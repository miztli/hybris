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
package de.hybris.platform.processengine.definition;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@UnitTest
public class ActionDefinitionContextTest
{
	private ActionDefinitionContext theGood;
	private ActionDefinitionContext theBad;

	@Before
	public void setUp()
	{
		Map<String, String> map = new TreeMap<>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");

		this.theGood = ActionDefinitionContext.builder()
				.withParameters(map)
				.withTransitions(map)
				.build();
		this.theBad = ActionDefinitionContext.builder()
				.withParameters(null)
				.withTransitions(null)
				.build();
	}

	@After
	public void tearDown()
	{
		//tearDown
	}

	@Test
	public void shouldReturnOptionalOfParameterValueWhenParameterExists()
	{
		assertThat(theGood.getParameter("k1")).isEqualTo(Optional.of("v1"));
	}

	@Test
	public void shouldReturnOptionalEmptyWhenParameterNotExists()
	{
		assertThat(this.theGood.getParameter("k4")).isEqualTo(Optional.empty());
		assertThat(this.theBad.getParameter("k1")).isEqualTo(Optional.empty());
	}

	@Test
	public void shouldReturnAllParameters()
	{
		assertThat(this.theGood.getParameters().size()).isEqualTo(3);
	}

	@Test
	public void shouldReturnZeroParameters()
	{
		assertThat(this.theBad.getParameters().size()).isEqualTo(0);
	}

	@Test
	public void shouldReturnAllTransitions()
	{
		assertThat(this.theGood.getTransitions().size()).isEqualTo(3);
	}

	@Test
	public void shouldReturnZeroTransitions()
	{
		assertThat(this.theBad.getTransitions().size()).isEqualTo(0);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldReturnSameNumberOfParameters()
	{
		this.theGood.getParameters().put("k4", "v4");
		assertThat(this.theGood.getParameters().size()).isEqualTo(3);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldReturnSameNumberOfTransitions()
	{
		this.theGood.getTransitions().put("k4", "v4");
		assertThat(this.theGood.getTransitions().size()).isEqualTo(3);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldNotBeAbleToChangeParameters()
	{
		this.theGood.getParameters().put("k1", "1v");
		assertThat(this.theGood.getParameter("k1")).isEqualTo(Optional.of("v1"));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldNotBeAbleToChangeTransitions()
	{
		this.theGood.getTransitions().put("k1", "1v");
		assertThat(this.theGood.getTransitions().get("k1")).isEqualTo("v1");
	}
}
