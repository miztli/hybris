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

package de.hybris.platform.order.strategies.calculation.pdt.criteria;

import de.hybris.platform.europe1.enums.ProductDiscountGroup;
import de.hybris.platform.europe1.enums.UserDiscountGroup;
import de.hybris.platform.order.exceptions.CalculationException;


public interface DiscountValueInfoCriteria extends PDTCriteria
{
	ProductDiscountGroup getProductGroup();

	UserDiscountGroup getUserGroup();

	@Override
	default Boolean isNet()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	default void validate()
	{
		try
		{
			if (getUser() == null && getUserGroup() == null)
			{
				throw new CalculationException("cannot match discounts without user and user group - at least one must be present");
			}
			if (getCurrency() == null)
			{
				throw new CalculationException("cannot match price without currency");
			}
			if (getDate() == null)
			{
				throw new CalculationException("cannot match price without date");
			}
		}
		catch (final CalculationException e)
		{
			throw new RuntimeException(e);
		}
	}
}
