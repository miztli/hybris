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
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.model.SolrSearchQueryTemplateModel;
import de.hybris.platform.solrfacetsearch.model.SolrSortModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrFacetSearchConfigModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexedPropertyModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexerQueryModel;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Generated model class for type SolrIndexedType first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrIndexedTypeModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrIndexedType";
	
	/**<i>Generated relation code constant for relation <code>SolrFacetSearchConfig2SolrIndexedType</code> defining source attribute <code>solrFacetSearchConfig</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRFACETSEARCHCONFIG2SOLRINDEXEDTYPE = "SolrFacetSearchConfig2SolrIndexedType";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.identifier</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String IDENTIFIER = "identifier";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.type</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String TYPE = "type";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.variant</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String VARIANT = "variant";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.identityProvider</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String IDENTITYPROVIDER = "identityProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.modelLoader</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String MODELLOADER = "modelLoader";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.defaultFieldValueProvider</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String DEFAULTFIELDVALUEPROVIDER = "defaultFieldValueProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.valuesProvider</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String VALUESPROVIDER = "valuesProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.indexName</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXNAME = "indexName";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.solrResultConverter</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRRESULTCONVERTER = "solrResultConverter";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.group</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String GROUP = "group";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.groupFieldName</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String GROUPFIELDNAME = "groupFieldName";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.groupLimit</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String GROUPLIMIT = "groupLimit";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.groupFacets</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String GROUPFACETS = "groupFacets";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.listeners</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LISTENERS = "listeners";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.configSet</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String CONFIGSET = "configSet";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.ftsQueryBuilder</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSQUERYBUILDER = "ftsQueryBuilder";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.ftsQueryBuilderParameters</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSQUERYBUILDERPARAMETERS = "ftsQueryBuilderParameters";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.additionalParameters</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String ADDITIONALPARAMETERS = "additionalParameters";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.solrIndexerQueries</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXERQUERIES = "solrIndexerQueries";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.solrIndexedProperties</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXEDPROPERTIES = "solrIndexedProperties";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.solrFacetSearchConfigPOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRFACETSEARCHCONFIGPOS = "solrFacetSearchConfigPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.solrFacetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRFACETSEARCHCONFIG = "solrFacetSearchConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.searchQueryTemplates</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SEARCHQUERYTEMPLATES = "searchQueryTemplates";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedType.sorts</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SORTS = "sorts";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrIndexedTypeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrIndexedTypeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _identifier initial attribute declared by type <code>SolrIndexedType</code> at extension <code>solrfacetsearch</code>
	 * @param _type initial attribute declared by type <code>SolrIndexedType</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrIndexedTypeModel(final String _identifier, final ComposedTypeModel _type)
	{
		super();
		setIdentifier(_identifier);
		setType(_type);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _identifier initial attribute declared by type <code>SolrIndexedType</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _type initial attribute declared by type <code>SolrIndexedType</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrIndexedTypeModel(final String _identifier, final ItemModel _owner, final ComposedTypeModel _type)
	{
		super();
		setIdentifier(_identifier);
		setOwner(_owner);
		setType(_type);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.additionalParameters</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the additionalParameters - additional parameters of indexed type
	 */
	@Accessor(qualifier = "additionalParameters", type = Accessor.Type.GETTER)
	public Map<String,String> getAdditionalParameters()
	{
		return getPersistenceContext().getPropertyValue(ADDITIONALPARAMETERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.configSet</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the configSet - configSet defining configuration for core in solr
	 */
	@Accessor(qualifier = "configSet", type = Accessor.Type.GETTER)
	public String getConfigSet()
	{
		return getPersistenceContext().getPropertyValue(CONFIGSET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.defaultFieldValueProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the defaultFieldValueProvider - default fieldValueProvider to be used by the indexed properties
	 */
	@Accessor(qualifier = "defaultFieldValueProvider", type = Accessor.Type.GETTER)
	public String getDefaultFieldValueProvider()
	{
		return getPersistenceContext().getPropertyValue(DEFAULTFIELDVALUEPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.ftsQueryBuilder</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsQueryBuilder
	 */
	@Accessor(qualifier = "ftsQueryBuilder", type = Accessor.Type.GETTER)
	public String getFtsQueryBuilder()
	{
		return getPersistenceContext().getPropertyValue(FTSQUERYBUILDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.ftsQueryBuilderParameters</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsQueryBuilderParameters
	 */
	@Accessor(qualifier = "ftsQueryBuilderParameters", type = Accessor.Type.GETTER)
	public Map<String,String> getFtsQueryBuilderParameters()
	{
		return getPersistenceContext().getPropertyValue(FTSQUERYBUILDERPARAMETERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.groupFieldName</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the groupFieldName
	 */
	@Accessor(qualifier = "groupFieldName", type = Accessor.Type.GETTER)
	public String getGroupFieldName()
	{
		return getPersistenceContext().getPropertyValue(GROUPFIELDNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.groupLimit</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the groupLimit
	 */
	@Accessor(qualifier = "groupLimit", type = Accessor.Type.GETTER)
	public Integer getGroupLimit()
	{
		return getPersistenceContext().getPropertyValue(GROUPLIMIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.identifier</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the identifier - name of the Indexed Type
	 */
	@Accessor(qualifier = "identifier", type = Accessor.Type.GETTER)
	public String getIdentifier()
	{
		return getPersistenceContext().getPropertyValue(IDENTIFIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.identityProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the identityProvider
	 */
	@Accessor(qualifier = "identityProvider", type = Accessor.Type.GETTER)
	public String getIdentityProvider()
	{
		return getPersistenceContext().getPropertyValue(IDENTITYPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.indexName</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexName
	 */
	@Accessor(qualifier = "indexName", type = Accessor.Type.GETTER)
	public String getIndexName()
	{
		return getPersistenceContext().getPropertyValue(INDEXNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.listeners</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the listeners
	 */
	@Accessor(qualifier = "listeners", type = Accessor.Type.GETTER)
	public Collection<String> getListeners()
	{
		return getPersistenceContext().getPropertyValue(LISTENERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.modelLoader</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the modelLoader
	 */
	@Accessor(qualifier = "modelLoader", type = Accessor.Type.GETTER)
	public String getModelLoader()
	{
		return getPersistenceContext().getPropertyValue(MODELLOADER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.searchQueryTemplates</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the searchQueryTemplates
	 */
	@Accessor(qualifier = "searchQueryTemplates", type = Accessor.Type.GETTER)
	public Collection<SolrSearchQueryTemplateModel> getSearchQueryTemplates()
	{
		return getPersistenceContext().getPropertyValue(SEARCHQUERYTEMPLATES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.solrFacetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrFacetSearchConfig
	 */
	@Accessor(qualifier = "solrFacetSearchConfig", type = Accessor.Type.GETTER)
	public SolrFacetSearchConfigModel getSolrFacetSearchConfig()
	{
		return getPersistenceContext().getPropertyValue(SOLRFACETSEARCHCONFIG);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.solrIndexedProperties</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrIndexedProperties
	 */
	@Accessor(qualifier = "solrIndexedProperties", type = Accessor.Type.GETTER)
	public List<SolrIndexedPropertyModel> getSolrIndexedProperties()
	{
		return getPersistenceContext().getPropertyValue(SOLRINDEXEDPROPERTIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.solrIndexerQueries</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrIndexerQueries
	 */
	@Accessor(qualifier = "solrIndexerQueries", type = Accessor.Type.GETTER)
	public List<SolrIndexerQueryModel> getSolrIndexerQueries()
	{
		return getPersistenceContext().getPropertyValue(SOLRINDEXERQUERIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.solrResultConverter</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrResultConverter
	 */
	@Accessor(qualifier = "solrResultConverter", type = Accessor.Type.GETTER)
	public String getSolrResultConverter()
	{
		return getPersistenceContext().getPropertyValue(SOLRRESULTCONVERTER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.sorts</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the sorts
	 */
	@Accessor(qualifier = "sorts", type = Accessor.Type.GETTER)
	public List<SolrSortModel> getSorts()
	{
		return getPersistenceContext().getPropertyValue(SORTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.type</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the type - enclosing type of the Indexed Type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public ComposedTypeModel getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.valuesProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the valuesProvider
	 */
	@Accessor(qualifier = "valuesProvider", type = Accessor.Type.GETTER)
	public String getValuesProvider()
	{
		return getPersistenceContext().getPropertyValue(VALUESPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.group</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the group
	 */
	@Accessor(qualifier = "group", type = Accessor.Type.GETTER)
	public boolean isGroup()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(GROUP));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.groupFacets</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the groupFacets
	 */
	@Accessor(qualifier = "groupFacets", type = Accessor.Type.GETTER)
	public boolean isGroupFacets()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(GROUPFACETS));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedType.variant</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the variant
	 */
	@Accessor(qualifier = "variant", type = Accessor.Type.GETTER)
	public boolean isVariant()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(VARIANT));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.additionalParameters</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the additionalParameters - additional parameters of indexed type
	 */
	@Accessor(qualifier = "additionalParameters", type = Accessor.Type.SETTER)
	public void setAdditionalParameters(final Map<String,String> value)
	{
		getPersistenceContext().setPropertyValue(ADDITIONALPARAMETERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.configSet</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the configSet - configSet defining configuration for core in solr
	 */
	@Accessor(qualifier = "configSet", type = Accessor.Type.SETTER)
	public void setConfigSet(final String value)
	{
		getPersistenceContext().setPropertyValue(CONFIGSET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.defaultFieldValueProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the defaultFieldValueProvider - default fieldValueProvider to be used by the indexed properties
	 */
	@Accessor(qualifier = "defaultFieldValueProvider", type = Accessor.Type.SETTER)
	public void setDefaultFieldValueProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(DEFAULTFIELDVALUEPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.ftsQueryBuilder</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsQueryBuilder
	 */
	@Accessor(qualifier = "ftsQueryBuilder", type = Accessor.Type.SETTER)
	public void setFtsQueryBuilder(final String value)
	{
		getPersistenceContext().setPropertyValue(FTSQUERYBUILDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.ftsQueryBuilderParameters</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsQueryBuilderParameters
	 */
	@Accessor(qualifier = "ftsQueryBuilderParameters", type = Accessor.Type.SETTER)
	public void setFtsQueryBuilderParameters(final Map<String,String> value)
	{
		getPersistenceContext().setPropertyValue(FTSQUERYBUILDERPARAMETERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.group</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the group
	 */
	@Accessor(qualifier = "group", type = Accessor.Type.SETTER)
	public void setGroup(final boolean value)
	{
		getPersistenceContext().setPropertyValue(GROUP, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.groupFacets</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the groupFacets
	 */
	@Accessor(qualifier = "groupFacets", type = Accessor.Type.SETTER)
	public void setGroupFacets(final boolean value)
	{
		getPersistenceContext().setPropertyValue(GROUPFACETS, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.groupFieldName</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the groupFieldName
	 */
	@Accessor(qualifier = "groupFieldName", type = Accessor.Type.SETTER)
	public void setGroupFieldName(final String value)
	{
		getPersistenceContext().setPropertyValue(GROUPFIELDNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.groupLimit</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the groupLimit
	 */
	@Accessor(qualifier = "groupLimit", type = Accessor.Type.SETTER)
	public void setGroupLimit(final Integer value)
	{
		getPersistenceContext().setPropertyValue(GROUPLIMIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SolrIndexedType.identifier</code> attribute defined at extension <code>solrfacetsearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the identifier - name of the Indexed Type
	 */
	@Accessor(qualifier = "identifier", type = Accessor.Type.SETTER)
	public void setIdentifier(final String value)
	{
		getPersistenceContext().setPropertyValue(IDENTIFIER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.identityProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the identityProvider
	 */
	@Accessor(qualifier = "identityProvider", type = Accessor.Type.SETTER)
	public void setIdentityProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(IDENTITYPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.indexName</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexName
	 */
	@Accessor(qualifier = "indexName", type = Accessor.Type.SETTER)
	public void setIndexName(final String value)
	{
		getPersistenceContext().setPropertyValue(INDEXNAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.listeners</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the listeners
	 */
	@Accessor(qualifier = "listeners", type = Accessor.Type.SETTER)
	public void setListeners(final Collection<String> value)
	{
		getPersistenceContext().setPropertyValue(LISTENERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.modelLoader</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the modelLoader
	 */
	@Accessor(qualifier = "modelLoader", type = Accessor.Type.SETTER)
	public void setModelLoader(final String value)
	{
		getPersistenceContext().setPropertyValue(MODELLOADER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.searchQueryTemplates</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the searchQueryTemplates
	 */
	@Accessor(qualifier = "searchQueryTemplates", type = Accessor.Type.SETTER)
	public void setSearchQueryTemplates(final Collection<SolrSearchQueryTemplateModel> value)
	{
		getPersistenceContext().setPropertyValue(SEARCHQUERYTEMPLATES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.solrFacetSearchConfig</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrFacetSearchConfig
	 */
	@Accessor(qualifier = "solrFacetSearchConfig", type = Accessor.Type.SETTER)
	public void setSolrFacetSearchConfig(final SolrFacetSearchConfigModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRFACETSEARCHCONFIG, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.solrIndexedProperties</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrIndexedProperties
	 */
	@Accessor(qualifier = "solrIndexedProperties", type = Accessor.Type.SETTER)
	public void setSolrIndexedProperties(final List<SolrIndexedPropertyModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRINDEXEDPROPERTIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.solrIndexerQueries</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrIndexerQueries
	 */
	@Accessor(qualifier = "solrIndexerQueries", type = Accessor.Type.SETTER)
	public void setSolrIndexerQueries(final List<SolrIndexerQueryModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRINDEXERQUERIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.solrResultConverter</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrResultConverter
	 */
	@Accessor(qualifier = "solrResultConverter", type = Accessor.Type.SETTER)
	public void setSolrResultConverter(final String value)
	{
		getPersistenceContext().setPropertyValue(SOLRRESULTCONVERTER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.sorts</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the sorts
	 */
	@Accessor(qualifier = "sorts", type = Accessor.Type.SETTER)
	public void setSorts(final List<SolrSortModel> value)
	{
		getPersistenceContext().setPropertyValue(SORTS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.type</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the type - enclosing type of the Indexed Type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final ComposedTypeModel value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.valuesProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the valuesProvider
	 */
	@Accessor(qualifier = "valuesProvider", type = Accessor.Type.SETTER)
	public void setValuesProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(VALUESPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedType.variant</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the variant
	 */
	@Accessor(qualifier = "variant", type = Accessor.Type.SETTER)
	public void setVariant(final boolean value)
	{
		getPersistenceContext().setPropertyValue(VARIANT, toObject(value));
	}
	
}
