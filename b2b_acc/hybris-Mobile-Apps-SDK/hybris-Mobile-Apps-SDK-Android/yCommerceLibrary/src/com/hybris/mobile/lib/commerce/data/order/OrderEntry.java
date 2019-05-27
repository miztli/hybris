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

import com.hybris.mobile.lib.commerce.data.product.Price;
import com.hybris.mobile.lib.commerce.data.product.Product;
import com.hybris.mobile.lib.commerce.data.product.PromotionResult;
import com.hybris.mobile.lib.commerce.data.store.PointOfService;

public class OrderEntry  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>OrderEntry.updateable</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean updateable;
	/** <i>Generated property</i> for <code>OrderEntry.product</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Product product;
	/** <i>Generated property</i> for <code>OrderEntry.quantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long quantity;
	/** <i>Generated property</i> for <code>OrderEntry.totalPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price totalPrice;
	/** <i>Generated property</i> for <code>OrderEntry.deliveryMode</code> property defined at extension <code>commercewebservicescommons</code>. */
	private DeliveryMode deliveryMode;
	/** <i>Generated property</i> for <code>OrderEntry.deliveryPointOfService</code> property defined at extension <code>commercewebservicescommons</code>. */
	private PointOfService deliveryPointOfService;
	/** <i>Generated property</i> for <code>OrderEntry.entryNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer entryNumber;
	/** <i>Generated property</i> for <code>OrderEntry.basePrice</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price basePrice;
		
	private PromotionResult promotionResult;

	public OrderEntry()
	{
		// default constructor
	}
	
		
	public void setUpdateable(final Boolean updateable)
	{
		this.updateable = updateable;
	}
	
		
	public Boolean getUpdateable() 
	{
		return updateable;
	}
		
		
	public void setProduct(final Product product)
	{
		this.product = product;
	}
	
		
	public Product getProduct() 
	{
		return product;
	}
		
		
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}
	
		
	public Long getQuantity() 
	{
		return quantity;
	}
		
		
	public void setTotalPrice(final Price totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	
		
	public Price getTotalPrice() 
	{
		return totalPrice;
	}
		
		
	public void setDeliveryMode(final DeliveryMode deliveryMode)
	{
		this.deliveryMode = deliveryMode;
	}
	
		
	public DeliveryMode getDeliveryMode() 
	{
		return deliveryMode;
	}
		
		
	public void setDeliveryPointOfService(final PointOfService deliveryPointOfService)
	{
		this.deliveryPointOfService = deliveryPointOfService;
	}
	
		
	public PointOfService getDeliveryPointOfService() 
	{
		return deliveryPointOfService;
	}
		
		
	public void setEntryNumber(final Integer entryNumber)
	{
		this.entryNumber = entryNumber;
	}
	
		
	public Integer getEntryNumber() 
	{
		return entryNumber;
	}
		
		
	public void setBasePrice(final Price basePrice)
	{
		this.basePrice = basePrice;
	}
	
		
	public Price getBasePrice() 
	{
		return basePrice;
	}


	public PromotionResult getPromotionResult() {
		return promotionResult;
	}

	public void setPromotionResult(PromotionResult promotionResult) {
		this.promotionResult = promotionResult;
	}
}