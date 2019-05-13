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
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.AbstractCMSComponentData;
import de.hybris.platform.cmsfacades.data.SlotStatus;
import java.util.List;

public  class PageContentSlotData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotData.pageId</code> property defined at extension <code>cmsfacades</code>. */
		
	private String pageId;

	/** <i>Generated property</i> for <code>PageContentSlotData.slotId</code> property defined at extension <code>cmsfacades</code>. */
		
	private String slotId;

	/** <i>Generated property</i> for <code>PageContentSlotData.position</code> property defined at extension <code>cmsfacades</code>. */
		
	private String position;

	/** <i>Generated property</i> for <code>PageContentSlotData.slotShared</code> property defined at extension <code>cmsfacades</code>. */
		
	private boolean slotShared;

	/** <i>Generated property</i> for <code>PageContentSlotData.slotStatus</code> property defined at extension <code>cmsfacades</code>. */
		
	private SlotStatus slotStatus;

	/** <i>Generated property</i> for <code>PageContentSlotData.name</code> property defined at extension <code>cmsfacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>PageContentSlotData.catalogVersion</code> property defined at extension <code>cmsfacades</code>. */
		
	private String catalogVersion;

	/** <i>Generated property</i> for <code>PageContentSlotData.components</code> property defined at extension <code>cmsfacades</code>. */
		
	private List<AbstractCMSComponentData> components;
	
	public PageContentSlotData()
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
	
		
	
	public void setPosition(final String position)
	{
		this.position = position;
	}

		
	
	public String getPosition() 
	{
		return position;
	}
	
		
	
	public void setSlotShared(final boolean slotShared)
	{
		this.slotShared = slotShared;
	}

		
	
	public boolean isSlotShared() 
	{
		return slotShared;
	}
	
		
	
	public void setSlotStatus(final SlotStatus slotStatus)
	{
		this.slotStatus = slotStatus;
	}

		
	
	public SlotStatus getSlotStatus() 
	{
		return slotStatus;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

		
	
	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
		
	
	public void setComponents(final List<AbstractCMSComponentData> components)
	{
		this.components = components;
	}

		
	
	public List<AbstractCMSComponentData> getComponents() 
	{
		return components;
	}
	


}
