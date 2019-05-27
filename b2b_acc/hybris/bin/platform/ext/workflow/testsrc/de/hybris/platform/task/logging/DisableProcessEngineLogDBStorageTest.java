/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.task.logging;


import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.action.AbstractProceduralAction;
import de.hybris.platform.processengine.definition.ProcessDefinitionsCache;
import de.hybris.platform.processengine.enums.ProcessState;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.processengine.model.DynamicProcessDefinitionModel;
import de.hybris.platform.processengine.model.ProcessTaskLogModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.task.utils.NeedsTaskEngine;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;


@IntegrationTest
@NeedsTaskEngine
public class DisableProcessEngineLogDBStorageTest extends ServicelayerBaseTest
{
	private static final int INITIAL_NUMBER_OF_NODES = 100;
	private static final String INITIAL_CONTENT = getProcessDefinition(INITIAL_NUMBER_OF_NODES);
	private static final String TEST_DEFINITION_CODE = "TEST_DEFINITION1";
	private static final String TEST_PROCESS_CODE = "TEST_PROCESS1";
	private static final String PROCEDURAL_ACTION_ID = "test.action";

	private String randomTestUUID;

	@Resource
	private BusinessProcessService businessProcessService;

	@Resource
	private ModelService modelService;

	@Resource
	private ProcessDefinitionsCache processDefinitionsCache;

	private final PropertyConfigSwitcher processEngineLogsDBStoreEnabled = new PropertyConfigSwitcher(
			"processengine.process.log.dbstore.enabled");

	@Before
	public void setUp()
	{
		final ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) Registry.getApplicationContext();
		final DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ctx.getBeanFactory();

		randomTestUUID = UUID.randomUUID().toString();

		beanFactory.registerBeanDefinition(PROCEDURAL_ACTION_ID,
				BeanDefinitionBuilder.rootBeanDefinition(RecordableProceduralAction.class).setScope("singleton")
						.addConstructorArgValue(randomTestUUID).getBeanDefinition());
	}

	@After
	public void tearDown()
	{
		final ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) Registry.getApplicationContext();
		final DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ctx.getBeanFactory();

		beanFactory.removeBeanDefinition(PROCEDURAL_ACTION_ID);

		randomTestUUID = null;
		processDefinitionsCache.clear();

		processEngineLogsDBStoreEnabled.switchBackToDefault();
	}

	@Test
	public void shouldStoreLogsInDBWithFlagSetToTrue() throws InterruptedException, TimeoutException
	{
		givenInitialProcessDefinition();
		processEngineLogsDBStoreEnabled.switchToValue(Boolean.TRUE.toString());

		final BusinessProcessModel businessProcess = whenProcessIsExecuted();

		assertThat(businessProcess.getTaskLogs()).isNotEmpty();
		assertThat(businessProcess.getTaskLogs()).extracting(ProcessTaskLogModel::getLogMessages)
				.filteredOn(s -> s.contains("FOO" + randomTestUUID)).isNotEmpty();
	}

	@Test
	public void shouldNotStoreLogsInDBWithFlagSetToFalse() throws InterruptedException, TimeoutException
	{
		givenInitialProcessDefinition();
		processEngineLogsDBStoreEnabled.switchToValue(Boolean.FALSE.toString());

		final BusinessProcessModel businessProcess = whenProcessIsExecuted();

		assertThat(businessProcess.getTaskLogs()).isEmpty();
	}

	private BusinessProcessModel whenProcessIsExecuted() throws TimeoutException, InterruptedException
	{
		final BusinessProcessModel businessProcess = businessProcessService.createProcess(TEST_PROCESS_CODE, TEST_DEFINITION_CODE);
		businessProcessService.startProcess(businessProcess);

		final Instant maxWaitTime = Instant.now().plus(Duration.ofMinutes(2));
		while (businessProcess.getState() == ProcessState.RUNNING)
		{
			if (Instant.now().isAfter(maxWaitTime))
			{
				throw new TimeoutException("Wait time exceeded for " + businessProcess.getCode());
			}
			Thread.sleep(50);
			modelService.refresh(businessProcess);
		}

		Thread.sleep(200);
		modelService.refresh(businessProcess);

		assertThat(businessProcess.getState()).isEqualTo(ProcessState.SUCCEEDED);
		return businessProcess;
	}


	private void givenInitialProcessDefinition()
	{
		final DynamicProcessDefinitionModel result = modelService.create(DynamicProcessDefinitionModel.class);
		result.setContent(INITIAL_CONTENT);
		result.setCode(TEST_DEFINITION_CODE);
		modelService.save(result);
	}

	private static String getProcessDefinition(final int n)
	{
		final StringBuilder result = new StringBuilder();
		result.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		result.append("<process xmlns=\"http://www.hybris.de/xsd/processdefinition\" start=\"action0\" name=\"")
				.append(TEST_DEFINITION_CODE).append("\">");
		for (int i = 0; i < (n - 1); i++)
		{
			result.append("   <action id=\"action").append(i).append("\" bean=\"test.action\">");
			result.append("      <transition name=\"OK\" to=\"action").append(i + 1).append("\"/>");
			result.append("   </action>");
		}
		result.append("   <action id=\"action").append(n - 1).append("\" bean=\"test.action\">");
		result.append("      <transition name=\"OK\" to=\"success\"/>");
		result.append("   </action>");
		result.append("   <end id=\"success\" state=\"SUCCEEDED\">Everything was fine</end>");
		result.append("</process>");
		return result.toString();
	}

	private static class RecordableProceduralAction extends AbstractProceduralAction<BusinessProcessModel>
	{
		public static final Logger LOG = LoggerFactory.getLogger(RecordableProceduralAction.class);

		private final String randomTestUUID;

		private final AtomicInteger counter = new AtomicInteger();

		private RecordableProceduralAction(final String randomTestUUID)
		{
			this.randomTestUUID = randomTestUUID;
		}

		@Override
		public void executeAction(final BusinessProcessModel process)
		{
			LOG.warn("FOO{} {}", randomTestUUID, counter.getAndIncrement());
		}
	}
}