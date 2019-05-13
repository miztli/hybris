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

package de.hybris.platform.order.strategies.calculation.pdt.repository.impl;

import de.hybris.platform.europe1.jalo.PDTRowsQueryBuilder;
import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.query.PDTQueryProvider;
import de.hybris.platform.order.strategies.calculation.pdt.repository.PDTRowRepository;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;


public class GenericPDTRowRepository<CRITERIA extends PDTCriteria, MODEL extends PDTRowModel>
		implements PDTRowRepository<CRITERIA, MODEL>
{
	private PDTQueryProvider<CRITERIA> queryProvider;
	private FlexibleSearchService flexibleSearchService;

	@Override
	public Collection<MODEL> findRows(final CRITERIA criteria)
	{
		final PDTRowsQueryBuilder.QueryWithParams query = queryProvider.query(criteria);
		final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.getQuery());
		searchQuery.addQueryParameters(query.getParams());

		final SearchResult<MODEL> rows = flexibleSearchService.<MODEL> search(searchQuery);
		return rows.getResult();
	}

	@Required
	public void setQueryProvider(final PDTQueryProvider<CRITERIA> queryProvider)
	{
		this.queryProvider = queryProvider;
	}

	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}
}
