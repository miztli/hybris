/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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

/**
 * CMS Item Search DTO
 */
@ApiModel(value="CMSItemSearchWsDTO", description="CMS Item Search DTO")
public  class CMSItemSearchWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.mask</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="mask") 	
	private String mask;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.typeCode</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="typeCode") 	
	private String typeCode;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.typeCodes</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="typeCodes") 	
	private String typeCodes;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.catalogId</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="catalogVersion") 	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.itemSearchParams</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="itemSearchParams") 	
	private String itemSearchParams;
	
	public CMSItemSearchWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setMask(final String mask)
	{
		this.mask = mask;
	}

		
	
	public String getMask() 
	{
		return mask;
	}
	
		
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

		
	
	public String getTypeCode() 
	{
		return typeCode;
	}
	
		
	
	public void setTypeCodes(final String typeCodes)
	{
		this.typeCodes = typeCodes;
	}

		
	
	public String getTypeCodes() 
	{
		return typeCodes;
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
	
		
	
	public void setItemSearchParams(final String itemSearchParams)
	{
		this.itemSearchParams = itemSearchParams;
	}

		
	
	public String getItemSearchParams() 
	{
		return itemSearchParams;
	}
	


}
