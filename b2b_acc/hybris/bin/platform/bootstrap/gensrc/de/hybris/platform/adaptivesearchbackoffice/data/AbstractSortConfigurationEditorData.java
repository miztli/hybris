/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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

import de.hybris.platform.adaptivesearch.data.AbstractAsSortConfiguration;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractEditorData;
import java.util.Map;

public  class AbstractSortConfigurationEditorData extends AbstractEditorData 
{

 

	/** <i>Generated property</i> for <code>AbstractSortConfigurationEditorData.code</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>AbstractSortConfigurationEditorData.name</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>AbstractSortConfigurationEditorData.priority</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private Integer priority;

	/** <i>Generated property</i> for <code>AbstractSortConfigurationEditorData.sortConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private AbstractAsSortConfiguration sortConfiguration;
	
	public AbstractSortConfigurationEditorData()
	{
		// default constructor
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setName(final Map<String,String> name)
	{
		this.name = name;
	}

		
	
	public Map<String,String> getName() 
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
	
		
	
	public void setSortConfiguration(final AbstractAsSortConfiguration sortConfiguration)
	{
		this.sortConfiguration = sortConfiguration;
	}

		
	
	public AbstractAsSortConfiguration getSortConfiguration() 
	{
		return sortConfiguration;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final AbstractSortConfigurationEditorData other = (AbstractSortConfigurationEditorData) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getCode(), other.getCode()) 
			.append(getName(), other.getName()) 
			.append(getPriority(), other.getPriority()) 
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
		.append(getCode()) 
		.append(getName()) 
		.append(getPriority()) 
		.toHashCode();
	}

}
