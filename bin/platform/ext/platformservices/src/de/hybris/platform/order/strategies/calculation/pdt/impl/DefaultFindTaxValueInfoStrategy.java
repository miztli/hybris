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

import de.hybris.platform.europe1.constants.Europe1Constants;
import de.hybris.platform.europe1.model.TaxRowModel;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.FindPDTValueInfoStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.TaxValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


public class DefaultFindTaxValueInfoStrategy
		extends GenericPDTFindValueInfoStrategy<TaxValue, TaxInformation, TaxValueInfoCriteria, TaxRowModel>
{

	private FindPDTValueInfoStrategy<TaxValue, TaxInformation, TaxValueInfoCriteria> cachingFindTaxValueInfoStrategy;

	@Override
	public List<TaxValue> getPDTValues(final TaxValueInfoCriteria criteria) throws CalculationException
	{

		if (isCachingEnabled())
		{
			return cachingFindTaxValueInfoStrategy.getPDTValues(criteria);
		}
		return super.getPDTValues(criteria);
	}

	@Override
	public List<TaxInformation> getPDTInformation(final TaxValueInfoCriteria criteria) throws CalculationException
	{

		if (isCachingEnabled())
		{
			return cachingFindTaxValueInfoStrategy.getPDTInformation(criteria);
		}
		return super.getPDTInformation(criteria);
	}

	public static boolean isCachingEnabled()
	{
		return Config.getBoolean(Europe1Constants.KEY_CACHE_TAXES, true);
	}

	@Required
	public void setCachingFindTaxValueInfoStrategy(
			final FindPDTValueInfoStrategy<TaxValue, TaxInformation, TaxValueInfoCriteria> cachingFindTaxValueInfoStrategy)
	{
		this.cachingFindTaxValueInfoStrategy = cachingFindTaxValueInfoStrategy;
	}

}
