/*
 * [y] hybris Platform
 *
 * Copyright (c) {year} SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.platform.order.strategies.calculation.pdt.criteria.impl;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.enums.ProductPriceGroup;
import de.hybris.platform.europe1.enums.UserPriceGroup;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.DiscountValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteriaFactory;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.impl.PDTEnumGroupsHelper;
import de.hybris.platform.servicelayer.internal.i18n.I18NConstants;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Required;


public class DefaultPDTCriteriaFactory implements PDTCriteriaFactory
{
	private PDTEnumGroupsHelper pdtEnumGroupsHelper;
	private UserService userService;
	private SessionService sessionService;

	@Override
	public TaxValueInfoCriteria taxValueCriteriaFromOrderEntry(final AbstractOrderEntryModel orderEntry) throws CalculationException
	{
		final AbstractOrderModel order = orderEntry.getOrder();

		return DefaultTaxValueInfoCriteria.buildForValue() //
				.withProduct(orderEntry.getProduct()) //
				.withProductTaxGroup(pdtEnumGroupsHelper.getPTG(orderEntry)) //
				.withUser(order.getUser()) //
				.withUserTaxGroup(pdtEnumGroupsHelper.getUTG(orderEntry)) //
				.withCurrency(order.getCurrency()) //
				.withDate(order.getDate()) //
				.build();
	}

	@Override
	public TaxValueInfoCriteria taxInfoCriteriaFromPriceCriteria(final BaseCriteria baseCriteria) throws CalculationException
	{
		return DefaultTaxValueInfoCriteria.buildForInfo()//
				.withProduct(baseCriteria.getProduct()) //
				.withProductTaxGroup(pdtEnumGroupsHelper.getPTG(baseCriteria.getProduct())) //
				.withUser(userService.getCurrentUser()) //
				.withUserTaxGroup(pdtEnumGroupsHelper.getUTG(userService.getCurrentUser())).withDate(baseCriteria.getDate()) //
				.withCurrency(sessionService.getAttribute(I18NConstants.CURRENCY_SESSION_ATTR_KEY)) //
				.build();
	}

	@Override
	public DiscountValueInfoCriteria discountValueCriteriaFromOrder(final AbstractOrderModel order) throws CalculationException
	{
		return DefaultDiscountValueInfoCriteria.buildForValue() //
				.withProduct(null) // no product
				.withProductDiscountGroup(null) // no product group
				.withUser(order.getUser()) //
				.withUserDiscountGroup(pdtEnumGroupsHelper.getUDG(order)) //
				.withCurrency(order.getCurrency()) //
				.withDate(order.getDate()) //
				.build();
	}

	@Override
	public DiscountValueInfoCriteria discountValueCriteriaFromOrderEntry(final AbstractOrderEntryModel orderEntry)
			throws CalculationException
	{
		final AbstractOrderModel order = orderEntry.getOrder();

		return DefaultDiscountValueInfoCriteria.buildForValue() //
				.withProduct(orderEntry.getProduct()) //
				.withProductDiscountGroup(pdtEnumGroupsHelper.getPDG(orderEntry)) //
				.withUser(order.getUser()) //
				.withUserDiscountGroup(pdtEnumGroupsHelper.getUDG(orderEntry)) //
				.withCurrency(order.getCurrency()) //
				.withDate(order.getDate()) //
				.build();
	}

	@Override
	public DiscountValueInfoCriteria discountInfoCriteriaFromBaseCriteria(final BaseCriteria baseCriteria)
			throws CalculationException
	{
		final UserModel user = sessionService.getAttribute("user");
		final ProductModel product = baseCriteria.getProduct();

		return DefaultDiscountValueInfoCriteria.buildForInfo() //
				.withProduct(product) //
				.withProductDiscountGroup(pdtEnumGroupsHelper.getPDG(product)) //
				.withUser(user) //
				.withUserDiscountGroup(pdtEnumGroupsHelper.getUDG(user)) //
				.withCurrency(sessionService.getAttribute(I18NConstants.CURRENCY_SESSION_ATTR_KEY)) //
				.withDate(baseCriteria.getDate()) //
				.build();
	}

	@Override
	public PriceValueInfoCriteria priceValueCriteriaFromOrderEntry(final AbstractOrderEntryModel orderEntry) throws CalculationException
	{
		final AbstractOrderModel order = orderEntry.getOrder();
		CurrencyModel currency = null;
		ProductPriceGroup productGroup = null;
		UserModel user = null;
		UserPriceGroup userGroup = null;
		UnitModel unit = null;
		long quantity = 0;
		boolean net = false;
		Date date = null;
		final ProductModel product = orderEntry.getProduct();
		final boolean giveAwayMode = orderEntry.getGiveAway().booleanValue();
		final boolean entryRejected = orderEntry.getRejected().booleanValue();

		productGroup = pdtEnumGroupsHelper.getPPG(product);
		user = order.getUser();
		userGroup = pdtEnumGroupsHelper.getUPG(orderEntry);
		quantity = orderEntry.getQuantity().longValue();
		unit = orderEntry.getUnit();
		currency = order.getCurrency();
		date = order.getDate();
		net = order.getNet().booleanValue();


		return DefaultPriceValueInfoCriteria.buildForValue() //
				.withProduct(product) //
				.withProductPriceGroup(productGroup) //
				.withUser(user) //
				.withUserPriceGroup(userGroup) //
				.withCurrency(currency) //
				.withQuantity(quantity) //
				.withUnit(unit) //
				.withDate(date) //
				.withNet(net) //
				.withGiveAwayMode(giveAwayMode) //
				.withEntryRejected(entryRejected) //
				.build();
	}

	@Override
	public PriceValueInfoCriteria priceInfoCriteriaFromBaseCriteria(final BaseCriteria baseCriteria) throws CalculationException
	{
		return DefaultPriceValueInfoCriteria.buildForInfo() //
				.withProduct(baseCriteria.getProduct()) //
				.withProductPriceGroup(pdtEnumGroupsHelper.getPPG(baseCriteria.getProduct())) //
				.withUser(userService.getCurrentUser()) //
				.withUserPriceGroup(pdtEnumGroupsHelper.getUPG(userService.getCurrentUser()))
				.withCurrency(sessionService.getAttribute(I18NConstants.CURRENCY_SESSION_ATTR_KEY))//
				.withNet(baseCriteria.isNet()) //
				.withDate(baseCriteria.getDate()) //
				.build();
	}

	@Required
	public void setPdtEnumGroupsHelper(final PDTEnumGroupsHelper pdtEnumGroupsHelper)
	{
		this.pdtEnumGroupsHelper = pdtEnumGroupsHelper;
	}

	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	@Required
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}
}
