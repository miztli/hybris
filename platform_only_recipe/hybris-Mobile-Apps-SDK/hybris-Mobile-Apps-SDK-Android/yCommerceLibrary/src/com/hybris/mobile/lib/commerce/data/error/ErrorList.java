/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:21 PM
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

import java.util.ArrayList;
import java.util.List;

/**
 * List of errors
 */
public class ErrorList  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>ErrorList.errors</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Error> errors;

	// Wrapper for single errors used for oauth/token
	private String error;
	private String error_description;

	public ErrorList()
	{
		// default constructor
	}
	
		
	public void setErrors(final List<Error> errors)
	{
		this.errors = errors;
	}
	
		
	public List<Error> getErrors() 
	{
		// No error on the list, we get them from the wrapper
		if (errors == null || errors.isEmpty()) {
			List<Error> errorWrapper = new ArrayList<>();
			Error errorTmp = new Error();
			errorTmp.setMessage(error_description);
			errorTmp.setReason(error);
			errorWrapper.add(errorTmp);
			return errorWrapper;
		} else {
			return errors;
		}
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

	public String getError_description() {
		return error_description;
	}
}