/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 16, 2019 3:34:17 PM
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
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public  class AfterSessionAttributeChangeEvent  extends AbstractEvent {


	/** <i>Generated property</i> for <code>AfterSessionAttributeChangeEvent.attributeName</code> property defined at extension <code>core</code>. */
		
	private String attributeName;

	/** <i>Generated property</i> for <code>AfterSessionAttributeChangeEvent.value</code> property defined at extension <code>core</code>. */
		
	private Object value;
	
	public AfterSessionAttributeChangeEvent()
	{
		super();
	}

	public AfterSessionAttributeChangeEvent(final Serializable source)
	{
		super(source);
	}
	
	
	
	public void setAttributeName(final String attributeName)
	{
		this.attributeName = attributeName;
	}
	
	
	
	public String getAttributeName() 
	{
		return attributeName;
	}
	
	
	
	public void setValue(final Object value)
	{
		this.value = value;
	}
	
	
	
	public Object getValue() 
	{
		return value;
	}
	


}
