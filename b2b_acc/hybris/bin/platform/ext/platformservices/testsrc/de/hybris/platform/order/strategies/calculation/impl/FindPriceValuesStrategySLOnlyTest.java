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

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.enums.ProductPriceGroup;
import de.hybris.platform.europe1.enums.UserPriceGroup;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.impl.servicelayer.DefaultSLFindPriceStrategy;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.PriceValue;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;


@IntegrationTest
public class FindPriceValuesStrategySLOnlyTest extends ServicelayerTest
{

	@Resource
	private DefaultSLFindPriceStrategy slFindPriceStrategy;

	@Resource
	private ModelService modelService;

	@Resource
	private UserService userService;

	private static final String TEST_PRODUCT = "TEST_PRODUCT";
	private static final String TEST_USER_GROUP = "TEST_USER_GROUP";
	private static final String TEST_PRODUCT_GROUP = "TEST_PRODUCT_GROUP";

	private CatalogVersionModel testCatalogVersionOnline;
	private CatalogModel testCatalog;
	private CurrencyModel currency;
	private UserModel givenUser1;
	private UserModel givenUser2;
	private UserModel anyUser;
	private UnitModel unit;

	private PriceRowModel any_anyM;
	private PriceRowModel any_groupM;
	private PriceRowModel given_givenM;
	private PriceRowModel group_groupM;

	private ProductModel anyProductM;
	private ProductModel givenProductM;

	private ProductPriceGroup givenProductPriceGroup;
	private UserPriceGroup givenUserPriceGroup;

	@Before
	public void setUp() throws Exception
	{
		getOrCreateLanguage("de");
		unit = modelService.create(UnitModel.class);
		unit.setCode("foo");
		unit.setUnitType("bar");
		modelService.save(unit);

		currency = modelService.create(CurrencyModel.class);
		currency.setActive(Boolean.TRUE);
		currency.setSymbol("foo");
		currency.setIsocode("foo");
		modelService.save(currency);

		givenUser1 = createUser("testUser1");
		givenUser2 = createUser("testUser2");

		final UserGroupModel userGroupModel = modelService.create(UserGroupModel.class);
		userGroupModel.setUid(TEST_USER_GROUP);
		modelService.save(userGroupModel);
		givenUser1.setGroups(ImmutableSet.of(userGroupModel));
		modelService.save(givenUser1);

		testCatalog = modelService.create(CatalogModel.class);
		testCatalog.setId("testCatalog");
		modelService.save(testCatalog);

		testCatalogVersionOnline = modelService.create(CatalogVersionModel.class);
		testCatalogVersionOnline.setCatalog(testCatalog);
		testCatalogVersionOnline.setVersion("online");
		modelService.save(testCatalogVersionOnline);

		givenProductM = createProduct(TEST_PRODUCT, testCatalogVersionOnline);

		givenUserPriceGroup = UserPriceGroup.valueOf(TEST_USER_GROUP);
		modelService.save(givenUserPriceGroup);
		userGroupModel.setUserPriceGroup(givenUserPriceGroup);

		givenProductPriceGroup = ProductPriceGroup.valueOf(TEST_PRODUCT_GROUP);
		modelService.save(givenProductPriceGroup);

		any_anyM = createPrice(anyProductM, anyUser, 15);
		given_givenM = createPrice(givenProductM, null, 14);
		any_groupM = createPrice(null, givenUserPriceGroup, 13);
		group_groupM = createPrice(givenProductPriceGroup, givenUserPriceGroup, 12);

		anyUser = null;
		anyProductM = null;
	}

	@Test
	public void toLowQuantityTest() throws Exception
	{
		final ProductModel product = createProduct("any", testCatalogVersionOnline);
		final OrderEntryModel orderEntry = createOrderEntry(product, givenUser2);
		orderEntry.setQuantity(Long.valueOf(1));

		Exception expectedException = null;
		try
		{
			final PriceValue priceValue = slFindPriceStrategy.findBasePrice(orderEntry);
		}
		catch (final Exception e)
		{
			expectedException = e;
		}
		assertThat(expectedException).isInstanceOf(CalculationException.class);
	}

	@Test
	public void anyTest() throws Exception
	{
		final ProductModel product = createProduct("any", testCatalogVersionOnline);
		final OrderEntryModel orderEntry = createOrderEntry(product, givenUser2);

		final PriceValue priceValue = slFindPriceStrategy.findBasePrice(orderEntry);
		assertThat(priceValue).isNotNull();
		assertThat(priceValue.getValue()).isEqualTo(any_anyM.getPrice());
	}

	@Test
	public void rejectedTest() throws Exception
	{
		final ProductModel product = createProduct("any", testCatalogVersionOnline);
		final OrderEntryModel orderEntry = createOrderEntry(product, givenUser2);

		final PriceValue priceValue = slFindPriceStrategy.findBasePrice(orderEntry);
		assertThat(priceValue).isNotNull();
		assertThat(priceValue.getValue()).isEqualTo(any_anyM.getPrice());
	}

	@Test
	public void givenProductTest() throws Exception
	{
		final OrderEntryModel orderEntry = createOrderEntry(givenProductM, givenUser2);

		final PriceValue priceValue = slFindPriceStrategy.findBasePrice(orderEntry);
		assertThat(priceValue).isNotNull();
		assertThat(priceValue.getValue()).isEqualTo(given_givenM.getPrice());
	}

	@Test
	public void givenUserGroupTest() throws Exception
	{
		final ProductModel product = createProduct("any", testCatalogVersionOnline);
		final OrderEntryModel orderEntry = createOrderEntry(product, givenUser1);

		final PriceValue priceValue = slFindPriceStrategy.findBasePrice(orderEntry);
		assertThat(priceValue).isNotNull();
		assertThat(priceValue.getValue()).isEqualTo(any_groupM.getPrice());
	}

	@Test
	public void givenUserGroupandProductGroupTest() throws Exception
	{
		final ProductModel product = createProduct("any", testCatalogVersionOnline);
		final OrderEntryModel orderEntry = createOrderEntry(product, givenUser2);
		product.setEurope1PriceFactory_PPG(givenProductPriceGroup);
		givenUser2.setEurope1PriceFactory_UPG(givenUserPriceGroup);

		final PriceValue priceValue = slFindPriceStrategy.findBasePrice(orderEntry);
		assertThat(priceValue).isNotNull();
		assertThat(priceValue.getValue()).isEqualTo(group_groupM.getPrice());
	}

	private OrderEntryModel createOrderEntry(final ProductModel product, final UserModel user)
	{
		final OrderModel order = createOrder(user);
		final OrderEntryModel orderEntry = modelService.create(OrderEntryModel.class);
		orderEntry.setProduct(product);
		orderEntry.setOrder(order);
		orderEntry.setQuantity(Long.valueOf(2));
		orderEntry.setUnit(unit);
		modelService.save(orderEntry);

		return orderEntry;
	}

	private OrderModel createOrder(final UserModel user)
	{
		final OrderModel order = modelService.create(OrderModel.class);
		order.setCurrency(currency);
		order.setUser(user);
		order.setDate(new Date());
		modelService.save(order);

		return order;
	}

	private PriceRowModel createPrice(final Object product, final Object user, final double priceValue) throws Exception
	{
		final ProductModel prod = (product instanceof ProductModel) ? (ProductModel) product : null;
		final ProductPriceGroup prodGroup = (product instanceof ProductPriceGroup) ? (ProductPriceGroup) product : null;
		final UserModel usr = (user instanceof UserModel) ? (UserModel) user : null;
		final UserPriceGroup usrGroup = (user instanceof UserPriceGroup) ? (UserPriceGroup) user : null;
		final String productCode = (product instanceof String) ? (String) product : null;

		return createPriceRow(prod, prodGroup, usr, usrGroup, productCode, priceValue);
	}

	private PriceRowModel createPriceRow(final ProductModel product, final ProductPriceGroup productGroup, final UserModel user,
			final UserPriceGroup userGroup, final String productCode, final double priceValue)
	{
		final PriceRowModel priceRowModel = modelService.create(PriceRowModel.class);
		priceRowModel.setProduct(product);
		priceRowModel.setPg(productGroup);
		priceRowModel.setUser(user);
		priceRowModel.setUg(userGroup);
		priceRowModel.setMinqtd(2l);
		priceRowModel.setUnitFactor(1);
		priceRowModel.setNet(true);
		priceRowModel.setPrice(priceValue);
		priceRowModel.setUnit(unit);
		priceRowModel.setCurrency(currency);
		priceRowModel.setProductId(productCode);
		modelService.save(priceRowModel);

		return priceRowModel;
	}

	private UserModel createUser(final String login)
	{
		if (login == null)
		{
			return null;
		}

		try
		{
			final UserModel userModel = modelService.create(UserModel.class);
			userModel.setUid(login);
			modelService.save(userModel);
			return userModel;
		}
		catch (final Exception e)
		{
			return userService.getUserForUID(login);
		}
	}

	private ProductModel createProduct(final String code, final CatalogVersionModel testCatalogVersion)
	{
		if (code == null)
		{
			return null;
		}

		final ProductModel product = modelService.create(ProductModel.class);
		product.setCode(code);
		product.setCatalogVersion(testCatalogVersion);
		modelService.save(product);
		return product;
	}
}