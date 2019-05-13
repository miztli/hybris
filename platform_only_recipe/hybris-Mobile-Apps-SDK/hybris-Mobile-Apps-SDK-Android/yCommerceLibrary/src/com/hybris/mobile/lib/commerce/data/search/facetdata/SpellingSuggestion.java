/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:22 PM
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

/**
 * POJO representing a spell checker suggestion.
 */
public class SpellingSuggestion  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>SpellingSuggestion.suggestion</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String suggestion;
	/** <i>Generated property</i> for <code>SpellingSuggestion.query</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String query;
		
	public SpellingSuggestion()
	{
		// default constructor
	}
	
		
	public void setSuggestion(final String suggestion)
	{
		this.suggestion = suggestion;
	}
	
		
	public String getSuggestion() 
	{
		return suggestion;
	}
		
		
	public void setQuery(final String query)
	{
		this.query = query;
	}
	
		
	public String getQuery() 
	{
		return query;
	}
		
	
}