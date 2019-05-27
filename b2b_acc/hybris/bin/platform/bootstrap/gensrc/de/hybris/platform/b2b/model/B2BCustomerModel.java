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
import de.hybris.platform.b2b.model.B2BUserGroupModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.customerreview.model.CustomerReviewModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Set;

/**
 * Generated model class for type B2BCustomer first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BCustomerModel extends CustomerModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BCustomer";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCustomer.active</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ACTIVE = "active";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCustomer.email</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String EMAIL = "email";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCustomer.defaultB2BUnit</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String DEFAULTB2BUNIT = "defaultB2BUnit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCustomer.ApproverGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String APPROVERGROUPS = "ApproverGroups";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCustomer.Approvers</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String APPROVERS = "Approvers";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCustomer.PermissionGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String PERMISSIONGROUPS = "PermissionGroups";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCustomer.Permissions</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String PERMISSIONS = "Permissions";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BCustomerModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BCustomerModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _email initial attribute declared by type <code>B2BCustomer</code> at extension <code>b2bcommerce</code>
	 * @param _loginDisabled initial attribute declared by type <code>User</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BCustomerModel(final String _email, final boolean _loginDisabled, final String _uid)
	{
		super();
		setEmail(_email);
		setLoginDisabled(_loginDisabled);
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _customerReviews initial attribute declared by type <code>User</code> at extension <code>customerreview</code>
	 * @param _email initial attribute declared by type <code>B2BCustomer</code> at extension <code>b2bcommerce</code>
	 * @param _loginDisabled initial attribute declared by type <code>User</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BCustomerModel(final Collection<CustomerReviewModel> _customerReviews, final String _email, final boolean _loginDisabled, final ItemModel _owner, final String _uid)
	{
		super();
		setCustomerReviews(_customerReviews);
		setEmail(_email);
		setLoginDisabled(_loginDisabled);
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCustomer.active</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.GETTER)
	public Boolean getActive()
	{
		return getPersistenceContext().getPropertyValue(ACTIVE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCustomer.ApproverGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the ApproverGroups
	 */
	@Accessor(qualifier = "ApproverGroups", type = Accessor.Type.GETTER)
	public Set<B2BUserGroupModel> getApproverGroups()
	{
		return getPersistenceContext().getPropertyValue(APPROVERGROUPS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCustomer.Approvers</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Approvers
	 */
	@Accessor(qualifier = "Approvers", type = Accessor.Type.GETTER)
	public Set<B2BCustomerModel> getApprovers()
	{
		return getPersistenceContext().getPropertyValue(APPROVERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCustomer.defaultB2BUnit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the defaultB2BUnit
	 */
	@Accessor(qualifier = "defaultB2BUnit", type = Accessor.Type.GETTER)
	public B2BUnitModel getDefaultB2BUnit()
	{
		return getPersistenceContext().getPropertyValue(DEFAULTB2BUNIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCustomer.email</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the email
	 */
	@Accessor(qualifier = "email", type = Accessor.Type.GETTER)
	public String getEmail()
	{
		return getPersistenceContext().getPropertyValue(EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCustomer.PermissionGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the PermissionGroups
	 */
	@Accessor(qualifier = "PermissionGroups", type = Accessor.Type.GETTER)
	public Set<B2BUserGroupModel> getPermissionGroups()
	{
		return getPersistenceContext().getPropertyValue(PERMISSIONGROUPS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCustomer.Permissions</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Permissions - Permissions associated to a B2BCustomer
	 */
	@Accessor(qualifier = "Permissions", type = Accessor.Type.GETTER)
	public Set<B2BPermissionModel> getPermissions()
	{
		return getPersistenceContext().getPropertyValue(PERMISSIONS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCustomer.active</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.SETTER)
	public void setActive(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(ACTIVE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCustomer.ApproverGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the ApproverGroups
	 */
	@Accessor(qualifier = "ApproverGroups", type = Accessor.Type.SETTER)
	public void setApproverGroups(final Set<B2BUserGroupModel> value)
	{
		getPersistenceContext().setPropertyValue(APPROVERGROUPS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCustomer.Approvers</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the Approvers
	 */
	@Accessor(qualifier = "Approvers", type = Accessor.Type.SETTER)
	public void setApprovers(final Set<B2BCustomerModel> value)
	{
		getPersistenceContext().setPropertyValue(APPROVERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCustomer.defaultB2BUnit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the defaultB2BUnit
	 */
	@Accessor(qualifier = "defaultB2BUnit", type = Accessor.Type.SETTER)
	public void setDefaultB2BUnit(final B2BUnitModel value)
	{
		getPersistenceContext().setPropertyValue(DEFAULTB2BUNIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCustomer.email</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the email
	 */
	@Accessor(qualifier = "email", type = Accessor.Type.SETTER)
	public void setEmail(final String value)
	{
		getPersistenceContext().setPropertyValue(EMAIL, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCustomer.PermissionGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the PermissionGroups
	 */
	@Accessor(qualifier = "PermissionGroups", type = Accessor.Type.SETTER)
	public void setPermissionGroups(final Set<B2BUserGroupModel> value)
	{
		getPersistenceContext().setPropertyValue(PERMISSIONGROUPS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCustomer.Permissions</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the Permissions - Permissions associated to a B2BCustomer
	 */
	@Accessor(qualifier = "Permissions", type = Accessor.Type.SETTER)
	public void setPermissions(final Set<B2BPermissionModel> value)
	{
		getPersistenceContext().setPropertyValue(PERMISSIONS, value);
	}
	
}
