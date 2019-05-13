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


import de.hybris.platform.europe1.enums.ProductTaxGroup;
import de.hybris.platform.europe1.enums.UserTaxGroup;
import de.hybris.platform.order.exceptions.CalculationException;


public interface TaxValueInfoCriteria extends PDTCriteria
{
	ProductTaxGroup getProductGroup();

	UserTaxGroup getUserGroup();

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
			if (getProduct() == null && getProductGroup() == null)
			{
				throw new CalculationException("cannot match taxes without product and product group - at least one must be present");
			}
			if (getUser() == null && getUserGroup() == null)
			{
				throw new CalculationException("cannot match taxes without user and user group - at least one must be present");
			}
			if (getDate() == null)
			{
				throw new CalculationException("cannot match taxes without date");
			}
		}
		catch (final CalculationException ex)
		{
			throw new IllegalArgumentException(ex);
		}
	}
}

