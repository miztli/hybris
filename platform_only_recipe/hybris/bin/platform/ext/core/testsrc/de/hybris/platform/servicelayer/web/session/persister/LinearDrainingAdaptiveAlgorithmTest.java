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
package de.hybris.platform.servicelayer.web.session.persister;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class LinearDrainingAdaptiveAlgorithmTest extends ServicelayerBaseTest
{
	private final PropertyConfigSwitcher springSessionAsyncMaxItems = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_MAX_ITEMS);
	private final PropertyConfigSwitcher springSessionAsyncQueueSize = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_QUEUE_SIZE);
	private final PropertyConfigSwitcher springSessionAsyncAdaptiveAlg = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_USE_ADAPTIVE_ALGORITHM);
	private final PropertyConfigSwitcher springSessionAsyncAdaptiveMax = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_MAXRATIO_ADAPTIVE_ALGORITHM);
	private final PropertyConfigSwitcher springSessionAsyncAdaptiveThreshold = new PropertyConfigSwitcher(
			AsyncSessionPersister.SPRING_SESSION_SAVE_ASYNC_THRESHOLD_ADAPTIVE_ALGORITHM);

	private LinearDrainingAdaptiveAlgorithm linearDrainSizeStrategy;

	@Before
	public void setUp()
	{
		springSessionAsyncAdaptiveAlg.switchToValue("true");
		springSessionAsyncAdaptiveThreshold.switchToValue("20");
		springSessionAsyncAdaptiveMax.switchToValue("80");

		linearDrainSizeStrategy = getDrainSizeAdaptiveAlgorithm();
	}

	@After
	public void revertConfigs()
	{
		springSessionAsyncMaxItems.switchBackToDefault();
		springSessionAsyncQueueSize.switchBackToDefault();
		springSessionAsyncAdaptiveAlg.switchBackToDefault();
		springSessionAsyncAdaptiveMax.switchBackToDefault();
		springSessionAsyncAdaptiveThreshold.switchBackToDefault();
	}

	@Test
	public void testDrainSizeForQueue10AndMax2()
	{
		springSessionAsyncQueueSize.switchToValue("10");
		springSessionAsyncMaxItems.switchToValue("2");
		linearDrainSizeStrategy.init();

		assertThat(linearDrainSizeStrategy.getDrainSize(1)).isEqualTo(2);
		assertThat(linearDrainSizeStrategy.getDrainSize(2)).isEqualTo(2);
		assertThat(linearDrainSizeStrategy.getDrainSize(10)).isEqualTo(8);
	}

	@Test
	public void testDrainSizeForQueue150AndMax15()
	{
		springSessionAsyncQueueSize.switchToValue("150");
		springSessionAsyncMaxItems.switchToValue("15");
		linearDrainSizeStrategy.init();

		assertThat(linearDrainSizeStrategy.getDrainSize(10)).isEqualTo(15);
		assertThat(linearDrainSizeStrategy.getDrainSize(30)).isEqualTo(15);
		assertThat(linearDrainSizeStrategy.getDrainSize(70)).isEqualTo(64);
		assertThat(linearDrainSizeStrategy.getDrainSize(150)).isEqualTo(120);
	}

	@Test
	public void testShouldAdaptForQueue10AndMax2()
	{
		final LinearDrainingAdaptiveAlgorithm linearDrainSizeStrategy = getDrainSizeAdaptiveAlgorithm();

		springSessionAsyncQueueSize.switchToValue("10");
		springSessionAsyncMaxItems.switchToValue("2");
		linearDrainSizeStrategy.init();

		assertThat(linearDrainSizeStrategy.shouldAdapt(1, 20)).isEqualTo(false);
		assertThat(linearDrainSizeStrategy.shouldAdapt(3, 20)).isEqualTo(true);
		assertThat(linearDrainSizeStrategy.shouldAdapt(9, 20)).isEqualTo(true);
	}

	@Test
	public void testShouldAdaptForQueue150AndMax15()
	{
		springSessionAsyncQueueSize.switchToValue("150");
		springSessionAsyncMaxItems.switchToValue("15");
		linearDrainSizeStrategy.init();

		assertThat(linearDrainSizeStrategy.shouldAdapt(10, 20)).isEqualTo(false);
		assertThat(linearDrainSizeStrategy.shouldAdapt(31, 20)).isEqualTo(true);
		assertThat(linearDrainSizeStrategy.shouldAdapt(90, 20)).isEqualTo(true);
	}

	private LinearDrainingAdaptiveAlgorithm getDrainSizeAdaptiveAlgorithm()
	{
		final LinearDrainingAdaptiveAlgorithm linearDrainSizeStrategy = new LinearDrainingAdaptiveAlgorithm();
		linearDrainSizeStrategy.setTenant(Registry.getCurrentTenant());
		return linearDrainSizeStrategy;
	}
}
