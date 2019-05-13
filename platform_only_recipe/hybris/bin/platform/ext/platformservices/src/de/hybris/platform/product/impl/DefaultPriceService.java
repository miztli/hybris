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
package de.hybris.platform.product.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.constants.Europe1Tools;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.jalo.order.price.ProductPriceInformations;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.order.strategies.calculation.FindTaxValuesStrategy;
import de.hybris.platform.product.PriceCriteria;
import de.hybris.platform.product.PriceService;
import de.hybris.platform.servicelayer.exceptions.SystemException;
import de.hybris.platform.servicelayer.internal.service.AbstractBusinessService;
import de.hybris.platform.servicelayer.time.TimeService;
import de.hybris.platform.servicelayer.user.UserNetCheckingStrategy;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.TaxValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * Default implementation of the {@link PriceService}.
 */
public class DefaultPriceService extends AbstractBusinessService implements PriceService, ApplicationContextAware
{
	private transient ApplicationContext ctx;
	private transient TimeService timeService;
	private transient UserService userService;
	private transient FindPriceStrategy findPriceStrategy;
	private transient FindTaxValuesStrategy findTaxValuesStrategy;
	private transient FindDiscountValuesStrategy findDiscountValuesStrategy;

	private transient UserNetCheckingStrategy userNetCheckingStrategy;

	@Override
	public List<PriceInformation> getPriceInformationsForProduct(final ProductModel product)
	{
		return getPriceInformations(PriceCriteria.DefaultPriceCriteria.forProduct(product));
	}

	@Override
	public List<PriceInformation> getPriceInformations(final PriceCriteria priceCriteria)
	{
		try
		{
			final PriceCriteria pCriteria = adjustPriceCriteria(priceCriteria);

			final List<PriceInformation> priceInformations = findPriceStrategy.getPriceInformation(pCriteria);
			final List<PriceInformation> returnCollection = new ArrayList<PriceInformation>(priceInformations.size());

			Collection<TaxValue> taxes = null;
			for (final PriceInformation pInfo : priceInformations)
			{
				PriceInformation pInfoToAdd = pInfo;
				if (pInfo.getPriceValue().isNet() != pCriteria.isNet().booleanValue())
				{
					taxes = getTaxValues(taxes, pCriteria);
					// we have to create a new info object since it is immutable
					pInfoToAdd = new PriceInformation(pInfo.getQualifiers(), pInfo.getPriceValue().getOtherPrice(taxes));
				}
				returnCollection.add(pInfoToAdd);
			}
			return returnCollection;
		}
		catch (final CalculationException e)
		{
			throw new SystemException(e.getMessage(), e);
		}
	}

	private Collection<TaxValue> getTaxValues(final Collection<TaxValue> taxValues, final PriceCriteria pCriteria)
			throws CalculationException
	{
		if (taxValues == null)
		{
			return Europe1Tools.getTaxValues(findTaxValuesStrategy.getTaxInformation(pCriteria));
		}
		return taxValues;
	}

	@Override
	public ProductPriceInformations getAllPriceInformation(final PriceCriteria priceCriteria)
	{
		try
		{
			final PriceCriteria pCriteria = adjustPriceCriteria(priceCriteria);
			final List<PriceInformation> priceInformations = findPriceStrategy.getPriceInformation(pCriteria);
			final List<DiscountInformation> discountInformations = findDiscountValuesStrategy.getDiscountInformation(pCriteria);
			final List<PriceInformation> returnCollection = new ArrayList<PriceInformation>(priceInformations.size());
			final List<TaxInformation> taxes = findTaxValuesStrategy.getTaxInformation(pCriteria);
			Collection<TaxValue> taxValues = null;

			for (final PriceInformation pInfo : priceInformations)
			{
				PriceInformation pInfoToAdd = pInfo;
				if (pInfo.getPriceValue().isNet() != pCriteria.isNet().booleanValue())
				{
					// we have to create a new info object since it is immutable
					taxValues = getTaxValues(taxValues, taxes);
					pInfoToAdd = new PriceInformation(pInfo.getQualifiers(), pInfo.getPriceValue().getOtherPrice(taxValues));
				}
				returnCollection.add(pInfoToAdd);
			}

			return new ProductPriceInformations(returnCollection, taxes, discountInformations);
		}
		catch (final CalculationException e)
		{
			throw new SystemException(e.getMessage(), e);
		}
	}

	private Collection<TaxValue> getTaxValues(final Collection<TaxValue> taxValues, final List<TaxInformation> taxes)
	{
		if (taxValues == null)
		{
			return Europe1Tools.getTaxValues(taxes);
		}
		return taxValues;
	}

	private PriceCriteria adjustPriceCriteria(final PriceCriteria priceCriteria)
	{
		boolean createNewPriceCriteria = false;
		Date forDate = priceCriteria.getDate();
		if (forDate == null)
		{
			forDate = timeService.getCurrentTime();
			createNewPriceCriteria = true;
		}
		Boolean net = priceCriteria.isNet();
		if (net == null)
		{
			final UserModel currentUser = userService.getCurrentUser();
			net = Boolean.valueOf(userNetCheckingStrategy.isNetUser(currentUser));
			createNewPriceCriteria = true;
		}
		if (createNewPriceCriteria)
		{
			return PriceCriteria.DefaultPriceCriteria.forProduct(priceCriteria.getProduct()).forDate(forDate).withNetPrice(net);
		}
		return priceCriteria;
	}

	// actually this would be @Required but we don't know how many partners did
	// override it. so we're looking it up in afterPropertiesSet() in case it's missing
	public void setTimeService(final TimeService timeService)
	{
		this.timeService = timeService;
	}

	// actually this would be @Required but we don't know how many partners did
	// override it. so we're looking it up in afterPropertiesSet() in case it's missing
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	public void setFindPriceStrategy(final FindPriceStrategy findPriceStrategy)
	{
		this.findPriceStrategy = findPriceStrategy;
	}

	public void setFindTaxValuesStrategy(final FindTaxValuesStrategy findTaxValuesStrategy)
	{
		this.findTaxValuesStrategy = findTaxValuesStrategy;
	}

	public void setUserNetCheckingStrategy(final UserNetCheckingStrategy userNetCheckingStrategy)
	{
		this.userNetCheckingStrategy = userNetCheckingStrategy;
	}

	public void setFindDiscountValuesStrategy(final FindDiscountValuesStrategy findDiscountValuesStrategy)
	{
		this.findDiscountValuesStrategy = findDiscountValuesStrategy;
	}

	@Override
	public void setApplicationContext(final ApplicationContext ctx)
	{
		this.ctx = ctx;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		super.afterPropertiesSet();

		if (timeService == null)
		{
			this.timeService = ctx.getBean("timeService", TimeService.class);
		}
		if (userService == null)
		{
			this.userService = ctx.getBean("userService", UserService.class);
		}
		if (findPriceStrategy == null)
		{
			this.findPriceStrategy = ctx.getBean("findPriceStrategy", FindPriceStrategy.class);
		}
		if (findTaxValuesStrategy == null)
		{
			this.findTaxValuesStrategy = ctx.getBean("findTaxValuesStrategy", FindTaxValuesStrategy.class);
		}
		if (findDiscountValuesStrategy == null)
		{
			this.findDiscountValuesStrategy = ctx.getBean("findDiscountValuesStrategy", FindDiscountValuesStrategy.class);
		}
		if (userNetCheckingStrategy == null)
		{
			this.userNetCheckingStrategy = ctx.getBean("userNetCheckingStrategy", UserNetCheckingStrategy.class);
		}
	}
}
