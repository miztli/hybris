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
package de.hybris.platform.cmsfacades.dto;

import java.io.Serializable;

public  class RenderingComponentValidationDto  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RenderingComponentValidationDto.catalogCode</code> property defined at extension <code>cmsfacades</code>. */
		
	private String catalogCode;

	/** <i>Generated property</i> for <code>RenderingComponentValidationDto.categoryCode</code> property defined at extension <code>cmsfacades</code>. */
		
	private String categoryCode;

	/** <i>Generated property</i> for <code>RenderingComponentValidationDto.productCode</code> property defined at extension <code>cmsfacades</code>. */
		
	private String productCode;
	
	public RenderingComponentValidationDto()
	{
		// default constructor
	}
	
		
	
	public void setCatalogCode(final String catalogCode)
	{
		this.catalogCode = catalogCode;
	}

		
	
	public String getCatalogCode() 
	{
		return catalogCode;
	}
	
		
	
	public void setCategoryCode(final String categoryCode)
	{
		this.categoryCode = categoryCode;
	}

		
	
	public String getCategoryCode() 
	{
		return categoryCode;
	}
	
		
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

		
	
	public String getProductCode() 
	{
		return productCode;
	}
	


}
