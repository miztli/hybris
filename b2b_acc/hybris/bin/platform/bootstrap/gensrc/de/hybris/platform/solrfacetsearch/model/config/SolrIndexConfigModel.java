/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 27, 2019 5:14:19 PM                     ---
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
import de.hybris.platform.solrfacetsearch.enums.IndexMode;
import de.hybris.platform.solrfacetsearch.enums.SolrCommitMode;
import de.hybris.platform.solrfacetsearch.enums.SolrOptimizeMode;

/**
 * Generated model class for type SolrIndexConfig first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrIndexConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrIndexConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.name</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.batchSize</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String BATCHSIZE = "batchSize";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.exportPath</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String EXPORTPATH = "exportPath";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.numberOfThreads</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NUMBEROFTHREADS = "numberOfThreads";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.indexMode</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXMODE = "indexMode";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.commitMode</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String COMMITMODE = "commitMode";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.optimizeMode</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String OPTIMIZEMODE = "optimizeMode";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.ignoreErrors</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String IGNOREERRORS = "ignoreErrors";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.legacyMode</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LEGACYMODE = "legacyMode";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.maxRetries</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String MAXRETRIES = "maxRetries";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.maxBatchRetries</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String MAXBATCHRETRIES = "maxBatchRetries";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.distributedIndexing</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String DISTRIBUTEDINDEXING = "distributedIndexing";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexConfig.nodeGroup</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NODEGROUP = "nodeGroup";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrIndexConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrIndexConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _name initial attribute declared by type <code>SolrIndexConfig</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrIndexConfigModel(final String _name)
	{
		super();
		setName(_name);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _name initial attribute declared by type <code>SolrIndexConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public SolrIndexConfigModel(final String _name, final ItemModel _owner)
	{
		super();
		setName(_name);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.batchSize</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the batchSize
	 */
	@Accessor(qualifier = "batchSize", type = Accessor.Type.GETTER)
	public int getBatchSize()
	{
		return toPrimitive((Integer)getPersistenceContext().getPropertyValue(BATCHSIZE));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.commitMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the commitMode
	 */
	@Accessor(qualifier = "commitMode", type = Accessor.Type.GETTER)
	public SolrCommitMode getCommitMode()
	{
		return getPersistenceContext().getPropertyValue(COMMITMODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.exportPath</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the exportPath
	 */
	@Accessor(qualifier = "exportPath", type = Accessor.Type.GETTER)
	public String getExportPath()
	{
		return getPersistenceContext().getPropertyValue(EXPORTPATH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.indexMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexMode
	 */
	@Accessor(qualifier = "indexMode", type = Accessor.Type.GETTER)
	public IndexMode getIndexMode()
	{
		return getPersistenceContext().getPropertyValue(INDEXMODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.maxBatchRetries</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the maxBatchRetries
	 */
	@Accessor(qualifier = "maxBatchRetries", type = Accessor.Type.GETTER)
	public int getMaxBatchRetries()
	{
		return toPrimitive((Integer)getPersistenceContext().getPropertyValue(MAXBATCHRETRIES));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.maxRetries</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the maxRetries
	 */
	@Accessor(qualifier = "maxRetries", type = Accessor.Type.GETTER)
	public int getMaxRetries()
	{
		return toPrimitive((Integer)getPersistenceContext().getPropertyValue(MAXRETRIES));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the name - unique identifier of indexer configuration
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.nodeGroup</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the nodeGroup - allows to control on which node group of a cluster process will be executed in case of distributed indexing
	 */
	@Accessor(qualifier = "nodeGroup", type = Accessor.Type.GETTER)
	public String getNodeGroup()
	{
		return getPersistenceContext().getPropertyValue(NODEGROUP);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.numberOfThreads</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the numberOfThreads
	 */
	@Accessor(qualifier = "numberOfThreads", type = Accessor.Type.GETTER)
	public int getNumberOfThreads()
	{
		return toPrimitive((Integer)getPersistenceContext().getPropertyValue(NUMBEROFTHREADS));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.optimizeMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the optimizeMode
	 */
	@Accessor(qualifier = "optimizeMode", type = Accessor.Type.GETTER)
	public SolrOptimizeMode getOptimizeMode()
	{
		return getPersistenceContext().getPropertyValue(OPTIMIZEMODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.distributedIndexing</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the distributedIndexing
	 */
	@Accessor(qualifier = "distributedIndexing", type = Accessor.Type.GETTER)
	public boolean isDistributedIndexing()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(DISTRIBUTEDINDEXING));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.ignoreErrors</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ignoreErrors
	 */
	@Accessor(qualifier = "ignoreErrors", type = Accessor.Type.GETTER)
	public boolean isIgnoreErrors()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(IGNOREERRORS));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexConfig.legacyMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the legacyMode
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "legacyMode", type = Accessor.Type.GETTER)
	public boolean isLegacyMode()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(LEGACYMODE));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.batchSize</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the batchSize
	 */
	@Accessor(qualifier = "batchSize", type = Accessor.Type.SETTER)
	public void setBatchSize(final int value)
	{
		getPersistenceContext().setPropertyValue(BATCHSIZE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.commitMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the commitMode
	 */
	@Accessor(qualifier = "commitMode", type = Accessor.Type.SETTER)
	public void setCommitMode(final SolrCommitMode value)
	{
		getPersistenceContext().setPropertyValue(COMMITMODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.distributedIndexing</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the distributedIndexing
	 */
	@Accessor(qualifier = "distributedIndexing", type = Accessor.Type.SETTER)
	public void setDistributedIndexing(final boolean value)
	{
		getPersistenceContext().setPropertyValue(DISTRIBUTEDINDEXING, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.exportPath</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the exportPath
	 */
	@Accessor(qualifier = "exportPath", type = Accessor.Type.SETTER)
	public void setExportPath(final String value)
	{
		getPersistenceContext().setPropertyValue(EXPORTPATH, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.ignoreErrors</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ignoreErrors
	 */
	@Accessor(qualifier = "ignoreErrors", type = Accessor.Type.SETTER)
	public void setIgnoreErrors(final boolean value)
	{
		getPersistenceContext().setPropertyValue(IGNOREERRORS, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.indexMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexMode
	 */
	@Accessor(qualifier = "indexMode", type = Accessor.Type.SETTER)
	public void setIndexMode(final IndexMode value)
	{
		getPersistenceContext().setPropertyValue(INDEXMODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.legacyMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the legacyMode
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "legacyMode", type = Accessor.Type.SETTER)
	public void setLegacyMode(final boolean value)
	{
		getPersistenceContext().setPropertyValue(LEGACYMODE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.maxBatchRetries</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the maxBatchRetries
	 */
	@Accessor(qualifier = "maxBatchRetries", type = Accessor.Type.SETTER)
	public void setMaxBatchRetries(final int value)
	{
		getPersistenceContext().setPropertyValue(MAXBATCHRETRIES, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.maxRetries</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the maxRetries
	 */
	@Accessor(qualifier = "maxRetries", type = Accessor.Type.SETTER)
	public void setMaxRetries(final int value)
	{
		getPersistenceContext().setPropertyValue(MAXRETRIES, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SolrIndexConfig.name</code> attribute defined at extension <code>solrfacetsearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the name - unique identifier of indexer configuration
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.nodeGroup</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the nodeGroup - allows to control on which node group of a cluster process will be executed in case of distributed indexing
	 */
	@Accessor(qualifier = "nodeGroup", type = Accessor.Type.SETTER)
	public void setNodeGroup(final String value)
	{
		getPersistenceContext().setPropertyValue(NODEGROUP, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.numberOfThreads</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the numberOfThreads
	 */
	@Accessor(qualifier = "numberOfThreads", type = Accessor.Type.SETTER)
	public void setNumberOfThreads(final int value)
	{
		getPersistenceContext().setPropertyValue(NUMBEROFTHREADS, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexConfig.optimizeMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the optimizeMode
	 */
	@Accessor(qualifier = "optimizeMode", type = Accessor.Type.SETTER)
	public void setOptimizeMode(final SolrOptimizeMode value)
	{
		getPersistenceContext().setPropertyValue(OPTIMIZEMODE, value);
	}
	
}
