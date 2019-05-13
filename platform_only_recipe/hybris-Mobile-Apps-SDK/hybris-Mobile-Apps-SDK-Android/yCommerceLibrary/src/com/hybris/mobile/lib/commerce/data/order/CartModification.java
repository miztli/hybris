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

import org.apache.commons.lang3.StringUtils;

public class CartModification  implements java.io.Serializable
{

	/** <i>Generated property</i> for <code>CartModification.entry</code> property defined at extension <code>commercewebservicescommons</code>. */
	private OrderEntry entry;
	/** <i>Generated property</i> for <code>CartModification.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long quantity;
	/** <i>Generated property</i> for <code>CartModification.deliveryModeChanged</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean deliveryModeChanged;
	/** <i>Generated property</i> for <code>CartModification.statusMessage</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String statusMessage;
	/** <i>Generated property</i> for <code>CartModification.statusCode</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String statusCode;
	/** <i>Generated property</i> for <code>CartModification.quantityAdded</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long quantityAdded;
		
	public CartModification()
	{
		// default constructor
	}
	
		
	public void setEntry(final OrderEntry entry)
	{
		this.entry = entry;
	}
	
		
	public OrderEntry getEntry() 
	{
		return entry;
	}
		
		
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}
	
		
	public Long getQuantity() 
	{
		return quantity;
	}
		
		
	public void setDeliveryModeChanged(final Boolean deliveryModeChanged)
	{
		this.deliveryModeChanged = deliveryModeChanged;
	}
	
		
	public Boolean getDeliveryModeChanged() 
	{
		return deliveryModeChanged;
	}
		
		
	public void setStatusMessage(final String statusMessage)
	{
		this.statusMessage = statusMessage;
	}
	
		
	public String getStatusMessage() 
	{
		return statusMessage;
	}
		
		
	public void setStatusCode(final String statusCode)
	{
		this.statusCode = statusCode;
	}
	
		
	public String getStatusCode() 
	{
		return statusCode;
	}
		
		
	public void setQuantityAdded(final Long quantityAdded)
	{
		this.quantityAdded = quantityAdded;
	}
	
		
	public Long getQuantityAdded() 
	{
		return quantityAdded;
	}

	public boolean isOutOfStock() {
		return StringUtils.equalsIgnoreCase(statusCode, StockLevelEnum.OUT_OF_STOCK.getStatus());
	}

	public boolean isQuantityAddedNotFulfilled() {
		return StringUtils.equalsIgnoreCase(statusCode, StockLevelEnum.LOW_STOCK.getStatus());
	}

	private enum StockLevelEnum {

		OUT_OF_STOCK("nostock"), LOW_STOCK("lowstock");

		private final String status;

		StockLevelEnum(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

	}

}