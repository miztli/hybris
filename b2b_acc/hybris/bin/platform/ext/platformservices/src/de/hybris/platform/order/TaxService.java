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
import de.hybris.platform.core.model.order.price.TaxModel;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.impl.DefaultTaxService;
import de.hybris.platform.servicelayer.internal.LogUtil;
import de.hybris.platform.product.BaseCriteria;

import java.util.Collection;
import java.util.List;


/**
 * Service around the {@link TaxModel}.
 *
 * @spring.bean taxService
 */
public interface TaxService
{

	/**
	 * Gets the {@link TaxModel} with the specified unique {@link TaxModel#CODE}.
	 *
	 * @param code
	 *           the tax code
	 * @return the found {@link TaxModel} with the specified code
	 * @throws de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException
	 *            when no tax found.
	 */
	TaxModel getTaxForCode(String code);

	/**
	 * Gets all {@link TaxModel}s which match the specified code.
	 *
	 * @param matchedCode
	 *           an SQL-Like statement as String, such as <b>%taxCode%</b>
	 * @return the <code>Collection</code> of all {@link TaxModel}s which match the specified code
	 */
	Collection<TaxModel> getTaxesForCode(String matchedCode);

	/**
	 * Get taxes information {@link TaxInformation} for given criteria.
	 *
	 * @param baseCriteria
	 *           {@link BaseCriteria}
	 * @return the <code>List</code> of all {@link TaxInformation}s which matching baseCriteria. If no matching discounts
	 *         were found, an empty collection is returned.
	 * @throws CalculationException
	 *            if error occurred
	 */
	default List<TaxInformation> getTaxInformation(final BaseCriteria baseCriteria) throws CalculationException
	{
		LogUtil.infoOnce(TaxService.class, 30,
				"The method getTaxInformation(final BaseCriteria priceCriteria) is not implemented, using the defaultTaxService as fallback.");

		return Registry.getApplicationContext().getBean("defaultTaxService", DefaultTaxService.class)
				.getTaxInformation(baseCriteria);
	}
}
