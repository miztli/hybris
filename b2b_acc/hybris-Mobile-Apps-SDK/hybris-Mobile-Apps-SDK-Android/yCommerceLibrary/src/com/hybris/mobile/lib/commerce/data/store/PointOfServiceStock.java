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
package com.hybris.mobile.lib.commerce.data.store;

import com.hybris.mobile.lib.commerce.data.product.Stock;

public class PointOfServiceStock extends PointOfService 
{

	/** <i>Generated property</i> for <code>PointOfServiceStock.stockInfo</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Stock stockInfo;
		
	public PointOfServiceStock()
	{
		// default constructor
	}
	
		
	public void setStockInfo(final Stock stockInfo)
	{
		this.stockInfo = stockInfo;
	}
	
		
	public Stock getStockInfo() 
	{
		return stockInfo;
	}
		
	
}