/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.bootstrap.loader.metrics;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.bootstrap.loader.metrics.internal.ClasspathEfficiencyEvaluator;
import de.hybris.bootstrap.loader.metrics.internal.ResourceInfo;

import java.util.List;
import java.util.Map;

import de.hybris.bootstrap.loader.metrics.internal.YURLClasspathProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


@UnitTest
public class ClassLoaderMetricRegistryTest
{
	private ClassLoaderMetricRegistry metricRegistry;

	private final ResourceInfo fooClassFromSourceJar = new ResourceInfo("com.foo", "source.jar", "classloader",
			ResourceType.CLASS);

	private final ResourceInfo barClassFromSourceJar = new ResourceInfo("com.bar", "source.jar", "classloader",
			ResourceType.CLASS);

	private final ResourceInfo bazClassFromBazingaJar = new ResourceInfo("com.baz", "bazinga.jar", "classloader",
			ResourceType.CLASS);

	private final ResourceInfo fooResource = new ResourceInfo("fooResource", "bazinga.jar", "classloader",
			ResourceType.RESOURCE);


	@Before
	public void setup()
	{
		final YURLClasspathProvider mock = Mockito.mock(YURLClasspathProvider.class);
		Mockito.when(mock.getClasspath()).thenReturn(ImmutableList.of("source.jar", "bazinga.jar"));

		metricRegistry = new ClassLoaderMetricRegistry(new ClasspathEfficiencyEvaluator(), mock);
	}

	@Test
	public void shouldRecordClassLoaderMetricEvents()
	{
		// given
		final ClassLoaderMetricEvent foundEvent = buildEvent(fooClassFromSourceJar, EventType.FOUND_ON_CLASSPATH);
		final ClassLoaderMetricEvent notFoundEvent = buildEvent(fooClassFromSourceJar, EventType.NOT_FOUND_ON_CLASSPATH);

		// when
		publishEvents(notFoundEvent, notFoundEvent, foundEvent);

		// then
		final List<ClassLoaderMetric> metrics = metricRegistry.findMetrics(MetricQueryCriteria.FIND_ALL);

		assertThat(metrics).hasSize(1);

		final ClassLoaderMetric metric = metrics.get(0);

		assertThat(metric.getName()).isEqualTo(fooClassFromSourceJar.getName());
		assertThat(metric.getClassloader()).isEqualTo(fooClassFromSourceJar.getClassLoader());
		assertThat(metric.getSource()).isEqualTo(fooClassFromSourceJar.getLocation());
		assertThat(metric.getResourceType()).isEqualTo(fooClassFromSourceJar.getType());

		final Map<EventType, Integer> eventTypeCount = metric.getEventTypeCount();
		assertThat(eventTypeCount.get(EventType.FOUND_ON_CLASSPATH)).isEqualTo(1);
		assertThat(eventTypeCount.get(EventType.NOT_FOUND_ON_CLASSPATH)).isEqualTo(2);
	}

	@Test
	public void shouldOrderMetrics()
	{
		// given
		final ClassLoaderMetricEvent fooNotFound = buildEvent(fooClassFromSourceJar, EventType.NOT_FOUND_ON_CLASSPATH);
		final ClassLoaderMetricEvent barNotFound = buildEvent(barClassFromSourceJar, EventType.NOT_FOUND_ON_CLASSPATH);
		final ClassLoaderMetricEvent bazNotFound = buildEvent(bazClassFromBazingaJar, EventType.NOT_FOUND_ON_CLASSPATH);
		final ClassLoaderMetricEvent bazFound = buildEvent(bazClassFromBazingaJar, EventType.FOUND_ON_CLASSPATH);

		// when
		publishEvents(fooNotFound, fooNotFound, fooNotFound);
		publishEvents(barNotFound, barNotFound);
		publishEvents(bazNotFound, bazFound);

		// then
		final List<ClassLoaderMetric> metricsByNotFoundAscending = metricRegistry
				.findMetrics(MetricQueryCriteria.query().forEventType(EventType.NOT_FOUND_ON_CLASSPATH).sortAsc().build());

		final List<ClassLoaderMetric> metricsByNotFoundDescending = metricRegistry
				.findMetrics(MetricQueryCriteria.query().forEventType(EventType.NOT_FOUND_ON_CLASSPATH).sortDesc().build());

		assertThat(metricsByNotFoundAscending).extracting(i -> i.getName()).containsExactly(bazNotFound.getName(),
				barNotFound.getName(), fooNotFound.getName());

		assertThat(metricsByNotFoundDescending).extracting(i -> i.getName()).containsExactly(fooNotFound.getName(),
				barNotFound.getName(), bazNotFound.getName());
	}


	@Test
	public void shouldFindSelectedResourceType()
	{
		// given
		final ClassLoaderMetricEvent fooNotFound = buildEvent(fooClassFromSourceJar, EventType.NOT_FOUND_ON_CLASSPATH);
		final ClassLoaderMetricEvent barNotFound = buildEvent(barClassFromSourceJar, EventType.NOT_FOUND_ON_CLASSPATH);

		final ClassLoaderMetricEvent fooResourceFound = buildEvent(fooResource, EventType.FOUND_ON_CLASSPATH);

		publishEvents(fooNotFound, fooNotFound, barNotFound, fooResourceFound);

		// when
		final List<ClassLoaderMetric> classMetrics = metricRegistry.findMetrics(MetricQueryCriteria.query().forResourceType(ResourceType.CLASS).build());
		final List<ClassLoaderMetric> resourceMetrics = metricRegistry.findMetrics(MetricQueryCriteria.query().forResourceType(ResourceType.RESOURCE).build());
		final List<ClassLoaderMetric> allMetrics = metricRegistry.findMetrics(MetricQueryCriteria.query().build());

		// then
		assertThat(classMetrics).hasSize(2);
		assertThat(resourceMetrics).hasSize(1);
		assertThat(allMetrics).hasSize(3);
	}


	private void publishEvents(final ClassLoaderMetricEvent... events)
	{
		for (final ClassLoaderMetricEvent event : events)
		{
			metricRegistry.onEvent(event);
		}
	}


	private ClassLoaderMetricEvent buildEvent(final ResourceInfo resource, final EventType foundOnClasspath)
	{
		return ClassLoaderMetricEvent.forType(resource.getType()) //
				.withName(resource.getName()) //
				.withClassloader(resource.getClassLoader()) //
				.withSource(resource.getLocation()) //
				.ofEventType(foundOnClasspath) //
				.build();
	}
}
