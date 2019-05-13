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

import com.hybris.mobile.lib.commerce.data.order.OrderHistory;
import com.hybris.mobile.lib.commerce.data.search.pagedata.Pagination;
import com.hybris.mobile.lib.commerce.data.search.pagedata.Sort;
import java.util.List;

public class OrderHistoryList  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>OrderHistoryList.pagination</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Pagination pagination;
	/** <i>Generated property</i> for <code>OrderHistoryList.orders</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<OrderHistory> orders;
	/** <i>Generated property</i> for <code>OrderHistoryList.sorts</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Sort> sorts;
		
	public OrderHistoryList()
	{
		// default constructor
	}
	
		
	public void setPagination(final Pagination pagination)
	{
		this.pagination = pagination;
	}
	
		
	public Pagination getPagination() 
	{
		return pagination;
	}
		
		
	public void setOrders(final List<OrderHistory> orders)
	{
		this.orders = orders;
	}
	
		
	public List<OrderHistory> getOrders() 
	{
		return orders;
	}
		
		
	public void setSorts(final List<Sort> sorts)
	{
		this.sorts = sorts;
	}
	
		
	public List<Sort> getSorts() 
	{
		return sorts;
	}
		
	
}