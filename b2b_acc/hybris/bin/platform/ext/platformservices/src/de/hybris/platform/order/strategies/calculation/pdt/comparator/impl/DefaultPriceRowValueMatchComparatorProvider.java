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

package de.hybris.platform.order.strategies.calculation.pdt.comparator.impl;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.comparator.PDTRowMatchComparatorProvider;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DefaultPriceRowValueMatchComparatorProvider
		implements PDTRowMatchComparatorProvider<PriceValueInfoCriteria, PriceRowModel>
{
	@Override
	public Comparator<PriceRowModel> comparator(final PriceValueInfoCriteria criteria)
	{
		return new PriceRowValueMatchComparator(criteria.getCurrency(), criteria.isNet(), criteria.getUnit());
	}

	public static class PriceRowValueMatchComparator implements Comparator<PriceRowModel>
	{
		private static final Logger LOG = LoggerFactory.getLogger(PriceRowValueMatchComparator.class);

		private final CurrencyModel curr;
		private final boolean net;
		private final UnitModel unit;

		protected PriceRowValueMatchComparator(final CurrencyModel curr, final boolean net, final UnitModel unit)
		{
			this.curr = curr;
			this.net = net;
			this.unit = unit;
		}

		@Override
		public int compare(final PriceRowModel row1, final PriceRowModel row2)
		{
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

			int compare = 0;
			// the row matching currency exactly is better
			if ((compare = compareBooleans(c1Match, c2Match)) != 0)
			{
				return compare;
			}

			// net
			final boolean n1Match = this.net == row1.getNet().booleanValue();
			final boolean n2Match = this.net == row2.getNet().booleanValue();

			// the row matching net flag exactly is better
			if ((compare = compareBooleans(n1Match, n2Match)) != 0)
			{
				return compare;
			}

			// unit
			final boolean u1Match = unit.equals(row1.getUnit());
			final boolean u2Match = unit.equals(row2.getUnit());

			// the row matching unit exactly is better
			if ((compare = compareBooleans(u1Match, u2Match)) != 0)
			{
				return compare;
			}

			// min quantity
			final long min1 = row1.getMinqtd().longValue();
			final long min2 = row2.getMinqtd().longValue();
			if (min1 != min2)
			{
				// the row with larger min quantity is better
				return min1 > min2 ? -1 : 1;
			}

			// date range
			final boolean row1Range = row1.getStartTime() != null;
			final boolean row2Range = row2.getStartTime() != null;

			// rows with range are better
			if ((compare = compareBooleans(row1Range, row2Range)) != 0)
			{
				return compare;
			}

			LOG.warn("found ambigous price rows {} and {} - using PK to distinguish", row1, row2);

			return row1.getPk().compareTo(row2.getPk());
		}

		private static int compareBooleans(final boolean first, final boolean second)
		{

			if (first != second)
			{
				// the row matching value exactly is better
				return first ? -1 : 1;
			}
			return 0;
		}
	}
}