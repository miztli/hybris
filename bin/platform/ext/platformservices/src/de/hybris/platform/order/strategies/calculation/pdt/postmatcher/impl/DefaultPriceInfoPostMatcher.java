/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.order.strategies.calculation.pdt.postmatcher.impl;

import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.europe1.channel.strategies.RetrieveChannelStrategy;
import de.hybris.platform.europe1.enums.PriceRowChannel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Required;


public class DefaultPriceInfoPostMatcher extends DefaultPriceValuePostMatcher
{

	RetrieveChannelStrategy retrieveChannelStrategy;

	@Override
	public Collection<PriceRowModel> process(final Collection<PriceRowModel> models, final PriceValueInfoCriteria criteria)
			throws CalculationException
	{

		final List<PriceRowModel> priceRows = filterPriceRows(models);
		final List<PriceRowModel> priceRowModels = new ArrayList<>(priceRows.size());
		final List<PriceRowModel> defaultPriceModels = new ArrayList<>(priceRows.size());

		final PriceRowChannel channel = retrieveChannelStrategy.getChannel(null);

		for (final PriceRowModel row : priceRows)
		{

			if (row.getChannel() == null)
			{
				defaultPriceModels.add(row);
			}

			// if its coming from a default channel should return only default PriceRows (default is null channel)
			if (channel == null && row.getChannel() == null)
			{
				priceRowModels.add(row);
			}
			// if its coming from a specific channel then it should match with the PriceRow channel
			else if (channel != null && row.getChannel() != null && row.getChannel().getCode().equalsIgnoreCase(channel.getCode()))
			{
				priceRowModels.add(row);
			}
		}
		// If no PriceRow was found for the specified channel then it should return the default list.
		if (priceRowModels.isEmpty())
		{
			return defaultPriceModels;
		}
		else
		{
			return priceRowModels;
		}
	}


	/**
	 * Removes price rows from set of matching rows if they will never be applicable. This may be the case if two rows have
	 * different match values (e.g. product only vs. user+product) but same unit and minimum quantity - only the better
	 * matching will ever apply so we omit the second one. We expect the price rows ordered as follows:
	 * <ul>
	 * <li>unit - order unimportant</li>
	 * <li>minimum quantity - ascending</li>
	 * <li>match value - greatest at top</li>
	 * <li>currency - requested currency on top ; only if requested currency is not base currency )</li>
	 * <li>net - requested net state is on top</li>
	 * <li>date range - non-null date ranges at top</li>
	 * </ul>
	 */
	protected List<PriceRowModel> filterPriceRows(final Collection<PriceRowModel> priceRows)
	{

		if (priceRows.isEmpty())
		{
			return Collections.emptyList();
		}
		else
		{
			UnitModel lastUnit = null;
			long lastMin = -1;

			final ArrayList<PriceRowModel> ret = new ArrayList<>(priceRows);
			for (final ListIterator<PriceRowModel> it = ret.listIterator(); it.hasNext();)
			{
				final PriceRowModel row = it.next();

				final long min = row.getMinqtd();
				final UnitModel unit = row.getUnit();
				// all rows with same unit and minimum quantity as previous row
				// (since rows are sorted we  just have to check lastMin == min !!!)
				if (lastUnit != null && lastUnit.equals(unit) && lastMin == min)
				{
					it.remove();
				}
				else
				{
					lastUnit = unit;
					lastMin = min;
				}
			}
			return ret;
		}
	}

	@Required
	public void setRetrieveChannelStrategy(final RetrieveChannelStrategy retrieveChannelStrategy)
	{
		this.retrieveChannelStrategy = retrieveChannelStrategy;
	}

}
