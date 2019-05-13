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

package de.hybris.platform.order.strategies.calculation.pdt.filter.impl;

import static java.lang.String.format;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.europe1.channel.strategies.RetrieveChannelStrategy;
import de.hybris.platform.europe1.enums.PriceRowChannel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.filter.PDTRowFilter;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.util.DateRange;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Required;


public class DefaultPriceRowValueFilter implements PDTRowFilter<PriceValueInfoCriteria, PriceRowModel>
{
	CommonI18NService commonI18NService;
	FlexibleSearchService flexibleSearchService;
	RetrieveChannelStrategy retrieveChannelStrategy;

	@Override
	public Collection<PriceRowModel> filter(final Collection<PriceRowModel> collection, final PriceValueInfoCriteria criteria)
	{
		if (collection.isEmpty())
		{
			return Collections.emptyList();
		}

		final CurrencyModel base = getBaseCurrencyModel(criteria.getCurrency());
		final List<UnitModel> convertible = getConvertibleUnits(criteria.getUnit());
		final long quantity = getQuantity(criteria.getQuantity());

		boolean hasChannelRowMatching = false;
		final List<PriceRowModel> ret = new ArrayList<>(collection);
		for (final ListIterator<PriceRowModel> it = ret.listIterator(); it.hasNext();)
		{
			final PriceRowValidator priceRowV = new PriceRowValidator(it.next());

			final PriceRowChannel channel = retrieveChannelStrategy.getChannel(null);

			boolean isPriceRowInvalid = priceRowV.isMinQuantityInvalid(quantity);
			isPriceRowInvalid = isPriceRowInvalid || priceRowV.isCurrencyInvalid(criteria.getCurrency(), base);
			isPriceRowInvalid = isPriceRowInvalid || priceRowV.isUnitInvalid(criteria.getUnit(), convertible);
			isPriceRowInvalid = isPriceRowInvalid || priceRowV.isDateRangeInvalid(criteria.getDate());
			isPriceRowInvalid = isPriceRowInvalid || priceRowV.isGiveAwayModeInvalid(criteria.isGiveAwayMode());
			isPriceRowInvalid = isPriceRowInvalid || priceRowV.isChannelInvalid(channel);

			if (isPriceRowInvalid)
			{
				it.remove();
				continue;
			}
			hasChannelRowMatching = setupHasChannelRowMatching(channel, hasChannelRowMatching, priceRowV);
		}
		removePriceRowsWithoutChannel(ret, hasChannelRowMatching);

		return ret;
	}

	static boolean setupHasChannelRowMatching(final PriceRowChannel channel, boolean hasChannelRowMatching,
			final PriceRowValidator priceRowV)
	{
		if (priceRowV.hasChannelRowMatching(channel))
		{
			hasChannelRowMatching = true;
		}
		return hasChannelRowMatching;
	}

	private static long getQuantity(final long _quantity)
	{
		return _quantity == 0 ? 1 : _quantity;
	}

	CurrencyModel getBaseCurrencyModel(final CurrencyModel curr)
	{
		return curr.getBase().booleanValue() ? null : commonI18NService.getBaseCurrency();
	}

	private List<UnitModel> getConvertibleUnits(final UnitModel unitModel)
	{
		final String myType = unitModel.getUnitType();
		if (myType == null || myType.length() == 0)
		{
			return Collections.emptyList();
		}
		else
		{
			final FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(
					format("select {%s} from {%s} where {%s}= ?type and {%s}<>?me ", UnitModel.PK, UnitModel._TYPECODE,
							UnitModel.UNITTYPE, UnitModel.PK));
			flexibleSearchQuery.addQueryParameter("type", myType);
			flexibleSearchQuery.addQueryParameter("me", unitModel);

			final SearchResult<UnitModel> search = flexibleSearchService.search(flexibleSearchQuery);

			return search.getResult();
		}
	}

	static void removePriceRowsWithoutChannel(final List<PriceRowModel> ret, final boolean hasChannelRowMatching)
	{
		// if there is a possibility to have price row without channel
		if (hasChannelRowMatching && ret.size() > 1)
		{
			//remove price row without channel
			ret.removeIf(p -> p.getChannel() == null);
		}
	}



	static class PriceRowValidator
	{
		private final PriceRowModel priceRow;

		public PriceRowValidator(final PriceRowModel model)
		{
			this.priceRow = model;
		}

		boolean hasChannelRowMatching(final PriceRowChannel channel)
		{
			return channel != null && priceRow.getChannel() != null
					&& priceRow.getChannel().getCode().equalsIgnoreCase(channel.getCode());
		}

		boolean isChannelInvalid(final PriceRowChannel channel)
		{
			return channel != null && priceRow.getChannel() != null
					&& !priceRow.getChannel().getCode().equalsIgnoreCase(channel.getCode());
		}

		boolean isGiveAwayModeInvalid(final boolean giveAwayMode)
		{
			return giveAwayMode != priceRow.getGiveAwayPrice().booleanValue();
		}

		boolean isDateRangeInvalid(final Date date)
		{
			final DateRange dateRange = priceRow.getDateRange();
			return dateRange != null && !dateRange.encloses(date);
		}

		boolean isCurrencyInvalid(final CurrencyModel curr, final CurrencyModel base)
		{
			final CurrencyModel currency = priceRow.getCurrency();
			return !curr.equals(currency) && (base == null || !base.equals(currency));
		}

		boolean isUnitInvalid(final UnitModel unit, final List<UnitModel> convertible)
		{
			final UnitModel user = priceRow.getUnit();
			return !unit.equals(user) && !convertible.contains(user);
		}

		boolean isMinQuantityInvalid(final long quantity)
		{
			return quantity < priceRow.getMinqtd().longValue();
		}

	}


	@Required
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}

	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

	@Required
	public void setRetrieveChannelStrategy(final RetrieveChannelStrategy retrieveChannelStrategy)
	{
		this.retrieveChannelStrategy = retrieveChannelStrategy;
	}


}