/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:21 PM
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

public  class CommerceSaveCartParameter  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** The CartModel to be saved<br/><br/><i>Generated property</i> for <code>CommerceSaveCartParameter.cart</code> property defined at extension <code>commerceservices</code>. */
		
	private CartModel cart;

	/** The name of the saved cart provided by user or auto-generated<br/><br/><i>Generated property</i> for <code>CommerceSaveCartParameter.name</code> property defined at extension <code>commerceservices</code>. */
		
	private String name;

	/** The description of the saved cart provided by user or auto-generated<br/><br/><i>Generated property</i> for <code>CommerceSaveCartParameter.description</code> property defined at extension <code>commerceservices</code>. */
		
	private String description;

	/** Should the method hooks be executed<br/><br/><i>Generated property</i> for <code>CommerceSaveCartParameter.enableHooks</code> property defined at extension <code>commerceservices</code>. */
		
	private boolean enableHooks;
	
	public CommerceSaveCartParameter()
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
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	
		
	
	public void setEnableHooks(final boolean enableHooks)
	{
		this.enableHooks = enableHooks;
	}

		
	
	public boolean isEnableHooks() 
	{
		return enableHooks;
	}
	


}
