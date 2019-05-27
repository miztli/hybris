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
import de.hybris.platform.kymaintegrationservices.dto.PropertyData;
import java.util.List;
import java.util.Map;

public  class PropertyData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PropertyData.type</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("type") 	
	private String type;

	/** <i>Generated property</i> for <code>PropertyData.required</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("required") 	
	private List<String> required;

	/** <i>Generated property</i> for <code>PropertyData.example</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("example") 	
	private String example;

	/** <i>Generated property</i> for <code>PropertyData.properties</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("properties") 	
	private Map<String,PropertyData> properties;

	/** <i>Generated property</i> for <code>PropertyData.description</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("description") 	
	private String description;

	/** <i>Generated property</i> for <code>PropertyData.title</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("title") 	
	private String title;
	
	public PropertyData()
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
	
		
	@JsonProperty("example") 
	public void setExample(final String example)
	{
		this.example = example;
	}

		
	@JsonProperty("example") 
	public String getExample() 
	{
		return example;
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
	


}
