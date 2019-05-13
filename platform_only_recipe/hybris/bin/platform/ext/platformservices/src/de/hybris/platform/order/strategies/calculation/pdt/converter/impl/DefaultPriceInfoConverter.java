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

package de.hybris.platform.order.strategies.calculation.pdt.converter.impl;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.europe1.jalo.PDTRow;
import de.hybris.platform.europe1.jalo.PriceRow;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.order.strategies.calculation.pdt.converter.PDTConverter;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.util.DateRange;
import de.hybris.platform.util.PriceValue;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;


public class DefaultPriceInfoConverter implements PDTConverter<PriceRowModel, PriceInformation, PriceValueInfoCriteria>
{
	private CommonI18NService commonI18NService;

	@Override
	public PriceInformation convert(final PriceRowModel priceRowModel, final PriceValueInfoCriteria criteria)
	{
		return createPriceInformation(priceRowModel, criteria.getCurrency());
	}

	public final PriceInformation createPriceInformation(final PriceRowModel row, final CurrencyModel currency)
	{
		final Map qualifiers = new HashMap();
		qualifiers.put(PriceRow.MINQTD, row.getMinqtd());
		qualifiers.put(PriceRow.UNIT, row.getUnit());
		qualifiers.put(PriceRow.PRICEROW, row);
		final DateRange dateRange = row.getDateRange();
		if (dateRange != null)
		{
			qualifiers.put(PDTRow.DATERANGE, dateRange);
		}
		final CurrencyModel actCurr = row.getCurrency();
		// get base price ( convert if necessary )
		final double basePrice;
		if (currency.equals(actCurr))
		{
			basePrice = getDoubleAsPrimitive(row.getPrice()) / getIntegerAsPrimitive(row.getUnitFactor());
		}
		else
		{
			basePrice = commonI18NService.convertCurrency(actCurr.getConversion().doubleValue(),
					currency.getConversion().doubleValue(),
					(getDoubleAsPrimitive(row.getPrice()) / getIntegerAsPrimitive(row.getUnitFactor())));
		}

		// if base price is not in requested net/gross state, compute it
		return new PriceInformation(qualifiers,
				new PriceValue(currency.getIsocode(), basePrice, getBooleanAsPrimitive(row.getNet())));
	}


	private static double getDoubleAsPrimitive(final Double value)
	{
		return value != null ? value.doubleValue() : 0.0d;
	}

	private static boolean getBooleanAsPrimitive(final Boolean value)
	{

		return value != null ? value.booleanValue() : Boolean.FALSE;
	}

	private static int getIntegerAsPrimitive(final Integer value)
	{
		return value != null ? value.intValue() : 0;
	}

	@Required
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}

}
