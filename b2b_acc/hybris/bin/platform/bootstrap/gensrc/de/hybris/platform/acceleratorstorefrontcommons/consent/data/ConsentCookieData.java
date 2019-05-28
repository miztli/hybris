/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
package de.hybris.platform.acceleratorstorefrontcommons.consent.data;

import java.io.Serializable;

public  class ConsentCookieData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsentCookieData.templateCode</code> property defined at extension <code>acceleratorstorefrontcommons</code>. */
		
	private String templateCode;

	/** <i>Generated property</i> for <code>ConsentCookieData.templateVersion</code> property defined at extension <code>acceleratorstorefrontcommons</code>. */
		
	private int templateVersion;

	/** <i>Generated property</i> for <code>ConsentCookieData.consentState</code> property defined at extension <code>acceleratorstorefrontcommons</code>. */
		
	private String consentState;
	
	public ConsentCookieData()
	{
		// default constructor
	}
	
		
	
	public void setTemplateCode(final String templateCode)
	{
		this.templateCode = templateCode;
	}

		
	
	public String getTemplateCode() 
	{
		return templateCode;
	}
	
		
	
	public void setTemplateVersion(final int templateVersion)
	{
		this.templateVersion = templateVersion;
	}

		
	
	public int getTemplateVersion() 
	{
		return templateVersion;
	}
	
		
	
	public void setConsentState(final String consentState)
	{
		this.consentState = consentState;
	}

		
	
	public String getConsentState() 
	{
		return consentState;
	}
	


}
