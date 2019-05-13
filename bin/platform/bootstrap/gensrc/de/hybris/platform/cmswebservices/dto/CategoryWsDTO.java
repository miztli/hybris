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
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

/**
 * Category DTO
 */
@ApiModel(value="CategoryWsDTO", description="Category DTO")
public  class CategoryWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CategoryWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="code") 	
	private String code;

	/** <i>Generated property</i> for <code>CategoryWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="name") 	
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>CategoryWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="description") 	
	private Map<String,String> description;

	/** <i>Generated property</i> for <code>CategoryWsDTO.thumbnailMediaCode</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="thumbnailMediaCode") 	
	private String thumbnailMediaCode;

	/** <i>Generated property</i> for <code>CategoryWsDTO.catalogId</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CategoryWsDTO.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="catalogVersion") 	
	private String catalogVersion;
	
	public CategoryWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setName(final Map<String,String> name)
	{
		this.name = name;
	}

		
	
	public Map<String,String> getName() 
	{
		return name;
	}
	
		
	
	public void setDescription(final Map<String,String> description)
	{
		this.description = description;
	}

		
	
	public Map<String,String> getDescription() 
	{
		return description;
	}
	
		
	
	public void setThumbnailMediaCode(final String thumbnailMediaCode)
	{
		this.thumbnailMediaCode = thumbnailMediaCode;
	}

		
	
	public String getThumbnailMediaCode() 
	{
		return thumbnailMediaCode;
	}
	
		
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

		
	
	public String getCatalogId() 
	{
		return catalogId;
	}
	
		
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

		
	
	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	


}
