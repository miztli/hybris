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
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.definition.ProcessDefinitionFactory;
import de.hybris.platform.processengine.helpers.ActionThreadTransactionTracker;
import de.hybris.platform.processengine.impl.BusinessProcessServiceDao;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.tx.Transaction;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.ClassPathResource;


@IntegrationTest
public class SynchProcessEngineIntegrationTest extends AbstractProcessEngineIntegrationTest
{
	public static final String TEST_PROCESS = "test-proc";
	public static final String PROCESS_DEFINITION_NAME = "synchTestProces";
	public static final String TEST_ACTION_BEAN = "TestActionBean";

	private final ClassPathResource processDefinition = new ClassPathResource("processengine/test/synch.xml");

	@Resource
	private BusinessProcessService businessProcessService;

	@Resource
	private ModelService modelService;

	@Resource
	private ProcessDefinitionFactory processDefinitionFactory;


	private DefaultListableBeanFactory beanFactory;

	private ActionThreadTransactionTracker tracker;

	@Resource
	private BusinessProcessServiceDao businessProcessServiceDao;

	private static Context context;


	@Before
	public void doBefore() throws IOException
	{
		canJoinPreviousNodeDefaultValue.switchToValue("false");
		context = new Context();
		processDefinitionFactory.add(processDefinition);
		final BusinessProcessModel bpm = modelService.create(BusinessProcessModel.class);
		bpm.setCode(TEST_PROCESS);
		bpm.setProcessDefinitionName(PROCESS_DEFINITION_NAME);
		modelService.saveAll();
		initTracks();
	}


	private void initTracks()
	{
		tracker = new ActionThreadTransactionTracker();
		tracker.addSynchroGroup("GR_1_SYNCH", "start", "secondStep");
		tracker.addSynchroGroup("GR_2_SYNCH", "thirdStep", "thourdStep", "fifthStep");
		tracker.addAsynchroGroup("GR_3_ASYNCH", "secondStep", "thirdStep");
		tracker.addAsynchroGroup("GR_4_ASYNCH", "fifthStep", "sixthStep");

	}

	@After
	public void doAfter()
	{
		canJoinPreviousNodeDefaultValue.switchBackToDefault();
	}

	@Test
	public void testSynchroProcess() throws InterruptedException, TimeoutException
	{
		// given
		final BusinessProcessModel bpm = businessProcessService.getProcess(TEST_PROCESS);

		// when
		businessProcessService.startProcess(bpm);
		waitForBusinessProcess(bpm);

		//then
		assertThat(tracker.isThreadError("GR_1_SYNCH")).isFalse();
		assertThat(tracker.isTransactionError("GR_1_SYNCH")).isFalse();

		assertThat(tracker.isThreadError("GR_2_SYNCH")).isFalse();
		assertThat(tracker.isTransactionError("GR_2_SYNCH")).isFalse();

		assertThat(tracker.isThreadError("GR_3_ASYNCH")).isFalse();
		assertThat(tracker.isTransactionError("GR_3_ASYNCH")).isFalse();

		assertThat(tracker.isThreadError("GR_4_ASYNCH")).isFalse();
		assertThat(tracker.isTransactionError("GR_4_ASYNCH")).isFalse();

	}

	public static Context getContext()
	{
		return context;
	}


	private class Context
	{

		public void action(final String action)
		{
			tracker.trackThreadAndTransactionForAction(action, Thread.currentThread().getId(), Transaction.current().getObjectID());
		}
	}
}

