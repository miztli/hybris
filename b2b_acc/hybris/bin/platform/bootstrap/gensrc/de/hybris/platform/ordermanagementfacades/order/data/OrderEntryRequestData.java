/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
package de.hybris.platform.ordermanagementfacades.order.data;

import java.io.Serializable;

public  class OrderEntryRequestData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderEntryRequestData.entryNumber</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Integer entryNumber;

	/** <i>Generated property</i> for <code>OrderEntryRequestData.quantity</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private long quantity;

	/** <i>Generated property</i> for <code>OrderEntryRequestData.unitCode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String unitCode;

	/** <i>Generated property</i> for <code>OrderEntryRequestData.productCode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String productCode;

	/** <i>Generated property</i> for <code>OrderEntryRequestData.deliveryModeCode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String deliveryModeCode;

	/** <i>Generated property</i> for <code>OrderEntryRequestData.deliveryPointOfService</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String deliveryPointOfService;

	/** <i>Generated property</i> for <code>OrderEntryRequestData.basePrice</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private double basePrice;

	/** <i>Generated property</i> for <code>OrderEntryRequestData.totalPrice</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private double totalPrice;

	/** <i>Generated property</i> for <code>OrderEntryRequestData.pointOfService</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String pointOfService;
	
	public OrderEntryRequestData()
	{
		// default constructor
	}
	
		
	
	public void setEntryNumber(final Integer entryNumber)
	{
		this.entryNumber = entryNumber;
	}

		
	
	public Integer getEntryNumber() 
	{
		return entryNumber;
	}
	
		
	
	public void setQuantity(final long quantity)
	{
		this.quantity = quantity;
	}

		
	
	public long getQuantity() 
	{
		return quantity;
	}
	
		
	
	public void setUnitCode(final String unitCode)
	{
		this.unitCode = unitCode;
	}

		
	
	public String getUnitCode() 
	{
		return unitCode;
	}
	
		
	
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

		
	
	public String getProductCode() 
	{
		return productCode;
	}
	
		
	
	public void setDeliveryModeCode(final String deliveryModeCode)
	{
		this.deliveryModeCode = deliveryModeCode;
	}

		
	
	public String getDeliveryModeCode() 
	{
		return deliveryModeCode;
	}
	
		
	
	public void setDeliveryPointOfService(final String deliveryPointOfService)
	{
		this.deliveryPointOfService = deliveryPointOfService;
	}

		
	
	public String getDeliveryPointOfService() 
	{
		return deliveryPointOfService;
	}
	
		
	
	public void setBasePrice(final double basePrice)
	{
		this.basePrice = basePrice;
	}

		
	
	public double getBasePrice() 
	{
		return basePrice;
	}
	
		
	
	public void setTotalPrice(final double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

		
	
	public double getTotalPrice() 
	{
		return totalPrice;
	}
	
		
	
	public void setPointOfService(final String pointOfService)
	{
		this.pointOfService = pointOfService;
	}

		
	
	public String getPointOfService() 
	{
		return pointOfService;
	}
	


}
