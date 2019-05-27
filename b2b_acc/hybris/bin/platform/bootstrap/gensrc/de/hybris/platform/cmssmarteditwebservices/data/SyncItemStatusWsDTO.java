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
package de.hybris.platform.cmssmarteditwebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * DTO that contains the complex synchronization status of the page
 */
@ApiModel(value="syncItemStatus", description="DTO that contains the complex synchronization status of the page")
public  class SyncItemStatusWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.itemId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="itemId") 	
	private String itemId;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.itemType</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="itemType") 	
	private String itemType;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.name</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="name") 	
	private String name;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.status</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="status") 	
	private String status;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.lastSyncStatus</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="lastSyncStatus") 	
	private Long lastSyncStatus;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.catalogVersionUuid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="catalogVersionUuid") 	
	private String catalogVersionUuid;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.dependentItemTypesOutOfSync</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="dependentItemTypesOutOfSync") 	
	private List<ItemTypeWsDTO> dependentItemTypesOutOfSync;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.selectedDependencies</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="selectedDependencies") 	
	private List<SyncItemStatusWsDTO> selectedDependencies;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.sharedDependencies</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="sharedDependencies") 	
	private List<SyncItemStatusWsDTO> sharedDependencies;

	/** <i>Generated property</i> for <code>SyncItemStatusWsDTO.unavailableDependencies</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="unavailableDependencies") 	
	private List<SyncItemStatusWsDTO> unavailableDependencies;
	
	public SyncItemStatusWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setItemId(final String itemId)
	{
		this.itemId = itemId;
	}

		
	
	public String getItemId() 
	{
		return itemId;
	}
	
		
	
	public void setItemType(final String itemType)
	{
		this.itemType = itemType;
	}

		
	
	public String getItemType() 
	{
		return itemType;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

		
	
	public String getStatus() 
	{
		return status;
	}
	
		
	
	public void setLastSyncStatus(final Long lastSyncStatus)
	{
		this.lastSyncStatus = lastSyncStatus;
	}

		
	
	public Long getLastSyncStatus() 
	{
		return lastSyncStatus;
	}
	
		
	
	public void setCatalogVersionUuid(final String catalogVersionUuid)
	{
		this.catalogVersionUuid = catalogVersionUuid;
	}

		
	
	public String getCatalogVersionUuid() 
	{
		return catalogVersionUuid;
	}
	
		
	
	public void setDependentItemTypesOutOfSync(final List<ItemTypeWsDTO> dependentItemTypesOutOfSync)
	{
		this.dependentItemTypesOutOfSync = dependentItemTypesOutOfSync;
	}

		
	
	public List<ItemTypeWsDTO> getDependentItemTypesOutOfSync() 
	{
		return dependentItemTypesOutOfSync;
	}
	
		
	
	public void setSelectedDependencies(final List<SyncItemStatusWsDTO> selectedDependencies)
	{
		this.selectedDependencies = selectedDependencies;
	}

		
	
	public List<SyncItemStatusWsDTO> getSelectedDependencies() 
	{
		return selectedDependencies;
	}
	
		
	
	public void setSharedDependencies(final List<SyncItemStatusWsDTO> sharedDependencies)
	{
		this.sharedDependencies = sharedDependencies;
	}

		
	
	public List<SyncItemStatusWsDTO> getSharedDependencies() 
	{
		return sharedDependencies;
	}
	
		
	
	public void setUnavailableDependencies(final List<SyncItemStatusWsDTO> unavailableDependencies)
	{
		this.unavailableDependencies = unavailableDependencies;
	}

		
	
	public List<SyncItemStatusWsDTO> getUnavailableDependencies() 
	{
		return unavailableDependencies;
	}
	


}
