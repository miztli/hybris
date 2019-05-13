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
import com.hybris.mobile.lib.commerce.data.search.pagedata.Pagination;
import com.hybris.mobile.lib.commerce.data.search.pagedata.Sort;

import java.util.List;

/**
 * POJO containing the result page for product search.
 */
public class ProductSearchPageBase  implements java.io.Serializable
{

	/** <i>Generated property</i> for <code>ProductSearchPage.freeTextSearch</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String freeTextSearch;
	/** <i>Generated property</i> for <code>ProductSearchPage.pagination</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Pagination pagination;
	/** <i>Generated property</i> for <code>ProductSearchPage.currentQuery</code> property defined at extension <code>commercewebservicescommons</code>. */
	private SearchState currentQuery;
	/** <i>Generated property</i> for <code>ProductSearchPage.keywordRedirectUrl</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String keywordRedirectUrl;
	/** <i>Generated property</i> for <code>ProductSearchPage.spellingSuggestion</code> property defined at extension <code>commercewebservicescommons</code>. */
	private SpellingSuggestion spellingSuggestion;
	/** <i>Generated property</i> for <code>ProductSearchPage.categoryCode</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String categoryCode;
	/** <i>Generated property</i> for <code>ProductSearchPage.sorts</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Sort> sorts;
	/** <i>Generated property</i> for <code>ProductSearchPage.breadcrumbs</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Breadcrumb> breadcrumbs;

	/** <i>Generated property</i> for <code>ProductSearchPage.facets</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Facet> facets;
		
	public ProductSearchPageBase()
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
		
		
	public void setPagination(final Pagination pagination)
	{
		this.pagination = pagination;
	}
	
		
	public Pagination getPagination() 
	{
		return pagination;
	}
		
		
	public void setCurrentQuery(final SearchState currentQuery)
	{
		this.currentQuery = currentQuery;
	}
	
		
	public SearchState getCurrentQuery() 
	{
		return currentQuery;
	}
		
		
	public void setKeywordRedirectUrl(final String keywordRedirectUrl)
	{
		this.keywordRedirectUrl = keywordRedirectUrl;
	}
	
		
	public String getKeywordRedirectUrl() 
	{
		return keywordRedirectUrl;
	}
		
		
	public void setSpellingSuggestion(final SpellingSuggestion spellingSuggestion)
	{
		this.spellingSuggestion = spellingSuggestion;
	}
	
		
	public SpellingSuggestion getSpellingSuggestion() 
	{
		return spellingSuggestion;
	}
		
		
	public void setCategoryCode(final String categoryCode)
	{
		this.categoryCode = categoryCode;
	}
	
		
	public String getCategoryCode() 
	{
		return categoryCode;
	}
		
		
	public void setSorts(final List<Sort> sorts)
	{
		this.sorts = sorts;
	}
	
		
	public List<Sort> getSorts() 
	{
		return sorts;
	}
		
		
	public void setBreadcrumbs(final List<Breadcrumb> breadcrumbs)
	{
		this.breadcrumbs = breadcrumbs;
	}
	
		
	public List<Breadcrumb> getBreadcrumbs() 
	{
		return breadcrumbs;
	}

		
	public void setFacets(final List<Facet> facets)
	{
		this.facets = facets;
	}
	
		
	public List<Facet> getFacets() 
	{
		return facets;
	}
		
	
}