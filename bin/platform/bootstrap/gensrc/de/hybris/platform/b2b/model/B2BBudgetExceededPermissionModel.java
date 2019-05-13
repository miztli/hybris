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
package de.hybris.platform.b2b.model;

import de.hybris.platform.b2b.model.B2BPermissionModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type B2BBudgetExceededPermission first defined at extension b2bapprovalprocess.
 */
@SuppressWarnings("all")
public class B2BBudgetExceededPermissionModel extends B2BPermissionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BBudgetExceededPermission";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BBudgetExceededPermissionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BBudgetExceededPermissionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _code initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 */
	@Deprecated
	public B2BBudgetExceededPermissionModel(final B2BUnitModel _Unit, final String _code)
	{
		super();
		setUnit(_Unit);
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _code initial attribute declared by type <code>B2BPermission</code> at extension <code>b2bapprovalprocess</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BBudgetExceededPermissionModel(final B2BUnitModel _Unit, final String _code, final ItemModel _owner)
	{
		super();
		setUnit(_Unit);
		setCode(_code);
		setOwner(_owner);
	}
	
	
}
