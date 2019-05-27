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
package de.hybris.platform.solrfacetsearch.config;

import java.io.Serializable;
import de.hybris.platform.solrfacetsearch.config.EndpointURL;
import java.util.List;

public  class ClusterConfig  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ClusterConfig.aliveCheckInterval</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer aliveCheckInterval;

	/** <i>Generated property</i> for <code>ClusterConfig.connectionTimeout</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer connectionTimeout;

	/** <i>Generated property</i> for <code>ClusterConfig.socketTimeout</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer socketTimeout;

	/** <i>Generated property</i> for <code>ClusterConfig.maxConnections</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer maxConnections;

	/** <i>Generated property</i> for <code>ClusterConfig.maxConnectionsPerHost</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer maxConnectionsPerHost;

	/** <i>Generated property</i> for <code>ClusterConfig.tcpNoDelay</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean tcpNoDelay;

	/** <i>Generated property</i> for <code>ClusterConfig.endpointURLs</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private List<EndpointURL> endpointURLs;

	/** <i>Generated property</i> for <code>ClusterConfig.useMasterNodeExclusivelyForIndexing</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean useMasterNodeExclusivelyForIndexing;

	/** <i>Generated property</i> for <code>ClusterConfig.numShards</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer numShards;

	/** <i>Generated property</i> for <code>ClusterConfig.replicationFactor</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer replicationFactor;
	
	public ClusterConfig()
	{
		// default constructor
	}
	
		
	
	public void setAliveCheckInterval(final Integer aliveCheckInterval)
	{
		this.aliveCheckInterval = aliveCheckInterval;
	}

		
	
	public Integer getAliveCheckInterval() 
	{
		return aliveCheckInterval;
	}
	
		
	
	public void setConnectionTimeout(final Integer connectionTimeout)
	{
		this.connectionTimeout = connectionTimeout;
	}

		
	
	public Integer getConnectionTimeout() 
	{
		return connectionTimeout;
	}
	
		
	
	public void setSocketTimeout(final Integer socketTimeout)
	{
		this.socketTimeout = socketTimeout;
	}

		
	
	public Integer getSocketTimeout() 
	{
		return socketTimeout;
	}
	
		
	
	public void setMaxConnections(final Integer maxConnections)
	{
		this.maxConnections = maxConnections;
	}

		
	
	public Integer getMaxConnections() 
	{
		return maxConnections;
	}
	
		
	
	public void setMaxConnectionsPerHost(final Integer maxConnectionsPerHost)
	{
		this.maxConnectionsPerHost = maxConnectionsPerHost;
	}

		
	
	public Integer getMaxConnectionsPerHost() 
	{
		return maxConnectionsPerHost;
	}
	
		
	
	public void setTcpNoDelay(final boolean tcpNoDelay)
	{
		this.tcpNoDelay = tcpNoDelay;
	}

		
	
	public boolean isTcpNoDelay() 
	{
		return tcpNoDelay;
	}
	
		
	
	public void setEndpointURLs(final List<EndpointURL> endpointURLs)
	{
		this.endpointURLs = endpointURLs;
	}

		
	
	public List<EndpointURL> getEndpointURLs() 
	{
		return endpointURLs;
	}
	
		
	
	public void setUseMasterNodeExclusivelyForIndexing(final boolean useMasterNodeExclusivelyForIndexing)
	{
		this.useMasterNodeExclusivelyForIndexing = useMasterNodeExclusivelyForIndexing;
	}

		
	
	public boolean isUseMasterNodeExclusivelyForIndexing() 
	{
		return useMasterNodeExclusivelyForIndexing;
	}
	
		
	
	public void setNumShards(final Integer numShards)
	{
		this.numShards = numShards;
	}

		
	
	public Integer getNumShards() 
	{
		return numShards;
	}
	
		
	
	public void setReplicationFactor(final Integer replicationFactor)
	{
		this.replicationFactor = replicationFactor;
	}

		
	
	public Integer getReplicationFactor() 
	{
		return replicationFactor;
	}
	


}
