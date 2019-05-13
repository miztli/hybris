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

/**
 * POJO for Sync permission
 */
public  class SyncPermissionsWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SyncPermissionsWsDTO.targetCatalogVersion</code> property defined at extension <code>permissionswebservices</code>. */
		
	private String targetCatalogVersion;

	/** <i>Generated property</i> for <code>SyncPermissionsWsDTO.canSynchronize</code> property defined at extension <code>permissionswebservices</code>. */
		
	private boolean canSynchronize;
	
	public SyncPermissionsWsDTO()
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
	


}
