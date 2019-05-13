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
package de.hybris.platform.order.strategies.calculation.pdt.postmatcher.impl;

import de.hybris.platform.core.CoreAlgorithms;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.postmatcher.PDTPostMatcher;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Required;

import com.google.common.collect.ImmutableList;


public class DefaultPriceValuePostMatcher implements PDTPostMatcher<PriceValueInfoCriteria, PriceRowModel>
{

	private CommonI18NService commonI18NService;

	@Override
	public Collection<PriceRowModel> process(final Collection<PriceRowModel> models, final PriceValueInfoCriteria criteria)
			throws CalculationException
	{
		PriceRowModel priceRow = models.isEmpty() ? null : models.iterator().next();

		if (priceRow != null)
		{
			final CurrencyModel priceRowCurrency = priceRow.getCurrency();
			final double price;

			if (criteria.getCurrency().equals(priceRowCurrency))
			{
				price = priceRow.getPrice().doubleValue() / priceRow.getUnitFactor().doubleValue();
			}
			else
			{
				final double conversion = priceRowCurrency.getConversion().doubleValue();
				price = commonI18NService.convertCurrency(conversion, criteria.getCurrency().getConversion().doubleValue(),
						priceRow.getPrice().doubleValue() / priceRow.getUnitFactor().doubleValue());
			}

			final UnitModel priceUnit = priceRow.getUnit();
			final UnitModel entryUnit = criteria.getUnit();
			final double convertedPrice = convertExact(priceUnit, entryUnit, price);

			priceRow = createPriceRow(criteria.getCurrency(), convertedPrice, priceRow.getNet());

			return ImmutableList.of(priceRow);
		}
		else
		{
			return Collections.emptyList();
		}
	}

	private static PriceRowModel createPriceRow(final CurrencyModel currency, final Double price, final Boolean net)
	{
		final PriceRowModel priceRowModel = new PriceRowModel();

		priceRowModel.setCurrency(currency);
		priceRowModel.setPrice(price);
		priceRowModel.setNet(net);

		return priceRowModel;
	}

	/**
	 * Converts a quantity of this unit into another quantity of a specified target unit. Does no rounding to get an exact
	 * results.
	 *
	 * @param targetUnit
	 *           target unit for conversion
	 * @param value
	 *           value to convert
	 * @throws JaloInvalidParameterException
	 *            if this unit type not equals target unit type
	 */
	private static double convertExact(final UnitModel sourceUnit, final UnitModel targetUnit, final double value)
			throws CalculationException
	{
		if (!sourceUnit.getUnitType().equals(targetUnit.getUnitType()))
		{
			throw new CalculationException("can't convert: unit types don't match");
		}
		return CoreAlgorithms.convert(sourceUnit.getConversion().doubleValue(), targetUnit.getConversion().doubleValue(), value);
	}

	@Required
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}
}
