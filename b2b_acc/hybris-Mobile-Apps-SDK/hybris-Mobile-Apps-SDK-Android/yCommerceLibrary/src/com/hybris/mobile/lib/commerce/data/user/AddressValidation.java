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
package com.hybris.mobile.lib.commerce.data.user;

import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.user.Address;
import java.util.List;

public class AddressValidation  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>AddressValidation.decision</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String decision;
	/** <i>Generated property</i> for <code>AddressValidation.suggestedAddresses</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Address> suggestedAddresses;
	/** <i>Generated property</i> for <code>AddressValidation.errors</code> property defined at extension <code>commercewebservicescommons</code>. */
	private ErrorList errors;
		
	public AddressValidation()
	{
		// default constructor
	}
	
		
	public void setDecision(final String decision)
	{
		this.decision = decision;
	}
	
		
	public String getDecision() 
	{
		return decision;
	}
		
		
	public void setSuggestedAddresses(final List<Address> suggestedAddresses)
	{
		this.suggestedAddresses = suggestedAddresses;
	}
	
		
	public List<Address> getSuggestedAddresses() 
	{
		return suggestedAddresses;
	}
		
		
	public void setErrors(final ErrorList errors)
	{
		this.errors = errors;
	}
	
		
	public ErrorList getErrors() 
	{
		return errors;
	}
		
	
}