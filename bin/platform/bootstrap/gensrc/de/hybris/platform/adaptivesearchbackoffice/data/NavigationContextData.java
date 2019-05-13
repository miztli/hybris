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
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearchbackoffice.data.CatalogVersionData;
import de.hybris.platform.adaptivesearchbackoffice.data.CategoryData;
import java.util.List;

public  class NavigationContextData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationContextData.indexConfiguration</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String indexConfiguration;

	/** <i>Generated property</i> for <code>NavigationContextData.indexType</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String indexType;

	/** <i>Generated property</i> for <code>NavigationContextData.catalogVersion</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private CatalogVersionData catalogVersion;

	/** <i>Generated property</i> for <code>NavigationContextData.category</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private CategoryData category;

	/** <i>Generated property</i> for <code>NavigationContextData.currentSearchProfile</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String currentSearchProfile;

	/** <i>Generated property</i> for <code>NavigationContextData.searchProfiles</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private List<String> searchProfiles;
	
	public NavigationContextData()
	{
		// default constructor
	}
	
		
	
	public void setIndexConfiguration(final String indexConfiguration)
	{
		this.indexConfiguration = indexConfiguration;
	}

		
	
	public String getIndexConfiguration() 
	{
		return indexConfiguration;
	}
	
		
	
	public void setIndexType(final String indexType)
	{
		this.indexType = indexType;
	}

		
	
	public String getIndexType() 
	{
		return indexType;
	}
	
		
	
	public void setCatalogVersion(final CatalogVersionData catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

		
	
	public CatalogVersionData getCatalogVersion() 
	{
		return catalogVersion;
	}
	
		
	
	public void setCategory(final CategoryData category)
	{
		this.category = category;
	}

		
	
	public CategoryData getCategory() 
	{
		return category;
	}
	
		
	
	public void setCurrentSearchProfile(final String currentSearchProfile)
	{
		this.currentSearchProfile = currentSearchProfile;
	}

		
	
	public String getCurrentSearchProfile() 
	{
		return currentSearchProfile;
	}
	
		
	
	public void setSearchProfiles(final List<String> searchProfiles)
	{
		this.searchProfiles = searchProfiles;
	}

		
	
	public List<String> getSearchProfiles() 
	{
		return searchProfiles;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final NavigationContextData other = (NavigationContextData) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getIndexConfiguration(), other.getIndexConfiguration()) 
			.append(getIndexType(), other.getIndexType()) 
			.append(getCatalogVersion(), other.getCatalogVersion()) 
			.append(getCategory(), other.getCategory()) 
			.append(getSearchProfiles(), other.getSearchProfiles()) 
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
		.append(getIndexConfiguration()) 
		.append(getIndexType()) 
		.append(getCatalogVersion()) 
		.append(getCategory()) 
		.append(getSearchProfiles()) 
		.toHashCode();
	}

}
