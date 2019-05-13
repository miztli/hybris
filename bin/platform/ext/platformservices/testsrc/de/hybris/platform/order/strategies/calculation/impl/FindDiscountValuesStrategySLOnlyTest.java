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
import de.hybris.platform.core.model.order.price.DiscountModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.DiscountRowModel;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.impl.servicelayer.DefaultSLFindDiscountValuesStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultDiscountValueInfoCriteria;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;


@IntegrationTest
public class FindDiscountValuesStrategySLOnlyTest extends ServicelayerBaseTest
{

	@Resource
	private DefaultSLFindDiscountValuesStrategy slFindDiscountValuesStrategy;

	@Resource
	private ModelService modelService;

	@Resource
	private SessionService sessionService;

	@Test
	public void shouldReturnDiscountInformations() throws CalculationException {
		// given
		final CatalogModel catalog = modelService.create(CatalogModel.class);
		catalog.setId(UUID.randomUUID().toString());

		final CatalogVersionModel catalogVersion = modelService.create(CatalogVersionModel.class);
		catalogVersion.setCatalog(catalog);
		catalogVersion.setVersion(UUID.randomUUID().toString());

		final ProductModel product = modelService.create(ProductModel.class);
		product.setCode(UUID.randomUUID().toString());
		product.setCatalogVersion(catalogVersion);

		final DiscountModel discount = modelService.create(DiscountModel.class);
		discount.setCode(UUID.randomUUID().toString());
		discount.setValue(10.0);

		final DiscountRowModel discountRow = modelService.create(DiscountRowModel.class);
		discountRow.setProduct(product);
		discountRow.setDiscount(discount);

		modelService.saveAll();

		// when
		final List<DiscountInformation> discountInformations = slFindDiscountValuesStrategy
				.getDiscountInformation(DefaultDiscountValueInfoCriteria.buildForInfo() //
						.withProduct(product) //
						.withDate(new Date()) //
						.withUser(sessionService.getCurrentSession().getAttribute("user")) //
						.withCurrency(sessionService.getCurrentSession().getAttribute("currency"))
						.build());

		// then
		assertThat(discountInformations).hasSize(1);

		final DiscountInformation discountInfo = discountInformations.get(0);
		assertThat(discountInfo.getValue().getCode()).isEqualTo(discount.getCode());
		assertThat(discountInfo.getValue().getValue()).isEqualTo(10.0);
	}
}
