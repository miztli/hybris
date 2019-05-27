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
package com.hybris.mobile.lib.commerce.data.voucher;

import com.hybris.mobile.lib.commerce.data.product.Price;
import com.hybris.mobile.lib.commerce.data.storesession.Currency;

public class Voucher  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Voucher.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>Voucher.valueString</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String valueString;
	/** <i>Generated property</i> for <code>Voucher.freeShipping</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean freeShipping;
	/** <i>Generated property</i> for <code>Voucher.valueFormatted</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String valueFormatted;
	/** <i>Generated property</i> for <code>Voucher.name</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String name;
	/** <i>Generated property</i> for <code>Voucher.description</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String description;
	/** <i>Generated property</i> for <code>Voucher.appliedValue</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price appliedValue;
	/** <i>Generated property</i> for <code>Voucher.currency</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Currency currency;
	/** <i>Generated property</i> for <code>Voucher.value</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double value;
	/** <i>Generated property</i> for <code>Voucher.voucherCode</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String voucherCode;
		
	public Voucher()
	{
		// default constructor
	}
	
		
	public void setCode(final String code)
	{
		this.code = code;
	}
	
		
	public String getCode() 
	{
		return code;
	}
		
		
	public void setValueString(final String valueString)
	{
		this.valueString = valueString;
	}
	
		
	public String getValueString() 
	{
		return valueString;
	}
		
		
	public void setFreeShipping(final Boolean freeShipping)
	{
		this.freeShipping = freeShipping;
	}
	
		
	public Boolean getFreeShipping() 
	{
		return freeShipping;
	}
		
		
	public void setValueFormatted(final String valueFormatted)
	{
		this.valueFormatted = valueFormatted;
	}
	
		
	public String getValueFormatted() 
	{
		return valueFormatted;
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
		
		
	public void setAppliedValue(final Price appliedValue)
	{
		this.appliedValue = appliedValue;
	}
	
		
	public Price getAppliedValue() 
	{
		return appliedValue;
	}
		
		
	public void setCurrency(final Currency currency)
	{
		this.currency = currency;
	}
	
		
	public Currency getCurrency() 
	{
		return currency;
	}
		
		
	public void setValue(final Double value)
	{
		this.value = value;
	}
	
		
	public Double getValue() 
	{
		return value;
	}
		
		
	public void setVoucherCode(final String voucherCode)
	{
		this.voucherCode = voucherCode;
	}
	
		
	public String getVoucherCode() 
	{
		return voucherCode;
	}
		
	
}