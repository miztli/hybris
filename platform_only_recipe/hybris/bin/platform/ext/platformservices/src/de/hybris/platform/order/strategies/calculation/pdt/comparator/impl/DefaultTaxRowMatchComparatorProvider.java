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

import de.hybris.platform.europe1.model.TaxRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.comparator.PDTRowMatchComparatorProvider;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;

import java.util.Comparator;


public class DefaultTaxRowMatchComparatorProvider implements PDTRowMatchComparatorProvider<TaxValueInfoCriteria, TaxRowModel>
{
	@Override
	public Comparator<TaxRowModel> comparator(final TaxValueInfoCriteria criteria)
	{
		return new TaxRowMatchComparator();
	}

	protected static class TaxRowMatchComparator implements Comparator<TaxRowModel>
	{
		@Override
		public int compare(final TaxRowModel row1, final TaxRowModel row2)
		{
			// currency
			final boolean c1Set = row1.getCurrency() != null;
			final boolean c2Set = row2.getCurrency() != null;
			if (c1Set != c2Set)
			{
				// the rows having a currency are better
				return c1Set ? -1 : 1;
			}

			// sort by PK otherwise to have a stable order
			return row1.getPk().compareTo(row2.getPk());
		}
	}

}
