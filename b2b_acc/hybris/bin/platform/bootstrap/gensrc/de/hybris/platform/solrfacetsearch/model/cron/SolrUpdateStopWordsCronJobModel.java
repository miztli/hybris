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
package de.hybris.platform.solrfacetsearch.model.cron;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cronjob.model.JobModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.model.config.SolrFacetSearchConfigModel;

/**
 * Generated model class for type SolrUpdateStopWordsCronJob first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrUpdateStopWordsCronJobModel extends CronJobModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrUpdateStopWordsCronJob";
	
	/**<i>Generated relation code constant for relation <code>SolrFacetSearchConfig2SolrUpdateStopWordsCronJob</code> defining source attribute <code>solrFacetSearchConfig</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRFACETSEARCHCONFIG2SOLRUPDATESTOPWORDSCRONJOB = "SolrFacetSearchConfig2SolrUpdateStopWordsCronJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrUpdateStopWordsCronJob.language</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LANGUAGE = "language";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrUpdateStopWordsCronJob.solrFacetSearchConfigPOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRFACETSEARCHCONFIGPOS = "solrFacetSearchConfigPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrUpdateStopWordsCronJob.solrFacetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRFACETSEARCHCONFIG = "solrFacetSearchConfig";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrUpdateStopWordsCronJobModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrUpdateStopWordsCronJobModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _job initial attribute declared by type <code>CronJob</code> at extension <code>processing</code>
	 * @param _solrFacetSearchConfig initial attribute declared by type <code>SolrUpdateStopWordsCronJob</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrUpdateStopWordsCronJobModel(final JobModel _job, final SolrFacetSearchConfigModel _solrFacetSearchConfig)
	{
		super();
		setJob(_job);
		setSolrFacetSearchConfig(_solrFacetSearchConfig);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _job initial attribute declared by type <code>CronJob</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _solrFacetSearchConfig initial attribute declared by type <code>SolrUpdateStopWordsCronJob</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrUpdateStopWordsCronJobModel(final JobModel _job, final ItemModel _owner, final SolrFacetSearchConfigModel _solrFacetSearchConfig)
	{
		super();
		setJob(_job);
		setOwner(_owner);
		setSolrFacetSearchConfig(_solrFacetSearchConfig);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrUpdateStopWordsCronJob.language</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the language
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.GETTER)
	public LanguageModel getLanguage()
	{
		return getPersistenceContext().getPropertyValue(LANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrUpdateStopWordsCronJob.solrFacetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrFacetSearchConfig
	 */
	@Accessor(qualifier = "solrFacetSearchConfig", type = Accessor.Type.GETTER)
	public SolrFacetSearchConfigModel getSolrFacetSearchConfig()
	{
		return getPersistenceContext().getPropertyValue(SOLRFACETSEARCHCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrUpdateStopWordsCronJob.language</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the language
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.SETTER)
	public void setLanguage(final LanguageModel value)
	{
		getPersistenceContext().setPropertyValue(LANGUAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrUpdateStopWordsCronJob.solrFacetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrFacetSearchConfig
	 */
	@Accessor(qualifier = "solrFacetSearchConfig", type = Accessor.Type.SETTER)
	public void setSolrFacetSearchConfig(final SolrFacetSearchConfigModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRFACETSEARCHCONFIG, value);
	}
	
}
