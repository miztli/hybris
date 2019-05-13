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


import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.product.PriceCriteria;


/**
 * PDTCriteria extends PriceCriteria for backward method-compatibility
 */
public interface PDTCriteria extends PriceCriteria
{
	default void validate()
	{
		throw new UnsupportedOperationException("Not implemented");
	}

	PDTCriteriaTarget getPDTCriteriaTarget();

	UserModel getUser();

	CurrencyModel getCurrency();

	enum PDTCriteriaTarget

	{
		VALUE, INFORMATION;
	}
}
