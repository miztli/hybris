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
package de.hybris.platform.adaptivesearch.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearch.data.AsMergeConfiguration;
import de.hybris.platform.adaptivesearch.data.AsSearchProfileActivationGroup;
import de.hybris.platform.adaptivesearch.model.AbstractAsSearchProfileModel;
import java.util.List;

public  class AsSearchProfileActivationGroup  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsSearchProfileActivationGroup.mergeConfiguration</code> property defined at extension <code>adaptivesearch</code>. */
		
	private AsMergeConfiguration mergeConfiguration;

	/** <i>Generated property</i> for <code>AsSearchProfileActivationGroup.searchProfiles</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<AbstractAsSearchProfileModel> searchProfiles;

	/** <i>Generated property</i> for <code>AsSearchProfileActivationGroup.groups</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<AsSearchProfileActivationGroup> groups;
	
	public AsSearchProfileActivationGroup()
	{
		// default constructor
	}
	
		
	
	public void setMergeConfiguration(final AsMergeConfiguration mergeConfiguration)
	{
		this.mergeConfiguration = mergeConfiguration;
	}

		
	
	public AsMergeConfiguration getMergeConfiguration() 
	{
		return mergeConfiguration;
	}
	
		
	
	public void setSearchProfiles(final List<AbstractAsSearchProfileModel> searchProfiles)
	{
		this.searchProfiles = searchProfiles;
	}

		
	
	public List<AbstractAsSearchProfileModel> getSearchProfiles() 
	{
		return searchProfiles;
	}
	
		
	
	public void setGroups(final List<AsSearchProfileActivationGroup> groups)
	{
		this.groups = groups;
	}

		
	
	public List<AsSearchProfileActivationGroup> getGroups() 
	{
		return groups;
	}
	


}
