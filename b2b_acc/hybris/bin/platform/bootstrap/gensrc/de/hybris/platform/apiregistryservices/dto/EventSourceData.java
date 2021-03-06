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
package de.hybris.platform.apiregistryservices.dto;

import java.io.Serializable;
import de.hybris.platform.apiregistryservices.model.events.EventConfigurationModel;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public  class EventSourceData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>EventSourceData.event</code> property defined at extension <code>apiregistryservices</code>. */
		
	private AbstractEvent event;

	/** <i>Generated property</i> for <code>EventSourceData.eventConfig</code> property defined at extension <code>apiregistryservices</code>. */
		
	private EventConfigurationModel eventConfig;
	
	public EventSourceData()
	{
		// default constructor
	}
	
		
	
	public void setEvent(final AbstractEvent event)
	{
		this.event = event;
	}

		
	
	public AbstractEvent getEvent() 
	{
		return event;
	}
	
		
	
	public void setEventConfig(final EventConfigurationModel eventConfig)
	{
		this.eventConfig = eventConfig;
	}

		
	
	public EventConfigurationModel getEventConfig() 
	{
		return eventConfig;
	}
	


}
