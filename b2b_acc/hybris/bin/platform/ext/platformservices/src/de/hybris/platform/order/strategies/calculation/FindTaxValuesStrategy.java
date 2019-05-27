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
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.util.TaxValue;

import java.util.Collection;
import java.util.List;


/**
 * Strategy focused on finding {@link TaxValue}s for the given order entry.
 */
public interface FindTaxValuesStrategy extends ServiceLayerOnlyCalculationVerifier
{
	/**
	 * Resolves tax value for the given {@link AbstractOrderEntryModel} basing on the underlying implementation.
	 *
	 * @param entry
	 *           {@link AbstractOrderEntryModel}
	 * @return collection of {@link TaxValue}s
	 */
	Collection<TaxValue> findTaxValues(AbstractOrderEntryModel entry) throws CalculationException;


	/**
	 * Get taxes information {@link TaxInformation} for given criteria.
	 *
	 * @param baseCriteria
	 *           {@link BaseCriteria}
	 *
	 * @return the <code>List</code> of all {@link TaxInformation}s which matching baseCriteria. If no matching taxes were
	 *         found, an empty collection is returned.
	 */
	default List<TaxInformation> getTaxInformation(final BaseCriteria baseCriteria) throws CalculationException
	{
		throw new UnsupportedOperationException("Not implemented");
	}
}
