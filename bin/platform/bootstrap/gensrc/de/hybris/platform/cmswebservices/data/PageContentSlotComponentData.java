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
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Page content slot component data
 */
@ApiModel(value="PageContentSlotComponentData", description="Page content slot component data")
public  class PageContentSlotComponentData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.pageId</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="pageId") 	
	private String pageId;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.componentId</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="componentId") 	
	private String componentId;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.componentUuid</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="componentUuid") 	
	private String componentUuid;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.slotId</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="slotId") 	
	private String slotId;

	/** <i>Generated property</i> for <code>PageContentSlotComponentData.position</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="position") 	
	private Integer position;
	
	public PageContentSlotComponentData()
	{
		// default constructor
	}
	
		
	
	public void setPageId(final String pageId)
	{
		this.pageId = pageId;
	}

		
	
	public String getPageId() 
	{
		return pageId;
	}
	
		
	
	public void setComponentId(final String componentId)
	{
		this.componentId = componentId;
	}

		
	
	public String getComponentId() 
	{
		return componentId;
	}
	
		
	
	public void setComponentUuid(final String componentUuid)
	{
		this.componentUuid = componentUuid;
	}

		
	
	public String getComponentUuid() 
	{
		return componentUuid;
	}
	
		
	
	public void setSlotId(final String slotId)
	{
		this.slotId = slotId;
	}

		
	
	public String getSlotId() 
	{
		return slotId;
	}
	
		
	
	public void setPosition(final Integer position)
	{
		this.position = position;
	}

		
	
	public Integer getPosition() 
	{
		return position;
	}
	


}
