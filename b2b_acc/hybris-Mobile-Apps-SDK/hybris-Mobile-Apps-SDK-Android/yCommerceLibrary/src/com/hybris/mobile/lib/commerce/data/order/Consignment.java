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

import com.hybris.mobile.lib.commerce.data.order.ConsignmentEntry;
import com.hybris.mobile.lib.commerce.data.store.PointOfService;
import com.hybris.mobile.lib.commerce.data.user.Address;
import java.util.Date;
import java.util.List;

public class Consignment  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Consignment.statusDate</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date statusDate;
	/** <i>Generated property</i> for <code>Consignment.entries</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<ConsignmentEntry> entries;
	/** <i>Generated property</i> for <code>Consignment.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>Consignment.deliveryPointOfService</code> property defined at extension <code>commercewebservicescommons</code>. */
	private PointOfService deliveryPointOfService;
	/** <i>Generated property</i> for <code>Consignment.shippingAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Address shippingAddress;
	/** <i>Generated property</i> for <code>Consignment.trackingID</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String trackingID;
	/** <i>Generated property</i> for <code>Consignment.status</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String status;
		
	public Consignment()
	{
		// default constructor
	}
	
		
	public void setStatusDate(final Date statusDate)
	{
		this.statusDate = statusDate;
	}
	
		
	public Date getStatusDate() 
	{
		return statusDate;
	}
		
		
	public void setEntries(final List<ConsignmentEntry> entries)
	{
		this.entries = entries;
	}
	
		
	public List<ConsignmentEntry> getEntries() 
	{
		return entries;
	}
		
		
	public void setCode(final String code)
	{
		this.code = code;
	}
	
		
	public String getCode() 
	{
		return code;
	}
		
		
	public void setDeliveryPointOfService(final PointOfService deliveryPointOfService)
	{
		this.deliveryPointOfService = deliveryPointOfService;
	}
	
		
	public PointOfService getDeliveryPointOfService() 
	{
		return deliveryPointOfService;
	}
		
		
	public void setShippingAddress(final Address shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}
	
		
	public Address getShippingAddress() 
	{
		return shippingAddress;
	}
		
		
	public void setTrackingID(final String trackingID)
	{
		this.trackingID = trackingID;
	}
	
		
	public String getTrackingID() 
	{
		return trackingID;
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