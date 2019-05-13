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

import com.hybris.mobile.lib.commerce.data.order.OrderEntryGroup;
import com.hybris.mobile.lib.commerce.data.store.PointOfService;

public class PickupOrderEntryGroup extends OrderEntryGroup 
{

	/** <i>Generated property</i> for <code>PickupOrderEntryGroup.distance</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double distance;
	/** <i>Generated property</i> for <code>PickupOrderEntryGroup.deliveryPointOfService</code> property defined at extension <code>commercewebservicescommons</code>. */
	private PointOfService deliveryPointOfService;
		
	public PickupOrderEntryGroup()
	{
		// default constructor
	}
	
		
	public void setDistance(final Double distance)
	{
		this.distance = distance;
	}
	
		
	public Double getDistance() 
	{
		return distance;
	}
		
		
	public void setDeliveryPointOfService(final PointOfService deliveryPointOfService)
	{
		this.deliveryPointOfService = deliveryPointOfService;
	}
	
		
	public PointOfService getDeliveryPointOfService() 
	{
		return deliveryPointOfService;
	}
		
	
}