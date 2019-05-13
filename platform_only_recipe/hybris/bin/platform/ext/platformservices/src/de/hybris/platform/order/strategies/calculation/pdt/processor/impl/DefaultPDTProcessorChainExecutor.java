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
package de.hybris.platform.order.strategies.calculation.pdt.processor.impl;

import de.hybris.platform.jalo.order.price.PDTInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.FindPDTValueInfoStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.processor.PDTContext;
import de.hybris.platform.order.strategies.calculation.pdt.processor.PDTProcessor;
import de.hybris.platform.order.strategies.calculation.pdt.processor.PDTProcessorChain;
import de.hybris.platform.util.PDTValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * Class is used to manage the execution of a set of PDTprocessors.
 *
 * @param <VALUE>
 *           the generic type for price/discount/tax value.
 * @param <INFO>
 *           the generic type for price/discount/tax information.
 * @param <CRITERIA>
 *           the generic type for price/discount/tax criteria.
 */
public class DefaultPDTProcessorChainExecutor<VALUE extends PDTValue, INFO extends PDTInformation, CRITERIA extends PDTCriteria>
		implements FindPDTValueInfoStrategy<VALUE, INFO, CRITERIA>
{
	private PDTProcessor[] pdtProcessors = new PDTProcessor[0];

	@Override
	public List<VALUE> getPDTValues(final CRITERIA criteria) throws CalculationException
	{
		final PDTContext context = new PDTContext(criteria);
		internalDoFilter(context);
		return context.getValues();
	}

	@Override
	public List<INFO> getPDTInformation(final CRITERIA criteria) throws CalculationException
	{

		final PDTContext context = new PDTContext(criteria);
		internalDoFilter(context);
		return context.getInformations();
	}

	private void internalDoFilter(final PDTContext context) throws CalculationException
	{
		new InternalPDTProcessorChain(pdtProcessors).doProcess(context);
	}

	private static final class InternalPDTProcessorChain implements PDTProcessorChain
	{
		private int position;
		private final PDTProcessor[] internalProcessors;

		public InternalPDTProcessorChain(final PDTProcessor[] processors)
		{
			this.position = 0;
			this.internalProcessors = processors;
		}

		@Override
		public void doProcess(final PDTContext context) throws CalculationException
		{
			if (internalProcessors != null && position < internalProcessors.length)
			{
				final PDTProcessor filter = internalProcessors[position++];
				filter.doProcess(context, this);
			}
		}
	}

	@Required
	public void setPdtProcessors(final List<PDTProcessor> pdtProcessors)
	{
		this.pdtProcessors = pdtProcessors.toArray(new PDTProcessor[pdtProcessors.size()]);
	}

}
