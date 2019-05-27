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
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmssmarteditwebservices.dto.StructureAttributeWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * @deprecated since 1811, no longer needed.
 */
@ApiModel(value="structure")
@Deprecated
public  class StructureWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StructureWsDTO.code</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="code") 	
	private String code;

	/** <i>Generated property</i> for <code>StructureWsDTO.category</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="category") 	
	private String category;

	/** <i>Generated property</i> for <code>StructureWsDTO.name</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="name") 	
	private String name;

	/** <i>Generated property</i> for <code>StructureWsDTO.i18nKey</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="i18nKey") 	
	private String i18nKey;

	/** <i>Generated property</i> for <code>StructureWsDTO.type</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="type") 	
	private String type;

	/** <i>Generated property</i> for <code>StructureWsDTO.attributes</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="attributes") 	
	private List<StructureAttributeWsDTO> attributes;
	
	public StructureWsDTO()
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
	
		
	
	public void setCategory(final String category)
	{
		this.category = category;
	}

		
	
	public String getCategory() 
	{
		return category;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setI18nKey(final String i18nKey)
	{
		this.i18nKey = i18nKey;
	}

		
	
	public String getI18nKey() 
	{
		return i18nKey;
	}
	
		
	
	public void setType(final String type)
	{
		this.type = type;
	}

		
	
	public String getType() 
	{
		return type;
	}
	
		
	
	public void setAttributes(final List<StructureAttributeWsDTO> attributes)
	{
		this.attributes = attributes;
	}

		
	
	public List<StructureAttributeWsDTO> getAttributes() 
	{
		return attributes;
	}
	


}
