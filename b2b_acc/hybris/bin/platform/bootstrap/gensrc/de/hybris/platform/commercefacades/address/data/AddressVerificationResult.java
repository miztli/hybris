/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:21 PM
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
package de.hybris.platform.commercefacades.address.data;

import java.io.Serializable;
import  de.hybris.platform.commercefacades.address.data.AddressVerificationErrorField;
import de.hybris.platform.commercefacades.user.data.AddressData;
import java.util.List;
import java.util.Map;

public  class AddressVerificationResult<DECISION>  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddressVerificationResult<DECISION>.decision</code> property defined at extension <code>commercefacades</code>. */
		
	private DECISION decision;

	/** <i>Generated property</i> for <code>AddressVerificationResult<DECISION>.suggestedAddresses</code> property defined at extension <code>commercefacades</code>. */
		
	private List<AddressData> suggestedAddresses;

	/** <i>Generated property</i> for <code>AddressVerificationResult<DECISION>.errors</code> property defined at extension <code>commercefacades</code>. */
		
	private Map<String,AddressVerificationErrorField> errors;
	
	public AddressVerificationResult()
	{
		// default constructor
	}
	
		
	
	public void setDecision(final DECISION decision)
	{
		this.decision = decision;
	}

		
	
	public DECISION getDecision() 
	{
		return decision;
	}
	
		
	
	public void setSuggestedAddresses(final List<AddressData> suggestedAddresses)
	{
		this.suggestedAddresses = suggestedAddresses;
	}

		
	
	public List<AddressData> getSuggestedAddresses() 
	{
		return suggestedAddresses;
	}
	
		
	
	public void setErrors(final Map<String,AddressVerificationErrorField> errors)
	{
		this.errors = errors;
	}

		
	
	public Map<String,AddressVerificationErrorField> getErrors() 
	{
		return errors;
	}
	


}
