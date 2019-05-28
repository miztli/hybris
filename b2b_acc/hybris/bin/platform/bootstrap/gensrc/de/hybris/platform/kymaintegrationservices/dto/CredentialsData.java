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
package de.hybris.platform.kymaintegrationservices.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.hybris.platform.kymaintegrationservices.dto.OAuthData;

public  class CredentialsData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CredentialsData.oauth</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("oauth") 	
	private OAuthData oauth;
	
	public CredentialsData()
	{
		// default constructor
	}
	
		
	@JsonProperty("oauth") 
	public void setOauth(final OAuthData oauth)
	{
		this.oauth = oauth;
	}

		
	@JsonProperty("oauth") 
	public OAuthData getOauth() 
	{
		return oauth;
	}
	


}
