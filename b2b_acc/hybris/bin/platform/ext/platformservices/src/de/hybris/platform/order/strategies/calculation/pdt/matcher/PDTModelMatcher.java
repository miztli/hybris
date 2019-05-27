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
package de.hybris.platform.order.strategies.calculation.pdt.matcher;

import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.impl.GenericPDTFindValueInfoStrategy;

import java.util.List;


/**
 * The Interface for matching price/discount/tax models in the {@link GenericPDTFindValueInfoStrategy}.
 *
 * @param <CRITERIA>
 *           the generic type for price/discount/tax criteria.
 * @param <MODEL>
 *           the generic type for price/discount/tax row models.
 */
public interface PDTModelMatcher<CRITERIA extends PDTCriteria, MODEL extends PDTRowModel>
{

	/**
	 * Match rows for given criteria.
	 *
	 * @param criteria
	 *           the price/discount/tax criteria.
	 * @return the price/discount/tax models list.
	 */
	List<MODEL> matchRows(final CRITERIA criteria);
}
