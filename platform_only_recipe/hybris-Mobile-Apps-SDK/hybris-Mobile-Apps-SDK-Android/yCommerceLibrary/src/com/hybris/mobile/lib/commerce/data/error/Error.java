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
package com.hybris.mobile.lib.commerce.data.error;

/**
 * Error message
 */
public class Error  implements java.io.Serializable 
{

	/** Additional classification specific for each error type e.g. 'noStock'.<br/><br/><i>Generated property</i> for <code>Error.reason</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String reason;
	/** Identifier of the related object e.g. '1'.<br/><br/><i>Generated property</i> for <code>Error.subject</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String subject;
	/** Type of the error e.g. 'LowStockError'.<br/><br/><i>Generated property</i> for <code>Error.type</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String type;
	/** Descriptive, human readable error message.<br/><br/><i>Generated property</i> for <code>Error.message</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String message;
	/** Type of the object related to the error e.g. 'entry'.<br/><br/><i>Generated property</i> for <code>Error.subjectType</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String subjectType;
		
	public Error()
	{
		// default constructor
	}
	
		
	public void setReason(final String reason)
	{
		this.reason = reason;
	}
	
		
	public String getReason() 
	{
		return reason;
	}
		
		
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}
	
		
	public String getSubject() 
	{
		return subject;
	}
		
		
	public void setType(final String type)
	{
		this.type = type;
	}
	
		
	public String getType() 
	{
		return type;
	}
		
		
	public void setMessage(final String message)
	{
		this.message = message;
	}
	
		
	public String getMessage() 
	{
		return message;
	}
		
		
	public void setSubjectType(final String subjectType)
	{
		this.subjectType = subjectType;
	}
	
		
	public String getSubjectType() 
	{
		return subjectType;
	}
		
	
}