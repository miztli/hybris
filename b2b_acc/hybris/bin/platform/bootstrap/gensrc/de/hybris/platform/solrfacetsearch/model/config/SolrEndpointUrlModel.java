/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 28, 2019 3:18:54 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.solrfacetsearch.model.config;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.model.config.SolrServerConfigModel;

/**
 * Generated model class for type SolrEndpointUrl first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrEndpointUrlModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrEndpointUrl";
	
	/**<i>Generated relation code constant for relation <code>SolrServerConfig2SolrEndpointUrl</code> defining source attribute <code>solrServerConfig</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRSERVERCONFIG2SOLRENDPOINTURL = "SolrServerConfig2SolrEndpointUrl";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrEndpointUrl.url</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String URL = "url";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrEndpointUrl.master</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String MASTER = "master";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrEndpointUrl.solrServerConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRSERVERCONFIG = "solrServerConfig";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrEndpointUrlModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrEndpointUrlModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _url initial attribute declared by type <code>SolrEndpointUrl</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrEndpointUrlModel(final String _url)
	{
		super();
		setUrl(_url);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _url initial attribute declared by type <code>SolrEndpointUrl</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrEndpointUrlModel(final ItemModel _owner, final String _url)
	{
		super();
		setOwner(_owner);
		setUrl(_url);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrEndpointUrl.solrServerConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrServerConfig
	 */
	@Accessor(qualifier = "solrServerConfig", type = Accessor.Type.GETTER)
	public SolrServerConfigModel getSolrServerConfig()
	{
		return getPersistenceContext().getPropertyValue(SOLRSERVERCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrEndpointUrl.url</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the url
	 */
	@Accessor(qualifier = "url", type = Accessor.Type.GETTER)
	public String getUrl()
	{
		return getPersistenceContext().getPropertyValue(URL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrEndpointUrl.master</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the master
	 */
	@Accessor(qualifier = "master", type = Accessor.Type.GETTER)
	public boolean isMaster()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(MASTER));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrEndpointUrl.master</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the master
	 */
	@Accessor(qualifier = "master", type = Accessor.Type.SETTER)
	public void setMaster(final boolean value)
	{
		getPersistenceContext().setPropertyValue(MASTER, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrEndpointUrl.solrServerConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrServerConfig
	 */
	@Accessor(qualifier = "solrServerConfig", type = Accessor.Type.SETTER)
	public void setSolrServerConfig(final SolrServerConfigModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRSERVERCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrEndpointUrl.url</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the url
	 */
	@Accessor(qualifier = "url", type = Accessor.Type.SETTER)
	public void setUrl(final String value)
	{
		getPersistenceContext().setPropertyValue(URL, value);
	}
	
}
