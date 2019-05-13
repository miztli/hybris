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

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserNetCheckingStrategy;


/**
 * The default SL implementation of the {@link UserNetCheckingStrategy}.
 */
public class DefaultSLUserNetCheckingStrategy implements UserNetCheckingStrategy
{

	@Override
	public boolean isNetUser(final UserModel user)
	{
		return false;
	}

}
