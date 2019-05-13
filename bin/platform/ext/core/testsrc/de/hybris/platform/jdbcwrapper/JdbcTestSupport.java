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
package de.hybris.platform.jdbcwrapper;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.platform.core.Registry;
import de.hybris.platform.jdbcwrapper.JDBCLogUtils.StatementsListener;

import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.assertj.core.api.AssertProvider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;


public final class JdbcTestSupport
{
	private JdbcTestSupport()
	{
		//no instantiation
	}

	public static JdbcStatistics createNewJdbcStatistics()
	{
		return new JdbcStatistics();
	}

	public static class JdbcStatistics implements AssertProvider<JdbcStatisticsAssertions>
	{
		private final ConcurrentHashMap<Long, ImmutableList<String>> statementsPerThread = new ConcurrentHashMap<>();
		private final StatementsListener listener = JdbcStatistics.this::statementExecuted;

		private void statementExecuted(final String statement)
		{
			if (!JdbcStatisticsAssertions.isSupported(statement))
			{
				return;
			}
			final Long threadId = Long.valueOf(Thread.currentThread().getId());
			statementsPerThread.computeIfPresent(threadId,
					(tId, current) -> ImmutableList.<String> builder().addAll(current).add(statement).build());
		}

		public void attachToCurrentThread()
		{
			final Long threadId = Long.valueOf(Thread.currentThread().getId());
			statementsPerThread.putIfAbsent(threadId, ImmutableList.of());

			Registry.getCurrentTenant().getDataSource().getLogUtils().addListener(listener);
		}

		public void detach()
		{
			Registry.getCurrentTenant().getDataSource().getLogUtils().removeListener(listener);
		}

		@Override
		public JdbcStatisticsAssertions assertThat()
		{
			return new JdbcStatisticsAssertions(
					ImmutableMap.<Long, ImmutableList<String>> builder().putAll(statementsPerThread).build());
		}
	}

	public static class JdbcStatisticsAssertions
	{
		private static final String SELECT = "SELECT";
		private static final Set<String> DMLS = ImmutableSet.of("INSERT", "UPDATE", "DELETE");
		private static final Set<String> ALL_SUPPORTED_STATEMENTS = ImmutableSet.<String> builder().addAll(DMLS).add(SELECT)
				.build();
		private final Map<Long, ImmutableList<String>> statementsPerThread;

		private JdbcStatisticsAssertions(final Map<Long, ImmutableList<String>> statements)
		{
			this.statementsPerThread = ImmutableMap.copyOf(statements);
		}

		private static boolean isSupported(final String statement)
		{
			return statement != null
					&& ALL_SUPPORTED_STATEMENTS.stream().anyMatch(s -> statement.toUpperCase(Locale.getDefault()).startsWith(s));
		}

		public void containsOnlySelectStatements()
		{
			assertThat(allStatements()).isNotEmpty().allMatch(JdbcStatisticsAssertions::isSELECT);
		}

		public void containsNoDMLStatements()
		{
			final Stream<String> dmlStatements = allStatements().filter(JdbcStatisticsAssertions::isDML);

			assertThat(dmlStatements).isEmpty();
		}

		public void containsNoStatements()
		{
			assertThat(allStatements()).isEmpty();
		}

		public void containsExpectedNumberOfStatements(final int expected)
		{
			assertThat(allStatements()).hasSize(expected);
		}

		private Stream<String> allStatements()
		{
			return statementsPerThread.values().stream().flatMap(s -> s.stream());
		}

		private static boolean isSELECT(final String statement)
		{
			return statement.toUpperCase(Locale.getDefault()).startsWith("SELECT");
		}

		private static boolean isDML(final String statement)
		{
			return DMLS.stream().anyMatch(s -> statement.toUpperCase(Locale.getDefault()).startsWith(s));
		}
	}
}
