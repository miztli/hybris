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
package de.hybris.platform.cmsfacades.validator.data;

import java.io.Serializable;

public  class ValidationError  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ValidationError.field</code> property defined at extension <code>cmsfacades</code>. */
		
	private String field;

	/** <i>Generated property</i> for <code>ValidationError.rejectedValue</code> property defined at extension <code>cmsfacades</code>. */
		
	private Object rejectedValue;

	/** <i>Generated property</i> for <code>ValidationError.language</code> property defined at extension <code>cmsfacades</code>. */
		
	private String language;

	/** <i>Generated property</i> for <code>ValidationError.errorCode</code> property defined at extension <code>cmsfacades</code>. */
		
	private String errorCode;

	/** <i>Generated property</i> for <code>ValidationError.errorArgs</code> property defined at extension <code>cmsfacades</code>. */
		
	private Object[] errorArgs;

	/** <i>Generated property</i> for <code>ValidationError.exceptionMessage</code> property defined at extension <code>cmsfacades</code>. */
		
	private String exceptionMessage;

	/** <i>Generated property</i> for <code>ValidationError.defaultMessage</code> property defined at extension <code>cmsfacades</code>. */
		
	private String defaultMessage;

	/** <i>Generated property</i> for <code>ValidationError.position</code> property defined at extension <code>cmsfacades</code>. */
		
	private Integer position;
	
	public ValidationError()
	{
		// default constructor
	}
	
		
	
	public void setField(final String field)
	{
		this.field = field;
	}

		
	
	public String getField() 
	{
		return field;
	}
	
		
	
	public void setRejectedValue(final Object rejectedValue)
	{
		this.rejectedValue = rejectedValue;
	}

		
	
	public Object getRejectedValue() 
	{
		return rejectedValue;
	}
	
		
	
	public void setLanguage(final String language)
	{
		this.language = language;
	}

		
	
	public String getLanguage() 
	{
		return language;
	}
	
		
	
	public void setErrorCode(final String errorCode)
	{
		this.errorCode = errorCode;
	}

		
	
	public String getErrorCode() 
	{
		return errorCode;
	}
	
		
	
	public void setErrorArgs(final Object[] errorArgs)
	{
		this.errorArgs = errorArgs;
	}

		
	
	public Object[] getErrorArgs() 
	{
		return errorArgs;
	}
	
		
	
	public void setExceptionMessage(final String exceptionMessage)
	{
		this.exceptionMessage = exceptionMessage;
	}

		
	
	public String getExceptionMessage() 
	{
		return exceptionMessage;
	}
	
		
	
	public void setDefaultMessage(final String defaultMessage)
	{
		this.defaultMessage = defaultMessage;
	}

		
	
	public String getDefaultMessage() 
	{
		return defaultMessage;
	}
	
		
	
	public void setPosition(final Integer position)
	{
		this.position = position;
	}

		
	
	public Integer getPosition() 
	{
		return position;
	}
	


}
