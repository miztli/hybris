/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
package de.hybris.platform.commerceservices.service.data;

import java.io.Serializable;
import de.hybris.platform.core.model.order.CartModel;

public  class RemoveEntryGroupParameter  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** The CartModel<br/><br/><i>Generated property</i> for <code>RemoveEntryGroupParameter.cart</code> property defined at extension <code>commerceservices</code>. */
		
	private CartModel cart;

	/** Should the method hooks be executed<br/><br/><i>Generated property</i> for <code>RemoveEntryGroupParameter.enableHooks</code> property defined at extension <code>commerceservices</code>. */
		
	private boolean enableHooks;

	/** Entry group number to be removed<br/><br/><i>Generated property</i> for <code>RemoveEntryGroupParameter.entryGroupNumber</code> property defined at extension <code>commerceservices</code>. */
		
	private Integer entryGroupNumber;
	
	public RemoveEntryGroupParameter()
	{
		// default constructor
	}
	
		
	
	public void setCart(final CartModel cart)
	{
		this.cart = cart;
	}

		
	
	public CartModel getCart() 
	{
		return cart;
	}
	
		
	
	public void setEnableHooks(final boolean enableHooks)
	{
		this.enableHooks = enableHooks;
	}

		
	
	public boolean isEnableHooks() 
	{
		return enableHooks;
	}
	
		
	
	public void setEntryGroupNumber(final Integer entryGroupNumber)
	{
		this.entryGroupNumber = entryGroupNumber;
	}

		
	
	public Integer getEntryGroupNumber() 
	{
		return entryGroupNumber;
	}
	


}
