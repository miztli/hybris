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

package de.hybris.platform.servicelayer.web.session.persister;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.web.session.CachedPersistedSessionRepository;
import de.hybris.platform.servicelayer.web.session.HybrisDeserializer;
import de.hybris.platform.servicelayer.web.session.PersistedSession;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.Config;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.serializer.Deserializer;
import org.springframework.session.Session;


@IntegrationTest
public class AsyncPersistedSessionLoadTest extends ServicelayerBaseTest
{
	@Resource
	private LinearDrainingAdaptiveAlgorithm linearDrainingAdaptiveAlgorithm;

	private final PropertyConfigSwitcher springSessionSaveAsyncTimeout = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_TIMEOUT);
	private final PropertyConfigSwitcher springSessionSaveAsyncMaxItems = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_MAX_ITEMS);
	private final PropertyConfigSwitcher springSessionSaveAsyncQueueSize = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_QUEUE_SIZE);
	private final PropertyConfigSwitcher springSessionSaveAsyncInterval = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_INTERVAL);
	private final PropertyConfigSwitcher springSessionSaveAsyncUseAdaptiveAlg = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_USE_ADAPTIVE_ALGORITHM);
	private final PropertyConfigSwitcher springSessionSaveAsyncMaxratioAdaptiveMax = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_MAXRATIO_ADAPTIVE_ALGORITHM);
	private final PropertyConfigSwitcher springSessionSaveAsyncThresholdAdaptivrAlg = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_THRESHOLD_ADAPTIVE_ALGORITHM);
	private final PropertyConfigSwitcher springSessionSaveAsyncShouldThrowExceptions = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_SHOULD_THROW_EXCEPTION);

	@Resource
	private ModelService modelService;

	private TestAsyncSessionPersisterRunnable asyncSessionPersisterRunnable;
	private TestAsyncSessionPersister asynchronousSessionPersister;


	private static final Logger LOG = LoggerFactory.getLogger(AsyncPersistedSessionLoadTest.class);

	private CachedPersistedSessionRepository repository;

	@Before
	public void setup()
	{
		springSessionSaveAsyncTimeout.switchToValue("6");
		springSessionSaveAsyncMaxItems.switchToValue("2");
		springSessionSaveAsyncQueueSize.switchToValue("10");
		springSessionSaveAsyncInterval.switchToValue("100");
		springSessionSaveAsyncUseAdaptiveAlg.switchToValue("true");
		springSessionSaveAsyncMaxratioAdaptiveMax.switchToValue("80");
		springSessionSaveAsyncThresholdAdaptivrAlg.switchToValue("20");
		springSessionSaveAsyncShouldThrowExceptions.switchToValue("true");

		asyncSessionPersisterRunnable = new TestAsyncSessionPersisterRunnable();
		asynchronousSessionPersister = new TestAsyncSessionPersister();

		asyncSessionPersisterRunnable.setTenant(Registry.getCurrentTenant());
		asyncSessionPersisterRunnable.setModelService(modelService);
		asyncSessionPersisterRunnable.setDrainingAdaptiveAlgorithm(linearDrainingAdaptiveAlgorithm);

		asyncSessionPersisterRunnable.init();
		linearDrainingAdaptiveAlgorithm.init();
		asynchronousSessionPersister.setAsyncSessionPersisterRunnable(asyncSessionPersisterRunnable);
		asynchronousSessionPersister.init();
		asynchronousSessionPersister.start();

		repository = buildTestSessionRepository();
	}

	@After
	public void revertConfigs()
	{
		springSessionSaveAsyncTimeout.switchBackToDefault();
		springSessionSaveAsyncMaxItems.switchBackToDefault();
		springSessionSaveAsyncQueueSize.switchBackToDefault();
		springSessionSaveAsyncInterval.switchBackToDefault();
		springSessionSaveAsyncUseAdaptiveAlg.switchBackToDefault();
		springSessionSaveAsyncMaxratioAdaptiveMax.switchBackToDefault();
		springSessionSaveAsyncThresholdAdaptivrAlg.switchBackToDefault();
		springSessionSaveAsyncShouldThrowExceptions.switchBackToDefault();

		linearDrainingAdaptiveAlgorithm.init();
	}

	@Test
	public void shouldHandleWithoutErrors() throws InterruptedException
	{
		logSetupInformation();

		final Map<String, Boolean> executions = new ConcurrentHashMap<>();

		final long startTime = System.currentTimeMillis();

		persistSessions(executions, 50, 4000);

		while (asyncSessionPersisterRunnable.getQueue().size() > 0)
		{
			Thread.currentThread().sleep(20);
		}

		final long executionTime = System.currentTimeMillis() - startTime;
		final long total = executions.size();
		final long passed = executions.keySet().stream().filter(entry -> executions.get(entry)).count();
		final long errors = executions.keySet().stream().filter(entry -> !executions.get(entry)).count();

		logResultInformation(executionTime, total, passed, errors);

		assertThat(errors).isEqualTo(0);
		assertThat(passed).isEqualTo(total).isEqualTo(asyncSessionPersisterRunnable.getCount());
	}

	@Test
	public void shouldNotThrowExceptionsWhenFailedToPersist() throws InterruptedException
	{
		springSessionSaveAsyncShouldThrowExceptions.switchToValue("false");

		logSetupInformation();

		final Map<String, Boolean> executions = new ConcurrentHashMap<>();

		final long startTime = System.currentTimeMillis();

		persistSessions(executions, 2, 4000);

		while (asyncSessionPersisterRunnable.getQueue().size() > 0)
		{
			Thread.currentThread().sleep(20);
		}

		final long executionTime = System.currentTimeMillis() - startTime;
		final long total = executions.size();
		final long withoutExceptions = executions.keySet().stream().filter(entry -> executions.get(entry)).count();
		final long withException = executions.keySet().stream().filter(entry -> !executions.get(entry)).count();

		logResultInformation(executionTime, total, withoutExceptions, withException);

		assertThat(withException).isEqualTo(0);
		assertThat(withoutExceptions).isEqualTo(total);
		assertThat(withoutExceptions).isGreaterThan(asyncSessionPersisterRunnable.getCount());
	}

	@Test
	public void shouldThrowExceptionsWhenFailedAndConfiguredToDo()
	{
		springSessionSaveAsyncShouldThrowExceptions.switchToValue("true");
		logSetupInformation();

		final Map<String, Boolean> executions = new ConcurrentHashMap<>();
		final Throwable throwable = catchThrowable(() -> persistSessions(executions, 2, 4000));

		assertThat(throwable).isInstanceOf(IllegalStateException.class);
	}

	private void persistSessions(final Map<String, Boolean> executions, final long interval, final long timeout)
	{
		final Random generator = new Random();

		for (int i = 0; i < 6; i++)
		{
			createSession(executions);
		}

		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < timeout)
		{
			createSession(executions);
			try
			{
				Thread.currentThread().sleep(interval + generator.nextInt(4));
			}
			catch (final InterruptedException e)
			{
				break;
			}
		}
	}

	private void createSession(final Map<String, Boolean> executions)
	{
		final Session session = repository.createSession();

		repository.save(session);
		executions.put(session.getId(), true);
	}

	private void logResultInformation(final long executionTime, final long total, final long withoutException,
			final long withException)
	{
		LOG.debug("total: {}", total);
		LOG.debug("executionTime: {}", executionTime);
		LOG.debug("ops per sec: {}", ((double) total / executionTime) * 1000);
		LOG.debug("withoutException: {}", withoutException);
		LOG.debug("withException: {}", withException);
		LOG.debug("savedCount: {}", asyncSessionPersisterRunnable.getCount());
	}

	private void logSetupInformation()
	{
		LOG.debug("{}: {}", AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_MAX_ITEMS,
				Config.getLong(AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_MAX_ITEMS, 10));
		LOG.debug("{}: {}", AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_QUEUE_SIZE,
				Config.getLong(AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_QUEUE_SIZE, 100));
		LOG.debug("{}: {}", AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_INTERVAL,
				Config.getLong(AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_INTERVAL, 200));
		LOG.debug("{}: {}", AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_TIMEOUT,
				Config.getLong(AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_TIMEOUT, 4000));
		LOG.debug("{}: {}", AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_USE_ADAPTIVE_ALGORITHM,
				Config.getBoolean(AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_USE_ADAPTIVE_ALGORITHM, true));
		LOG.debug("{}: {}", AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_THRESHOLD_ADAPTIVE_ALGORITHM,
				Config.getLong(AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_THRESHOLD_ADAPTIVE_ALGORITHM, 40));
		LOG.debug("{}: {}", AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_MAXRATIO_ADAPTIVE_ALGORITHM,
				Config.getLong(AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_MAXRATIO_ADAPTIVE_ALGORITHM, 80));
	}

	private CachedPersistedSessionRepository buildTestSessionRepository()
	{
		final HybrisDeserializer deserializer = new HybrisDeserializer(this.getClass().getClassLoader());
		return new CachedPersistedSessionRepository(deserializer, asynchronousSessionPersister, "foo", "");
	}

	private class TestAsyncSessionPersisterRunnable extends AsyncSessionPersisterRunnable
	{
		long count = 0;

		protected long getCount()
		{
			return count;
		}

		@Override
		protected void persistSessions(final Collection<PersistedSession> withoutDuplicates)
		{
			count += withoutDuplicates.size();
			try
			{
				Thread.currentThread().sleep(withoutDuplicates.size() * 10);
			}
			catch (final InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}

		@Override
		protected void removeSessions(final Set<String> ids)
		{
			try
			{
				Thread.currentThread().sleep(ids.size() * 10);
			}
			catch (final InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}
	}

	private class TestAsyncSessionPersister extends AsyncSessionPersister
	{
		@Override
		public PersistedSession load(final String id, final Deserializer deSerializer)
		{
			return null;
		}

		@Override
		protected boolean isAllowedToStart()
		{
			return true;
		}

		@Override
		protected boolean isAsyncSessionPersistenceConfigured()
		{
			return true;
		}
	}
}
