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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import de.hybris.platform.kymaintegrationservices.dto.CredentialsData;

@JsonInclude(JsonInclude.Include.NON_NULL)
public  class ApiSpecificationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ApiSpecificationData.targetUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("targetUrl") 	
	private String targetUrl;

	/** <i>Generated property</i> for <code>ApiSpecificationData.credentials</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("credentials") 	
	private CredentialsData credentials;

	/** <i>Generated property</i> for <code>ApiSpecificationData.spec</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("spec") 	
	private JsonNode spec;

	/** <i>Generated property</i> for <code>ApiSpecificationData.specificationUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("specificationUrl") 	
	private String specificationUrl;
	
	public ApiSpecificationData()
	{
		// default constructor
	}
	
		
	@JsonProperty("targetUrl") 
	public void setTargetUrl(final String targetUrl)
	{
		this.targetUrl = targetUrl;
	}

		
	@JsonProperty("targetUrl") 
	public String getTargetUrl() 
	{
		return targetUrl;
	}
	
		
	@JsonProperty("credentials") 
	public void setCredentials(final CredentialsData credentials)
	{
		this.credentials = credentials;
	}

		
	@JsonProperty("credentials") 
	public CredentialsData getCredentials() 
	{
		return credentials;
	}
	
		
	@JsonProperty("spec") 
	public void setSpec(final JsonNode spec)
	{
		this.spec = spec;
	}

		
	@JsonProperty("spec") 
	public JsonNode getSpec() 
	{
		return spec;
	}
	
		
	@JsonProperty("specificationUrl") 
	public void setSpecificationUrl(final String specificationUrl)
	{
		this.specificationUrl = specificationUrl;
	}

		
	@JsonProperty("specificationUrl") 
	public String getSpecificationUrl() 
	{
		return specificationUrl;
	}
	


}
