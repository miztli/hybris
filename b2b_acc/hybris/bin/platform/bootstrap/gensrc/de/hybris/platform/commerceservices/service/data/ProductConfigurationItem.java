/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
package de.hybris.platform.commerceservices.service.data;

import java.io.Serializable;
import de.hybris.platform.catalog.enums.ConfiguratorType;
import de.hybris.platform.catalog.enums.ProductInfoStatus;
import java.io.Serializable;

public  class ProductConfigurationItem  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** Configuration item id<br/><br/><i>Generated property</i> for <code>ProductConfigurationItem.key</code> property defined at extension <code>commerceservices</code>. */
		
	private String key;

	/** Configuration item value<br/><br/><i>Generated property</i> for <code>ProductConfigurationItem.value</code> property defined at extension <code>commerceservices</code>. */
		
	private Serializable value;

	/** Configuration item status<br/><br/><i>Generated property</i> for <code>ProductConfigurationItem.status</code> property defined at extension <code>commerceservices</code>. */
		
	private ProductInfoStatus status;

	/** Configurator type<br/><br/><i>Generated property</i> for <code>ProductConfigurationItem.configuratorType</code> property defined at extension <code>commerceservices</code>. */
		
	private ConfiguratorType configuratorType;
	
	public ProductConfigurationItem()
	{
		// default constructor
	}
	
		
	
	public void setKey(final String key)
	{
		this.key = key;
	}

		
	
	public String getKey() 
	{
		return key;
	}
	
		
	
	public void setValue(final Serializable value)
	{
		this.value = value;
	}

		
	
	public Serializable getValue() 
	{
		return value;
	}
	
		
	
	public void setStatus(final ProductInfoStatus status)
	{
		this.status = status;
	}

		
	
	public ProductInfoStatus getStatus() 
	{
		return status;
	}
	
		
	
	public void setConfiguratorType(final ConfiguratorType configuratorType)
	{
		this.configuratorType = configuratorType;
	}

		
	
	public ConfiguratorType getConfiguratorType() 
	{
		return configuratorType;
	}
	


}
