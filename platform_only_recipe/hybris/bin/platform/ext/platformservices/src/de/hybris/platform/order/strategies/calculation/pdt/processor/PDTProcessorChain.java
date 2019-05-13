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
package de.hybris.platform.order.strategies.calculation.pdt.processor;

import de.hybris.platform.order.exceptions.CalculationException;


/**
 * Current <code>PDTProcessor</code> can use the <code>PDTProcessorChain</code> to invoke the next processor in the
 * chain
 */
public interface PDTProcessorChain
{
	/**
	 * Causes the next processor in the chain to be invoked
	 *
	 * @param context
	 *           the context to pass along the chain
	 * @throws CalculationException
	 *            the calculation exception
	 *
	 */
	void doProcess(PDTContext context) throws CalculationException;

}
