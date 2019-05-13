/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:23 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.hybris.mobile.lib.commerce.data.product;

import com.hybris.mobile.lib.commerce.data.product.Product;

public class Reference  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Reference.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer quantity;
	/** <i>Generated property</i> for <code>Reference.referenceType</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String referenceType;
	/** <i>Generated property</i> for <code>Reference.description</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String description;
	/** <i>Generated property</i> for <code>Reference.target</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Product target;
		
	public Reference()
	{
		// default constructor
	}
	
		
	public void setQuantity(final Integer quantity)
	{
		this.quantity = quantity;
	}
	
		
	public Integer getQuantity() 
	{
		return quantity;
	}
		
		
	public void setReferenceType(final String referenceType)
	{
		this.referenceType = referenceType;
	}
	
		
	public String getReferenceType() 
	{
		return referenceType;
	}
		
		
	public void setDescription(final String description)
	{
		this.description = description;
	}
	
		
	public String getDescription() 
	{
		return description;
	}
		
		
	public void setTarget(final Product target)
	{
		this.target = target;
	}
	
		
	public Product getTarget() 
	{
		return target;
	}
		
	
}