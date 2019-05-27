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
package de.hybris.platform.order.strategies.calculation.impl.servicelayer;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.FindPDTValueInfoStrategy;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteriaFactory;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.util.PriceValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * Default implementation of price resolver strategy ({@link FindPriceStrategy}, that resolves values for calculation.
 */
public class DefaultSLFindPriceStrategy implements FindPriceStrategy
{
	private FindPDTValueInfoStrategy<PriceValue, PriceInformation, PriceValueInfoCriteria> findPriceValueInfoStrategy;
	private PDTCriteriaFactory pdtCriteriaFactory;

	@Override
	public boolean isSLOnly()
	{
		return true;
	}

	@Override
	public PriceValue findBasePrice(final AbstractOrderEntryModel entry) throws CalculationException
	{
		return findBasePriceWithStrategy(entry);
	}

	private PriceValue findBasePriceWithStrategy(final AbstractOrderEntryModel entry) throws CalculationException
	{
		final PriceValueInfoCriteria priceValuesCriteria = pdtCriteriaFactory.priceValueCriteriaFromOrderEntry(entry);

		final List<PriceValue> pdtValues = findPriceValueInfoStrategy.getPDTValues(priceValuesCriteria);

		return pdtValues.isEmpty() ? null : pdtValues.get(0);
	}

	@Override
	public List<PriceInformation> getPriceInformation(final BaseCriteria priceCriteria) throws CalculationException
	{
		final PriceValueInfoCriteria pvc = pdtCriteriaFactory.priceInfoCriteriaFromBaseCriteria(priceCriteria);
		return findPriceValueInfoStrategy.getPDTInformation(pvc);
	}

	@Required
	public void setPdtCriteriaFactory(final PDTCriteriaFactory pdtCriteriaFactory)
	{
		this.pdtCriteriaFactory = pdtCriteriaFactory;
	}

	@Required
	public void setFindPriceValueInfoStrategy(
			final FindPDTValueInfoStrategy<PriceValue, PriceInformation, PriceValueInfoCriteria> findPriceValueInfoStrategy)
	{
		this.findPriceValueInfoStrategy = findPriceValueInfoStrategy;
	}
}
