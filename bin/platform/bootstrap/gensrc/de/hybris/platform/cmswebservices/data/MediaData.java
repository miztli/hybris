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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Media item data
 */
@ApiModel(value="MediaData", description="Media item data")
public  class MediaData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaData.uuid</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="uuid") 	
	private String uuid;

	/** <i>Generated property</i> for <code>MediaData.code</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="code") 	
	private String code;

	/** <i>Generated property</i> for <code>MediaData.catalogId</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>MediaData.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="catalogVersion") 	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>MediaData.mime</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="mime") 	
	private String mime;

	/** <i>Generated property</i> for <code>MediaData.altText</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="altText") 	
	private String altText;

	/** <i>Generated property</i> for <code>MediaData.description</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="description") 	
	private String description;

	/** <i>Generated property</i> for <code>MediaData.url</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="url") 	
	private String url;

	/** <i>Generated property</i> for <code>MediaData.downloadUrl</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="downloadUrl") 	
	private String downloadUrl;
	
	public MediaData()
	{
		// default constructor
	}
	
		
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

		
	
	public String getUuid() 
	{
		return uuid;
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
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
	
		
	
	public void setMime(final String mime)
	{
		this.mime = mime;
	}

		
	
	public String getMime() 
	{
		return mime;
	}
	
		
	
	public void setAltText(final String altText)
	{
		this.altText = altText;
	}

		
	
	public String getAltText() 
	{
		return altText;
	}
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	
		
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

		
	
	public String getUrl() 
	{
		return url;
	}
	
		
	
	public void setDownloadUrl(final String downloadUrl)
	{
		this.downloadUrl = downloadUrl;
	}

		
	
	public String getDownloadUrl() 
	{
		return downloadUrl;
	}
	


}
