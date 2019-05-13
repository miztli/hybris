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
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.ComponentTypeData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value="ComponentTypeListData")
public  class ComponentTypeListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ComponentTypeListData.componentTypes</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="componentTypes") 	
	private List<ComponentTypeData> componentTypes;
	
	public ComponentTypeListData()
	{
		// default constructor
	}
	
		
	
	public void setComponentTypes(final List<ComponentTypeData> componentTypes)
	{
		this.componentTypes = componentTypes;
	}

		
	
	public List<ComponentTypeData> getComponentTypes() 
	{
		return componentTypes;
	}
	


}
