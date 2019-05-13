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

package de.hybris.platform.order.strategies.calculation.impl.internal;

import de.hybris.platform.catalog.jalo.CatalogAwareEurope1PriceFactory;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.jalo.PriceRow;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.order.AbstractOrder;
import de.hybris.platform.jalo.order.AbstractOrderEntry;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.jalo.order.price.JaloPriceFactoryException;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.jalo.order.price.ProductPriceInformations;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.order.DiscountService;
import de.hybris.platform.order.TaxService;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.order.strategies.calculation.FindTaxValuesStrategy;
import de.hybris.platform.product.PriceCriteria;
import de.hybris.platform.product.PriceService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserNetCheckingStrategy;
import de.hybris.platform.util.DiscountValue;
import de.hybris.platform.util.PriceValue;
import de.hybris.platform.util.TaxValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;


public final class PriceFactorySwitcher extends CatalogAwareEurope1PriceFactory
{
	private transient ModelService modelService;
	private transient TaxService taxService;
	private transient DiscountService discountService;
	private transient PriceService priceService;

	private transient FindPriceStrategy findPriceStrategy;
	private transient FindTaxValuesStrategy findTaxValuesStrategy;
	private transient FindDiscountValuesStrategy findDiscountValuesStrategy;

	private transient UserNetCheckingStrategy userNetCheckingStrategy;
	private transient PricingCustomizationDetector pricingCustomizationDetector;

	@Override
	public ProductPriceInformations getAllPriceInformations(final SessionContext ctx, final Product product, final Date date,
			final boolean net) throws JaloPriceFactoryException
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return super.getAllPriceInformations(ctx, product, date, net);
		}

		final PriceCriteria pCriteria = createPriceCriteria(product, date, net);

		return convertProductPriceInformations(pCriteria);
	}

	private ProductPriceInformations convertProductPriceInformations(final PriceCriteria pCriteria)
	{
		final ProductPriceInformations productPriceInformations = priceService.getAllPriceInformation(pCriteria);
		final List<PriceInformation> priceInformations = new ArrayList<>();

		for (final PriceInformation sourcePriceInformation : productPriceInformations.getPrices())
		{
			final Map qualifiers = new HashMap(sourcePriceInformation.getQualifiers());
			if (sourcePriceInformation.getQualifierValue(PriceRow.UNIT) instanceof UnitModel)
			{
				qualifiers.put(PriceRow.UNIT, modelService.getSource(sourcePriceInformation.getQualifierValue(PriceRow.UNIT)));
			}

			final PriceInformation targetPriceInformation = new PriceInformation(qualifiers, sourcePriceInformation.getPriceValue());
			priceInformations.add(targetPriceInformation);
		}

		return new ProductPriceInformations(priceInformations, productPriceInformations.getTaxes(),
				productPriceInformations.getDiscounts());
	}

	@Override
	public List<PriceInformation> getProductPriceInformations(final SessionContext ctx, final Product product, final Date date,
			final boolean net) throws JaloPriceFactoryException
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return super.getProductPriceInformations(ctx, product, date, net);
		}

		final PriceCriteria pCriteria = createPriceCriteria(product, date, net);

		return priceService.getPriceInformations(pCriteria);
	}

	@Override
	public List<TaxInformation> getProductTaxInformations(final SessionContext ctx, final Product product, final Date date)
			throws JaloPriceFactoryException
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return super.getProductTaxInformations(ctx, product, date);
		}

		try
		{
			final PriceCriteria pCriteria = createPriceCriteria(product, date);
			return taxService.getTaxInformation(pCriteria);
		}
		catch (final CalculationException e)
		{
			throw new JaloPriceFactoryException(e, -1);
		}
	}

	@Override
	public List<DiscountInformation> getProductDiscountInformations(final SessionContext ctx, final Product product,
			final Date date, final boolean net) throws JaloPriceFactoryException
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return super.getProductDiscountInformations(ctx, product, date, net);
		}

		try
		{
			final PriceCriteria pCriteria = createPriceCriteria(product, date, net);
			return discountService.getDiscountInformation(pCriteria);
		}
		catch (final CalculationException e)
		{
			throw new JaloPriceFactoryException(e, -1);
		}
	}

	@Override
	public boolean isNetUser(final User user)
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return super.isNetUser(user);
		}

		final UserModel userModel = modelService.get(user);
		return userNetCheckingStrategy.isNetUser(userModel);
	}

	@Override
	public Collection<TaxValue> getTaxValues(final AbstractOrderEntry entry) throws JaloPriceFactoryException
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return super.getTaxValues(entry);
		}

		final AbstractOrderEntryModel entryModel = modelService.get(entry);
		try
		{
			return findTaxValuesStrategy.findTaxValues(entryModel);
		}
		catch (final CalculationException e)
		{
			throw new JaloPriceFactoryException(e, -1);
		}
	}

	@Override
	public PriceValue getBasePrice(final AbstractOrderEntry entry) throws JaloPriceFactoryException
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return super.getBasePrice(entry);
		}
		final AbstractOrderEntryModel entryModel = modelService.get(entry);
		try
		{
			return findPriceStrategy.findBasePrice(entryModel);
		}
		catch (final CalculationException e)
		{
			throw new JaloPriceFactoryException(e, -1);
		}
	}

	@Override
	public List<DiscountValue> getDiscountValues(final AbstractOrderEntry entry) throws JaloPriceFactoryException
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return super.getDiscountValues(entry);
		}
		final AbstractOrderEntryModel entryModel = modelService.get(entry);
		try
		{
			return findDiscountValuesStrategy.findDiscountValues(entryModel);
		}
		catch (final CalculationException e)
		{
			throw new JaloPriceFactoryException(e, -1);
		}
	}

	@Override
	public List<DiscountValue> getDiscountValues(final AbstractOrder order) throws JaloPriceFactoryException
	{
		if (pricingCustomizationDetector.useJalo())
		{
			return super.getDiscountValues(order);
		}
		final AbstractOrderModel orderModel = modelService.get(order);
		try
		{
			return findDiscountValuesStrategy.findDiscountValues(orderModel);
		}
		catch (final CalculationException e)
		{
			throw new JaloPriceFactoryException(e, -1);
		}
	}

	private PriceCriteria createPriceCriteria(final Product product, final Date date)
	{
		return createPriceCriteria(product, date, null);
	}

	private PriceCriteria createPriceCriteria(final Product product, final Date date, final Boolean net)
	{
		final ProductModel productModel = modelService.get(product);
		return PriceCriteria.DefaultPriceCriteria.forProduct(productModel).forDate(date).withNetPrice(net);
	}

	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	@Required
	public void setTaxService(final TaxService taxService)
	{
		this.taxService = taxService;
	}

	@Required
	public void setDiscountService(final DiscountService discountService)
	{
		this.discountService = discountService;
	}

	@Required
	public void setPriceService(final PriceService priceService)
	{
		this.priceService = priceService;
	}

	@Required
	public void setUserNetCheckingStrategy(final UserNetCheckingStrategy userNetCheckingStrategy)
	{
		this.userNetCheckingStrategy = userNetCheckingStrategy;
	}

	@Required
	public void setFindPriceStrategy(final FindPriceStrategy findPriceStrategy)
	{
		this.findPriceStrategy = findPriceStrategy;
	}

	@Required
	public void setFindTaxValuesStrategy(final FindTaxValuesStrategy findTaxValuesStrategy)
	{
		this.findTaxValuesStrategy = findTaxValuesStrategy;
	}

	@Required
	public void setFindDiscountValuesStrategy(final FindDiscountValuesStrategy findDiscountValuesStrategy)
	{
		this.findDiscountValuesStrategy = findDiscountValuesStrategy;
	}

	@Required
	public void setPricingCustomizationDetector(final PricingCustomizationDetector pricingCustomizationDetector)
	{
		this.pricingCustomizationDetector = pricingCustomizationDetector;
	}
}