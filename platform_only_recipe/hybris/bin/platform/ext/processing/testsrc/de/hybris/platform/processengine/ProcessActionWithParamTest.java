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
package de.hybris.platform.processengine;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.processengine.actionstrategy.TriggeredProcessAction;
import de.hybris.platform.processengine.definition.ActionDefinitionContext;
import de.hybris.platform.processengine.definition.ProcessDefinitionFactory;
import de.hybris.platform.processengine.definition.ProcessDefinitionId;
import de.hybris.platform.processengine.enums.ProcessState;
import de.hybris.platform.processengine.helpers.ProcessDefinitionBuilder;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.scripting.enums.ScriptType;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.action.ActionService;
import de.hybris.platform.servicelayer.enums.ActionType;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.model.action.AbstractActionModel;
import de.hybris.platform.servicelayer.model.action.SimpleActionModel;
import de.hybris.platform.task.RetryLaterException;
import de.hybris.platform.util.Config;

import java.io.StringReader;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.support.AbstractApplicationContext;
import org.xml.sax.InputSource;


@IntegrationTest
public class ProcessActionWithParamTest extends ServicelayerBaseTest
{
	private static final String PROCESS_DEFINITION_NAME_OK = "testParameterProcessOK";
	private static final String PROCESS_DEFINITION_NAME_SCRIPT = "testParameterProcessScript";
	private static final String PROCESS_DEFINITION_NAME_ACTION_SCRIPT_COMBO = "testParameterProcessActionAndScript";
	private static final String ACTION_BEAN = "testParameterAction";
	private static final String PARAM_OK = "OK";
	private static final String PARAM_NOK = "NOK";
	private static final String START_NODE = "start";
	private static final String PARAMETER_NAME = "goto";
	private static final String TEST_SCRIPT = "actionDefinitionContext.parameters['" + PARAMETER_NAME + "']";
	private static final String SUCCESS = "success";
	private static final String FAIL_MESSAGE = "process didn't run or had different status then ";
	private static final String END_MSG = "ending";
	private static final String WORKS = "works";
	private static final String ERROR = "error";

	@Resource
	private ModelService modelService;
	@Resource
	private ActionService actionService;
	@Resource
	private ProcessDefinitionFactory processDefinitionFactory;

	private TestParameterAction testParameterAction;
	private final double timeFactor = Config.getDouble("platform.test.timefactor", 1.0);


	@Before
	public void setUp()
	{
		this.testParameterAction = new TestParameterAction();
		SingletonBeanRegistry registry =
				((AbstractApplicationContext) getApplicationContext()).getBeanFactory();
		registry.registerSingleton(ACTION_BEAN, this.testParameterAction);

		this.processDefinitionFactory
				.add(new InputSource(new StringReader(ProcessDefinitionBuilder.builder(PROCESS_DEFINITION_NAME_OK, START_NODE)
						.withActionNode(START_NODE, ACTION_BEAN)
						.withParameter(PARAMETER_NAME, PARAM_OK)
						.withTransition(PARAM_OK, SUCCESS)
						.withTransition(PARAM_NOK, ERROR)
						.addEndNode(SUCCESS, ProcessState.SUCCEEDED, END_MSG)
						.addEndNode(ERROR, ProcessState.ERROR, ERROR)
						.build())));

		this.processDefinitionFactory.add(new InputSource(new StringReader(ProcessDefinitionBuilder
				.builder(PROCESS_DEFINITION_NAME_SCRIPT, START_NODE)
				.withScriptActionNode(START_NODE)
				.withScript(ScriptType.JAVASCRIPT, TEST_SCRIPT)
				.withParameter(PARAMETER_NAME, WORKS)
				.withTransition(WORKS, SUCCESS)
				.addEndNode(ERROR, ProcessState.ERROR, ERROR)
				.addEndNode(SUCCESS, ProcessState.SUCCEEDED, SUCCESS)
				.build())));

		String goTo = "goScript";
		this.processDefinitionFactory.add(new InputSource(new StringReader(ProcessDefinitionBuilder
				.builder(PROCESS_DEFINITION_NAME_ACTION_SCRIPT_COMBO, START_NODE)
				.withActionNode(START_NODE, ACTION_BEAN)
				.withParameter(PARAMETER_NAME, PARAM_OK)
				.withTransition(PARAM_OK, goTo)
				.withTransition(PARAM_NOK, ERROR)
				.withScriptActionNode(goTo)
				.withScript(ScriptType.JAVASCRIPT, TEST_SCRIPT)
				.withParameter(PARAMETER_NAME, WORKS)
				.withTransition(WORKS, SUCCESS)
				.addEndNode(ERROR, ProcessState.ERROR, ERROR)
				.addEndNode(SUCCESS, ProcessState.SUCCEEDED, SUCCESS)
				.build())));
	}

	@After
	public void tearDown()
	{
		this.processDefinitionFactory.remove(new ProcessDefinitionId(PROCESS_DEFINITION_NAME_OK));
		this.processDefinitionFactory.remove(new ProcessDefinitionId(PROCESS_DEFINITION_NAME_ACTION_SCRIPT_COMBO));
		this.processDefinitionFactory.remove(new ProcessDefinitionId(PROCESS_DEFINITION_NAME_SCRIPT));

		((DefaultSingletonBeanRegistry) ((AbstractApplicationContext) getApplicationContext()).getBeanFactory())
				.destroySingleton(ACTION_BEAN);

		this.testParameterAction = null;
	}

	@Test
	public void shouldPassTestActionNodeWithDefinedParameters() throws InterruptedException
	{
		assertThat(processDefinitionFactory.getProcessDefinition(new ProcessDefinitionId(PROCESS_DEFINITION_NAME_OK))).isNotNull();
		assertThat(testParameterAction).isNotNull();
		assertThat(testParameterAction.getActionDefinitionContext()).isNull();

		BusinessProcessModel processModel = triggerAction(PROCESS_DEFINITION_NAME_OK);

		assertThat(testParameterAction.getActionDefinitionContext()).isNotNull();
		assertThat(testParameterAction.getCurrentActionDefinitionContext()).isNull();
		assertThat(testParameterAction.getActionDefinitionContext().getParameter(PARAMETER_NAME)).isEqualTo(Optional.of(PARAM_OK));
		assertThat(processModel.getEndMessage())
				.isEqualTo(END_MSG);
	}

	@Test
	public void shouldPassTestScriptActionExecutionWithParameters() throws InterruptedException
	{
		testForProcessDef(PROCESS_DEFINITION_NAME_SCRIPT);
	}

	@Test
	public void shouldPassTestActionToScriptFlowExecutionWithParameters() throws InterruptedException
	{
		testForProcessDef(PROCESS_DEFINITION_NAME_ACTION_SCRIPT_COMBO);
	}

	private BusinessProcessModel triggerAction(String processName) throws InterruptedException
	{
		final AbstractActionModel actionModel = new SimpleActionModel();
		actionModel.setCode("action1");
		actionModel.setType(ActionType.PROCESS);
		actionModel.setTarget(processName);
		modelService.save(actionModel);

		TriggeredProcessAction<String> preparedAction =
				(TriggeredProcessAction<String>) actionService.prepareAction(actionModel, "TestAction1");
		BusinessProcessModel processModel = preparedAction.getProcess();

		actionService.triggerAction(preparedAction);

		assertThat(waitForProcessStatus(processModel, ProcessState.SUCCEEDED, 40 * 1000))
				.isTrue()
				.withFailMessage(FAIL_MESSAGE + ProcessState.SUCCEEDED);
		return processModel;
	}

	private void testForProcessDef(String processDefinitionName) throws InterruptedException
	{
		BusinessProcessModel processModel = triggerAction(processDefinitionName);
		assertThat(processModel.getEndMessage())
				.isEqualTo(SUCCESS);
	}

	private boolean waitForProcessStatus(final BusinessProcessModel processModel, ProcessState state, final long maxWait)
			throws InterruptedException
	{
		final long t1 = System.currentTimeMillis();
		boolean done = false;
		do
		{
			Thread.sleep((long) (200 * timeFactor));
			modelService.refresh(processModel);
			done = processModel.getState() == ProcessState.SUCCEEDED || processModel.getState() == ProcessState.ERROR
					|| processModel.getState() == ProcessState.FAILED;
		}
		while (!done && (System.currentTimeMillis() - t1) < maxWait * timeFactor);

		return processModel.getState() == state;
	}

	class TestParameterAction extends AbstractSimpleDecisionAction<BusinessProcessModel>
	{
		private ActionDefinitionContext actionDefinitionContext = null;

		@Override
		public Transition executeAction(BusinessProcessModel process)
				throws RetryLaterException, Exception
		{
			this.actionDefinitionContext = this.getCurrentActionDefinitionContext();
			return this.actionDefinitionContext
					.getParameter(PARAMETER_NAME)
					.map(Transition::valueOf).orElseThrow(() -> new NoSuchElementException(""));
		}

		ActionDefinitionContext getActionDefinitionContext()
		{
			return this.actionDefinitionContext;
		}

		void resetActionDefinitionContext()
		{
			this.actionDefinitionContext = null;
		}
	}

}
