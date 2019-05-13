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
package de.hybris.platform.apiregistryservices.event;

import java.io.Serializable;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

import de.hybris.platform.processengine.model.BusinessProcessModel;

public  class DynamicProcessEvent  extends AbstractEvent {


	/** <i>Generated property</i> for <code>DynamicProcessEvent.businessEvent</code> property defined at extension <code>apiregistryservices</code>. */
		
	private String businessEvent;

	/** <i>Generated property</i> for <code>DynamicProcessEvent.businessProcess</code> property defined at extension <code>apiregistryservices</code>. */
		
	private BusinessProcessModel businessProcess;
	
	public DynamicProcessEvent()
	{
		super();
	}

	public DynamicProcessEvent(final Serializable source)
	{
		super(source);
	}
	
	
	
	public void setBusinessEvent(final String businessEvent)
	{
		this.businessEvent = businessEvent;
	}
	
	
	
	public String getBusinessEvent() 
	{
		return businessEvent;
	}
	
	
	
	public void setBusinessProcess(final BusinessProcessModel businessProcess)
	{
		this.businessProcess = businessProcess;
	}
	
	
	
	public BusinessProcessModel getBusinessProcess() 
	{
		return businessProcess;
	}
	


}
