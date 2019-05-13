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
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.TriggerData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * List of triggers
 */
@ApiModel(value="triggerList", description="List of triggers")
public  class TriggerListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** List of customer triggers<br/><br/><i>Generated property</i> for <code>TriggerListWsDTO.triggers</code> property defined at extension <code>personalizationwebservices</code>. */
	@ApiModelProperty(name="triggers", value="List of customer triggers") 	
	private List<TriggerData> triggers;
	
	public TriggerListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setTriggers(final List<TriggerData> triggers)
	{
		this.triggers = triggers;
	}

		
	
	public List<TriggerData> getTriggers() 
	{
		return triggers;
	}
	


}
