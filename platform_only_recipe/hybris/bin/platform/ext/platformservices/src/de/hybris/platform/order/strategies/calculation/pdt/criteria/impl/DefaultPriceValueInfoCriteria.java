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
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.enums.ProductPriceGroup;
import de.hybris.platform.europe1.enums.UserPriceGroup;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;

import java.util.Date;


public class DefaultPriceValueInfoCriteria implements PriceValueInfoCriteria
{
	private final PDTCriteriaTarget purpose;
	private final ProductModel product;
	private final ProductPriceGroup productPriceGroup;
	private final UserModel user;
	private final UserPriceGroup userPriceGroup;
	private final long quantity;
	private final UnitModel unit;
	private final CurrencyModel currency;
	private final Date date;
	private final Boolean net;
	private final boolean giveAwayMode;
	private final boolean entryRejected;

	DefaultPriceValueInfoCriteria(final Builder builder)
	{
		purpose = builder.purpose;
		product = builder.product;
		productPriceGroup = builder.productPriceGroup;
		user = builder.user;
		userPriceGroup = builder.userPriceGroup;
		quantity = builder.quantity;
		unit = builder.unit;
		currency = builder.currency;
		date = builder.date;
		net = builder.net;
		giveAwayMode = builder.giveAwayMode;
		entryRejected = builder.entryRejected;
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
	public UserModel getUser()
	{
		return user;
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
	public ProductPriceGroup getProductGroup()
	{
		return productPriceGroup;
	}

	@Override
	public UserPriceGroup getUserGroup()
	{
		return userPriceGroup;
	}

	@Override
	public long getQuantity()
	{
		return quantity;
	}

	@Override
	public UnitModel getUnit()
	{
		return unit;
	}

	@Override
	public boolean isGiveAwayMode()
	{
		return giveAwayMode;
	}

	@Override
	public PDTCriteriaTarget getPDTCriteriaTarget()
	{
		return purpose;
	}

	@Override
	public boolean isEntryRejected()
	{
		return entryRejected;
	}

	public static class Builder
	{
		PDTCriteriaTarget purpose;
		ProductModel product;
		ProductPriceGroup productPriceGroup;
		UserModel user;
		UserPriceGroup userPriceGroup;
		long quantity;
		UnitModel unit;
		CurrencyModel currency;
		Date date;
		Boolean net;
		boolean giveAwayMode;
		boolean entryRejected;

		Builder(final PDTCriteriaTarget purpose)
		{
			this.purpose = purpose;
		}

		public Builder withPurpose(final PDTCriteriaTarget purpose)
		{
			this.purpose = purpose;
			return this;
		}

		public Builder withProduct(final ProductModel product)
		{
			this.product = product;
			return this;
		}

		public Builder withProductPriceGroup(final ProductPriceGroup productPriceGroup)
		{
			this.productPriceGroup = productPriceGroup;
			return this;
		}

		public Builder withUser(final UserModel user)
		{
			this.user = user;
			return this;
		}

		public Builder withUserPriceGroup(final UserPriceGroup userPriceGroup)
		{
			this.userPriceGroup = userPriceGroup;
			return this;
		}

		public Builder withQuantity(final long quantity)
		{
			this.quantity = quantity;
			return this;
		}

		public Builder withUnit(final UnitModel unit)
		{
			this.unit = unit;
			return this;
		}

		public Builder withCurrency(final CurrencyModel currency)
		{
			this.currency = currency;
			return this;
		}

		public Builder withDate(final Date date)
		{
			this.date = date;
			return this;
		}

		public Builder withNet(final Boolean net)
		{
			this.net = net;
			return this;
		}

		public Builder withGiveAwayMode(final boolean giveAwayMode)
		{
			this.giveAwayMode = giveAwayMode;
			return this;
		}

		public Builder withEntryRejected(final boolean entryRejected)
		{
			this.entryRejected = entryRejected;
			return this;
		}

		public DefaultPriceValueInfoCriteria build()
		{
			return new DefaultPriceValueInfoCriteria(this);
		}
	}
}
