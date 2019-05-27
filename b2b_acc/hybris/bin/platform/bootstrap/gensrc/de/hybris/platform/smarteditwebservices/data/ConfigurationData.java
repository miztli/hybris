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
package de.hybris.platform.smarteditwebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Configuration data
 */
@ApiModel(value="configurationData", description="Configuration data")
public  class ConfigurationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** The configuration data key<br/><br/><i>Generated property</i> for <code>ConfigurationData.key</code> property defined at extension <code>smarteditwebservices</code>. */
	@ApiModelProperty(name="key", value="The configuration data key", required=true, example="defaultToolingLanguage") 	
	private String key;

	/** The configuration data value<br/><br/><i>Generated property</i> for <code>ConfigurationData.value</code> property defined at extension <code>smarteditwebservices</code>. */
	@ApiModelProperty(name="value", value="The configuration data value", required=true, example="en") 	
	private String value;
	
	public ConfigurationData()
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
	
		
	
	public void setValue(final String value)
	{
		this.value = value;
	}

		
	
	public String getValue() 
	{
		return value;
	}
	


}
