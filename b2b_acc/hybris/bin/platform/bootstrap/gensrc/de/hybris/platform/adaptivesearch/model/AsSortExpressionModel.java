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
package de.hybris.platform.adaptivesearch.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.adaptivesearch.enums.AsSortOrder;
import de.hybris.platform.adaptivesearch.model.AbstractAsItemConfigurationModel;
import de.hybris.platform.adaptivesearch.model.AbstractAsSortConfigurationModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type AsSortExpression first defined at extension adaptivesearch.
 */
@SuppressWarnings("all")
public class AsSortExpressionModel extends AbstractAsItemConfigurationModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AsSortExpression";
	
	/**<i>Generated relation code constant for relation <code>AsSortConfiguration2SortExpression</code> defining source attribute <code>sortConfiguration</code> in extension <code>adaptivesearch</code>.</i>*/
	public static final String _ASSORTCONFIGURATION2SORTEXPRESSION = "AsSortConfiguration2SortExpression";
	
	/** <i>Generated constant</i> - Attribute key of <code>AsSortExpression.expression</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String EXPRESSION = "expression";
	
	/** <i>Generated constant</i> - Attribute key of <code>AsSortExpression.order</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String ORDER = "order";
	
	/** <i>Generated constant</i> - Attribute key of <code>AsSortExpression.uniqueIdx</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String UNIQUEIDX = "uniqueIdx";
	
	/** <i>Generated constant</i> - Attribute key of <code>AsSortExpression.sortConfigurationPOS</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String SORTCONFIGURATIONPOS = "sortConfigurationPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>AsSortExpression.sortConfiguration</code> attribute defined at extension <code>adaptivesearch</code>. */
	public static final String SORTCONFIGURATION = "sortConfiguration";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AsSortExpressionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AsSortExpressionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _expression initial attribute declared by type <code>AsSortExpression</code> at extension <code>adaptivesearch</code>
	 * @param _sortConfiguration initial attribute declared by type <code>AsSortExpression</code> at extension <code>adaptivesearch</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _uniqueIdx initial attribute declared by type <code>AsSortExpression</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated
	public AsSortExpressionModel(final String _expression, final AbstractAsSortConfigurationModel _sortConfiguration, final String _uid, final String _uniqueIdx)
	{
		super();
		setExpression(_expression);
		setSortConfiguration(_sortConfiguration);
		setUid(_uid);
		setUniqueIdx(_uniqueIdx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _catalogVersion initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _expression initial attribute declared by type <code>AsSortExpression</code> at extension <code>adaptivesearch</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _sortConfiguration initial attribute declared by type <code>AsSortExpression</code> at extension <code>adaptivesearch</code>
	 * @param _uid initial attribute declared by type <code>AbstractAsConfiguration</code> at extension <code>adaptivesearch</code>
	 * @param _uniqueIdx initial attribute declared by type <code>AsSortExpression</code> at extension <code>adaptivesearch</code>
	 */
	@Deprecated
	public AsSortExpressionModel(final CatalogVersionModel _catalogVersion, final String _expression, final ItemModel _owner, final AbstractAsSortConfigurationModel _sortConfiguration, final String _uid, final String _uniqueIdx)
	{
		super();
		setCatalogVersion(_catalogVersion);
		setExpression(_expression);
		setOwner(_owner);
		setSortConfiguration(_sortConfiguration);
		setUid(_uid);
		setUniqueIdx(_uniqueIdx);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AsSortExpression.expression</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the expression
	 */
	@Accessor(qualifier = "expression", type = Accessor.Type.GETTER)
	public String getExpression()
	{
		return getPersistenceContext().getPropertyValue(EXPRESSION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AsSortExpression.order</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the order
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.GETTER)
	public AsSortOrder getOrder()
	{
		return getPersistenceContext().getPropertyValue(ORDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AsSortExpression.sortConfiguration</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the sortConfiguration
	 */
	@Accessor(qualifier = "sortConfiguration", type = Accessor.Type.GETTER)
	public AbstractAsSortConfigurationModel getSortConfiguration()
	{
		return getPersistenceContext().getPropertyValue(SORTCONFIGURATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AsSortExpression.uniqueIdx</code> attribute defined at extension <code>adaptivesearch</code>. 
	 * @return the uniqueIdx
	 */
	@Accessor(qualifier = "uniqueIdx", type = Accessor.Type.GETTER)
	public String getUniqueIdx()
	{
		return getPersistenceContext().getPropertyValue(UNIQUEIDX);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AsSortExpression.expression</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the expression
	 */
	@Accessor(qualifier = "expression", type = Accessor.Type.SETTER)
	public void setExpression(final String value)
	{
		getPersistenceContext().setPropertyValue(EXPRESSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AsSortExpression.order</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the order
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.SETTER)
	public void setOrder(final AsSortOrder value)
	{
		getPersistenceContext().setPropertyValue(ORDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>AsSortExpression.sortConfiguration</code> attribute defined at extension <code>adaptivesearch</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the sortConfiguration
	 */
	@Accessor(qualifier = "sortConfiguration", type = Accessor.Type.SETTER)
	public void setSortConfiguration(final AbstractAsSortConfigurationModel value)
	{
		getPersistenceContext().setPropertyValue(SORTCONFIGURATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AsSortExpression.uniqueIdx</code> attribute defined at extension <code>adaptivesearch</code>. 
	 *  
	 * @param value the uniqueIdx
	 */
	@Accessor(qualifier = "uniqueIdx", type = Accessor.Type.SETTER)
	public void setUniqueIdx(final String value)
	{
		getPersistenceContext().setPropertyValue(UNIQUEIDX, value);
	}
	
}
