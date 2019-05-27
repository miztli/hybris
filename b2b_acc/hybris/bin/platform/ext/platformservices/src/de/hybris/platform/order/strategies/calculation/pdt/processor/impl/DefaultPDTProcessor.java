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
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria.PDTCriteriaTarget;
import de.hybris.platform.order.strategies.calculation.pdt.processor.PDTContext;
import de.hybris.platform.order.strategies.calculation.pdt.processor.PDTProcessor;
import de.hybris.platform.order.strategies.calculation.pdt.processor.PDTProcessorChain;
import de.hybris.platform.util.PDTValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Required;


/**
 * Default implementation of PDT processor ({@link PDTProcessor}, that fill values/informations if current
 * values/informations are empty or NO_RESULT. This processor always calls method doProcess from PDTProcessorChain
 */
public class DefaultPDTProcessor<VALUE extends PDTValue, INFO extends PDTInformation, CRITERIA extends PDTCriteria>
		implements PDTProcessor
{
	public static final List NO_RESULT = Collections.unmodifiableList(new ArrayList<>());

	private FindPDTValueInfoStrategy<VALUE, INFO, CRITERIA> findPDTValueInfoStrategy;

	@Override
	public void doProcess(final PDTContext context, final PDTProcessorChain chain) throws CalculationException
	{
		Objects.requireNonNull(context, "context is required");
		Objects.requireNonNull(context.getCriteria(), "context.getCriteria() is required");
		Objects.requireNonNull(context.getPDTCriteriaTarget(), "context.getPDTCriteriaTarget() is required");

		final CRITERIA criteria = (CRITERIA) context.getCriteria();

		//it get values only if response object is empty
		if (PDTCriteriaTarget.VALUE.equals(context.getPDTCriteriaTarget()) && valuesNotSet(context))
		{
			final List<VALUE> actualResponse = findPDTValueInfoStrategy.getPDTValues(criteria);
			context.setValues(actualResponse);
		}
		else if (PDTCriteriaTarget.INFORMATION.equals(context.getPDTCriteriaTarget()) && informationsNotSet(context))
		{
			final List<INFO> actualResponse = findPDTValueInfoStrategy.getPDTInformation(criteria);
			context.setInformations(actualResponse);
		}

		//default always call doProcess from PDTProcessorChain
		chain.doProcess(context);
	}

	private static boolean valuesNotSet(final PDTContext context)
	{
		return context.getValues() == null || context.getValues() == NO_RESULT;
	}

	private static boolean informationsNotSet(final PDTContext context)
	{
		return context.getInformations() == null || context.getInformations() == NO_RESULT;
	}

	@Required
	public void setFindPDTValueInfoStrategy(final FindPDTValueInfoStrategy<VALUE, INFO, CRITERIA> findPDTValueInfoStrategy)
	{
		this.findPDTValueInfoStrategy = findPDTValueInfoStrategy;
	}

}
