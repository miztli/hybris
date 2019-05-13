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
package com.hybris.mobile.lib.commerce.data.order;

import com.hybris.mobile.lib.commerce.data.product.Price;
import java.util.Date;

public class OrderHistory  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>OrderHistory.total</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price total;
	/** <i>Generated property</i> for <code>OrderHistory.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>OrderHistory.placed</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date placed;
	/** <i>Generated property</i> for <code>OrderHistory.statusDisplay</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String statusDisplay;
	/** <i>Generated property</i> for <code>OrderHistory.guid</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String guid;
	/** <i>Generated property</i> for <code>OrderHistory.status</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String status;
		
	public OrderHistory()
	{
		// default constructor
	}
	
		
	public void setTotal(final Price total)
	{
		this.total = total;
	}
	
		
	public Price getTotal() 
	{
		return total;
	}
		
		
	public void setCode(final String code)
	{
		this.code = code;
	}
	
		
	public String getCode() 
	{
		return code;
	}
		
		
	public void setPlaced(final Date placed)
	{
		this.placed = placed;
	}
	
		
	public Date getPlaced() 
	{
		return placed;
	}
		
		
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}
	
		
	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
		
		
	public void setGuid(final String guid)
	{
		this.guid = guid;
	}
	
		
	public String getGuid() 
	{
		return guid;
	}
		
		
	public void setStatus(final String status)
	{
		this.status = status;
	}
	
		
	public String getStatus() 
	{
		return status;
	}
		
	
}