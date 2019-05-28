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
package de.hybris.platform.adaptivesearchbackoffice.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsBoostItemConfiguration;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractEditorData;
import de.hybris.platform.core.PK;

public  class AbstractBoostItemConfigurationEditorData extends AbstractEditorData 
{

 

	/** <i>Generated property</i> for <code>AbstractBoostItemConfigurationEditorData.itemPk</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private PK itemPk;

	/** <i>Generated property</i> for <code>AbstractBoostItemConfigurationEditorData.boostItemConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private AbstractAsBoostItemConfiguration boostItemConfiguration;
	
	public AbstractBoostItemConfigurationEditorData()
	{
		// default constructor
	}
	
		
	
	public void setItemPk(final PK itemPk)
	{
		this.itemPk = itemPk;
	}

		
	
	public PK getItemPk() 
	{
		return itemPk;
	}
	
		
	
	public void setBoostItemConfiguration(final AbstractAsBoostItemConfiguration boostItemConfiguration)
	{
		this.boostItemConfiguration = boostItemConfiguration;
	}

		
	
	public AbstractAsBoostItemConfiguration getBoostItemConfiguration() 
	{
		return boostItemConfiguration;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final AbstractBoostItemConfigurationEditorData other = (AbstractBoostItemConfigurationEditorData) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getItemPk(), other.getItemPk()) 
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
		.append(getItemPk()) 
		.toHashCode();
	}

}
