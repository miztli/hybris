/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 15, 2019 4:26:33 PM
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
package de.hybris.platform.oauth2.data;

import java.io.Serializable;

public  class AuthenticatedUserData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AuthenticatedUserData.displayName</code> property defined at extension <code>oauth2</code>. */
		
	private String displayName;
	
	public AuthenticatedUserData()
	{
		// default constructor
	}
	
		
	
	public void setDisplayName(final String displayName)
	{
		this.displayName = displayName;
	}

		
	
	public String getDisplayName() 
	{
		return displayName;
	}
	


}
