/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
import de.hybris.platform.solrfacetsearch.config.IndexedTypeSortField;
import de.hybris.platform.solrfacetsearch.model.SolrSortModel;
import java.util.List;
import java.util.Map;

public  class IndexedTypeSort  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>IndexedTypeSort.sort</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private SolrSortModel sort;

	/** <i>Generated property</i> for <code>IndexedTypeSort.code</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>IndexedTypeSort.name</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>IndexedTypeSort.localizedName</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<String,String> localizedName;

	/** <i>Generated property</i> for <code>IndexedTypeSort.applyPromotedItems</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean applyPromotedItems;

	/** <i>Generated property</i> for <code>IndexedTypeSort.highlightPromotedItems</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean highlightPromotedItems;

	/** <i>Generated property</i> for <code>IndexedTypeSort.fields</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private List<IndexedTypeSortField> fields;
	
	public IndexedTypeSort()
	{
		// default constructor
	}
	
		
	@Deprecated 
	public void setSort(final SolrSortModel sort)
	{
		this.sort = sort;
	}

		
	@Deprecated 
	public SolrSortModel getSort() 
	{
		return sort;
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setLocalizedName(final Map<String,String> localizedName)
	{
		this.localizedName = localizedName;
	}

		
	
	public Map<String,String> getLocalizedName() 
	{
		return localizedName;
	}
	
		
	
	public void setApplyPromotedItems(final boolean applyPromotedItems)
	{
		this.applyPromotedItems = applyPromotedItems;
	}

		
	
	public boolean isApplyPromotedItems() 
	{
		return applyPromotedItems;
	}
	
		
	
	public void setHighlightPromotedItems(final boolean highlightPromotedItems)
	{
		this.highlightPromotedItems = highlightPromotedItems;
	}

		
	
	public boolean isHighlightPromotedItems() 
	{
		return highlightPromotedItems;
	}
	
		
	
	public void setFields(final List<IndexedTypeSortField> fields)
	{
		this.fields = fields;
	}

		
	
	public List<IndexedTypeSortField> getFields() 
	{
		return fields;
	}
	


}
