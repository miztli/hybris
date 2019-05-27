/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:21 PM
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
package de.hybris.platform.personalizationcmsweb.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * List of CxCmsComponents
 */
@ApiModel(value="cxCmsComponentsList", description="List of CxCmsComponents")
public  class CxCmsComponentsListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** List of components<br/><br/><i>Generated property</i> for <code>CxCmsComponentsListWsDTO.components</code> property defined at extension <code>personalizationcmsweb</code>. */
	@ApiModelProperty(name="components", value="List of components") 	
	private List<String> components;
	
	public CxCmsComponentsListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setComponents(final List<String> components)
	{
		this.components = components;
	}

		
	
	public List<String> getComponents() 
	{
		return components;
	}
	


}
