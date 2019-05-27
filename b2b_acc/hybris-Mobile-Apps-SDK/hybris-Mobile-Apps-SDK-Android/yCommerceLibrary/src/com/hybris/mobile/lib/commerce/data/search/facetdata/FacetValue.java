/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:23 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.hybris.mobile.lib.commerce.data.search.facetdata;

import com.hybris.mobile.lib.commerce.data.search.SearchState;

/**
 * POJO representing a facet value.
 */
public class FacetValue  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>FacetValue.query</code> property defined at extension <code>commercewebservicescommons</code>. */
	private SearchState query;
	/** <i>Generated property</i> for <code>FacetValue.name</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String name;
	/** <i>Generated property</i> for <code>FacetValue.count</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long count;
	/** <i>Generated property</i> for <code>FacetValue.selected</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean selected;
		
	public FacetValue()
	{
		// default constructor
	}
	
		
	public void setQuery(final SearchState query)
	{
		this.query = query;
	}
	
		
	public SearchState getQuery() 
	{
		return query;
	}
		
		
	public void setName(final String name)
	{
		this.name = name;
	}
	
		
	public String getName() 
	{
		return name;
	}
		
		
	public void setCount(final Long count)
	{
		this.count = count;
	}
	
		
	public Long getCount() 
	{
		return count;
	}
		
		
	public void setSelected(final Boolean selected)
	{
		this.selected = selected;
	}
	
		
	public Boolean getSelected() 
	{
		return selected;
	}
		
	
}