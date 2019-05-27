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
import de.hybris.platform.cmsoccaddon.data.ComponentWsDTO;
import java.util.List;

public  class ComponentListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ComponentListWsDTO.component</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private List<ComponentWsDTO> component;
	
	public ComponentListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setComponent(final List<ComponentWsDTO> component)
	{
		this.component = component;
	}

		
	
	public List<ComponentWsDTO> getComponent() 
	{
		return component;
	}
	


}
