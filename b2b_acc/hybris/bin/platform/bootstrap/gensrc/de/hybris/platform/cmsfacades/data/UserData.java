/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import java.util.Set;

public  class UserData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserData.uid</code> property defined at extension <code>cmsfacades</code>. */
		
	private String uid;

	/** <i>Generated property</i> for <code>UserData.readableLanguages</code> property defined at extension <code>cmsfacades</code>. */
		
	private Set<String> readableLanguages;

	/** <i>Generated property</i> for <code>UserData.writeableLanguages</code> property defined at extension <code>cmsfacades</code>. */
		
	private Set<String> writeableLanguages;
	
	public UserData()
	{
		// default constructor
	}
	
		
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

		
	
	public String getUid() 
	{
		return uid;
	}
	
		
	
	public void setReadableLanguages(final Set<String> readableLanguages)
	{
		this.readableLanguages = readableLanguages;
	}

		
	
	public Set<String> getReadableLanguages() 
	{
		return readableLanguages;
	}
	
		
	
	public void setWriteableLanguages(final Set<String> writeableLanguages)
	{
		this.writeableLanguages = writeableLanguages;
	}

		
	
	public Set<String> getWriteableLanguages() 
	{
		return writeableLanguages;
	}
	


}
