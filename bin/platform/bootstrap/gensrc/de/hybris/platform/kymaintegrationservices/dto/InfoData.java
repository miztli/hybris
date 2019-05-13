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

public  class InfoData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>InfoData.title</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("title") 	
	private String title;

	/** <i>Generated property</i> for <code>InfoData.version</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("version") 	
	private String version;

	/** <i>Generated property</i> for <code>InfoData.description</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("description") 	
	private String description;
	
	public InfoData()
	{
		// default constructor
	}
	
		
	@JsonProperty("title") 
	public void setTitle(final String title)
	{
		this.title = title;
	}

		
	@JsonProperty("title") 
	public String getTitle() 
	{
		return title;
	}
	
		
	@JsonProperty("version") 
	public void setVersion(final String version)
	{
		this.version = version;
	}

		
	@JsonProperty("version") 
	public String getVersion() 
	{
		return version;
	}
	
		
	@JsonProperty("description") 
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	@JsonProperty("description") 
	public String getDescription() 
	{
		return description;
	}
	


}
