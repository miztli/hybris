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
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import java.util.Set;

public  class CartModificationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CartModificationData.statusCode</code> property defined at extension <code>commercefacades</code>. */
		
	private String statusCode;

	/** <i>Generated property</i> for <code>CartModificationData.quantityAdded</code> property defined at extension <code>commercefacades</code>. */
		
	private long quantityAdded;

	/** <i>Generated property</i> for <code>CartModificationData.quantity</code> property defined at extension <code>commercefacades</code>. */
		
	private long quantity;

	/** <i>Generated property</i> for <code>CartModificationData.entry</code> property defined at extension <code>commercefacades</code>. */
		
	private OrderEntryData entry;

	/** <i>Generated property</i> for <code>CartModificationData.deliveryModeChanged</code> property defined at extension <code>commercefacades</code>. */
		
	private Boolean deliveryModeChanged;

	/** <i>Generated property</i> for <code>CartModificationData.cartCode</code> property defined at extension <code>commercefacades</code>. */
		
	private String cartCode;

	/** <i>Generated property</i> for <code>CartModificationData.statusMessage</code> property defined at extension <code>commercefacades</code>. */
		
	private String statusMessage;

	/** <i>Generated property</i> for <code>CartModificationData.entryGroupNumbers</code> property defined at extension <code>commercefacades</code>. */
		
	private Set<Integer> entryGroupNumbers;
	
	public CartModificationData()
	{
		// default constructor
	}
	
		
	
	public void setStatusCode(final String statusCode)
	{
		this.statusCode = statusCode;
	}

		
	
	public String getStatusCode() 
	{
		return statusCode;
	}
	
		
	
	public void setQuantityAdded(final long quantityAdded)
	{
		this.quantityAdded = quantityAdded;
	}

		
	
	public long getQuantityAdded() 
	{
		return quantityAdded;
	}
	
		
	
	public void setQuantity(final long quantity)
	{
		this.quantity = quantity;
	}

		
	
	public long getQuantity() 
	{
		return quantity;
	}
	
		
	
	public void setEntry(final OrderEntryData entry)
	{
		this.entry = entry;
	}

		
	
	public OrderEntryData getEntry() 
	{
		return entry;
	}
	
		
	
	public void setDeliveryModeChanged(final Boolean deliveryModeChanged)
	{
		this.deliveryModeChanged = deliveryModeChanged;
	}

		
	
	public Boolean getDeliveryModeChanged() 
	{
		return deliveryModeChanged;
	}
	
		
	
	public void setCartCode(final String cartCode)
	{
		this.cartCode = cartCode;
	}

		
	
	public String getCartCode() 
	{
		return cartCode;
	}
	
		
	
	public void setStatusMessage(final String statusMessage)
	{
		this.statusMessage = statusMessage;
	}

		
	
	public String getStatusMessage() 
	{
		return statusMessage;
	}
	
		
	
	public void setEntryGroupNumbers(final Set<Integer> entryGroupNumbers)
	{
		this.entryGroupNumbers = entryGroupNumbers;
	}

		
	
	public Set<Integer> getEntryGroupNumbers() 
	{
		return entryGroupNumbers;
	}
	


}
