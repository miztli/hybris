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

package de.hybris.platform.order.strategies.calculation.pdt;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.order.price.TaxModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.TaxRowModel;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultTaxValueInfoCriteria;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.TaxValue;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public abstract class AbstractFindTaxValuesStrategyTest extends ServicelayerTest
{

	public abstract FindPDTValueInfoStrategy<TaxValue, TaxInformation, TaxValueInfoCriteria> findPDTValueInfoStrategy();

	@Resource
	ModelService modelService;

	@Resource
	private SessionService sessionService;

	protected PropertyConfigSwitcher europe1CacheTaxesProperty = new PropertyConfigSwitcher("europe1.cache.taxes");

	private CatalogModel catalog;
	private CatalogVersionModel catalogVersion;
	ProductModel product;

	@Before
	public void doBefore()
	{
		catalog = modelService.create(CatalogModel.class);
		catalog.setId(UUID.randomUUID().toString());

		catalogVersion = modelService.create(CatalogVersionModel.class);
		catalogVersion.setCatalog(catalog);
		catalogVersion.setVersion(UUID.randomUUID().toString());

		product = modelService.create(ProductModel.class);
		product.setCode(UUID.randomUUID().toString());
		product.setCatalogVersion(catalogVersion);

		modelService.saveAll();
	}

	@After
	public void revertSettings()
	{
		europe1CacheTaxesProperty.switchBackToDefault();
	}

	@Test
	public void shouldReturnEmptyListsWhenNoTaxInSystem() throws CalculationException
	{
		final TaxValueInfoCriteria criteria = DefaultTaxValueInfoCriteria.buildForValue() //
				.withDate(new Date()) //
				.withProduct(product) //
				.withUser(sessionService.getCurrentSession().getAttribute("user")) //
				.withCurrency(sessionService.getCurrentSession().getAttribute("currency")) //
				.build();

		// when
		final List<TaxInformation> taxInformations = findPDTValueInfoStrategy().getPDTInformation(criteria);
		final List<TaxValue> taxValues = findPDTValueInfoStrategy().getPDTValues(criteria);

		// then
		assertThat(taxInformations).hasSize(0);
		assertThat(taxValues).hasSize(0);
	}


	@Test
	public void shouldReturnTaxInformations() throws CalculationException
	{
		final TaxModel tax = modelService.create(TaxModel.class);
		tax.setCode(UUID.randomUUID().toString());
		tax.setValue(10.0);

		final TaxRowModel taxRow = modelService.create(TaxRowModel.class);
		taxRow.setProduct(product);
		taxRow.setTax(tax);

		modelService.saveAll();

		final TaxValueInfoCriteria criteria = DefaultTaxValueInfoCriteria.buildForValue() //
				.withProduct(product) //
				.withDate(new Date()) //
				.withUser(sessionService.getCurrentSession().getAttribute("user")) //
				.withCurrency(sessionService.getCurrentSession().getAttribute("currency")) //
				.build();

		// when
		final List<TaxInformation> taxInformations = findPDTValueInfoStrategy().getPDTInformation(criteria);
		final List<TaxValue> taxValues = findPDTValueInfoStrategy().getPDTValues(criteria);

		// then
		assertThat(taxInformations).hasSize(1);

		final TaxInformation taxInfo = taxInformations.get(0);
		assertThat(taxInfo.getValue().getCode()).isEqualTo(tax.getCode());
		assertThat(taxInfo.getValue().getValue()).isEqualTo(10.0);

		assertThat(taxValues).hasSize(1);

		final TaxValue taxValue = taxValues.get(0);
		assertThat(taxValue.getCode()).isEqualTo(tax.getCode());
		assertThat(taxValue.getValue()).isEqualTo(10.0);
	}
}
