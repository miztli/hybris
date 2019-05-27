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
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import java.util.Set;

public  class AddToCartParams  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddToCartParams.productCode</code> property defined at extension <code>commercefacades</code>. */
		
	private String productCode;

	/** <i>Generated property</i> for <code>AddToCartParams.quantity</code> property defined at extension <code>commercefacades</code>. */
		
	private long quantity;

	/** <i>Generated property</i> for <code>AddToCartParams.storeId</code> property defined at extension <code>commercefacades</code>. */
		
	private String storeId;

	/** <i>Generated property</i> for <code>AddToCartParams.entryGroupNumbers</code> property defined at extension <code>commercefacades</code>. */
		
	private Set<Integer> entryGroupNumbers;
	
	public AddToCartParams()
	{
		// default constructor
	}
	
		
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

		
	
	public String getProductCode() 
	{
		return productCode;
	}
	
		
	
	public void setQuantity(final long quantity)
	{
		this.quantity = quantity;
	}

		
	
	public long getQuantity() 
	{
		return quantity;
	}
	
		
	
	public void setStoreId(final String storeId)
	{
		this.storeId = storeId;
	}

		
	
	public String getStoreId() 
	{
		return storeId;
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
