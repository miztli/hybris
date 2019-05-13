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
package de.hybris.platform.order.strategies.calculation.pdt.matcher.impl;

import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.comparator.PDTRowMatchComparatorProvider;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.filter.PDTRowFilter;
import de.hybris.platform.order.strategies.calculation.pdt.matcher.PDTModelMatcher;
import de.hybris.platform.order.strategies.calculation.pdt.repository.PDTRowRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * The generic implementation of the {@link PDTModelMatcher}.
 */
public class GenericPDTModelMatcher implements PDTModelMatcher<PDTCriteria, PDTRowModel>
{
	private PDTRowRepository<PDTCriteria, PDTRowModel> rowRepository;
	private PDTRowFilter<PDTCriteria, PDTRowModel> rowFilter;
	private PDTRowMatchComparatorProvider<PDTCriteria, PDTRowModel> rowMatchComparatorProvider;

	/**
	 * Finds rows using {@link PDTRowRepository}, filters rows using {@link PDTRowFilter} and sorts rows using
	 * {@link PDTRowMatchComparatorProvider}.
	 *
	 * @param criteria
	 *           the criteria
	 * @return the list
	 */
	@Override
	public List<PDTRowModel> matchRows(final PDTCriteria criteria)
	{
		criteria.validate();
		final Collection<PDTRowModel> rows = rowRepository.findRows(criteria);
		final Collection<PDTRowModel> filteredCollection = rowFilter.filter(rows, criteria);
		final List<PDTRowModel> list = new ArrayList<>(filteredCollection);
		list.sort(rowMatchComparatorProvider.comparator(criteria));

		return list;
	}

	@Required
	public void setRowRepository(final PDTRowRepository<PDTCriteria, PDTRowModel> rowRepository)
	{
		this.rowRepository = rowRepository;
	}

	@Required
	public void setRowFilter(final PDTRowFilter<PDTCriteria, PDTRowModel> rowFilter)
	{
		this.rowFilter = rowFilter;
	}

	@Required
	public void setRowMatchComparatorProvider(
			final PDTRowMatchComparatorProvider<PDTCriteria, PDTRowModel> rowMatchComparatorProvider)
	{
		this.rowMatchComparatorProvider = rowMatchComparatorProvider;
	}


}
