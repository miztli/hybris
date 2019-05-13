/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.ordermanagementfacades.payment.data.PaymentTransactionEntryData;
import java.math.BigDecimal;
import java.util.List;

public  class PaymentTransactionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PaymentTransactionData.code</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>PaymentTransactionData.currencyIsocode</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String currencyIsocode;

	/** <i>Generated property</i> for <code>PaymentTransactionData.entries</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private List<PaymentTransactionEntryData> entries;

	/** <i>Generated property</i> for <code>PaymentTransactionData.paymentInfo</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private CCPaymentInfoData paymentInfo;

	/** <i>Generated property</i> for <code>PaymentTransactionData.paymentProvider</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String paymentProvider;

	/** <i>Generated property</i> for <code>PaymentTransactionData.plannedAmount</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private BigDecimal plannedAmount;

	/** <i>Generated property</i> for <code>PaymentTransactionData.requestId</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String requestId;

	/** <i>Generated property</i> for <code>PaymentTransactionData.requestToken</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String requestToken;

	/** <i>Generated property</i> for <code>PaymentTransactionData.versionID</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String versionID;
	
	public PaymentTransactionData()
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
	
		
	
	public void setCurrencyIsocode(final String currencyIsocode)
	{
		this.currencyIsocode = currencyIsocode;
	}

		
	
	public String getCurrencyIsocode() 
	{
		return currencyIsocode;
	}
	
		
	
	public void setEntries(final List<PaymentTransactionEntryData> entries)
	{
		this.entries = entries;
	}

		
	
	public List<PaymentTransactionEntryData> getEntries() 
	{
		return entries;
	}
	
		
	
	public void setPaymentInfo(final CCPaymentInfoData paymentInfo)
	{
		this.paymentInfo = paymentInfo;
	}

		
	
	public CCPaymentInfoData getPaymentInfo() 
	{
		return paymentInfo;
	}
	
		
	
	public void setPaymentProvider(final String paymentProvider)
	{
		this.paymentProvider = paymentProvider;
	}

		
	
	public String getPaymentProvider() 
	{
		return paymentProvider;
	}
	
		
	
	public void setPlannedAmount(final BigDecimal plannedAmount)
	{
		this.plannedAmount = plannedAmount;
	}

		
	
	public BigDecimal getPlannedAmount() 
	{
		return plannedAmount;
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
	
		
	
	public void setVersionID(final String versionID)
	{
		this.versionID = versionID;
	}

		
	
	public String getVersionID() 
	{
		return versionID;
	}
	


}
