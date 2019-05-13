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
package de.hybris.platform.processengine.synchronus;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.definition.ProcessDefinitionFactory;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.processengine.model.ProcessTaskLogModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;


@IntegrationTest
public class SynchLogsProcessEngineIntegrationTest extends AbstractProcessEngineIntegrationTest
{


	public static final String TEST_PROCESS = "test-proc";
	public static final String PROCESS_DEFINITION_NAME = "synchLogs";

	private final ClassPathResource processDefinition = new ClassPathResource("processengine/test/synch_logs.xml");

	@Resource
	private BusinessProcessService businessProcessService;

	@Resource
	private ModelService modelService;

	@Resource
	private ProcessDefinitionFactory processDefinitionFactory;

	@Before
	public void doBefore() throws IOException
	{
		canJoinPreviousNodeDefaultValue.switchToValue("false");
		final ConfigurableApplicationContext appCtx = (ConfigurableApplicationContext) Registry.getApplicationContext();
		processDefinitionFactory.add(processDefinition);
		final BusinessProcessModel bpm = modelService.create(BusinessProcessModel.class);
		bpm.setCode(TEST_PROCESS);
		bpm.setProcessDefinitionName(PROCESS_DEFINITION_NAME);
		modelService.saveAll();
	}

	@Before
	public void doAfter()
	{
		canJoinPreviousNodeDefaultValue.switchBackToDefault();
	}

	@Test
	public void shouldCreateLogsForSynchronousBusinessProcess() throws InterruptedException, TimeoutException
	{
		// given
		final BusinessProcessModel bpm = businessProcessService.getProcess(TEST_PROCESS);

		// when
		businessProcessService.startProcess(bpm);
		waitForBusinessProcess(bpm);

		// then
		final Collection<ProcessTaskLogModel> logs = bpm.getTaskLogs();
		assertThat(logs).hasSize(2);
		final Iterator<ProcessTaskLogModel> itLog = logs.iterator();

		final ProcessTaskLogModel logForFirstStep = itLog.next();
		final ProcessTaskLogModel logForSecondStep = itLog.next();
		assertThat(logForFirstStep.getReturnCode()).isEqualTo("OK");
		assertThat(logForFirstStep.getActionId()).isEqualTo("start");

		assertThat(logForSecondStep.getReturnCode()).isEqualTo("OK");
		assertThat(logForSecondStep.getActionId()).isEqualTo("secondStep");
	}



}
