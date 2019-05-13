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
package de.hybris.platform.order.strategies.calculation;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.impl.FindPricingWithCurrentPriceFactoryStrategy;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.util.PriceValue;

import java.util.List;


/**
 * Strategy that focuses on resolving {@link PriceValue} for the given {@link AbstractOrderEntryModel}.
 */
public interface FindPriceStrategy extends ServiceLayerOnlyCalculationVerifier
{

	/**
	 * Resolves price value for the given {@link AbstractOrderEntryModel}. Please refer to
	 * {@link FindPricingWithCurrentPriceFactoryStrategy}, which resolves the price according to the current price factory.
	 *
	 * @param entry
	 *           {@link AbstractOrderEntryModel}
	 * @return {@link PriceValue}
	 */
	PriceValue findBasePrice(AbstractOrderEntryModel entry) throws CalculationException;

	/**
	 * Get prices information {@link PriceInformation} for given criteria.
	 *
	 * @param baseCriteria
	 *           {@link BaseCriteria}
	 *
	 * @return the <code>List</code> of all {@link PriceInformation}s which matching baseCriteria. If no matching prices
	 *         were found, an empty collection is returned.
	 */
	default List<PriceInformation> getPriceInformation(final BaseCriteria baseCriteria) throws CalculationException
	{
		throw new UnsupportedOperationException("Not implemented");
	}
}
