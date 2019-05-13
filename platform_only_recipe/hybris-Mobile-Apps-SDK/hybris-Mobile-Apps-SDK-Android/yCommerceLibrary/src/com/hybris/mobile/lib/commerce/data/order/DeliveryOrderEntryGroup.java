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

import com.hybris.mobile.lib.commerce.data.order.OrderEntryGroup;
import com.hybris.mobile.lib.commerce.data.user.Address;

public class DeliveryOrderEntryGroup extends OrderEntryGroup 
{

	/** <i>Generated property</i> for <code>DeliveryOrderEntryGroup.deliveryAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Address deliveryAddress;
		
	public DeliveryOrderEntryGroup()
	{
		// default constructor
	}
	
		
	public void setDeliveryAddress(final Address deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}
	
		
	public Address getDeliveryAddress() 
	{
		return deliveryAddress;
	}
		
	
}