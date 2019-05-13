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
import com.fasterxml.jackson.annotation.JsonProperty;

public  class EventsSpecificationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>EventsSpecificationData.spec</code> property defined at extension <code>kymaintegrationservices</code>. */
	@JsonProperty("spec") 	
	private SpecData spec;
	
	public EventsSpecificationData()
	{
		// default constructor
	}
	
		
	@JsonProperty("spec") 
	public void setSpec(final SpecData spec)
	{
		this.spec = spec;
	}

		
	@JsonProperty("spec") 
	public SpecData getSpec() 
	{
		return spec;
	}
	


}
