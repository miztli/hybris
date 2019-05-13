/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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

import de.hybris.platform.adaptivesearch.data.AbstractAsSearchProfile;
import de.hybris.platform.adaptivesearch.data.AsConfigurableSearchConfiguration;
import de.hybris.platform.adaptivesearch.data.AsReference;
import java.util.Map;

public  class AsGenericSearchProfile extends AbstractAsSearchProfile 
{

 

	/** <i>Generated property</i> for <code>AsGenericSearchProfile.qualifierType</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String qualifierType;

	/** <i>Generated property</i> for <code>AsGenericSearchProfile.availableSearchConfigurations</code> property defined at extension <code>adaptivesearch</code>. */
		
	private Map<String,AsReference> availableSearchConfigurations;

	/** <i>Generated property</i> for <code>AsGenericSearchProfile.searchConfigurations</code> property defined at extension <code>adaptivesearch</code>. */
		
	private Map<String,AsConfigurableSearchConfiguration> searchConfigurations;
	
	public AsGenericSearchProfile()
	{
		// default constructor
	}
	
		
	
	public void setQualifierType(final String qualifierType)
	{
		this.qualifierType = qualifierType;
	}

		
	
	public String getQualifierType() 
	{
		return qualifierType;
	}
	
		
	
	public void setAvailableSearchConfigurations(final Map<String,AsReference> availableSearchConfigurations)
	{
		this.availableSearchConfigurations = availableSearchConfigurations;
	}

		
	
	public Map<String,AsReference> getAvailableSearchConfigurations() 
	{
		return availableSearchConfigurations;
	}
	
		
	
	public void setSearchConfigurations(final Map<String,AsConfigurableSearchConfiguration> searchConfigurations)
	{
		this.searchConfigurations = searchConfigurations;
	}

		
	
	public Map<String,AsConfigurableSearchConfiguration> getSearchConfigurations() 
	{
		return searchConfigurations;
	}
	


}
