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

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.price.DiscountModel;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.util.DiscountValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;


/**
 * Implementation of {@link FindDiscountValuesStrategy} that resolves {@link DiscountValue}s from the order's attached
 * {@link DiscountModel}s.
 */
public class DefaultSLFindOrderDiscountValuesStrategy implements FindDiscountValuesStrategy
{

	private static final Logger LOG = LoggerFactory.getLogger(DefaultSLFindOrderDiscountValuesStrategy.class);

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderEntryModel entry) throws CalculationException
	{
		return Collections.emptyList();
	}

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderModel order) throws CalculationException
	{
		final List<DiscountModel> discounts = order.getDiscounts();
		if (!ObjectUtils.isEmpty(discounts))
		{
			final List<DiscountValue> result = new ArrayList<>(discounts.size());
			for (final DiscountModel orderDiscount : discounts)
			{
				final DiscountValue discountValue = getDiscountValue(orderDiscount);
				if (discountValue != null)
				{
					result.add(discountValue);
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	@Override
	public boolean isSLOnly()
	{
		return true;
	}

	protected DiscountValue getDiscountValue(final DiscountModel discount)
	{
		try
		{
			final CurrencyModel currency = discount.getCurrency();
			return new DiscountValue(discount.getCode(), discount.getValue(), discount.getAbsolute(), 0.0,
					currency != null ? currency.getIsocode() : null);
		}
		catch (final Exception e)
		{
			//jalo exceptions
			LOG.warn("Discount value of discount " + discount + " could not be resolved due to : " + e.getMessage(), e);
			return null;
		}
	}


}
