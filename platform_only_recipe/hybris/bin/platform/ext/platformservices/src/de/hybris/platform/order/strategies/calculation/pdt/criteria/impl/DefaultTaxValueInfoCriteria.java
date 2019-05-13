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
import de.hybris.platform.europe1.enums.ProductTaxGroup;
import de.hybris.platform.europe1.enums.UserTaxGroup;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;

import java.util.Date;


public class DefaultTaxValueInfoCriteria implements TaxValueInfoCriteria
{
	private final PDTCriteriaTarget purpose;
	private final Date date;

	private final ProductModel product;
	private final ProductTaxGroup productTaxGroup;

	private final UserModel user;
	private final UserTaxGroup userTaxGroup;

	private final CurrencyModel currency;

	DefaultTaxValueInfoCriteria(final Builder taxCriteria)
	{
		this.purpose = taxCriteria.purpose;
		this.date = taxCriteria.date;
		this.product = taxCriteria.product;
		this.productTaxGroup = taxCriteria.productTaxGroup;
		this.user = taxCriteria.user;
		this.userTaxGroup = taxCriteria.userTaxGroup;
		this.currency = taxCriteria.currency;
	}

	public static Builder buildForValue()
	{
		return new Builder(PDTCriteriaTarget.VALUE);
	}

	public static Builder buildForInfo()
	{
		return new Builder(PDTCriteriaTarget.INFORMATION);
	}


	@Override
	public ProductModel getProduct()
	{
		return product;
	}

	@Override
	public ProductTaxGroup getProductGroup()
	{
		return productTaxGroup;
	}

	@Override
	public UserModel getUser()
	{
		return user;
	}

	@Override
	public UserTaxGroup getUserGroup()
	{
		return userTaxGroup;
	}

	@Override
	public Date getDate()
	{
		return date;
	}

	@Override
	public CurrencyModel getCurrency()
	{
		return currency;
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
		ProductTaxGroup productTaxGroup;

		UserModel user;
		UserTaxGroup userTaxGroup;

		CurrencyModel currency;

		Builder(final PDTCriteriaTarget purpose)
		{
			this.purpose = purpose;
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

		public Builder withProductTaxGroup(final ProductTaxGroup productTaxGroup)
		{
			this.productTaxGroup = productTaxGroup;
			return this;
		}

		public Builder withUser(final UserModel user)
		{
			this.user = user;
			return this;
		}

		public Builder withUserTaxGroup(final UserTaxGroup userTaxGroup)
		{
			this.userTaxGroup = userTaxGroup;
			return this;
		}

		public Builder withCurrency(final CurrencyModel currency)
		{
			this.currency = currency;
			return this;
		}

		public DefaultTaxValueInfoCriteria build()
		{
			return new DefaultTaxValueInfoCriteria(this);
		}
	}
}
