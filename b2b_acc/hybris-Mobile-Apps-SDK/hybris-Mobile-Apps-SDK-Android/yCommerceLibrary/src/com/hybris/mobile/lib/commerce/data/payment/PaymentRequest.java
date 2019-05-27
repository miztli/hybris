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
package com.hybris.mobile.lib.commerce.data.payment;

import java.util.Map;

public class PaymentRequest  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>PaymentRequest.postUrl</code> property defined at extension <code>acceleratorwebservicesaddon</code>. */
	private String postUrl;
	/** <i>Generated property</i> for <code>PaymentRequest.parameters</code> property defined at extension <code>acceleratorwebservicesaddon</code>. */
	private Map<String, String> parameters;
		
	public PaymentRequest()
	{
		// default constructor
	}
	
		
	public void setPostUrl(final String postUrl)
	{
		this.postUrl = postUrl;
	}
	
		
	public String getPostUrl() 
	{
		return postUrl;
	}
		
		
	public void setParameters(final Map<String, String> parameters)
	{
		this.parameters = parameters;
	}
	
		
	public Map<String, String> getParameters() 
	{
		return parameters;
	}
		
	
}