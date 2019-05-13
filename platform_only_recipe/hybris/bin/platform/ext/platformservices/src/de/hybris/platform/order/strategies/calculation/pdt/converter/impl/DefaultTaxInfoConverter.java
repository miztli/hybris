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

import de.hybris.platform.core.model.order.price.TaxModel;
import de.hybris.platform.europe1.jalo.Europe1TaxInformation;
import de.hybris.platform.europe1.model.TaxRowModel;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.strategies.calculation.pdt.converter.PDTConverter;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.util.TaxValue;


public class DefaultTaxInfoConverter implements PDTConverter<TaxRowModel, TaxInformation, TaxValueInfoCriteria>
{
	@Override
	public TaxInformation convert(final TaxRowModel taxRow, final TaxValueInfoCriteria taxCriteria)
	{
		final TaxModel tax = taxRow.getTax();

		final double val = taxRowHasValue(taxRow) ? taxRow.getValue().doubleValue() : tax.getValue().doubleValue();
		final boolean abs = taxRowHasValue(taxRow) ? isTaxRowAbsoluteAsPrimitive(taxRow) : tax.getAbsolute();

		final TaxValue taxValue = new TaxValue(tax.getCode(), val, abs,
				abs ? (taxRowHasValue(taxRow) ? taxRow.getCurrency() : tax.getCurrency()).getIsocode() : null);

		return new Europe1TaxInformation(taxValue, taxRow.getPk());
	}

	private static boolean isTaxRowAbsoluteAsPrimitive(final TaxRowModel taxRow)
	{
		final Boolean absolute = taxRow.getAbsolute();
		if (absolute == null)
		{
			return false;
		}
		return absolute;
	}

	private static boolean taxRowHasValue(final TaxRowModel taxRow)
	{
		return taxRow.getValue() != null;
	}


}
