/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;

public  class SearchContextData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchContextData.language</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String language;

	/** <i>Generated property</i> for <code>SearchContextData.currency</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String currency;
	
	public SearchContextData()
	{
		// default constructor
	}
	
		
	
	public void setLanguage(final String language)
	{
		this.language = language;
	}

		
	
	public String getLanguage() 
	{
		return language;
	}
	
		
	
	public void setCurrency(final String currency)
	{
		this.currency = currency;
	}

		
	
	public String getCurrency() 
	{
		return currency;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final SearchContextData other = (SearchContextData) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getLanguage(), other.getLanguage()) 
			.append(getCurrency(), other.getCurrency()) 
			.isEquals();
		} 
		catch (ClassCastException c)
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return new org.apache.commons.lang.builder.HashCodeBuilder()
		.append(getLanguage()) 
		.append(getCurrency()) 
		.toHashCode();
	}

}
