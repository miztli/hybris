/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:22 PM
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
package com.hybris.mobile.lib.commerce.data.order;

public class PromotionOrderEntryConsumed  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>PromotionOrderEntryConsumed.orderEntryNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer orderEntryNumber;
	/** <i>Generated property</i> for <code>PromotionOrderEntryConsumed.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>PromotionOrderEntryConsumed.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long quantity;
	/** <i>Generated property</i> for <code>PromotionOrderEntryConsumed.adjustedUnitPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double adjustedUnitPrice;
		
	public PromotionOrderEntryConsumed()
	{
		// default constructor
	}
	
		
	public void setOrderEntryNumber(final Integer orderEntryNumber)
	{
		this.orderEntryNumber = orderEntryNumber;
	}
	
		
	public Integer getOrderEntryNumber() 
	{
		return orderEntryNumber;
	}
		
		
	public void setCode(final String code)
	{
		this.code = code;
	}
	
		
	public String getCode() 
	{
		return code;
	}
		
		
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}
	
		
	public Long getQuantity() 
	{
		return quantity;
	}
		
		
	public void setAdjustedUnitPrice(final Double adjustedUnitPrice)
	{
		this.adjustedUnitPrice = adjustedUnitPrice;
	}
	
		
	public Double getAdjustedUnitPrice() 
	{
		return adjustedUnitPrice;
	}
		
	
}