/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.order.CartModificationWsDTO;
import java.util.List;

public  class CartModificationListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CartModificationListWsDTO.cartModifications</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<CartModificationWsDTO> cartModifications;
	
	public CartModificationListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setCartModifications(final List<CartModificationWsDTO> cartModifications)
	{
		this.cartModifications = cartModifications;
	}

		
	
	public List<CartModificationWsDTO> getCartModifications() 
	{
		return cartModifications;
	}
	


}
