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

package de.hybris.bootstrap.loader.metrics.internal;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.bootstrap.loader.metrics.ClasspathLocationUsage;
import de.hybris.bootstrap.loader.metrics.ClasspathReorderingResult;
import de.hybris.bootstrap.loader.metrics.EventType;
import de.hybris.bootstrap.loader.metrics.ResourceType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;


@UnitTest
public class ClasspathEfficiencyEvaluatorTest
{
	private ClasspathEfficiencyEvaluator classpathEfficiencyEvaluator;
	private Map<String, ResourceInfo> resourceInfoMap;

	@Before
	public void setup()
	{
		classpathEfficiencyEvaluator = new ClasspathEfficiencyEvaluator();
		resourceInfoMap = new HashMap<>();
	}

	@Test
	public void shouldCalculateClasspathUsage()
	{
		registerClassInLocation("jar1_available", "jar1.jar");
		registerClassInLocation("jar1_available2", "jar1.jar");
		registerClassInLocation("jar2_available", "jar2.jar");
		registerClassInLocation("jar1_not_available", "jar1.jar");

		final Map<EventCounterKey, LongAdder> events = new HashMap<>();
		events.put(new EventCounterKey("jar1_available", EventType.FOUND_ON_CLASSPATH), asAdder(1));
		events.put(new EventCounterKey("jar1_available2", EventType.FOUND_ON_CLASSPATH), asAdder(1));
		events.put(new EventCounterKey("jar2_available", EventType.FOUND_ON_CLASSPATH), asAdder(1));
		events.put(new EventCounterKey("jar1_not_available", EventType.NOT_FOUND_ON_CLASSPATH), asAdder(1));

		final List<ClasspathLocationUsage> classpathLocationUsages = classpathEfficiencyEvaluator.findLoadedByLocation(events,
				resourceInfoMap);

		assertThat(classpathLocationUsages).hasSize(2);
		assertThat(classpathLocationUsages).extracting(i -> i.getUsage()).containsExactly(2, 1);
		assertThat(classpathLocationUsages).extracting(i -> i.getLocation()).containsExactly("jar1.jar", "jar2.jar");
	}

	@Test
	public void shouldCalculateTraversalCost()
	{
		// given
		registerClassInLocation("jar1_available", "jar1.jar");
		registerClassInLocation("jar1_not_available", "jar1.jar");

		final Map<EventCounterKey, LongAdder> events = new HashMap<>();
		events.put(new EventCounterKey("jar1_available", EventType.FOUND_ON_CLASSPATH), asAdder(1));

		// when
		final int costWithoutMiss = classpathEfficiencyEvaluator.calculateTraversalCost(events, resourceInfoMap,
				ImmutableList.of("jar1.jar", "jar2.jar"));

		// then
		assertThat(costWithoutMiss).isEqualTo(0);

		// and when
		events.put(new EventCounterKey("jar1_not_available", EventType.NOT_FOUND_ON_CLASSPATH), asAdder(1));
		final int costWithMiss = classpathEfficiencyEvaluator.calculateTraversalCost(events, resourceInfoMap,
				ImmutableList.of("jar1.jar", "jar2.jar"));

		// then
		assertThat(costWithMiss).isEqualTo(2);
	}

	@Test
	public void shouldCalculateTraversalCostForResourcesLaterInClasspath()
	{
		// given
		registerClassInLocation("jar1_available", "jar1.jar");
		registerClassInLocation("jar2_available", "jar2.jar");

		final Map<EventCounterKey, LongAdder> events = new HashMap<>();
		events.put(new EventCounterKey("jar2_available", EventType.FOUND_ON_CLASSPATH), asAdder(1));

		// when
		final int costWithoutMiss = classpathEfficiencyEvaluator.calculateTraversalCost(events, resourceInfoMap,
				ImmutableList.of("jar1.jar", "jar2.jar"));

		// then
		assertThat(costWithoutMiss).isEqualTo(1);
	}

	@Test
	public void shouldReorderClasspath()
	{
		// given
		registerClassInLocation("jar1_available", "jar1.jar");
		registerClassInLocation("jar2_available", "jar2.jar");
		registerClassInLocation("jar2_available2", "jar2.jar");

		final Map<EventCounterKey, LongAdder> events = new HashMap<>();
		events.put(new EventCounterKey("jar2_available", EventType.FOUND_ON_CLASSPATH), asAdder(1));
		events.put(new EventCounterKey("jar2_available2", EventType.FOUND_ON_CLASSPATH), asAdder(1));
		events.put(new EventCounterKey("jar1_available", EventType.FOUND_ON_CLASSPATH), asAdder(1));

		final ClasspathReorderingResult reorderingResult = classpathEfficiencyEvaluator.reorderClasspath(ImmutableList.of("jar1.jar", "jar2.jar"), events, resourceInfoMap);
		assertThat(reorderingResult.getClasspath()).containsExactly("jar1.jar", "jar2.jar");
		assertThat(reorderingResult.getClasspathTraversalCost()).isEqualTo(2);

		assertThat(reorderingResult.getOptimizedClasspath()).containsExactly("jar2.jar", "jar1.jar");
		assertThat(reorderingResult.getOptimizedClasspathTraversalCost()).isEqualTo(1);
	}

	private LongAdder asAdder(final long i)
	{
		final LongAdder adder = new LongAdder();
		adder.add(i);
		return adder;
	}


	private void registerClassInLocation(final String clazz, final String location)
	{
		resourceInfoMap.put(clazz, new ResourceInfo(clazz, location, "classloader", ResourceType.CLASS));
	}
}
