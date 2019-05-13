/*
 * [y] hybris Platform
 *
 * Copyright (c) {year} SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.platform.servicelayer.internal;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.LoggerFactory;


public class LogUtil
{
	private static final Set<Integer> LOGGED_MESSAGES = ConcurrentHashMap.newKeySet();

	private LogUtil()
	{
	}

	public static void infoOnce(final Class clazz, final Integer messageId, final String message)
	{
		if (LOGGED_MESSAGES.add(messageId))
		{
			LoggerFactory.getLogger(clazz).info(message);
		}
	}
}
