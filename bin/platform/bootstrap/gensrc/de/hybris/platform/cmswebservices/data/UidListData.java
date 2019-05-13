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
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * List of uids
 */
@ApiModel(value="UidListData", description="List of uids")
public  class UidListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UidListData.uids</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="uids") 	
	private List<String> uids;
	
	public UidListData()
	{
		// default constructor
	}
	
		
	
	public void setUids(final List<String> uids)
	{
		this.uids = uids;
	}

		
	
	public List<String> getUids() 
	{
		return uids;
	}
	


}
