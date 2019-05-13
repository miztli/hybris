/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.task.impl;
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

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cronjob.model.TriggerModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.cronjob.TriggerService;
import de.hybris.platform.servicelayer.internal.model.ScriptingJobModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.task.RetryLaterException;
import de.hybris.platform.task.TaskModel;
import de.hybris.platform.task.TaskRunner;
import de.hybris.platform.task.TaskService;
import de.hybris.platform.task.TestTaskRunner;
import de.hybris.platform.task.action.TriggerTaskRunner;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.retry.support.RetryTemplate;

import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.Lists;


public class TriggerTaskRunnerRetriesHandlingTest extends ServicelayerBaseTest
{

	private static final int DEFAULT_SHUTDOWN_WAIT = 15;
	@Resource
	protected ModelService modelService;
	@Resource
	protected FlexibleSearchService flexibleSearchService;
	@Resource
	protected TaskService taskService;
	@Resource
	protected TypeService typeService;
	@Resource
	protected MetricRegistry metricRegistry;
	@Resource
	protected RetryTemplate taskEngineRetryTemplate;

	private CountDownLatch countDownLatch;
	private CountDownLatch handledRetriesLatch;
	private boolean taskEngineWasRunningBefore;

	private TriggerTaskRunner testTaskRunner;
	private final PropertyConfigSwitcher triggerRetryIntervalSeconds = new PropertyConfigSwitcher(
			"taskRunner.trigger.retry.interval.seconds");

	private final PropertyConfigSwitcher triggerRetryMaxAttempts = new PropertyConfigSwitcher(
			"taskRunner.trigger.retry.maxattempts");

	@Before
	public void setUp()
	{
		if (taskService.getEngine().isRunning())
		{
			taskEngineWasRunningBefore = true;
			taskService.getEngine().stop();
		}
	}

	@After
	public void tearDown()
	{
		triggerRetryIntervalSeconds.switchBackToDefault();
		triggerRetryMaxAttempts.switchBackToDefault();

		if (taskEngineWasRunningBefore)
		{
			taskService.getEngine().start();
		}
	}

	@Test
	public void shouldRetryTaskAndNotRemoveThem() throws Exception
	{
		assureTaskEngineStopped();
		//given
		final int maxAttemts = 3;
		triggerRetryIntervalSeconds.switchToValue("2");
		triggerRetryMaxAttempts.switchToValue(String.valueOf(maxAttemts));
		initializeTaskRunnerWhichThrowingException();

		final TriggerModel trigger = createTrigger("group_a");
		final TaskModel triggerTask = findTaskForTrigger(trigger);
		final Collection<Long> relevantTasks = Lists.newArrayList(triggerTask.getPk().getLong());

		countDownLatch = new CountDownLatch(relevantTasks.size());
		handledRetriesLatch = new CountDownLatch(maxAttemts);
		final TestTaskService serviceA = new TestTaskService(0, Lists.newArrayList("group_a"), relevantTasks);

		try
		{
			//when
			serviceA.getEngine().start();
			//then
			assertThat(countDownLatch.await(30, TimeUnit.SECONDS)).isTrue();
			assertThat(serviceA.getExecutedTasks()).contains(triggerTask.getPk().getLong());
			final List<Long> allExecutedTasks = Lists.newArrayList(serviceA.getExecutedTasks());
			assertThat(allExecutedTasks).containsOnlyOnce(relevantTasks.toArray(new Long[relevantTasks.size()]));
			assertThat(handledRetriesLatch.await(30, TimeUnit.SECONDS)).isTrue();
			Thread.currentThread().sleep(5 * 1000);
			assertThat(modelService.isRemoved(triggerTask)).isFalse();
			assertThat(triggerTask.getRetry()).isEqualTo(maxAttemts);
		}
		finally
		{
			serviceA.getEngine().stop();
		}
	}

	@Test
	public void shouldRetryTasksWithDefaultMaxAttempts() throws Exception
	{
		assureTaskEngineStopped();
		//given
		triggerRetryIntervalSeconds.switchToValue("2");
		initializeTaskWhichThrowingExceptionAfterRecalculation();
		final int maxAttempts = 10;
		final TriggerModel trigger = createTrigger("group_a");
		final TaskModel triggerTask = findTaskForTrigger(trigger);
		final Collection<Long> relevantTasks = Lists.newArrayList(triggerTask.getPk().getLong());

		countDownLatch = new CountDownLatch(relevantTasks.size());
		handledRetriesLatch = new CountDownLatch(maxAttempts);
		final TestTaskService serviceA = new TestTaskService(0, Lists.newArrayList("group_a"), relevantTasks);

		try
		{
			//when
			serviceA.getEngine().start();
			//then
			assertThat(countDownLatch.await(30, TimeUnit.SECONDS)).isTrue();
			assertThat(serviceA.getExecutedTasks()).contains(triggerTask.getPk().getLong());
			final List<Long> allExecutedTasks = Lists.newArrayList(serviceA.getExecutedTasks());
			assertThat(allExecutedTasks).containsOnlyOnce(relevantTasks.toArray(new Long[relevantTasks.size()]));
			assertThat(handledRetriesLatch.await(30, TimeUnit.SECONDS)).isTrue();
			Thread.currentThread().sleep(5 * 1000);
			assertThat(modelService.isRemoved(triggerTask)).isFalse();
			assertThat(triggerTask.getRetry()).isEqualTo(maxAttempts);
		}
		finally
		{
			serviceA.getEngine().stop();
		}
	}

	private void initializeTaskRunnerWhichThrowingException()
	{
		testTaskRunner = new TriggerTaskRunner();
		final TriggerService triggerService = Mockito.mock(TriggerService.class);
		Mockito.doThrow(createRuntimeEx()) //
				.doThrow(createRuntimeEx()) //
				.doThrow(createRuntimeEx()) //
				.doAnswer(recaluclateActivationTimeAndThenThrowException()) //
				.when(triggerService).activate(Mockito.any());
		testTaskRunner.setTriggerService(triggerService);
		testTaskRunner.setModelService(modelService);
	}


	private void initializeTaskWhichThrowingExceptionAfterRecalculation()
	{
		testTaskRunner = new TriggerTaskRunner();
		final TriggerService triggerService = Mockito.mock(TriggerService.class);
		Mockito.doAnswer(recaluclateActivationTimeAndThenThrowException()) //
				.when(triggerService).activate(Mockito.any());
		testTaskRunner.setTriggerService(triggerService);
		testTaskRunner.setModelService(modelService);
	}

	private RuntimeException createRuntimeEx()
	{
		return new RuntimeException("RuntimeException during activate");
	}

	private Answer recaluclateActivationTimeAndThenThrowException()
	{
		final Answer answer = new Answer()
		{
			public Void answer(final InvocationOnMock invocation) throws Throwable
			{
				final TriggerModel triggerModel = invocation.getArgumentAt(0, TriggerModel.class);
				triggerModel.setActivationTime(new Date(System.currentTimeMillis() + 1000));
				modelService.save(triggerModel);
				throw new RuntimeException("Throwing runtime after date recalculation");
			}
		};
		return answer;
	}

	private TaskModel findTaskForTrigger(final TriggerModel trigger)
	{
		final SearchResult<TaskModel> searchResult = flexibleSearchService
				.search("SELECT {PK} from {TriggerTask} WHERE {trigger}=" + trigger.getPk());
		assertThat(searchResult).isNotNull();
		return searchResult.getResult().get(0);
	}

	private TriggerModel createTrigger(final String group)
	{

		final ScriptingJobModel testJob = modelService.create(ScriptingJobModel.class);
		testJob.setCode("testJob");
		testJob.setScriptURI("model://anyScript");

		final CronJobModel testCronjob = modelService.create(CronJobModel.class);
		testCronjob.setCode("testCronJob");
		testCronjob.setJob(testJob);

		final TriggerModel tm = modelService.create(TriggerModel.class);
		tm.setCronJob(testCronjob);

		modelService.save(tm);
		return tm;
	}

	private TasksProvider getTasksProvider()
	{
		final DefaultTasksProvider tasksProvider = new DefaultTasksProvider();
		tasksProvider.setMetricRegistry(metricRegistry);
		tasksProvider.setTypeService(typeService);
		tasksProvider.setFlexibleSearchService(flexibleSearchService);
		tasksProvider.afterPropertiesSet();
		return tasksProvider;
	}

	public class TestTaskService extends DefaultTaskService
	{

		private final int nodeId;
		private final Collection<String> nodeGroups;
		private final TestExecutionStrategy testExecutionStrategy;

		public TestTaskService(final int nodeId, final Collection<String> nodeGroups, final Collection<Long> relevantTasks)
		{
			this.nodeId = nodeId;
			this.nodeGroups = nodeGroups;
			this.testExecutionStrategy = new TestExecutionStrategy(relevantTasks);
			this.setTaskEngineRetryTemplate(taskEngineRetryTemplate);

			this.setModelService(modelService);
			this.setMetricRegistry(metricRegistry);
			this.setTaskExecutionStrategies(Lists.newArrayList(testExecutionStrategy));
			this.setTasksProvider(getTasksProvider());
			this.setTaskDao(new TaskDAO(getTenant())
			{
				@Override
				protected int initializeClusterId()
				{
					return nodeId;
				}
			});
		}

		@Override
		protected TaskExecutionStrategy getExecutionStrategy(final TaskRunner<? extends TaskModel> runner)
		{
			return testExecutionStrategy;
		}

		@Override
		protected TaskRunner getRunner(final String runnerBean) throws IllegalStateException
		{
			return testTaskRunner;
		}

		@Override
		Collection<String> getClusterGroupsForThisNode()
		{
			return nodeGroups;
		}

		@Override
		int getClusterNodeID()
		{
			return nodeId;
		}

		@Override
		public void setModelService(final ModelService modelService)
		{
			this.testExecutionStrategy.setModelService(modelService);
			super.setModelService(modelService);
		}

		@Override
		void scheduleTaskForExecution(final TasksProvider.VersionPK versionedPK)
		{
			super.scheduleTaskForExecution(versionedPK);
		}

		public Collection<Long> getExecutedTasks()
		{
			return testExecutionStrategy.getExecutedTasks();
		}

		public Collection<Long> getFailedTasks()
		{
			return testExecutionStrategy.getFailedTasks();
		}

		@Override
		protected TaskEngineParameters getTaskProviderParameters()
		{
			return new TaskEngineParameters.ParametersBuilder().withMaxThreads(1).withClusterNodeID(getClusterNodeID())
					.withTenant(getTenant()).withProcessTriggerTask(true).withExclusiveMode(false)
					.withClusterGroupsForThisNode(getClusterGroupsForThisNode()).build();
		}

	}

	class TestExecutionStrategy extends TriggerTaskExecutionStrategy
	{

		private final Collection<Long> relevantTasks;
		private final Collection<Long> executedTasks = Collections.synchronizedList(new ArrayList<Long>());
		private final Collection<Long> failedTasks = Collections.synchronizedList(new ArrayList<Long>());

		private final Collection<Long> handledRetryTasks = Collections.synchronizedList(new ArrayList<Long>());


		public TestExecutionStrategy(final Collection<Long> relevantTasks)
		{
			this.relevantTasks = relevantTasks;
		}

		@Override
		public void run(final TaskService taskService, final TaskRunner<TaskModel> runner, final TaskModel model)
				throws RetryLaterException
		{
			final Long pk = model.getPk().getLong();
			if (relevantTasks.contains(pk))
			{
				executedTasks.add(pk);
				countDownLatch.countDown();
			}
			super.run(taskService, runner, model);
		}


		@Override
		public Date handleRetry(final TaskService taskService, final TaskRunner<TaskModel> runner, final TaskModel model,
				final RetryLaterException retry, final int currentRetries)
		{
			final Long pk = model.getPk().getLong();
			if (relevantTasks.contains(pk))
			{
				handledRetriesLatch.countDown();
			}
			return super.handleRetry(taskService, runner, model, retry, currentRetries);
		}

		@Override
		public Throwable handleError(final TaskService taskService, final TaskRunner<TaskModel> runner, final TaskModel model,
				final Throwable error)
		{

			final Long pk = model.getPk().getLong();
			if (relevantTasks.contains(pk))
			{
				failedTasks.add(pk);
				countDownLatch.countDown();
			}
			return super.handleError(taskService, runner, model, error);

		}

		@Override
		public Class<? extends TaskRunner<? extends TaskModel>> getRunnerClass()
		{
			return TestTaskRunner.class;
		}

		public Collection<Long> getExecutedTasks()
		{
			return executedTasks;
		}

		public Collection<Long> getFailedTasks()
		{
			return failedTasks;
		}
	}

	private void assureTaskEngineStopped()
	{
		int shutdownWait = DEFAULT_SHUTDOWN_WAIT;
		while (taskService.getEngine().isRunning() && shutdownWait-- > 0)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (final InterruptedException e)
			{
				break;
			}
		}
		assertThat(taskService.getEngine().isRunning())
				.overridingErrorMessage("Task Engine failed to shut down in " + DEFAULT_SHUTDOWN_WAIT + " seconds.").isFalse();
	}


}
