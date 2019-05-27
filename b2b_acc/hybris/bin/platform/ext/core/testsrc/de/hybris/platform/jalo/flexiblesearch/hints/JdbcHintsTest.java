package de.hybris.platform.jalo.flexiblesearch.hints;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.jalo.flexiblesearch.hints.impl.JdbcHints;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class JdbcHintsTest
{
	@Mock
	private PreparedStatement ps;

	@Test
	public void shouldApplyFetchSizeHint() throws Exception
	{
		// given
		final PreparedStatementHint hint = JdbcHints.preparedStatementHints().withFetchSize(50);

		// when
		hint.apply(ps);

		// then
		verify(ps).setFetchSize(50);
	}

	@Test
	public void shouldApplyQueryTimeoutHint() throws Exception
	{
		// given
		final PreparedStatementHint hint = JdbcHints.preparedStatementHints().withQueryTimeOut(200);

		// when
		hint.apply(ps);

		// then
		verify(ps).setQueryTimeout(200);
	}

	@Test
	public void shouldThrowNullPointerExceptionWhenHintIsNull()
	{
		try
		{
			// when
			JdbcHints.preparedStatementHints().withHint(null);
			fail("Expected NullPointerException");
		}
		catch (final NullPointerException e)
		{
			// then OK
		}
	}

	@Test
	public void shouldApplyMoreThanOneHintInSameOrder() throws SQLException
	{
		// given
		final PreparedStatementHint jdbcHints = JdbcHints.preparedStatementHints().withFetchSize(50).withQueryTimeOut(200).withHint(ps -> {
			ps.setCursorName("fooBar");
			return ps;
		}).withHint(ps -> {
			ps.setMaxFieldSize(500);
			return ps;
		});
		final InOrder inOrder = inOrder(ps);

		// when
		jdbcHints.apply(ps);

		// then
		inOrder.verify(ps).setFetchSize(50);
		inOrder.verify(ps).setQueryTimeout(200);
		inOrder.verify(ps).setCursorName("fooBar");
		inOrder.verify(ps).setMaxFieldSize(500);
	}

}
