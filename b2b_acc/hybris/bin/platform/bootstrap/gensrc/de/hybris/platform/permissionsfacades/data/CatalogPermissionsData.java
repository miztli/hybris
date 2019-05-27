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
import de.hybris.platform.permissionsfacades.data.SyncPermissionsData;
import java.util.List;
import java.util.Map;

public  class CatalogPermissionsData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogPermissionsData.catalogId</code> property defined at extension <code>permissionsfacades</code>. */
		
	private String catalogId;

	/** <i>Generated property</i> for <code>CatalogPermissionsData.catalogVersion</code> property defined at extension <code>permissionsfacades</code>. */
		
	private String catalogVersion;

	/** <i>Generated property</i> for <code>CatalogPermissionsData.permissions</code> property defined at extension <code>permissionsfacades</code>. */
		
	private Map<String, String> permissions;

	/** <i>Generated property</i> for <code>CatalogPermissionsData.syncPermissions</code> property defined at extension <code>permissionsfacades</code>. */
		
	private List<SyncPermissionsData> syncPermissions;
	
	public CatalogPermissionsData()
	{
		// default constructor
	}
	
		
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

		
	
	public String getCatalogId() 
	{
		return catalogId;
	}
	
		
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

		
	
	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
		
	
	public void setPermissions(final Map<String, String> permissions)
	{
		this.permissions = permissions;
	}

		
	
	public Map<String, String> getPermissions() 
	{
		return permissions;
	}
	
		
	
	public void setSyncPermissions(final List<SyncPermissionsData> syncPermissions)
	{
		this.syncPermissions = syncPermissions;
	}

		
	
	public List<SyncPermissionsData> getSyncPermissions() 
	{
		return syncPermissions;
	}
	


}
