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

import com.hybris.mobile.lib.commerce.data.search.facetdata.FacetValue;
import java.util.List;

/**
 * POJO representing a facet.
 */
public class Facet  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Facet.visible</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean visible;
	/** <i>Generated property</i> for <code>Facet.values</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<FacetValue> values;
	/** <i>Generated property</i> for <code>Facet.name</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String name;
	/** <i>Generated property</i> for <code>Facet.priority</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer priority;
	/** <i>Generated property</i> for <code>Facet.category</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean category;
	/** <i>Generated property</i> for <code>Facet.topValues</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<FacetValue> topValues;
	/** <i>Generated property</i> for <code>Facet.multiSelect</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean multiSelect;
		
	public Facet()
	{
		// default constructor
	}
	
		
	public void setVisible(final Boolean visible)
	{
		this.visible = visible;
	}
	
		
	public Boolean getVisible() 
	{
		return visible;
	}
		
		
	public void setValues(final List<FacetValue> values)
	{
		this.values = values;
	}
	
		
	public List<FacetValue> getValues() 
	{
		return values;
	}
		
		
	public void setName(final String name)
	{
		this.name = name;
	}
	
		
	public String getName() 
	{
		return name;
	}
		
		
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}
	
		
	public Integer getPriority() 
	{
		return priority;
	}
		
		
	public void setCategory(final Boolean category)
	{
		this.category = category;
	}
	
		
	public Boolean getCategory() 
	{
		return category;
	}
		
		
	public void setTopValues(final List<FacetValue> topValues)
	{
		this.topValues = topValues;
	}
	
		
	public List<FacetValue> getTopValues() 
	{
		return topValues;
	}
		
		
	public void setMultiSelect(final Boolean multiSelect)
	{
		this.multiSelect = multiSelect;
	}
	
		
	public Boolean getMultiSelect() 
	{
		return multiSelect;
	}
		
	
}