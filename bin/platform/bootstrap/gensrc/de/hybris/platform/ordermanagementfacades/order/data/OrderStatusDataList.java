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
package de.hybris.platform.ordermanagementfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.core.enums.OrderStatus;
import java.util.List;

public  class OrderStatusDataList  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderStatusDataList.statuses</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private List<OrderStatus> statuses;
	
	public OrderStatusDataList()
	{
		// default constructor
	}
	
		
	
	public void setStatuses(final List<OrderStatus> statuses)
	{
		this.statuses = statuses;
	}

		
	
	public List<OrderStatus> getStatuses() 
	{
		return statuses;
	}
	


}
