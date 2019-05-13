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
import de.hybris.platform.commercefacades.product.data.PriceData;
import java.util.Collection;

public  class OrderEntryGroupData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderEntryGroupData.totalPriceWithTax</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData totalPriceWithTax;

	/** <i>Generated property</i> for <code>OrderEntryGroupData.entries</code> property defined at extension <code>commercefacades</code>. */
		
	private Collection<OrderEntryData> entries;

	/** <i>Generated property</i> for <code>OrderEntryGroupData.quantity</code> property defined at extension <code>commercefacades</code>. */
		
	private Long quantity;
	
	public OrderEntryGroupData()
	{
		// default constructor
	}
	
		
	
	public void setTotalPriceWithTax(final PriceData totalPriceWithTax)
	{
		this.totalPriceWithTax = totalPriceWithTax;
	}

		
	
	public PriceData getTotalPriceWithTax() 
	{
		return totalPriceWithTax;
	}
	
		
	
	public void setEntries(final Collection<OrderEntryData> entries)
	{
		this.entries = entries;
	}

		
	
	public Collection<OrderEntryData> getEntries() 
	{
		return entries;
	}
	
		
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

		
	
	public Long getQuantity() 
	{
		return quantity;
	}
	


}
