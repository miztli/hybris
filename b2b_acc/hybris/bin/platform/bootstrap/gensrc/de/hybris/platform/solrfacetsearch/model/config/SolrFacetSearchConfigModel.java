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
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexConfigModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexedTypeModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrSearchConfigModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrServerConfigModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrStopWordModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrSynonymConfigModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrValueRangeSetModel;
import de.hybris.platform.solrfacetsearch.model.cron.SolrUpdateStopWordsCronJobModel;
import de.hybris.platform.solrfacetsearch.model.cron.SolrUpdateSynonymsCronJobModel;
import de.hybris.platform.solrfacetsearch.model.indexer.cron.SolrIndexerCronJobModel;
import de.hybris.platform.solrfacetsearch.model.redirect.SolrFacetSearchKeywordRedirectModel;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * Generated model class for type SolrFacetSearchConfig first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrFacetSearchConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrFacetSearchConfig";
	
	/**<i>Generated relation code constant for relation <code>SolrSynonymConfig2SolrFacetSearchConfig</code> defining source attribute <code>synonyms</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRSYNONYMCONFIG2SOLRFACETSEARCHCONFIG = "SolrSynonymConfig2SolrFacetSearchConfig";
	
	/**<i>Generated relation code constant for relation <code>SolrStopWord2SolrFacetSearchConfig</code> defining source attribute <code>StopWords</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRSTOPWORD2SOLRFACETSEARCHCONFIG = "SolrStopWord2SolrFacetSearchConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.name</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.description</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.document</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String DOCUMENT = "document";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.solrSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRSEARCHCONFIG = "solrSearchConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.solrIndexConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXCONFIG = "solrIndexConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.solrServerConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRSERVERCONFIG = "solrServerConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.indexNamePrefix</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXNAMEPREFIX = "indexNamePrefix";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.languageSynonymMapping</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LANGUAGESYNONYMMAPPING = "languageSynonymMapping";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.languageStopWordMapping</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LANGUAGESTOPWORDMAPPING = "languageStopWordMapping";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.languageKeywordRedirectMapping</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LANGUAGEKEYWORDREDIRECTMAPPING = "languageKeywordRedirectMapping";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.enabledLanguageFallbackMechanism</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String ENABLEDLANGUAGEFALLBACKMECHANISM = "enabledLanguageFallbackMechanism";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.listeners</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LISTENERS = "listeners";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.catalogVersions</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String CATALOGVERSIONS = "catalogVersions";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.currencies</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String CURRENCIES = "currencies";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.languages</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LANGUAGES = "languages";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.solrValueRangeSets</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRVALUERANGESETS = "solrValueRangeSets";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.solrIndexerCronJob</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXERCRONJOB = "solrIndexerCronJob";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.solrIndexedTypes</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXEDTYPES = "solrIndexedTypes";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.keywordRedirects</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String KEYWORDREDIRECTS = "keywordRedirects";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.solrUpdateSynonymsCronJobs</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRUPDATESYNONYMSCRONJOBS = "solrUpdateSynonymsCronJobs";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.solrUpdateStopWordsCronJobs</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRUPDATESTOPWORDSCRONJOBS = "solrUpdateStopWordsCronJobs";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.synonyms</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SYNONYMS = "synonyms";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrFacetSearchConfig.StopWords</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String STOPWORDS = "StopWords";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrFacetSearchConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrFacetSearchConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _enabledLanguageFallbackMechanism initial attribute declared by type <code>SolrFacetSearchConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _name initial attribute declared by type <code>SolrFacetSearchConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _solrSearchConfig initial attribute declared by type <code>SolrFacetSearchConfig</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrFacetSearchConfigModel(final boolean _enabledLanguageFallbackMechanism, final String _name, final SolrSearchConfigModel _solrSearchConfig)
	{
		super();
		setEnabledLanguageFallbackMechanism(_enabledLanguageFallbackMechanism);
		setName(_name);
		setSolrSearchConfig(_solrSearchConfig);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _enabledLanguageFallbackMechanism initial attribute declared by type <code>SolrFacetSearchConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _name initial attribute declared by type <code>SolrFacetSearchConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _solrSearchConfig initial attribute declared by type <code>SolrFacetSearchConfig</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrFacetSearchConfigModel(final boolean _enabledLanguageFallbackMechanism, final String _name, final ItemModel _owner, final SolrSearchConfigModel _solrSearchConfig)
	{
		super();
		setEnabledLanguageFallbackMechanism(_enabledLanguageFallbackMechanism);
		setName(_name);
		setOwner(_owner);
		setSolrSearchConfig(_solrSearchConfig);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.catalogVersions</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the catalogVersions
	 */
	@Accessor(qualifier = "catalogVersions", type = Accessor.Type.GETTER)
	public List<CatalogVersionModel> getCatalogVersions()
	{
		return getPersistenceContext().getPropertyValue(CATALOGVERSIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.currencies</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the currencies
	 */
	@Accessor(qualifier = "currencies", type = Accessor.Type.GETTER)
	public List<CurrencyModel> getCurrencies()
	{
		return getPersistenceContext().getPropertyValue(CURRENCIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.description</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the description - description of the Config
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getPersistenceContext().getPropertyValue(DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.document</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the document - non hmc-configurable part of FacetSearchConfig.
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "document", type = Accessor.Type.GETTER)
	public MediaModel getDocument()
	{
		return getPersistenceContext().getPropertyValue(DOCUMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.indexNamePrefix</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexNamePrefix
	 */
	@Accessor(qualifier = "indexNamePrefix", type = Accessor.Type.GETTER)
	public String getIndexNamePrefix()
	{
		return getPersistenceContext().getPropertyValue(INDEXNAMEPREFIX);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.keywordRedirects</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the keywordRedirects
	 */
	@Accessor(qualifier = "keywordRedirects", type = Accessor.Type.GETTER)
	public Collection<SolrFacetSearchKeywordRedirectModel> getKeywordRedirects()
	{
		return getPersistenceContext().getPropertyValue(KEYWORDREDIRECTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.languageKeywordRedirectMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the languageKeywordRedirectMapping
	 */
	@Accessor(qualifier = "languageKeywordRedirectMapping", type = Accessor.Type.GETTER)
	public List<SolrFacetSearchKeywordRedirectModel> getLanguageKeywordRedirectMapping()
	{
		return getLanguageKeywordRedirectMapping(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.languageKeywordRedirectMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @param loc the value localization key 
	 * @return the languageKeywordRedirectMapping
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "languageKeywordRedirectMapping", type = Accessor.Type.GETTER)
	public List<SolrFacetSearchKeywordRedirectModel> getLanguageKeywordRedirectMapping(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(LANGUAGEKEYWORDREDIRECTMAPPING, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.languages</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the languages
	 */
	@Accessor(qualifier = "languages", type = Accessor.Type.GETTER)
	public List<LanguageModel> getLanguages()
	{
		return getPersistenceContext().getPropertyValue(LANGUAGES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.languageStopWordMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the languageStopWordMapping
	 */
	@Accessor(qualifier = "languageStopWordMapping", type = Accessor.Type.GETTER)
	public List<SolrStopWordModel> getLanguageStopWordMapping()
	{
		return getLanguageStopWordMapping(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.languageStopWordMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @param loc the value localization key 
	 * @return the languageStopWordMapping
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "languageStopWordMapping", type = Accessor.Type.GETTER)
	public List<SolrStopWordModel> getLanguageStopWordMapping(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(LANGUAGESTOPWORDMAPPING, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.languageSynonymMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the languageSynonymMapping
	 */
	@Accessor(qualifier = "languageSynonymMapping", type = Accessor.Type.GETTER)
	public List<SolrSynonymConfigModel> getLanguageSynonymMapping()
	{
		return getLanguageSynonymMapping(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.languageSynonymMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @param loc the value localization key 
	 * @return the languageSynonymMapping
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "languageSynonymMapping", type = Accessor.Type.GETTER)
	public List<SolrSynonymConfigModel> getLanguageSynonymMapping(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(LANGUAGESYNONYMMAPPING, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.listeners</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the listeners
	 */
	@Accessor(qualifier = "listeners", type = Accessor.Type.GETTER)
	public Collection<String> getListeners()
	{
		return getPersistenceContext().getPropertyValue(LISTENERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the name - name of the Config
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.solrIndexConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrIndexConfig
	 */
	@Accessor(qualifier = "solrIndexConfig", type = Accessor.Type.GETTER)
	public SolrIndexConfigModel getSolrIndexConfig()
	{
		return getPersistenceContext().getPropertyValue(SOLRINDEXCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.solrIndexedTypes</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrIndexedTypes
	 */
	@Accessor(qualifier = "solrIndexedTypes", type = Accessor.Type.GETTER)
	public List<SolrIndexedTypeModel> getSolrIndexedTypes()
	{
		return getPersistenceContext().getPropertyValue(SOLRINDEXEDTYPES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.solrIndexerCronJob</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrIndexerCronJob
	 */
	@Accessor(qualifier = "solrIndexerCronJob", type = Accessor.Type.GETTER)
	public List<SolrIndexerCronJobModel> getSolrIndexerCronJob()
	{
		return getPersistenceContext().getPropertyValue(SOLRINDEXERCRONJOB);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.solrSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrSearchConfig
	 */
	@Accessor(qualifier = "solrSearchConfig", type = Accessor.Type.GETTER)
	public SolrSearchConfigModel getSolrSearchConfig()
	{
		return getPersistenceContext().getPropertyValue(SOLRSEARCHCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.solrServerConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrServerConfig
	 */
	@Accessor(qualifier = "solrServerConfig", type = Accessor.Type.GETTER)
	public SolrServerConfigModel getSolrServerConfig()
	{
		return getPersistenceContext().getPropertyValue(SOLRSERVERCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.solrUpdateStopWordsCronJobs</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrUpdateStopWordsCronJobs
	 */
	@Accessor(qualifier = "solrUpdateStopWordsCronJobs", type = Accessor.Type.GETTER)
	public List<SolrUpdateStopWordsCronJobModel> getSolrUpdateStopWordsCronJobs()
	{
		return getPersistenceContext().getPropertyValue(SOLRUPDATESTOPWORDSCRONJOBS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.solrUpdateSynonymsCronJobs</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrUpdateSynonymsCronJobs
	 */
	@Accessor(qualifier = "solrUpdateSynonymsCronJobs", type = Accessor.Type.GETTER)
	public List<SolrUpdateSynonymsCronJobModel> getSolrUpdateSynonymsCronJobs()
	{
		return getPersistenceContext().getPropertyValue(SOLRUPDATESYNONYMSCRONJOBS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.solrValueRangeSets</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrValueRangeSets
	 */
	@Accessor(qualifier = "solrValueRangeSets", type = Accessor.Type.GETTER)
	public List<SolrValueRangeSetModel> getSolrValueRangeSets()
	{
		return getPersistenceContext().getPropertyValue(SOLRVALUERANGESETS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.StopWords</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the StopWords
	 */
	@Accessor(qualifier = "StopWords", type = Accessor.Type.GETTER)
	public List<SolrStopWordModel> getStopWords()
	{
		return getPersistenceContext().getPropertyValue(STOPWORDS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.synonyms</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the synonyms
	 */
	@Accessor(qualifier = "synonyms", type = Accessor.Type.GETTER)
	public List<SolrSynonymConfigModel> getSynonyms()
	{
		return getPersistenceContext().getPropertyValue(SYNONYMS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrFacetSearchConfig.enabledLanguageFallbackMechanism</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the enabledLanguageFallbackMechanism
	 */
	@Accessor(qualifier = "enabledLanguageFallbackMechanism", type = Accessor.Type.GETTER)
	public boolean isEnabledLanguageFallbackMechanism()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(ENABLEDLANGUAGEFALLBACKMECHANISM));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.catalogVersions</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the catalogVersions
	 */
	@Accessor(qualifier = "catalogVersions", type = Accessor.Type.SETTER)
	public void setCatalogVersions(final List<CatalogVersionModel> value)
	{
		getPersistenceContext().setPropertyValue(CATALOGVERSIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.currencies</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the currencies
	 */
	@Accessor(qualifier = "currencies", type = Accessor.Type.SETTER)
	public void setCurrencies(final List<CurrencyModel> value)
	{
		getPersistenceContext().setPropertyValue(CURRENCIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.description</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the description - description of the Config
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		getPersistenceContext().setPropertyValue(DESCRIPTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.document</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the document - non hmc-configurable part of FacetSearchConfig.
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "document", type = Accessor.Type.SETTER)
	public void setDocument(final MediaModel value)
	{
		getPersistenceContext().setPropertyValue(DOCUMENT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.enabledLanguageFallbackMechanism</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the enabledLanguageFallbackMechanism
	 */
	@Accessor(qualifier = "enabledLanguageFallbackMechanism", type = Accessor.Type.SETTER)
	public void setEnabledLanguageFallbackMechanism(final boolean value)
	{
		getPersistenceContext().setPropertyValue(ENABLEDLANGUAGEFALLBACKMECHANISM, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.indexNamePrefix</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexNamePrefix
	 */
	@Accessor(qualifier = "indexNamePrefix", type = Accessor.Type.SETTER)
	public void setIndexNamePrefix(final String value)
	{
		getPersistenceContext().setPropertyValue(INDEXNAMEPREFIX, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.keywordRedirects</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the keywordRedirects
	 */
	@Accessor(qualifier = "keywordRedirects", type = Accessor.Type.SETTER)
	public void setKeywordRedirects(final Collection<SolrFacetSearchKeywordRedirectModel> value)
	{
		getPersistenceContext().setPropertyValue(KEYWORDREDIRECTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.languageKeywordRedirectMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the languageKeywordRedirectMapping
	 */
	@Accessor(qualifier = "languageKeywordRedirectMapping", type = Accessor.Type.SETTER)
	public void setLanguageKeywordRedirectMapping(final List<SolrFacetSearchKeywordRedirectModel> value)
	{
		setLanguageKeywordRedirectMapping(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.languageKeywordRedirectMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the languageKeywordRedirectMapping
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "languageKeywordRedirectMapping", type = Accessor.Type.SETTER)
	public void setLanguageKeywordRedirectMapping(final List<SolrFacetSearchKeywordRedirectModel> value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(LANGUAGEKEYWORDREDIRECTMAPPING, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.languages</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the languages
	 */
	@Accessor(qualifier = "languages", type = Accessor.Type.SETTER)
	public void setLanguages(final List<LanguageModel> value)
	{
		getPersistenceContext().setPropertyValue(LANGUAGES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.languageStopWordMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the languageStopWordMapping
	 */
	@Accessor(qualifier = "languageStopWordMapping", type = Accessor.Type.SETTER)
	public void setLanguageStopWordMapping(final List<SolrStopWordModel> value)
	{
		setLanguageStopWordMapping(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.languageStopWordMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the languageStopWordMapping
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "languageStopWordMapping", type = Accessor.Type.SETTER)
	public void setLanguageStopWordMapping(final List<SolrStopWordModel> value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(LANGUAGESTOPWORDMAPPING, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.languageSynonymMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the languageSynonymMapping
	 */
	@Accessor(qualifier = "languageSynonymMapping", type = Accessor.Type.SETTER)
	public void setLanguageSynonymMapping(final List<SolrSynonymConfigModel> value)
	{
		setLanguageSynonymMapping(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.languageSynonymMapping</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the languageSynonymMapping
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "languageSynonymMapping", type = Accessor.Type.SETTER)
	public void setLanguageSynonymMapping(final List<SolrSynonymConfigModel> value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(LANGUAGESYNONYMMAPPING, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.listeners</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the listeners
	 */
	@Accessor(qualifier = "listeners", type = Accessor.Type.SETTER)
	public void setListeners(final Collection<String> value)
	{
		getPersistenceContext().setPropertyValue(LISTENERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SolrFacetSearchConfig.name</code> attribute defined at extension <code>solrfacetsearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the name - name of the Config
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.solrIndexConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrIndexConfig
	 */
	@Accessor(qualifier = "solrIndexConfig", type = Accessor.Type.SETTER)
	public void setSolrIndexConfig(final SolrIndexConfigModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRINDEXCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.solrIndexedTypes</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrIndexedTypes
	 */
	@Accessor(qualifier = "solrIndexedTypes", type = Accessor.Type.SETTER)
	public void setSolrIndexedTypes(final List<SolrIndexedTypeModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRINDEXEDTYPES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.solrIndexerCronJob</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrIndexerCronJob
	 */
	@Accessor(qualifier = "solrIndexerCronJob", type = Accessor.Type.SETTER)
	public void setSolrIndexerCronJob(final List<SolrIndexerCronJobModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRINDEXERCRONJOB, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.solrSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrSearchConfig
	 */
	@Accessor(qualifier = "solrSearchConfig", type = Accessor.Type.SETTER)
	public void setSolrSearchConfig(final SolrSearchConfigModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRSEARCHCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.solrServerConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrServerConfig
	 */
	@Accessor(qualifier = "solrServerConfig", type = Accessor.Type.SETTER)
	public void setSolrServerConfig(final SolrServerConfigModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRSERVERCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.solrUpdateStopWordsCronJobs</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrUpdateStopWordsCronJobs
	 */
	@Accessor(qualifier = "solrUpdateStopWordsCronJobs", type = Accessor.Type.SETTER)
	public void setSolrUpdateStopWordsCronJobs(final List<SolrUpdateStopWordsCronJobModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRUPDATESTOPWORDSCRONJOBS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.solrUpdateSynonymsCronJobs</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrUpdateSynonymsCronJobs
	 */
	@Accessor(qualifier = "solrUpdateSynonymsCronJobs", type = Accessor.Type.SETTER)
	public void setSolrUpdateSynonymsCronJobs(final List<SolrUpdateSynonymsCronJobModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRUPDATESYNONYMSCRONJOBS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.solrValueRangeSets</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrValueRangeSets
	 */
	@Accessor(qualifier = "solrValueRangeSets", type = Accessor.Type.SETTER)
	public void setSolrValueRangeSets(final List<SolrValueRangeSetModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRVALUERANGESETS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.StopWords</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the StopWords
	 */
	@Accessor(qualifier = "StopWords", type = Accessor.Type.SETTER)
	public void setStopWords(final List<SolrStopWordModel> value)
	{
		getPersistenceContext().setPropertyValue(STOPWORDS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrFacetSearchConfig.synonyms</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the synonyms
	 */
	@Accessor(qualifier = "synonyms", type = Accessor.Type.SETTER)
	public void setSynonyms(final List<SolrSynonymConfigModel> value)
	{
		getPersistenceContext().setPropertyValue(SYNONYMS, value);
	}
	
}
