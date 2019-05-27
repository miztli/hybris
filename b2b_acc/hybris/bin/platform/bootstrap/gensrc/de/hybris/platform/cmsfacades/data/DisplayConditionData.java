/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.OptionData;
import java.util.List;

public  class DisplayConditionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DisplayConditionData.typecode</code> property defined at extension <code>cmsfacades</code>. */
		
	private String typecode;

	/** <i>Generated property</i> for <code>DisplayConditionData.options</code> property defined at extension <code>cmsfacades</code>. */
		
	private List<OptionData> options;
	
	public DisplayConditionData()
	{
		// default constructor
	}
	
		
	
	public void setTypecode(final String typecode)
	{
		this.typecode = typecode;
	}

		
	
	public String getTypecode() 
	{
		return typecode;
	}
	
		
	
	public void setOptions(final List<OptionData> options)
	{
		this.options = options;
	}

		
	
	public List<OptionData> getOptions() 
	{
		return options;
	}
	


}
