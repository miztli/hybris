/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.commerceservices.search.facetdata;

import java.io.Serializable;

/**
 * POJO representing a spell checker suggestion.
 */
public  class SpellingSuggestionData<STATE>  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SpellingSuggestionData<STATE>.suggestion</code> property defined at extension <code>commerceservices</code>. */
		
	private String suggestion;

	/** <i>Generated property</i> for <code>SpellingSuggestionData<STATE>.query</code> property defined at extension <code>commerceservices</code>. */
		
	private STATE query;
	
	public SpellingSuggestionData()
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
	
		
	
	public void setQuery(final STATE query)
	{
		this.query = query;
	}

		
	
	public STATE getQuery() 
	{
		return query;
	}
	


}
