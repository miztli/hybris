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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.jdbcwrapper.interceptor.JDBCInterceptor.SupplierWithSQLException;

import java.sql.SQLException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;


@UnitTest
public class SQLRecoverableExceptionHandlerUnitTest
{

	private static final Object INVOKED = "INVOKED";
	private static final SQLException NON_RECOVERABLE_FAILURE = new SQLException("NON_RECOVERABLE_FAILURE");
	private static final SQLException RECOVERABLE_FAILURE = new SQLException("RECOVERABLE_FAILURE");
	private static final Duration NEGATIVE_DURATION = Duration.ZERO.minus(1, ChronoUnit.SECONDS);
	private static final Duration LONG_DURATION = Duration.ofDays(1);

	@Test
	public void shouldExecuteTheOperationWhenHandlerIsOpen() throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();
		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenReturn(INVOKED);

		final Object result = handler.get(operation);

		assertThat(result).isNotNull().isSameAs(INVOKED);
	}

	@Test
	public void shouldRethrowTheExceptionAndDoNotChangeTheHandlerStateWhenHandlerIsOpenAndTheOperationFailsWithNonRecoverableException()
			throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();
		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenThrow(NON_RECOVERABLE_FAILURE);

		assertThatThrownBy(() -> handler.get(operation)).isSameAs(NON_RECOVERABLE_FAILURE);
		assertThat(handler.isOpen()).isTrue();

		verify(strategy).isRecoverable(NON_RECOVERABLE_FAILURE);
	}

	@Test
	public void shouldRethrowTheExceptionAndCloseTheHandlerWhenHandlerIsOpenAndTheOperationFailsWithRecoverableException()
			throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();

		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenThrow(RECOVERABLE_FAILURE);

		assertThatThrownBy(() -> handler.get(operation)).isSameAs(RECOVERABLE_FAILURE);
		assertThat(handler.isOpen()).isFalse();

		verify(strategy).isRecoverable(RECOVERABLE_FAILURE);
	}

	@Test
	public void shouldNotExecuteTheOperationWhenHandlerIsClosedAndBackoffPeriodPassedButTheContextIsNotRecoverableOne()
			throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();
		when(strategy.canRecover(any())).thenReturn(false);
		when(strategy.calculateBackoffDuration(0)).thenReturn(NEGATIVE_DURATION);

		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);

		handler.forceClose();

		assertThatThrownBy(() -> handler.get(operation)).isExactlyInstanceOf(RecoveryInProgressException.class);
		assertThat(handler.isOpen()).isFalse();

		verify(operation, never()).get();
	}

	@Test
	public void shouldExecuteTheOperationAndOpenTheHandlerWhenHandlerIsClosedAndBackoffPeriodPassedAndTheContextIsNotRecoverableOne()
			throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();
		when(strategy.canRecover(any())).thenReturn(true);
		when(strategy.calculateBackoffDuration(0)).thenReturn(NEGATIVE_DURATION);

		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenReturn(INVOKED);

		handler.forceClose();

		final Object result = handler.get(operation);
		assertThat(result).isNotNull().isSameAs(INVOKED);
		assertThat(handler.isOpen()).isTrue();
	}

	@Test
	public void shouldReThrowTheExceptionWhenHandlerIsClosedAndBackoffPeriodPassedAndTheContextIsNotRecoverableOneButTheOperationFailsWithNonRecoverableException()
			throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();
		when(strategy.canRecover(any())).thenReturn(true);
		when(strategy.calculateBackoffDuration(0)).thenReturn(NEGATIVE_DURATION);

		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenThrow(NON_RECOVERABLE_FAILURE);

		handler.forceClose();

		assertThatThrownBy(() -> handler.get(operation)).isSameAs(NON_RECOVERABLE_FAILURE);
		assertThat(handler.isOpen()).isFalse();
	}

	@Test
	public void shouldReThrowTheExceptionWhenHandlerIsClosedAndBackoffPeriodPassedAndTheContextIsNotRecoverableOneButTheOperationFailsWithRecoverableException()
			throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();
		when(strategy.canRecover(any())).thenReturn(true);
		when(strategy.calculateBackoffDuration(0)).thenReturn(NEGATIVE_DURATION);

		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenThrow(RECOVERABLE_FAILURE);

		handler.forceClose();

		assertThatThrownBy(() -> handler.get(operation)).isSameAs(RECOVERABLE_FAILURE);
		assertThat(handler.isOpen()).isFalse();
	}

	@Test
	public void shouldNotExecuteTheOperationWhenHandlerIsClosedAndBackoffPeriodHasNotPassedYetAndTheContextIsRecoverableOne()
			throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();
		when(strategy.canRecover(any())).thenReturn(true);
		when(strategy.calculateBackoffDuration(0)).thenReturn(LONG_DURATION);

		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenReturn(INVOKED);

		handler.forceClose();

		assertThatThrownBy(() -> handler.get(operation)).isExactlyInstanceOf(RecoveryInProgressException.class);
		assertThat(handler.isOpen()).isFalse();

		verify(operation, never()).get();
	}

	@Test
	public void shouldNotExecuteTheRecursiveOperationWhenTheHandlerIsClosedInTheMiddleOfIt() throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();

		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenReturn(INVOKED);

		final AtomicBoolean executed = new AtomicBoolean(false);
		final SupplierWithSQLException recursiveOperation = () -> {
			executed.set(true);
			handler.forceClose();
			return handler.get(operation);
		};


		assertThatThrownBy(() -> handler.get(recursiveOperation)).isExactlyInstanceOf(RecoveryInProgressException.class);
		assertThat(handler.isOpen()).isFalse();
		assertThat(executed.get()).isTrue();

		verify(operation, never()).get();
	}

	@Test
	public void shouldExecuteTheRecursiveOperationDuringProbingPhase() throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();
		when(strategy.canRecover(any())).thenReturn(true);
		when(strategy.calculateBackoffDuration(0)).thenReturn(NEGATIVE_DURATION);
		when(strategy.calculateBackoffDuration(1)).thenReturn(LONG_DURATION);

		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenReturn(INVOKED);

		final AtomicBoolean executed = new AtomicBoolean(false);
		final SupplierWithSQLException recursiveOperation = () -> {
			executed.set(true);
			handler.forceClose();
			return handler.get(operation);
		};

		handler.forceClose();

		final Object result = handler.get(recursiveOperation);
		assertThat(result).isNotNull().isSameAs(INVOKED);
		assertThat(handler.isOpen()).isTrue();
		assertThat(executed.get()).isTrue();
	}

	@Test
	public void shouldExecuteTheOperationAndOpenTheHandlerWhenHandlerIsClosedAndBackoffPeriodPassedAndTheContextIsNotRecoverableOneAndSomeoneElseOpenedTheHandler()
			throws SQLException
	{
		final SQLRecoveryStrategy strategy = mockStrategy();
		when(strategy.calculateBackoffDuration(0)).thenReturn(NEGATIVE_DURATION);

		final SQLRecoverableExceptionHandler handler = givenHandler(strategy);

		when(strategy.canRecover(any())).then(i -> {
			handler.forceOpen();
			return true;
		});

		final SupplierWithSQLException operation = mock(SupplierWithSQLException.class);
		when(operation.get()).thenReturn(INVOKED);

		handler.forceClose();

		final Object result = handler.get(operation);
		assertThat(result).isNotNull().isSameAs(INVOKED);
		assertThat(handler.isOpen()).isTrue();
	}

	private SQLRecoveryStrategy mockStrategy()
	{
		final SQLRecoveryStrategy strategy = mock(SQLRecoveryStrategy.class);
		when(strategy.isRecoverable(RECOVERABLE_FAILURE)).thenReturn(true);

		return strategy;
	}

	private SQLRecoverableExceptionHandler givenHandler(final SQLRecoveryStrategy strategy)
	{
		return new SQLRecoverableExceptionHandler(strategy);
	}

}
