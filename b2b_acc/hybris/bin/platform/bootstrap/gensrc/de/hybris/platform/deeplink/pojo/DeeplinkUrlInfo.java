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
package de.hybris.platform.deeplink.pojo;

import java.io.Serializable;
import de.hybris.platform.deeplink.model.rules.DeeplinkUrlModel;

public  class DeeplinkUrlInfo  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>DeeplinkUrlInfo.contextObject</code> property defined at extension <code>basecommerce</code>. */
		
	private Object contextObject;

	/** <i>Generated property</i> for <code>DeeplinkUrlInfo.deeplinkUrl</code> property defined at extension <code>basecommerce</code>. */
		
	private DeeplinkUrlModel deeplinkUrl;
	
	public DeeplinkUrlInfo()
	{
		// default constructor
	}
	
		
	
	public void setContextObject(final Object contextObject)
	{
		this.contextObject = contextObject;
	}

		
	
	public Object getContextObject() 
	{
		return contextObject;
	}
	
		
	
	public void setDeeplinkUrl(final DeeplinkUrlModel deeplinkUrl)
	{
		this.deeplinkUrl = deeplinkUrl;
	}

		
	
	public DeeplinkUrlModel getDeeplinkUrl() 
	{
		return deeplinkUrl;
	}
	


}
