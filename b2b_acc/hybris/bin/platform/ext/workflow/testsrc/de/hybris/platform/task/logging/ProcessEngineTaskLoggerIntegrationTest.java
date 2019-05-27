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

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
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
public class ProcessEngineTaskLoggerIntegrationTest extends ServicelayerBaseTest
{
	private static final int INITIAL_NUMBER_OF_NODES = 100;
	private static final String PROCEDURAL_ACTION_ID = "test.procedural.action";
	private static final String TEST_DEFINITION_CODE = "TEST_DEFINITION";
	private static final String TEST_PROCESS_CODE = RandomStringUtils.randomAlphanumeric(12);
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessEngineTaskLoggerIntegrationTest.class);

	@Resource
	private BusinessProcessService businessProcessService;

	@Resource
	private ModelService modelService;

	@Resource
	private ProcessDefinitionsCache processDefinitionsCache;
	private String processContent;

	@Before
	public void setUp()
	{
		registerProceduralActionBean(PROCEDURAL_ACTION_ID, RecordableProceduralAction.class);

		processContent = getProcessDefinition(INITIAL_NUMBER_OF_NODES, TEST_DEFINITION_CODE, PROCEDURAL_ACTION_ID);
	}

	private void registerProceduralActionBean(final String proceduralActionId,
			final Class<? extends AbstractProceduralAction<BusinessProcessModel>> beanClass)
	{
		final ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) Registry.getApplicationContext();
		final DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ctx.getBeanFactory();


		beanFactory.registerBeanDefinition(proceduralActionId,
				BeanDefinitionBuilder.rootBeanDefinition(beanClass).setScope("singleton").getBeanDefinition());
	}

	@After
	public void tearDown()
	{
		final ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) Registry.getApplicationContext();
		final DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ctx.getBeanFactory();

		beanFactory.removeBeanDefinition(PROCEDURAL_ACTION_ID);

		processDefinitionsCache.clear();
	}

	@Test
	public void shouldConsumeOnlyLogsGeneratedByProcessEngineTask() throws InterruptedException, TimeoutException
	{
		givenInitialProcessDefinition();

		final BusinessProcessModel businessProcess = businessProcessService.createProcess(TEST_PROCESS_CODE, TEST_DEFINITION_CODE);
		businessProcessService.startProcess(businessProcess);
		final String test = "TEST" + UUID.randomUUID().toString();

		final Instant maxWaitTime = Instant.now().plus(Duration.ofMinutes(2));
		while (businessProcess.getState() == ProcessState.RUNNING)
		{
			if (Instant.now().isAfter(maxWaitTime))
			{
				throw new TimeoutException("Wait time exceeded for " + businessProcess.getCode());
			}
			Thread.sleep(5);
			LOGGER.warn(test);
			modelService.refresh(businessProcess);
		}

		assertThat(businessProcess.getState()).isEqualTo(ProcessState.SUCCEEDED);
		assertThat(businessProcess.getTaskLogs()).isNotEmpty();
		assertThat(businessProcess.getTaskLogs()).extracting(ProcessTaskLogModel::getLogMessages).allMatch(s -> !s.contains(test));
	}


	private void givenInitialProcessDefinition()
	{
		final DynamicProcessDefinitionModel result = modelService.create(DynamicProcessDefinitionModel.class);
		result.setContent(processContent);
		result.setCode(TEST_DEFINITION_CODE);
		modelService.save(result);
	}

	private static String getProcessDefinition(final int n, final String testDefinitionCode, final String actionBeanName)
	{
		final StringBuilder result = new StringBuilder();
		result.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		result.append("<process xmlns=\"http://www.hybris.de/xsd/processdefinition\" start=\"action0\" name=\"")
				.append(testDefinitionCode).append("\">");
		for (int i = 0; i < (n - 1); i++)
		{
			result.append("   <action id=\"action").append(i).append("\" bean=\"").append(actionBeanName).append("\">");
			result.append("      <transition name=\"OK\" to=\"action").append(i + 1).append("\"/>");
			result.append("   </action>");
		}
		result.append("   <action id=\"action").append(n - 1).append("\" bean=\"").append(actionBeanName).append("\">");
		result.append("      <transition name=\"OK\" to=\"success\"/>");
		result.append("   </action>");
		result.append("   <end id=\"success\" state=\"SUCCEEDED\">Everything was fine</end>");
		result.append("</process>");
		return result.toString();
	}

	private static class RecordableProceduralAction extends AbstractProceduralAction<BusinessProcessModel>
	{
		public static final Logger LOG = LoggerFactory.getLogger(RecordableProceduralAction.class);


		@Override
		public void executeAction(final BusinessProcessModel process)
		{
			LOG.warn("FOO");
		}
	}
}