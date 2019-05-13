/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:21 PM
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
package com.hybris.mobile.lib.commerce.data.search;

import com.hybris.mobile.lib.commerce.data.search.SearchQuery;

public class SearchState  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>SearchState.query</code> property defined at extension <code>commercewebservicescommons</code>. */
	private SearchQuery query;
	/** <i>Generated property</i> for <code>SearchState.url</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String url;
		
	public SearchState()
	{
		// default constructor
	}
	
		
	public void setQuery(final SearchQuery query)
	{
		this.query = query;
	}
	
		
	public SearchQuery getQuery() 
	{
		return query;
	}
		
		
	public void setUrl(final String url)
	{
		this.url = url;
	}
	
		
	public String getUrl() 
	{
		return url;
	}
		
	
}