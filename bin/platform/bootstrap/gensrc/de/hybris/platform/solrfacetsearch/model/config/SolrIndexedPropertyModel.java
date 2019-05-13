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
import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.commerceservices.enums.SolrIndexedPropertyFacetSort;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.enums.SolrIndexedPropertyFacetType;
import de.hybris.platform.solrfacetsearch.enums.SolrPropertiesTypes;
import de.hybris.platform.solrfacetsearch.enums.SolrWildcardType;
import de.hybris.platform.solrfacetsearch.model.SolrSearchQueryPropertyModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexedTypeModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrValueRangeSetModel;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Generated model class for type SolrIndexedProperty first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrIndexedPropertyModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrIndexedProperty";
	
	/**<i>Generated relation code constant for relation <code>SolrIndexedType2SolrIndexedProperty</code> defining source attribute <code>solrIndexedType</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRINDEXEDTYPE2SOLRINDEXEDPROPERTY = "SolrIndexedType2SolrIndexedProperty";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.name</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.displayName</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String DISPLAYNAME = "displayName";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.type</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String TYPE = "type";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.sortableType</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SORTABLETYPE = "sortableType";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.facet</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FACET = "facet";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.localized</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String LOCALIZED = "localized";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.currency</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.multiValue</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String MULTIVALUE = "multiValue";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.rangeSet</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String RANGESET = "rangeSet";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.facetDisplayNameProvider</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FACETDISPLAYNAMEPROVIDER = "facetDisplayNameProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.facetType</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FACETTYPE = "facetType";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.fieldValueProvider</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FIELDVALUEPROVIDER = "fieldValueProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.valueProviderParameter</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String VALUEPROVIDERPARAMETER = "valueProviderParameter";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.valueProviderParameters</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String VALUEPROVIDERPARAMETERS = "valueProviderParameters";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.exportId</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String EXPORTID = "exportId";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.useForSpellchecking</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String USEFORSPELLCHECKING = "useForSpellchecking";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.useForAutocomplete</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String USEFORAUTOCOMPLETE = "useForAutocomplete";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.priority</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String PRIORITY = "priority";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.includeInResponse</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INCLUDEINRESPONSE = "includeInResponse";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.useForHighlighting</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String USEFORHIGHLIGHTING = "useForHighlighting";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.customFacetSortProvider</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String CUSTOMFACETSORTPROVIDER = "customFacetSortProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.topValuesProvider</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String TOPVALUESPROVIDER = "topValuesProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsQuery</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSQUERY = "ftsQuery";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsQueryMinTermLength</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSQUERYMINTERMLENGTH = "ftsQueryMinTermLength";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSQUERYBOOST = "ftsQueryBoost";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsFuzzyQuery</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSFUZZYQUERY = "ftsFuzzyQuery";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsFuzzyQueryMinTermLength</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSFUZZYQUERYMINTERMLENGTH = "ftsFuzzyQueryMinTermLength";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsFuzzyQueryFuzziness</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSFUZZYQUERYFUZZINESS = "ftsFuzzyQueryFuzziness";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsFuzzyQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSFUZZYQUERYBOOST = "ftsFuzzyQueryBoost";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsWildcardQuery</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSWILDCARDQUERY = "ftsWildcardQuery";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsWildcardQueryMinTermLength</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSWILDCARDQUERYMINTERMLENGTH = "ftsWildcardQueryMinTermLength";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsWildcardQueryType</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSWILDCARDQUERYTYPE = "ftsWildcardQueryType";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsWildcardQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSWILDCARDQUERYBOOST = "ftsWildcardQueryBoost";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsPhraseQuery</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSPHRASEQUERY = "ftsPhraseQuery";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsPhraseQuerySlop</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSPHRASEQUERYSLOP = "ftsPhraseQuerySlop";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.ftsPhraseQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FTSPHRASEQUERYBOOST = "ftsPhraseQueryBoost";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.classAttributeAssignment</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String CLASSATTRIBUTEASSIGNMENT = "classAttributeAssignment";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.categoryField</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String CATEGORYFIELD = "categoryField";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.visible</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String VISIBLE = "visible";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.solrIndexedTypePOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXEDTYPEPOS = "solrIndexedTypePOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.solrIndexedType</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXEDTYPE = "solrIndexedType";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.rangeSets</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String RANGESETS = "rangeSets";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.searchQueryProperties</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SEARCHQUERYPROPERTIES = "searchQueryProperties";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.facetSort</code> attribute defined at extension <code>commerceservices</code>. */
	public static final String FACETSORT = "facetSort";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexedProperty.backofficeDisplayName</code> attribute defined at extension <code>backofficesolrsearch</code>. */
	public static final String BACKOFFICEDISPLAYNAME = "backofficeDisplayName";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrIndexedPropertyModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrIndexedPropertyModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _name initial attribute declared by type <code>SolrIndexedProperty</code> at extension <code>solrfacetsearch</code>
	 * @param _type initial attribute declared by type <code>SolrIndexedProperty</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrIndexedPropertyModel(final String _name, final SolrPropertiesTypes _type)
	{
		super();
		setName(_name);
		setType(_type);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _name initial attribute declared by type <code>SolrIndexedProperty</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _type initial attribute declared by type <code>SolrIndexedProperty</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrIndexedPropertyModel(final String _name, final ItemModel _owner, final SolrPropertiesTypes _type)
	{
		super();
		setName(_name);
		setOwner(_owner);
		setType(_type);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.backofficeDisplayName</code> attribute defined at extension <code>backofficesolrsearch</code>. 
	 * @return the backofficeDisplayName - The display name for this property in the list of backoffice facets.
	 */
	@Accessor(qualifier = "backofficeDisplayName", type = Accessor.Type.GETTER)
	public String getBackofficeDisplayName()
	{
		return getBackofficeDisplayName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.backofficeDisplayName</code> attribute defined at extension <code>backofficesolrsearch</code>. 
	 * @param loc the value localization key 
	 * @return the backofficeDisplayName - The display name for this property in the list of backoffice facets.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "backofficeDisplayName", type = Accessor.Type.GETTER)
	public String getBackofficeDisplayName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(BACKOFFICEDISPLAYNAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.classAttributeAssignment</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the classAttributeAssignment - The classification system category feature for this property.
	 */
	@Accessor(qualifier = "classAttributeAssignment", type = Accessor.Type.GETTER)
	public ClassAttributeAssignmentModel getClassAttributeAssignment()
	{
		return getPersistenceContext().getPropertyValue(CLASSATTRIBUTEASSIGNMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.customFacetSortProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the customFacetSortProvider - The custom sort provider for the facet values, only used if facetSort is set to Custom.
	 */
	@Accessor(qualifier = "customFacetSortProvider", type = Accessor.Type.GETTER)
	public String getCustomFacetSortProvider()
	{
		return getPersistenceContext().getPropertyValue(CUSTOMFACETSORTPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.displayName</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the displayName - The display name for this property in the list of facet.
	 */
	@Accessor(qualifier = "displayName", type = Accessor.Type.GETTER)
	public String getDisplayName()
	{
		return getDisplayName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.displayName</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @param loc the value localization key 
	 * @return the displayName - The display name for this property in the list of facet.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "displayName", type = Accessor.Type.GETTER)
	public String getDisplayName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(DISPLAYNAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.exportId</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the exportId - exportId used by this property
	 */
	@Accessor(qualifier = "exportId", type = Accessor.Type.GETTER)
	public String getExportId()
	{
		return getPersistenceContext().getPropertyValue(EXPORTID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.facetDisplayNameProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the facetDisplayNameProvider - facetDisplayNameProvider used by this property
	 */
	@Accessor(qualifier = "facetDisplayNameProvider", type = Accessor.Type.GETTER)
	public String getFacetDisplayNameProvider()
	{
		return getPersistenceContext().getPropertyValue(FACETDISPLAYNAMEPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.facetSort</code> attribute defined at extension <code>commerceservices</code>. 
	 * @return the facetSort - Deprecated - please use custom sort providers. The sort option to use to order the
	 * 							facet values.
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "facetSort", type = Accessor.Type.GETTER)
	public SolrIndexedPropertyFacetSort getFacetSort()
	{
		return getPersistenceContext().getPropertyValue(FACETSORT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.facetType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the facetType - The facet type, if this is a facet property.
	 */
	@Accessor(qualifier = "facetType", type = Accessor.Type.GETTER)
	public SolrIndexedPropertyFacetType getFacetType()
	{
		return getPersistenceContext().getPropertyValue(FACETTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.fieldValueProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the fieldValueProvider - fieldValueProvider used by this property
	 */
	@Accessor(qualifier = "fieldValueProvider", type = Accessor.Type.GETTER)
	public String getFieldValueProvider()
	{
		return getPersistenceContext().getPropertyValue(FIELDVALUEPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsFuzzyQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsFuzzyQueryBoost
	 */
	@Accessor(qualifier = "ftsFuzzyQueryBoost", type = Accessor.Type.GETTER)
	public Float getFtsFuzzyQueryBoost()
	{
		return getPersistenceContext().getPropertyValue(FTSFUZZYQUERYBOOST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsFuzzyQueryFuzziness</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsFuzzyQueryFuzziness
	 */
	@Accessor(qualifier = "ftsFuzzyQueryFuzziness", type = Accessor.Type.GETTER)
	public Integer getFtsFuzzyQueryFuzziness()
	{
		return getPersistenceContext().getPropertyValue(FTSFUZZYQUERYFUZZINESS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsFuzzyQueryMinTermLength</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsFuzzyQueryMinTermLength
	 */
	@Accessor(qualifier = "ftsFuzzyQueryMinTermLength", type = Accessor.Type.GETTER)
	public Integer getFtsFuzzyQueryMinTermLength()
	{
		return getPersistenceContext().getPropertyValue(FTSFUZZYQUERYMINTERMLENGTH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsPhraseQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsPhraseQueryBoost
	 */
	@Accessor(qualifier = "ftsPhraseQueryBoost", type = Accessor.Type.GETTER)
	public Float getFtsPhraseQueryBoost()
	{
		return getPersistenceContext().getPropertyValue(FTSPHRASEQUERYBOOST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsPhraseQuerySlop</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsPhraseQuerySlop
	 */
	@Accessor(qualifier = "ftsPhraseQuerySlop", type = Accessor.Type.GETTER)
	public Float getFtsPhraseQuerySlop()
	{
		return getPersistenceContext().getPropertyValue(FTSPHRASEQUERYSLOP);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsQueryBoost
	 */
	@Accessor(qualifier = "ftsQueryBoost", type = Accessor.Type.GETTER)
	public Float getFtsQueryBoost()
	{
		return getPersistenceContext().getPropertyValue(FTSQUERYBOOST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsQueryMinTermLength</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsQueryMinTermLength
	 */
	@Accessor(qualifier = "ftsQueryMinTermLength", type = Accessor.Type.GETTER)
	public Integer getFtsQueryMinTermLength()
	{
		return getPersistenceContext().getPropertyValue(FTSQUERYMINTERMLENGTH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsWildcardQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsWildcardQueryBoost
	 */
	@Accessor(qualifier = "ftsWildcardQueryBoost", type = Accessor.Type.GETTER)
	public Float getFtsWildcardQueryBoost()
	{
		return getPersistenceContext().getPropertyValue(FTSWILDCARDQUERYBOOST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsWildcardQueryMinTermLength</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsWildcardQueryMinTermLength
	 */
	@Accessor(qualifier = "ftsWildcardQueryMinTermLength", type = Accessor.Type.GETTER)
	public Integer getFtsWildcardQueryMinTermLength()
	{
		return getPersistenceContext().getPropertyValue(FTSWILDCARDQUERYMINTERMLENGTH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsWildcardQueryType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsWildcardQueryType
	 */
	@Accessor(qualifier = "ftsWildcardQueryType", type = Accessor.Type.GETTER)
	public SolrWildcardType getFtsWildcardQueryType()
	{
		return getPersistenceContext().getPropertyValue(FTSWILDCARDQUERYTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the name - name of the property
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.priority</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the priority - The ordering of this property in the list of facets. Higher number ordered first.
	 */
	@Accessor(qualifier = "priority", type = Accessor.Type.GETTER)
	public int getPriority()
	{
		return toPrimitive((Integer)getPersistenceContext().getPropertyValue(PRIORITY));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.rangeSet</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the rangeSet - range set used by this property
	 */
	@Accessor(qualifier = "rangeSet", type = Accessor.Type.GETTER)
	public SolrValueRangeSetModel getRangeSet()
	{
		return getPersistenceContext().getPropertyValue(RANGESET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.rangeSets</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the rangeSets
	 */
	@Accessor(qualifier = "rangeSets", type = Accessor.Type.GETTER)
	public List<SolrValueRangeSetModel> getRangeSets()
	{
		return getPersistenceContext().getPropertyValue(RANGESETS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.searchQueryProperties</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the searchQueryProperties
	 */
	@Accessor(qualifier = "searchQueryProperties", type = Accessor.Type.GETTER)
	public Collection<SolrSearchQueryPropertyModel> getSearchQueryProperties()
	{
		return getPersistenceContext().getPropertyValue(SEARCHQUERYPROPERTIES);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.solrIndexedType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrIndexedType
	 */
	@Accessor(qualifier = "solrIndexedType", type = Accessor.Type.GETTER)
	public SolrIndexedTypeModel getSolrIndexedType()
	{
		return getPersistenceContext().getPropertyValue(SOLRINDEXEDTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.sortableType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the sortableType - sortable type of the property
	 */
	@Accessor(qualifier = "sortableType", type = Accessor.Type.GETTER)
	public SolrPropertiesTypes getSortableType()
	{
		return getPersistenceContext().getPropertyValue(SORTABLETYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.topValuesProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the topValuesProvider - topValuesProvider used by this property
	 */
	@Accessor(qualifier = "topValuesProvider", type = Accessor.Type.GETTER)
	public String getTopValuesProvider()
	{
		return getPersistenceContext().getPropertyValue(TOPVALUESPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.type</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the type - type of the property
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public SolrPropertiesTypes getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.useForAutocomplete</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the useForAutocomplete - Determines if this property will be part of for solr's auto-complete dictionary
	 */
	@Accessor(qualifier = "useForAutocomplete", type = Accessor.Type.GETTER)
	public Boolean getUseForAutocomplete()
	{
		return getPersistenceContext().getPropertyValue(USEFORAUTOCOMPLETE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.useForHighlighting</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the useForHighlighting - Determines if this property will be used for highlighting search term
	 */
	@Accessor(qualifier = "useForHighlighting", type = Accessor.Type.GETTER)
	public Boolean getUseForHighlighting()
	{
		return getPersistenceContext().getPropertyValue(USEFORHIGHLIGHTING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.useForSpellchecking</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the useForSpellchecking - Determines if this property will be part of for solr's spell checking dictionary
	 */
	@Accessor(qualifier = "useForSpellchecking", type = Accessor.Type.GETTER)
	public Boolean getUseForSpellchecking()
	{
		return getPersistenceContext().getPropertyValue(USEFORSPELLCHECKING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.valueProviderParameter</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the valueProviderParameter - Parameter for Field Value Provider (used e.g. by springELvalueProvider)
	 */
	@Accessor(qualifier = "valueProviderParameter", type = Accessor.Type.GETTER)
	public String getValueProviderParameter()
	{
		return getPersistenceContext().getPropertyValue(VALUEPROVIDERPARAMETER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.valueProviderParameters</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the valueProviderParameters
	 */
	@Accessor(qualifier = "valueProviderParameters", type = Accessor.Type.GETTER)
	public Map<String,String> getValueProviderParameters()
	{
		return getPersistenceContext().getPropertyValue(VALUEPROVIDERPARAMETERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.categoryField</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the categoryField - True if this is a category field.
	 */
	@Accessor(qualifier = "categoryField", type = Accessor.Type.GETTER)
	public boolean isCategoryField()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(CATEGORYFIELD));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.currency</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public boolean isCurrency()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(CURRENCY));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.facet</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the facet
	 */
	@Accessor(qualifier = "facet", type = Accessor.Type.GETTER)
	public boolean isFacet()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(FACET));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsFuzzyQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsFuzzyQuery
	 */
	@Accessor(qualifier = "ftsFuzzyQuery", type = Accessor.Type.GETTER)
	public boolean isFtsFuzzyQuery()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(FTSFUZZYQUERY));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsPhraseQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsPhraseQuery
	 */
	@Accessor(qualifier = "ftsPhraseQuery", type = Accessor.Type.GETTER)
	public boolean isFtsPhraseQuery()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(FTSPHRASEQUERY));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsQuery
	 */
	@Accessor(qualifier = "ftsQuery", type = Accessor.Type.GETTER)
	public boolean isFtsQuery()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(FTSQUERY));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.ftsWildcardQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the ftsWildcardQuery
	 */
	@Accessor(qualifier = "ftsWildcardQuery", type = Accessor.Type.GETTER)
	public boolean isFtsWildcardQuery()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(FTSWILDCARDQUERY));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.includeInResponse</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the includeInResponse
	 */
	@Accessor(qualifier = "includeInResponse", type = Accessor.Type.GETTER)
	public boolean isIncludeInResponse()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(INCLUDEINRESPONSE));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.localized</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the localized
	 */
	@Accessor(qualifier = "localized", type = Accessor.Type.GETTER)
	public boolean isLocalized()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(LOCALIZED));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.multiValue</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the multiValue
	 */
	@Accessor(qualifier = "multiValue", type = Accessor.Type.GETTER)
	public boolean isMultiValue()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(MULTIVALUE));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexedProperty.visible</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the visible - This property is used to define whether a facet should be visible for frontend users or not.
	 */
	@Accessor(qualifier = "visible", type = Accessor.Type.GETTER)
	public boolean isVisible()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(VISIBLE));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.backofficeDisplayName</code> attribute defined at extension <code>backofficesolrsearch</code>. 
	 *  
	 * @param value the backofficeDisplayName - The display name for this property in the list of backoffice facets.
	 */
	@Accessor(qualifier = "backofficeDisplayName", type = Accessor.Type.SETTER)
	public void setBackofficeDisplayName(final String value)
	{
		setBackofficeDisplayName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.backofficeDisplayName</code> attribute defined at extension <code>backofficesolrsearch</code>. 
	 *  
	 * @param value the backofficeDisplayName - The display name for this property in the list of backoffice facets.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "backofficeDisplayName", type = Accessor.Type.SETTER)
	public void setBackofficeDisplayName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(BACKOFFICEDISPLAYNAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.categoryField</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the categoryField - True if this is a category field.
	 */
	@Accessor(qualifier = "categoryField", type = Accessor.Type.SETTER)
	public void setCategoryField(final boolean value)
	{
		getPersistenceContext().setPropertyValue(CATEGORYFIELD, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.classAttributeAssignment</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the classAttributeAssignment - The classification system category feature for this property.
	 */
	@Accessor(qualifier = "classAttributeAssignment", type = Accessor.Type.SETTER)
	public void setClassAttributeAssignment(final ClassAttributeAssignmentModel value)
	{
		getPersistenceContext().setPropertyValue(CLASSATTRIBUTEASSIGNMENT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.currency</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final boolean value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.customFacetSortProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the customFacetSortProvider - The custom sort provider for the facet values, only used if facetSort is set to Custom.
	 */
	@Accessor(qualifier = "customFacetSortProvider", type = Accessor.Type.SETTER)
	public void setCustomFacetSortProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(CUSTOMFACETSORTPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.displayName</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the displayName - The display name for this property in the list of facet.
	 */
	@Accessor(qualifier = "displayName", type = Accessor.Type.SETTER)
	public void setDisplayName(final String value)
	{
		setDisplayName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.displayName</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the displayName - The display name for this property in the list of facet.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "displayName", type = Accessor.Type.SETTER)
	public void setDisplayName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(DISPLAYNAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.exportId</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the exportId - exportId used by this property
	 */
	@Accessor(qualifier = "exportId", type = Accessor.Type.SETTER)
	public void setExportId(final String value)
	{
		getPersistenceContext().setPropertyValue(EXPORTID, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.facet</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the facet
	 */
	@Accessor(qualifier = "facet", type = Accessor.Type.SETTER)
	public void setFacet(final boolean value)
	{
		getPersistenceContext().setPropertyValue(FACET, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.facetDisplayNameProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the facetDisplayNameProvider - facetDisplayNameProvider used by this property
	 */
	@Accessor(qualifier = "facetDisplayNameProvider", type = Accessor.Type.SETTER)
	public void setFacetDisplayNameProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(FACETDISPLAYNAMEPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.facetSort</code> attribute defined at extension <code>commerceservices</code>. 
	 *  
	 * @param value the facetSort - Deprecated - please use custom sort providers. The sort option to use to order the
	 * 							facet values.
	 * @deprecated
	 */
	@Deprecated
	@Accessor(qualifier = "facetSort", type = Accessor.Type.SETTER)
	public void setFacetSort(final SolrIndexedPropertyFacetSort value)
	{
		getPersistenceContext().setPropertyValue(FACETSORT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.facetType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the facetType - The facet type, if this is a facet property.
	 */
	@Accessor(qualifier = "facetType", type = Accessor.Type.SETTER)
	public void setFacetType(final SolrIndexedPropertyFacetType value)
	{
		getPersistenceContext().setPropertyValue(FACETTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.fieldValueProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the fieldValueProvider - fieldValueProvider used by this property
	 */
	@Accessor(qualifier = "fieldValueProvider", type = Accessor.Type.SETTER)
	public void setFieldValueProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(FIELDVALUEPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsFuzzyQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsFuzzyQuery
	 */
	@Accessor(qualifier = "ftsFuzzyQuery", type = Accessor.Type.SETTER)
	public void setFtsFuzzyQuery(final boolean value)
	{
		getPersistenceContext().setPropertyValue(FTSFUZZYQUERY, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsFuzzyQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsFuzzyQueryBoost
	 */
	@Accessor(qualifier = "ftsFuzzyQueryBoost", type = Accessor.Type.SETTER)
	public void setFtsFuzzyQueryBoost(final Float value)
	{
		getPersistenceContext().setPropertyValue(FTSFUZZYQUERYBOOST, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsFuzzyQueryFuzziness</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsFuzzyQueryFuzziness
	 */
	@Accessor(qualifier = "ftsFuzzyQueryFuzziness", type = Accessor.Type.SETTER)
	public void setFtsFuzzyQueryFuzziness(final Integer value)
	{
		getPersistenceContext().setPropertyValue(FTSFUZZYQUERYFUZZINESS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsFuzzyQueryMinTermLength</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsFuzzyQueryMinTermLength
	 */
	@Accessor(qualifier = "ftsFuzzyQueryMinTermLength", type = Accessor.Type.SETTER)
	public void setFtsFuzzyQueryMinTermLength(final Integer value)
	{
		getPersistenceContext().setPropertyValue(FTSFUZZYQUERYMINTERMLENGTH, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsPhraseQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsPhraseQuery
	 */
	@Accessor(qualifier = "ftsPhraseQuery", type = Accessor.Type.SETTER)
	public void setFtsPhraseQuery(final boolean value)
	{
		getPersistenceContext().setPropertyValue(FTSPHRASEQUERY, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsPhraseQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsPhraseQueryBoost
	 */
	@Accessor(qualifier = "ftsPhraseQueryBoost", type = Accessor.Type.SETTER)
	public void setFtsPhraseQueryBoost(final Float value)
	{
		getPersistenceContext().setPropertyValue(FTSPHRASEQUERYBOOST, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsPhraseQuerySlop</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsPhraseQuerySlop
	 */
	@Accessor(qualifier = "ftsPhraseQuerySlop", type = Accessor.Type.SETTER)
	public void setFtsPhraseQuerySlop(final Float value)
	{
		getPersistenceContext().setPropertyValue(FTSPHRASEQUERYSLOP, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsQuery
	 */
	@Accessor(qualifier = "ftsQuery", type = Accessor.Type.SETTER)
	public void setFtsQuery(final boolean value)
	{
		getPersistenceContext().setPropertyValue(FTSQUERY, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsQueryBoost
	 */
	@Accessor(qualifier = "ftsQueryBoost", type = Accessor.Type.SETTER)
	public void setFtsQueryBoost(final Float value)
	{
		getPersistenceContext().setPropertyValue(FTSQUERYBOOST, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsQueryMinTermLength</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsQueryMinTermLength
	 */
	@Accessor(qualifier = "ftsQueryMinTermLength", type = Accessor.Type.SETTER)
	public void setFtsQueryMinTermLength(final Integer value)
	{
		getPersistenceContext().setPropertyValue(FTSQUERYMINTERMLENGTH, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsWildcardQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsWildcardQuery
	 */
	@Accessor(qualifier = "ftsWildcardQuery", type = Accessor.Type.SETTER)
	public void setFtsWildcardQuery(final boolean value)
	{
		getPersistenceContext().setPropertyValue(FTSWILDCARDQUERY, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsWildcardQueryBoost</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsWildcardQueryBoost
	 */
	@Accessor(qualifier = "ftsWildcardQueryBoost", type = Accessor.Type.SETTER)
	public void setFtsWildcardQueryBoost(final Float value)
	{
		getPersistenceContext().setPropertyValue(FTSWILDCARDQUERYBOOST, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsWildcardQueryMinTermLength</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsWildcardQueryMinTermLength
	 */
	@Accessor(qualifier = "ftsWildcardQueryMinTermLength", type = Accessor.Type.SETTER)
	public void setFtsWildcardQueryMinTermLength(final Integer value)
	{
		getPersistenceContext().setPropertyValue(FTSWILDCARDQUERYMINTERMLENGTH, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.ftsWildcardQueryType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the ftsWildcardQueryType
	 */
	@Accessor(qualifier = "ftsWildcardQueryType", type = Accessor.Type.SETTER)
	public void setFtsWildcardQueryType(final SolrWildcardType value)
	{
		getPersistenceContext().setPropertyValue(FTSWILDCARDQUERYTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.includeInResponse</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the includeInResponse
	 */
	@Accessor(qualifier = "includeInResponse", type = Accessor.Type.SETTER)
	public void setIncludeInResponse(final boolean value)
	{
		getPersistenceContext().setPropertyValue(INCLUDEINRESPONSE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.localized</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the localized
	 */
	@Accessor(qualifier = "localized", type = Accessor.Type.SETTER)
	public void setLocalized(final boolean value)
	{
		getPersistenceContext().setPropertyValue(LOCALIZED, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.multiValue</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the multiValue
	 */
	@Accessor(qualifier = "multiValue", type = Accessor.Type.SETTER)
	public void setMultiValue(final boolean value)
	{
		getPersistenceContext().setPropertyValue(MULTIVALUE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SolrIndexedProperty.name</code> attribute defined at extension <code>solrfacetsearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the name - name of the property
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.priority</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the priority - The ordering of this property in the list of facets. Higher number ordered first.
	 */
	@Accessor(qualifier = "priority", type = Accessor.Type.SETTER)
	public void setPriority(final int value)
	{
		getPersistenceContext().setPropertyValue(PRIORITY, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.rangeSet</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the rangeSet - range set used by this property
	 */
	@Accessor(qualifier = "rangeSet", type = Accessor.Type.SETTER)
	public void setRangeSet(final SolrValueRangeSetModel value)
	{
		getPersistenceContext().setPropertyValue(RANGESET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.rangeSets</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the rangeSets
	 */
	@Accessor(qualifier = "rangeSets", type = Accessor.Type.SETTER)
	public void setRangeSets(final List<SolrValueRangeSetModel> value)
	{
		getPersistenceContext().setPropertyValue(RANGESETS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.searchQueryProperties</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the searchQueryProperties
	 */
	@Accessor(qualifier = "searchQueryProperties", type = Accessor.Type.SETTER)
	public void setSearchQueryProperties(final Collection<SolrSearchQueryPropertyModel> value)
	{
		getPersistenceContext().setPropertyValue(SEARCHQUERYPROPERTIES, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.solrIndexedType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrIndexedType
	 */
	@Accessor(qualifier = "solrIndexedType", type = Accessor.Type.SETTER)
	public void setSolrIndexedType(final SolrIndexedTypeModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRINDEXEDTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.sortableType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the sortableType - sortable type of the property
	 */
	@Accessor(qualifier = "sortableType", type = Accessor.Type.SETTER)
	public void setSortableType(final SolrPropertiesTypes value)
	{
		getPersistenceContext().setPropertyValue(SORTABLETYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.topValuesProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the topValuesProvider - topValuesProvider used by this property
	 */
	@Accessor(qualifier = "topValuesProvider", type = Accessor.Type.SETTER)
	public void setTopValuesProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(TOPVALUESPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.type</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the type - type of the property
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final SolrPropertiesTypes value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.useForAutocomplete</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the useForAutocomplete - Determines if this property will be part of for solr's auto-complete dictionary
	 */
	@Accessor(qualifier = "useForAutocomplete", type = Accessor.Type.SETTER)
	public void setUseForAutocomplete(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(USEFORAUTOCOMPLETE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.useForHighlighting</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the useForHighlighting - Determines if this property will be used for highlighting search term
	 */
	@Accessor(qualifier = "useForHighlighting", type = Accessor.Type.SETTER)
	public void setUseForHighlighting(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(USEFORHIGHLIGHTING, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.useForSpellchecking</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the useForSpellchecking - Determines if this property will be part of for solr's spell checking dictionary
	 */
	@Accessor(qualifier = "useForSpellchecking", type = Accessor.Type.SETTER)
	public void setUseForSpellchecking(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(USEFORSPELLCHECKING, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.valueProviderParameter</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the valueProviderParameter - Parameter for Field Value Provider (used e.g. by springELvalueProvider)
	 */
	@Accessor(qualifier = "valueProviderParameter", type = Accessor.Type.SETTER)
	public void setValueProviderParameter(final String value)
	{
		getPersistenceContext().setPropertyValue(VALUEPROVIDERPARAMETER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.valueProviderParameters</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the valueProviderParameters
	 */
	@Accessor(qualifier = "valueProviderParameters", type = Accessor.Type.SETTER)
	public void setValueProviderParameters(final Map<String,String> value)
	{
		getPersistenceContext().setPropertyValue(VALUEPROVIDERPARAMETERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexedProperty.visible</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the visible - This property is used to define whether a facet should be visible for frontend users or not.
	 */
	@Accessor(qualifier = "visible", type = Accessor.Type.SETTER)
	public void setVisible(final boolean value)
	{
		getPersistenceContext().setPropertyValue(VISIBLE, toObject(value));
	}
	
}
