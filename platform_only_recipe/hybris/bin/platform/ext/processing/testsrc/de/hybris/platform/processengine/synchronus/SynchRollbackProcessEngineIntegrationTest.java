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
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.action.AbstractProceduralAction;
import de.hybris.platform.processengine.definition.ProcessDefinitionFactory;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.processengine.process.ProcessEngineIntegrationTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;


@IntegrationTest
public class SynchRollbackProcessEngineIntegrationTest extends AbstractProcessEngineIntegrationTest
{
	private static final Logger LOG = Logger.getLogger(ProcessEngineIntegrationTest.class);

	public static final String TEST_PROCESS = "test-proc";
	public static final String PROCESS_DEFINITION_NAME = "synchFailTestProces";

	public static final String TEST_ACTION_BEAN = "TestActionBean";
	public static final String EXCEPTION_ACTION_BEAN = "ExceptionActionBean";
	public static final String TEST_USER = "Tom";

	private static final String NEW_TITLE_MODEL_NAME = "NewName";
	private final ClassPathResource processDefinition = new ClassPathResource("processengine/test/synch_fail.xml");

	@Resource
	private BusinessProcessService businessProcessService;

	@Resource
	private ProcessDefinitionFactory processDefinitionFactory;

	@Resource
	private UserService userService;

	private TestCustomUserAction testActionBean;

	private DefaultListableBeanFactory beanFactory;

	private TitleModel titleModel = new TitleModel();

	@Before
	public void doBefore() throws IOException
	{
		canJoinPreviousNodeDefaultValue.switchToValue("false");

		final ConfigurableApplicationContext appCtx = (ConfigurableApplicationContext) Registry.getApplicationContext();
		beanFactory = (DefaultListableBeanFactory) appCtx.getBeanFactory();

		titleModel = modelService.create(TitleModel.class);
		titleModel.setCode(UUID.randomUUID().toString());
		titleModel.setName("0");
		modelService.save(titleModel);

		testActionBean = new TestCustomUserAction(modelService, titleModel);
		beanFactory.registerSingleton(TEST_ACTION_BEAN, testActionBean);

		final ExceptionActionBean exceptionBean = new ExceptionActionBean(modelService, titleModel);
		beanFactory.registerSingleton(EXCEPTION_ACTION_BEAN, exceptionBean);

		processDefinitionFactory.add(processDefinition);

		final BusinessProcessModel bpm = modelService.create(BusinessProcessModel.class);

		bpm.setCode(TEST_PROCESS);
		bpm.setProcessDefinitionName(PROCESS_DEFINITION_NAME);

		final UserModel tomUser = modelService.create(UserModel.class);
		tomUser.setUid(TEST_USER);

		modelService.saveAll();
	}

	@After
	public void doAfter()
	{
		canJoinPreviousNodeDefaultValue.switchBackToDefault();
		beanFactory.destroySingleton(TEST_ACTION_BEAN);
		beanFactory.destroySingleton(EXCEPTION_ACTION_BEAN);
	}

	@Test
	public void shuldStoreDataFromFirstAsynchActionAndRollbackForSynchAction() throws InterruptedException, TimeoutException
	{
		// given
		final BusinessProcessModel bpm = businessProcessService.getProcess(TEST_PROCESS);
		bpm.setUser(userService.getUserForUID(TEST_USER));

		// when
		businessProcessService.startProcess(bpm);
		waitForBusinessProcess(bpm);

		// then
		final TitleModel tModel = modelService.get(titleModel.getPk());
		assertThat(tModel.getName()).isEqualTo(NEW_TITLE_MODEL_NAME);

	}


	public class TestCustomUserAction extends AbstractProceduralAction
	{
		private final ModelService modelService;

		public TestCustomUserAction(final ModelService modelService, final TitleModel titleModel)
		{
			this.modelService = modelService;
		}

		@Override
		public void executeAction(final BusinessProcessModel process) throws Exception
		{
			modelService.refresh(titleModel);
			titleModel.setName(NEW_TITLE_MODEL_NAME);
			modelService.save(titleModel);
		}

	}

	public class ExceptionActionBean extends AbstractProceduralAction
	{

		ModelService modelService;
		TitleModel titleModel;

		public ExceptionActionBean(final ModelService mService, final TitleModel titleModel)
		{
			this.modelService = mService;
			this.titleModel = titleModel;
		}

		@Override
		public void executeAction(final BusinessProcessModel process) throws Exception
		{
			modelService.refresh(titleModel);
			titleModel.setName("BadName");
			modelService.save(titleModel);
			throw new IllegalStateException("Exception during executeAction");
		}
	}

}

