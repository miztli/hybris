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
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.model.config.SolrFacetSearchConfigModel;

/**
 * Generated model class for type SolrStopWord first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrStopWordModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrStopWord";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrStopWord.StopWord</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String STOPWORD = "StopWord";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrStopWord.languagePOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LANGUAGEPOS = "languagePOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrStopWord.language</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LANGUAGE = "language";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrStopWord.facetSearchConfigPOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FACETSEARCHCONFIGPOS = "facetSearchConfigPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrStopWord.facetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FACETSEARCHCONFIG = "facetSearchConfig";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrStopWordModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrStopWordModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _StopWord initial attribute declared by type <code>SolrStopWord</code> at extension <code>solrfacetsearch</code>
	 * @param _language initial attribute declared by type <code>SolrStopWord</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrStopWordModel(final String _StopWord, final LanguageModel _language)
	{
		super();
		setStopWord(_StopWord);
		setLanguage(_language);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _StopWord initial attribute declared by type <code>SolrStopWord</code> at extension <code>solrfacetsearch</code>
	 * @param _language initial attribute declared by type <code>SolrStopWord</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public SolrStopWordModel(final String _StopWord, final LanguageModel _language, final ItemModel _owner)
	{
		super();
		setStopWord(_StopWord);
		setLanguage(_language);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrStopWord.facetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the facetSearchConfig
	 */
	@Accessor(qualifier = "facetSearchConfig", type = Accessor.Type.GETTER)
	public SolrFacetSearchConfigModel getFacetSearchConfig()
	{
		return getPersistenceContext().getPropertyValue(FACETSEARCHCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrStopWord.language</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the language
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.GETTER)
	public LanguageModel getLanguage()
	{
		return getPersistenceContext().getPropertyValue(LANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrStopWord.StopWord</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the StopWord
	 */
	@Accessor(qualifier = "StopWord", type = Accessor.Type.GETTER)
	public String getStopWord()
	{
		return getPersistenceContext().getPropertyValue(STOPWORD);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrStopWord.facetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the facetSearchConfig
	 */
	@Accessor(qualifier = "facetSearchConfig", type = Accessor.Type.SETTER)
	public void setFacetSearchConfig(final SolrFacetSearchConfigModel value)
	{
		getPersistenceContext().setPropertyValue(FACETSEARCHCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrStopWord.language</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the language
	 */
	@Accessor(qualifier = "language", type = Accessor.Type.SETTER)
	public void setLanguage(final LanguageModel value)
	{
		getPersistenceContext().setPropertyValue(LANGUAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrStopWord.StopWord</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the StopWord
	 */
	@Accessor(qualifier = "StopWord", type = Accessor.Type.SETTER)
	public void setStopWord(final String value)
	{
		getPersistenceContext().setPropertyValue(STOPWORD, value);
	}
	
}
