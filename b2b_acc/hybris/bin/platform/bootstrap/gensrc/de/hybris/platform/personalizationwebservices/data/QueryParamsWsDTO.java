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
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

/**
 * Generic parameters for query endpoint
 */
@ApiModel(value="queryParams", description="Generic parameters for query endpoint")
public  class QueryParamsWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** Parameters map<br/><br/><i>Generated property</i> for <code>QueryParamsWsDTO.params</code> property defined at extension <code>personalizationwebservices</code>. */
	@ApiModelProperty(name="params", value="Parameters map", example="{'entry' : [{ 'key' : 'key1', 'value' : 'value1' },{ 'key' : 'key2', 'value' : 'value2' }]}") 	
	private Map<String,String> params;
	
	public QueryParamsWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setParams(final Map<String,String> params)
	{
		this.params = params;
	}

		
	
	public Map<String,String> getParams() 
	{
		return params;
	}
	


}
