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
 * POJO representing a section of the Breadcrumb.
 */
public class Breadcrumb  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Breadcrumb.facetValueName</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String facetValueName;
	/** <i>Generated property</i> for <code>Breadcrumb.facetName</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String facetName;
	/** <i>Generated property</i> for <code>Breadcrumb.truncateQuery</code> property defined at extension <code>commercewebservicescommons</code>. */
	private SearchState truncateQuery;
	/** <i>Generated property</i> for <code>Breadcrumb.facetValueCode</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String facetValueCode;
	/** <i>Generated property</i> for <code>Breadcrumb.facetCode</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String facetCode;
	/** <i>Generated property</i> for <code>Breadcrumb.removeQuery</code> property defined at extension <code>commercewebservicescommons</code>. */
	private SearchState removeQuery;
		
	public Breadcrumb()
	{
		// default constructor
	}
	
		
	public void setFacetValueName(final String facetValueName)
	{
		this.facetValueName = facetValueName;
	}
	
		
	public String getFacetValueName() 
	{
		return facetValueName;
	}
		
		
	public void setFacetName(final String facetName)
	{
		this.facetName = facetName;
	}
	
		
	public String getFacetName() 
	{
		return facetName;
	}
		
		
	public void setTruncateQuery(final SearchState truncateQuery)
	{
		this.truncateQuery = truncateQuery;
	}
	
		
	public SearchState getTruncateQuery() 
	{
		return truncateQuery;
	}
		
		
	public void setFacetValueCode(final String facetValueCode)
	{
		this.facetValueCode = facetValueCode;
	}
	
		
	public String getFacetValueCode() 
	{
		return facetValueCode;
	}
		
		
	public void setFacetCode(final String facetCode)
	{
		this.facetCode = facetCode;
	}
	
		
	public String getFacetCode() 
	{
		return facetCode;
	}
		
		
	public void setRemoveQuery(final SearchState removeQuery)
	{
		this.removeQuery = removeQuery;
	}
	
		
	public SearchState getRemoveQuery() 
	{
		return removeQuery;
	}
		
	
}