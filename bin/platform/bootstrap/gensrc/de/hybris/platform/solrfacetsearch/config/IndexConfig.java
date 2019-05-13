/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.solrfacetsearch.config.CommitMode;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.config.OptimizeMode;
import de.hybris.platform.solrfacetsearch.enums.IndexMode;
import java.util.Collection;
import java.util.Map;

public  class IndexConfig  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>IndexConfig.indexedTypes</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<String,IndexedType> indexedTypes;

	/** <i>Generated property</i> for <code>IndexConfig.catalogVersions</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Collection<CatalogVersionModel> catalogVersions;

	/** <i>Generated property</i> for <code>IndexConfig.languages</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Collection<LanguageModel> languages;

	/** <i>Generated property</i> for <code>IndexConfig.currencies</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Collection<CurrencyModel> currencies;

	/** <i>Generated property</i> for <code>IndexConfig.enabledLanguageFallbackMechanism</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean enabledLanguageFallbackMechanism;

	/** <i>Generated property</i> for <code>IndexConfig.listeners</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Collection<String> listeners;

	/** <i>Generated property</i> for <code>IndexConfig.exportPath</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String exportPath;

	/** <i>Generated property</i> for <code>IndexConfig.batchSize</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private int batchSize;

	/** <i>Generated property</i> for <code>IndexConfig.numberOfThreads</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private int numberOfThreads;

	/** <i>Generated property</i> for <code>IndexConfig.indexMode</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private IndexMode indexMode;

	/** <i>Generated property</i> for <code>IndexConfig.commitMode</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private CommitMode commitMode;

	/** <i>Generated property</i> for <code>IndexConfig.optimizeMode</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private OptimizeMode optimizeMode;

	/** <i>Generated property</i> for <code>IndexConfig.ignoreErrors</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean ignoreErrors;

	/** <i>Generated property</i> for <code>IndexConfig.legacyMode</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean legacyMode;

	/** <i>Generated property</i> for <code>IndexConfig.maxRetries</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private int maxRetries;

	/** <i>Generated property</i> for <code>IndexConfig.maxBatchRetries</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private int maxBatchRetries;

	/** <i>Generated property</i> for <code>IndexConfig.distributedIndexing</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean distributedIndexing;

	/** <i>Generated property</i> for <code>IndexConfig.nodeGroup</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String nodeGroup;

	/** <i>Generated property</i> for <code>IndexConfig.baseSite</code> property defined at extension <code>commerceservices</code>. */
		
	private BaseSiteModel baseSite;
	
	public IndexConfig()
	{
		// default constructor
	}
	
		
	
	public void setIndexedTypes(final Map<String,IndexedType> indexedTypes)
	{
		this.indexedTypes = indexedTypes;
	}

		
	
	public Map<String,IndexedType> getIndexedTypes() 
	{
		return indexedTypes;
	}
	
		
	
	public void setCatalogVersions(final Collection<CatalogVersionModel> catalogVersions)
	{
		this.catalogVersions = catalogVersions;
	}

		
	
	public Collection<CatalogVersionModel> getCatalogVersions() 
	{
		return catalogVersions;
	}
	
		
	
	public void setLanguages(final Collection<LanguageModel> languages)
	{
		this.languages = languages;
	}

		
	
	public Collection<LanguageModel> getLanguages() 
	{
		return languages;
	}
	
		
	
	public void setCurrencies(final Collection<CurrencyModel> currencies)
	{
		this.currencies = currencies;
	}

		
	
	public Collection<CurrencyModel> getCurrencies() 
	{
		return currencies;
	}
	
		
	
	public void setEnabledLanguageFallbackMechanism(final boolean enabledLanguageFallbackMechanism)
	{
		this.enabledLanguageFallbackMechanism = enabledLanguageFallbackMechanism;
	}

		
	
	public boolean isEnabledLanguageFallbackMechanism() 
	{
		return enabledLanguageFallbackMechanism;
	}
	
		
	
	public void setListeners(final Collection<String> listeners)
	{
		this.listeners = listeners;
	}

		
	
	public Collection<String> getListeners() 
	{
		return listeners;
	}
	
		
	
	public void setExportPath(final String exportPath)
	{
		this.exportPath = exportPath;
	}

		
	
	public String getExportPath() 
	{
		return exportPath;
	}
	
		
	
	public void setBatchSize(final int batchSize)
	{
		this.batchSize = batchSize;
	}

		
	
	public int getBatchSize() 
	{
		return batchSize;
	}
	
		
	
	public void setNumberOfThreads(final int numberOfThreads)
	{
		this.numberOfThreads = numberOfThreads;
	}

		
	
	public int getNumberOfThreads() 
	{
		return numberOfThreads;
	}
	
		
	
	public void setIndexMode(final IndexMode indexMode)
	{
		this.indexMode = indexMode;
	}

		
	
	public IndexMode getIndexMode() 
	{
		return indexMode;
	}
	
		
	
	public void setCommitMode(final CommitMode commitMode)
	{
		this.commitMode = commitMode;
	}

		
	
	public CommitMode getCommitMode() 
	{
		return commitMode;
	}
	
		
	
	public void setOptimizeMode(final OptimizeMode optimizeMode)
	{
		this.optimizeMode = optimizeMode;
	}

		
	
	public OptimizeMode getOptimizeMode() 
	{
		return optimizeMode;
	}
	
		
	
	public void setIgnoreErrors(final boolean ignoreErrors)
	{
		this.ignoreErrors = ignoreErrors;
	}

		
	
	public boolean isIgnoreErrors() 
	{
		return ignoreErrors;
	}
	
		
	@Deprecated 
	public void setLegacyMode(final boolean legacyMode)
	{
		this.legacyMode = legacyMode;
	}

		
	@Deprecated 
	public boolean isLegacyMode() 
	{
		return legacyMode;
	}
	
		
	
	public void setMaxRetries(final int maxRetries)
	{
		this.maxRetries = maxRetries;
	}

		
	
	public int getMaxRetries() 
	{
		return maxRetries;
	}
	
		
	
	public void setMaxBatchRetries(final int maxBatchRetries)
	{
		this.maxBatchRetries = maxBatchRetries;
	}

		
	
	public int getMaxBatchRetries() 
	{
		return maxBatchRetries;
	}
	
		
	
	public void setDistributedIndexing(final boolean distributedIndexing)
	{
		this.distributedIndexing = distributedIndexing;
	}

		
	
	public boolean isDistributedIndexing() 
	{
		return distributedIndexing;
	}
	
		
	
	public void setNodeGroup(final String nodeGroup)
	{
		this.nodeGroup = nodeGroup;
	}

		
	
	public String getNodeGroup() 
	{
		return nodeGroup;
	}
	
		
	
	public void setBaseSite(final BaseSiteModel baseSite)
	{
		this.baseSite = baseSite;
	}

		
	
	public BaseSiteModel getBaseSite() 
	{
		return baseSite;
	}
	


}
