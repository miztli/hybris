/*
 * [y] hybris Platform
 *
 * Copyright (c) {year} SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.platform.product;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.Date;


/**
 * BaseCriteria exposes basic attributes shared by all interfaces that subclass BaseCriteria
 */
public interface BaseCriteria
{
	ProductModel getProduct();

	Date getDate();

	Boolean isNet();
}
