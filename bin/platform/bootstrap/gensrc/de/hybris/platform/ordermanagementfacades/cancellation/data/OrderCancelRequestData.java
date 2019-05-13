/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
package de.hybris.platform.ordermanagementfacades.cancellation.data;

import java.io.Serializable;
import de.hybris.platform.ordermanagementfacades.cancellation.data.OrderCancelEntryData;
import java.util.List;

public  class OrderCancelRequestData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderCancelRequestData.orderCode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String orderCode;

	/** <i>Generated property</i> for <code>OrderCancelRequestData.entries</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private List<OrderCancelEntryData> entries;

	/** <i>Generated property</i> for <code>OrderCancelRequestData.userId</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String userId;
	
	public OrderCancelRequestData()
	{
		// default constructor
	}
	
		
	
	public void setOrderCode(final String orderCode)
	{
		this.orderCode = orderCode;
	}

		
	
	public String getOrderCode() 
	{
		return orderCode;
	}
	
		
	
	public void setEntries(final List<OrderCancelEntryData> entries)
	{
		this.entries = entries;
	}

		
	
	public List<OrderCancelEntryData> getEntries() 
	{
		return entries;
	}
	
		
	
	public void setUserId(final String userId)
	{
		this.userId = userId;
	}

		
	
	public String getUserId() 
	{
		return userId;
	}
	


}
