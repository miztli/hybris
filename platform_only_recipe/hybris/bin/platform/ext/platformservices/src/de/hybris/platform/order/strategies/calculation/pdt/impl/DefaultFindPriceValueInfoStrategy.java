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
package de.hybris.platform.order.strategies.calculation.pdt.impl;

import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.util.PriceValue;
import de.hybris.platform.util.localization.Localization;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.ImmutableList;


public class DefaultFindPriceValueInfoStrategy
		extends GenericPDTFindValueInfoStrategy<PriceValue, PriceInformation, PriceValueInfoCriteria, PriceRowModel>
{

	@Override
	public List<PriceValue> getPDTValues(final PriceValueInfoCriteria criteria) throws CalculationException
	{
		final boolean giveAwayMode = criteria.isGiveAwayMode();
		final boolean entryIsRejected = criteria.isEntryRejected();

		List<PriceValue> filteredCollection = null;

		if (shouldFindPrice(giveAwayMode, entryIsRejected))
		{
			filteredCollection = super.getPDTValues(criteria);
		}

		if (CollectionUtils.isNotEmpty(filteredCollection))
		{
			return filteredCollection;
		}
		else if (criteria.isGiveAwayMode())
		{
			return ImmutableList.of(createPriceValue(criteria, 0.0));
		}
		else
		{
			throw new CalculationException(getExceptionMessage(criteria));
		}
	}

	private static boolean shouldFindPrice(final boolean giveAwayMode, final boolean entryIsRejected)
	{
		return !(giveAwayMode && entryIsRejected);
	}

	private static PriceValue createPriceValue(final PriceValueInfoCriteria criteria, final double value)
	{
		return new PriceValue(criteria.getCurrency().getIsocode(), value, criteria.isNet().booleanValue());
	}

	private static String getExceptionMessage(final PriceValueInfoCriteria criteria)
	{
		return Localization.getLocalizedString("exception.europe1pricefactory.getbaseprice.jalopricefactoryexception1", new Object[]
		{ criteria.getProduct(), criteria.getProductGroup(), criteria.getUser(), criteria.getUserGroup(),
				Long.toString(criteria.getQuantity()), criteria.getUnit(), criteria.getCurrency(), criteria.getDate(),
				Boolean.toString(criteria.isNet()) });
	}


}
