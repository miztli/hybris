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
import de.hybris.platform.cmswebservices.data.PageTemplateData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * List of page templates
 */
@ApiModel(value="PageTemplateListData", description="List of page templates")
public  class PageTemplateListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageTemplateListData.templates</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="templates") 	
	private List<PageTemplateData> templates;
	
	public PageTemplateListData()
	{
		// default constructor
	}
	
		
	
	public void setTemplates(final List<PageTemplateData> templates)
	{
		this.templates = templates;
	}

		
	
	public List<PageTemplateData> getTemplates() 
	{
		return templates;
	}
	


}
