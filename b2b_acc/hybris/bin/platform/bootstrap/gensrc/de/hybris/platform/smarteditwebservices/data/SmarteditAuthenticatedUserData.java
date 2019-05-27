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
package de.hybris.platform.smarteditwebservices.data;

import de.hybris.platform.oauth2.data.AuthenticatedUserData;

/**
 * Smartedit Authenticated User Data
 */
public  class SmarteditAuthenticatedUserData extends AuthenticatedUserData 
{

 

	/** The uid of the user<br/><br/><i>Generated property</i> for <code>SmarteditAuthenticatedUserData.uid</code> property defined at extension <code>smarteditwebservices</code>. */
		
	private String uid;
	
	public SmarteditAuthenticatedUserData()
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
	


}
