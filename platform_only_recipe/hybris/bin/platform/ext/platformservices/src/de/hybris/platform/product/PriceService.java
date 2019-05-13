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

import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.jalo.order.price.ProductPriceInformations;
import de.hybris.platform.servicelayer.internal.LogUtil;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.order.strategies.calculation.FindTaxValuesStrategy;
import de.hybris.platform.product.impl.DefaultPriceService;

import java.util.List;


/**
 * Service for the product prices of a product.
 *
 * @spring.bean priceService
 */
public interface PriceService
{

	/**
	 * Returns all available {@link PriceInformation} for the given {@link ProductModel} and the current session user.
	 *
	 * @param model
	 *           the product
	 * @return an empty list if no price information exists for the product and current session user.
	 */
	List<PriceInformation> getPriceInformationsForProduct(ProductModel model);

	/**
	 * Calculates all applicable prices for given criteria.
	 *
	 * @param priceCriteria
	 *           {@link PriceCriteria}
	 * @return the list of {@link PriceInformation}
	 */
	default List<PriceInformation> getPriceInformations(final PriceCriteria priceCriteria)
	{
		LogUtil.infoOnce(PriceService.class, 10,
				"The method  List<PriceInformation> getPriceInformations(final PriceCriteria priceCriteria) "
						+ "is not implemented, using the defaultPriceService as fallback.");

		return Registry.getApplicationContext().getBean("defaultPriceService", DefaultPriceService.class)
				.getPriceInformations(priceCriteria);
	}

	/**
	 * Returns {@link ProductPriceInformations} product price containing all applicable prices, discounts and taxes for the
	 * given criteria (product and net/gross state)
	 * <p>
	 * This default implementation just calls {@link FindPriceStrategy#getPriceInformation(BaseCriteria)},
	 * {@link FindTaxValuesStrategy#getTaxInformation(BaseCriteria)} and
	 * {@link FindDiscountValuesStrategy#getDiscountInformation(BaseCriteria ) } and wraps the results inside a
	 * {@link ProductPriceInformations} object.
	 *
	 * @param priceCriteria
	 *           {@link PriceCriteria}
	 *
	 * @return {@link ProductPriceInformations} that contains prices,discount, taxes for given priceCriteria
	 */
	default ProductPriceInformations getAllPriceInformation(final PriceCriteria priceCriteria)
	{
		LogUtil.infoOnce(PriceService.class, 11,
				"The method ProductPriceInformations getAllPriceInformation(final PriceCriteria priceCriteria) "
						+ "is not implemented, using the defaultPriceService as fallback.");

		return Registry.getApplicationContext().getBean("defaultPriceService", DefaultPriceService.class)
				.getAllPriceInformation(priceCriteria);
	}
}


