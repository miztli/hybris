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

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.order.AbstractOrder;
import de.hybris.platform.jalo.order.AbstractOrderEntry;
import de.hybris.platform.jalo.order.OrderManager;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.jalo.order.price.JaloPriceFactoryException;
import de.hybris.platform.jalo.order.price.PriceFactory;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.order.strategies.calculation.FindTaxValuesStrategy;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.servicelayer.exceptions.SystemException;
import de.hybris.platform.servicelayer.internal.service.AbstractBusinessService;
import de.hybris.platform.servicelayer.time.TimeService;
import de.hybris.platform.servicelayer.user.UserNetCheckingStrategy;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.DiscountValue;
import de.hybris.platform.util.PriceValue;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * Default implementation of price, taxes and discounts resolver strategies ({@link FindPriceStrategy},
 * {@link FindDiscountValuesStrategy}, {@link FindTaxValuesStrategy}) that resolves values for calculation from current
 * session's price factory. If no session price factory is set it uses {@link OrderManager#getPriceFactory()} which will
 * retrieve the default one according to system settings.
 */
public class FindPricingWithCurrentPriceFactoryStrategy extends AbstractBusinessService implements FindPriceStrategy,
		FindDiscountValuesStrategy, FindTaxValuesStrategy, UserNetCheckingStrategy, ApplicationContextAware
{
	private transient ApplicationContext ctx;
	private transient TimeService timeService;
	private transient UserService userService;


	@Override
	public Collection findTaxValues(final AbstractOrderEntryModel entry) throws CalculationException
	{
		final AbstractOrderEntry entryItem = getModelService().getSource(entry);
		try
		{
			return getCurrentPriceFactory().getTaxValues(entryItem);
		}
		catch (final JaloPriceFactoryException e)
		{
			throw new CalculationException(e);
		}
	}

	@Override
	public PriceValue findBasePrice(final AbstractOrderEntryModel entry) throws CalculationException
	{
		final AbstractOrderEntry entryItem = getModelService().getSource(entry);
		try
		{
			return getCurrentPriceFactory().getBasePrice(entryItem);
		}
		catch (final JaloPriceFactoryException e)
		{
			throw new CalculationException(e);
		}
	}

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderEntryModel entry) throws CalculationException
	{
		final AbstractOrderEntry entryItem = getModelService().getSource(entry);
		try
		{
			return getCurrentPriceFactory().getDiscountValues(entryItem);
		}
		catch (final JaloPriceFactoryException e)
		{
			throw new CalculationException(e);
		}
	}

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderModel order) throws CalculationException
	{
		final AbstractOrder orderItem = getModelService().getSource(order);
		try
		{
			return getCurrentPriceFactory().getDiscountValues(orderItem);
		}
		catch (final JaloPriceFactoryException e)
		{
			throw new CalculationException(e);
		}
	}

	@Override
	public List<PriceInformation> getPriceInformation(final BaseCriteria baseCriteria)
	{
		final ProductDateNet pdn = provideSearchParameters(baseCriteria);
		try
		{
			return pdn.getProduct().getPriceInformations(pdn.getDate(), pdn.getNet().booleanValue());
		}
		catch (final JaloPriceFactoryException e)
		{
			throw new SystemException(e.getMessage(), e);
		}
	}

	@Override
	public List<DiscountInformation> getDiscountInformation(final BaseCriteria priceCriteria)
	{
		final ProductDateNet pdn = provideSearchParameters(priceCriteria);
		try
		{
			return pdn.getProduct().getDiscountInformations(pdn.getDate(), pdn.getNet().booleanValue());
		}
		catch (final JaloPriceFactoryException e)
		{
			throw new SystemException(e.getMessage(), e);
		}
	}

	@Override
	public List<TaxInformation> getTaxInformation(final BaseCriteria priceCriteria)
	{
		final Product productItem = getModelService().getSource(priceCriteria.getProduct()); //NOSONAR
		Date forDate = priceCriteria.getDate();
		if (forDate == null)
		{
			forDate = timeService.getCurrentTime();
		}
		try
		{
			return productItem.getTaxInformations(forDate);
		}
		catch (final JaloPriceFactoryException e)
		{
			throw new SystemException(e.getMessage(), e);
		}
	}

	@Override
	public boolean isNetUser(final UserModel user)
	{
		final User userItem = getModelService().getSource(user);
		return getCurrentPriceFactory().isNetUser(userItem);
	}

	private ProductDateNet provideSearchParameters(final BaseCriteria priceCriteria)
	{
		final Product productItem = getModelService().getSource(priceCriteria.getProduct()); //NOSONAR
		Date forDate = priceCriteria.getDate();
		if (forDate == null)
		{
			forDate = timeService.getCurrentTime();
		}
		Boolean net = priceCriteria.isNet();
		if (net == null)
		{
			final UserModel currentUser = userService.getCurrentUser();
			final User userItem = getModelService().getSource(currentUser);
			net = Boolean.valueOf(getCurrentPriceFactory().isNetUser(userItem));
		}
		return new ProductDateNet(productItem, forDate, net);
	}

	private static final class ProductDateNet
	{
		private final Product product; //NOSONAR
		private final Date date;
		private final Boolean net;

		public ProductDateNet(final Product product, final Date date, final Boolean net) //NOSONAR
		{
			super();
			this.product = product;
			this.date = date;
			this.net = net;
		}

		public Product getProduct() //NOSONAR
		{
			return product;
		}

		public Date getDate()
		{
			return date;
		}

		public Boolean getNet()
		{
			return net;
		}
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
	}

	public PriceFactory getCurrentPriceFactory()
	{
		// Actually OrderManager.getPriceFactory() implements default / session specific price
		// factory fetching. So no need to do it twice.
		return OrderManager.getInstance().getPriceFactory();
	}


}
