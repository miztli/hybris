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

package de.hybris.platform.order.strategies.calculation.pdt.repository;

import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.matcher.impl.GenericPDTModelMatcher;

import java.util.Collection;


/**
 * The Interface for price/discount/tax row model repository used in the {@link GenericPDTModelMatcher}.
 *
 * @param <CRITERIA>
 *           the generic type for price/discount/tax criteria.
 * @param <MODEL>
 *           the generic type for price/discount/tax row model.
 */
public interface PDTRowRepository<CRITERIA extends PDTCriteria, MODEL extends PDTRowModel>
{

	/**
	 * Finds price/discount/tax rows.
	 *
	 * @param criteria
	 *           the price/discount/tax criteria.
	 * @return the price/discount/tax row models collection.
	 */
	Collection<MODEL> findRows(CRITERIA criteria);
}
