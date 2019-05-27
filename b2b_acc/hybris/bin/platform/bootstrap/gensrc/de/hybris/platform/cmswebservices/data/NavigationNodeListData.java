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
import de.hybris.platform.cmswebservices.data.NavigationNodeData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * List of navigation nodes
 */
@ApiModel(value="NavigationNodeListData", description="List of navigation nodes")
public  class NavigationNodeListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationNodeListData.navigationNodes</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="navigationNodes") 	
	private List<NavigationNodeData> navigationNodes;
	
	public NavigationNodeListData()
	{
		// default constructor
	}
	
		
	
	public void setNavigationNodes(final List<NavigationNodeData> navigationNodes)
	{
		this.navigationNodes = navigationNodes;
	}

		
	
	public List<NavigationNodeData> getNavigationNodes() 
	{
		return navigationNodes;
	}
	


}
