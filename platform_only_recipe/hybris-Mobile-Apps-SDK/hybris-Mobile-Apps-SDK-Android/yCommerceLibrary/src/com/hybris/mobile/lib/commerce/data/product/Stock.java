/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:22 PM
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

public class Stock  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Stock.stockLevelStatus</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String stockLevelStatus;
	/** <i>Generated property</i> for <code>Stock.stockLevel</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long stockLevel;
		
	public Stock()
	{
		// default constructor
	}
	
		
	public void setStockLevelStatus(final String stockLevelStatus)
	{
		this.stockLevelStatus = stockLevelStatus;
	}
	
		
	public String getStockLevelStatus() 
	{
		return stockLevelStatus;
	}
		
		
	public void setStockLevel(final Long stockLevel)
	{
		this.stockLevel = stockLevel;
	}
	
		
	public Long getStockLevel() 
	{
		return stockLevel;
	}
		
	
}