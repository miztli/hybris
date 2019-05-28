/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
package de.hybris.platform.solrfacetsearch.config;

import java.io.Serializable;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.SearchQueryProperty;
import de.hybris.platform.solrfacetsearch.config.SearchQuerySort;
import java.util.Collection;
import java.util.Map;

public  class SearchQueryTemplate  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.name</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.showFacets</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean showFacets;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.restrictFieldsInResponse</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean restrictFieldsInResponse;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.enableHighlighting</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean enableHighlighting;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.group</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean group;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.groupProperty</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private IndexedProperty groupProperty;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.groupLimit</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer groupLimit;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.groupFacets</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean groupFacets;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.pageSize</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer pageSize;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.ftsQueryBuilder</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String ftsQueryBuilder;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.ftsQueryBuilderParameters</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<String,String> ftsQueryBuilderParameters;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.searchQueryProperties</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<String,SearchQueryProperty> searchQueryProperties;

	/** <i>Generated property</i> for <code>SearchQueryTemplate.searchQuerySorts</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Collection<SearchQuerySort> searchQuerySorts;
	
	public SearchQueryTemplate()
	{
		// default constructor
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setShowFacets(final boolean showFacets)
	{
		this.showFacets = showFacets;
	}

		
	
	public boolean isShowFacets() 
	{
		return showFacets;
	}
	
		
	
	public void setRestrictFieldsInResponse(final boolean restrictFieldsInResponse)
	{
		this.restrictFieldsInResponse = restrictFieldsInResponse;
	}

		
	
	public boolean isRestrictFieldsInResponse() 
	{
		return restrictFieldsInResponse;
	}
	
		
	
	public void setEnableHighlighting(final boolean enableHighlighting)
	{
		this.enableHighlighting = enableHighlighting;
	}

		
	
	public boolean isEnableHighlighting() 
	{
		return enableHighlighting;
	}
	
		
	
	public void setGroup(final boolean group)
	{
		this.group = group;
	}

		
	
	public boolean isGroup() 
	{
		return group;
	}
	
		
	
	public void setGroupProperty(final IndexedProperty groupProperty)
	{
		this.groupProperty = groupProperty;
	}

		
	
	public IndexedProperty getGroupProperty() 
	{
		return groupProperty;
	}
	
		
	
	public void setGroupLimit(final Integer groupLimit)
	{
		this.groupLimit = groupLimit;
	}

		
	
	public Integer getGroupLimit() 
	{
		return groupLimit;
	}
	
		
	
	public void setGroupFacets(final boolean groupFacets)
	{
		this.groupFacets = groupFacets;
	}

		
	
	public boolean isGroupFacets() 
	{
		return groupFacets;
	}
	
		
	
	public void setPageSize(final Integer pageSize)
	{
		this.pageSize = pageSize;
	}

		
	
	public Integer getPageSize() 
	{
		return pageSize;
	}
	
		
	
	public void setFtsQueryBuilder(final String ftsQueryBuilder)
	{
		this.ftsQueryBuilder = ftsQueryBuilder;
	}

		
	
	public String getFtsQueryBuilder() 
	{
		return ftsQueryBuilder;
	}
	
		
	
	public void setFtsQueryBuilderParameters(final Map<String,String> ftsQueryBuilderParameters)
	{
		this.ftsQueryBuilderParameters = ftsQueryBuilderParameters;
	}

		
	
	public Map<String,String> getFtsQueryBuilderParameters() 
	{
		return ftsQueryBuilderParameters;
	}
	
		
	
	public void setSearchQueryProperties(final Map<String,SearchQueryProperty> searchQueryProperties)
	{
		this.searchQueryProperties = searchQueryProperties;
	}

		
	
	public Map<String,SearchQueryProperty> getSearchQueryProperties() 
	{
		return searchQueryProperties;
	}
	
		
	
	public void setSearchQuerySorts(final Collection<SearchQuerySort> searchQuerySorts)
	{
		this.searchQuerySorts = searchQuerySorts;
	}

		
	
	public Collection<SearchQuerySort> getSearchQuerySorts() 
	{
		return searchQuerySorts;
	}
	


}
