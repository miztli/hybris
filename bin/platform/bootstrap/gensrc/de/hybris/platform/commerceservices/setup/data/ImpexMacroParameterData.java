/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
package de.hybris.platform.commerceservices.setup.data;

import java.io.Serializable;
import de.hybris.platform.commerceservices.enums.UiExperienceLevel;
import java.util.List;
import java.util.Map;

public  class ImpexMacroParameterData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.contentCatalog</code> property defined at extension <code>commerceservices</code>. */
		
	private String contentCatalog;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.productCatalog</code> property defined at extension <code>commerceservices</code>. */
		
	private String productCatalog;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.siteUid</code> property defined at extension <code>commerceservices</code>. */
		
	private String siteUid;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.storeUid</code> property defined at extension <code>commerceservices</code>. */
		
	private String storeUid;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.configExtensionName</code> property defined at extension <code>commerceservices</code>. */
		
	private String configExtensionName;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.addonExtensionName</code> property defined at extension <code>commerceservices</code>. */
		
	private String addonExtensionName;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.solrIndexedType</code> property defined at extension <code>commerceservices</code>. */
		
	private String solrIndexedType;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.channel</code> property defined at extension <code>commerceservices</code>. */
		
	private String channel;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.additionalParameterMap</code> property defined at extension <code>commerceservices</code>. */
		
	private Map<String,String> additionalParameterMap;

	/** <i>Generated property</i> for <code>ImpexMacroParameterData.supportedUiExperienceLevels</code> property defined at extension <code>commerceservices</code>. */
		
	private List<UiExperienceLevel> supportedUiExperienceLevels;
	
	public ImpexMacroParameterData()
	{
		// default constructor
	}
	
		
	
	public void setContentCatalog(final String contentCatalog)
	{
		this.contentCatalog = contentCatalog;
	}

		
	
	public String getContentCatalog() 
	{
		return contentCatalog;
	}
	
		
	
	public void setProductCatalog(final String productCatalog)
	{
		this.productCatalog = productCatalog;
	}

		
	
	public String getProductCatalog() 
	{
		return productCatalog;
	}
	
		
	
	public void setSiteUid(final String siteUid)
	{
		this.siteUid = siteUid;
	}

		
	
	public String getSiteUid() 
	{
		return siteUid;
	}
	
		
	
	public void setStoreUid(final String storeUid)
	{
		this.storeUid = storeUid;
	}

		
	
	public String getStoreUid() 
	{
		return storeUid;
	}
	
		
	
	public void setConfigExtensionName(final String configExtensionName)
	{
		this.configExtensionName = configExtensionName;
	}

		
	
	public String getConfigExtensionName() 
	{
		return configExtensionName;
	}
	
		
	
	public void setAddonExtensionName(final String addonExtensionName)
	{
		this.addonExtensionName = addonExtensionName;
	}

		
	
	public String getAddonExtensionName() 
	{
		return addonExtensionName;
	}
	
		
	
	public void setSolrIndexedType(final String solrIndexedType)
	{
		this.solrIndexedType = solrIndexedType;
	}

		
	
	public String getSolrIndexedType() 
	{
		return solrIndexedType;
	}
	
		
	
	public void setChannel(final String channel)
	{
		this.channel = channel;
	}

		
	
	public String getChannel() 
	{
		return channel;
	}
	
		
	
	public void setAdditionalParameterMap(final Map<String,String> additionalParameterMap)
	{
		this.additionalParameterMap = additionalParameterMap;
	}

		
	
	public Map<String,String> getAdditionalParameterMap() 
	{
		return additionalParameterMap;
	}
	
		
	
	public void setSupportedUiExperienceLevels(final List<UiExperienceLevel> supportedUiExperienceLevels)
	{
		this.supportedUiExperienceLevels = supportedUiExperienceLevels;
	}

		
	
	public List<UiExperienceLevel> getSupportedUiExperienceLevels() 
	{
		return supportedUiExperienceLevels;
	}
	


}
