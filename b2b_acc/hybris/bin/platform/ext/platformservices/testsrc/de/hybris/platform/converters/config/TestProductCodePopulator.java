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
package de.hybris.platform.converters.config;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.converters.data.TestProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;


/**
 * Product populator for testing purposes. Only populates the product code.
 */
public class TestProductCodePopulator implements Populator<ProductModel, TestProductData>
{
	@Override
	public void populate(final ProductModel source, final TestProductData target) throws ConversionException
	{
		target.setCode(source.getCode());
	}

}
