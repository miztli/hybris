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

package de.hybris.platform.order.strategies.calculation.pdt.comparator;

import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.matcher.impl.GenericPDTModelMatcher;

import java.util.Comparator;


/**
 * The Interface for provide price/discount/tax comparator for {@link GenericPDTModelMatcher}.
 *
 * @param <CRITERIA>
 *           the generic type for price/discount/tax criteria.
 * @param <MODEL>
 *           the generic type for price/discount/tax row models.
 */
public interface PDTRowMatchComparatorProvider<CRITERIA extends PDTCriteria, MODEL extends PDTRowModel>
{

	/**
	 * Compares price/discount/tax row models for given criteria.
	 *
	 * @param criteria
	 *           the price/discount/tax criteria.
	 * @return the price/discount/tax row model comparator.
	 */
	Comparator<MODEL> comparator(CRITERIA criteria);
}
