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
package de.hybris.platform.hac.facade;

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.hac.data.LoggerConfigData;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;


@UnitTest
public class HacLog4JFacadeTest
{
	private final HacLog4JFacade log4JFacade = new HacLog4JFacade();

	@Test
	public void shouldReturnAtLeastRootLoggerData()
	{
		final List<LoggerConfigData> loggers = log4JFacade.getLoggers();

		assertThat(loggers).isNotEmpty();

		final LoggerConfigData rootLoggerData = getLoggerConfig("root").get();
		assertThat(rootLoggerData.getEffectiveLevel()).isEqualTo(LogManager.getRootLogger().getLevel());
	}

	@Test
	public void testChangeLoggerOnRuntime()
	{
		final Level defaultLevel = LogManager.getRootLogger().getLevel();
		final Level wantedLevel = defaultLevel.equals(Level.WARN) ? Level.INFO : Level.WARN;

		try
		{
			log4JFacade.changeLogLevel("root", wantedLevel.name());
			assertThat(LogManager.getRootLogger().getLevel()).isEqualTo(wantedLevel);
		}
		finally
		{
			log4JFacade.changeLogLevel("root", wantedLevel.name());
		}
	}

	@Test
	public void testChangeUnconfiguredLoggerOnRuntime()
	{
		final String loggerName = HacLog4JFacadeTest.class.getName() + "testLogger";
		// Given logger is not configured
		Optional<LoggerConfigData> loggerConfig = getLoggerConfig(loggerName);
		assertThat(loggerConfig.isPresent()).isEqualTo(false);

		// When changing the log level
		log4JFacade.changeLogLevel(loggerName, Level.ERROR.name());

		// Then logger is configured
		loggerConfig = getLoggerConfig(loggerName);
		assertThat(loggerConfig.isPresent()).isEqualTo(true);
	}

	/**
	 * Get logger configuration.
	 *
	 * @param loggerName
	 *           The name of the logger.
	 * @return An {@link Optional} of the logger configuration. The {@link Optional} is empty when a logger with the given
	 *         name has not been configured yet.
	 */
	protected Optional<LoggerConfigData> getLoggerConfig(final String loggerName)
	{
		final List<LoggerConfigData> loggers = log4JFacade.getLoggers();
		return loggers.stream().filter(i -> i.getName().equals(loggerName)).findFirst();
	}

}
