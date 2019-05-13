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
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.OrderHistoryData;
import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.commerceservices.search.pagedata.SortData;
import java.util.List;

public  class OrderHistoriesData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderHistoriesData.orders</code> property defined at extension <code>commercefacades</code>. */
		
	private List<OrderHistoryData> orders;

	/** <i>Generated property</i> for <code>OrderHistoriesData.sorts</code> property defined at extension <code>commercefacades</code>. */
		
	private List<SortData> sorts;

	/** <i>Generated property</i> for <code>OrderHistoriesData.pagination</code> property defined at extension <code>commercefacades</code>. */
		
	private PaginationData pagination;
	
	public OrderHistoriesData()
	{
		// default constructor
	}
	
		
	
	public void setOrders(final List<OrderHistoryData> orders)
	{
		this.orders = orders;
	}

		
	
	public List<OrderHistoryData> getOrders() 
	{
		return orders;
	}
	
		
	
	public void setSorts(final List<SortData> sorts)
	{
		this.sorts = sorts;
	}

		
	
	public List<SortData> getSorts() 
	{
		return sorts;
	}
	
		
	
	public void setPagination(final PaginationData pagination)
	{
		this.pagination = pagination;
	}

		
	
	public PaginationData getPagination() 
	{
		return pagination;
	}
	


}
