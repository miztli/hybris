/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.processengine;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.processengine.definition.ProcessDefinitionFactory;
import de.hybris.platform.processengine.enums.ProcessState;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.processengine.synchronus.AbstractProcessEngineIntegrationTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

@IntegrationTest
public class MultipleProcessesWithCycleTest extends AbstractProcessEngineIntegrationTest
{
	public static final String PARENT_PROCESS = "test-parent-process";
	public static final String CHILD_PROCESS = "test-child-process";
	public static final String PARENT_PROCESS_DEFINITION_NAME = "multipleProcessesParent";
	public static final String CHILD_PROCESS_DEFINITION_NAME = "multipleProcessesChild";
	public static final String PARENT_ACTION_EVENT_NAME = "ActionEvent";

	private final ClassPathResource parentProcessDefinition = new ClassPathResource(
			"processengine/test/multipleProcessesParent.xml");
	private final ClassPathResource childProcessDefinition = new ClassPathResource(
			"processengine/test/multipleProcessesChild.xml");

	@Resource
	private BusinessProcessService businessProcessService;

	@Resource
	private ModelService modelService;

	@Resource
	private ProcessDefinitionFactory processDefinitionFactory;

	@Before
	public void doBefore() throws IOException
	{
		canJoinPreviousNodeDefaultValue.switchToValue("true");
		processDefinitionFactory.add(parentProcessDefinition);
		processDefinitionFactory.add(childProcessDefinition);
		final BusinessProcessModel parentProcessModel = modelService.create(BusinessProcessModel.class);
		parentProcessModel.setCode(PARENT_PROCESS);
		parentProcessModel.setProcessDefinitionName(PARENT_PROCESS_DEFINITION_NAME);
		final BusinessProcessModel childProcessModel = modelService.create(BusinessProcessModel.class);
		childProcessModel.setCode(CHILD_PROCESS);
		childProcessModel.setProcessDefinitionName(CHILD_PROCESS_DEFINITION_NAME);
		modelService.saveAll();
	}

	@Before
	public void doAfter()
	{
		canJoinPreviousNodeDefaultValue.switchBackToDefault();
	}

	@Test
	public void testMultipleProcesses() throws TimeoutException
	{
		// given
		final BusinessProcessModel parentProcessModel = businessProcessService.getProcess(PARENT_PROCESS);
		final BusinessProcessModel childProcessModel = businessProcessService.getProcess(CHILD_PROCESS);

		// when
		businessProcessService.startProcess(parentProcessModel);
		businessProcessService.startProcess(childProcessModel);

		// then
		sendParentProcessCancellation();

		waitForBusinessProcess(parentProcessModel);
		waitForBusinessProcess(childProcessModel);
		modelService.refresh(parentProcessModel);
		modelService.refresh(childProcessModel);

		assertThat(parentProcessModel.getState()).isEqualTo(ProcessState.SUCCEEDED);
		assertThat(childProcessModel.getState()).isEqualTo(ProcessState.SUCCEEDED);
	}

	public void sendParentProcessCancellation()
	{
		final BusinessProcessEvent event = BusinessProcessEvent.builder(PARENT_PROCESS + "_" + PARENT_ACTION_EVENT_NAME)
				.withChoice("cancelParentProcess").build();
		businessProcessService.triggerEvent(event);
	}

	public static void cancelChildProcess() //executed from business action via groovy
	{
		final BusinessProcessEvent event = BusinessProcessEvent.builder(CHILD_PROCESS + "_" + "EndChildProcess")
				.withChoice("cancelChildProcess").build();
		final BusinessProcessService businessProcessService = Registry.getApplicationContext()
				.getBean("businessProcessService", BusinessProcessService.class);
		businessProcessService.triggerEvent(event);
	}

	public static void sleep1000() throws InterruptedException //executed from business action via groovy
	{
		Thread.sleep(1000);
	}

	public static void confirmChildProcessCancellation() //executed from business action via groovy
	{
		final BusinessProcessEvent event = BusinessProcessEvent.builder(PARENT_PROCESS + "_" + PARENT_ACTION_EVENT_NAME)
				.withChoice("childProcessEnded").build();
		final BusinessProcessService businessProcessService = Registry.getApplicationContext()
				.getBean("businessProcessService", BusinessProcessService.class);
		businessProcessService.triggerEvent(event);
	}
}
