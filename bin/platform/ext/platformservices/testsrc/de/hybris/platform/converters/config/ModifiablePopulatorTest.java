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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.converters.data.TestProductData;
import de.hybris.platform.converters.impl.DefaultModifableConfigurablePopulator;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/platformservices/test/modifiable-populator-test-spring.xml")
@UnitTest
public class ModifiablePopulatorTest
{

	@Resource
	private DefaultModifableConfigurablePopulator<ProductModel, TestProductData, String> productConfiguredPopulator;

	@Resource
	private DefaultModifableConfigurablePopulator<ProductModel, TestProductData, String> extendedProductConfiguredPopulator;

	@Resource
	private DefaultModifableConfigurablePopulator<ProductModel, TestProductData, String> noCodeProductConfiguredPopulator;

	private static ProductModel source;
	private static List<String> options;

	@BeforeClass
	public static void setUpBeforeClass()
	{
		source = mock(ProductModel.class);
		given(source.getCode()).willReturn("12345");
		given(source.getName()).willReturn("Product Name");
		given(source.getDescription()).willReturn("Product Description");

		options = new ArrayList<>();
		options.add("CODE");
		options.add("NAME");
		options.add("DESCRIPTION");
	}

	@Test
	public void testProductConfiguredPopulator()
	{
		final TestProductData target = new TestProductData();

		productConfiguredPopulator.populate(source, target, options);

		Assert.assertEquals(source.getCode(), target.getCode());
		Assert.assertEquals(null, target.getName());
		Assert.assertEquals(source.getDescription(), target.getDescription());
	}

	@Test
	public void testExtendedProductConfiguredPopulator()
	{
		final TestProductData target = new TestProductData();

		extendedProductConfiguredPopulator.populate(source, target, options);

		Assert.assertEquals(source.getCode(), target.getCode());
		Assert.assertEquals(source.getName(), target.getName());
		Assert.assertEquals(source.getDescription(), target.getDescription());
	}

	@Test
	public void testNoCodeProductConfiguredPopulator()
	{
		final TestProductData target = new TestProductData();

		noCodeProductConfiguredPopulator.populate(source, target, options);

		Assert.assertEquals(null, target.getCode());
		Assert.assertEquals(source.getName(), target.getName());
		Assert.assertEquals(source.getDescription(), target.getDescription());
	}
}
