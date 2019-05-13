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

import com.hybris.mobile.lib.commerce.data.order.OrderEntry;
import com.hybris.mobile.lib.commerce.data.product.Price;
import java.util.Collection;

public class OrderEntryGroup  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>OrderEntryGroup.entries</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Collection<OrderEntry> entries;
	/** <i>Generated property</i> for <code>OrderEntryGroup.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long quantity;
	/** <i>Generated property</i> for <code>OrderEntryGroup.totalPriceWithTax</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price totalPriceWithTax;
		
	public OrderEntryGroup()
	{
		// default constructor
	}
	
		
	public void setEntries(final Collection<OrderEntry> entries)
	{
		this.entries = entries;
	}
	
		
	public Collection<OrderEntry> getEntries() 
	{
		return entries;
	}
		
		
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}
	
		
	public Long getQuantity() 
	{
		return quantity;
	}
		
		
	public void setTotalPriceWithTax(final Price totalPriceWithTax)
	{
		this.totalPriceWithTax = totalPriceWithTax;
	}
	
		
	public Price getTotalPriceWithTax() 
	{
		return totalPriceWithTax;
	}
		
	
}