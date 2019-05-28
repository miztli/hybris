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
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.PageRestrictionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * List of page restrictions
 */
@ApiModel(value="PageRestrictionListData", description="List of page restrictions")
public  class PageRestrictionListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageRestrictionListData.pageRestrictionList</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="pageRestrictionList") 	
	private List<PageRestrictionData> pageRestrictionList;
	
	public PageRestrictionListData()
	{
		// default constructor
	}
	
		
	
	public void setPageRestrictionList(final List<PageRestrictionData> pageRestrictionList)
	{
		this.pageRestrictionList = pageRestrictionList;
	}

		
	
	public List<PageRestrictionData> getPageRestrictionList() 
	{
		return pageRestrictionList;
	}
	


}
