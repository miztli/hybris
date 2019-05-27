/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:21 PM
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

import de.hybris.platform.commerceservices.search.facetdata.FacetSearchPageData;
import de.hybris.platform.commerceservices.search.facetdata.SpellingSuggestionData;

/**
 * POJO containing the result page for product search.
 */
public  class ProductSearchPageData<STATE, RESULT> extends FacetSearchPageData<STATE, RESULT> 
{

 

	/** <i>Generated property</i> for <code>ProductSearchPageData<STATE, RESULT>.freeTextSearch</code> property defined at extension <code>commerceservices</code>. */
		
	private String freeTextSearch;

	/** <i>Generated property</i> for <code>ProductSearchPageData<STATE, RESULT>.categoryCode</code> property defined at extension <code>commerceservices</code>. */
		
	private String categoryCode;

	/** <i>Generated property</i> for <code>ProductSearchPageData<STATE, RESULT>.keywordRedirectUrl</code> property defined at extension <code>commerceservices</code>. */
		
	private String keywordRedirectUrl;

	/** <i>Generated property</i> for <code>ProductSearchPageData<STATE, RESULT>.spellingSuggestion</code> property defined at extension <code>commerceservices</code>. */
		
	private SpellingSuggestionData<STATE> spellingSuggestion;
	
	public ProductSearchPageData()
	{
		// default constructor
	}
	
		
	
	public void setFreeTextSearch(final String freeTextSearch)
	{
		this.freeTextSearch = freeTextSearch;
	}

		
	
	public String getFreeTextSearch() 
	{
		return freeTextSearch;
	}
	
		
	
	public void setCategoryCode(final String categoryCode)
	{
		this.categoryCode = categoryCode;
	}

		
	
	public String getCategoryCode() 
	{
		return categoryCode;
	}
	
		
	
	public void setKeywordRedirectUrl(final String keywordRedirectUrl)
	{
		this.keywordRedirectUrl = keywordRedirectUrl;
	}

		
	
	public String getKeywordRedirectUrl() 
	{
		return keywordRedirectUrl;
	}
	
		
	
	public void setSpellingSuggestion(final SpellingSuggestionData<STATE> spellingSuggestion)
	{
		this.spellingSuggestion = spellingSuggestion;
	}

		
	
	public SpellingSuggestionData<STATE> getSpellingSuggestion() 
	{
		return spellingSuggestion;
	}
	


}
