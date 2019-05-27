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
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="NavigationEntryData")
public  class NavigationEntryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationEntryData.name</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="name") 	
	private String name;

	/** <i>Generated property</i> for <code>NavigationEntryData.itemId</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="itemId") 	
	private String itemId;

	/** <i>Generated property</i> for <code>NavigationEntryData.itemType</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="itemType") 	
	private String itemType;

	/** <i>Generated property</i> for <code>NavigationEntryData.itemSuperType</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="itemSuperType") 	
	private String itemSuperType;
	
	public NavigationEntryData()
	{
		// default constructor
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
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
