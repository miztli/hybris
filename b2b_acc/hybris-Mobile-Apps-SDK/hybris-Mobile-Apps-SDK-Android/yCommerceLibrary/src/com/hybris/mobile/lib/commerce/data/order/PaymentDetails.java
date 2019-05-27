/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:23 PM
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

import com.hybris.mobile.lib.commerce.data.order.CardType;
import com.hybris.mobile.lib.commerce.data.user.Address;

public class PaymentDetails  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>PaymentDetails.startMonth</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String startMonth;
	/** <i>Generated property</i> for <code>PaymentDetails.saved</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean saved;
	/** <i>Generated property</i> for <code>PaymentDetails.issueNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String issueNumber;
	/** <i>Generated property</i> for <code>PaymentDetails.cardType</code> property defined at extension <code>commercewebservicescommons</code>. */
	private CardType cardType;
	/** <i>Generated property</i> for <code>PaymentDetails.startYear</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String startYear;
	/** <i>Generated property</i> for <code>PaymentDetails.expiryMonth</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String expiryMonth;
	/** <i>Generated property</i> for <code>PaymentDetails.expiryYear</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String expiryYear;
	/** <i>Generated property</i> for <code>PaymentDetails.accountHolderName</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String accountHolderName;
	/** <i>Generated property</i> for <code>PaymentDetails.defaultPayment</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean defaultPayment;
	/** <i>Generated property</i> for <code>PaymentDetails.id</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String id;
	/** <i>Generated property</i> for <code>PaymentDetails.billingAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Address billingAddress;
	/** <i>Generated property</i> for <code>PaymentDetails.subscriptionId</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String subscriptionId;
	/** <i>Generated property</i> for <code>PaymentDetails.cardNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String cardNumber;
		
	public PaymentDetails()
	{
		// default constructor
	}
	
		
	public void setStartMonth(final String startMonth)
	{
		this.startMonth = startMonth;
	}
	
		
	public String getStartMonth() 
	{
		return startMonth;
	}
		
		
	public void setSaved(final Boolean saved)
	{
		this.saved = saved;
	}
	
		
	public Boolean getSaved() 
	{
		return saved;
	}
		
		
	public void setIssueNumber(final String issueNumber)
	{
		this.issueNumber = issueNumber;
	}
	
		
	public String getIssueNumber() 
	{
		return issueNumber;
	}
		
		
	public void setCardType(final CardType cardType)
	{
		this.cardType = cardType;
	}
	
		
	public CardType getCardType() 
	{
		return cardType;
	}
		
		
	public void setStartYear(final String startYear)
	{
		this.startYear = startYear;
	}
	
		
	public String getStartYear() 
	{
		return startYear;
	}
		
		
	public void setExpiryMonth(final String expiryMonth)
	{
		this.expiryMonth = expiryMonth;
	}
	
		
	public String getExpiryMonth() 
	{
		return expiryMonth;
	}
		
		
	public void setExpiryYear(final String expiryYear)
	{
		this.expiryYear = expiryYear;
	}
	
		
	public String getExpiryYear() 
	{
		return expiryYear;
	}
		
		
	public void setAccountHolderName(final String accountHolderName)
	{
		this.accountHolderName = accountHolderName;
	}
	
		
	public String getAccountHolderName() 
	{
		return accountHolderName;
	}
		
		
	public void setDefaultPayment(final Boolean defaultPayment)
	{
		this.defaultPayment = defaultPayment;
	}
	
		
	public Boolean getDefaultPayment() 
	{
		return defaultPayment;
	}
		
		
	public void setId(final String id)
	{
		this.id = id;
	}
	
		
	public String getId() 
	{
		return id;
	}
		
		
	public void setBillingAddress(final Address billingAddress)
	{
		this.billingAddress = billingAddress;
	}
	
		
	public Address getBillingAddress() 
	{
		return billingAddress;
	}
		
		
	public void setSubscriptionId(final String subscriptionId)
	{
		this.subscriptionId = subscriptionId;
	}
	
		
	public String getSubscriptionId() 
	{
		return subscriptionId;
	}
		
		
	public void setCardNumber(final String cardNumber)
	{
		this.cardNumber = cardNumber;
	}
	
		
	public String getCardNumber() 
	{
		return cardNumber;
	}
		
	
}