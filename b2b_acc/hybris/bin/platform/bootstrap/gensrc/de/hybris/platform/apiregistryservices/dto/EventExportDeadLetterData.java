/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
package de.hybris.platform.apiregistryservices.dto;

import java.io.Serializable;
import de.hybris.platform.apiregistryservices.model.DestinationTargetModel;
import java.util.Date;

public  class EventExportDeadLetterData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>EventExportDeadLetterData.eventType</code> property defined at extension <code>apiregistryservices</code>. */
		
	private String eventType;

	/** <i>Generated property</i> for <code>EventExportDeadLetterData.id</code> property defined at extension <code>apiregistryservices</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>EventExportDeadLetterData.timestamp</code> property defined at extension <code>apiregistryservices</code>. */
		
	private Date timestamp;

	/** <i>Generated property</i> for <code>EventExportDeadLetterData.payload</code> property defined at extension <code>apiregistryservices</code>. */
		
	private String payload;

	/** <i>Generated property</i> for <code>EventExportDeadLetterData.error</code> property defined at extension <code>apiregistryservices</code>. */
		
	private String error;

	/** <i>Generated property</i> for <code>EventExportDeadLetterData.destinationTarget</code> property defined at extension <code>apiregistryservices</code>. */
		
	private DestinationTargetModel destinationTarget;
	
	public EventExportDeadLetterData()
	{
		// default constructor
	}
	
		
	
	public void setEventType(final String eventType)
	{
		this.eventType = eventType;
	}

		
	
	public String getEventType() 
	{
		return eventType;
	}
	
		
	
	public void setId(final String id)
	{
		this.id = id;
	}

		
	
	public String getId() 
	{
		return id;
	}
	
		
	
	public void setTimestamp(final Date timestamp)
	{
		this.timestamp = timestamp;
	}

		
	
	public Date getTimestamp() 
	{
		return timestamp;
	}
	
		
	
	public void setPayload(final String payload)
	{
		this.payload = payload;
	}

		
	
	public String getPayload() 
	{
		return payload;
	}
	
		
	
	public void setError(final String error)
	{
		this.error = error;
	}

		
	
	public String getError() 
	{
		return error;
	}
	
		
	
	public void setDestinationTarget(final DestinationTargetModel destinationTarget)
	{
		this.destinationTarget = destinationTarget;
	}

		
	
	public DestinationTargetModel getDestinationTarget() 
	{
		return destinationTarget;
	}
	


}
