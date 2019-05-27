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
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;

public  class PromotionOrderEntryConsumedWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PromotionOrderEntryConsumedWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>PromotionOrderEntryConsumedWsDTO.adjustedUnitPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Double adjustedUnitPrice;

	/** <i>Generated property</i> for <code>PromotionOrderEntryConsumedWsDTO.orderEntryNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Integer orderEntryNumber;

	/** <i>Generated property</i> for <code>PromotionOrderEntryConsumedWsDTO.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Long quantity;
	
	public PromotionOrderEntryConsumedWsDTO()
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
	
		
	
	public void setAdjustedUnitPrice(final Double adjustedUnitPrice)
	{
		this.adjustedUnitPrice = adjustedUnitPrice;
	}

		
	
	public Double getAdjustedUnitPrice() 
	{
		return adjustedUnitPrice;
	}
	
		
	
	public void setOrderEntryNumber(final Integer orderEntryNumber)
	{
		this.orderEntryNumber = orderEntryNumber;
	}

		
	
	public Integer getOrderEntryNumber() 
	{
		return orderEntryNumber;
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
