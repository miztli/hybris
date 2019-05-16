/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 16, 2019 4:37:41 PM
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

public  class InvalidateModelConverterRegistryEvent  extends AbstractEvent {


	/** <i>Generated property</i> for <code>InvalidateModelConverterRegistryEvent.composedTypeCode</code> property defined at extension <code>core</code>. */
		
	private String composedTypeCode;

	/** <i>Generated property</i> for <code>InvalidateModelConverterRegistryEvent.composedClass</code> property defined at extension <code>core</code>. */
		
	private Class composedClass;

	/** <i>Generated property</i> for <code>InvalidateModelConverterRegistryEvent.refresh</code> property defined at extension <code>core</code>. */
		
	private boolean refresh;
	
	public InvalidateModelConverterRegistryEvent()
	{
		super();
	}

	public InvalidateModelConverterRegistryEvent(final Serializable source)
	{
		super(source);
	}
	
	
	
	public void setComposedTypeCode(final String composedTypeCode)
	{
		this.composedTypeCode = composedTypeCode;
	}
	
	
	
	public String getComposedTypeCode() 
	{
		return composedTypeCode;
	}
	
	
	
	public void setComposedClass(final Class composedClass)
	{
		this.composedClass = composedClass;
	}
	
	
	
	public Class getComposedClass() 
	{
		return composedClass;
	}
	
	
	
	public void setRefresh(final boolean refresh)
	{
		this.refresh = refresh;
	}
	
	
	
	public boolean isRefresh() 
	{
		return refresh;
	}
	


}
