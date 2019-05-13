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
package de.hybris.platform.commercewebservicescommons.dto.search.facetdata;

import java.io.Serializable;

/**
 * POJO representing a spell checker suggestion.
 */
public  class SpellingSuggestionWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SpellingSuggestionWsDTO.suggestion</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String suggestion;

	/** <i>Generated property</i> for <code>SpellingSuggestionWsDTO.query</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String query;
	
	public SpellingSuggestionWsDTO()
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
