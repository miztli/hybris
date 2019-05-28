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
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

@ApiModel(value="SyncJobData")
public  class SyncJobData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SyncJobData.syncStatus</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="syncStatus") 	
	private String syncStatus;

	/** <i>Generated property</i> for <code>SyncJobData.startDate</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="startDate") 	
	private Date startDate;

	/** <i>Generated property</i> for <code>SyncJobData.endDate</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="endDate") 	
	private Date endDate;

	/** <i>Generated property</i> for <code>SyncJobData.creationDate</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="creationDate") 	
	private Date creationDate;

	/** <i>Generated property</i> for <code>SyncJobData.lastModifiedDate</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="lastModifiedDate") 	
	private Date lastModifiedDate;

	/** <i>Generated property</i> for <code>SyncJobData.syncResult</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="syncResult") 	
	private String syncResult;

	/** <i>Generated property</i> for <code>SyncJobData.sourceCatalogVersion</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="sourceCatalogVersion") 	
	private String sourceCatalogVersion;

	/** <i>Generated property</i> for <code>SyncJobData.targetCatalogVersion</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="targetCatalogVersion") 	
	private String targetCatalogVersion;
	
	public SyncJobData()
	{
		// default constructor
	}
	
		
	
	public void setSyncStatus(final String syncStatus)
	{
		this.syncStatus = syncStatus;
	}

		
	
	public String getSyncStatus() 
	{
		return syncStatus;
	}
	
		
	
	public void setStartDate(final Date startDate)
	{
		this.startDate = startDate;
	}

		
	
	public Date getStartDate() 
	{
		return startDate;
	}
	
		
	
	public void setEndDate(final Date endDate)
	{
		this.endDate = endDate;
	}

		
	
	public Date getEndDate() 
	{
		return endDate;
	}
	
		
	
	public void setCreationDate(final Date creationDate)
	{
		this.creationDate = creationDate;
	}

		
	
	public Date getCreationDate() 
	{
		return creationDate;
	}
	
		
	
	public void setLastModifiedDate(final Date lastModifiedDate)
	{
		this.lastModifiedDate = lastModifiedDate;
	}

		
	
	public Date getLastModifiedDate() 
	{
		return lastModifiedDate;
	}
	
		
	
	public void setSyncResult(final String syncResult)
	{
		this.syncResult = syncResult;
	}

		
	
	public String getSyncResult() 
	{
		return syncResult;
	}
	
		
	
	public void setSourceCatalogVersion(final String sourceCatalogVersion)
	{
		this.sourceCatalogVersion = sourceCatalogVersion;
	}

		
	
	public String getSourceCatalogVersion() 
	{
		return sourceCatalogVersion;
	}
	
		
	
	public void setTargetCatalogVersion(final String targetCatalogVersion)
	{
		this.targetCatalogVersion = targetCatalogVersion;
	}

		
	
	public String getTargetCatalogVersion() 
	{
		return targetCatalogVersion;
	}
	


}
