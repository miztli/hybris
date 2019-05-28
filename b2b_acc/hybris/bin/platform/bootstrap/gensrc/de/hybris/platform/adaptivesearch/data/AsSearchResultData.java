/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
package de.hybris.platform.adaptivesearch.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearch.data.AsDocumentData;
import de.hybris.platform.adaptivesearch.data.AsFacetData;
import de.hybris.platform.adaptivesearch.data.AsSearchProfileResult;
import de.hybris.platform.adaptivesearch.data.AsSortData;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;
import java.util.List;

public  class AsSearchResultData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsSearchResultData.activePage</code> property defined at extension <code>adaptivesearch</code>. */
		
	private int activePage;

	/** <i>Generated property</i> for <code>AsSearchResultData.pageCount</code> property defined at extension <code>adaptivesearch</code>. */
		
	private int pageCount;

	/** <i>Generated property</i> for <code>AsSearchResultData.pageSize</code> property defined at extension <code>adaptivesearch</code>. */
		
	private int pageSize;

	/** <i>Generated property</i> for <code>AsSearchResultData.resultCount</code> property defined at extension <code>adaptivesearch</code>. */
		
	private int resultCount;

	/** <i>Generated property</i> for <code>AsSearchResultData.results</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<AsDocumentData> results;

	/** <i>Generated property</i> for <code>AsSearchResultData.facets</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<AsFacetData> facets;

	/** <i>Generated property</i> for <code>AsSearchResultData.currentSort</code> property defined at extension <code>adaptivesearch</code>. */
		
	private AsSortData currentSort;

	/** <i>Generated property</i> for <code>AsSearchResultData.availableSorts</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<AsSortData> availableSorts;

	/** <i>Generated property</i> for <code>AsSearchResultData.searchProfileResult</code> property defined at extension <code>adaptivesearch</code>. */
		
	private AsSearchProfileResult searchProfileResult;

	/** <i>Generated property</i> for <code>AsSearchResultData.catalogVersions</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<CatalogVersionModel> catalogVersions;

	/** <i>Generated property</i> for <code>AsSearchResultData.categoryPath</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<CategoryModel> categoryPath;
	
	public AsSearchResultData()
	{
		// default constructor
	}
	
		
	
	public void setActivePage(final int activePage)
	{
		this.activePage = activePage;
	}

		
	
	public int getActivePage() 
	{
		return activePage;
	}
	
		
	
	public void setPageCount(final int pageCount)
	{
		this.pageCount = pageCount;
	}

		
	
	public int getPageCount() 
	{
		return pageCount;
	}
	
		
	
	public void setPageSize(final int pageSize)
	{
		this.pageSize = pageSize;
	}

		
	
	public int getPageSize() 
	{
		return pageSize;
	}
	
		
	
	public void setResultCount(final int resultCount)
	{
		this.resultCount = resultCount;
	}

		
	
	public int getResultCount() 
	{
		return resultCount;
	}
	
		
	
	public void setResults(final List<AsDocumentData> results)
	{
		this.results = results;
	}

		
	
	public List<AsDocumentData> getResults() 
	{
		return results;
	}
	
		
	
	public void setFacets(final List<AsFacetData> facets)
	{
		this.facets = facets;
	}

		
	
	public List<AsFacetData> getFacets() 
	{
		return facets;
	}
	
		
	
	public void setCurrentSort(final AsSortData currentSort)
	{
		this.currentSort = currentSort;
	}

		
	
	public AsSortData getCurrentSort() 
	{
		return currentSort;
	}
	
		
	
	public void setAvailableSorts(final List<AsSortData> availableSorts)
	{
		this.availableSorts = availableSorts;
	}

		
	
	public List<AsSortData> getAvailableSorts() 
	{
		return availableSorts;
	}
	
		
	
	public void setSearchProfileResult(final AsSearchProfileResult searchProfileResult)
	{
		this.searchProfileResult = searchProfileResult;
	}

		
	
	public AsSearchProfileResult getSearchProfileResult() 
	{
		return searchProfileResult;
	}
	
		
	
	public void setCatalogVersions(final List<CatalogVersionModel> catalogVersions)
	{
		this.catalogVersions = catalogVersions;
	}

		
	
	public List<CatalogVersionModel> getCatalogVersions() 
	{
		return catalogVersions;
	}
	
		
	
	public void setCategoryPath(final List<CategoryModel> categoryPath)
	{
		this.categoryPath = categoryPath;
	}

		
	
	public List<CategoryModel> getCategoryPath() 
	{
		return categoryPath;
	}
	


}
