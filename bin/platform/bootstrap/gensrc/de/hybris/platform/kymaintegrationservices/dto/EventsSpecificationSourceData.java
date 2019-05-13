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
import de.hybris.platform.apiregistryservices.model.ExposedDestinationModel;
import de.hybris.platform.apiregistryservices.model.events.EventConfigurationModel;
import java.util.List;

public  class EventsSpecificationSourceData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>EventsSpecificationSourceData.exposedDestination</code> property defined at extension <code>kymaintegrationservices</code>. */
		
	private ExposedDestinationModel exposedDestination;

	/** <i>Generated property</i> for <code>EventsSpecificationSourceData.events</code> property defined at extension <code>kymaintegrationservices</code>. */
		
	private List<EventConfigurationModel> events;
	
	public EventsSpecificationSourceData()
	{
		// default constructor
	}
	
		
	
	public void setExposedDestination(final ExposedDestinationModel exposedDestination)
	{
		this.exposedDestination = exposedDestination;
	}

		
	
	public ExposedDestinationModel getExposedDestination() 
	{
		return exposedDestination;
	}
	
		
	
	public void setEvents(final List<EventConfigurationModel> events)
	{
		this.events = events;
	}

		
	
	public List<EventConfigurationModel> getEvents() 
	{
		return events;
	}
	


}
