/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.order;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.synchronization.CatalogVersionSyncCronJobModel;
import de.hybris.platform.catalog.model.synchronization.CatalogVersionSyncJobModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.price.DiscountModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.enums.ProductDiscountGroup;
import de.hybris.platform.europe1.enums.UserDiscountGroup;
import de.hybris.platform.europe1.model.DiscountRowModel;
import de.hybris.platform.jalo.order.price.JaloPriceFactoryException;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.cronjob.CronJobService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.util.DiscountValue;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class SyncDiscountRowsTest extends ServicelayerTest
{
	public static final String PRODUCT_CODE = "productCode";

	@Resource
	private ModelService modelService;
	@Resource
	private CronJobService cronJobService;
	@Resource
	private FlexibleSearchService flexibleSearchService;
	@Resource
	private FindDiscountValuesStrategy currentFactoryFindPricingStrategy;

	private CatalogVersionModel sourceCatalog;
	private CatalogVersionModel targetCatalog;
	private CatalogVersionSyncJobModel syncJob;
	private CurrencyModel currency;

	@Before
	public void setUp()
	{
		final CatalogModel catalog = createCatalog();
		sourceCatalog = createCatalogVersion("source", catalog);
		targetCatalog = createCatalogVersion("target", catalog);
		syncJob = createCatalogVersionSyncJobModel(sourceCatalog, targetCatalog);
		currency = createCurrency();

		modelService.saveAll();
	}

	private CatalogModel createCatalog()
	{
		final CatalogModel catalogModel = modelService.create(CatalogModel.class);
		catalogModel.setId(UUID.randomUUID().toString());
		return catalogModel;
	}

	private CatalogVersionModel createCatalogVersion(final String version, final CatalogModel catalog)
	{
		final CatalogVersionModel catalogVersionModel = modelService.create(CatalogVersionModel.class);
		catalogVersionModel.setCatalog(catalog);
		catalogVersionModel.setVersion(version);
		return catalogVersionModel;
	}

	private CatalogVersionSyncJobModel createCatalogVersionSyncJobModel(final CatalogVersionModel sourceVersion,
			final CatalogVersionModel targetVersion)
	{
		final CatalogVersionSyncJobModel syncJobModel = modelService.create(CatalogVersionSyncJobModel.class);
		syncJobModel.setCode(sourceVersion.getVersion() + "->" + targetVersion.getVersion());
		syncJobModel.setSourceVersion(sourceVersion);
		syncJobModel.setTargetVersion(targetVersion);

		modelService.save(syncJobModel);
		return syncJobModel;
	}

	private CurrencyModel createCurrency()
	{
		final CurrencyModel currencyModel = modelService.create(CurrencyModel.class);
		currencyModel.setSymbol("EUR");
		currencyModel.setIsocode("eur");
		return currencyModel;
	}

	@Test
	public void checkDiscountRowAssignedByUserAndProductGroupsIsVisibleViaPriceFactoryAfterSynchronization()
			throws JaloPriceFactoryException, CalculationException
	{
		//given
		final ProductDiscountGroup pdg = ProductDiscountGroup.valueOf("testDiscountClass");
		modelService.save(pdg);

		final ProductModel sourceProduct = createProduct(sourceCatalog, pdg);
		sourceProduct.setEurope1PriceFactory_PDG(pdg);

		final UserDiscountGroup udg = UserDiscountGroup.valueOf("testUserDiscountGroup");
		modelService.save(udg);
		final UserModel user = createUser(udg);

		createDiscountRow(sourceCatalog, udg, pdg);
		modelService.saveAll();

		//when
		synchronizeCatalog();

		//then
		modelService.refresh(sourceProduct);
		assertThat(sourceProduct.getEurope1Discounts().size()).isEqualTo(2);
		assertThat(sourceProduct.getOwnEurope1Discounts().size()).isEqualTo(0);

		final ProductModel targetProduct = findProduct(targetCatalog);
		assertThat(targetProduct.getEurope1PriceFactory_PDG()).isEqualTo(pdg);
		assertThat(targetProduct.getEurope1Discounts().size()).isEqualTo(2);
		assertThat(targetProduct.getOwnEurope1Discounts().size()).isEqualTo(0);

		final OrderModel order = createOrder(user);
		final OrderEntryModel orderEntry = createOrderEntry(targetProduct, order);
		modelService.saveAll();

		final List<DiscountValue> discountValues = currentFactoryFindPricingStrategy.findDiscountValues(orderEntry);
		assertThat(discountValues).hasSize(2);
	}

	private ProductModel createProduct(final CatalogVersionModel sourceCatalog, final ProductDiscountGroup pdg)
	{
		final ProductModel productModel = modelService.create(ProductModel.class);
		productModel.setCode(PRODUCT_CODE);
		productModel.setCatalogVersion(sourceCatalog);
		productModel.setEurope1PriceFactory_PDG(pdg);
		return productModel;
	}

	private UserModel createUser(final UserDiscountGroup udg)
	{
		final UserModel user = modelService.create(UserModel.class);
		user.setUid(UUID.randomUUID().toString());
		user.setName("user");
		user.setEurope1PriceFactory_UDG(udg);

		return user;
	}

	private OrderModel createOrder(final UserModel user)
	{
		final OrderModel order = modelService.create(OrderModel.class);
		order.setCode(UUID.randomUUID().toString());
		order.setUser(user);
		order.setCurrency(currency);
		order.setDate(new Date());

		return order;
	}

	private OrderEntryModel createOrderEntry(final ProductModel product, final OrderModel order)
	{
		final UnitModel unit = modelService.create(UnitModel.class);
		unit.setCode(UUID.randomUUID().toString());
		unit.setUnitType("type");
		unit.setName("unitName");

		final OrderEntryModel orderEntry = modelService.create(OrderEntryModel.class);
		orderEntry.setOrder(order);
		orderEntry.setProduct(product);
		orderEntry.setQuantity(1L);
		orderEntry.setUnit(unit);
		return orderEntry;
	}

	private void synchronizeCatalog()
	{
		cronJobService.performCronJob(createSyncCronJob(), true);
	}

	private CatalogVersionSyncCronJobModel createSyncCronJob()
	{
		final CatalogVersionSyncCronJobModel cronJobModel = modelService.create(CatalogVersionSyncCronJobModel.class);
		cronJobModel.setJob(syncJob);
		cronJobModel.setCode(UUID.randomUUID().toString());

		modelService.save(cronJobModel);
		return cronJobModel;
	}

	private ProductModel findProduct(final CatalogVersionModel targetCatalog)
	{
		final ProductModel productModel = modelService.create(ProductModel.class);
		productModel.setCode(PRODUCT_CODE);
		productModel.setCatalogVersion(targetCatalog);
		final ProductModel modelByExample = flexibleSearchService.getModelByExample(productModel);
		modelService.detach(productModel);
		return modelByExample;

	}

	private void createDiscountRow(final CatalogVersionModel catalogVersion, final UserDiscountGroup udg,
			final ProductDiscountGroup pdg)
	{
		final DiscountModel discount = modelService.create(DiscountModel.class);
		discount.setCode(UUID.randomUUID().toString());
		discount.setValue(10d);

		modelService.save(discount);

		final DiscountRowModel discountRow = modelService.create(DiscountRowModel.class);
		discountRow.setDiscount(discount);
		discountRow.setCatalogVersion(catalogVersion);
		discountRow.setUg(udg);
		discountRow.setPg(pdg);
	}
}
