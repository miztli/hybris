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
package de.hybris.platform.order.strategies.calculation.impl.servicelayer;

import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.europe1.channel.strategies.RetrieveChannelStrategy;
import de.hybris.platform.europe1.enums.PriceRowChannel;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.servicelayer.session.SessionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


public class DefaultSLRetrieveChannelStrategy implements RetrieveChannelStrategy
{

	private static final String CHANNEL = "channel";
	private static final String DETECTED_UI_EXPERIENCE_LEVEL = "UiExperienceService-Detected-Level";
	private EnumerationService enumerationService;
	private SessionService sessionService;

	@Override
	public PriceRowChannel getChannel(final SessionContext sessionContext)
	{
		PriceRowChannel priceRowChannel = null;
		if (sessionService.getAttribute(DETECTED_UI_EXPERIENCE_LEVEL) == null)
		{
			//If the channel is null, the client caller will treat this as default price row.
			return null;
		}
		else
		{
			priceRowChannel = sessionService.getAttribute(CHANNEL);
			if (priceRowChannel == null)
			{
				final Object priceRowChannelObject = sessionService.getAttribute(DETECTED_UI_EXPERIENCE_LEVEL);
				if (priceRowChannelObject instanceof PriceRowChannel)
				{
					priceRowChannel = (PriceRowChannel) priceRowChannelObject;
					sessionService.setAttribute(CHANNEL, priceRowChannel);
				}
			}
		}
		return priceRowChannel;
	}

	@Override
	public List<PriceRowChannel> getAllChannels()
	{
		return enumerationService.getEnumerationValues(PriceRowChannel._TYPECODE);
	}

	@Required
	public void setEnumerationService(final EnumerationService enumerationService)
	{
		this.enumerationService = enumerationService;
	}

	@Required
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}
}
