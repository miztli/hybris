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
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexedPropertyModel;
import java.util.Collection;

/**
 * Generated model class for type SolrSearchConfig first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrSearchConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrSearchConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSearchConfig.pageSize</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String PAGESIZE = "pageSize";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSearchConfig.defaultSortOrder</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String DEFAULTSORTORDER = "defaultSortOrder";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSearchConfig.description</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String DESCRIPTION = "description";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSearchConfig.restrictFieldsInResponse</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String RESTRICTFIELDSINRESPONSE = "restrictFieldsInResponse";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSearchConfig.enableHighlighting</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String ENABLEHIGHLIGHTING = "enableHighlighting";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSearchConfig.allFacetValuesInResponse</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String ALLFACETVALUESINRESPONSE = "allFacetValuesInResponse";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSearchConfig.legacyMode</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LEGACYMODE = "legacyMode";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrSearchConfig.groupingProperty</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String GROUPINGPROPERTY = "groupingProperty";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrSearchConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrSearchConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _pageSize initial attribute declared by type <code>SolrSearchConfig</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrSearchConfigModel(final Integer _pageSize)
	{
		super();
		setPageSize(_pageSize);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _pageSize initial attribute declared by type <code>SolrSearchConfig</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrSearchConfigModel(final ItemModel _owner, final Integer _pageSize)
	{
		super();
		setOwner(_owner);
		setPageSize(_pageSize);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSearchConfig.defaultSortOrder</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the defaultSortOrder
	 */
	@Accessor(qualifier = "defaultSortOrder", type = Accessor.Type.GETTER)
	public Collection<String> getDefaultSortOrder()
	{
		return getPersistenceContext().getPropertyValue(DEFAULTSORTORDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSearchConfig.description</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.GETTER)
	public String getDescription()
	{
		return getPersistenceContext().getPropertyValue(DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSearchConfig.groupingProperty</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the groupingProperty
	 */
	@Accessor(qualifier = "groupingProperty", type = Accessor.Type.GETTER)
	public SolrIndexedPropertyModel getGroupingProperty()
	{
		return getPersistenceContext().getPropertyValue(GROUPINGPROPERTY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSearchConfig.pageSize</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the pageSize
	 */
	@Accessor(qualifier = "pageSize", type = Accessor.Type.GETTER)
	public Integer getPageSize()
	{
		return getPersistenceContext().getPropertyValue(PAGESIZE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSearchConfig.allFacetValuesInResponse</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the allFacetValuesInResponse
	 */
	@Accessor(qualifier = "allFacetValuesInResponse", type = Accessor.Type.GETTER)
	public boolean isAllFacetValuesInResponse()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(ALLFACETVALUESINRESPONSE));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSearchConfig.enableHighlighting</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the enableHighlighting
	 */
	@Accessor(qualifier = "enableHighlighting", type = Accessor.Type.GETTER)
	public boolean isEnableHighlighting()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(ENABLEHIGHLIGHTING));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrSearchConfig.legacyMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>SolrSearchConfig.restrictFieldsInResponse</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the restrictFieldsInResponse
	 */
	@Accessor(qualifier = "restrictFieldsInResponse", type = Accessor.Type.GETTER)
	public boolean isRestrictFieldsInResponse()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(RESTRICTFIELDSINRESPONSE));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSearchConfig.allFacetValuesInResponse</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the allFacetValuesInResponse
	 */
	@Accessor(qualifier = "allFacetValuesInResponse", type = Accessor.Type.SETTER)
	public void setAllFacetValuesInResponse(final boolean value)
	{
		getPersistenceContext().setPropertyValue(ALLFACETVALUESINRESPONSE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSearchConfig.defaultSortOrder</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the defaultSortOrder
	 */
	@Accessor(qualifier = "defaultSortOrder", type = Accessor.Type.SETTER)
	public void setDefaultSortOrder(final Collection<String> value)
	{
		getPersistenceContext().setPropertyValue(DEFAULTSORTORDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSearchConfig.description</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the description
	 */
	@Accessor(qualifier = "description", type = Accessor.Type.SETTER)
	public void setDescription(final String value)
	{
		getPersistenceContext().setPropertyValue(DESCRIPTION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSearchConfig.enableHighlighting</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the enableHighlighting
	 */
	@Accessor(qualifier = "enableHighlighting", type = Accessor.Type.SETTER)
	public void setEnableHighlighting(final boolean value)
	{
		getPersistenceContext().setPropertyValue(ENABLEHIGHLIGHTING, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSearchConfig.groupingProperty</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the groupingProperty
	 */
	@Accessor(qualifier = "groupingProperty", type = Accessor.Type.SETTER)
	public void setGroupingProperty(final SolrIndexedPropertyModel value)
	{
		getPersistenceContext().setPropertyValue(GROUPINGPROPERTY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSearchConfig.legacyMode</code> attribute defined at extension <code>solrfacetsearch</code>. 
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
	 * <i>Generated method</i> - Setter of <code>SolrSearchConfig.pageSize</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the pageSize
	 */
	@Accessor(qualifier = "pageSize", type = Accessor.Type.SETTER)
	public void setPageSize(final Integer value)
	{
		getPersistenceContext().setPropertyValue(PAGESIZE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrSearchConfig.restrictFieldsInResponse</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the restrictFieldsInResponse
	 */
	@Accessor(qualifier = "restrictFieldsInResponse", type = Accessor.Type.SETTER)
	public void setRestrictFieldsInResponse(final boolean value)
	{
		getPersistenceContext().setPropertyValue(RESTRICTFIELDSINRESPONSE, toObject(value));
	}
	
}
