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
package de.hybris.platform.cmsoccaddon.data;

import java.io.Serializable;
import java.util.List;

/**
 * List of CMS component IDs
 */
public  class ComponentIDListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ComponentIDListWsDTO.idList</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private List<String> idList;
	
	public ComponentIDListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setIdList(final List<String> idList)
	{
		this.idList = idList;
	}

		
	
	public List<String> getIdList() 
	{
		return idList;
	}
	


}
