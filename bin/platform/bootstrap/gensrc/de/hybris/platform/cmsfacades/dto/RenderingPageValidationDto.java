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
package de.hybris.platform.cmsfacades.dto;

import java.io.Serializable;

public  class RenderingPageValidationDto  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RenderingPageValidationDto.pageTypeCode</code> property defined at extension <code>cmsfacades</code>. */
		
	private String pageTypeCode;

	/** <i>Generated property</i> for <code>RenderingPageValidationDto.code</code> property defined at extension <code>cmsfacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>RenderingPageValidationDto.pageLabelOrId</code> property defined at extension <code>cmsfacades</code>. */
		
	private String pageLabelOrId;
	
	public RenderingPageValidationDto()
	{
		// default constructor
	}
	
		
	
	public void setPageTypeCode(final String pageTypeCode)
	{
		this.pageTypeCode = pageTypeCode;
	}

		
	
	public String getPageTypeCode() 
	{
		return pageTypeCode;
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setPageLabelOrId(final String pageLabelOrId)
	{
		this.pageLabelOrId = pageLabelOrId;
	}

		
	
	public String getPageLabelOrId() 
	{
		return pageLabelOrId;
	}
	


}
