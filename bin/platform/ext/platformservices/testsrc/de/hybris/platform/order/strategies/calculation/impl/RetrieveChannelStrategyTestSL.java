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
package de.hybris.platform.order.strategies.calculation.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.europe1.channel.strategies.RetrieveChannelStrategy;
import de.hybris.platform.europe1.enums.PriceRowChannel;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.session.SessionService;

import javax.annotation.Resource;

import org.junit.Test;


@IntegrationTest
public class RetrieveChannelStrategyTestSL extends ServicelayerTest
{
	@Resource
	private RetrieveChannelStrategy retrieveChannelStrategy;

	@Resource
	private SessionService sessionService;

	protected static final String DETECTED_UI_EXPERIENCE_LEVEL = "UiExperienceService-Detected-Level";
	protected static final String CHANNEL = "channel";

	@Test
	public void testGetChannelForNullContext()
	{
		final SessionContext ctx = null;
		final PriceRowChannel channel = getChannelStrategySL().getChannel(ctx);
		assertNull(channel);
	}

	@Test
	public void testGetChannelForNullUIExpLevelContextSL()
	{
		final SessionContext ctx = JaloSession.getCurrentSession().getSessionContext();
		final PriceRowChannel channel = getChannelStrategySL().getChannel(ctx);
		assertNull(channel);
	}

	@Test
	public void testGetChannelForNullChannelContextSL()
	{
		final SessionContext ctx = JaloSession.getCurrentSession().getSessionContext();
		final PriceRowChannel desktopEnumUIExpLevel = PriceRowChannel.valueOf("desktop");
		sessionService.setAttribute(DETECTED_UI_EXPERIENCE_LEVEL, desktopEnumUIExpLevel);
		final PriceRowChannel channel = getChannelStrategySL().getChannel(ctx);
		assertNotNull(channel);
		assertEquals(desktopEnumUIExpLevel.getCode(), channel.getCode());
	}

	@Test
	public void testGetChannelForValidChannelContextSL()
	{
		final SessionContext ctx = JaloSession.getCurrentSession().getSessionContext();
		final PriceRowChannel desktopEnumUIExpLevel = PriceRowChannel.valueOf("desktop");
		sessionService.setAttribute(DETECTED_UI_EXPERIENCE_LEVEL, desktopEnumUIExpLevel);
		sessionService.setAttribute(CHANNEL, PriceRowChannel.DESKTOP);
		final PriceRowChannel channel = getChannelStrategySL().getChannel(ctx);
		assertNotNull(channel);
		assertEquals(PriceRowChannel.DESKTOP.getCode(), channel.getCode());
	}

	public RetrieveChannelStrategy getChannelStrategySL()
	{
		return retrieveChannelStrategy;
	}

}
