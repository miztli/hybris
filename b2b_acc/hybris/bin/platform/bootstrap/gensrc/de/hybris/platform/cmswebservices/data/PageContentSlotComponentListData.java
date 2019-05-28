/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
import de.hybris.platform.cmswebservices.data.PageContentSlotComponentData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * List of PageContentSlotComponentData
 */
@ApiModel(value="PageContentSlotComponentListData", description="List of PageContentSlotComponentData")
public  class PageContentSlotComponentListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageContentSlotComponentListData.pageContentSlotComponentList</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="pageContentSlotComponentList") 	
	private List<PageContentSlotComponentData> pageContentSlotComponentList;
	
	public PageContentSlotComponentListData()
	{
		// default constructor
	}
	
		
	
	public void setPageContentSlotComponentList(final List<PageContentSlotComponentData> pageContentSlotComponentList)
	{
		this.pageContentSlotComponentList = pageContentSlotComponentList;
	}

		
	
	public List<PageContentSlotComponentData> getPageContentSlotComponentList() 
	{
		return pageContentSlotComponentList;
	}
	


}