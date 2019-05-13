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

import com.hybris.mobile.lib.commerce.data.product.Price;

public class PriceRange  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>PriceRange.minPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price minPrice;
	/** <i>Generated property</i> for <code>PriceRange.maxPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price maxPrice;
		
	public PriceRange()
	{
		// default constructor
	}
	
		
	public void setMinPrice(final Price minPrice)
	{
		this.minPrice = minPrice;
	}
	
		
	public Price getMinPrice() 
	{
		return minPrice;
	}
		
		
	public void setMaxPrice(final Price maxPrice)
	{
		this.maxPrice = maxPrice;
	}
	
		
	public Price getMaxPrice() 
	{
		return maxPrice;
	}
		
	
}