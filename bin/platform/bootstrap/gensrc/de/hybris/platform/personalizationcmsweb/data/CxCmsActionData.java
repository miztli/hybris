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
package de.hybris.platform.personalizationcmsweb.data;

import de.hybris.platform.personalizationfacades.data.ActionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Action details
 */
@ApiModel(value="action", description="Action details")
public  class CxCmsActionData extends ActionData 
{

 

	/** ID of the component<br/><br/><i>Generated property</i> for <code>CxCmsActionData.componentId</code> property defined at extension <code>personalizationcmsweb</code>. */
	@ApiModelProperty(name="componentId", value="ID of the component") 	
	private String componentId;

	/** Identifier of the component's catalog<br/><br/><i>Generated property</i> for <code>CxCmsActionData.componentCatalog</code> property defined at extension <code>personalizationcmsweb</code>. */
	@ApiModelProperty(name="componentCatalog", value="Identifier of the component's catalog") 	
	private String componentCatalog;

	/** ID of the component's container<br/><br/><i>Generated property</i> for <code>CxCmsActionData.containerId</code> property defined at extension <code>personalizationcmsweb</code>. */
	@ApiModelProperty(name="containerId", value="ID of the component's container") 	
	private String containerId;
	
	public CxCmsActionData()
	{
		// default constructor
	}
	
		
	
	public void setComponentId(final String componentId)
	{
		this.componentId = componentId;
	}

		
	
	public String getComponentId() 
	{
		return componentId;
	}
	
		
	
	public void setComponentCatalog(final String componentCatalog)
	{
		this.componentCatalog = componentCatalog;
	}

		
	
	public String getComponentCatalog() 
	{
		return componentCatalog;
	}
	
		
	
	public void setContainerId(final String containerId)
	{
		this.containerId = containerId;
	}

		
	
	public String getContainerId() 
	{
		return containerId;
	}
	


}
