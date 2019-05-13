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
import  de.hybris.platform.solrfacetsearch.config.IndexedTypeSort;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.solrfacetsearch.config.IndexOperation;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.IndexedTypeFlexibleSearchQuery;
import de.hybris.platform.solrfacetsearch.config.IndexedTypeSort;
import de.hybris.platform.solrfacetsearch.config.SearchQueryTemplate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public  class IndexedType  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>IndexedType.identifier</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String identifier;

	/** <i>Generated property</i> for <code>IndexedType.indexedProperties</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<String,IndexedProperty> indexedProperties;

	/** <i>Generated property</i> for <code>IndexedType.flexibleSearchQueries</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<IndexOperation,IndexedTypeFlexibleSearchQuery> flexibleSearchQueries;

	/** <i>Generated property</i> for <code>IndexedType.composedType</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private ComposedTypeModel composedType;

	/** <i>Generated property</i> for <code>IndexedType.variant</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean variant;

	/** <i>Generated property</i> for <code>IndexedType.staged</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean staged;

	/** <i>Generated property</i> for <code>IndexedType.identityProvider</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String identityProvider;

	/** <i>Generated property</i> for <code>IndexedType.modelLoader</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String modelLoader;

	/** <i>Generated property</i> for <code>IndexedType.indexName</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String indexName;

	/** <i>Generated property</i> for <code>IndexedType.indexNameFromConfig</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String indexNameFromConfig;

	/** <i>Generated property</i> for <code>IndexedType.typeFacets</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Set<String> typeFacets;

	/** <i>Generated property</i> for <code>IndexedType.defaultFieldValueProvider</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String defaultFieldValueProvider;

	/** <i>Generated property</i> for <code>IndexedType.fieldsValuesProvider</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String fieldsValuesProvider;

	/** <i>Generated property</i> for <code>IndexedType.solrResultConverter</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String solrResultConverter;

	/** <i>Generated property</i> for <code>IndexedType.code</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>IndexedType.uniqueIndexedTypeCode</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String uniqueIndexedTypeCode;

	/** <i>Generated property</i> for <code>IndexedType.group</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean group;

	/** <i>Generated property</i> for <code>IndexedType.groupFieldName</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String groupFieldName;

	/** <i>Generated property</i> for <code>IndexedType.groupLimit</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private int groupLimit;

	/** <i>Generated property</i> for <code>IndexedType.groupFacets</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean groupFacets;

	/** <i>Generated property</i> for <code>IndexedType.listeners</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Collection<String> listeners;

	/** <i>Generated property</i> for <code>IndexedType.configSet</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String configSet;

	/** <i>Generated property</i> for <code>IndexedType.ftsQueryBuilder</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String ftsQueryBuilder;

	/** <i>Generated property</i> for <code>IndexedType.ftsQueryBuilderParameters</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<String,String> ftsQueryBuilderParameters;

	/** <i>Generated property</i> for <code>IndexedType.searchQueryTemplates</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<String,SearchQueryTemplate> searchQueryTemplates;

	/** <i>Generated property</i> for <code>IndexedType.additionalParameters</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<String,String> additionalParameters;

	/** <i>Generated property</i> for <code>IndexedType.sorts</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private List<IndexedTypeSort> sorts;

	/** <i>Generated property</i> for <code>IndexedType.sortsByCode</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Map<String,IndexedTypeSort> sortsByCode;
	
	public IndexedType()
	{
		// default constructor
	}
	
		
	
	public void setIdentifier(final String identifier)
	{
		this.identifier = identifier;
	}

		
	
	public String getIdentifier() 
	{
		return identifier;
	}
	
		
	
	public void setIndexedProperties(final Map<String,IndexedProperty> indexedProperties)
	{
		this.indexedProperties = indexedProperties;
	}

		
	
	public Map<String,IndexedProperty> getIndexedProperties() 
	{
		return indexedProperties;
	}
	
		
	
	public void setFlexibleSearchQueries(final Map<IndexOperation,IndexedTypeFlexibleSearchQuery> flexibleSearchQueries)
	{
		this.flexibleSearchQueries = flexibleSearchQueries;
	}

		
	
	public Map<IndexOperation,IndexedTypeFlexibleSearchQuery> getFlexibleSearchQueries() 
	{
		return flexibleSearchQueries;
	}
	
		
	
	public void setComposedType(final ComposedTypeModel composedType)
	{
		this.composedType = composedType;
	}

		
	
	public ComposedTypeModel getComposedType() 
	{
		return composedType;
	}
	
		
	
	public void setVariant(final boolean variant)
	{
		this.variant = variant;
	}

		
	
	public boolean isVariant() 
	{
		return variant;
	}
	
		
	
	public void setStaged(final boolean staged)
	{
		this.staged = staged;
	}

		
	
	public boolean isStaged() 
	{
		return staged;
	}
	
		
	
	public void setIdentityProvider(final String identityProvider)
	{
		this.identityProvider = identityProvider;
	}

		
	
	public String getIdentityProvider() 
	{
		return identityProvider;
	}
	
		
	
	public void setModelLoader(final String modelLoader)
	{
		this.modelLoader = modelLoader;
	}

		
	
	public String getModelLoader() 
	{
		return modelLoader;
	}
	
		
	
	public void setIndexName(final String indexName)
	{
		this.indexName = indexName;
	}

		
	
	public String getIndexName() 
	{
		return indexName;
	}
	
		
	
	public void setIndexNameFromConfig(final String indexNameFromConfig)
	{
		this.indexNameFromConfig = indexNameFromConfig;
	}

		
	
	public String getIndexNameFromConfig() 
	{
		return indexNameFromConfig;
	}
	
		
	
	public void setTypeFacets(final Set<String> typeFacets)
	{
		this.typeFacets = typeFacets;
	}

		
	
	public Set<String> getTypeFacets() 
	{
		return typeFacets;
	}
	
		
	
	public void setDefaultFieldValueProvider(final String defaultFieldValueProvider)
	{
		this.defaultFieldValueProvider = defaultFieldValueProvider;
	}

		
	
	public String getDefaultFieldValueProvider() 
	{
		return defaultFieldValueProvider;
	}
	
		
	
	public void setFieldsValuesProvider(final String fieldsValuesProvider)
	{
		this.fieldsValuesProvider = fieldsValuesProvider;
	}

		
	
	public String getFieldsValuesProvider() 
	{
		return fieldsValuesProvider;
	}
	
		
	
	public void setSolrResultConverter(final String solrResultConverter)
	{
		this.solrResultConverter = solrResultConverter;
	}

		
	
	public String getSolrResultConverter() 
	{
		return solrResultConverter;
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setUniqueIndexedTypeCode(final String uniqueIndexedTypeCode)
	{
		this.uniqueIndexedTypeCode = uniqueIndexedTypeCode;
	}

		
	
	public String getUniqueIndexedTypeCode() 
	{
		return uniqueIndexedTypeCode;
	}
	
		
	
	public void setGroup(final boolean group)
	{
		this.group = group;
	}

		
	
	public boolean isGroup() 
	{
		return group;
	}
	
		
	
	public void setGroupFieldName(final String groupFieldName)
	{
		this.groupFieldName = groupFieldName;
	}

		
	
	public String getGroupFieldName() 
	{
		return groupFieldName;
	}
	
		
	
	public void setGroupLimit(final int groupLimit)
	{
		this.groupLimit = groupLimit;
	}

		
	
	public int getGroupLimit() 
	{
		return groupLimit;
	}
	
		
	
	public void setGroupFacets(final boolean groupFacets)
	{
		this.groupFacets = groupFacets;
	}

		
	
	public boolean isGroupFacets() 
	{
		return groupFacets;
	}
	
		
	
	public void setListeners(final Collection<String> listeners)
	{
		this.listeners = listeners;
	}

		
	
	public Collection<String> getListeners() 
	{
		return listeners;
	}
	
		
	
	public void setConfigSet(final String configSet)
	{
		this.configSet = configSet;
	}

		
	
	public String getConfigSet() 
	{
		return configSet;
	}
	
		
	
	public void setFtsQueryBuilder(final String ftsQueryBuilder)
	{
		this.ftsQueryBuilder = ftsQueryBuilder;
	}

		
	
	public String getFtsQueryBuilder() 
	{
		return ftsQueryBuilder;
	}
	
		
	
	public void setFtsQueryBuilderParameters(final Map<String,String> ftsQueryBuilderParameters)
	{
		this.ftsQueryBuilderParameters = ftsQueryBuilderParameters;
	}

		
	
	public Map<String,String> getFtsQueryBuilderParameters() 
	{
		return ftsQueryBuilderParameters;
	}
	
		
	
	public void setSearchQueryTemplates(final Map<String,SearchQueryTemplate> searchQueryTemplates)
	{
		this.searchQueryTemplates = searchQueryTemplates;
	}

		
	
	public Map<String,SearchQueryTemplate> getSearchQueryTemplates() 
	{
		return searchQueryTemplates;
	}
	
		
	
	public void setAdditionalParameters(final Map<String,String> additionalParameters)
	{
		this.additionalParameters = additionalParameters;
	}

		
	
	public Map<String,String> getAdditionalParameters() 
	{
		return additionalParameters;
	}
	
		
	
	public void setSorts(final List<IndexedTypeSort> sorts)
	{
		this.sorts = sorts;
	}

		
	
	public List<IndexedTypeSort> getSorts() 
	{
		return sorts;
	}
	
		
	
	public void setSortsByCode(final Map<String,IndexedTypeSort> sortsByCode)
	{
		this.sortsByCode = sortsByCode;
	}

		
	
	public Map<String,IndexedTypeSort> getSortsByCode() 
	{
		return sortsByCode;
	}
	


}
