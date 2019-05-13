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
package de.hybris.platform.commercefacades.voucher.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.storesession.data.CurrencyData;

public  class VoucherData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>VoucherData.code</code> property defined at extension <code>commercefacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>VoucherData.voucherCode</code> property defined at extension <code>commercefacades</code>. */
		
	private String voucherCode;

	/** <i>Generated property</i> for <code>VoucherData.name</code> property defined at extension <code>commercefacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>VoucherData.description</code> property defined at extension <code>commercefacades</code>. */
		
	private String description;

	/** <i>Generated property</i> for <code>VoucherData.value</code> property defined at extension <code>commercefacades</code>. */
		
	private Double value;

	/** <i>Generated property</i> for <code>VoucherData.valueFormatted</code> property defined at extension <code>commercefacades</code>. */
		
	private String valueFormatted;

	/** <i>Generated property</i> for <code>VoucherData.valueString</code> property defined at extension <code>commercefacades</code>. */
		
	private String valueString;

	/** <i>Generated property</i> for <code>VoucherData.freeShipping</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean freeShipping;

	/** <i>Generated property</i> for <code>VoucherData.currency</code> property defined at extension <code>commercefacades</code>. */
		
	private CurrencyData currency;

	/** <i>Generated property</i> for <code>VoucherData.appliedValue</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData appliedValue;
	
	public VoucherData()
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
	
		
	
	public void setVoucherCode(final String voucherCode)
	{
		this.voucherCode = voucherCode;
	}

		
	
	public String getVoucherCode() 
	{
		return voucherCode;
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
	
		
	
	public void setValue(final Double value)
	{
		this.value = value;
	}

		
	
	public Double getValue() 
	{
		return value;
	}
	
		
	
	public void setValueFormatted(final String valueFormatted)
	{
		this.valueFormatted = valueFormatted;
	}

		
	
	public String getValueFormatted() 
	{
		return valueFormatted;
	}
	
		
	
	public void setValueString(final String valueString)
	{
		this.valueString = valueString;
	}

		
	
	public String getValueString() 
	{
		return valueString;
	}
	
		
	
	public void setFreeShipping(final boolean freeShipping)
	{
		this.freeShipping = freeShipping;
	}

		
	
	public boolean isFreeShipping() 
	{
		return freeShipping;
	}
	
		
	
	public void setCurrency(final CurrencyData currency)
	{
		this.currency = currency;
	}

		
	
	public CurrencyData getCurrency() 
	{
		return currency;
	}
	
		
	
	public void setAppliedValue(final PriceData appliedValue)
	{
		this.appliedValue = appliedValue;
	}

		
	
	public PriceData getAppliedValue() 
	{
		return appliedValue;
	}
	


}
