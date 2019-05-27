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
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.model.config.SolrFacetSearchConfigModel;

/**
 * Generated model class for type SolrSynonymConfig first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrSynonymConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrSynonymConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSynonymConfig.synonymFrom</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SYNONYMFROM = "synonymFrom";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSynonymConfig.synonymTo</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SYNONYMTO = "synonymTo";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSynonymConfig.languagePOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LANGUAGEPOS = "languagePOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSynonymConfig.language</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LANGUAGE = "language";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSynonymConfig.facetSearchConfigPOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FACETSEARCHCONFIGPOS = "facetSearchConfigPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSynonymConfig.facetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FACETSEARCHCONFIG = "facetSearchConfig";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrSynonymConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrSynonymConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _language initial attribute declared by type <code>SolrSynonymConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _synonymFrom initial attribute declared by type <code>SolrSynonymConfig</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrSynonymConfigModel(final LanguageModel _language, final String _synonymFrom)
	{
		super();
		setLanguage(_language);
		setSynonymFrom(_synonymFrom);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _language initial attribute declared by type <code>SolrSynonymConfig</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _synonymFrom initial attribute declared by type <code>SolrSynonymConfig</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrSynonymConfigModel(final LanguageModel _language, final ItemModel _owner, final String _synonymFrom)
	{
		super();
		setLanguage(_language);
		setOwner(_owner);
		setSynonymFrom(_synonymFrom);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSynonymConfig.facetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the facetSearchConfig
	 */
	@Accessor(qualifier = "facetSearchConfig", type = Accessor.Type.GETTER)
	public SolrFacetSearchConfigModel getFacetSearchConfig()
	{
		return getPersistenceContext().getPropertyValue(FACETSEARCHCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSynonymConfig.language</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the language
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.GETTER)
	public LanguageModel getLanguage()
	{
		return getPersistenceContext().getPropertyValue(LANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSynonymConfig.synonymFrom</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the synonymFrom
	 */
	@Accessor(qualifier = "synonymFrom", type = Accessor.Type.GETTER)
	public String getSynonymFrom()
	{
		return getPersistenceContext().getPropertyValue(SYNONYMFROM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSynonymConfig.synonymTo</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the synonymTo
	 */
	@Accessor(qualifier = "synonymTo", type = Accessor.Type.GETTER)
	public String getSynonymTo()
	{
		return getPersistenceContext().getPropertyValue(SYNONYMTO);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSynonymConfig.facetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the facetSearchConfig
	 */
	@Accessor(qualifier = "facetSearchConfig", type = Accessor.Type.SETTER)
	public void setFacetSearchConfig(final SolrFacetSearchConfigModel value)
	{
		getPersistenceContext().setPropertyValue(FACETSEARCHCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSynonymConfig.language</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the language
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.SETTER)
	public void setLanguage(final LanguageModel value)
	{
		getPersistenceContext().setPropertyValue(LANGUAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSynonymConfig.synonymFrom</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the synonymFrom
	 */
	@Accessor(qualifier = "synonymFrom", type = Accessor.Type.SETTER)
	public void setSynonymFrom(final String value)
	{
		getPersistenceContext().setPropertyValue(SYNONYMFROM, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSynonymConfig.synonymTo</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the synonymTo
	 */
	@Accessor(qualifier = "synonymTo", type = Accessor.Type.SETTER)
	public void setSynonymTo(final String value)
	{
		getPersistenceContext().setPropertyValue(SYNONYMTO, value);
	}
	
}
