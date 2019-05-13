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
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value="CMSItemUuidListWsDTO")
public  class CMSItemUuidListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSItemUuidListWsDTO.uuids</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="uuids") 	
	private List<String> uuids;
	
	public CMSItemUuidListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setUuids(final List<String> uuids)
	{
		this.uuids = uuids;
	}

		
	
	public List<String> getUuids() 
	{
		return uuids;
	}
	


}
