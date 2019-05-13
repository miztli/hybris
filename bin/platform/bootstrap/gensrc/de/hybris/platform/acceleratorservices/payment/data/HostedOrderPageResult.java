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
package de.hybris.platform.acceleratorservices.payment.data;

import java.io.Serializable;
import java.util.Map;

public  class HostedOrderPageResult  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>HostedOrderPageResult.requestId</code> property defined at extension <code>acceleratorservices</code>. */
		
	private String requestId;

	/** <i>Generated property</i> for <code>HostedOrderPageResult.reasonCode</code> property defined at extension <code>acceleratorservices</code>. */
		
	private Integer reasonCode;

	/** <i>Generated property</i> for <code>HostedOrderPageResult.errors</code> property defined at extension <code>acceleratorservices</code>. */
		
	private Map<Integer, String> errors;
	
	public HostedOrderPageResult()
	{
		// default constructor
	}
	
		
	
	public void setRequestId(final String requestId)
	{
		this.requestId = requestId;
	}

		
	
	public String getRequestId() 
	{
		return requestId;
	}
	
		
	
	public void setReasonCode(final Integer reasonCode)
	{
		this.reasonCode = reasonCode;
	}

		
	
	public Integer getReasonCode() 
	{
		return reasonCode;
	}
	
		
	
	public void setErrors(final Map<Integer, String> errors)
	{
		this.errors = errors;
	}

		
	
	public Map<Integer, String> getErrors() 
	{
		return errors;
	}
	


}
