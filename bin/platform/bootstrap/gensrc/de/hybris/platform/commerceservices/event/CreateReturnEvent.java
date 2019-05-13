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
package de.hybris.platform.commerceservices.event;

import java.io.Serializable;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

import de.hybris.platform.returns.model.ReturnRequestModel;

public  class CreateReturnEvent  extends AbstractEvent {


	/** <i>Generated property</i> for <code>CreateReturnEvent.returnRequest</code> property defined at extension <code>commerceservices</code>. */
		
	private ReturnRequestModel returnRequest;
	
	public CreateReturnEvent()
	{
		super();
	}

	public CreateReturnEvent(final Serializable source)
	{
		super(source);
	}
	
	
	
	public void setReturnRequest(final ReturnRequestModel returnRequest)
	{
		this.returnRequest = returnRequest;
	}
	
	
	
	public ReturnRequestModel getReturnRequest() 
	{
		return returnRequest;
	}
	


}
