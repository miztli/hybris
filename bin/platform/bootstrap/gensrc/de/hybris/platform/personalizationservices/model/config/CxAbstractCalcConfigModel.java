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
package de.hybris.platform.personalizationservices.model.config;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.personalizationservices.enums.CxUserType;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Set;

/**
 * Generated model class for type CxAbstractCalcConfig first defined at extension personalizationservices.
 */
@SuppressWarnings("all")
public class CxAbstractCalcConfigModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "CxAbstractCalcConfig";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxAbstractCalcConfig.code</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxAbstractCalcConfig.actions</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String ACTIONS = "actions";
	
	/** <i>Generated constant</i> - Attribute key of <code>CxAbstractCalcConfig.userType</code> attribute defined at extension <code>personalizationservices</code>. */
	public static final String USERTYPE = "userType";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CxAbstractCalcConfigModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CxAbstractCalcConfigModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _actions initial attribute declared by type <code>CxAbstractCalcConfig</code> at extension <code>personalizationservices</code>
	 * @param _code initial attribute declared by type <code>CxAbstractCalcConfig</code> at extension <code>personalizationservices</code>
	 */
	@Deprecated
	public CxAbstractCalcConfigModel(final Set<String> _actions, final String _code)
	{
		super();
		setActions(_actions);
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _actions initial attribute declared by type <code>CxAbstractCalcConfig</code> at extension <code>personalizationservices</code>
	 * @param _code initial attribute declared by type <code>CxAbstractCalcConfig</code> at extension <code>personalizationservices</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public CxAbstractCalcConfigModel(final Set<String> _actions, final String _code, final ItemModel _owner)
	{
		super();
		setActions(_actions);
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxAbstractCalcConfig.actions</code> attribute defined at extension <code>personalizationservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the actions - Collection of recalculate actions string representations
	 */
	@Accessor(qualifier = "actions", type = Accessor.Type.GETTER)
	public Set<String> getActions()
	{
		return getPersistenceContext().getPropertyValue(ACTIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxAbstractCalcConfig.code</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the code - Unique identifier
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CxAbstractCalcConfig.userType</code> attribute defined at extension <code>personalizationservices</code>. 
	 * @return the userType - User type for which config is valid
	 */
	@Accessor(qualifier = "userType", type = Accessor.Type.GETTER)
	public CxUserType getUserType()
	{
		return getPersistenceContext().getPropertyValue(USERTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxAbstractCalcConfig.actions</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the actions - Collection of recalculate actions string representations
	 */
	@Accessor(qualifier = "actions", type = Accessor.Type.SETTER)
	public void setActions(final Set<String> value)
	{
		getPersistenceContext().setPropertyValue(ACTIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>CxAbstractCalcConfig.code</code> attribute defined at extension <code>personalizationservices</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the code - Unique identifier
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>CxAbstractCalcConfig.userType</code> attribute defined at extension <code>personalizationservices</code>. 
	 *  
	 * @param value the userType - User type for which config is valid
	 */
	@Accessor(qualifier = "userType", type = Accessor.Type.SETTER)
	public void setUserType(final CxUserType value)
	{
		getPersistenceContext().setPropertyValue(USERTYPE, value);
	}
	
}
