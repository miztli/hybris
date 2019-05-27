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
package de.hybris.platform.permissionsfacades.data;

import java.io.Serializable;

public  class SyncPermissionsData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SyncPermissionsData.targetCatalogVersion</code> property defined at extension <code>permissionsfacades</code>. */
		
	private String targetCatalogVersion;

	/** <i>Generated property</i> for <code>SyncPermissionsData.canSynchronize</code> property defined at extension <code>permissionsfacades</code>. */
		
	private boolean canSynchronize;
	
	public SyncPermissionsData()
	{
		// default constructor
	}
	
		
	
	public void setTargetCatalogVersion(final String targetCatalogVersion)
	{
		this.targetCatalogVersion = targetCatalogVersion;
	}

		
	
	public String getTargetCatalogVersion() 
	{
		return targetCatalogVersion;
	}
	
		
	
	public void setCanSynchronize(final boolean canSynchronize)
	{
		this.canSynchronize = canSynchronize;
	}

		
	
	public boolean isCanSynchronize() 
	{
		return canSynchronize;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final SyncPermissionsData other = (SyncPermissionsData) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getTargetCatalogVersion(), other.getTargetCatalogVersion()) 
			.append(isCanSynchronize(), other.isCanSynchronize())
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
		.append(getTargetCatalogVersion()) 
		.append(isCanSynchronize())
		.toHashCode();
	}

}
