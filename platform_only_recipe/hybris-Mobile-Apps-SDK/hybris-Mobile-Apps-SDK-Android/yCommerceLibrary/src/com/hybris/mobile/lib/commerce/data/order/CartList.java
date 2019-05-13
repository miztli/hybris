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

import com.hybris.mobile.lib.commerce.data.order.Cart;
import java.util.List;

public class CartList  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>CartList.carts</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Cart> carts;
		
	public CartList()
	{
		// default constructor
	}
	
		
	public void setCarts(final List<Cart> carts)
	{
		this.carts = carts;
	}
	
		
	public List<Cart> getCarts() 
	{
		return carts;
	}
		
	
}