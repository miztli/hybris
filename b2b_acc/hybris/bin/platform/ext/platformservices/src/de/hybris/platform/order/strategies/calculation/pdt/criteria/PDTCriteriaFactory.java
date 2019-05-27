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

package de.hybris.platform.order.strategies.calculation.pdt.criteria;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.product.BaseCriteria;

/**
 * PDTCriteriaFactory creates appropriate Criteria objects that are used by {@link de.hybris.platform.order.strategies.calculation.pdt.FindPDTValueInfoStrategy}
 */
public interface PDTCriteriaFactory
{
	/**
	 * Creates TaxValueInfoCriteria from AbstractOrderEntryModel
	 * @param orderEntry
	 * @return criteria based on the AbstractOrderEntryModel
	 * @throws CalculationException
	 */
	TaxValueInfoCriteria taxValueCriteriaFromOrderEntry(AbstractOrderEntryModel orderEntry) throws CalculationException;

	/**
	 * Creates TaxValueInfoCriteria from BaseCriteria
	 * @param baseCriteria
	 * @return criteria based on BaseCriteria
	 * @throws CalculationException
	 */
	TaxValueInfoCriteria taxInfoCriteriaFromPriceCriteria(BaseCriteria baseCriteria) throws CalculationException;

	/**
	 * Creates DiscountValueInfoCriteria from AbstractOrderModel
	 * @param order
	 * @return criteria based on the AbstractOrderModel
	 * @throws CalculationException
	 */
	DiscountValueInfoCriteria discountValueCriteriaFromOrder(AbstractOrderModel order) throws CalculationException;

	/**
	 * Creates DiscountValueInfoCriteria from AbstractOrderEntryModel
	 * @param orderEntry
	 * @return criteria based on the AbstractOrderEntryModel
	 * @throws CalculationException
	 */
	DiscountValueInfoCriteria discountValueCriteriaFromOrderEntry(AbstractOrderEntryModel orderEntry) throws CalculationException;

	/**
	 * Creates DiscountValueInfoCriteria from BaseCriteria
	 * @param baseCriteria
	 * @return criteria based on the BaseCriteria
	 * @throws CalculationException
	 */
	DiscountValueInfoCriteria discountInfoCriteriaFromBaseCriteria(BaseCriteria baseCriteria) throws CalculationException;

	/**
	 * Creates PriceValueInfoCriteria from AbstractOrderEntryModel
	 * @param orderEntry
	 * @return criteria based on the AbstractOrderEntryModel
	 * @throws CalculationException
	 */
	PriceValueInfoCriteria priceValueCriteriaFromOrderEntry(AbstractOrderEntryModel orderEntry) throws CalculationException;

	/**
	 * Creates PriceValueInfoCriteria from BaseCriteria
	 * @param baseCriteria
	 * @return criteria based on the BaseCriteria
	 * @throws CalculationException
	 */
	PriceValueInfoCriteria priceInfoCriteriaFromBaseCriteria(BaseCriteria baseCriteria) throws CalculationException;
}
