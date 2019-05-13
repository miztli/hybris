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
package de.hybris.platform.commerceservices.search.solrfacetsearch.data;

import java.io.Serializable;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.solrfacetsearch.data.IndexedPropertyValueData;
import de.hybris.platform.commerceservices.search.solrfacetsearch.data.SolrSearchQueryData;
import java.util.List;

public  class SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>.searchQueryData</code> property defined at extension <code>commerceservices</code>. */
		
	private SolrSearchQueryData searchQueryData;

	/** <i>Generated property</i> for <code>SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>.pageableData</code> property defined at extension <code>commerceservices</code>. */
		
	private PageableData pageableData;

	/** <i>Generated property</i> for <code>SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>.catalogVersions</code> property defined at extension <code>commerceservices</code>. */
		
	private List<CatalogVersionModel> catalogVersions;

	/** <i>Generated property</i> for <code>SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>.facetSearchConfig</code> property defined at extension <code>commerceservices</code>. */
		
	private FACET_SEARCH_CONFIG_TYPE facetSearchConfig;

	/** <i>Generated property</i> for <code>SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>.indexedType</code> property defined at extension <code>commerceservices</code>. */
		
	private INDEXED_TYPE_TYPE indexedType;

	/** <i>Generated property</i> for <code>SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>.indexedPropertyValues</code> property defined at extension <code>commerceservices</code>. */
		
	private List<IndexedPropertyValueData<INDEXED_PROPERTY_TYPE>> indexedPropertyValues;

	/** <i>Generated property</i> for <code>SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>.currentSort</code> property defined at extension <code>commerceservices</code>. */
		
	private INDEXED_TYPE_SORT_TYPE currentSort;

	/** <i>Generated property</i> for <code>SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>.searchText</code> property defined at extension <code>commerceservices</code>. */
		
	private String searchText;

	/** <i>Generated property</i> for <code>SolrSearchRequest<FACET_SEARCH_CONFIG_TYPE, INDEXED_TYPE_TYPE, INDEXED_PROPERTY_TYPE, SEARCH_QUERY_TYPE, INDEXED_TYPE_SORT_TYPE>.searchQuery</code> property defined at extension <code>commerceservices</code>. */
		
	private SEARCH_QUERY_TYPE searchQuery;
	
	public SolrSearchRequest()
	{
		// default constructor
	}
	
		
	
	public void setSearchQueryData(final SolrSearchQueryData searchQueryData)
	{
		this.searchQueryData = searchQueryData;
	}

		
	
	public SolrSearchQueryData getSearchQueryData() 
	{
		return searchQueryData;
	}
	
		
	
	public void setPageableData(final PageableData pageableData)
	{
		this.pageableData = pageableData;
	}

		
	
	public PageableData getPageableData() 
	{
		return pageableData;
	}
	
		
	
	public void setCatalogVersions(final List<CatalogVersionModel> catalogVersions)
	{
		this.catalogVersions = catalogVersions;
	}

		
	
	public List<CatalogVersionModel> getCatalogVersions() 
	{
		return catalogVersions;
	}
	
		
	
	public void setFacetSearchConfig(final FACET_SEARCH_CONFIG_TYPE facetSearchConfig)
	{
		this.facetSearchConfig = facetSearchConfig;
	}

		
	
	public FACET_SEARCH_CONFIG_TYPE getFacetSearchConfig() 
	{
		return facetSearchConfig;
	}
	
		
	
	public void setIndexedType(final INDEXED_TYPE_TYPE indexedType)
	{
		this.indexedType = indexedType;
	}

		
	
	public INDEXED_TYPE_TYPE getIndexedType() 
	{
		return indexedType;
	}
	
		
	
	public void setIndexedPropertyValues(final List<IndexedPropertyValueData<INDEXED_PROPERTY_TYPE>> indexedPropertyValues)
	{
		this.indexedPropertyValues = indexedPropertyValues;
	}

		
	
	public List<IndexedPropertyValueData<INDEXED_PROPERTY_TYPE>> getIndexedPropertyValues() 
	{
		return indexedPropertyValues;
	}
	
		
	
	public void setCurrentSort(final INDEXED_TYPE_SORT_TYPE currentSort)
	{
		this.currentSort = currentSort;
	}

		
	
	public INDEXED_TYPE_SORT_TYPE getCurrentSort() 
	{
		return currentSort;
	}
	
		
	
	public void setSearchText(final String searchText)
	{
		this.searchText = searchText;
	}

		
	
	public String getSearchText() 
	{
		return searchText;
	}
	
		
	
	public void setSearchQuery(final SEARCH_QUERY_TYPE searchQuery)
	{
		this.searchQuery = searchQuery;
	}

		
	
	public SEARCH_QUERY_TYPE getSearchQuery() 
	{
		return searchQuery;
	}
	


}
