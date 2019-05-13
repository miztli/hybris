/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 10, 2019 3:20:53 PM                     ---
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
import de.hybris.platform.solrfacetsearch.enums.SolrQueryMethod;
import de.hybris.platform.solrfacetsearch.enums.SolrServerModes;
import de.hybris.platform.solrfacetsearch.model.config.SolrEndpointUrlModel;
import java.util.List;

/**
 * Generated model class for type SolrServerConfig first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrServerConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrServerConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.name</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.mode</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String MODE = "mode";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.embeddedMaster</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String EMBEDDEDMASTER = "embeddedMaster";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.aliveCheckInterval</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String ALIVECHECKINTERVAL = "aliveCheckInterval";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.connectionTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String CONNECTIONTIMEOUT = "connectionTimeout";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.socketTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOCKETTIMEOUT = "socketTimeout";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.tcpNoDelay</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String TCPNODELAY = "tcpNoDelay";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.maxTotalConnections</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String MAXTOTALCONNECTIONS = "maxTotalConnections";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.maxTotalConnectionsPerHostConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String MAXTOTALCONNECTIONSPERHOSTCONFIG = "maxTotalConnectionsPerHostConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.username</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String USERNAME = "username";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.password</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String PASSWORD = "password";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.indexingAliveCheckInterval</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXINGALIVECHECKINTERVAL = "indexingAliveCheckInterval";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.indexingConnectionTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXINGCONNECTIONTIMEOUT = "indexingConnectionTimeout";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.indexingSocketTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXINGSOCKETTIMEOUT = "indexingSocketTimeout";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.indexingTcpNoDelay</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXINGTCPNODELAY = "indexingTcpNoDelay";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.indexingMaxTotalConnections</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXINGMAXTOTALCONNECTIONS = "indexingMaxTotalConnections";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.indexingMaxTotalConnectionsPerHostConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXINGMAXTOTALCONNECTIONSPERHOSTCONFIG = "indexingMaxTotalConnectionsPerHostConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.indexingUsername</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXINGUSERNAME = "indexingUsername";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.indexingPassword</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXINGPASSWORD = "indexingPassword";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.readTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String READTIMEOUT = "readTimeout";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.useMasterNodeExclusivelyForIndexing</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String USEMASTERNODEEXCLUSIVELYFORINDEXING = "useMasterNodeExclusivelyForIndexing";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.numShards</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NUMSHARDS = "numShards";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.replicationFactor</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String REPLICATIONFACTOR = "replicationFactor";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.solrQueryMethod</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRQUERYMETHOD = "solrQueryMethod";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.version</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String VERSION = "version";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrServerConfig.solrEndpointUrls</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRENDPOINTURLS = "solrEndpointUrls";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrServerConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrServerConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _mode initial attribute declared by type <code>SolrServerConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _name initial attribute declared by type <code>SolrServerConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _useMasterNodeExclusivelyForIndexing initial attribute declared by type <code>SolrServerConfig</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrServerConfigModel(final SolrServerModes _mode, final String _name, final boolean _useMasterNodeExclusivelyForIndexing)
	{
		super();
		setMode(_mode);
		setName(_name);
		setUseMasterNodeExclusivelyForIndexing(_useMasterNodeExclusivelyForIndexing);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _mode initial attribute declared by type <code>SolrServerConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _name initial attribute declared by type <code>SolrServerConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _useMasterNodeExclusivelyForIndexing initial attribute declared by type <code>SolrServerConfig</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrServerConfigModel(final SolrServerModes _mode, final String _name, final ItemModel _owner, final boolean _useMasterNodeExclusivelyForIndexing)
	{
		super();
		setMode(_mode);
		setName(_name);
		setOwner(_owner);
		setUseMasterNodeExclusivelyForIndexing(_useMasterNodeExclusivelyForIndexing);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.aliveCheckInterval</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the aliveCheckInterval - Time interval in milliseconds which is used to ping the dead servers to find if it is alive.
	 */
	@Accessor(qualifier = "aliveCheckInterval", type = Accessor.Type.GETTER)
	public Integer getAliveCheckInterval()
	{
		return getPersistenceContext().getPropertyValue(ALIVECHECKINTERVAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.connectionTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the connectionTimeout - Sets the timeout in milliseconds until a connection is established.
	 */
	@Accessor(qualifier = "connectionTimeout", type = Accessor.Type.GETTER)
	public Integer getConnectionTimeout()
	{
		return getPersistenceContext().getPropertyValue(CONNECTIONTIMEOUT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.indexingAliveCheckInterval</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexingAliveCheckInterval - Time interval in milliseconds which is used to ping the dead servers to find if it is alive.
	 */
	@Accessor(qualifier = "indexingAliveCheckInterval", type = Accessor.Type.GETTER)
	public Integer getIndexingAliveCheckInterval()
	{
		return getPersistenceContext().getPropertyValue(INDEXINGALIVECHECKINTERVAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.indexingConnectionTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexingConnectionTimeout - Sets the timeout in milliseconds until a connection is established.
	 */
	@Accessor(qualifier = "indexingConnectionTimeout", type = Accessor.Type.GETTER)
	public Integer getIndexingConnectionTimeout()
	{
		return getPersistenceContext().getPropertyValue(INDEXINGCONNECTIONTIMEOUT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.indexingMaxTotalConnections</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexingMaxTotalConnections - Sets the maximum total connections allowed
	 */
	@Accessor(qualifier = "indexingMaxTotalConnections", type = Accessor.Type.GETTER)
	public Integer getIndexingMaxTotalConnections()
	{
		return getPersistenceContext().getPropertyValue(INDEXINGMAXTOTALCONNECTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.indexingMaxTotalConnectionsPerHostConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexingMaxTotalConnectionsPerHostConfig - Sets the maximum number of connections to be used for the given host config
	 */
	@Accessor(qualifier = "indexingMaxTotalConnectionsPerHostConfig", type = Accessor.Type.GETTER)
	public Integer getIndexingMaxTotalConnectionsPerHostConfig()
	{
		return getPersistenceContext().getPropertyValue(INDEXINGMAXTOTALCONNECTIONSPERHOSTCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.indexingPassword</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexingPassword
	 */
	@Accessor(qualifier = "indexingPassword", type = Accessor.Type.GETTER)
	public String getIndexingPassword()
	{
		return getPersistenceContext().getPropertyValue(INDEXINGPASSWORD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.indexingSocketTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexingSocketTimeout - Sets the default socket timeout in milliseconds which is the timeout for waiting for data
	 */
	@Accessor(qualifier = "indexingSocketTimeout", type = Accessor.Type.GETTER)
	public Integer getIndexingSocketTimeout()
	{
		return getPersistenceContext().getPropertyValue(INDEXINGSOCKETTIMEOUT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.indexingUsername</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexingUsername
	 */
	@Accessor(qualifier = "indexingUsername", type = Accessor.Type.GETTER)
	public String getIndexingUsername()
	{
		return getPersistenceContext().getPropertyValue(INDEXINGUSERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.maxTotalConnections</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the maxTotalConnections - Sets the maximum total connections allowed
	 */
	@Accessor(qualifier = "maxTotalConnections", type = Accessor.Type.GETTER)
	public Integer getMaxTotalConnections()
	{
		return getPersistenceContext().getPropertyValue(MAXTOTALCONNECTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.maxTotalConnectionsPerHostConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the maxTotalConnectionsPerHostConfig - Sets the maximum number of connections to be used for the given host config
	 */
	@Accessor(qualifier = "maxTotalConnectionsPerHostConfig", type = Accessor.Type.GETTER)
	public Integer getMaxTotalConnectionsPerHostConfig()
	{
		return getPersistenceContext().getPropertyValue(MAXTOTALCONNECTIONSPERHOSTCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.mode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the mode - operation mode of Solr server
	 */
	@Accessor(qualifier = "mode", type = Accessor.Type.GETTER)
	public SolrServerModes getMode()
	{
		return getPersistenceContext().getPropertyValue(MODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the name - unique identifier of solr configuration
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.numShards</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the numShards
	 */
	@Accessor(qualifier = "numShards", type = Accessor.Type.GETTER)
	public Integer getNumShards()
	{
		return getPersistenceContext().getPropertyValue(NUMSHARDS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.password</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the password
	 */
	@Accessor(qualifier = "password", type = Accessor.Type.GETTER)
	public String getPassword()
	{
		return getPersistenceContext().getPropertyValue(PASSWORD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.readTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the readTimeout
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "readTimeout", type = Accessor.Type.GETTER)
	public Integer getReadTimeout()
	{
		return getPersistenceContext().getPropertyValue(READTIMEOUT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.replicationFactor</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the replicationFactor
	 */
	@Accessor(qualifier = "replicationFactor", type = Accessor.Type.GETTER)
	public Integer getReplicationFactor()
	{
		return getPersistenceContext().getPropertyValue(REPLICATIONFACTOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.socketTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the socketTimeout - Sets the default socket timeout in milliseconds which is the timeout for waiting for data
	 */
	@Accessor(qualifier = "socketTimeout", type = Accessor.Type.GETTER)
	public Integer getSocketTimeout()
	{
		return getPersistenceContext().getPropertyValue(SOCKETTIMEOUT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.solrEndpointUrls</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrEndpointUrls
	 */
	@Accessor(qualifier = "solrEndpointUrls", type = Accessor.Type.GETTER)
	public List<SolrEndpointUrlModel> getSolrEndpointUrls()
	{
		return getPersistenceContext().getPropertyValue(SOLRENDPOINTURLS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.solrQueryMethod</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrQueryMethod
	 */
	@Accessor(qualifier = "solrQueryMethod", type = Accessor.Type.GETTER)
	public SolrQueryMethod getSolrQueryMethod()
	{
		return getPersistenceContext().getPropertyValue(SOLRQUERYMETHOD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.username</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the username
	 */
	@Accessor(qualifier = "username", type = Accessor.Type.GETTER)
	public String getUsername()
	{
		return getPersistenceContext().getPropertyValue(USERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.version</code> dynamic attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the version
	 */
	@Accessor(qualifier = "version", type = Accessor.Type.GETTER)
	public String getVersion()
	{
		return getPersistenceContext().getDynamicValue(this,VERSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.embeddedMaster</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the embeddedMaster
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "embeddedMaster", type = Accessor.Type.GETTER)
	public boolean isEmbeddedMaster()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(EMBEDDEDMASTER));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.indexingTcpNoDelay</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexingTcpNoDelay - Setting to true disables TCP packet batching
	 */
	@Accessor(qualifier = "indexingTcpNoDelay", type = Accessor.Type.GETTER)
	public boolean isIndexingTcpNoDelay()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(INDEXINGTCPNODELAY));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.tcpNoDelay</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the tcpNoDelay - Setting to true disables TCP packet batching
	 */
	@Accessor(qualifier = "tcpNoDelay", type = Accessor.Type.GETTER)
	public boolean isTcpNoDelay()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(TCPNODELAY));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrServerConfig.useMasterNodeExclusivelyForIndexing</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the useMasterNodeExclusivelyForIndexing
	 */
	@Accessor(qualifier = "useMasterNodeExclusivelyForIndexing", type = Accessor.Type.GETTER)
	public boolean isUseMasterNodeExclusivelyForIndexing()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(USEMASTERNODEEXCLUSIVELYFORINDEXING));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.aliveCheckInterval</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the aliveCheckInterval - Time interval in milliseconds which is used to ping the dead servers to find if it is alive.
	 */
	@Accessor(qualifier = "aliveCheckInterval", type = Accessor.Type.SETTER)
	public void setAliveCheckInterval(final Integer value)
	{
		getPersistenceContext().setPropertyValue(ALIVECHECKINTERVAL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.connectionTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the connectionTimeout - Sets the timeout in milliseconds until a connection is established.
	 */
	@Accessor(qualifier = "connectionTimeout", type = Accessor.Type.SETTER)
	public void setConnectionTimeout(final Integer value)
	{
		getPersistenceContext().setPropertyValue(CONNECTIONTIMEOUT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.embeddedMaster</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the embeddedMaster
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "embeddedMaster", type = Accessor.Type.SETTER)
	public void setEmbeddedMaster(final boolean value)
	{
		getPersistenceContext().setPropertyValue(EMBEDDEDMASTER, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.indexingAliveCheckInterval</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexingAliveCheckInterval - Time interval in milliseconds which is used to ping the dead servers to find if it is alive.
	 */
	@Accessor(qualifier = "indexingAliveCheckInterval", type = Accessor.Type.SETTER)
	public void setIndexingAliveCheckInterval(final Integer value)
	{
		getPersistenceContext().setPropertyValue(INDEXINGALIVECHECKINTERVAL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.indexingConnectionTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexingConnectionTimeout - Sets the timeout in milliseconds until a connection is established.
	 */
	@Accessor(qualifier = "indexingConnectionTimeout", type = Accessor.Type.SETTER)
	public void setIndexingConnectionTimeout(final Integer value)
	{
		getPersistenceContext().setPropertyValue(INDEXINGCONNECTIONTIMEOUT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.indexingMaxTotalConnections</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexingMaxTotalConnections - Sets the maximum total connections allowed
	 */
	@Accessor(qualifier = "indexingMaxTotalConnections", type = Accessor.Type.SETTER)
	public void setIndexingMaxTotalConnections(final Integer value)
	{
		getPersistenceContext().setPropertyValue(INDEXINGMAXTOTALCONNECTIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.indexingMaxTotalConnectionsPerHostConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexingMaxTotalConnectionsPerHostConfig - Sets the maximum number of connections to be used for the given host config
	 */
	@Accessor(qualifier = "indexingMaxTotalConnectionsPerHostConfig", type = Accessor.Type.SETTER)
	public void setIndexingMaxTotalConnectionsPerHostConfig(final Integer value)
	{
		getPersistenceContext().setPropertyValue(INDEXINGMAXTOTALCONNECTIONSPERHOSTCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.indexingPassword</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexingPassword
	 */
	@Accessor(qualifier = "indexingPassword", type = Accessor.Type.SETTER)
	public void setIndexingPassword(final String value)
	{
		getPersistenceContext().setPropertyValue(INDEXINGPASSWORD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.indexingSocketTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexingSocketTimeout - Sets the default socket timeout in milliseconds which is the timeout for waiting for data
	 */
	@Accessor(qualifier = "indexingSocketTimeout", type = Accessor.Type.SETTER)
	public void setIndexingSocketTimeout(final Integer value)
	{
		getPersistenceContext().setPropertyValue(INDEXINGSOCKETTIMEOUT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.indexingTcpNoDelay</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexingTcpNoDelay - Setting to true disables TCP packet batching
	 */
	@Accessor(qualifier = "indexingTcpNoDelay", type = Accessor.Type.SETTER)
	public void setIndexingTcpNoDelay(final boolean value)
	{
		getPersistenceContext().setPropertyValue(INDEXINGTCPNODELAY, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.indexingUsername</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexingUsername
	 */
	@Accessor(qualifier = "indexingUsername", type = Accessor.Type.SETTER)
	public void setIndexingUsername(final String value)
	{
		getPersistenceContext().setPropertyValue(INDEXINGUSERNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.maxTotalConnections</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the maxTotalConnections - Sets the maximum total connections allowed
	 */
	@Accessor(qualifier = "maxTotalConnections", type = Accessor.Type.SETTER)
	public void setMaxTotalConnections(final Integer value)
	{
		getPersistenceContext().setPropertyValue(MAXTOTALCONNECTIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.maxTotalConnectionsPerHostConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the maxTotalConnectionsPerHostConfig - Sets the maximum number of connections to be used for the given host config
	 */
	@Accessor(qualifier = "maxTotalConnectionsPerHostConfig", type = Accessor.Type.SETTER)
	public void setMaxTotalConnectionsPerHostConfig(final Integer value)
	{
		getPersistenceContext().setPropertyValue(MAXTOTALCONNECTIONSPERHOSTCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.mode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the mode - operation mode of Solr server
	 */
	@Accessor(qualifier = "mode", type = Accessor.Type.SETTER)
	public void setMode(final SolrServerModes value)
	{
		getPersistenceContext().setPropertyValue(MODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SolrServerConfig.name</code> attribute defined at extension <code>solrfacetsearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the name - unique identifier of solr configuration
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.numShards</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the numShards
	 */
	@Accessor(qualifier = "numShards", type = Accessor.Type.SETTER)
	public void setNumShards(final Integer value)
	{
		getPersistenceContext().setPropertyValue(NUMSHARDS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.password</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the password
	 */
	@Accessor(qualifier = "password", type = Accessor.Type.SETTER)
	public void setPassword(final String value)
	{
		getPersistenceContext().setPropertyValue(PASSWORD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.readTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the readTimeout
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "readTimeout", type = Accessor.Type.SETTER)
	public void setReadTimeout(final Integer value)
	{
		getPersistenceContext().setPropertyValue(READTIMEOUT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.replicationFactor</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the replicationFactor
	 */
	@Accessor(qualifier = "replicationFactor", type = Accessor.Type.SETTER)
	public void setReplicationFactor(final Integer value)
	{
		getPersistenceContext().setPropertyValue(REPLICATIONFACTOR, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.socketTimeout</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the socketTimeout - Sets the default socket timeout in milliseconds which is the timeout for waiting for data
	 */
	@Accessor(qualifier = "socketTimeout", type = Accessor.Type.SETTER)
	public void setSocketTimeout(final Integer value)
	{
		getPersistenceContext().setPropertyValue(SOCKETTIMEOUT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.solrEndpointUrls</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrEndpointUrls
	 */
	@Accessor(qualifier = "solrEndpointUrls", type = Accessor.Type.SETTER)
	public void setSolrEndpointUrls(final List<SolrEndpointUrlModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRENDPOINTURLS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.solrQueryMethod</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrQueryMethod
	 */
	@Accessor(qualifier = "solrQueryMethod", type = Accessor.Type.SETTER)
	public void setSolrQueryMethod(final SolrQueryMethod value)
	{
		getPersistenceContext().setPropertyValue(SOLRQUERYMETHOD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.tcpNoDelay</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the tcpNoDelay - Setting to true disables TCP packet batching
	 */
	@Accessor(qualifier = "tcpNoDelay", type = Accessor.Type.SETTER)
	public void setTcpNoDelay(final boolean value)
	{
		getPersistenceContext().setPropertyValue(TCPNODELAY, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.useMasterNodeExclusivelyForIndexing</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the useMasterNodeExclusivelyForIndexing
	 */
	@Accessor(qualifier = "useMasterNodeExclusivelyForIndexing", type = Accessor.Type.SETTER)
	public void setUseMasterNodeExclusivelyForIndexing(final boolean value)
	{
		getPersistenceContext().setPropertyValue(USEMASTERNODEEXCLUSIVELYFORINDEXING, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrServerConfig.username</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the username
	 */
	@Accessor(qualifier = "username", type = Accessor.Type.SETTER)
	public void setUsername(final String value)
	{
		getPersistenceContext().setPropertyValue(USERNAME, value);
	}
	
}
