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
package de.hybris.platform.commercefacades.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.StockData;
import java.util.Date;

public  class FutureStockData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FutureStockData.stock</code> property defined at extension <code>commercefacades</code>. */
		
	private StockData stock;

	/** <i>Generated property</i> for <code>FutureStockData.date</code> property defined at extension <code>commercefacades</code>. */
		
	private Date date;

	/** <i>Generated property</i> for <code>FutureStockData.formattedDate</code> property defined at extension <code>commercefacades</code>. */
		
	private String formattedDate;
	
	public FutureStockData()
	{
		// default constructor
	}
	
		
	
	public void setStock(final StockData stock)
	{
		this.stock = stock;
	}

		
	
	public StockData getStock() 
	{
		return stock;
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
	


}
