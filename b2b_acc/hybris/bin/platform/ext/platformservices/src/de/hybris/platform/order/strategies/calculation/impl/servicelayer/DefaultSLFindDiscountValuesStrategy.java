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
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.FindPDTValueInfoStrategy;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.DiscountValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteriaFactory;
import de.hybris.platform.util.DiscountValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * Default implementation of discount resolver strategy {@link FindDiscountValuesStrategy}).
 */
public class DefaultSLFindDiscountValuesStrategy implements FindDiscountValuesStrategy
{
	private FindPDTValueInfoStrategy<DiscountValue, DiscountInformation, DiscountValueInfoCriteria> findDiscountValueInfoStrategy;

	private PDTCriteriaFactory pdtCriteriaFactory;

	@Override
	public boolean isSLOnly()
	{
		return true;
	}

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderModel order) throws CalculationException
	{
		final DiscountValueInfoCriteria discountCriteria = pdtCriteriaFactory.discountValueCriteriaFromOrder(order);
		return findDiscountValueInfoStrategy.getPDTValues(discountCriteria);
	}

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderEntryModel entry) throws CalculationException
	{
		final DiscountValueInfoCriteria discountCriteria = pdtCriteriaFactory.discountValueCriteriaFromOrderEntry(entry);
		return findDiscountValueInfoStrategy.getPDTValues(discountCriteria);
	}

	@Override
	public List<DiscountInformation> getDiscountInformation(final BaseCriteria baseCriteria) throws CalculationException
	{
		return findDiscountValueInfoStrategy
				.getPDTInformation(pdtCriteriaFactory.discountInfoCriteriaFromBaseCriteria(baseCriteria));
	}

	@Required
	public void setPdtCriteriaFactory(final PDTCriteriaFactory pdtCriteriaFactory)
	{
		this.pdtCriteriaFactory = pdtCriteriaFactory;
	}

	@Required
	public void setFindDiscountValueInfoStrategy(
			final FindPDTValueInfoStrategy<DiscountValue, DiscountInformation, DiscountValueInfoCriteria> findDiscountValueInfoStrategy)
	{
		this.findDiscountValueInfoStrategy = findDiscountValueInfoStrategy;
	}
}
