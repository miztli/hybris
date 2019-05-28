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
package de.hybris.platform.adaptivesearchbackoffice.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsFacetConfiguration;
import de.hybris.platform.adaptivesearch.data.AsFacetData;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractEditorData;

public abstract  class AbstractFacetConfigurationEditorData extends AbstractEditorData 
{

 

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.indexProperty</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String indexProperty;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.priority</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private Integer priority;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.multiselect</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private boolean multiselect;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.facetFiltersCount</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private Integer facetFiltersCount;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.facetConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private AbstractAsFacetConfiguration facetConfiguration;

	/** <i>Generated property</i> for <code>AbstractFacetConfigurationEditorData.facet</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private AsFacetData facet;
	
	public AbstractFacetConfigurationEditorData()
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
	
		
	
	public void setMultiselect(final boolean multiselect)
	{
		this.multiselect = multiselect;
	}

		
	
	public boolean isMultiselect() 
	{
		return multiselect;
	}
	
		
	
	public void setFacetFiltersCount(final Integer facetFiltersCount)
	{
		this.facetFiltersCount = facetFiltersCount;
	}

		
	
	public Integer getFacetFiltersCount() 
	{
		return facetFiltersCount;
	}
	
		
	
	public void setFacetConfiguration(final AbstractAsFacetConfiguration facetConfiguration)
	{
		this.facetConfiguration = facetConfiguration;
	}

		
	
	public AbstractAsFacetConfiguration getFacetConfiguration() 
	{
		return facetConfiguration;
	}
	
		
	
	public void setFacet(final AsFacetData facet)
	{
		this.facet = facet;
	}

		
	
	public AsFacetData getFacet() 
	{
		return facet;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final AbstractFacetConfigurationEditorData other = (AbstractFacetConfigurationEditorData) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getIndexProperty(), other.getIndexProperty()) 
			.append(getPriority(), other.getPriority()) 
			.append(isMultiselect(), other.isMultiselect())
			.append(getFacetFiltersCount(), other.getFacetFiltersCount()) 
			.isEquals();
		} 
		catch (ClassCastException c)
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return new org.apache.commons.lang.builder.HashCodeBuilder()
		.append(getIndexProperty()) 
		.append(getPriority()) 
		.append(isMultiselect())
		.append(getFacetFiltersCount()) 
		.toHashCode();
	}

}
