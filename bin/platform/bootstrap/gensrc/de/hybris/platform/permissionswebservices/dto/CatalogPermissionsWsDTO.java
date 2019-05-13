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
package de.hybris.platform.permissionswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;

/**
 * Permissions for catalog
 */
@ApiModel(value="catalogPermissions", description="Permissions for catalog")
public  class CatalogPermissionsWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** Catalog identifier<br/><br/><i>Generated property</i> for <code>CatalogPermissionsWsDTO.catalogId</code> property defined at extension <code>permissionswebservices</code>. */
	@ApiModelProperty(name="catalogId", value="Catalog identifier", required=true) 	
	private String catalogId;

	/** Catalog version identifier<br/><br/><i>Generated property</i> for <code>CatalogPermissionsWsDTO.catalogVersion</code> property defined at extension <code>permissionswebservices</code>. */
	@ApiModelProperty(name="catalogVersion", value="Catalog version identifier", required=true) 	
	private String catalogVersion;

	/** Permissions map<br/><br/><i>Generated property</i> for <code>CatalogPermissionsWsDTO.permissions</code> property defined at extension <code>permissionswebservices</code>. */
	@ApiModelProperty(name="permissions", value="Permissions map") 	
	private Map<String, String> permissions;

	/** Sync Permissions list<br/><br/><i>Generated property</i> for <code>CatalogPermissionsWsDTO.syncPermissions</code> property defined at extension <code>permissionswebservices</code>. */
	@ApiModelProperty(name="syncPermissions", value="Sync Permissions list") 	
	private List<SyncPermissionsWsDTO> syncPermissions;
	
	public CatalogPermissionsWsDTO()
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
	
		
	
	public void setSyncPermissions(final List<SyncPermissionsWsDTO> syncPermissions)
	{
		this.syncPermissions = syncPermissions;
	}

		
	
	public List<SyncPermissionsWsDTO> getSyncPermissions() 
	{
		return syncPermissions;
	}
	


}
