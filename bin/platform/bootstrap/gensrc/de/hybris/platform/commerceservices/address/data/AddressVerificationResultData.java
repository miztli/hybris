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
package de.hybris.platform.commerceservices.address.data;

import java.io.Serializable;
import de.hybris.platform.core.model.user.AddressModel;
import java.util.List;

/**
 * POJO representation of an address verification result.
 */
public  class AddressVerificationResultData<DECISION, FIELD_ERROR>  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddressVerificationResultData<DECISION, FIELD_ERROR>.decision</code> property defined at extension <code>commerceservices</code>. */
		
	private DECISION decision;

	/** <i>Generated property</i> for <code>AddressVerificationResultData<DECISION, FIELD_ERROR>.fieldErrors</code> property defined at extension <code>commerceservices</code>. */
		
	private List<FIELD_ERROR> fieldErrors;

	/** <i>Generated property</i> for <code>AddressVerificationResultData<DECISION, FIELD_ERROR>.suggestedAddresses</code> property defined at extension <code>commerceservices</code>. */
		
	private List<AddressModel> suggestedAddresses;
	
	public AddressVerificationResultData()
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
	
		
	
	public void setFieldErrors(final List<FIELD_ERROR> fieldErrors)
	{
		this.fieldErrors = fieldErrors;
	}

		
	
	public List<FIELD_ERROR> getFieldErrors() 
	{
		return fieldErrors;
	}
	
		
	
	public void setSuggestedAddresses(final List<AddressModel> suggestedAddresses)
	{
		this.suggestedAddresses = suggestedAddresses;
	}

		
	
	public List<AddressModel> getSuggestedAddresses() 
	{
		return suggestedAddresses;
	}
	


}
