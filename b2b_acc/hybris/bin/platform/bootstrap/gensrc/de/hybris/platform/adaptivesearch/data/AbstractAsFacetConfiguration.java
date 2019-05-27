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
package de.hybris.platform.adaptivesearch.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsItemConfiguration;
import de.hybris.platform.adaptivesearch.data.AsExcludedFacetValue;
import de.hybris.platform.adaptivesearch.data.AsPromotedFacetValue;
import de.hybris.platform.adaptivesearch.enums.AsFacetType;
import java.util.List;

public abstract  class AbstractAsFacetConfiguration extends AbstractAsItemConfiguration 
{

 

	/** <i>Generated property</i> for <code>AbstractAsFacetConfiguration.indexProperty</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String indexProperty;

	/** <i>Generated property</i> for <code>AbstractAsFacetConfiguration.priority</code> property defined at extension <code>adaptivesearch</code>. */
		
	private Integer priority;

	/** <i>Generated property</i> for <code>AbstractAsFacetConfiguration.facetType</code> property defined at extension <code>adaptivesearch</code>. */
		
	private AsFacetType facetType;

	/** <i>Generated property</i> for <code>AbstractAsFacetConfiguration.valuesSortProvider</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String valuesSortProvider;

	/** <i>Generated property</i> for <code>AbstractAsFacetConfiguration.valuesDisplayNameProvider</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String valuesDisplayNameProvider;

	/** <i>Generated property</i> for <code>AbstractAsFacetConfiguration.topValuesProvider</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String topValuesProvider;

	/** <i>Generated property</i> for <code>AbstractAsFacetConfiguration.promotedValues</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<AsPromotedFacetValue> promotedValues;

	/** <i>Generated property</i> for <code>AbstractAsFacetConfiguration.excludedValues</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<AsExcludedFacetValue> excludedValues;
	
	public AbstractAsFacetConfiguration()
	{
		// default constructor
	}
	
		
	
	public void setIndexProperty(final String indexProperty)
	{
		this.indexProperty = indexProperty;
	}

		
	
	public String getIndexProperty() 
	{
		return indexProperty;
	}
	
		
	
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}

		
	
	public Integer getPriority() 
	{
		return priority;
	}
	
		
	
	public void setFacetType(final AsFacetType facetType)
	{
		this.facetType = facetType;
	}

		
	
	public AsFacetType getFacetType() 
	{
		return facetType;
	}
	
		
	
	public void setValuesSortProvider(final String valuesSortProvider)
	{
		this.valuesSortProvider = valuesSortProvider;
	}

		
	
	public String getValuesSortProvider() 
	{
		return valuesSortProvider;
	}
	
		
	
	public void setValuesDisplayNameProvider(final String valuesDisplayNameProvider)
	{
		this.valuesDisplayNameProvider = valuesDisplayNameProvider;
	}

		
	
	public String getValuesDisplayNameProvider() 
	{
		return valuesDisplayNameProvider;
	}
	
		
	
	public void setTopValuesProvider(final String topValuesProvider)
	{
		this.topValuesProvider = topValuesProvider;
	}

		
	
	public String getTopValuesProvider() 
	{
		return topValuesProvider;
	}
	
		
	
	public void setPromotedValues(final List<AsPromotedFacetValue> promotedValues)
	{
		this.promotedValues = promotedValues;
	}

		
	
	public List<AsPromotedFacetValue> getPromotedValues() 
	{
		return promotedValues;
	}
	
		
	
	public void setExcludedValues(final List<AsExcludedFacetValue> excludedValues)
	{
		this.excludedValues = excludedValues;
	}

		
	
	public List<AsExcludedFacetValue> getExcludedValues() 
	{
		return excludedValues;
	}
	


}
