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
import com.hybris.mobile.lib.commerce.data.product.PromotionResult;
import com.hybris.mobile.lib.commerce.data.user.Address;
import com.hybris.mobile.lib.commerce.data.user.Principal;
import com.hybris.mobile.lib.commerce.data.voucher.Voucher;

import java.util.List;

public class AbstractOrder  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>AbstractOrder.appliedProductPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<PromotionResult> appliedProductPromotions;
	/** <i>Generated property</i> for <code>AbstractOrder.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>AbstractOrder.totalPrice</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price totalPrice;
	/** <i>Generated property</i> for <code>AbstractOrder.totalDiscounts</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price totalDiscounts;
	/** <i>Generated property</i> for <code>AbstractOrder.subTotal</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price subTotal;
	/** <i>Generated property</i> for <code>AbstractOrder.totalTax</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price totalTax;
	/** <i>Generated property</i> for <code>AbstractOrder.appliedVouchers</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Voucher> appliedVouchers;
	/** <i>Generated property</i> for <code>AbstractOrder.deliveryMode</code> property defined at extension <code>commercewebservicescommons</code>. */
	private DeliveryMode deliveryMode;
	/** <i>Generated property</i> for <code>AbstractOrder.deliveryAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Address deliveryAddress;
	/** <i>Generated property</i> for <code>AbstractOrder.deliveryItemsQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long deliveryItemsQuantity;
	/** <i>Generated property</i> for <code>AbstractOrder.totalPriceWithTax</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price totalPriceWithTax;
	/** <i>Generated property</i> for <code>AbstractOrder.net</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean net;
	/** <i>Generated property</i> for <code>AbstractOrder.calculated</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean calculated;
	/** <i>Generated property</i> for <code>AbstractOrder.totalItems</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer totalItems;
	/** <i>Generated property</i> for <code>AbstractOrder.productDiscounts</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price productDiscounts;
	/** <i>Generated property</i> for <code>AbstractOrder.appliedOrderPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<PromotionResult> appliedOrderPromotions;
	/** <i>Generated property</i> for <code>AbstractOrder.pickupOrderGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<PickupOrderEntryGroup> pickupOrderGroups;
	/** <i>Generated property</i> for <code>AbstractOrder.orderDiscounts</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price orderDiscounts;
	/** <i>Generated property</i> for <code>AbstractOrder.store</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String store;
	/** <i>Generated property</i> for <code>AbstractOrder.entries</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<OrderEntry> entries;
	/** <i>Generated property</i> for <code>AbstractOrder.site</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String site;
	/** <i>Generated property</i> for <code>AbstractOrder.guid</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String guid;
	/** <i>Generated property</i> for <code>AbstractOrder.pickupItemsQuantity</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long pickupItemsQuantity;
	/** <i>Generated property</i> for <code>AbstractOrder.user</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Principal user;
	/** <i>Generated property</i> for <code>AbstractOrder.paymentInfo</code> property defined at extension <code>commercewebservicescommons</code>. */
	private PaymentDetails paymentInfo;
	/** <i>Generated property</i> for <code>AbstractOrder.deliveryOrderGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<DeliveryOrderEntryGroup> deliveryOrderGroups;
	/** <i>Generated property</i> for <code>AbstractOrder.deliveryCost</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price deliveryCost;
		
	public AbstractOrder()
	{
		// default constructor
	}
	
		
	public void setAppliedProductPromotions(final List<PromotionResult> appliedProductPromotions)
	{
		this.appliedProductPromotions = appliedProductPromotions;
	}
	
		
	public List<PromotionResult> getAppliedProductPromotions() 
	{
		return appliedProductPromotions;
	}
		
		
	public void setCode(final String code)
	{
		this.code = code;
	}
	
		
	public String getCode() 
	{
		return code;
	}
		
		
	public void setTotalPrice(final Price totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	
		
	public Price getTotalPrice() 
	{
		return totalPrice;
	}
		
		
	public void setTotalDiscounts(final Price totalDiscounts)
	{
		this.totalDiscounts = totalDiscounts;
	}
	
		
	public Price getTotalDiscounts() 
	{
		return totalDiscounts;
	}
		
		
	public void setSubTotal(final Price subTotal)
	{
		this.subTotal = subTotal;
	}
	
		
	public Price getSubTotal() 
	{
		return subTotal;
	}
		
		
	public void setTotalTax(final Price totalTax)
	{
		this.totalTax = totalTax;
	}
	
		
	public Price getTotalTax() 
	{
		return totalTax;
	}
		
		
	public void setAppliedVouchers(final List<Voucher> appliedVouchers)
	{
		this.appliedVouchers = appliedVouchers;
	}
	
		
	public List<Voucher> getAppliedVouchers() 
	{
		return appliedVouchers;
	}
		
		
	public void setDeliveryMode(final DeliveryMode deliveryMode)
	{
		this.deliveryMode = deliveryMode;
	}
	
		
	public DeliveryMode getDeliveryMode() 
	{
		return deliveryMode;
	}
		
		
	public void setDeliveryAddress(final Address deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}
	
		
	public Address getDeliveryAddress() 
	{
		return deliveryAddress;
	}
		
		
	public void setDeliveryItemsQuantity(final Long deliveryItemsQuantity)
	{
		this.deliveryItemsQuantity = deliveryItemsQuantity;
	}
	
		
	public Long getDeliveryItemsQuantity() 
	{
		return deliveryItemsQuantity;
	}
		
		
	public void setTotalPriceWithTax(final Price totalPriceWithTax)
	{
		this.totalPriceWithTax = totalPriceWithTax;
	}
	
		
	public Price getTotalPriceWithTax() 
	{
		return totalPriceWithTax;
	}
		
		
	public void setNet(final Boolean net)
	{
		this.net = net;
	}
	
		
	public Boolean getNet() 
	{
		return net;
	}
		
		
	public void setCalculated(final Boolean calculated)
	{
		this.calculated = calculated;
	}
	
		
	public Boolean getCalculated() 
	{
		return calculated;
	}
		
		
	public void setTotalItems(final Integer totalItems)
	{
		this.totalItems = totalItems;
	}
	
		
	public Integer getTotalItems() 
	{
		return totalItems;
	}
		
		
	public void setProductDiscounts(final Price productDiscounts)
	{
		this.productDiscounts = productDiscounts;
	}
	
		
	public Price getProductDiscounts() 
	{
		return productDiscounts;
	}
		
		
	public void setAppliedOrderPromotions(final List<PromotionResult> appliedOrderPromotions)
	{
		this.appliedOrderPromotions = appliedOrderPromotions;
	}
	
		
	public List<PromotionResult> getAppliedOrderPromotions() 
	{
		return appliedOrderPromotions;
	}
		
		
	public void setPickupOrderGroups(final List<PickupOrderEntryGroup> pickupOrderGroups)
	{
		this.pickupOrderGroups = pickupOrderGroups;
	}
	
		
	public List<PickupOrderEntryGroup> getPickupOrderGroups() 
	{
		return pickupOrderGroups;
	}
		
		
	public void setOrderDiscounts(final Price orderDiscounts)
	{
		this.orderDiscounts = orderDiscounts;
	}
	
		
	public Price getOrderDiscounts() 
	{
		return orderDiscounts;
	}
		
		
	public void setStore(final String store)
	{
		this.store = store;
	}
	
		
	public String getStore() 
	{
		return store;
	}
		
		
	public void setEntries(final List<OrderEntry> entries)
	{
		this.entries = entries;
	}
	
		
	public List<OrderEntry> getEntries() 
	{
		return entries;
	}
		
		
	public void setSite(final String site)
	{
		this.site = site;
	}
	
		
	public String getSite() 
	{
		return site;
	}
		
		
	public void setGuid(final String guid)
	{
		this.guid = guid;
	}
	
		
	public String getGuid() 
	{
		return guid;
	}
		
		
	public void setPickupItemsQuantity(final Long pickupItemsQuantity)
	{
		this.pickupItemsQuantity = pickupItemsQuantity;
	}
	
		
	public Long getPickupItemsQuantity() 
	{
		return pickupItemsQuantity;
	}
		
		
	public void setUser(final Principal user)
	{
		this.user = user;
	}
	
		
	public Principal getUser() 
	{
		return user;
	}
		
		
	public void setPaymentInfo(final PaymentDetails paymentInfo)
	{
		this.paymentInfo = paymentInfo;
	}
	
		
	public PaymentDetails getPaymentInfo() 
	{
		return paymentInfo;
	}
		
		
	public void setDeliveryOrderGroups(final List<DeliveryOrderEntryGroup> deliveryOrderGroups)
	{
		this.deliveryOrderGroups = deliveryOrderGroups;
	}
	
		
	public List<DeliveryOrderEntryGroup> getDeliveryOrderGroups() 
	{
		return deliveryOrderGroups;
	}
		
		
	public void setDeliveryCost(final Price deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}
	
		
	public Price getDeliveryCost() 
	{
		return deliveryCost;
	}
		
	
}