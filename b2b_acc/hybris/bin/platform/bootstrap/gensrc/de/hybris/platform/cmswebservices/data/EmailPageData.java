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
package de.hybris.platform.cmswebservices.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

/**
 * @deprecated Deprecated since 6.6
 */
@ApiModel(value="EmailPageData")
@Deprecated
public  class EmailPageData extends AbstractPageData 
{

 

	/** <i>Generated property</i> for <code>EmailPageData.fromEmail</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="fromEmail") 	
	private Map<String,String> fromEmail;

	/** <i>Generated property</i> for <code>EmailPageData.fromName</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="fromName") 	
	private Map<String,String> fromName;
	
	public EmailPageData()
	{
		// default constructor
	}
	
		
	
	public void setFromEmail(final Map<String,String> fromEmail)
	{
		this.fromEmail = fromEmail;
	}

		
	
	public Map<String,String> getFromEmail() 
	{
		return fromEmail;
	}
	
		
	
	public void setFromName(final Map<String,String> fromName)
	{
		this.fromName = fromName;
	}

		
	
	public Map<String,String> getFromName() 
	{
		return fromName;
	}
	


}
