/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:21 PM
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

import com.hybris.mobile.lib.commerce.data.order.OrderEntry;

public class ConsignmentEntry  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>ConsignmentEntry.orderEntry</code> property defined at extension <code>commercewebservicescommons</code>. */
	private OrderEntry orderEntry;
	/** <i>Generated property</i> for <code>ConsignmentEntry.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long quantity;
	/** <i>Generated property</i> for <code>ConsignmentEntry.shippedQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long shippedQuantity;
		
	public ConsignmentEntry()
	{
		// default constructor
	}
	
		
	public void setOrderEntry(final OrderEntry orderEntry)
	{
		this.orderEntry = orderEntry;
	}
	
		
	public OrderEntry getOrderEntry() 
	{
		return orderEntry;
	}
		
		
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}
	
		
	public Long getQuantity() 
	{
		return quantity;
	}
		
		
	public void setShippedQuantity(final Long shippedQuantity)
	{
		this.shippedQuantity = shippedQuantity;
	}
	
		
	public Long getShippedQuantity() 
	{
		return shippedQuantity;
	}
		
	
}