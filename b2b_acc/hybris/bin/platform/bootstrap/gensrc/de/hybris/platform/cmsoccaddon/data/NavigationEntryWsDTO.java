/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
package de.hybris.platform.cmsoccaddon.data;

import java.io.Serializable;

public  class NavigationEntryWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationEntryWsDTO.itemId</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String itemId;

	/** <i>Generated property</i> for <code>NavigationEntryWsDTO.itemType</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String itemType;

	/** <i>Generated property</i> for <code>NavigationEntryWsDTO.itemSuperType</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String itemSuperType;
	
	public NavigationEntryWsDTO()
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
	
		
	
	public void setItemSuperType(final String itemSuperType)
	{
		this.itemSuperType = itemSuperType;
	}

		
	
	public String getItemSuperType() 
	{
		return itemSuperType;
	}
	


}
