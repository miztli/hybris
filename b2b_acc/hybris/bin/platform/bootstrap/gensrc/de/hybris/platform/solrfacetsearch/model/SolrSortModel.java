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
package de.hybris.platform.solrfacetsearch.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.model.SolrSortFieldModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexedTypeModel;
import java.util.List;
import java.util.Locale;

/**
 * Generated model class for type SolrSort first defined at extension solrfacetsearch.
 * <p>
 * Extending SolrSort type with additional attributes.
 */
@SuppressWarnings("all")
public class SolrSortModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrSort";
	
	/**<i>Generated relation code constant for relation <code>SolrIndexedType2SolrSortRel</code> defining source attribute <code>indexedType</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRINDEXEDTYPE2SOLRSORTREL = "SolrIndexedType2SolrSortRel";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSort.code</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSort.name</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSort.useBoost</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String USEBOOST = "useBoost";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSort.indexedTypePOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXEDTYPEPOS = "indexedTypePOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSort.indexedType</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXEDTYPE = "indexedType";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSort.fields</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FIELDS = "fields";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrSortModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrSortModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>SolrSort</code> at extension <code>solrfacetsearch</code>
	 * @param _indexedType initial attribute declared by type <code>SolrSort</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrSortModel(final String _code, final SolrIndexedTypeModel _indexedType)
	{
		super();
		setCode(_code);
		setIndexedType(_indexedType);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>SolrSort</code> at extension <code>solrfacetsearch</code>
	 * @param _indexedType initial attribute declared by type <code>SolrSort</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public SolrSortModel(final String _code, final SolrIndexedTypeModel _indexedType, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setIndexedType(_indexedType);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSort.code</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the code - The unique code used to identify the solr sort.
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSort.fields</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the fields
	 */
	@Accessor(qualifier = "fields", type = Accessor.Type.GETTER)
	public List<SolrSortFieldModel> getFields()
	{
		return getPersistenceContext().getPropertyValue(FIELDS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSort.indexedType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the indexedType
	 */
	@Accessor(qualifier = "indexedType", type = Accessor.Type.GETTER)
	public SolrIndexedTypeModel getIndexedType()
	{
		return getPersistenceContext().getPropertyValue(INDEXEDTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSort.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the name - The display name for this sort.
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSort.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @param loc the value localization key 
	 * @return the name - The display name for this sort.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSort.useBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the useBoost - The property specifies whether a sort should apply SOLR boost rules.
	 */
	@Accessor(qualifier = "useBoost", type = Accessor.Type.GETTER)
	public boolean isUseBoost()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(USEBOOST));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSort.code</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the code - The unique code used to identify the solr sort.
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSort.fields</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the fields
	 */
	@Accessor(qualifier = "fields", type = Accessor.Type.SETTER)
	public void setFields(final List<SolrSortFieldModel> value)
	{
		getPersistenceContext().setPropertyValue(FIELDS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSort.indexedType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexedType
	 */
	@Accessor(qualifier = "indexedType", type = Accessor.Type.SETTER)
	public void setIndexedType(final SolrIndexedTypeModel value)
	{
		getPersistenceContext().setPropertyValue(INDEXEDTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSort.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the name - The display name for this sort.
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSort.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the name - The display name for this sort.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSort.useBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the useBoost - The property specifies whether a sort should apply SOLR boost rules.
	 */
	@Accessor(qualifier = "useBoost", type = Accessor.Type.SETTER)
	public void setUseBoost(final boolean value)
	{
		getPersistenceContext().setPropertyValue(USEBOOST, toObject(value));
	}
	
}
