/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:23 PM
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
package com.hybris.mobile.lib.commerce.data.product;

import de.hybris.platform.commercefacades.product.data.PriceDataType;
import java.math.BigDecimal;

public class Price  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Price.currencyIso</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String currencyIso;
	/** <i>Generated property</i> for <code>Price.minQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long minQuantity;
	/** <i>Generated property</i> for <code>Price.maxQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long maxQuantity;
	/** <i>Generated property</i> for <code>Price.priceType</code> property defined at extension <code>commercewebservicescommons</code>. */
	private PriceDataType priceType;
	/** <i>Generated property</i> for <code>Price.formattedValue</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String formattedValue;
	/** <i>Generated property</i> for <code>Price.value</code> property defined at extension <code>commercewebservicescommons</code>. */
	private BigDecimal value;
		
	public Price()
	{
		// default constructor
	}
	
		
	public void setCurrencyIso(final String currencyIso)
	{
		this.currencyIso = currencyIso;
	}
	
		
	public String getCurrencyIso() 
	{
		return currencyIso;
	}
		
		
	public void setMinQuantity(final Long minQuantity)
	{
		this.minQuantity = minQuantity;
	}
	
		
	public Long getMinQuantity() 
	{
		return minQuantity;
	}
		
		
	public void setMaxQuantity(final Long maxQuantity)
	{
		this.maxQuantity = maxQuantity;
	}
	
		
	public Long getMaxQuantity() 
	{
		return maxQuantity;
	}
		
		
	public void setPriceType(final PriceDataType priceType)
	{
		this.priceType = priceType;
	}
	
		
	public PriceDataType getPriceType() 
	{
		return priceType;
	}
		
		
	public void setFormattedValue(final String formattedValue)
	{
		this.formattedValue = formattedValue;
	}
	
		
	public String getFormattedValue() 
	{
		return formattedValue;
	}
		
		
	public void setValue(final BigDecimal value)
	{
		this.value = value;
	}
	
		
	public BigDecimal getValue() 
	{
		return value;
	}
		
	
}