/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
package de.hybris.platform.commercewebservicescommons.dto.product;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.product.StockWsDTO;
import java.util.Date;

public  class FutureStockWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FutureStockWsDTO.stock</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private StockWsDTO stock;

	/** <i>Generated property</i> for <code>FutureStockWsDTO.date</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Date date;

	/** <i>Generated property</i> for <code>FutureStockWsDTO.formattedDate</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String formattedDate;
	
	public FutureStockWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setStock(final StockWsDTO stock)
	{
		this.stock = stock;
	}

		
	
	public StockWsDTO getStock() 
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
