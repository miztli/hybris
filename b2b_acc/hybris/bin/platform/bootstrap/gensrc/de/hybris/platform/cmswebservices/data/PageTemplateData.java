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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PageTemplateData")
public  class PageTemplateData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageTemplateData.uid</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="uid") 	
	private String uid;

	/** <i>Generated property</i> for <code>PageTemplateData.uuid</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="uuid") 	
	private String uuid;

	/** <i>Generated property</i> for <code>PageTemplateData.name</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="name") 	
	private String name;

	/** <i>Generated property</i> for <code>PageTemplateData.frontEndName</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="frontEndName") 	
	private String frontEndName;

	/** <i>Generated property</i> for <code>PageTemplateData.previewIcon</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="previewIcon") 	
	private String previewIcon;
	
	public PageTemplateData()
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
	
		
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

		
	
	public String getUuid() 
	{
		return uuid;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setFrontEndName(final String frontEndName)
	{
		this.frontEndName = frontEndName;
	}

		
	
	public String getFrontEndName() 
	{
		return frontEndName;
	}
	
		
	
	public void setPreviewIcon(final String previewIcon)
	{
		this.previewIcon = previewIcon;
	}

		
	
	public String getPreviewIcon() 
	{
		return previewIcon;
	}
	


}
