/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:22 PM
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

import com.hybris.mobile.lib.commerce.data.storesession.Currency;
import com.hybris.mobile.lib.commerce.data.storesession.Language;
import com.hybris.mobile.lib.commerce.data.user.Address;
import com.hybris.mobile.lib.commerce.data.user.Principal;
import java.util.List;

public class User extends Principal 
{

	/** <i>Generated property</i> for <code>User.firstName</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String firstName;
	/** <i>Generated property</i> for <code>User.lastName</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String lastName;
	/** <i>Generated property</i> for <code>User.displayUid</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String displayUid;
	/** <i>Generated property</i> for <code>User.roles</code> property defined at extension <code>b2boccaddon</code>. */
	private List<String> roles;
	/** <i>Generated property</i> for <code>User.currency</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Currency currency;
	/** <i>Generated property</i> for <code>User.language</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Language language;
	/** <i>Generated property</i> for <code>User.title</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String title;
	/** <i>Generated property</i> for <code>User.titleCode</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String titleCode;
	/** <i>Generated property</i> for <code>User.defaultAddress</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Address defaultAddress;
		
	public User()
	{
		// default constructor
	}
	
		
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}
	
		
	public String getFirstName() 
	{
		return firstName;
	}
		
		
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}
	
		
	public String getLastName() 
	{
		return lastName;
	}
		
		
	public void setDisplayUid(final String displayUid)
	{
		this.displayUid = displayUid;
	}
	
		
	public String getDisplayUid() 
	{
		return displayUid;
	}
		
		
	public void setRoles(final List<String> roles)
	{
		this.roles = roles;
	}
	
		
	public List<String> getRoles() 
	{
		return roles;
	}
		
		
	public void setCurrency(final Currency currency)
	{
		this.currency = currency;
	}
	
		
	public Currency getCurrency() 
	{
		return currency;
	}
		
		
	public void setLanguage(final Language language)
	{
		this.language = language;
	}
	
		
	public Language getLanguage() 
	{
		return language;
	}
		
		
	public void setTitle(final String title)
	{
		this.title = title;
	}
	
		
	public String getTitle() 
	{
		return title;
	}
		
		
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}
	
		
	public String getTitleCode() 
	{
		return titleCode;
	}
		
		
	public void setDefaultAddress(final Address defaultAddress)
	{
		this.defaultAddress = defaultAddress;
	}
	
		
	public Address getDefaultAddress() 
	{
		return defaultAddress;
	}
		
	
}