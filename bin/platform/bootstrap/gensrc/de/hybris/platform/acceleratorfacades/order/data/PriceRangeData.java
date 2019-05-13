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
package de.hybris.platform.acceleratorfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.PriceData;

public  class PriceRangeData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PriceRangeData.minPrice</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData minPrice;

	/** <i>Generated property</i> for <code>PriceRangeData.maxPrice</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData maxPrice;
	
	public PriceRangeData()
	{
		// default constructor
	}
	
		
	
	public void setMinPrice(final PriceData minPrice)
	{
		this.minPrice = minPrice;
	}

		
	
	public PriceData getMinPrice() 
	{
		return minPrice;
	}
	
		
	
	public void setMaxPrice(final PriceData maxPrice)
	{
		this.maxPrice = maxPrice;
	}

		
	
	public PriceData getMaxPrice() 
	{
		return maxPrice;
	}
	


}
