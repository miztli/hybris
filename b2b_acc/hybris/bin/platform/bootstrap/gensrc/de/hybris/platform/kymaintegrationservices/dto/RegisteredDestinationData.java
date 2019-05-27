/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:21 PM
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public  class RegisteredDestinationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RegisteredDestinationData.identifier</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("identifier") 	
	private String identifier;

	/** <i>Generated property</i> for <code>RegisteredDestinationData.targetId</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("id") 	
	private String targetId;
	
	public RegisteredDestinationData()
	{
		// default constructor
	}
	
		
	@JsonProperty("identifier") 
	public void setIdentifier(final String identifier)
	{
		this.identifier = identifier;
	}

		
	@JsonProperty("identifier") 
	public String getIdentifier() 
	{
		return identifier;
	}
	
		
	@JsonProperty("id") 
	public void setTargetId(final String targetId)
	{
		this.targetId = targetId;
	}

		
	@JsonProperty("id") 
	public String getTargetId() 
	{
		return targetId;
	}
	


}
