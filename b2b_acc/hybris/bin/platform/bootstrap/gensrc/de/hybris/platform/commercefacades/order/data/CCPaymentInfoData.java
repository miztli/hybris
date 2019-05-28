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
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.CardTypeData;
import de.hybris.platform.commercefacades.user.data.AddressData;

public  class CCPaymentInfoData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.id</code> property defined at extension <code>commercefacades</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.accountHolderName</code> property defined at extension <code>commercefacades</code>. */
		
	private String accountHolderName;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.cardType</code> property defined at extension <code>commercefacades</code>. */
		
	private String cardType;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.cardTypeData</code> property defined at extension <code>commercefacades</code>. */
		
	private CardTypeData cardTypeData;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.cardNumber</code> property defined at extension <code>commercefacades</code>. */
		
	private String cardNumber;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.startMonth</code> property defined at extension <code>commercefacades</code>. */
		
	private String startMonth;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.startYear</code> property defined at extension <code>commercefacades</code>. */
		
	private String startYear;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.expiryMonth</code> property defined at extension <code>commercefacades</code>. */
		
	private String expiryMonth;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.expiryYear</code> property defined at extension <code>commercefacades</code>. */
		
	private String expiryYear;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.issueNumber</code> property defined at extension <code>commercefacades</code>. */
		
	private String issueNumber;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.subscriptionId</code> property defined at extension <code>commercefacades</code>. */
		
	private String subscriptionId;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.saved</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean saved;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.defaultPaymentInfo</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean defaultPaymentInfo;

	/** <i>Generated property</i> for <code>CCPaymentInfoData.billingAddress</code> property defined at extension <code>commercefacades</code>. */
		
	private AddressData billingAddress;
	
	public CCPaymentInfoData()
	{
		// default constructor
	}
	
		
	
	public void setId(final String id)
	{
		this.id = id;
	}

		
	
	public String getId() 
	{
		return id;
	}
	
		
	
	public void setAccountHolderName(final String accountHolderName)
	{
		this.accountHolderName = accountHolderName;
	}

		
	
	public String getAccountHolderName() 
	{
		return accountHolderName;
	}
	
		
	
	public void setCardType(final String cardType)
	{
		this.cardType = cardType;
	}

		
	
	public String getCardType() 
	{
		return cardType;
	}
	
		
	
	public void setCardTypeData(final CardTypeData cardTypeData)
	{
		this.cardTypeData = cardTypeData;
	}

		
	
	public CardTypeData getCardTypeData() 
	{
		return cardTypeData;
	}
	
		
	
	public void setCardNumber(final String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

		
	
	public String getCardNumber() 
	{
		return cardNumber;
	}
	
		
	
	public void setStartMonth(final String startMonth)
	{
		this.startMonth = startMonth;
	}

		
	
	public String getStartMonth() 
	{
		return startMonth;
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
	
		
	
	public void setIssueNumber(final String issueNumber)
	{
		this.issueNumber = issueNumber;
	}

		
	
	public String getIssueNumber() 
	{
		return issueNumber;
	}
	
		
	
	public void setSubscriptionId(final String subscriptionId)
	{
		this.subscriptionId = subscriptionId;
	}

		
	
	public String getSubscriptionId() 
	{
		return subscriptionId;
	}
	
		
	
	public void setSaved(final boolean saved)
	{
		this.saved = saved;
	}

		
	
	public boolean isSaved() 
	{
		return saved;
	}
	
		
	
	public void setDefaultPaymentInfo(final boolean defaultPaymentInfo)
	{
		this.defaultPaymentInfo = defaultPaymentInfo;
	}

		
	
	public boolean isDefaultPaymentInfo() 
	{
		return defaultPaymentInfo;
	}
	
		
	
	public void setBillingAddress(final AddressData billingAddress)
	{
		this.billingAddress = billingAddress;
	}

		
	
	public AddressData getBillingAddress() 
	{
		return billingAddress;
	}
	


}
