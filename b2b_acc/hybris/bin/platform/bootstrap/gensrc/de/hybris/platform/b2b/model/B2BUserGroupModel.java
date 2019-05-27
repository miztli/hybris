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
package de.hybris.platform.b2b.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2b.model.B2BPermissionModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;

/**
 * Generated model class for type B2BUserGroup first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BUserGroupModel extends UserGroupModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BUserGroup";
	
	/**<i>Generated relation code constant for relation <code>B2BUnit2B2BUserGroups</code> defining source attribute <code>Unit</code> in extension <code>b2bcommerce</code>.</i>*/
	public static final String _B2BUNIT2B2BUSERGROUPS = "B2BUnit2B2BUserGroups";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUserGroup.Unit</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String UNIT = "Unit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUserGroup.Permissions</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String PERMISSIONS = "Permissions";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BUserGroupModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BUserGroupModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BUserGroup</code> at extension <code>b2bcommerce</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BUserGroupModel(final B2BUnitModel _Unit, final String _uid)
	{
		super();
		setUnit(_Unit);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BUserGroup</code> at extension <code>b2bcommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BUserGroupModel(final B2BUnitModel _Unit, final ItemModel _owner, final String _uid)
	{
		super();
		setUnit(_Unit);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUserGroup.Permissions</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Permissions
	 */
	@Accessor(qualifier = "Permissions", type = Accessor.Type.GETTER)
	public List<B2BPermissionModel> getPermissions()
	{
		return getPersistenceContext().getPropertyValue(PERMISSIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUserGroup.Unit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the Unit - The Parent B2BUnit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.GETTER)
	public B2BUnitModel getUnit()
	{
		return getPersistenceContext().getPropertyValue(UNIT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUserGroup.Permissions</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the Permissions
	 */
	@Accessor(qualifier = "Permissions", type = Accessor.Type.SETTER)
	public void setPermissions(final List<B2BPermissionModel> value)
	{
		getPersistenceContext().setPropertyValue(PERMISSIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUserGroup.Unit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the Unit - The Parent B2BUnit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.SETTER)
	public void setUnit(final B2BUnitModel value)
	{
		getPersistenceContext().setPropertyValue(UNIT, value);
	}
	
}
