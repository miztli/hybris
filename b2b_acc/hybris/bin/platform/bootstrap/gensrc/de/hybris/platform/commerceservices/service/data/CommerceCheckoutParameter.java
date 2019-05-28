/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
package de.hybris.platform.commerceservices.service.data;

import java.io.Serializable;
import de.hybris.platform.commerceservices.enums.SalesApplication;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.delivery.DeliveryModeModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.core.model.user.AddressModel;
import java.math.BigDecimal;

public  class CommerceCheckoutParameter  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** The CartModel<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.cart</code> property defined at extension <code>commerceservices</code>. */
		
	private CartModel cart;

	/** the Address<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.address</code> property defined at extension <code>commerceservices</code>. */
		
	private AddressModel address;

	/** Delivery address flag<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.isDeliveryAddress</code> property defined at extension <code>commerceservices</code>. */
		
	private boolean isDeliveryAddress;

	/** The delivery mode<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.deliveryMode</code> property defined at extension <code>commerceservices</code>. */
		
	private DeliveryModeModel deliveryMode;

	/** payment information<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.paymentInfo</code> property defined at extension <code>commerceservices</code>. */
		
	private PaymentInfoModel paymentInfo;

	/** The security code for payment authorizations<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.securityCode</code> property defined at extension <code>commerceservices</code>. */
		
	private String securityCode;

	/** the code of the payment provider<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.paymentProvider</code> property defined at extension <code>commerceservices</code>. */
		
	private String paymentProvider;

	/** The amount for authorize<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.authorizationAmount</code> property defined at extension <code>commerceservices</code>. */
		
	private BigDecimal authorizationAmount;

	/** The enum for sales application<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.salesApplication</code> property defined at extension <code>commerceservices</code>. */
		
	private SalesApplication salesApplication;

	/** Should the method hooks be executed<br/><br/><i>Generated property</i> for <code>CommerceCheckoutParameter.enableHooks</code> property defined at extension <code>commerceservices</code>. */
		
	private boolean enableHooks;
	
	public CommerceCheckoutParameter()
	{
		// default constructor
	}
	
		
	
	public void setCart(final CartModel cart)
	{
		this.cart = cart;
	}

		
	
	public CartModel getCart() 
	{
		return cart;
	}
	
		
	
	public void setAddress(final AddressModel address)
	{
		this.address = address;
	}

		
	
	public AddressModel getAddress() 
	{
		return address;
	}
	
		
	
	public void setIsDeliveryAddress(final boolean isDeliveryAddress)
	{
		this.isDeliveryAddress = isDeliveryAddress;
	}

		
	
	public boolean isIsDeliveryAddress() 
	{
		return isDeliveryAddress;
	}
	
		
	
	public void setDeliveryMode(final DeliveryModeModel deliveryMode)
	{
		this.deliveryMode = deliveryMode;
	}

		
	
	public DeliveryModeModel getDeliveryMode() 
	{
		return deliveryMode;
	}
	
		
	
	public void setPaymentInfo(final PaymentInfoModel paymentInfo)
	{
		this.paymentInfo = paymentInfo;
	}

		
	
	public PaymentInfoModel getPaymentInfo() 
	{
		return paymentInfo;
	}
	
		
	
	public void setSecurityCode(final String securityCode)
	{
		this.securityCode = securityCode;
	}

		
	
	public String getSecurityCode() 
	{
		return securityCode;
	}
	
		
	
	public void setPaymentProvider(final String paymentProvider)
	{
		this.paymentProvider = paymentProvider;
	}

		
	
	public String getPaymentProvider() 
	{
		return paymentProvider;
	}
	
		
	
	public void setAuthorizationAmount(final BigDecimal authorizationAmount)
	{
		this.authorizationAmount = authorizationAmount;
	}

		
	
	public BigDecimal getAuthorizationAmount() 
	{
		return authorizationAmount;
	}
	
		
	
	public void setSalesApplication(final SalesApplication salesApplication)
	{
		this.salesApplication = salesApplication;
	}

		
	
	public SalesApplication getSalesApplication() 
	{
		return salesApplication;
	}
	
		
	
	public void setEnableHooks(final boolean enableHooks)
	{
		this.enableHooks = enableHooks;
	}

		
	
	public boolean isEnableHooks() 
	{
		return enableHooks;
	}
	


}
