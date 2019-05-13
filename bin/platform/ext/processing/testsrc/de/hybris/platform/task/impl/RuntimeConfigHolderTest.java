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
package de.hybris.platform.task.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.task.impl.RuntimeConfigHolder.DurationTaskEngineProperty;
import de.hybris.platform.task.impl.RuntimeConfigHolder.IntTaskEngineProperty;
import de.hybris.platform.task.impl.RuntimeConfigHolder.StringTaskEngineProperty;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;


@UnitTest
public class RuntimeConfigHolderTest
{

	private static final IntTaskEngineProperty BACKGROUND_INT_PROPERTY = RuntimeConfigHolder.intProperty("backgroundIntProperty",
			1);
	private static final StringTaskEngineProperty BACKGROUND_STRING_PROPERTY = RuntimeConfigHolder
			.stringParameter("backgroundStringProperty", "blah");
	private static final DurationTaskEngineProperty BACKGROUND_DURATION_PROPERTY = RuntimeConfigHolder
			.durationProperty("backgroundDurationProperty", ChronoUnit.SECONDS, Duration.ofSeconds(5));

	@Test
	public void shouldReturnIntegerProperty() throws Exception
	{
		//given
		final IntTaskEngineProperty property = RuntimeConfigHolder.intProperty("intProperty", 1);
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(ImmutableMap.of("intProperty", "10"));

		//when
		final Integer value = configHolder.getProperty(property);

		//then
		assertThat(value).isEqualTo(10);
	}

	@Test
	public void shouldReturnStringProperty() throws Exception
	{
		//given
		final StringTaskEngineProperty property = RuntimeConfigHolder.stringParameter("stringProperty", "default");
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(ImmutableMap.of("stringProperty", "foo"));

		//when
		final String value = configHolder.getProperty(property);

		//then
		assertThat(value).isEqualTo("foo");
	}

	@Test
	public void shouldReturnDurationProperty() throws Exception
	{
		//given
		final DurationTaskEngineProperty property = RuntimeConfigHolder.durationProperty("durationProperty", ChronoUnit.SECONDS,
				Duration.ofSeconds(60));
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(Collections.emptyMap());

		//when
		final Duration value = configHolder.getProperty(property);

		//then
		assertThat(value).isEqualByComparingTo(Duration.ofSeconds(60));

	}

	@Test
	public void shouldReturnDefaultIntegerProperty() throws Exception
	{
		//given
		final IntTaskEngineProperty property = RuntimeConfigHolder.intProperty("intProperty", 1);
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(Collections.emptyMap());

		//when
		final Integer value = configHolder.getProperty(property);

		//then
		assertThat(value).isEqualTo(1);

	}

	@Test
	public void shouldReturnDefaultStringProperty() throws Exception
	{
		//given
		final StringTaskEngineProperty property = RuntimeConfigHolder.stringParameter("stringProperty", "default");
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(Collections.emptyMap());

		//when
		final String value = configHolder.getProperty(property);

		//then
		assertThat(value).isEqualTo("default");

	}


	@Test
	public void shouldReturnDefaultDurationProperty() throws Exception
	{
		//given
		final DurationTaskEngineProperty property = RuntimeConfigHolder.durationProperty("durationProperty", ChronoUnit.SECONDS,
				Duration.ofSeconds(60));
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(ImmutableMap.of("durationProperty", "10"));

		//when
		final Duration value = configHolder.getProperty(property);

		//then
		assertThat(value).isEqualByComparingTo(Duration.ofSeconds(10));

	}

	@Test
	public void shouldReturnUpdatedIntegerProperty() throws Exception
	{
		//given
		final Map<String, String> mockConfig = new HashMap<>();
		final IntTaskEngineProperty property = RuntimeConfigHolder.intProperty("intProperty", 1);
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(mockConfig);
		mockConfig.put("intProperty", "10");

		//when
		final Integer firstValue = configHolder.getProperty(property);
		mockConfig.put("intProperty", "20");
		final Integer secondValue = configHolder.getProperty(property);
		mockConfig.remove("intProperty");
		final Integer thirdValue = configHolder.getProperty(property);

		//then
		assertThat(firstValue).isEqualTo(10);
		assertThat(secondValue).isEqualTo(20);
		assertThat(thirdValue).isEqualTo(1);

	}

	@Test
	public void shouldReturnUpdatedStringProperty() throws Exception
	{
		//given
		final StringTaskEngineProperty property = RuntimeConfigHolder.stringParameter("stringProperty", "default");
		final Map<String, String> mockConfig = new HashMap<>();
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(mockConfig);
		mockConfig.put("stringProperty", "foo");

		//when
		final String firstValue = configHolder.getProperty(property);
		mockConfig.put("stringProperty", "bar");
		final String secondValue = configHolder.getProperty(property);
		mockConfig.remove("stringProperty");
		final String thirdValue = configHolder.getProperty(property);

		//then
		assertThat(firstValue).isEqualTo("foo");
		assertThat(secondValue).isEqualTo("bar");
		assertThat(thirdValue).isEqualTo("default");

	}

	@Test
	public void shouldReturnUpdatedDurationProperty() throws Exception
	{
		//given
		final Map<String, String> mockConfig = new HashMap<>();
		final DurationTaskEngineProperty property = RuntimeConfigHolder.durationProperty("durationProperty", ChronoUnit.SECONDS,
				Duration.ofSeconds(60));
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(mockConfig);
		mockConfig.put("durationProperty", "10");

		//when
		final Duration firstValue = configHolder.getProperty(property);
		mockConfig.put("durationProperty", "20");
		final Duration secondValue = configHolder.getProperty(property);
		mockConfig.remove("durationProperty");
		final Duration thirdValue = configHolder.getProperty(property);

		//then
		assertThat(firstValue).isEqualByComparingTo(Duration.ofSeconds(10));
		assertThat(secondValue).isEqualByComparingTo(Duration.ofSeconds(20));
		assertThat(thirdValue).isEqualByComparingTo(Duration.ofSeconds(60));
	}

	@Test
	public void shouldEvaluateIntegerProperty() throws Exception
	{
		//given
		final IntTaskEngineProperty property = RuntimeConfigHolder.intProperty("intProperty", 1);
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(ImmutableMap.of("intProperty", "10 * #cores"), 5);
		setBackgroundProperties(configHolder);

		//when
		final Integer value = configHolder.getProperty(property);

		//then
		assertThat(value).isEqualTo(50);

		checkBackgroundProperties(configHolder);
	}

	@Test
	public void shouldEvaluateIntegerPropertyWhenWorkersNumberHasChanged() throws Exception
	{
		//given
		final IntTaskEngineProperty property = RuntimeConfigHolder.intProperty("intProperty", 1);
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(ImmutableMap.of("intProperty", "10 * #workers"));
		setBackgroundProperties(configHolder);

		//when
		final Integer firstValue = configHolder.getProperty(property, 2);
		final Integer secondValue = configHolder.getProperty(property, 4);

		//then
		assertThat(firstValue).isEqualTo(20);
		assertThat(secondValue).isEqualTo(40);

		checkBackgroundProperties(configHolder);
	}


	@Test
	public void shouldEvaluateAllPropertiesWhenWorkersNumberHasChanged() throws Exception
	{
		//given
		final IntTaskEngineProperty property = RuntimeConfigHolder.intProperty("intProperty", 1);
		final IntTaskEngineProperty otherProperty = RuntimeConfigHolder.intProperty("otherIntProperty", 2);
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(
				ImmutableMap.of("intProperty", "10 * #workers", "otherIntProperty", "100*#workers"));

		setBackgroundProperties(configHolder);

		//when
		final Integer firstValue = configHolder.getProperty(property, 2);
		final Integer firstOtherValue = configHolder.getProperty(otherProperty);
		final Integer secondValue = configHolder.getProperty(property, 4);
		final Integer secondOtherValue = configHolder.getProperty(otherProperty);

		//then
		assertThat(firstValue).isEqualTo(20);
		assertThat(secondValue).isEqualTo(40);
		assertThat(firstOtherValue).isEqualTo(200);
		assertThat(secondOtherValue).isEqualTo(400);

		checkBackgroundProperties(configHolder);
	}

	@Test
	public void shouldEvaluateAllPropertiesWhenDurationPropertyWorkersNumberHasChanged() throws Exception
	{
		//given
		final DurationTaskEngineProperty property = RuntimeConfigHolder.durationProperty("durationProperty", ChronoUnit.SECONDS,
				Duration.ofSeconds(60));
		final DurationTaskEngineProperty otherProperty = RuntimeConfigHolder.durationProperty("otherDurationProperty",
				ChronoUnit.SECONDS, Duration.ofSeconds(1));
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(
				ImmutableMap.of("durationProperty", "10 * #workers", "otherDurationProperty", "100*#workers"));

		setBackgroundProperties(configHolder);

		//when
		final Duration firstValue = configHolder.getProperty(property, 2);
		final Duration firstOtherValue = configHolder.getProperty(otherProperty);
		final Duration secondValue = configHolder.getProperty(property, 4);
		final Duration secondOtherValue = configHolder.getProperty(otherProperty);

		//then
		assertThat(firstValue).isEqualByComparingTo(Duration.ofSeconds(20));
		assertThat(secondValue).isEqualByComparingTo(Duration.ofSeconds(40));
		assertThat(firstOtherValue).isEqualByComparingTo(Duration.ofSeconds(200));
		assertThat(secondOtherValue).isEqualByComparingTo(Duration.ofSeconds(400));

		checkBackgroundProperties(configHolder);
	}

	@Test
	public void shouldReturnDefaultValueWhenOtherPropertyChangedNumberOfWorkers() throws Exception
	{
		//given
		final IntTaskEngineProperty property = RuntimeConfigHolder.intProperty("intProperty", 1);
		final IntTaskEngineProperty otherProperty = RuntimeConfigHolder.intProperty("otherIntProperty", 2);
		final RuntimeConfigHolder configHolder = new TestRuntimeConfigHolder(
				ImmutableMap.of("intProperty", "10 * #workers"));

		setBackgroundProperties(configHolder);

		//when
		final Integer firstValue = configHolder.getProperty(property, 2);
		final Integer firstOtherValue = configHolder.getProperty(otherProperty);
		final Integer secondValue = configHolder.getProperty(property, 4);
		final Integer secondOtherValue = configHolder.getProperty(otherProperty);

		//then
		assertThat(firstValue).isEqualTo(20);
		assertThat(secondValue).isEqualTo(40);
		assertThat(firstOtherValue).isEqualTo(2);
		assertThat(secondOtherValue).isEqualTo(2);

		checkBackgroundProperties(configHolder);


	}

	private void setBackgroundProperties(final RuntimeConfigHolder configHolder)
	{

		configHolder.getProperty(BACKGROUND_INT_PROPERTY);
		configHolder.getProperty(BACKGROUND_STRING_PROPERTY);
		configHolder.getProperty(BACKGROUND_DURATION_PROPERTY);

	}

	private void checkBackgroundProperties(final RuntimeConfigHolder configHolder)
	{
		assertThat(configHolder.getProperty(BACKGROUND_INT_PROPERTY)).isEqualTo(1);
		assertThat(configHolder.getProperty(BACKGROUND_STRING_PROPERTY)).isEqualTo("blah");
		assertThat(configHolder.getProperty(BACKGROUND_DURATION_PROPERTY)).isEqualByComparingTo(Duration.ofSeconds(5));
	}

	private static class TestRuntimeConfigHolder extends RuntimeConfigHolder
	{
		private final Map<String, String> mockConfig;
		private final int cores;

		private TestRuntimeConfigHolder(final Map<String, String> mockConfig)
		{
			this(mockConfig, 4);
		}

		private TestRuntimeConfigHolder(final Map<String, String> mockConfig, final int cores)
		{
			this.mockConfig = mockConfig;
			this.cores = cores;
		}


		@Override
		protected String getParameterFromConfig(final TaskEngineProperty<?> parameter)
		{
			return mockConfig.get(parameter.getName());
		}

		@Override
		protected Map<String, Object> getVariables(final int newNumberOfWorkers)
		{
			return ImmutableMap.of("workers", Integer.valueOf(newNumberOfWorkers), "cores", Integer.valueOf(cores));
		}
	}
}