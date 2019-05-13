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
package de.hybris.platform.order.strategies.calculation.impl.internal;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.util.DiscountValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * Internal use only
 */
final class FindOrderDiscountValuesStrategySwitcher implements FindDiscountValuesStrategy
{
	private FindDiscountValuesStrategy findOrderDiscountValuesStrategy;
	private FindDiscountValuesStrategy slFindOrderDiscountValuesStrategy;

	private PricingCustomizationDetector pricingCustomizationDetector;

	@Override
	public boolean isSLOnly()
	{
		return getStrategy().isSLOnly();
	}

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderEntryModel entry) throws CalculationException
	{
		return getStrategy().findDiscountValues(entry);
	}

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderModel order) throws CalculationException
	{
		return getStrategy().findDiscountValues(order);
	}

	private FindDiscountValuesStrategy getStrategy()
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return findOrderDiscountValuesStrategy;
		}
		else
		{
			return slFindOrderDiscountValuesStrategy;
		}
	}

	@Required
	public void setFindOrderDiscountValuesStrategy(final FindDiscountValuesStrategy findOrderDiscountValuesStrategy)
	{
		this.findOrderDiscountValuesStrategy = findOrderDiscountValuesStrategy;
	}

	@Required
	public void setSlFindOrderDiscountValuesStrategy(final FindDiscountValuesStrategy findOrderDiscountValuesStrategy)
	{
		this.slFindOrderDiscountValuesStrategy = findOrderDiscountValuesStrategy;
	}

	@Required
	public void setPricingCustomizationDetector(final PricingCustomizationDetector pricingCustomizationDetector)
	{
		this.pricingCustomizationDetector = pricingCustomizationDetector;
	}
}
