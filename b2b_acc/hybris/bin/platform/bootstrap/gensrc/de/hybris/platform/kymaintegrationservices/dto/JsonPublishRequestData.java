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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public  class JsonPublishRequestData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>JsonPublishRequestData.eventType</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("event-type") 	
	private String eventType;

	/** <i>Generated property</i> for <code>JsonPublishRequestData.eventTypeVersion</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("event-type-version") 	
	private String eventTypeVersion;

	/** <i>Generated property</i> for <code>JsonPublishRequestData.eventId</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("event-id") 	
	private String eventId;

	/** <i>Generated property</i> for <code>JsonPublishRequestData.eventTime</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("event-time") 	
	private String eventTime;

	/** <i>Generated property</i> for <code>JsonPublishRequestData.data</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("data") 	
	private JsonNode data;
	
	public JsonPublishRequestData()
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
	public void setData(final JsonNode data)
	{
		this.data = data;
	}

		
	@JsonProperty("data") 
	public JsonNode getData() 
	{
		return data;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final JsonPublishRequestData other = (JsonPublishRequestData) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getEventType(), other.getEventType()) 
			.append(getEventTypeVersion(), other.getEventTypeVersion()) 
			.append(getEventId(), other.getEventId()) 
			.append(getEventTime(), other.getEventTime()) 
			.append(getData(), other.getData()) 
			.isEquals();
		} 
		catch (ClassCastException c)
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return new org.apache.commons.lang.builder.HashCodeBuilder()
		.append(getEventType()) 
		.append(getEventTypeVersion()) 
		.append(getEventId()) 
		.append(getEventTime()) 
		.append(getData()) 
		.toHashCode();
	}

}
