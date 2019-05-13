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
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import java.util.Map;

public  class MediaContainerData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaContainerData.formatMediaCodeMap</code> property defined at extension <code>cmsfacades</code>. */
		
	private Map<String, String> formatMediaCodeMap;
	
	public MediaContainerData()
	{
		// default constructor
	}
	
		
	
	public void setFormatMediaCodeMap(final Map<String, String> formatMediaCodeMap)
	{
		this.formatMediaCodeMap = formatMediaCodeMap;
	}

		
	
	public Map<String, String> getFormatMediaCodeMap() 
	{
		return formatMediaCodeMap;
	}
	


}
