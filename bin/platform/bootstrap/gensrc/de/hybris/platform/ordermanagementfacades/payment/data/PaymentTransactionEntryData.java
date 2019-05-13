/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
package de.hybris.platform.ordermanagementfacades.payment.data;

import java.io.Serializable;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import java.math.BigDecimal;
import java.util.Date;

public  class PaymentTransactionEntryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.amount</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private BigDecimal amount;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.code</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.currencyIsocode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String currencyIsocode;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.requestId</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String requestId;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.requestToken</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String requestToken;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.subscriptionID</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String subscriptionID;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.time</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Date time;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.transactionStatus</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String transactionStatus;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.transactionStatusDetails</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String transactionStatusDetails;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.type</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private PaymentTransactionType type;

	/** <i>Generated property</i> for <code>PaymentTransactionEntryData.versionID</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String versionID;
	
	public PaymentTransactionEntryData()
	{
		// default constructor
	}
	
		
	
	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}

		
	
	public BigDecimal getAmount() 
	{
		return amount;
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setCurrencyIsocode(final String currencyIsocode)
	{
		this.currencyIsocode = currencyIsocode;
	}

		
	
	public String getCurrencyIsocode() 
	{
		return currencyIsocode;
	}
	
		
	
	public void setRequestId(final String requestId)
	{
		this.requestId = requestId;
	}

		
	
	public String getRequestId() 
	{
		return requestId;
	}
	
		
	
	public void setRequestToken(final String requestToken)
	{
		this.requestToken = requestToken;
	}

		
	
	public String getRequestToken() 
	{
		return requestToken;
	}
	
		
	
	public void setSubscriptionID(final String subscriptionID)
	{
		this.subscriptionID = subscriptionID;
	}

		
	
	public String getSubscriptionID() 
	{
		return subscriptionID;
	}
	
		
	
	public void setTime(final Date time)
	{
		this.time = time;
	}

		
	
	public Date getTime() 
	{
		return time;
	}
	
		
	
	public void setTransactionStatus(final String transactionStatus)
	{
		this.transactionStatus = transactionStatus;
	}

		
	
	public String getTransactionStatus() 
	{
		return transactionStatus;
	}
	
		
	
	public void setTransactionStatusDetails(final String transactionStatusDetails)
	{
		this.transactionStatusDetails = transactionStatusDetails;
	}

		
	
	public String getTransactionStatusDetails() 
	{
		return transactionStatusDetails;
	}
	
		
	
	public void setType(final PaymentTransactionType type)
	{
		this.type = type;
	}

		
	
	public PaymentTransactionType getType() 
	{
		return type;
	}
	
		
	
	public void setVersionID(final String versionID)
	{
		this.versionID = versionID;
	}

		
	
	public String getVersionID() 
	{
		return versionID;
	}
	


}
