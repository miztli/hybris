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
import java.util.Map;

@ApiModel(value="SiteData")
public  class SiteData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SiteData.uid</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="uid") 	
	private String uid;

	/** <i>Generated property</i> for <code>SiteData.previewUrl</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="previewUrl") 	
	private String previewUrl;

	/** <i>Generated property</i> for <code>SiteData.name</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="name") 	
	private Map<String, String> name;

	/** <i>Generated property</i> for <code>SiteData.contentCatalogs</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="contentCatalogs") 	
	private List<String> contentCatalogs;
	
	public SiteData()
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
	
		
	
	public void setPreviewUrl(final String previewUrl)
	{
		this.previewUrl = previewUrl;
	}

		
	
	public String getPreviewUrl() 
	{
		return previewUrl;
	}
	
		
	
	public void setName(final Map<String, String> name)
	{
		this.name = name;
	}

		
	
	public Map<String, String> getName() 
	{
		return name;
	}
	
		
	
	public void setContentCatalogs(final List<String> contentCatalogs)
	{
		this.contentCatalogs = contentCatalogs;
	}

		
	
	public List<String> getContentCatalogs() 
	{
		return contentCatalogs;
	}
	


}
