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
package de.hybris.platform.cmssmarteditwebservices.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @deprecated since 1811, no longer needed.
 */
@ApiModel(value="ContentPageWsDTO")
@Deprecated
public  class ContentPageWsDTO extends AbstractPageWsDTO 
{

 

	/** <i>Generated property</i> for <code>ContentPageWsDTO.label</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="label") 	
	private String label;

	/** <i>Generated property</i> for <code>ContentPageWsDTO.path</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="path") 	
	private String path;
	
	public ContentPageWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

		
	
	public String getLabel() 
	{
		return label;
	}
	
		
	
	public void setPath(final String path)
	{
		this.path = path;
	}

		
	
	public String getPath() 
	{
		return path;
	}
	


}
