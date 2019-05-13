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
package de.hybris.platform.order.strategies.calculation.pdt.comparator.impl;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.comparator.PDTRowMatchComparatorProvider;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;

import java.util.Comparator;


public class DefaultPriceRowInfoMatchComparatorProvider implements PDTRowMatchComparatorProvider<PriceValueInfoCriteria, PriceRowModel>
{
	@Override
	public Comparator<PriceRowModel> comparator(final PriceValueInfoCriteria criteria)
	{
		return new PriceRowInfoMatchComparator(criteria.getCurrency(), criteria.isNet());
	}


	public static class PriceRowInfoMatchComparator implements Comparator<PriceRowModel>
	{
		private final CurrencyModel curr;
		private final Boolean net;

		protected PriceRowInfoMatchComparator(final CurrencyModel curr, final Boolean net)
		{
			this.curr = curr;
			this.net = net;
		}

		@Override
		public int compare(final PriceRowModel row1, final PriceRowModel row2)
		{
			final long u1Match = row1.getUnit().getPk().getLongValue();
			final long u2Match = row2.getUnit().getPk().getLongValue();
			if (u1Match != u2Match)
			{
				// just sort by unit pk
				return u1Match < u2Match ? -1 : 1;
			}
			// min quantity
			final long min1 = row1.getMinqtd().longValue();
			final long min2 = row2.getMinqtd().longValue();
			if (min1 != min2)
			{
				// the row with larger min quantity is better
				return min1 > min2 ? -1 : 1;
			}
			// match value
			final int matchValue1 = row1.getMatchValue().intValue();
			final int matchValue2 = row2.getMatchValue().intValue();
			if (matchValue1 != matchValue2)
			{
				// DESC -> row is better if match value is greater !
				return matchValue2 - matchValue1;
			}
			// currency
			final boolean c1Match = curr.equals(row1.getCurrency());
			final boolean c2Match = curr.equals(row2.getCurrency());
			if (c1Match != c2Match)
			{
				// the row matching currency exactly is better
				return c1Match ? -1 : 1;
			}
			// net
			final boolean n1Match = this.net == row1.getNet().booleanValue();
			final boolean n2Match = this.net == row2.getNet().booleanValue();
			if (n1Match != n2Match)
			{
				// the row matching net flag exactly is better
				return n1Match ? -1 : 1;
			}
			// date range
			final boolean row1Range = row1.getStartTime() != null;
			final boolean row2Range = row2.getStartTime() != null;

			if (row1Range != row2Range)
			{
				// rows with range are better
				return row1Range ? -1 : 1;
			}
			return row1.getPk().compareTo(row2.getPk());
		}
	}
}