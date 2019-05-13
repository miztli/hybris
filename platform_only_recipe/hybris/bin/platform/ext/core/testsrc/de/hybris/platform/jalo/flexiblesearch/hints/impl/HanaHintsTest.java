package de.hybris.platform.jalo.flexiblesearch.hints.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;


@UnitTest
public class HanaHintsTest
{

	@Test
	public void shouldApplyHintToTheQuery()
	{
		// given
		final String query = "SELECT foo FROM bar";
		final HanaHints hint = new HanaHints(true, Lists.newArrayList("HINT_ONE"));

		// when
		final String modifiedQuery = hint.apply(query);

		// then
		assertThat(modifiedQuery).isNotEmpty();
		assertThat(modifiedQuery).isEqualTo("SELECT foo FROM bar WITH HINT(HINT_ONE)");
	}

	@Test
	public void shouldApplyMoreThanOneHintToTheQuery()
	{
		// given
		final String query = "SELECT foo FROM bar";
		final HanaHints hint = new HanaHints(true, Lists.newArrayList("HINT_ONE", "HINT_TWO"));

		// when
		final String modifiedQuery = hint.apply(query);

		// then
		assertThat(modifiedQuery).isNotEmpty();
		assertThat(modifiedQuery).isEqualTo("SELECT foo FROM bar WITH HINT(HINT_ONE,HINT_TWO)");
	}

	@Test
	public void shouldNotApplyHintIfHintsAreNotForCurrentDb()
	{
		// given
		final String query = "SELECT foo FROM bar";
		final HanaHints hint = new HanaHints(false, Lists.newArrayList("HINT_ONE"));

		// when
		final String modifiedQuery = hint.apply(query);

		// then
		assertThat(modifiedQuery).isNotEmpty();
		assertThat(modifiedQuery).isEqualTo("SELECT foo FROM bar");
	}


	@Test
	public void shouldThrowIllegalArgumentExceptionIfSomeHintsAreNull()
	{
		// given
		final List<String> hints = new ArrayList<>();
		hints.add(null);

		try
		{
			// when
			new HanaHints(true, hints);
			fail("Expected IllegalArgumentException");
		}
		catch (final IllegalArgumentException e)
		{
			// then OK
		}
	}

	@Test
	public void shouldThrowIllegalArgumentExceptionIfSomeHintsAreBlank()
	{
		// given
		final List<String> hints = new ArrayList<>();
		hints.add(" ");

		try
		{
			// when
			new HanaHints(true, hints);
			fail("Expected IllegalArgumentException");
		}
		catch (final IllegalArgumentException e)
		{
			// then OK
		}
	}

	@Test
	public void shouldThrowIllegalArgumentExceptionIfAddeHintsIsNull()
	{
		// given
		final HanaHints hints = new HanaHints(true, new ArrayList<>());

		try
		{
			// when
			hints.add(null);
			fail("Expected IllegalArgumentException");
		}
		catch (final IllegalArgumentException e)
		{
			// then OK
		}
	}

	@Test
	public void shouldThrowIllegalArgumentExceptionIfAddedHintIsBlank()
	{
		// given
		final HanaHints hints = new HanaHints(true, new ArrayList<>());

		try
		{
			// when
			hints.add(" ");
			fail("Expected IllegalArgumentException");
		}
		catch (final IllegalArgumentException e)
		{
			// then OK
		}
	}

	@Test
	public void shouldAddAdditionalHints()
	{
		// given
		final String query = "SELECT foo FROM bar";

		final HanaHints hint = new HanaHints(true, Lists.newArrayList("HINT_ONE"));
		hint.add("HINT_TWO").add("HINT_THREE");

		// when
		final String modifiedQuery = hint.apply(query);

		// then
		assertThat(modifiedQuery).isNotEmpty();
		assertThat(modifiedQuery).isEqualTo("SELECT foo FROM bar WITH HINT(HINT_ONE,HINT_TWO,HINT_THREE)");
	}

	@Test
	public void shouldAddHintsIfInitialSetOfHintsAreEmpty()
	{
		// given
		final String query = "SELECT foo FROM bar";

		final HanaHints hint = new HanaHints(true, new ArrayList<>());
		hint.add("HINT_TWO").add("HINT_THREE");

		// when
		final String modifiedQuery = hint.apply(query);

		// then
		assertThat(modifiedQuery).isNotEmpty();
		assertThat(modifiedQuery).isEqualTo("SELECT foo FROM bar WITH HINT(HINT_TWO,HINT_THREE)");
	}

}