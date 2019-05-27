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

import com.hybris.mobile.lib.commerce.data.product.Stock;
import java.util.Date;

public class FutureStock  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>FutureStock.date</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date date;
	/** <i>Generated property</i> for <code>FutureStock.formattedDate</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String formattedDate;
	/** <i>Generated property</i> for <code>FutureStock.stock</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Stock stock;
		
	public FutureStock()
	{
		// default constructor
	}
	
		
	public void setDate(final Date date)
	{
		this.date = date;
	}
	
		
	public Date getDate() 
	{
		return date;
	}
		
		
	public void setFormattedDate(final String formattedDate)
	{
		this.formattedDate = formattedDate;
	}
	
		
	public String getFormattedDate() 
	{
		return formattedDate;
	}
		
		
	public void setStock(final Stock stock)
	{
		this.stock = stock;
	}
	
		
	public Stock getStock() 
	{
		return stock;
	}
		
	
}