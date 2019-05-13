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

package de.hybris.platform.order.strategies.calculation.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.price.DiscountModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.order.strategies.calculation.impl.servicelayer.DefaultSLFindOrderDiscountValuesStrategy;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.util.DiscountValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class FindOrderDiscountValuesStrategySLOnlyTest extends ServicelayerTransactionalTest
{

	@Resource
	private DefaultSLFindOrderDiscountValuesStrategy slFindOrderDiscountValuesStrategy;

	@Resource
	private ModelService modelService;


	private ProductModel testProduct;
	private CatalogVersionModel testCatalogVersionOnline;
	private CatalogModel testCatalog;
	private OrderModel order1;
	private CurrencyModel currency;
	private UserModel testUser;
	private UnitModel unit;
	private DiscountModel discountModel1;
	private DiscountModel discountModel2;
	private DiscountModel discountModel3;


	private OrderEntryModel orderEntry1;


	@Before
	public void setUp()
	{
		discountModel1 = modelService.create(DiscountModel.class);
		discountModel1.setCode("discountCode1");
		discountModel1.setValue(10.0);
		modelService.save(discountModel1);

		discountModel2 = modelService.create(DiscountModel.class);
		discountModel2.setCode("discountCode2");
		discountModel2.setValue(20.0);
		modelService.save(discountModel2);

		discountModel3 = modelService.create(DiscountModel.class);
		discountModel3.setCode("discountCode3");
		discountModel3.setValue(30.0);

		modelService.save(discountModel3);

		final List<DiscountModel> discountModelList = Arrays.asList(discountModel1, discountModel2, discountModel3);

		unit = modelService.create(UnitModel.class);
		unit.setCode("foo");
		unit.setUnitType("bar");
		modelService.save(unit);

		currency = modelService.create(CurrencyModel.class);
		currency.setActive(Boolean.TRUE);
		currency.setSymbol("foo");
		currency.setIsocode("foo");
		modelService.save(currency);

		testUser = modelService.create(UserModel.class);
		testUser.setUid("testUser");
		modelService.save(testUser);

		order1 = modelService.create(OrderModel.class);
		order1.setCurrency(currency);
		order1.setUser(testUser);
		order1.setDate(new Date());
		order1.setDiscounts(discountModelList);
		modelService.save(order1);


		testCatalog = modelService.create(CatalogModel.class);
		testCatalog.setId("testCatalog");
		modelService.save(testCatalog);

		testCatalogVersionOnline = modelService.create(CatalogVersionModel.class);
		testCatalogVersionOnline.setCatalog(testCatalog);
		testCatalogVersionOnline.setVersion("online");
		modelService.save(testCatalogVersionOnline);

		testProduct = modelService.create(ProductModel.class);
		testProduct.setCode("testProduct");
		testProduct.setCatalogVersion(testCatalogVersionOnline);
		modelService.save(testProduct);

		orderEntry1 = modelService.create(OrderEntryModel.class);
		orderEntry1.setProduct(testProduct);
		orderEntry1.setOrder(order1);
		orderEntry1.setQuantity(Long.valueOf(1));
		orderEntry1.setUnit(unit);
		modelService.save(orderEntry1);



	}

	@After
	public void tearDown()
	{
		modelService.remove(testProduct);
		modelService.remove(testCatalogVersionOnline);
		modelService.remove(testCatalog);
		modelService.remove(orderEntry1);
		modelService.remove(order1);
		modelService.remove(testUser);
		modelService.remove(currency);
		modelService.remove(unit);
		modelService.remove(discountModel1);
		modelService.remove(discountModel2);
		modelService.remove(discountModel3);
	}


	@Test
	public void shouldReturnEmptyListFromOrderEntryModel() throws Exception
	{
		final List<DiscountValue> discountValueList = slFindOrderDiscountValuesStrategy.findDiscountValues(orderEntry1);
		Assert.assertEquals("discount value list should be empty", Collections.emptyList(), discountValueList);
	}


	@Test
	public void findDiscountValuesTest() throws Exception
	{
		List<DiscountValue> discountValueList = slFindOrderDiscountValuesStrategy.findDiscountValues(order1);
		Assert.assertEquals("discount value list should has proper size", 3, discountValueList.size());
		Assert.assertEquals("should be returned proper code of first element of discount value list", "discountCode1",
				discountValueList.get(0).getCode());
		Assert.assertEquals("should be returned proper value of first element of discount value list", 10.0,
				discountValueList.get(0).getValue(), 0);
		order1.setDiscounts(Collections.emptyList());
		discountValueList.clear();
		discountValueList = slFindOrderDiscountValuesStrategy.findDiscountValues(order1);
		Assert.assertEquals("discount value list should be empty", Collections.emptyList(), discountValueList);
	}



}