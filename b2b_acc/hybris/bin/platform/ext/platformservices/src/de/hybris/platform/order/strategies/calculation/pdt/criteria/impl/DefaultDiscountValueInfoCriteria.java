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
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.enums.ProductDiscountGroup;
import de.hybris.platform.europe1.enums.UserDiscountGroup;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.DiscountValueInfoCriteria;

import java.util.Date;


public class DefaultDiscountValueInfoCriteria implements DiscountValueInfoCriteria
{
	private final PDTCriteriaTarget purpose;
	private final Date date;

	private final ProductModel product;
	private final ProductDiscountGroup productDiscountGroup;

	private final UserModel user;
	private final UserDiscountGroup userDiscountGroup;

	private final CurrencyModel currency;
	private final Boolean net;

	DefaultDiscountValueInfoCriteria(final Builder builder)
	{
		purpose = builder.purpose;
		product = builder.product;
		date = builder.date;
		productDiscountGroup = builder.productDiscountGroup;

		user = builder.user;
		userDiscountGroup = builder.userDiscountGroup;

		currency = builder.currencyModel;
		net = builder.net;
	}

	public static DefaultDiscountValueInfoCriteria.Builder buildForValue()
	{
		return new DefaultDiscountValueInfoCriteria.Builder(PDTCriteriaTarget.VALUE);
	}

	public static DefaultDiscountValueInfoCriteria.Builder buildForInfo()
	{
		return new DefaultDiscountValueInfoCriteria.Builder(PDTCriteriaTarget.INFORMATION);
	}

	@Override
	public ProductModel getProduct()
	{
		return product;
	}

	@Override
	public ProductDiscountGroup getProductGroup()
	{
		return productDiscountGroup;
	}

	@Override
	public UserModel getUser()
	{
		return user;
	}

	@Override
	public UserDiscountGroup getUserGroup()
	{
		return userDiscountGroup;
	}

	@Override
	public CurrencyModel getCurrency()
	{
		return currency;
	}

	@Override
	public Date getDate()
	{
		return date;
	}

	@Override
	public Boolean isNet()
	{
		return net;
	}

	@Override
	public PDTCriteriaTarget getPDTCriteriaTarget()
	{
		return purpose;
	}

	public static class Builder
	{
		PDTCriteriaTarget purpose;
		Date date;

		ProductModel product;
		ProductDiscountGroup productDiscountGroup;

		UserModel user;
		UserDiscountGroup userDiscountGroup;

		CurrencyModel currencyModel;
		Boolean net;

		Builder(final PDTCriteriaTarget purpose)
		{
			this.purpose = purpose;
		}

		public Builder withPurpose(final PDTCriteriaTarget purpose)
		{
			this.purpose = purpose;
			return this;
		}

		public Builder withDate(final Date date)
		{
			this.date = date;
			return this;
		}

		public Builder withProduct(final ProductModel product)
		{
			this.product = product;
			return this;
		}

		public Builder withProductDiscountGroup(final ProductDiscountGroup productDiscountGroup)
		{
			this.productDiscountGroup = productDiscountGroup;
			return this;
		}

		public Builder withUser(final UserModel user)
		{
			this.user = user;
			return this;
		}

		public Builder withUserDiscountGroup(final UserDiscountGroup userDiscountGroup)
		{
			this.userDiscountGroup = userDiscountGroup;
			return this;
		}

		public Builder withCurrency(final CurrencyModel currencyModel)
		{
			this.currencyModel = currencyModel;
			return this;
		}

		public Builder withNet(final Boolean net)
		{
			this.net = net;
			return this;
		}

		public DefaultDiscountValueInfoCriteria build()
		{
			return new DefaultDiscountValueInfoCriteria(this);
		}
	}
}
