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
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.price.DiscountModel;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.impl.DefaultCalculationService;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.util.DiscountValue;

import java.util.List;


/**
 * Strategy focuses on resolving {@link DiscountValue}s for the order (global discounts), or for the order entry.
 * Implement the interface and inject a list of such strategies into the {@link DefaultCalculationService} if you want
 * the order calculation process to take into account all the returned discounts.
 */
public interface FindDiscountValuesStrategy extends ServiceLayerOnlyCalculationVerifier
{
	/**
	 * Find applicable {@link DiscountValue}s for the target order entry.
	 *
	 * @param entry
	 * @return List of {@link DiscountValue}s
	 */
	List<DiscountValue> findDiscountValues(AbstractOrderEntryModel entry) throws CalculationException;

	/**
	 * Find applicable global {@link DiscountValue}s for the target order. They may originate from the current session's
	 * price factory or {@link DiscountModel}s directly attached to the target order.
	 *
	 * @param order
	 * @return List of {@link DiscountValue}s
	 */
	List<DiscountValue> findDiscountValues(AbstractOrderModel order) throws CalculationException;

	/**
	 * Get discounts {@link DiscountInformation}s for given criteria.
	 *
	 * @param baseCriteria
	 *           {@link BaseCriteria}
	 *
	 * @return the <code>List</code> of all {@link DiscountInformation}s which matching baseCriteria. If no matching
	 *         discounts were found, an empty collection is returned.
	 */
	default List<DiscountInformation> getDiscountInformation(final BaseCriteria baseCriteria) throws CalculationException
	{
		throw new UnsupportedOperationException("Not implemented");
	}
}
