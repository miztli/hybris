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
package de.hybris.platform.commercewebservicescommons.dto.search.facetdata;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.search.facetdata.FacetValueWsDTO;
import java.util.List;

/**
 * POJO representing a facet.
 */
public  class FacetWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FacetWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>FacetWsDTO.priority</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Integer priority;

	/** <i>Generated property</i> for <code>FacetWsDTO.category</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Boolean category;

	/** <i>Generated property</i> for <code>FacetWsDTO.multiSelect</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Boolean multiSelect;

	/** <i>Generated property</i> for <code>FacetWsDTO.visible</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Boolean visible;

	/** <i>Generated property</i> for <code>FacetWsDTO.topValues</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<FacetValueWsDTO> topValues;

	/** <i>Generated property</i> for <code>FacetWsDTO.values</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<FacetValueWsDTO> values;
	
	public FacetWsDTO()
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
	
		
	
	public void setMultiSelect(final Boolean multiSelect)
	{
		this.multiSelect = multiSelect;
	}

		
	
	public Boolean getMultiSelect() 
	{
		return multiSelect;
	}
	
		
	
	public void setVisible(final Boolean visible)
	{
		this.visible = visible;
	}

		
	
	public Boolean getVisible() 
	{
		return visible;
	}
	
		
	
	public void setTopValues(final List<FacetValueWsDTO> topValues)
	{
		this.topValues = topValues;
	}

		
	
	public List<FacetValueWsDTO> getTopValues() 
	{
		return topValues;
	}
	
		
	
	public void setValues(final List<FacetValueWsDTO> values)
	{
		this.values = values;
	}

		
	
	public List<FacetValueWsDTO> getValues() 
	{
		return values;
	}
	


}
