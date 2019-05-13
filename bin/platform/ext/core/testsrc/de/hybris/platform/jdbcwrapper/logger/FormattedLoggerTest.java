package de.hybris.platform.jdbcwrapper.logger;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class FormattedLoggerTest extends ServicelayerBaseTest
{
	private static final long THREAD_ID = 1;
	private static final String DATA_SOURCE_ID = "2";
	private static final int CONN_ID = 3;
	private static final String DATE_NOW = "567890";
	private static final long ELAPSED = 123;
	private static final String LOG_CATEGORY = "test_log";
	private static final String PREPARED_STATEMENT = "SELECT * FROM Foo WHERE x=?";
	private static final String SQL_AND_STACKTRACE = "SELECT * FROM Foo WHERE x='123' /* SomeClass:94:OtherClass:58:END */";

	private final PropertyConfigSwitcher logSqlParams = new PropertyConfigSwitcher("db.log.sql.parameters");
	private final PropertyConfigSwitcher logAppendStacktrace = new PropertyConfigSwitcher("db.log.appendStackTrace");
	private TestLogger logger;

	@Before
	public void setUp()
	{
		logger = new TestLogger();
	}

	@After
	public void tearDown()
	{
		logSqlParams.switchBackToDefault();
		logAppendStacktrace.switchBackToDefault();
	}

	@Test
	public void shouldLogOnlyPreparedStatementByDefault()
	{
		// given (settings from default advanced.properties (false, false))

		// when
		logWithQuery(PREPARED_STATEMENT, SQL_AND_STACKTRACE);

		// then
		assertThat(logger.getLog()).endsWith("|SELECT * FROM Foo WHERE x=?");
	}

	@Test
	public void shouldLogQueryWithRealParamsIfConfigured()
	{
		// given
		logSqlParams.switchToValue("true");

		// when
		logWithQuery(PREPARED_STATEMENT, SQL_AND_STACKTRACE);

		// then
		assertThat(logger.getLog()).endsWith("|SELECT * FROM Foo WHERE x=?|SELECT * FROM Foo WHERE x='123'");
	}

	@Test
	public void shouldLogQueryWithRealParamsAndStacktraceIfConfigured()
	{
		// given
		logSqlParams.switchToValue("true");
		logAppendStacktrace.switchToValue("true");

		// when
		logWithQuery(PREPARED_STATEMENT, SQL_AND_STACKTRACE);

		// then
		assertThat(logger.getLog())
				.endsWith("|SELECT * FROM Foo WHERE x=?|SELECT * FROM Foo WHERE x='123'|SomeClass:94:OtherClass:58:END");
	}

	@Test
	public void shouldLogQueryWithStacktraceIfConfigured()
	{
		// given
		logAppendStacktrace.switchToValue("true");

		// when
		logWithQuery(PREPARED_STATEMENT, SQL_AND_STACKTRACE);

		// then
		assertThat(logger.getLog()).endsWith("|SELECT * FROM Foo WHERE x=?|SomeClass:94:OtherClass:58:END");
	}

	@Test
	public void shouldLogQueryWithSqlParamsIfConfiguredAndInputSqlDoesNotContainStacktrace()
	{
		// given
		logSqlParams.switchToValue("true");
		final String sql = "SELECT * FROM Foo WHERE x='567'";

		// when
		logWithQuery(PREPARED_STATEMENT, sql);

		// then
		assertThat(logger.getLog()).endsWith("|SELECT * FROM Foo WHERE x=?|SELECT * FROM Foo WHERE x='567'");
	}

	@Test
	public void shouldLogQueryWithoutSqlParamsIfNotConfiguredAndInputSqlDoesNotContainStacktrace()
	{
		// given
		final String sql = "SELECT * FROM Foo WHERE x='567'";

		// when
		logWithQuery(PREPARED_STATEMENT, sql);

		// then
		assertThat(logger.getLog()).endsWith("|SELECT * FROM Foo WHERE x=?");
	}

    @Test
    public void shouldLogQueryWithoutSqlParamsIfNotConfiguredAndInputSqlDoesNotContainStacktraceButPreparedStatementContainsComment()
    {
        // given
        final String preparedStatement = "SELECT * /* comment */ FROM Foo WHERE x=?";
        final String sql = "SELECT * FROM Foo WHERE x='567'";

        // when
        logWithQuery(preparedStatement, sql);

        // then
        assertThat(logger.getLog()).endsWith("|SELECT * /* comment */ FROM Foo WHERE x=?");
    }

    @Test
    public void shouldLogQueryWithoutStacktraceIfStacktraceIsEmpty()
    {
    	// given
        logAppendStacktrace.switchToValue("true");
        final String sqlAndStacktrace = "SELECT * FROM Foo WHERE x='123' /**/";

    	// when
        logWithQuery(PREPARED_STATEMENT, sqlAndStacktrace);

    	// then
        assertThat(logger.getLog()).endsWith("|SELECT * FROM Foo WHERE x=?");
    }

	@Test
	public void shouldLogQueryWithoutSqlParamsEvenItIsConfiguredIfInputSqlIsNull()
	{
		// given
		logSqlParams.switchToValue("true");

		// when
		logWithQuery(PREPARED_STATEMENT, null);

		// then
		assertThat(logger.getLog()).endsWith("|SELECT * FROM Foo WHERE x=?");
	}

	@Test
	public void shouldLogQueryWithoutSqlParamsEvenItIsConfiguredIfInputSqlIsBlank()
	{
		// given
		logSqlParams.switchToValue("true");
		final String sql = " ";

		// when
		logWithQuery(PREPARED_STATEMENT, sql);

		// then
		assertThat(logger.getLog()).endsWith("|SELECT * FROM Foo WHERE x=?");
	}

	private void logWithQuery(final String preparedStatement, final String sqlAndStacktrace)
	{
		logger.logSQL(THREAD_ID, DATA_SOURCE_ID, CONN_ID, DATE_NOW, ELAPSED, LOG_CATEGORY, preparedStatement, sqlAndStacktrace);
	}

	class TestLogger extends FormattedLogger
	{
		private final StringBuilder sb = new StringBuilder();

		@Override
		public void logException(final Exception exception)
		{
			// NO-OP
		}

		@Override
		public void logText(final String text)
		{
			sb.append(text);
		}

		public String getLog()
		{
			return sb.toString();
		}
	}
}