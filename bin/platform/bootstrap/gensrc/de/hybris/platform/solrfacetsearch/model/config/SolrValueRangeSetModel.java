/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 10, 2019 3:20:53 PM                     ---
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
import de.hybris.platform.solrfacetsearch.model.config.SolrFacetSearchConfigModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexedPropertyModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrValueRangeModel;
import java.util.List;

/**
 * Generated model class for type SolrValueRangeSet first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrValueRangeSetModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrValueRangeSet";
	
	/**<i>Generated relation code constant for relation <code>SolrFacetSearchConfig2SolrValueRangeSetRelation</code> defining source attribute <code>facetSearchConfigs</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRFACETSEARCHCONFIG2SOLRVALUERANGESETRELATION = "SolrFacetSearchConfig2SolrValueRangeSetRelation";
	
	/**<i>Generated relation code constant for relation <code>SolrIndexedProperty2SolrValueRangeSetRelation</code> defining source attribute <code>indexedProperties</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRINDEXEDPROPERTY2SOLRVALUERANGESETRELATION = "SolrIndexedProperty2SolrValueRangeSetRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRangeSet.name</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRangeSet.type</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String TYPE = "type";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRangeSet.qualifier</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String QUALIFIER = "qualifier";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRangeSet.facetSearchConfigs</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FACETSEARCHCONFIGS = "facetSearchConfigs";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRangeSet.solrValueRanges</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRVALUERANGES = "solrValueRanges";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRangeSet.indexedProperties</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INDEXEDPROPERTIES = "indexedProperties";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrValueRangeSetModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrValueRangeSetModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _name initial attribute declared by type <code>SolrValueRangeSet</code> at extension <code>solrfacetsearch</code>
	 * @param _type initial attribute declared by type <code>SolrValueRangeSet</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrValueRangeSetModel(final String _name, final String _type)
	{
		super();
		setName(_name);
		setType(_type);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _name initial attribute declared by type <code>SolrValueRangeSet</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _type initial attribute declared by type <code>SolrValueRangeSet</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrValueRangeSetModel(final String _name, final ItemModel _owner, final String _type)
	{
		super();
		setName(_name);
		setOwner(_owner);
		setType(_type);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRangeSet.facetSearchConfigs</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the facetSearchConfigs
	 */
	@Accessor(qualifier = "facetSearchConfigs", type = Accessor.Type.GETTER)
	public List<SolrFacetSearchConfigModel> getFacetSearchConfigs()
	{
		return getPersistenceContext().getPropertyValue(FACETSEARCHCONFIGS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRangeSet.indexedProperties</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the indexedProperties
	 */
	@Accessor(qualifier = "indexedProperties", type = Accessor.Type.GETTER)
	public List<SolrIndexedPropertyModel> getIndexedProperties()
	{
		return getPersistenceContext().getPropertyValue(INDEXEDPROPERTIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRangeSet.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRangeSet.qualifier</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the qualifier
	 */
	@Accessor(qualifier = "qualifier", type = Accessor.Type.GETTER)
	public String getQualifier()
	{
		return getPersistenceContext().getPropertyValue(QUALIFIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRangeSet.solrValueRanges</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrValueRanges
	 */
	@Accessor(qualifier = "solrValueRanges", type = Accessor.Type.GETTER)
	public List<SolrValueRangeModel> getSolrValueRanges()
	{
		return getPersistenceContext().getPropertyValue(SOLRVALUERANGES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRangeSet.type</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public String getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRangeSet.facetSearchConfigs</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the facetSearchConfigs
	 */
	@Accessor(qualifier = "facetSearchConfigs", type = Accessor.Type.SETTER)
	public void setFacetSearchConfigs(final List<SolrFacetSearchConfigModel> value)
	{
		getPersistenceContext().setPropertyValue(FACETSEARCHCONFIGS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRangeSet.indexedProperties</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the indexedProperties
	 */
	@Accessor(qualifier = "indexedProperties", type = Accessor.Type.SETTER)
	public void setIndexedProperties(final List<SolrIndexedPropertyModel> value)
	{
		getPersistenceContext().setPropertyValue(INDEXEDPROPERTIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRangeSet.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRangeSet.qualifier</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the qualifier
	 */
	@Accessor(qualifier = "qualifier", type = Accessor.Type.SETTER)
	public void setQualifier(final String value)
	{
		getPersistenceContext().setPropertyValue(QUALIFIER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRangeSet.solrValueRanges</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrValueRanges
	 */
	@Accessor(qualifier = "solrValueRanges", type = Accessor.Type.SETTER)
	public void setSolrValueRanges(final List<SolrValueRangeModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRVALUERANGES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRangeSet.type</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the type
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final String value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
}
