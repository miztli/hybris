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
import de.hybris.platform.core.model.order.price.TaxModel;
import de.hybris.platform.europe1.model.TaxRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.converter.PDTConverter;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.util.TaxValue;

import org.springframework.beans.factory.annotation.Required;


public class DefaultTaxValueConverter implements PDTConverter<TaxRowModel, TaxValue, TaxValueInfoCriteria>
{
	private CommonI18NService commonI18NService;

	@Override
	public TaxValue convert(final TaxRowModel taxRow, final TaxValueInfoCriteria criteria)
	{
		final TaxModel tax = taxRow.getTax();
		final boolean hasValue = taxRow.getValue() != null;
		final boolean abs = hasValue ? taxRow.getAbsolute() : tax.getAbsolute().booleanValue();
		final double value;
		final String isoCode;
		if (abs)
		{
			final CurrencyModel rowCurr = hasValue ? taxRow.getCurrency() : tax.getCurrency();


			final CurrencyModel reqCurr = criteria.getCurrency();
			if (rowCurr != null && !rowCurr.equals(reqCurr))
			{
				final double taxDoubleValue = hasValue ? taxRow.getValue().doubleValue() : tax.getValue().doubleValue();
				value = commonI18NService.convertAndRoundCurrency(rowCurr.getConversion().doubleValue(),
						reqCurr.getConversion().doubleValue(), reqCurr.getDigits().intValue(), taxDoubleValue);
			}
			else
			{
				value = hasValue ? taxRow.getValue().doubleValue() : tax.getValue().doubleValue();
			}
			isoCode = reqCurr.getIsocode();
		}
		else
		{
			value = hasValue ? taxRow.getValue().doubleValue() : tax.getValue().doubleValue();
			isoCode = null;
		}
		return new TaxValue(tax.getCode(), value, abs, isoCode);
	}

	@Required
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}
}
