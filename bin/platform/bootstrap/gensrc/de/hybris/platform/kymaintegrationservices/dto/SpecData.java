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
import de.hybris.platform.kymaintegrationservices.dto.InfoData;
import de.hybris.platform.kymaintegrationservices.dto.TopicData;
import java.util.Map;

public  class SpecData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SpecData.asyncapi</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("asyncapi") 	
	private String asyncapi;

	/** <i>Generated property</i> for <code>SpecData.info</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("info") 	
	private InfoData info;

	/** <i>Generated property</i> for <code>SpecData.topics</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("topics") 	
	private Map<String,TopicData> topics;
	
	public SpecData()
	{
		// default constructor
	}
	
		
	@JsonProperty("asyncapi") 
	public void setAsyncapi(final String asyncapi)
	{
		this.asyncapi = asyncapi;
	}

		
	@JsonProperty("asyncapi") 
	public String getAsyncapi() 
	{
		return asyncapi;
	}
	
		
	@JsonProperty("info") 
	public void setInfo(final InfoData info)
	{
		this.info = info;
	}

		
	@JsonProperty("info") 
	public InfoData getInfo() 
	{
		return info;
	}
	
		
	@JsonProperty("topics") 
	public void setTopics(final Map<String,TopicData> topics)
	{
		this.topics = topics;
	}

		
	@JsonProperty("topics") 
	public Map<String,TopicData> getTopics() 
	{
		return topics;
	}
	


}
