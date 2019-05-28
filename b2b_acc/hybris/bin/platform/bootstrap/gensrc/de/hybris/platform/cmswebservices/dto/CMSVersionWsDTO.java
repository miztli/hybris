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
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

@ApiModel(value="CMSVersionWsDTO")
public  class CMSVersionWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.uid</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="uid") 	
	private String uid;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.itemUUID</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="itemUUID") 	
	private String itemUUID;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.label</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="label") 	
	private String label;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="description") 	
	private String description;

	/** <i>Generated property</i> for <code>CMSVersionWsDTO.creationtime</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="creationtime") 	
	private Date creationtime;
	
	public CMSVersionWsDTO()
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
	
		
	
	public void setItemUUID(final String itemUUID)
	{
		this.itemUUID = itemUUID;
	}

		
	
	public String getItemUUID() 
	{
		return itemUUID;
	}
	
		
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

		
	
	public String getLabel() 
	{
		return label;
	}
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	
		
	
	public void setCreationtime(final Date creationtime)
	{
		this.creationtime = creationtime;
	}

		
	
	public Date getCreationtime() 
	{
		return creationtime;
	}
	


}
