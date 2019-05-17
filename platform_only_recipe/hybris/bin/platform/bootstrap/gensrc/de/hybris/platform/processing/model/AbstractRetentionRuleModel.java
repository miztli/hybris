/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 17, 2019 5:46:53 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.processing.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type AbstractRetentionRule first defined at extension processing.
 */
@SuppressWarnings("all")
public class AbstractRetentionRuleModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "AbstractRetentionRule";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractRetentionRule.code</code> attribute defined at extension <code>processing</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>AbstractRetentionRule.actionReference</code> attribute defined at extension <code>processing</code>. */
	public static final String ACTIONREFERENCE = "actionReference";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public AbstractRetentionRuleModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public AbstractRetentionRuleModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _actionReference initial attribute declared by type <code>AbstractRetentionRule</code> at extension <code>processing</code>
	 * @param _code initial attribute declared by type <code>AbstractRetentionRule</code> at extension <code>processing</code>
	 */
	@Deprecated
	public AbstractRetentionRuleModel(final String _actionReference, final String _code)
	{
		super();
		setActionReference(_actionReference);
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _actionReference initial attribute declared by type <code>AbstractRetentionRule</code> at extension <code>processing</code>
	 * @param _code initial attribute declared by type <code>AbstractRetentionRule</code> at extension <code>processing</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public AbstractRetentionRuleModel(final String _actionReference, final String _code, final ItemModel _owner)
	{
		super();
		setActionReference(_actionReference);
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractRetentionRule.actionReference</code> attribute defined at extension <code>processing</code>. 
	 * @return the actionReference
	 */
	@Accessor(qualifier = "actionReference", type = Accessor.Type.GETTER)
	public String getActionReference()
	{
		return getPersistenceContext().getPropertyValue(ACTIONREFERENCE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractRetentionRule.code</code> attribute defined at extension <code>processing</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractRetentionRule.actionReference</code> attribute defined at extension <code>processing</code>. 
	 *  
	 * @param value the actionReference
	 */
	@Accessor(qualifier = "actionReference", type = Accessor.Type.SETTER)
	public void setActionReference(final String value)
	{
		getPersistenceContext().setPropertyValue(ACTIONREFERENCE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>AbstractRetentionRule.code</code> attribute defined at extension <code>processing</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
}
