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
package com.hybris.mobile.lib.commerce.data.order;

import com.hybris.mobile.lib.commerce.data.order.AbstractOrder;
import com.hybris.mobile.lib.commerce.data.order.Consignment;
import com.hybris.mobile.lib.commerce.data.order.OrderEntry;
import java.util.Date;
import java.util.List;

public class Order extends AbstractOrder 
{

	/** <i>Generated property</i> for <code>Order.statusDisplay</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String statusDisplay;
	/** <i>Generated property</i> for <code>Order.created</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date created;
	/** <i>Generated property</i> for <code>Order.unconsignedEntries</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<OrderEntry> unconsignedEntries;
	/** <i>Generated property</i> for <code>Order.totalUnitCount</code> property defined at extension <code>b2boccaddon</code>. */
	private Integer totalUnitCount;
	/** <i>Generated property</i> for <code>Order.guestCustomer</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean guestCustomer;
	/** <i>Generated property</i> for <code>Order.deliveryStatusDisplay</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String deliveryStatusDisplay;
	/** <i>Generated property</i> for <code>Order.consignments</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Consignment> consignments;
	/** <i>Generated property</i> for <code>Order.deliveryStatus</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String deliveryStatus;
	/** <i>Generated property</i> for <code>Order.status</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String status;
		
	public Order()
	{
		// default constructor
	}
	
		
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}
	
		
	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
		
		
	public void setCreated(final Date created)
	{
		this.created = created;
	}
	
		
	public Date getCreated() 
	{
		return created;
	}
		
		
	public void setUnconsignedEntries(final List<OrderEntry> unconsignedEntries)
	{
		this.unconsignedEntries = unconsignedEntries;
	}
	
		
	public List<OrderEntry> getUnconsignedEntries() 
	{
		return unconsignedEntries;
	}
		
		
	public void setTotalUnitCount(final Integer totalUnitCount)
	{
		this.totalUnitCount = totalUnitCount;
	}
	
		
	public Integer getTotalUnitCount() 
	{
		return totalUnitCount;
	}
		
		
	public void setGuestCustomer(final Boolean guestCustomer)
	{
		this.guestCustomer = guestCustomer;
	}
	
		
	public Boolean getGuestCustomer() 
	{
		return guestCustomer;
	}
		
		
	public void setDeliveryStatusDisplay(final String deliveryStatusDisplay)
	{
		this.deliveryStatusDisplay = deliveryStatusDisplay;
	}
	
		
	public String getDeliveryStatusDisplay() 
	{
		return deliveryStatusDisplay;
	}
		
		
	public void setConsignments(final List<Consignment> consignments)
	{
		this.consignments = consignments;
	}
	
		
	public List<Consignment> getConsignments() 
	{
		return consignments;
	}
		
		
	public void setDeliveryStatus(final String deliveryStatus)
	{
		this.deliveryStatus = deliveryStatus;
	}
	
		
	public String getDeliveryStatus() 
	{
		return deliveryStatus;
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