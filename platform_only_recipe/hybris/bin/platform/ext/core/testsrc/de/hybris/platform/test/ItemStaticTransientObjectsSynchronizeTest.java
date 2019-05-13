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
package de.hybris.platform.test;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.ComposedType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;


@UnitTest
public class ItemStaticTransientObjectsSynchronizeTest
{
	private static final List<String> keys = Arrays.asList("a", "b", "c", "d", "e");
	private static final int SIZE = 10000;

	private final NullPKEmptyItem item = new NullPKEmptyItem();

	@Test
	public void shouldNotThrowIllegalStateExceptionWhenConcurrentHeavyMapPutOperationsAreMade() throws InterruptedException
	{
		final ExecutorService pool = Executors.newFixedThreadPool(500);

		final de.hybris.platform.jalo.Item a = new MockLRUSynchronizedMapItem("mock1");
		final de.hybris.platform.jalo.Item b = new MockLRUSynchronizedMapItem("mock2");

		final CountDownLatch latch = new CountDownLatch(2 * SIZE);
		final AtomicBoolean exceptionWasThrown = new AtomicBoolean(false);

		for (int i = 0; i < SIZE; i++)
		{
			final int x = i;

			pool.execute(() -> executeProcedure(latch, exceptionWasThrown,
					() -> a.setTransientObject(keys.get(x % keys.size()), x % 6 == 0 ? null : x)));

			pool.execute(
					() -> executeProcedure(latch, exceptionWasThrown,
					() -> b.setTransientObject(keys.get(x % keys.size()), x)));
		}

		latch.await();
		pool.shutdown();

		Assertions.assertThat(exceptionWasThrown.get()).isFalse();
	}

	@Test
	public void shouldCreateMappingForGivenItemPK()
	{
		Assertions.assertThat(item.getTransientObject(keys.get(0))).isNull();
		Assertions.assertThat(item.getTransientObjectMap()).isNotNull().isEmpty();

		item.setTransientObject(keys.get(0), "someValue");

		Assertions.assertThat(item.getTransientObject(keys.get(0))).isEqualTo("someValue");
	}

	@Test
	public void shouldRemoveMappingForGivenItemPK()
	{
		Assertions.assertThat(item.getTransientObject(keys.get(0))).isNull();
		Assertions.assertThat(item.getTransientObjectMap()).isNotNull().isEmpty();

		item.setTransientObject(keys.get(0), "someValue");
		item.setTransientObject(keys.get(0), null);

		Assertions.assertThat(item.getTransientObject(keys.get(0))).isNull();
	}


	private void executeProcedure(final CountDownLatch latch, final AtomicBoolean exceptionThrown, final Procedure procedure)
	{
		try
		{
			procedure.invoke();
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			exceptionThrown.set(true);
		}
		finally
		{
			latch.countDown();
		}
	}
}

@FunctionalInterface
interface Procedure
{
	void invoke();
}

class NullPKEmptyItem extends Item
{
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes)
			throws JaloBusinessException
	{
		return null;
	}

	@Override
	public de.hybris.platform.core.PK getPK()
	{
		return de.hybris.platform.core.PK.NULL_PK;
	}
}

class MockLRUSynchronizedMapItem extends de.hybris.platform.jalo.Item
{
	private static final Logger LOG = LoggerFactory.getLogger(MockLRUSynchronizedMapItem.class);


	protected static final ConcurrentMap<String, Map<String, Object>> staticTransientObjects = CacheBuilder.newBuilder()
			.maximumSize(3).<String, Map<String, Object>> build().asMap();

	final String name;

	public MockLRUSynchronizedMapItem(final String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}

	@Override
	protected de.hybris.platform.jalo.Item createItem(final SessionContext ctx, final ComposedType type,
			final ItemAttributeMap allAttributes)
	{
		return null;
	}

	@Override
	public void setTransientObject(final String key, final Object value)
	{
		LOG.debug(this.toString() + " started " + key + "--" + value);
		while (true)
		{
			final ConcurrentMap<String, Object> oldMap = (ConcurrentMap<String, Object>) staticTransientObjects.get(key);
			final ConcurrentMap<String, Object> newMap = (oldMap == null) ? new ConcurrentHashMap<>()
					: new ConcurrentHashMap<>(oldMap);

			if (value == null)
			{
				newMap.remove(key);
			}
			else
			{
				newMap.put(key, value);
			}

			if (newMap.isEmpty() && oldMap == null){
				LOG.debug(this.toString() + " Key: " + key + " value: null and oldMap null");
				return;
			}

			if (newMap.isEmpty() && staticTransientObjects.remove(key, oldMap))
			{
				LOG.debug(this.toString() + " Key: " + key + " removed with value: " + newMap);
				return;
			}

			if (oldMap == null && staticTransientObjects.putIfAbsent(key, newMap) == null)
			{
				LOG.debug(this.toString() + " Key: " + key + " added with value: " + newMap);
				return;
			}

			if (oldMap != null && staticTransientObjects.replace(key, oldMap, newMap))
			{
				LOG.debug(this.toString() + " Key: " + key + " replaced with value: " + newMap);
				return;
			}
			LOG.debug(this.toString() + " race occurred for key: " + key);
		}
	}

	@Override
	public Object getTransientObject(final String key)
	{
		final Map<String, Object> transientObjects = staticTransientObjects.get(key);
		if (transientObjects == null)
		{
			return null;
		}
		return transientObjects.get(key);
	}
}