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
package de.hybris.platform.commercewebservicescommons.dto.consent;

import java.io.Serializable;
import java.util.Date;

public  class ConsentWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsentWsDTO.code</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>ConsentWsDTO.consentGivenDate</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Date consentGivenDate;

	/** <i>Generated property</i> for <code>ConsentWsDTO.consentWithdrawnDate</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Date consentWithdrawnDate;
	
	public ConsentWsDTO()
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
	
		
	
	public void setConsentGivenDate(final Date consentGivenDate)
	{
		this.consentGivenDate = consentGivenDate;
	}

		
	
	public Date getConsentGivenDate() 
	{
		return consentGivenDate;
	}
	
		
	
	public void setConsentWithdrawnDate(final Date consentWithdrawnDate)
	{
		this.consentWithdrawnDate = consentWithdrawnDate;
	}

		
	
	public Date getConsentWithdrawnDate() 
	{
		return consentWithdrawnDate;
	}
	


}
