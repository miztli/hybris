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
package de.hybris.platform.jdbcwrapper.interceptor.recover;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.jdbcwrapper.interceptor.JDBCInterceptorContext;
import de.hybris.platform.util.Config.DatabaseName;
import de.hybris.platform.util.config.ConfigIntf;
import de.hybris.platform.util.config.FastHashMapConfig;

import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.junit.Test;


@UnitTest
public class DefaultSQLRecoveryStrategyUnitTest
{

	@Test
	public void shouldTreatSQLRecoverableExceptionAsRecoverableOne()
	{
		final ConfigIntf config = givenConfig();

		final DefaultSQLRecoveryStrategy strategy = givenStarategy(config);
		final DefaultSQLRecoveryStrategy strategySQLServer = givenStarategyOn(DatabaseName.SQLSERVER, config);

		final SQLException ex = givenSQLRecoverableException();

		assertThat(strategy.isRecoverable(ex)).isTrue();
		assertThat(strategySQLServer.isRecoverable(ex)).isTrue();
	}

	@Test
	public void shouldTreatNotRecoverableSQLExceptionAsNotRecoverableOne()
	{
		final ConfigIntf config = givenConfig();

		final DefaultSQLRecoveryStrategy strategy = givenStarategy(config);
		final DefaultSQLRecoveryStrategy strategySQLServer = givenStarategyOn(DatabaseName.SQLSERVER, config);

		final SQLException ex = givenSQLException(123);

		assertThat(strategy.isRecoverable(ex)).isFalse();
		assertThat(strategySQLServer.isRecoverable(ex)).isFalse();
	}

	@Test
	public void shouldTreatNotRecoverableSQLExceptionAsRecoverableOneWhenErrorCodeMatchesAndSQLServerIsUsed()
	{
		final ConfigIntf config = givenConfig(DefaultSQLRecoveryStrategy.recoverableErrorCodesKey(DatabaseName.SQLSERVER), "123");

		final DefaultSQLRecoveryStrategy strategy = givenStarategy(config);
		final DefaultSQLRecoveryStrategy strategySQLServer = givenStarategyOn(DatabaseName.SQLSERVER, config);

		final SQLException ex = givenSQLException(123);

		assertThat(strategy.isRecoverable(ex)).isFalse();
		assertThat(strategySQLServer.isRecoverable(ex)).isTrue();
	}

	@Test
	public void shouldTreatGetConnectionMethodFromTheDataSourceAsTheOneWhichCanRecoverTheSystem()
	{
		final ConfigIntf config = givenConfig();
		final DefaultSQLRecoveryStrategy strategy = givenStarategy(config);

		assertThat(strategy.canRecover(JDBCInterceptorContext.forMethod(DataSource.class, "getConnection"))).isTrue();
		assertThat(strategy.canRecover(JDBCInterceptorContext.forMethod(DataSource.class, "ala"))).isFalse();
	}

	@Test
	public void shouldIncreaseTheBackoffDurationExponentialyBasedOnTheConfiguration()
	{
		final ConfigIntf config = givenConfig( //
				DefaultSQLRecoveryStrategy.INITIAL_BACKOFF, "3", //
				DefaultSQLRecoveryStrategy.INCREASE_BACKOFF_FACTOR, "2", //
				DefaultSQLRecoveryStrategy.MAX_BACKOFF, "17");
		final DefaultSQLRecoveryStrategy strategy = givenStarategy(config);

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> strategy.calculateBackoffDuration(-1));

		assertThat(strategy.calculateBackoffDuration(0).get(ChronoUnit.SECONDS)).isEqualTo(3);
		assertThat(strategy.calculateBackoffDuration(1).get(ChronoUnit.SECONDS)).isEqualTo(6);
		assertThat(strategy.calculateBackoffDuration(2).get(ChronoUnit.SECONDS)).isEqualTo(12);
		assertThat(strategy.calculateBackoffDuration(3).get(ChronoUnit.SECONDS)).isEqualTo(17);
		assertThat(strategy.calculateBackoffDuration(10000).get(ChronoUnit.SECONDS)).isEqualTo(17);
	}

	@Test
	public void shouldConvertBlankStringToEmptySet()
	{
		assertThat(DefaultSQLRecoveryStrategy.toSetOfInts(null)).isNotNull().isEmpty();
		assertThat(DefaultSQLRecoveryStrategy.toSetOfInts("")).isNotNull().isEmpty();
		assertThat(DefaultSQLRecoveryStrategy.toSetOfInts(" ")).isNotNull().isEmpty();
		assertThat(DefaultSQLRecoveryStrategy.toSetOfInts(" \t")).isNotNull().isEmpty();
	}

	@Test
	public void shouldConvertValidStringToSet()
	{
		assertThat(DefaultSQLRecoveryStrategy.toSetOfInts("123")).isNotNull().isNotEmpty().containsOnlyOnce(123);
		assertThat(DefaultSQLRecoveryStrategy.toSetOfInts("12 3,45;6, 7 ; 8\t\t\t,9 \t\t\t 10")).isNotNull().isNotEmpty()
				.containsOnlyOnce(12, 3, 45, 6, 7, 8, 9, 10);
		assertThat(DefaultSQLRecoveryStrategy.toSetOfInts(" 12;34 ")).isNotNull().isNotEmpty().containsOnlyOnce(12, 34);
		assertThat(DefaultSQLRecoveryStrategy.toSetOfInts(" \t123\t ")).isNotNull().isNotEmpty().containsOnlyOnce(123);
	}

	@Test
	public void shouldConvertInvalidStringToException()
	{
		assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> DefaultSQLRecoveryStrategy.toSetOfInts("123|23"));
		assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> DefaultSQLRecoveryStrategy.toSetOfInts("1a3"));
		assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> DefaultSQLRecoveryStrategy.toSetOfInts("ala"));
		assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> DefaultSQLRecoveryStrategy.toSetOfInts("1,3,d,4"));
	}

	@Test
	public void shouldMergeRecoverableErrorCodesToDbSpecificones()
	{
		final ConfigIntf config = givenConfig(DefaultSQLRecoveryStrategy.recoverableErrorCodesKey(null), "1, 2, 3",
				DefaultSQLRecoveryStrategy.recoverableErrorCodesKey(DatabaseName.HANA), "11;12;13",
				DefaultSQLRecoveryStrategy.recoverableErrorCodesKey(DatabaseName.HSQLDB), "21 22 23",
				DefaultSQLRecoveryStrategy.recoverableErrorCodesKey(DatabaseName.MYSQL), "31;32;33",
				DefaultSQLRecoveryStrategy.recoverableErrorCodesKey(DatabaseName.ORACLE), "41, 42 43",
				DefaultSQLRecoveryStrategy.recoverableErrorCodesKey(DatabaseName.POSTGRESQL), "51 52;53",
				DefaultSQLRecoveryStrategy.recoverableErrorCodesKey(DatabaseName.SQLSERVER), "61 62, 63");

		final Map<DatabaseName, Set<Integer>> mergedCodes = DefaultSQLRecoveryStrategy.mergeRecoverableErrorCodes(config);

		assertThat(mergedCodes).isNotNull().hasSize(6);
		assertThat(mergedCodes.get(DatabaseName.HANA)).isNotNull().isNotEmpty().containsOnly(1, 2, 3, 11, 12, 13);
		assertThat(mergedCodes.get(DatabaseName.HSQLDB)).isNotNull().isNotEmpty().containsOnly(1, 2, 3, 21, 22, 23);
		assertThat(mergedCodes.get(DatabaseName.MYSQL)).isNotNull().isNotEmpty().containsOnly(1, 2, 3, 31, 32, 33);
		assertThat(mergedCodes.get(DatabaseName.ORACLE)).isNotNull().isNotEmpty().containsOnly(1, 2, 3, 41, 42, 43);
		assertThat(mergedCodes.get(DatabaseName.POSTGRESQL)).isNotNull().isNotEmpty().containsOnly(1, 2, 3, 51, 52, 53);
		assertThat(mergedCodes.get(DatabaseName.SQLSERVER)).isNotNull().isNotEmpty().containsOnly(1, 2, 3, 61, 62, 63);
	}

	private SQLException givenSQLException(final int errorCode)
	{
		return new SQLException("TEST", "TEST", errorCode);
	}

	private SQLException givenSQLRecoverableException()
	{
		return new SQLRecoverableException("TEST");
	}

	private DefaultSQLRecoveryStrategy givenStarategy(final ConfigIntf config)
	{
		return givenStarategyOn(null, config);
	}

	private DefaultSQLRecoveryStrategy givenStarategyOn(final DatabaseName dbType, final ConfigIntf config)
	{
		return new DefaultSQLRecoveryStrategy(config)
		{
			@Override
			protected DatabaseName getDataBaseType()
			{
				return dbType;
			}
		};
	}

	private ConfigIntf givenConfig(final String... params)
	{
		assertThat(params).isNotNull().hasSize((params.length / 2) * 2).doesNotContainNull();
		final HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < params.length / 2; i++)
		{
			map.put(params[i * 2], params[i * 2 + 1]);
		}
		return new FastHashMapConfig(map);
	}


}
