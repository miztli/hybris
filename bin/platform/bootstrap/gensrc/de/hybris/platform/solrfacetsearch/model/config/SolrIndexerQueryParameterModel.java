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
import de.hybris.platform.solrfacetsearch.model.config.SolrIndexerQueryModel;

/**
 * Generated model class for type SolrIndexerQueryParameter first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrIndexerQueryParameterModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrIndexerQueryParameter";
	
	/**<i>Generated relation code constant for relation <code>SolrIndexerQuery2SolrIndexerQueryParameter</code> defining source attribute <code>solrIndexerQuery</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRINDEXERQUERY2SOLRINDEXERQUERYPARAMETER = "SolrIndexerQuery2SolrIndexerQueryParameter";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQueryParameter.name</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQueryParameter.value</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String VALUE = "value";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQueryParameter.solrIndexerQueryPOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXERQUERYPOS = "solrIndexerQueryPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrIndexerQueryParameter.solrIndexerQuery</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRINDEXERQUERY = "solrIndexerQuery";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrIndexerQueryParameterModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrIndexerQueryParameterModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _name initial attribute declared by type <code>SolrIndexerQueryParameter</code> at extension <code>solrfacetsearch</code>
	 * @param _value initial attribute declared by type <code>SolrIndexerQueryParameter</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrIndexerQueryParameterModel(final String _name, final String _value)
	{
		super();
		setName(_name);
		setValue(_value);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _name initial attribute declared by type <code>SolrIndexerQueryParameter</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _value initial attribute declared by type <code>SolrIndexerQueryParameter</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrIndexerQueryParameterModel(final String _name, final ItemModel _owner, final String _value)
	{
		super();
		setName(_name);
		setOwner(_owner);
		setValue(_value);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQueryParameter.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the name - name of the parameter
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQueryParameter.solrIndexerQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrIndexerQuery
	 */
	@Accessor(qualifier = "solrIndexerQuery", type = Accessor.Type.GETTER)
	public SolrIndexerQueryModel getSolrIndexerQuery()
	{
		return getPersistenceContext().getPropertyValue(SOLRINDEXERQUERY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrIndexerQueryParameter.value</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the value - value of the parameter
	 */
	@Accessor(qualifier = "value", type = Accessor.Type.GETTER)
	public String getValue()
	{
		return getPersistenceContext().getPropertyValue(VALUE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQueryParameter.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the name - name of the parameter
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQueryParameter.solrIndexerQuery</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrIndexerQuery
	 */
	@Accessor(qualifier = "solrIndexerQuery", type = Accessor.Type.SETTER)
	public void setSolrIndexerQuery(final SolrIndexerQueryModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRINDEXERQUERY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrIndexerQueryParameter.value</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the value - value of the parameter
	 */
	@Accessor(qualifier = "value", type = Accessor.Type.SETTER)
	public void setValue(final String value)
	{
		getPersistenceContext().setPropertyValue(VALUE, value);
	}
	
}
