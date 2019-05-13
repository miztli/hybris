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
package de.hybris.platform.acceleratorfacades.payment.data;

import de.hybris.platform.acceleratorservices.payment.data.PaymentSubscriptionResult;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;

public  class PaymentSubscriptionResultData extends PaymentSubscriptionResult 
{

 

	/** <i>Generated property</i> for <code>PaymentSubscriptionResultData.storedCard</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private CCPaymentInfoData storedCard;
	
	public PaymentSubscriptionResultData()
	{
		// default constructor
	}
	
		
	
	public void setStoredCard(final CCPaymentInfoData storedCard)
	{
		this.storedCard = storedCard;
	}

		
	
	public CCPaymentInfoData getStoredCard() 
	{
		return storedCard;
	}
	


}
