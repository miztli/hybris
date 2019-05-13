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
import de.hybris.platform.processengine.action.AbstractProceduralAction;
import de.hybris.platform.processengine.definition.ProcessDefinitionFactory;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.task.RetryLaterException;
import de.hybris.platform.task.RetryLaterException.Method;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;


@IntegrationTest
public class SynchRetryProcessEngineIntegrationTest extends AbstractProcessEngineIntegrationTest
{
	public static final String TEST_PROCESS = "test-proc";
	public static final String PROCESS_DEFINITION_NAME = "synchFailTestProces";

	public static final String TEST_ACTION_BEAN = "TestActionBean";
	public static final String RETRY_ACTION_BEAN = "RetryBean";

	private final ClassPathResource processDefinition = new ClassPathResource("processengine/test/synch_retry.xml");

	@Resource
	private BusinessProcessService businessProcessService;

	@Resource
	private ModelService modelService;

	@Resource
	private ProcessDefinitionFactory processDefinitionFactory;

	private TestCustomUserAction testActionBean;
	private RetryActionBean retryActionBean;

	private DefaultListableBeanFactory beanFactory;

	@Before
	public void doBefore() throws IOException
	{
		canJoinPreviousNodeDefaultValue.switchToValue("false");
		final ConfigurableApplicationContext appCtx = (ConfigurableApplicationContext) Registry.getApplicationContext();
		beanFactory = (DefaultListableBeanFactory) appCtx.getBeanFactory();

		testActionBean = new TestCustomUserAction();
		beanFactory.registerSingleton(TEST_ACTION_BEAN, testActionBean);

		retryActionBean = new RetryActionBean();
		beanFactory.registerSingleton(RETRY_ACTION_BEAN, retryActionBean);

		processDefinitionFactory.add(processDefinition);

		final BusinessProcessModel bpm = modelService.create(BusinessProcessModel.class);

		bpm.setCode(TEST_PROCESS);
		bpm.setProcessDefinitionName(PROCESS_DEFINITION_NAME);
		modelService.saveAll();
	}

	@After
	public void doAfter()
	{
		canJoinPreviousNodeDefaultValue.switchBackToDefault();
		beanFactory.destroySingleton(TEST_ACTION_BEAN);
		beanFactory.destroySingleton(RETRY_ACTION_BEAN);
	}


	@Test
	public void shouldRetrySecondSynchronusProcess() throws InterruptedException, TimeoutException
	{
		// given
		final BusinessProcessModel bpm = businessProcessService.getProcess(TEST_PROCESS);

		// when
		businessProcessService.startProcess(bpm);
		waitForBusinessProcess(bpm);

		// then
		assertThat(testActionBean.getMethodExecuteCalls()).isEqualTo(1);
		assertThat(retryActionBean.getMethodExecuteCalls()).isEqualTo(2);
	}

	public class TestCustomUserAction extends AbstractProceduralAction
	{

		int methodExecuteCalls = 0;

		@Override
		public void executeAction(final BusinessProcessModel process) throws Exception
		{
			methodExecuteCalls++;
		}

		public int getMethodExecuteCalls()
		{
			return methodExecuteCalls;
		}
	}

	public static class RetryActionBean extends AbstractProceduralAction
	{
		private int methodExecuteCalls = 0;
		private static boolean firstRetry = false;

		@Override
		public void executeAction(final BusinessProcessModel process) throws RetryLaterException, Exception
		{
			methodExecuteCalls++;
			if (!firstRetry)
			{
				final RetryLaterException retryLater = new RetryLaterException();
				retryLater.setDelay(1000);
				retryLater.setMethod(Method.EXACT_DATE);
				firstRetry = true;
				throw retryLater;
			}
		}

		public int getMethodExecuteCalls()
		{
			return methodExecuteCalls;
		}

	}
}

