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

import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.converter.PDTConverter;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.util.PriceValue;


public class DefaultPriceValueConverter implements PDTConverter<PriceRowModel, PriceValue, PriceValueInfoCriteria>
{

	@Override
	public PriceValue convert(final PriceRowModel priceRowModel, final PriceValueInfoCriteria criteria)
	{
		return new PriceValue(priceRowModel.getCurrency().getIsocode(), priceRowModel.getPrice(), priceRowModel.getNet());
	}

}
