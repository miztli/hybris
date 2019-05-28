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
import de.hybris.platform.commercefacades.product.data.PromotionResultData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.enums.DeliveryStatus;
import de.hybris.platform.ordermanagementfacades.order.data.OrderEntryRequestData;
import de.hybris.platform.ordermanagementfacades.payment.data.PaymentTransactionData;
import java.util.Date;
import java.util.List;
import java.util.Set;

public  class OrderRequestData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderRequestData.externalOrderCode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String externalOrderCode;

	/** <i>Generated property</i> for <code>OrderRequestData.name</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>OrderRequestData.description</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String description;

	/** <i>Generated property</i> for <code>OrderRequestData.guid</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String guid;

	/** <i>Generated property</i> for <code>OrderRequestData.user</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private CustomerData user;

	/** <i>Generated property</i> for <code>OrderRequestData.siteUid</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String siteUid;

	/** <i>Generated property</i> for <code>OrderRequestData.storeUid</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String storeUid;

	/** <i>Generated property</i> for <code>OrderRequestData.currencyIsocode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String currencyIsocode;

	/** <i>Generated property</i> for <code>OrderRequestData.languageIsocode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String languageIsocode;

	/** <i>Generated property</i> for <code>OrderRequestData.deliveryAddress</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private AddressData deliveryAddress;

	/** <i>Generated property</i> for <code>OrderRequestData.paymentAddress</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private AddressData paymentAddress;

	/** <i>Generated property</i> for <code>OrderRequestData.deliveryModeCode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String deliveryModeCode;

	/** <i>Generated property</i> for <code>OrderRequestData.deliveryStatus</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private DeliveryStatus deliveryStatus;

	/** <i>Generated property</i> for <code>OrderRequestData.net</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private boolean net;

	/** <i>Generated property</i> for <code>OrderRequestData.calculated</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private boolean calculated;

	/** <i>Generated property</i> for <code>OrderRequestData.totalPrice</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private double totalPrice;

	/** <i>Generated property</i> for <code>OrderRequestData.totalTax</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private double totalTax;

	/** <i>Generated property</i> for <code>OrderRequestData.subtotal</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private double subtotal;

	/** <i>Generated property</i> for <code>OrderRequestData.deliveryCost</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private double deliveryCost;

	/** <i>Generated property</i> for <code>OrderRequestData.expirationTime</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Date expirationTime;

	/** <i>Generated property</i> for <code>OrderRequestData.entries</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private List<OrderEntryRequestData> entries;

	/** <i>Generated property</i> for <code>OrderRequestData.paymentTransactions</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private List<PaymentTransactionData> paymentTransactions;

	/** <i>Generated property</i> for <code>OrderRequestData.allPromotionResults</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Set<PromotionResultData> allPromotionResults;
	
	public OrderRequestData()
	{
		// default constructor
	}
	
		
	
	public void setExternalOrderCode(final String externalOrderCode)
	{
		this.externalOrderCode = externalOrderCode;
	}

		
	
	public String getExternalOrderCode() 
	{
		return externalOrderCode;
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
	
		
	
	public void setGuid(final String guid)
	{
		this.guid = guid;
	}

		
	
	public String getGuid() 
	{
		return guid;
	}
	
		
	
	public void setUser(final CustomerData user)
	{
		this.user = user;
	}

		
	
	public CustomerData getUser() 
	{
		return user;
	}
	
		
	
	public void setSiteUid(final String siteUid)
	{
		this.siteUid = siteUid;
	}

		
	
	public String getSiteUid() 
	{
		return siteUid;
	}
	
		
	
	public void setStoreUid(final String storeUid)
	{
		this.storeUid = storeUid;
	}

		
	
	public String getStoreUid() 
	{
		return storeUid;
	}
	
		
	
	public void setCurrencyIsocode(final String currencyIsocode)
	{
		this.currencyIsocode = currencyIsocode;
	}

		
	
	public String getCurrencyIsocode() 
	{
		return currencyIsocode;
	}
	
		
	
	public void setLanguageIsocode(final String languageIsocode)
	{
		this.languageIsocode = languageIsocode;
	}

		
	
	public String getLanguageIsocode() 
	{
		return languageIsocode;
	}
	
		
	
	public void setDeliveryAddress(final AddressData deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

		
	
	public AddressData getDeliveryAddress() 
	{
		return deliveryAddress;
	}
	
		
	
	public void setPaymentAddress(final AddressData paymentAddress)
	{
		this.paymentAddress = paymentAddress;
	}

		
	
	public AddressData getPaymentAddress() 
	{
		return paymentAddress;
	}
	
		
	
	public void setDeliveryModeCode(final String deliveryModeCode)
	{
		this.deliveryModeCode = deliveryModeCode;
	}

		
	
	public String getDeliveryModeCode() 
	{
		return deliveryModeCode;
	}
	
		
	
	public void setDeliveryStatus(final DeliveryStatus deliveryStatus)
	{
		this.deliveryStatus = deliveryStatus;
	}

		
	
	public DeliveryStatus getDeliveryStatus() 
	{
		return deliveryStatus;
	}
	
		
	
	public void setNet(final boolean net)
	{
		this.net = net;
	}

		
	
	public boolean isNet() 
	{
		return net;
	}
	
		
	
	public void setCalculated(final boolean calculated)
	{
		this.calculated = calculated;
	}

		
	
	public boolean isCalculated() 
	{
		return calculated;
	}
	
		
	
	public void setTotalPrice(final double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

		
	
	public double getTotalPrice() 
	{
		return totalPrice;
	}
	
		
	
	public void setTotalTax(final double totalTax)
	{
		this.totalTax = totalTax;
	}

		
	
	public double getTotalTax() 
	{
		return totalTax;
	}
	
		
	
	public void setSubtotal(final double subtotal)
	{
		this.subtotal = subtotal;
	}

		
	
	public double getSubtotal() 
	{
		return subtotal;
	}
	
		
	
	public void setDeliveryCost(final double deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}

		
	
	public double getDeliveryCost() 
	{
		return deliveryCost;
	}
	
		
	
	public void setExpirationTime(final Date expirationTime)
	{
		this.expirationTime = expirationTime;
	}

		
	
	public Date getExpirationTime() 
	{
		return expirationTime;
	}
	
		
	
	public void setEntries(final List<OrderEntryRequestData> entries)
	{
		this.entries = entries;
	}

		
	
	public List<OrderEntryRequestData> getEntries() 
	{
		return entries;
	}
	
		
	
	public void setPaymentTransactions(final List<PaymentTransactionData> paymentTransactions)
	{
		this.paymentTransactions = paymentTransactions;
	}

		
	
	public List<PaymentTransactionData> getPaymentTransactions() 
	{
		return paymentTransactions;
	}
	
		
	
	public void setAllPromotionResults(final Set<PromotionResultData> allPromotionResults)
	{
		this.allPromotionResults = allPromotionResults;
	}

		
	
	public Set<PromotionResultData> getAllPromotionResults() 
	{
		return allPromotionResults;
	}
	


}
