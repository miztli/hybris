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

package de.hybris.platform.order.strategies.calculation.pdt.filter;

import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;

import java.util.Collection;


/**
 * The Interface for filtering price/discount/tax rows models using criteria.
 *
 * @param <CRITERIA>
 *           the generic type for price/discount/tax criteria.
 * @param <MODEL>
 *           the generic type for price/discount/tax row models.
 */
public interface PDTRowFilter<CRITERIA extends PDTCriteria, MODEL extends PDTRowModel>
{

	/**
	 * Filters price/discount/tax models using given criteria.
	 *
	 * @param collection
	 *           the price/discount/tax collection to filter.
	 * @param criteria
	 *           the price/discount/tax criteria.
	 * @return the filtered price/discount/tax models collection.
	 */
	Collection<MODEL> filter(Collection<MODEL> collection, CRITERIA criteria);
}
