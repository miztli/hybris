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
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.enums.IndexerOperationValues;
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexedTypeModel;
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexerQueryParameterModel;
import java.util.List;

/**
 * Generated model class for type SolrIndexerQuery first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrIndexerQueryModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrIndexerQuery";
	
	/**<i>Generated relation code constant for relation <code>SolrIndexedType2SolrIndexerQuery</code> defining source attribute <code>solrIndexedType</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRINDEXEDTYPE2SOLRINDEXERQUERY = "SolrIndexedType2SolrIndexerQuery";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.identifier</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String IDENTIFIER = "identifier";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.type</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String TYPE = "type";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.query</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String QUERY = "query";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.injectLastIndexTime</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INJECTLASTINDEXTIME = "injectLastIndexTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.injectCurrentTime</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INJECTCURRENTTIME = "injectCurrentTime";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.injectCurrentDate</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String INJECTCURRENTDATE = "injectCurrentDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.user</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String USER = "user";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.parameterProvider</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String PARAMETERPROVIDER = "parameterProvider";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.solrIndexedTypePOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXEDTYPEPOS = "solrIndexedTypePOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.solrIndexedType</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXEDTYPE = "solrIndexedType";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQuery.solrIndexerQueryParameters</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXERQUERYPARAMETERS = "solrIndexerQueryParameters";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrIndexerQueryModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrIndexerQueryModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _identifier initial attribute declared by type <code>SolrIndexerQuery</code> at extension <code>solrfacetsearch</code>
	 * @param _query initial attribute declared by type <code>SolrIndexerQuery</code> at extension <code>solrfacetsearch</code>
	 * @param _type initial attribute declared by type <code>SolrIndexerQuery</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrIndexerQueryModel(final String _identifier, final String _query, final IndexerOperationValues _type)
	{
		super();
		setIdentifier(_identifier);
		setQuery(_query);
		setType(_type);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _identifier initial attribute declared by type <code>SolrIndexerQuery</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _query initial attribute declared by type <code>SolrIndexerQuery</code> at extension <code>solrfacetsearch</code>
	 * @param _type initial attribute declared by type <code>SolrIndexerQuery</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrIndexerQueryModel(final String _identifier, final ItemModel _owner, final String _query, final IndexerOperationValues _type)
	{
		super();
		setIdentifier(_identifier);
		setOwner(_owner);
		setQuery(_query);
		setType(_type);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.identifier</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the identifier - id of the query
	 */
	@Accessor(qualifier = "identifier", type = Accessor.Type.GETTER)
	public String getIdentifier()
	{
		return getPersistenceContext().getPropertyValue(IDENTIFIER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.parameterProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the parameterProvider
	 */
	@Accessor(qualifier = "parameterProvider", type = Accessor.Type.GETTER)
	public String getParameterProvider()
	{
		return getPersistenceContext().getPropertyValue(PARAMETERPROVIDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.query</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the query
	 */
	@Accessor(qualifier = "query", type = Accessor.Type.GETTER)
	public String getQuery()
	{
		return getPersistenceContext().getPropertyValue(QUERY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.solrIndexedType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrIndexedType
	 */
	@Accessor(qualifier = "solrIndexedType", type = Accessor.Type.GETTER)
	public SolrIndexedTypeModel getSolrIndexedType()
	{
		return getPersistenceContext().getPropertyValue(SOLRINDEXEDTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.solrIndexerQueryParameters</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the solrIndexerQueryParameters
	 */
	@Accessor(qualifier = "solrIndexerQueryParameters", type = Accessor.Type.GETTER)
	public List<SolrIndexerQueryParameterModel> getSolrIndexerQueryParameters()
	{
		return getPersistenceContext().getPropertyValue(SOLRINDEXERQUERYPARAMETERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.type</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the type - type of operation: full, update or delete
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.GETTER)
	public IndexerOperationValues getType()
	{
		return getPersistenceContext().getPropertyValue(TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.user</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.GETTER)
	public UserModel getUser()
	{
		return getPersistenceContext().getPropertyValue(USER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.injectCurrentDate</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the injectCurrentDate
	 */
	@Accessor(qualifier = "injectCurrentDate", type = Accessor.Type.GETTER)
	public boolean isInjectCurrentDate()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(INJECTCURRENTDATE));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.injectCurrentTime</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the injectCurrentTime
	 */
	@Accessor(qualifier = "injectCurrentTime", type = Accessor.Type.GETTER)
	public boolean isInjectCurrentTime()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(INJECTCURRENTTIME));
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQuery.injectLastIndexTime</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the injectLastIndexTime
	 */
	@Accessor(qualifier = "injectLastIndexTime", type = Accessor.Type.GETTER)
	public boolean isInjectLastIndexTime()
	{
		return toPrimitive((Boolean)getPersistenceContext().getPropertyValue(INJECTLASTINDEXTIME));
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SolrIndexerQuery.identifier</code> attribute defined at extension <code>solrfacetsearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the identifier - id of the query
	 */
	@Accessor(qualifier = "identifier", type = Accessor.Type.SETTER)
	public void setIdentifier(final String value)
	{
		getPersistenceContext().setPropertyValue(IDENTIFIER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQuery.injectCurrentDate</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the injectCurrentDate
	 */
	@Accessor(qualifier = "injectCurrentDate", type = Accessor.Type.SETTER)
	public void setInjectCurrentDate(final boolean value)
	{
		getPersistenceContext().setPropertyValue(INJECTCURRENTDATE, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQuery.injectCurrentTime</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the injectCurrentTime
	 */
	@Accessor(qualifier = "injectCurrentTime", type = Accessor.Type.SETTER)
	public void setInjectCurrentTime(final boolean value)
	{
		getPersistenceContext().setPropertyValue(INJECTCURRENTTIME, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQuery.injectLastIndexTime</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the injectLastIndexTime
	 */
	@Accessor(qualifier = "injectLastIndexTime", type = Accessor.Type.SETTER)
	public void setInjectLastIndexTime(final boolean value)
	{
		getPersistenceContext().setPropertyValue(INJECTLASTINDEXTIME, toObject(value));
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQuery.parameterProvider</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the parameterProvider
	 */
	@Accessor(qualifier = "parameterProvider", type = Accessor.Type.SETTER)
	public void setParameterProvider(final String value)
	{
		getPersistenceContext().setPropertyValue(PARAMETERPROVIDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQuery.query</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the query
	 */
	@Accessor(qualifier = "query", type = Accessor.Type.SETTER)
	public void setQuery(final String value)
	{
		getPersistenceContext().setPropertyValue(QUERY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQuery.solrIndexedType</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrIndexedType
	 */
	@Accessor(qualifier = "solrIndexedType", type = Accessor.Type.SETTER)
	public void setSolrIndexedType(final SolrIndexedTypeModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRINDEXEDTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQuery.solrIndexerQueryParameters</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrIndexerQueryParameters
	 */
	@Accessor(qualifier = "solrIndexerQueryParameters", type = Accessor.Type.SETTER)
	public void setSolrIndexerQueryParameters(final List<SolrIndexerQueryParameterModel> value)
	{
		getPersistenceContext().setPropertyValue(SOLRINDEXERQUERYPARAMETERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>SolrIndexerQuery.type</code> attribute defined at extension <code>solrfacetsearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the type - type of operation: full, update or delete
	 */
	@Accessor(qualifier = "type", type = Accessor.Type.SETTER)
	public void setType(final IndexerOperationValues value)
	{
		getPersistenceContext().setPropertyValue(TYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQuery.user</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.SETTER)
	public void setUser(final UserModel value)
	{
		getPersistenceContext().setPropertyValue(USER, value);
	}
	
}
