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

import de.hybris.platform.europe1.model.AbstractDiscountRowModel;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.order.strategies.calculation.pdt.converter.PDTConverter;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.DiscountValueInfoCriteria;
import de.hybris.platform.util.DiscountValue;


public class DefaultDiscountInfoConverter
		implements PDTConverter<AbstractDiscountRowModel, DiscountInformation, DiscountValueInfoCriteria>
{
	private final de.hybris.platform.servicelayer.DiscountValueConverter converter = new de.hybris.platform.servicelayer.DiscountValueConverter();

	@Override
	public DiscountInformation convert(final AbstractDiscountRowModel abstractDiscountRowModel, final DiscountValueInfoCriteria criteria)
	{
		final DiscountValue discountValue = converter.discountToValue(abstractDiscountRowModel);
		return new DiscountInformation(discountValue);
	}


}
