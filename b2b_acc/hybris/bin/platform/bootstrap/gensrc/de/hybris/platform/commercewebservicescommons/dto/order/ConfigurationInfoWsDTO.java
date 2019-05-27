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
package de.hybris.platform.commercewebservicescommons.dto.order;

import java.io.Serializable;

public  class ConfigurationInfoWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConfigurationInfoWsDTO.configuratorType</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String configuratorType;

	/** <i>Generated property</i> for <code>ConfigurationInfoWsDTO.status</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String status;

	/** <i>Generated property</i> for <code>ConfigurationInfoWsDTO.configurationLabel</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String configurationLabel;

	/** <i>Generated property</i> for <code>ConfigurationInfoWsDTO.configurationValue</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String configurationValue;
	
	public ConfigurationInfoWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setConfiguratorType(final String configuratorType)
	{
		this.configuratorType = configuratorType;
	}

		
	
	public String getConfiguratorType() 
	{
		return configuratorType;
	}
	
		
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

		
	
	public String getStatus() 
	{
		return status;
	}
	
		
	
	public void setConfigurationLabel(final String configurationLabel)
	{
		this.configurationLabel = configurationLabel;
	}

		
	
	public String getConfigurationLabel() 
	{
		return configurationLabel;
	}
	
		
	
	public void setConfigurationValue(final String configurationValue)
	{
		this.configurationValue = configurationValue;
	}

		
	
	public String getConfigurationValue() 
	{
		return configurationValue;
	}
	


}
