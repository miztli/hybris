

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
package de.hybris.platform.order.strategies.calculation.pdt.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.price.TaxModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.constants.Europe1Constants;
import de.hybris.platform.europe1.enums.ProductTaxGroup;
import de.hybris.platform.europe1.enums.UserTaxGroup;
import de.hybris.platform.europe1.model.TaxRowModel;
import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.order.price.JaloPriceFactoryException;
import de.hybris.platform.order.CartService;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindTaxValuesStrategy;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.TaxValue;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class FindTaxValuesStrategySLOnlyWithCacheTest extends ServicelayerTransactionalTest
{
	private static final Logger LOG = Logger.getLogger(FindTaxValuesStrategySLOnlyWithCacheTest.class);
	private final PropertyConfigSwitcher cachingConfigSwitcher = new PropertyConfigSwitcher(Europe1Constants.KEY_CACHE_TAXES);

	@Resource
	private CachingFindTaxValueInfoStrategy cachingFindTaxValueInfoStrategy;

	@Resource
	private FindTaxValuesStrategy findTaxValuesStrategy;

	@Resource
	private ModelService modelService;

	@Resource
	private CartService cartService;

	private UnitModel unitModel;
	private TaxModel tax1;
	private TaxModel tax2;
	private ProductTaxGroup productTaxGroupFull;
	private ProductTaxGroup productTaxGroupHalf;
	private UserTaxGroup userTaxGroup1;
	private UserTaxGroup userTaxGroup2;
	private UserModel userModel;
	private ProductModel productModel;
	private ProductModel productModel2;

	@Before
	public void setUp()
	{
		unitModel = modelService.create(UnitModel.class);
		unitModel.setCode("foo");
		unitModel.setUnitType("bar");
		modelService.save(unitModel);

		final CatalogModel testCatalog = modelService.create(CatalogModel.class);
		testCatalog.setId("testCatalog2");
		modelService.save(testCatalog);

		final CatalogVersionModel testCatalogVersion = modelService.create(CatalogVersionModel.class);
		testCatalogVersion.setCatalog(testCatalog);
		testCatalogVersion.setVersion("online");

		tax1 = modelService.create(TaxModel.class);
		tax1.setCode("FULL");
		modelService.save(tax1);
		tax2 = modelService.create(TaxModel.class);
		tax2.setCode("HALF");
		modelService.save(tax2);

		productTaxGroupFull = ProductTaxGroup.valueOf("test_full");
		modelService.save(productTaxGroupFull);
		productTaxGroupHalf = ProductTaxGroup.valueOf("test_half");
		modelService.save(productTaxGroupHalf);
		userTaxGroup1 = UserTaxGroup.valueOf("userGrp1");
		modelService.save(userTaxGroup1);
		userTaxGroup2 = UserTaxGroup.valueOf("userGrp2");
		modelService.save(userTaxGroup2);

		userModel = modelService.get(jaloSession.getUser());
		userModel.setEurope1PriceFactory_UTG(userTaxGroup1);
		modelService.save(userModel);

		productModel = modelService.create(ProductModel.class);
		productModel.setCode("foo");
		productModel.setCatalogVersion(testCatalogVersion);
		productModel.setEurope1PriceFactory_PTG(productTaxGroupFull);
		modelService.save(productModel);

		productModel2 = modelService.create(ProductModel.class);
		productModel2.setCode("bar");
		productModel2.setCatalogVersion(testCatalogVersion);
		productModel2.setEurope1PriceFactory_PTG(productTaxGroupHalf);
		modelService.save(productModel2);
	}

	@After
	public void tearDown()
	{
		cachingConfigSwitcher.switchBackToDefault();
	}

	@Test
	public void testTaxCaching() throws ConsistencyCheckException, JaloPriceFactoryException, CalculationException
	{
		cachingConfigSwitcher.switchToValue(Boolean.TRUE.toString());
		cachingFindTaxValueInfoStrategy.invalidateTaxCache();

		final TaxRowModel tr1 = createTaxRow(null, productTaxGroupFull, null, userTaxGroup1, tax1, Double.valueOf(19));
		final TaxRowModel tr2 = createTaxRow(null, productTaxGroupHalf, null, userTaxGroup1, tax2, Double.valueOf(7));
		final TaxRowModel tr3 = createTaxRow(null, productTaxGroupFull, null, userTaxGroup2, tax1, Double.valueOf(25));
		final TaxRowModel tr4 = createTaxRow(null, productTaxGroupHalf, null, userTaxGroup2, tax2, Double.valueOf(10));

		final CartModel cart = modelService.get(jaloSession.getCart());

		final CartEntryModel entry1 = cartService.addNewEntry(cart, productModel, 2, unitModel);
		final CartEntryModel entry2 = cartService.addNewEntry(cart, productModel2, 10, unitModel);
		modelService.save(entry1);
		modelService.save(entry2);

		Collection<TaxValue> taxes = findTaxValuesStrategy.findTaxValues(entry1);
		assertEquals(1, taxes.size());
		assertTrue(taxes.contains(new TaxValue(tax1.getCode(), 19, false, null)));

		taxes = findTaxValuesStrategy.findTaxValues(entry2);
		assertEquals(1, taxes.size());
		assertTrue(taxes.contains(new TaxValue(tax2.getCode(), 7, false, null)));

		userModel.setEurope1PriceFactory_UTG(userTaxGroup2);
		modelService.save(userModel);

		taxes = findTaxValuesStrategy.findTaxValues(entry1);
		assertEquals(1, taxes.size());
		assertTrue(taxes.contains(new TaxValue(tax1.getCode(), 25, false, null)));

		taxes = findTaxValuesStrategy.findTaxValues(entry2);
		assertEquals(1, taxes.size());
		assertTrue(taxes.contains(new TaxValue(tax2.getCode(), 10, false, null)));

		final TaxRowModel tr5 = createTaxRow(null, null, null, null, tax2, Double.valueOf(100));

		productModel2.setEurope1PriceFactory_PTG(null);
		modelService.save(productModel2);
		taxes = findTaxValuesStrategy.findTaxValues(entry2);
		assertEquals(Collections.singletonList(new TaxValue(tax2.getCode(), 100, false, null)), taxes);

		final TaxRowModel tr6 = createTaxRow(productModel, null, null, null, tax1, Double.valueOf(30));

		taxes = findTaxValuesStrategy.findTaxValues(entry1);
		assertEquals(3, taxes.size());
		assertTrue(taxes.contains(new TaxValue(tax1.getCode(), 30, false, null)));
		assertTrue(taxes.contains(new TaxValue(tax1.getCode(), 25, false, null)));
		assertTrue(taxes.contains(new TaxValue(tax2.getCode(), 100, false, null)));

		final TaxRowModel tr7 = createTaxRow(null, null, userModel, null, tax1, Double.valueOf(40));

		taxes = findTaxValuesStrategy.findTaxValues(entry2);
		assertEquals(2, taxes.size());
		assertTrue(taxes.contains(new TaxValue(tax1.getCode(), 40, false, null)));
		assertTrue(taxes.contains(new TaxValue(tax2.getCode(), 100, false, null)));

		assertTrue(cachingFindTaxValueInfoStrategy.isCachingTaxes());

		final int count = 10000;
		final long ts1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++)
		{
			findTaxValuesStrategy.findTaxValues(entry2);
		}
		final long ts2 = System.currentTimeMillis();

		cachingConfigSwitcher.switchToValue(Boolean.FALSE.toString());
		cachingFindTaxValueInfoStrategy.invalidateTaxCache();
		assertFalse(cachingFindTaxValueInfoStrategy.isCachingTaxes());

		final long ts3 = System.currentTimeMillis();
		for (int i = 0; i < count; i++)
		{
			findTaxValuesStrategy.findTaxValues(entry2);
		}
		final long ts4 = System.currentTimeMillis();

		final long cachedTime = (ts2 - ts1);
		final long nonCachedTime = (ts4 - ts3);

		LOG.info("caching taxes perf [ " + count + " invocations cached=" + cachedTime + "ms, non-cached=" + nonCachedTime
				+ "ms, difference=" + (((nonCachedTime - cachedTime) * 100) / nonCachedTime) + "%");

		modelService.remove(tr1);
		modelService.remove(tr2);
		modelService.remove(tr3);
		modelService.remove(tr4);
		modelService.remove(tr5);
		modelService.remove(tr6);
		modelService.remove(tr7);

		cachingConfigSwitcher.switchToValue(Boolean.TRUE.toString());
		cachingFindTaxValueInfoStrategy.invalidateTaxCache();
		assertTrue(cachingFindTaxValueInfoStrategy.isCachingTaxes());

		assertEquals(Collections.emptyList(), findTaxValuesStrategy.findTaxValues(entry1));
	}

	private TaxRowModel createTaxRow(final ProductModel product, final ProductTaxGroup productTaxGroup, final UserModel user,
			final UserTaxGroup userTaxGroup, final TaxModel tax, final Double value)
	{
		final TaxRowModel taxRowModel = modelService.create(TaxRowModel.class);
		taxRowModel.setProduct(product);
		taxRowModel.setPg(productTaxGroup);
		taxRowModel.setUser(user);
		taxRowModel.setUg(userTaxGroup);
		taxRowModel.setTax(tax);
		taxRowModel.setValue(value);
		modelService.save(taxRowModel);

		return taxRowModel;
	}
}
