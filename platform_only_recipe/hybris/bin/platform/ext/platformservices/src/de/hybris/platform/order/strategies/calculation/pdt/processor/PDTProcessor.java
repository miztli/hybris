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
 * A <code>PDTProcessor</code> is an object that performs processing for <code>PDTContext</code>.
 */
public interface PDTProcessor
{
	/**
	 * The <code>doProcess</code> method of the PDTProcessor is called by the application if price/discount/tax information
	 * or values are needed to be resolved. The PDTProcessorChain passed in to this method allows the PDTProcessor to pass
	 * on the context to the next entity in the chain.
	 * <p>
	 * A typical implementation of this method would follow the following pattern: <br>
	 * 1. Examine the PDTCriteriaTarget from the context (context.getPDTCriteriaTarget()) <br>
	 * 2. Examine the CRITERIA from the context (context.getCriteria()) <br>
	 * 2. Depending on the PDTCriteriaTarget and CRITERIA process to resolve values or information<br>
	 * 3. Set up values or information <br>
	 * 3. a) <strong>either</strong> invoke the next entity in the chain using the PDTProcessorChain object
	 * (<code>chain.doProcess(PDTContext context)</code>), <br>
	 * 3. b) <strong>or</strong> not pass on context to the next entity in the process chain to block the context
	 * processing<br>
	 *
	 * @param context
	 *           contains criteria and values/information to process
	 * @param chain
	 *           provides access to the next processor in the chain for this processor to pass the context to for further
	 *           processing
	 *
	 */
	void doProcess(PDTContext context, PDTProcessorChain chain) throws CalculationException;

}
