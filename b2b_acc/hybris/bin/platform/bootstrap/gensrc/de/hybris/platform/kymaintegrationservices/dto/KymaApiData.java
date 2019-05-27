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
import com.fasterxml.jackson.annotation.JsonProperty;

public  class KymaApiData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>KymaApiData.metadataUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("metadataUrl") 	
	private String metadataUrl;

	/** <i>Generated property</i> for <code>KymaApiData.eventsUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("eventsUrl") 	
	private String eventsUrl;

	/** <i>Generated property</i> for <code>KymaApiData.certificatesUrl</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("certificatesUrl") 	
	private String certificatesUrl;
	
	public KymaApiData()
	{
		// default constructor
	}
	
		
	@JsonProperty("metadataUrl") 
	public void setMetadataUrl(final String metadataUrl)
	{
		this.metadataUrl = metadataUrl;
	}

		
	@JsonProperty("metadataUrl") 
	public String getMetadataUrl() 
	{
		return metadataUrl;
	}
	
		
	@JsonProperty("eventsUrl") 
	public void setEventsUrl(final String eventsUrl)
	{
		this.eventsUrl = eventsUrl;
	}

		
	@JsonProperty("eventsUrl") 
	public String getEventsUrl() 
	{
		return eventsUrl;
	}
	
		
	@JsonProperty("certificatesUrl") 
	public void setCertificatesUrl(final String certificatesUrl)
	{
		this.certificatesUrl = certificatesUrl;
	}

		
	@JsonProperty("certificatesUrl") 
	public String getCertificatesUrl() 
	{
		return certificatesUrl;
	}
	


}
