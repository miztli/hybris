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
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import java.util.List;

public  class PageContentSlotContainerData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotContainerData.pageId</code> property defined at extension <code>cmsfacades</code>. */
		
	private String pageId;

	/** <i>Generated property</i> for <code>PageContentSlotContainerData.slotId</code> property defined at extension <code>cmsfacades</code>. */
		
	private String slotId;

	/** <i>Generated property</i> for <code>PageContentSlotContainerData.containerId</code> property defined at extension <code>cmsfacades</code>. */
		
	private String containerId;

	/** <i>Generated property</i> for <code>PageContentSlotContainerData.containerType</code> property defined at extension <code>cmsfacades</code>. */
		
	private String containerType;

	/** <i>Generated property</i> for <code>PageContentSlotContainerData.components</code> property defined at extension <code>cmsfacades</code>. */
		
	private List<String> components;
	
	public PageContentSlotContainerData()
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
	
		
	
	public void setSlotId(final String slotId)
	{
		this.slotId = slotId;
	}

		
	
	public String getSlotId() 
	{
		return slotId;
	}
	
		
	
	public void setContainerId(final String containerId)
	{
		this.containerId = containerId;
	}

		
	
	public String getContainerId() 
	{
		return containerId;
	}
	
		
	
	public void setContainerType(final String containerType)
	{
		this.containerType = containerType;
	}

		
	
	public String getContainerType() 
	{
		return containerType;
	}
	
		
	
	public void setComponents(final List<String> components)
	{
		this.components = components;
	}

		
	
	public List<String> getComponents() 
	{
		return components;
	}
	


}
