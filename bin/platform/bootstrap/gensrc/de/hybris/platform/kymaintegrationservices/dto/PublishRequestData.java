/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public  class PublishRequestData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PublishRequestData.eventType</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("event-type") 	
	private String eventType;

	/** <i>Generated property</i> for <code>PublishRequestData.eventTypeVersion</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("event-type-version") 	
	private String eventTypeVersion;

	/** <i>Generated property</i> for <code>PublishRequestData.eventId</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("event-id") 	
	private String eventId;

	/** <i>Generated property</i> for <code>PublishRequestData.eventTime</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("event-time") 	
	private String eventTime;

	/** <i>Generated property</i> for <code>PublishRequestData.data</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("data") 	
	private Map<String,Object> data;
	
	public PublishRequestData()
	{
		// default constructor
	}
	
		
	@JsonProperty("event-type") 
	public void setEventType(final String eventType)
	{
		this.eventType = eventType;
	}

		
	@JsonProperty("event-type") 
	public String getEventType() 
	{
		return eventType;
	}
	
		
	@JsonProperty("event-type-version") 
	public void setEventTypeVersion(final String eventTypeVersion)
	{
		this.eventTypeVersion = eventTypeVersion;
	}

		
	@JsonProperty("event-type-version") 
	public String getEventTypeVersion() 
	{
		return eventTypeVersion;
	}
	
		
	@JsonProperty("event-id") 
	public void setEventId(final String eventId)
	{
		this.eventId = eventId;
	}

		
	@JsonProperty("event-id") 
	public String getEventId() 
	{
		return eventId;
	}
	
		
	@JsonProperty("event-time") 
	public void setEventTime(final String eventTime)
	{
		this.eventTime = eventTime;
	}

		
	@JsonProperty("event-time") 
	public String getEventTime() 
	{
		return eventTime;
	}
	
		
	@JsonProperty("data") 
	public void setData(final Map<String,Object> data)
	{
		this.data = data;
	}

		
	@JsonProperty("data") 
	public Map<String,Object> getData() 
	{
		return data;
	}
	


}
