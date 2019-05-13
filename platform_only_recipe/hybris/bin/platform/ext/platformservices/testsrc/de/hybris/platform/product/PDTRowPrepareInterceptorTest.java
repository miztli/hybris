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
package de.hybris.platform.product;

import java.time.Instant;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.testframework.seed.TestDataCreator;
import de.hybris.platform.util.persistence.PersistenceUtils;

import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;


@IntegrationTest
public class PDTRowPrepareInterceptorTest extends ServicelayerBaseTest
{
	public static final double INITIAL_PRICE = 1.12;

	@Resource
	private ModelService modelService;

	private final PropertyConfigSwitcher persistenceLegacyModeSwitcher = new PropertyConfigSwitcher(
			PersistenceUtils.PERSISTENCE_LEGACY_MODE);
	private final PropertyConfigSwitcher linkJDBCModeSwitcher = new PropertyConfigSwitcher("link.jdbc.mode.enabled");

	private ProductModel product;
	private PriceRowModel priceRow;

	protected void switchPersistenceLegacyMode(final boolean value)
	{
		persistenceLegacyModeSwitcher.switchToValue(Boolean.valueOf(value).toString());
	}

	protected void switchLinkJDBCMode(final boolean value)
	{
		linkJDBCModeSwitcher.switchToValue(Boolean.valueOf(value).toString());
	}


	public void createData() throws Exception
	{
		final TestDataCreator testDataCreator = new TestDataCreator(modelService);

		testDataCreator.createLanguage("aas", Locale.GERMAN.getDisplayName());
		final CatalogModel testCatalog = testDataCreator.createCatalog("testCatalog");
		final CatalogVersionModel ver = testDataCreator.createCatalogVersion("ver", testCatalog);
		product = testDataCreator.createProduct("prod", "prodName", "prodDesc", ver);
		final Date productInitialModifiedTime = product.getModifiedtime();

		final UnitModel unit = modelService.create(UnitModel.class);
		unit.setUnitType("volume");
		unit.setCode("l");
		unit.setName("litre");

		final CurrencyModel curr = modelService.create(CurrencyModel.class);
		curr.setIsocode("CHF");
		curr.setName("Swiss franc");
		curr.setActive(true);
		curr.setDigits(2);

		modelService.saveAll(unit, curr);

		Thread.sleep(100);
		priceRow = modelService.create(PriceRowModel.class);
		priceRow.setCatalogVersion(ver);
		priceRow.setProduct(product);
		priceRow.setCurrency(curr);
		priceRow.setUnit(unit);
		priceRow.setPrice(INITIAL_PRICE);

		modelService.save(priceRow);
		modelService.refresh(product);

		assertThat(product.getModifiedtime()).isAfter(productInitialModifiedTime);

	}

	@After
	public void tearDown() throws Exception
	{
		persistenceLegacyModeSwitcher.switchBackToDefault();
		linkJDBCModeSwitcher.switchBackToDefault();
	}

	@Test
	public void shouldNotChangeProductModifiedTimeIfNoChangeInPriceRowJaloWithJDBCLink() throws Exception
	{
		switchPersistenceLegacyMode(true);
		switchLinkJDBCMode(true);

		createData();

		assertThatProductModifiedTimeHasNotChangedIfNoChangeInPriceRow();
	}

	@Test
	public void shouldNotChangeProductModifiedTimeIfNoChangeInPriceRowJaloWithoutJDBCLink() throws Exception
	{
		switchPersistenceLegacyMode(true);
		switchLinkJDBCMode(false);
		createData();

		assertThatProductModifiedTimeHasNotChangedIfNoChangeInPriceRow();
	}

	@Test
	public void shouldNotChangeProductModifiedTimeIfNoChangeInPriceRowSLDWithJDBCLink() throws Exception
	{
		switchPersistenceLegacyMode(false);
		switchLinkJDBCMode(true);
		createData();

		assertThatProductModifiedTimeHasNotChangedIfNoChangeInPriceRow();
	}

	@Test
	public void shouldNotChangeProductModifiedTimeIfNoChangeInPriceRowSLDWithoutJDBCLink() throws Exception
	{
		switchPersistenceLegacyMode(false);
		switchLinkJDBCMode(false);
		createData();

		assertThatProductModifiedTimeHasNotChangedIfNoChangeInPriceRow();
	}


	@Test
	public void shouldChangeProductModifiedTimeIfChangeInPriceRowJaloWithJDBCLink() throws Exception
	{
		switchPersistenceLegacyMode(true);
		switchLinkJDBCMode(true);

		createData();

		assertThatProductModifiedTimeHasChangedIfChangeInPriceRow();
	}

	@Test
	public void shouldChangeProductModifiedTimeIfChangeInPriceRowJaloWithoutJDBCLink() throws Exception
	{
		switchPersistenceLegacyMode(true);
		switchLinkJDBCMode(false);
		createData();

		assertThatProductModifiedTimeHasChangedIfChangeInPriceRow();
	}

	@Test
	public void shouldChangeProductModifiedTimeIfChangeInPriceRowSLDWithJDBCLink() throws Exception
	{
		switchPersistenceLegacyMode(false);
		switchLinkJDBCMode(true);
		createData();

		assertThatProductModifiedTimeHasChangedIfChangeInPriceRow();
	}

	@Test
	public void shouldChangeProductModifiedTimeIfChangeInPriceRowSLDWithoutJDBCLink() throws Exception
	{
		switchPersistenceLegacyMode(false);
		switchLinkJDBCMode(false);
		createData();

		assertThatProductModifiedTimeHasChangedIfChangeInPriceRow();
	}

	private void assertThatProductModifiedTimeHasNotChangedIfNoChangeInPriceRow() throws InterruptedException
	{
		modelService.refresh(product);
		final Date productPreChangeModifiedTime = product.getModifiedtime();

		Thread.sleep(100);

		priceRow.setPrice(INITIAL_PRICE);
		modelService.save(priceRow);

		modelService.refresh(product);
		assertThat(product.getModifiedtime()).isEqualTo(productPreChangeModifiedTime);
	}

	private void assertThatProductModifiedTimeHasChangedIfChangeInPriceRow() throws InterruptedException
	{
		modelService.refresh(product);
		final Date productPreChangeModifiedTime = product.getModifiedtime();

		Thread.sleep(100);

		priceRow.setPrice(INITIAL_PRICE + 0.2);
		modelService.save(priceRow);

		modelService.refresh(product);
		assertThat(product.getModifiedtime()).isAfter(productPreChangeModifiedTime);
	}

	@Test
	public void shouldChangeProductModifiedTimeIfNullChangedToOtherValue() throws Exception
	{
		createData();

		modelService.refresh(product);
		final Date productPreChangeModifiedTime = product.getModifiedtime();

		priceRow.setStartTime(Date.from(Instant.now()));
		modelService.save(priceRow);

		modelService.refresh(product);
		assertThat(product.getModifiedtime()).isAfter(productPreChangeModifiedTime);
	}
}