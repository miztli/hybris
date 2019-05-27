/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
import java.util.Date;
import java.util.Optional;

public  class CommerceCartMetadataParameter  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** The name of the Cart<br/><br/><i>Generated property</i> for <code>CommerceCartMetadataParameter.name</code> property defined at extension <code>commerceservices</code>. */
		
	private Optional<String> name;

	/** The description of the Cart<br/><br/><i>Generated property</i> for <code>CommerceCartMetadataParameter.description</code> property defined at extension <code>commerceservices</code>. */
		
	private Optional<String> description;

	/** The expiration time to be stored in the Cart<br/><br/><i>Generated property</i> for <code>CommerceCartMetadataParameter.expirationTime</code> property defined at extension <code>commerceservices</code>. */
		
	private Optional<Date> expirationTime;

	/** Indicates if the expiration time stored in the Cart should be removed. It has precedence over
				expirationTime
				attribute which will be ignored when this attribute will be set to true.
			<br/><br/><i>Generated property</i> for <code>CommerceCartMetadataParameter.removeExpirationTime</code> property defined at extension <code>commerceservices</code>. */
		
	private boolean removeExpirationTime;

	/** The CartModel<br/><br/><i>Generated property</i> for <code>CommerceCartMetadataParameter.cart</code> property defined at extension <code>commerceservices</code>. */
		
	private CartModel cart;

	/** Should the method hooks be executed<br/><br/><i>Generated property</i> for <code>CommerceCartMetadataParameter.enableHooks</code> property defined at extension <code>commerceservices</code>. */
		
	private boolean enableHooks;
	
	public CommerceCartMetadataParameter()
	{
		// default constructor
	}
	
		
	
	public void setName(final Optional<String> name)
	{
		this.name = name;
	}

		
	
	public Optional<String> getName() 
	{
		return name;
	}
	
		
	
	public void setDescription(final Optional<String> description)
	{
		this.description = description;
	}

		
	
	public Optional<String> getDescription() 
	{
		return description;
	}
	
		
	
	public void setExpirationTime(final Optional<Date> expirationTime)
	{
		this.expirationTime = expirationTime;
	}

		
	
	public Optional<Date> getExpirationTime() 
	{
		return expirationTime;
	}
	
		
	
	public void setRemoveExpirationTime(final boolean removeExpirationTime)
	{
		this.removeExpirationTime = removeExpirationTime;
	}

		
	
	public boolean isRemoveExpirationTime() 
	{
		return removeExpirationTime;
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
	


}
