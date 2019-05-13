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
package de.hybris.platform.order.strategies.calculation.pdt;

import de.hybris.platform.jalo.order.price.PDTInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.util.PDTValue;

import java.util.List;


/**
 * The Interface for find for price/discount/tax values or information.
 *
 * @param <VALUE>
 *           the generic type for price/discount/tax values.
 * @param <INFO>
 *           the generic type for price/discount/tax information.
 * @param <CRITERIA>
 *           the generic type for price/discount/tax criteria.
 */
public interface FindPDTValueInfoStrategy<VALUE extends PDTValue, INFO extends PDTInformation, CRITERIA extends PDTCriteria>
{

	/**
	 * Gets the price/discount/tax values.
	 *
	 * @param criteria
	 *           the price/discount/tax criteria.
	 * @return the price/discount/tax values.
	 * @throws CalculationException
	 *            the calculation exception
	 */
	List<VALUE> getPDTValues(CRITERIA criteria) throws CalculationException;

	/**
	 * Gets the price/discount/tax information.
	 *
	 * @param criteria
	 *           the price/discount/tax criteria.
	 * @return the price/discount/tax information.
	 * @throws CalculationException
	 *            the calculation exception
	 */
	List<INFO> getPDTInformation(CRITERIA criteria) throws CalculationException;
}
