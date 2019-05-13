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
package de.hybris.platform.kymaintegrationservices.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public  class OAuthData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OAuthData.url</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("url") 	
	private String url;

	/** <i>Generated property</i> for <code>OAuthData.clientId</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("clientId") 	
	private String clientId;

	/** <i>Generated property</i> for <code>OAuthData.clientSecret</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("clientSecret") 	
	private String clientSecret;
	
	public OAuthData()
	{
		// default constructor
	}
	
		
	@JsonProperty("url") 
	public void setUrl(final String url)
	{
		this.url = url;
	}

		
	@JsonProperty("url") 
	public String getUrl() 
	{
		return url;
	}
	
		
	@JsonProperty("clientId") 
	public void setClientId(final String clientId)
	{
		this.clientId = clientId;
	}

		
	@JsonProperty("clientId") 
	public String getClientId() 
	{
		return clientId;
	}
	
		
	@JsonProperty("clientSecret") 
	public void setClientSecret(final String clientSecret)
	{
		this.clientSecret = clientSecret;
	}

		
	@JsonProperty("clientSecret") 
	public String getClientSecret() 
	{
		return clientSecret;
	}
	


}
