/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
package de.hybris.platform.ruleengineservices.rao;

import java.io.Serializable;
import de.hybris.platform.ruleengineservices.rao.OrderEntryRAO;
import java.math.BigDecimal;

public  class OrderEntryConsumedRAO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderEntryConsumedRAO.firedRuleCode</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String firedRuleCode;

	/** <i>Generated property</i> for <code>OrderEntryConsumedRAO.orderEntry</code> property defined at extension <code>ruleengineservices</code>. */
		
	private OrderEntryRAO orderEntry;

	/** <i>Generated property</i> for <code>OrderEntryConsumedRAO.quantity</code> property defined at extension <code>ruleengineservices</code>. */
		
	private int quantity;

	/** <i>Generated property</i> for <code>OrderEntryConsumedRAO.adjustedUnitPrice</code> property defined at extension <code>ruleengineservices</code>. */
		
	private BigDecimal adjustedUnitPrice;
	
	public OrderEntryConsumedRAO()
	{
		// default constructor
	}
	
		
	
	public void setFiredRuleCode(final String firedRuleCode)
	{
		this.firedRuleCode = firedRuleCode;
	}

		
	
	public String getFiredRuleCode() 
	{
		return firedRuleCode;
	}
	
		
	
	public void setOrderEntry(final OrderEntryRAO orderEntry)
	{
		this.orderEntry = orderEntry;
	}

		
	
	public OrderEntryRAO getOrderEntry() 
	{
		return orderEntry;
	}
	
		
	
	public void setQuantity(final int quantity)
	{
		this.quantity = quantity;
	}

		
	
	public int getQuantity() 
	{
		return quantity;
	}
	
		
	
	public void setAdjustedUnitPrice(final BigDecimal adjustedUnitPrice)
	{
		this.adjustedUnitPrice = adjustedUnitPrice;
	}

		
	
	public BigDecimal getAdjustedUnitPrice() 
	{
		return adjustedUnitPrice;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final OrderEntryConsumedRAO other = (OrderEntryConsumedRAO) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getFiredRuleCode(), other.getFiredRuleCode()) 
			.append(getOrderEntry(), other.getOrderEntry()) 
			.append(getQuantity(), other.getQuantity()) 
			.append(getAdjustedUnitPrice(), other.getAdjustedUnitPrice()) 
			.isEquals();
		} 
		catch (ClassCastException c)
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return new org.apache.commons.lang.builder.HashCodeBuilder()
		.append(getFiredRuleCode()) 
		.append(getOrderEntry()) 
		.append(getQuantity()) 
		.append(getAdjustedUnitPrice()) 
		.toHashCode();
	}

}
