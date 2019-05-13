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

package de.hybris.platform.order.strategies.calculation.pdt.postmatcher;

import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.impl.GenericPDTFindValueInfoStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.matcher.PDTModelMatcher;

import java.util.Collection;


/**
 * The Interface for adding custom logic after invoking the {@link PDTModelMatcher} in the
 * {@link GenericPDTFindValueInfoStrategy}.
 *
 * @param <CRITERIA>
 *           the generic type for price/discount/tax criteria.
 * @param <MODEL>
 *           the generic type for price/discount/tax model.
 */
public interface PDTPostMatcher<CRITERIA extends PDTCriteria, MODEL extends PDTRowModel>
{

	/**
	 * Process the custom post matcher logic.
	 *
	 * @param models
	 *           the collection of price/discount/tax models
	 * @param criteria
	 *           the price/discount/tax criteria
	 * @return the processed price/discount/tax models collection
	 * @throws CalculationException
	 *            the calculation exception
	 */
	Collection<MODEL> process(Collection<MODEL> models, CRITERIA criteria) throws CalculationException;
}
