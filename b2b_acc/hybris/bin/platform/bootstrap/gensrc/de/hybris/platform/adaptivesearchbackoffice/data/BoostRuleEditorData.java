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
package de.hybris.platform.adaptivesearchbackoffice.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsBoostRuleConfiguration;
import de.hybris.platform.adaptivesearch.enums.AsBoostType;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractBoostRuleConfigurationEditorData;

public  class BoostRuleEditorData extends AbstractBoostRuleConfigurationEditorData 
{

 

	/** <i>Generated property</i> for <code>BoostRuleEditorData.indexProperty</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String indexProperty;

	/** <i>Generated property</i> for <code>BoostRuleEditorData.boostType</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private AsBoostType boostType;

	/** <i>Generated property</i> for <code>BoostRuleEditorData.boostTypeSymbol</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String boostTypeSymbol;

	/** <i>Generated property</i> for <code>BoostRuleEditorData.boost</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private Float boost;

	/** <i>Generated property</i> for <code>BoostRuleEditorData.boostRuleConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private AbstractAsBoostRuleConfiguration boostRuleConfiguration;
	
	public BoostRuleEditorData()
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
	
		
	
	public void setBoostType(final AsBoostType boostType)
	{
		this.boostType = boostType;
	}

		
	
	public AsBoostType getBoostType() 
	{
		return boostType;
	}
	
		
	
	public void setBoostTypeSymbol(final String boostTypeSymbol)
	{
		this.boostTypeSymbol = boostTypeSymbol;
	}

		
	
	public String getBoostTypeSymbol() 
	{
		return boostTypeSymbol;
	}
	
		
	
	public void setBoost(final Float boost)
	{
		this.boost = boost;
	}

		
	
	public Float getBoost() 
	{
		return boost;
	}
	
		
	
	public void setBoostRuleConfiguration(final AbstractAsBoostRuleConfiguration boostRuleConfiguration)
	{
		this.boostRuleConfiguration = boostRuleConfiguration;
	}

		
	
	public AbstractAsBoostRuleConfiguration getBoostRuleConfiguration() 
	{
		return boostRuleConfiguration;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final BoostRuleEditorData other = (BoostRuleEditorData) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getIndexProperty(), other.getIndexProperty()) 
			.append(getBoostType(), other.getBoostType()) 
			.append(getBoostTypeSymbol(), other.getBoostTypeSymbol()) 
			.append(getBoost(), other.getBoost()) 
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
		.append(getBoostType()) 
		.append(getBoostTypeSymbol()) 
		.append(getBoost()) 
		.toHashCode();
	}

}
