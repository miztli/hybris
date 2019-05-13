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
package de.hybris.platform.order;

import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.price.DiscountModel;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.impl.DefaultDiscountService;
import de.hybris.platform.servicelayer.internal.LogUtil;
import de.hybris.platform.product.BaseCriteria;

import java.util.Collection;
import java.util.List;


/**
 * Service around the {@link DiscountModel}.
 * <p>
 * There are different kinds of discounts: absolute or relative, and global and non-global. Absolute discounts contain a
 * real price value (price and currency), whereas relative discounts are discounts in percent. Global discounts are
 * applied on order level, which means that they can not be applied to a single entry. Non-global discounts are only
 * applicable on entry - level.
 * <p/>
 * <i> Since all price calculation is done be the currently installed pricefactory refer to it for maybe differing
 * behavior. </i>
 *
 * @spring.bean discountService
 */
public interface DiscountService
{

	/**
	 * Gets the {@link DiscountModel} with the specified code.
	 *
	 * @param code
	 *           the discount code
	 * @return the found {@link DiscountModel} with the specified code
	 */
	DiscountModel getDiscountForCode(String code);

	/**
	 * Gets all {@link DiscountModel}s which match the specified code.
	 *
	 * @param matchedCode
	 *           an SQL-Like statement as String, such as <b>%discountCode%</b>
	 * @return the <code>Collection</code> of all {@link DiscountModel}s which match the specified code
	 */
	Collection<DiscountModel> getDiscountsForCode(String matchedCode);

	/**
	 * Gets all {@link DiscountModel}s which match the specified currency.
	 *
	 * @param currency
	 *           target {@link CurrencyModel}
	 * @return the <code>Collection</code> of all {@link DiscountModel}s which matching currency. If no matching discounts
	 *         were found, an empty collection is returned.
	 *
	 * @throws IllegalArgumentException
	 *            if currency is null
	 *
	 */
	Collection<DiscountModel> getDiscountsForCurrency(CurrencyModel currency);

	/**
	 * Get discounts {@link DiscountInformation}s for given criteria.
	 *
	 * @param baseCriteria
	 *           {@link BaseCriteria}
	 * @return the <code>List</code> of all {@link DiscountInformation}s which matching baseCriteria. If no matching
	 *         discounts were found, an empty collection is returned.
	 * @throws CalculationException
	 *            if error occurred
	 */
	default List<DiscountInformation> getDiscountInformation(final BaseCriteria baseCriteria) throws CalculationException
	{
		LogUtil.infoOnce(DiscountService.class, 20,
				"The method getDiscountInformation(final BaseCriteria baseCriteria) is not implemented, using the defaultDiscountService as fallback.");

		return Registry.getApplicationContext().getBean("defaultDiscountService", DefaultDiscountService.class)
				.getDiscountInformation(baseCriteria);
	}
}
