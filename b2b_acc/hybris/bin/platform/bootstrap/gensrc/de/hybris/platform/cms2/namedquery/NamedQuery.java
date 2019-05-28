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
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
 * ----------------------------------------------------------------
 */
package de.hybris.platform.cms2.namedquery;

import de.hybris.platform.cms2.namedquery.Sort;
import java.util.List;
import java.util.Map;

public class NamedQuery {

	/** <i>Generated property</i> for <code>NamedQuery.queryName</code> property defined at extension <code>cms2</code>. */
	private String queryName;
	/** <i>Generated property</i> for <code>NamedQuery.sort</code> property defined at extension <code>cms2</code>. */
	private List<Sort> sort;
	/** <i>Generated property</i> for <code>NamedQuery.currentPage</code> property defined at extension <code>cms2</code>. */
	private Integer currentPage;
	/** <i>Generated property</i> for <code>NamedQuery.pageSize</code> property defined at extension <code>cms2</code>. */
	private Integer pageSize;
	/** <i>Generated property</i> for <code>NamedQuery.parameters</code> property defined at extension <code>cms2</code>. */
	private Map<String, ? extends Object> parameters;


		public void setQueryName(final String queryName)
	{
		this.queryName = queryName;
	}

	public NamedQuery withQueryName(final String queryName)
	{
		this.queryName = queryName;
		return this;
	}

			
	public String getQueryName() 
	{
		return queryName;
	}

	
		public void setSort(final List<Sort> sort)
	{
		this.sort = sort;
	}

	public NamedQuery withSort(final List<Sort> sort)
	{
		this.sort = sort;
		return this;
	}

			
	public List<Sort> getSort() 
	{
		return sort;
	}

	
		public void setCurrentPage(final Integer currentPage)
	{
		this.currentPage = currentPage;
	}

	public NamedQuery withCurrentPage(final Integer currentPage)
	{
		this.currentPage = currentPage;
		return this;
	}

			
	public Integer getCurrentPage() 
	{
		return currentPage;
	}

	
		public void setPageSize(final Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	public NamedQuery withPageSize(final Integer pageSize)
	{
		this.pageSize = pageSize;
		return this;
	}

			
	public Integer getPageSize() 
	{
		return pageSize;
	}

	
		public void setParameters(final Map<String, ? extends Object> parameters)
	{
		this.parameters = parameters;
	}

	public NamedQuery withParameters(final Map<String, ? extends Object> parameters)
	{
		this.parameters = parameters;
		return this;
	}

			
	public Map<String, ? extends Object> getParameters() 
	{
		return parameters;
	}

	}
