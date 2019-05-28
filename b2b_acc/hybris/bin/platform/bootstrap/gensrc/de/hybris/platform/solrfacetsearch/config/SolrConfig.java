/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
import de.hybris.platform.solrfacetsearch.config.QueryMethod;
import de.hybris.platform.solrfacetsearch.config.SolrClientConfig;
import de.hybris.platform.solrfacetsearch.config.SolrServerMode;
import java.util.Date;
import java.util.List;

public  class SolrConfig  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SolrConfig.name</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>SolrConfig.mode</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private SolrServerMode mode;

	/** <i>Generated property</i> for <code>SolrConfig.endpointURLs</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private List<EndpointURL> endpointURLs;

	/** <i>Generated property</i> for <code>SolrConfig.useMasterNodeExclusivelyForIndexing</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean useMasterNodeExclusivelyForIndexing;

	/** <i>Generated property</i> for <code>SolrConfig.numShards</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer numShards;

	/** <i>Generated property</i> for <code>SolrConfig.replicationFactor</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Integer replicationFactor;

	/** Solr Client configuration for searching<br/><br/><i>Generated property</i> for <code>SolrConfig.clientConfig</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private SolrClientConfig clientConfig;

	/** Solr Client configuration for indexing<br/><br/><i>Generated property</i> for <code>SolrConfig.indexingClientConfig</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private SolrClientConfig indexingClientConfig;

	/** <i>Generated property</i> for <code>SolrConfig.queryMethod</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private QueryMethod queryMethod;

	/** <i>Generated property</i> for <code>SolrConfig.modifiedTime</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Date modifiedTime;

	/** <i>Generated property</i> for <code>SolrConfig.version</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String version;
	
	public SolrConfig()
	{
		// default constructor
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setMode(final SolrServerMode mode)
	{
		this.mode = mode;
	}

		
	
	public SolrServerMode getMode() 
	{
		return mode;
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
	
		
	
	public void setClientConfig(final SolrClientConfig clientConfig)
	{
		this.clientConfig = clientConfig;
	}

		
	
	public SolrClientConfig getClientConfig() 
	{
		return clientConfig;
	}
	
		
	
	public void setIndexingClientConfig(final SolrClientConfig indexingClientConfig)
	{
		this.indexingClientConfig = indexingClientConfig;
	}

		
	
	public SolrClientConfig getIndexingClientConfig() 
	{
		return indexingClientConfig;
	}
	
		
	
	public void setQueryMethod(final QueryMethod queryMethod)
	{
		this.queryMethod = queryMethod;
	}

		
	
	public QueryMethod getQueryMethod() 
	{
		return queryMethod;
	}
	
		
	
	public void setModifiedTime(final Date modifiedTime)
	{
		this.modifiedTime = modifiedTime;
	}

		
	
	public Date getModifiedTime() 
	{
		return modifiedTime;
	}
	
		
	
	public void setVersion(final String version)
	{
		this.version = version;
	}

		
	
	public String getVersion() 
	{
		return version;
	}
	


}
