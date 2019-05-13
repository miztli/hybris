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
package de.hybris.platform.personalizationcmsweb.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * cxCmsComponentContainer details
 */
@ApiModel(value="cxCmsComponentContainer", description="cxCmsComponentContainer details")
public  class CxCmsComponentContainerData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** Unique ID of the container<br/><br/><i>Generated property</i> for <code>CxCmsComponentContainerData.uid</code> property defined at extension <code>personalizationcmsweb</code>. */
	@ApiModelProperty(name="uid", value="Unique ID of the container") 	
	private String uid;

	/** ID of the original container shared across catalog hierarchy<br/><br/><i>Generated property</i> for <code>CxCmsComponentContainerData.sourceId</code> property defined at extension <code>personalizationcmsweb</code>. */
	@ApiModelProperty(name="sourceId", value="ID of the original container shared across catalog hierarchy") 	
	private String sourceId;

	/** ID of the container's default component<br/><br/><i>Generated property</i> for <code>CxCmsComponentContainerData.defaultComponentUid</code> property defined at extension <code>personalizationcmsweb</code>. */
	@ApiModelProperty(name="defaultComponentUid", value="ID of the container's default component") 	
	private String defaultComponentUid;
	
	public CxCmsComponentContainerData()
	{
		// default constructor
	}
	
		
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

		
	
	public String getUid() 
	{
		return uid;
	}
	
		
	
	public void setSourceId(final String sourceId)
	{
		this.sourceId = sourceId;
	}

		
	
	public String getSourceId() 
	{
		return sourceId;
	}
	
		
	
	public void setDefaultComponentUid(final String defaultComponentUid)
	{
		this.defaultComponentUid = defaultComponentUid;
	}

		
	
	public String getDefaultComponentUid() 
	{
		return defaultComponentUid;
	}
	


}
