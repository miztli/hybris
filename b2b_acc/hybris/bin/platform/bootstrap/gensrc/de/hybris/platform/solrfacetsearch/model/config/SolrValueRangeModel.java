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
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.solrfacetsearch.model.config.SolrValueRangeSetModel;

/**
 * Generated model class for type SolrValueRange first defined at extension solrfacetsearch.
 */
@SuppressWarnings("all")
public class SolrValueRangeModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "SolrValueRange";
	
	/**<i>Generated relation code constant for relation <code>SolrValueRangeSet2SolrValueRangeRelation</code> defining source attribute <code>solrValueRangeSet</code> in extension <code>solrfacetsearch</code>.</i>*/
	public static final String _SOLRVALUERANGESET2SOLRVALUERANGERELATION = "SolrValueRangeSet2SolrValueRangeRelation";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRange.name</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRange.from</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String FROM = "from";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRange.to</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String TO = "to";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRange.solrValueRangeSetPOS</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRVALUERANGESETPOS = "solrValueRangeSetPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>SolrValueRange.solrValueRangeSet</code> attribute defined at extension <code>solrfacetsearch</code>. */
	public static final String SOLRVALUERANGESET = "solrValueRangeSet";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SolrValueRangeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SolrValueRangeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _from initial attribute declared by type <code>SolrValueRange</code> at extension <code>solrfacetsearch</code>
	 * @param _name initial attribute declared by type <code>SolrValueRange</code> at extension <code>solrfacetsearch</code>
	 * @param _solrValueRangeSet initial attribute declared by type <code>SolrValueRange</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrValueRangeModel(final String _from, final String _name, final SolrValueRangeSetModel _solrValueRangeSet)
	{
		super();
		setFrom(_from);
		setName(_name);
		setSolrValueRangeSet(_solrValueRangeSet);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _from initial attribute declared by type <code>SolrValueRange</code> at extension <code>solrfacetsearch</code>
	 * @param _name initial attribute declared by type <code>SolrValueRange</code> at extension <code>solrfacetsearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _solrValueRangeSet initial attribute declared by type <code>SolrValueRange</code> at extension <code>solrfacetsearch</code>
	 */
	@Deprecated
	public SolrValueRangeModel(final String _from, final String _name, final ItemModel _owner, final SolrValueRangeSetModel _solrValueRangeSet)
	{
		super();
		setFrom(_from);
		setName(_name);
		setOwner(_owner);
		setSolrValueRangeSet(_solrValueRangeSet);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRange.from</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the from
	 */
	@Accessor(qualifier = "from", type = Accessor.Type.GETTER)
	public String getFrom()
	{
		return getPersistenceContext().getPropertyValue(FROM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRange.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getPersistenceContext().getPropertyValue(NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRange.solrValueRangeSet</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the solrValueRangeSet
	 */
	@Accessor(qualifier = "solrValueRangeSet", type = Accessor.Type.GETTER)
	public SolrValueRangeSetModel getSolrValueRangeSet()
	{
		return getPersistenceContext().getPropertyValue(SOLRVALUERANGESET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SolrValueRange.to</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 * @return the to
	 */
	@Accessor(qualifier = "to", type = Accessor.Type.GETTER)
	public String getTo()
	{
		return getPersistenceContext().getPropertyValue(TO);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRange.from</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the from
	 */
	@Accessor(qualifier = "from", type = Accessor.Type.SETTER)
	public void setFrom(final String value)
	{
		getPersistenceContext().setPropertyValue(FROM, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRange.name</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		getPersistenceContext().setPropertyValue(NAME, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRange.solrValueRangeSet</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the solrValueRangeSet
	 */
	@Accessor(qualifier = "solrValueRangeSet", type = Accessor.Type.SETTER)
	public void setSolrValueRangeSet(final SolrValueRangeSetModel value)
	{
		getPersistenceContext().setPropertyValue(SOLRVALUERANGESET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>SolrValueRange.to</code> attribute defined at extension <code>solrfacetsearch</code>. 
	 *  
	 * @param value the to
	 */
	@Accessor(qualifier = "to", type = Accessor.Type.SETTER)
	public void setTo(final String value)
	{
		getPersistenceContext().setPropertyValue(TO, value);
	}
	
}
