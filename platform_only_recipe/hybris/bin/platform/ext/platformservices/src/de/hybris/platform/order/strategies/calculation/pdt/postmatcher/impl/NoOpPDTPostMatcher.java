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
package de.hybris.platform.order.strategies.calculation.pdt.postmatcher.impl;

import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.postmatcher.PDTPostMatcher;

import java.util.Collection;


/**
 * This post matcher does nothing
 */
public class NoOpPDTPostMatcher implements PDTPostMatcher
{

	@Override
	public Collection process(final Collection models, final PDTCriteria criteria) throws CalculationException
	{
		return models;
	}

}
