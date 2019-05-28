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
package de.hybris.platform.assistedservicestorefront.user;

import java.io.Serializable;
import java.util.List;

public  class AutoSuggestionCustomerData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.email</code> property defined at extension <code>assistedservicestorefront</code>. */
		
	private String email;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.value</code> property defined at extension <code>assistedservicestorefront</code>. */
		
	private String value;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.date</code> property defined at extension <code>assistedservicestorefront</code>. */
		
	private String date;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.card</code> property defined at extension <code>assistedservicestorefront</code>. */
		
	private String card;

	/** <i>Generated property</i> for <code>AutoSuggestionCustomerData.carts</code> property defined at extension <code>assistedservicestorefront</code>. */
		
	private List<String> carts;
	
	public AutoSuggestionCustomerData()
	{
		// default constructor
	}
	
		
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

		
	
	public String getEmail() 
	{
		return email;
	}
	
		
	
	public void setValue(final String value)
	{
		this.value = value;
	}

		
	
	public String getValue() 
	{
		return value;
	}
	
		
	
	public void setDate(final String date)
	{
		this.date = date;
	}

		
	
	public String getDate() 
	{
		return date;
	}
	
		
	
	public void setCard(final String card)
	{
		this.card = card;
	}

		
	
	public String getCard() 
	{
		return card;
	}
	
		
	
	public void setCarts(final List<String> carts)
	{
		this.carts = carts;
	}

		
	
	public List<String> getCarts() 
	{
		return carts;
	}
	


}
