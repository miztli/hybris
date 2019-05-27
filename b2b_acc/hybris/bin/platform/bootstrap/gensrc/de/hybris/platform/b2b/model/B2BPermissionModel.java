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
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.b2b.model.B2BUserGroupModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * Generated model class for type B2BPermission first defined at extension b2bapprovalprocess.
 */
@SuppressWarnings("all")
public class B2BPermissionModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BPermission";
	
	/**<i>Generated relation code constant for relation <code>B2BUserGroups2B2BPermissions</code> defining source attribute <code>UserGroups</code> in extension <code>b2bapprovalprocess</code>.</i>*/
	public static final String _B2BUSERGROUPS2B2BPERMISSIONS = "B2BUserGroups2B2BPermissions";
	
	/**<i>Generated relation code constant for relation <code>B2BUnit2B2BPermissions</code> defining source attribute <code>Unit</code> in extension <code>b2bapprovalprocess</code>.</i>*/
	public static final String _B2BUNIT2B2BPERMISSIONS = "B2BUnit2B2BPermissions";
	
	/**<i>Generated relation code constant for relation <code>B2BCustomer2B2BPermissions</code> defining source attribute <code>Customers</code> in extension <code>b2bapprovalprocess</code>.</i>*/
	public static final String _B2BCUSTOMER2B2BPERMISSIONS = "B2BCustomer2B2BPermissions";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermission.code</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermission.active</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String ACTIVE = "active";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermission.message</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String MESSAGE = "message";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermission.UserGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String USERGROUPS = "UserGroups";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermission.UnitPOS</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String UNITPOS = "UnitPOS";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermission.Unit</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String UNIT = "Unit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BPermission.Customers</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String CUSTOMERS = "Customers";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BPermissionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BPermissionModel(final ItemModelContext ctx)
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
	public B2BPermissionModel(final B2BUnitModel _Unit, final String _code)
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
	public B2BPermissionModel(final B2BUnitModel _Unit, final String _code, final ItemModel _owner)
	{
		super();
		setUnit(_Unit);
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermission.active</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.GETTER)
	public Boolean getActive()
	{
		return getPersistenceContext().getPropertyValue(ACTIVE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermission.code</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermission.Customers</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Customers
	 */
	@Accessor(qualifier = "Customers", type = Accessor.Type.GETTER)
	public Collection<B2BCustomerModel> getCustomers()
	{
		return getPersistenceContext().getPropertyValue(CUSTOMERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermission.message</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the message
	 */
	@Accessor(qualifier = "message", type = Accessor.Type.GETTER)
	public String getMessage()
	{
		return getMessage(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermission.message</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @param loc the value localization key 
	 * @return the message
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "message", type = Accessor.Type.GETTER)
	public String getMessage(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(MESSAGE, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermission.Unit</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the Unit - The Parent B2BUnit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.GETTER)
	public B2BUnitModel getUnit()
	{
		return getPersistenceContext().getPropertyValue(UNIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BPermission.UserGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the UserGroups
	 */
	@Accessor(qualifier = "UserGroups", type = Accessor.Type.GETTER)
	public List<B2BUserGroupModel> getUserGroups()
	{
		return getPersistenceContext().getPropertyValue(USERGROUPS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermission.active</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.SETTER)
	public void setActive(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(ACTIVE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermission.code</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermission.Customers</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the Customers
	 */
	@Accessor(qualifier = "Customers", type = Accessor.Type.SETTER)
	public void setCustomers(final Collection<B2BCustomerModel> value)
	{
		getPersistenceContext().setPropertyValue(CUSTOMERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermission.message</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the message
	 */
	@Accessor(qualifier = "message", type = Accessor.Type.SETTER)
	public void setMessage(final String value)
	{
		setMessage(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermission.message</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the message
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "message", type = Accessor.Type.SETTER)
	public void setMessage(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(MESSAGE, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermission.Unit</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the Unit - The Parent B2BUnit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.SETTER)
	public void setUnit(final B2BUnitModel value)
	{
		getPersistenceContext().setPropertyValue(UNIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BPermission.UserGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the UserGroups
	 */
	@Accessor(qualifier = "UserGroups", type = Accessor.Type.SETTER)
	public void setUserGroups(final List<B2BUserGroupModel> value)
	{
		getPersistenceContext().setPropertyValue(USERGROUPS, value);
	}
	
}
