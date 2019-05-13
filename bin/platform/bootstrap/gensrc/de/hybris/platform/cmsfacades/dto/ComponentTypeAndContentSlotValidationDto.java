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
package de.hybris.platform.cmsfacades.dto;

import java.io.Serializable;
import de.hybris.platform.cms2.model.contents.contentslot.ContentSlotModel;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;

public  class ComponentTypeAndContentSlotValidationDto  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ComponentTypeAndContentSlotValidationDto.componentType</code> property defined at extension <code>cmsfacades</code>. */
		
	private String componentType;

	/** <i>Generated property</i> for <code>ComponentTypeAndContentSlotValidationDto.contentSlot</code> property defined at extension <code>cmsfacades</code>. */
		
	private ContentSlotModel contentSlot;

	/** <i>Generated property</i> for <code>ComponentTypeAndContentSlotValidationDto.page</code> property defined at extension <code>cmsfacades</code>. */
		
	private AbstractPageModel page;
	
	public ComponentTypeAndContentSlotValidationDto()
	{
		// default constructor
	}
	
		
	
	public void setComponentType(final String componentType)
	{
		this.componentType = componentType;
	}

		
	
	public String getComponentType() 
	{
		return componentType;
	}
	
		
	
	public void setContentSlot(final ContentSlotModel contentSlot)
	{
		this.contentSlot = contentSlot;
	}

		
	
	public ContentSlotModel getContentSlot() 
	{
		return contentSlot;
	}
	
		
	
	public void setPage(final AbstractPageModel page)
	{
		this.page = page;
	}

		
	
	public AbstractPageModel getPage() 
	{
		return page;
	}
	


}
