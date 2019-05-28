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
import de.hybris.platform.kymaintegrationservices.dto.PropertyData;
import java.util.List;
import java.util.Map;

public  class PayloadData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PayloadData.type</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("type") 	
	private String type;

	/** <i>Generated property</i> for <code>PayloadData.required</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("required") 	
	private List<String> required;

	/** <i>Generated property</i> for <code>PayloadData.properties</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("properties") 	
	private Map<String,PropertyData> properties;
	
	public PayloadData()
	{
		// default constructor
	}
	
		
	@JsonProperty("type") 
	public void setType(final String type)
	{
		this.type = type;
	}

		
	@JsonProperty("type") 
	public String getType() 
	{
		return type;
	}
	
		
	@JsonProperty("required") 
	public void setRequired(final List<String> required)
	{
		this.required = required;
	}

		
	@JsonProperty("required") 
	public List<String> getRequired() 
	{
		return required;
	}
	
		
	@JsonProperty("properties") 
	public void setProperties(final Map<String,PropertyData> properties)
	{
		this.properties = properties;
	}

		
	@JsonProperty("properties") 
	public Map<String,PropertyData> getProperties() 
	{
		return properties;
	}
	


}
