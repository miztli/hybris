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
package de.hybris.platform.kymaintegrationservices.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.hybris.platform.kymaintegrationservices.dto.KymaApiData;
import de.hybris.platform.kymaintegrationservices.dto.KymaCertificateCreation;

public  class KymaSecurityData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>KymaSecurityData.csrUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("csrUrl") 	
	private String csrUrl;

	/** <i>Generated property</i> for <code>KymaSecurityData.api</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("api") 	
	private KymaApiData api;

	/** <i>Generated property</i> for <code>KymaSecurityData.certificate</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("certificate") 	
	private KymaCertificateCreation certificate;
	
	public KymaSecurityData()
	{
		// default constructor
	}
	
		
	@JsonProperty("csrUrl") 
	public void setCsrUrl(final String csrUrl)
	{
		this.csrUrl = csrUrl;
	}

		
	@JsonProperty("csrUrl") 
	public String getCsrUrl() 
	{
		return csrUrl;
	}
	
		
	@JsonProperty("api") 
	public void setApi(final KymaApiData api)
	{
		this.api = api;
	}

		
	@JsonProperty("api") 
	public KymaApiData getApi() 
	{
		return api;
	}
	
		
	@JsonProperty("certificate") 
	public void setCertificate(final KymaCertificateCreation certificate)
	{
		this.certificate = certificate;
	}

		
	@JsonProperty("certificate") 
	public KymaCertificateCreation getCertificate() 
	{
		return certificate;
	}
	


}
