/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 16, 2019 11:26:15 AM
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
package de.hybris.platform.servicelayer.event.events;

import java.io.Serializable;

import de.hybris.platform.servicelayer.event.events.AbstractPersistenceEvent;

public  class AfterItemCreationEvent extends AbstractPersistenceEvent {


	/** <i>Generated property</i> for <code>AfterItemCreationEvent.typeCode</code> property defined at extension <code>core</code>. */
		
	private String typeCode;
	
	public AfterItemCreationEvent()
	{
		super();
	}

	public AfterItemCreationEvent(final Serializable source)
	{
		super(source);
	}
	
	
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}
	
	
	
	public String getTypeCode() 
	{
		return typeCode;
	}
	


}
