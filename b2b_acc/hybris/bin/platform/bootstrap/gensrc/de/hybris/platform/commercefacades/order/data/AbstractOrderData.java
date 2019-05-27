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
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.comment.data.CommentData;
import de.hybris.platform.commercefacades.order.EntryGroupData;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.commercefacades.order.data.DeliveryModeData;
import de.hybris.platform.commercefacades.order.data.DeliveryOrderEntryGroupData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.order.data.PickupOrderEntryGroupData;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PromotionResultData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import java.util.Date;
import java.util.List;

public  class AbstractOrderData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractOrderData.code</code> property defined at extension <code>commercefacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>AbstractOrderData.name</code> property defined at extension <code>commercefacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>AbstractOrderData.description</code> property defined at extension <code>commercefacades</code>. */
		
	private String description;

	/** <i>Generated property</i> for <code>AbstractOrderData.expirationTime</code> property defined at extension <code>commercefacades</code>. */
		
	private Date expirationTime;

	/** <i>Generated property</i> for <code>AbstractOrderData.net</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean net;

	/** <i>Generated property</i> for <code>AbstractOrderData.totalPriceWithTax</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData totalPriceWithTax;

	/** <i>Generated property</i> for <code>AbstractOrderData.totalPrice</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData totalPrice;

	/** <i>Generated property</i> for <code>AbstractOrderData.totalTax</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData totalTax;

	/** <i>Generated property</i> for <code>AbstractOrderData.subTotal</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData subTotal;

	/** <i>Generated property</i> for <code>AbstractOrderData.subTotalWithoutQuoteDiscounts</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData subTotalWithoutQuoteDiscounts;

	/** <i>Generated property</i> for <code>AbstractOrderData.deliveryCost</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData deliveryCost;

	/** <i>Generated property</i> for <code>AbstractOrderData.entries</code> property defined at extension <code>commercefacades</code>. */
		
	private List<OrderEntryData> entries;

	/** <i>Generated property</i> for <code>AbstractOrderData.totalItems</code> property defined at extension <code>commercefacades</code>. */
		
	private Integer totalItems;

	/** <i>Generated property</i> for <code>AbstractOrderData.deliveryMode</code> property defined at extension <code>commercefacades</code>. */
		
	private DeliveryModeData deliveryMode;

	/** <i>Generated property</i> for <code>AbstractOrderData.deliveryAddress</code> property defined at extension <code>commercefacades</code>. */
		
	private AddressData deliveryAddress;

	/** <i>Generated property</i> for <code>AbstractOrderData.paymentInfo</code> property defined at extension <code>commercefacades</code>. */
		
	private CCPaymentInfoData paymentInfo;

	/** <i>Generated property</i> for <code>AbstractOrderData.appliedOrderPromotions</code> property defined at extension <code>commercefacades</code>. */
		
	private List<PromotionResultData> appliedOrderPromotions;

	/** <i>Generated property</i> for <code>AbstractOrderData.appliedProductPromotions</code> property defined at extension <code>commercefacades</code>. */
		
	private List<PromotionResultData> appliedProductPromotions;

	/** <i>Generated property</i> for <code>AbstractOrderData.productDiscounts</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData productDiscounts;

	/** <i>Generated property</i> for <code>AbstractOrderData.orderDiscounts</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData orderDiscounts;

	/** <i>Generated property</i> for <code>AbstractOrderData.quoteDiscounts</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData quoteDiscounts;

	/** <i>Generated property</i> for <code>AbstractOrderData.quoteDiscountsRate</code> property defined at extension <code>commercefacades</code>. */
		
	private Double quoteDiscountsRate;

	/** <i>Generated property</i> for <code>AbstractOrderData.quoteDiscountsType</code> property defined at extension <code>commercefacades</code>. */
		
	private String quoteDiscountsType;

	/** <i>Generated property</i> for <code>AbstractOrderData.totalDiscounts</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData totalDiscounts;

	/** <i>Generated property</i> for <code>AbstractOrderData.totalDiscountsWithQuoteDiscounts</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData totalDiscountsWithQuoteDiscounts;

	/** <i>Generated property</i> for <code>AbstractOrderData.subTotalWithDiscounts</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData subTotalWithDiscounts;

	/** <i>Generated property</i> for <code>AbstractOrderData.site</code> property defined at extension <code>commercefacades</code>. */
		
	private String site;

	/** <i>Generated property</i> for <code>AbstractOrderData.store</code> property defined at extension <code>commercefacades</code>. */
		
	private String store;

	/** <i>Generated property</i> for <code>AbstractOrderData.guid</code> property defined at extension <code>commercefacades</code>. */
		
	private String guid;

	/** <i>Generated property</i> for <code>AbstractOrderData.calculated</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean calculated;

	/** <i>Generated property</i> for <code>AbstractOrderData.appliedVouchers</code> property defined at extension <code>commercefacades</code>. */
		
	private List<String> appliedVouchers;

	/** <i>Generated property</i> for <code>AbstractOrderData.user</code> property defined at extension <code>commercefacades</code>. */
		
	private PrincipalData user;

	/** <i>Generated property</i> for <code>AbstractOrderData.pickupOrderGroups</code> property defined at extension <code>commercefacades</code>. */
		
	private List<PickupOrderEntryGroupData> pickupOrderGroups;

	/** <i>Generated property</i> for <code>AbstractOrderData.deliveryOrderGroups</code> property defined at extension <code>commercefacades</code>. */
		
	private List<DeliveryOrderEntryGroupData> deliveryOrderGroups;

	/** <i>Generated property</i> for <code>AbstractOrderData.pickupItemsQuantity</code> property defined at extension <code>commercefacades</code>. */
		
	private Long pickupItemsQuantity;

	/** <i>Generated property</i> for <code>AbstractOrderData.deliveryItemsQuantity</code> property defined at extension <code>commercefacades</code>. */
		
	private Long deliveryItemsQuantity;

	/** <i>Generated property</i> for <code>AbstractOrderData.totalUnitCount</code> property defined at extension <code>commercefacades</code>. */
		
	private Integer totalUnitCount;

	/** <i>Generated property</i> for <code>AbstractOrderData.comments</code> property defined at extension <code>commercefacades</code>. */
		
	private List<CommentData> comments;

	/** <i>Generated property</i> for <code>AbstractOrderData.rootGroups</code> property defined at extension <code>commercefacades</code>. */
		
	private List<EntryGroupData> rootGroups;
	
	public AbstractOrderData()
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
	
		
	
	public void setExpirationTime(final Date expirationTime)
	{
		this.expirationTime = expirationTime;
	}

		
	
	public Date getExpirationTime() 
	{
		return expirationTime;
	}
	
		
	
	public void setNet(final boolean net)
	{
		this.net = net;
	}

		
	
	public boolean isNet() 
	{
		return net;
	}
	
		
	
	public void setTotalPriceWithTax(final PriceData totalPriceWithTax)
	{
		this.totalPriceWithTax = totalPriceWithTax;
	}

		
	
	public PriceData getTotalPriceWithTax() 
	{
		return totalPriceWithTax;
	}
	
		
	
	public void setTotalPrice(final PriceData totalPrice)
	{
		this.totalPrice = totalPrice;
	}

		
	
	public PriceData getTotalPrice() 
	{
		return totalPrice;
	}
	
		
	
	public void setTotalTax(final PriceData totalTax)
	{
		this.totalTax = totalTax;
	}

		
	
	public PriceData getTotalTax() 
	{
		return totalTax;
	}
	
		
	
	public void setSubTotal(final PriceData subTotal)
	{
		this.subTotal = subTotal;
	}

		
	
	public PriceData getSubTotal() 
	{
		return subTotal;
	}
	
		
	
	public void setSubTotalWithoutQuoteDiscounts(final PriceData subTotalWithoutQuoteDiscounts)
	{
		this.subTotalWithoutQuoteDiscounts = subTotalWithoutQuoteDiscounts;
	}

		
	
	public PriceData getSubTotalWithoutQuoteDiscounts() 
	{
		return subTotalWithoutQuoteDiscounts;
	}
	
		
	
	public void setDeliveryCost(final PriceData deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}

		
	
	public PriceData getDeliveryCost() 
	{
		return deliveryCost;
	}
	
		
	
	public void setEntries(final List<OrderEntryData> entries)
	{
		this.entries = entries;
	}

		
	
	public List<OrderEntryData> getEntries() 
	{
		return entries;
	}
	
		
	
	public void setTotalItems(final Integer totalItems)
	{
		this.totalItems = totalItems;
	}

		
	
	public Integer getTotalItems() 
	{
		return totalItems;
	}
	
		
	
	public void setDeliveryMode(final DeliveryModeData deliveryMode)
	{
		this.deliveryMode = deliveryMode;
	}

		
	
	public DeliveryModeData getDeliveryMode() 
	{
		return deliveryMode;
	}
	
		
	
	public void setDeliveryAddress(final AddressData deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

		
	
	public AddressData getDeliveryAddress() 
	{
		return deliveryAddress;
	}
	
		
	
	public void setPaymentInfo(final CCPaymentInfoData paymentInfo)
	{
		this.paymentInfo = paymentInfo;
	}

		
	
	public CCPaymentInfoData getPaymentInfo() 
	{
		return paymentInfo;
	}
	
		
	
	public void setAppliedOrderPromotions(final List<PromotionResultData> appliedOrderPromotions)
	{
		this.appliedOrderPromotions = appliedOrderPromotions;
	}

		
	
	public List<PromotionResultData> getAppliedOrderPromotions() 
	{
		return appliedOrderPromotions;
	}
	
		
	
	public void setAppliedProductPromotions(final List<PromotionResultData> appliedProductPromotions)
	{
		this.appliedProductPromotions = appliedProductPromotions;
	}

		
	
	public List<PromotionResultData> getAppliedProductPromotions() 
	{
		return appliedProductPromotions;
	}
	
		
	
	public void setProductDiscounts(final PriceData productDiscounts)
	{
		this.productDiscounts = productDiscounts;
	}

		
	
	public PriceData getProductDiscounts() 
	{
		return productDiscounts;
	}
	
		
	
	public void setOrderDiscounts(final PriceData orderDiscounts)
	{
		this.orderDiscounts = orderDiscounts;
	}

		
	
	public PriceData getOrderDiscounts() 
	{
		return orderDiscounts;
	}
	
		
	
	public void setQuoteDiscounts(final PriceData quoteDiscounts)
	{
		this.quoteDiscounts = quoteDiscounts;
	}

		
	
	public PriceData getQuoteDiscounts() 
	{
		return quoteDiscounts;
	}
	
		
	
	public void setQuoteDiscountsRate(final Double quoteDiscountsRate)
	{
		this.quoteDiscountsRate = quoteDiscountsRate;
	}

		
	
	public Double getQuoteDiscountsRate() 
	{
		return quoteDiscountsRate;
	}
	
		
	
	public void setQuoteDiscountsType(final String quoteDiscountsType)
	{
		this.quoteDiscountsType = quoteDiscountsType;
	}

		
	
	public String getQuoteDiscountsType() 
	{
		return quoteDiscountsType;
	}
	
		
	
	public void setTotalDiscounts(final PriceData totalDiscounts)
	{
		this.totalDiscounts = totalDiscounts;
	}

		
	
	public PriceData getTotalDiscounts() 
	{
		return totalDiscounts;
	}
	
		
	
	public void setTotalDiscountsWithQuoteDiscounts(final PriceData totalDiscountsWithQuoteDiscounts)
	{
		this.totalDiscountsWithQuoteDiscounts = totalDiscountsWithQuoteDiscounts;
	}

		
	
	public PriceData getTotalDiscountsWithQuoteDiscounts() 
	{
		return totalDiscountsWithQuoteDiscounts;
	}
	
	@Deprecated
    /**
     * @deprecated Since 6.3. Use de.hybris.platform.commercefacades.order.data.AbstractOrderData#subTotal instead.
     */
		
	
	public void setSubTotalWithDiscounts(final PriceData subTotalWithDiscounts)
	{
		this.subTotalWithDiscounts = subTotalWithDiscounts;
	}

	@Deprecated
	/**
	 * @deprecated Since 6.3. Use de.hybris.platform.commercefacades.order.data.AbstractOrderData#subTotal instead.
	 */
		
	
	public PriceData getSubTotalWithDiscounts() 
	{
		return subTotalWithDiscounts;
	}
	
		
	
	public void setSite(final String site)
	{
		this.site = site;
	}

		
	
	public String getSite() 
	{
		return site;
	}
	
		
	
	public void setStore(final String store)
	{
		this.store = store;
	}

		
	
	public String getStore() 
	{
		return store;
	}
	
		
	
	public void setGuid(final String guid)
	{
		this.guid = guid;
	}

		
	
	public String getGuid() 
	{
		return guid;
	}
	
		
	
	public void setCalculated(final boolean calculated)
	{
		this.calculated = calculated;
	}

		
	
	public boolean isCalculated() 
	{
		return calculated;
	}
	
		
	
	public void setAppliedVouchers(final List<String> appliedVouchers)
	{
		this.appliedVouchers = appliedVouchers;
	}

		
	
	public List<String> getAppliedVouchers() 
	{
		return appliedVouchers;
	}
	
		
	
	public void setUser(final PrincipalData user)
	{
		this.user = user;
	}

		
	
	public PrincipalData getUser() 
	{
		return user;
	}
	
		
	
	public void setPickupOrderGroups(final List<PickupOrderEntryGroupData> pickupOrderGroups)
	{
		this.pickupOrderGroups = pickupOrderGroups;
	}

		
	
	public List<PickupOrderEntryGroupData> getPickupOrderGroups() 
	{
		return pickupOrderGroups;
	}
	
		
	
	public void setDeliveryOrderGroups(final List<DeliveryOrderEntryGroupData> deliveryOrderGroups)
	{
		this.deliveryOrderGroups = deliveryOrderGroups;
	}

		
	
	public List<DeliveryOrderEntryGroupData> getDeliveryOrderGroups() 
	{
		return deliveryOrderGroups;
	}
	
		
	
	public void setPickupItemsQuantity(final Long pickupItemsQuantity)
	{
		this.pickupItemsQuantity = pickupItemsQuantity;
	}

		
	
	public Long getPickupItemsQuantity() 
	{
		return pickupItemsQuantity;
	}
	
		
	
	public void setDeliveryItemsQuantity(final Long deliveryItemsQuantity)
	{
		this.deliveryItemsQuantity = deliveryItemsQuantity;
	}

		
	
	public Long getDeliveryItemsQuantity() 
	{
		return deliveryItemsQuantity;
	}
	
		
	
	public void setTotalUnitCount(final Integer totalUnitCount)
	{
		this.totalUnitCount = totalUnitCount;
	}

		
	
	public Integer getTotalUnitCount() 
	{
		return totalUnitCount;
	}
	
		
	
	public void setComments(final List<CommentData> comments)
	{
		this.comments = comments;
	}

		
	
	public List<CommentData> getComments() 
	{
		return comments;
	}
	
		
	
	public void setRootGroups(final List<EntryGroupData> rootGroups)
	{
		this.rootGroups = rootGroups;
	}

		
	
	public List<EntryGroupData> getRootGroups() 
	{
		return rootGroups;
	}
	


}
