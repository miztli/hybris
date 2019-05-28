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
package de.hybris.platform.b2b.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2b.model.B2BBudgetModel;
import de.hybris.platform.b2b.model.B2BCostCenterModel;
import de.hybris.platform.b2b.model.B2BCreditLimitModel;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.model.B2BPermissionModel;
import de.hybris.platform.b2b.model.B2BQuoteLimitModel;
import de.hybris.platform.b2b.model.B2BUserGroupModel;
import de.hybris.platform.commerceservices.model.OrgUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.List;
import java.util.Set;

/**
 * Generated model class for type B2BUnit first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BUnitModel extends OrgUnitModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BUnit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.reportingOrganization</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String REPORTINGORGANIZATION = "reportingOrganization";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.UserGroups</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String USERGROUPS = "UserGroups";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.CostCenters</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COSTCENTERS = "CostCenters";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.Budgets</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String BUDGETS = "Budgets";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.Orders</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ORDERS = "Orders";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.CreditLimit</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CREDITLIMIT = "CreditLimit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.QuoteLimit</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String QUOTELIMIT = "QuoteLimit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.accountManager</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ACCOUNTMANAGER = "accountManager";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.AccountManagerGroups</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ACCOUNTMANAGERGROUPS = "AccountManagerGroups";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.approvalProcessCode</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String APPROVALPROCESSCODE = "approvalProcessCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.ApproverGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String APPROVERGROUPS = "ApproverGroups";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.Permissions</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String PERMISSIONS = "Permissions";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BUnit.Approvers</code> attribute defined at extension <code>b2bapprovalprocess</code>. */
	public static final String APPROVERS = "Approvers";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BUnitModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BUnitModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BUnitModel(final String _uid)
	{
		super();
		setUid(_uid);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _uid initial attribute declared by type <code>Principal</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BUnitModel(final ItemModel _owner, final String _uid)
	{
		super();
		setOwner(_owner);
		setUid(_uid);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.accountManager</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the accountManager - Employee-Account Manager associated to a Parent B2BUnit
	 */
	@Accessor(qualifier = "accountManager", type = Accessor.Type.GETTER)
	public EmployeeModel getAccountManager()
	{
		return getPersistenceContext().getPropertyValue(ACCOUNTMANAGER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.AccountManagerGroups</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the AccountManagerGroups - User groups associated to a B2BUnit that hold other employees who can approve quotes
	 */
	@Accessor(qualifier = "AccountManagerGroups", type = Accessor.Type.GETTER)
	public Set<UserGroupModel> getAccountManagerGroups()
	{
		return getPersistenceContext().getPropertyValue(ACCOUNTMANAGERGROUPS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.approvalProcessCode</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * @return the approvalProcessCode - A name of the process to be consumed by process engine for
	 * 						b2b order approval as defined in the process definition file.
	 */
	@Accessor(qualifier = "approvalProcessCode", type = Accessor.Type.GETTER)
	public String getApprovalProcessCode()
	{
		return getPersistenceContext().getPropertyValue(APPROVALPROCESSCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.ApproverGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the ApproverGroups - User groups associated to a B2BUnit that hold other employees who can approve orders
	 */
	@Accessor(qualifier = "ApproverGroups", type = Accessor.Type.GETTER)
	public Set<B2BUserGroupModel> getApproverGroups()
	{
		return getPersistenceContext().getPropertyValue(APPROVERGROUPS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.Approvers</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Approvers - Approvers associated to a customer
	 */
	@Accessor(qualifier = "Approvers", type = Accessor.Type.GETTER)
	public Set<B2BCustomerModel> getApprovers()
	{
		return getPersistenceContext().getPropertyValue(APPROVERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.Budgets</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Budgets - Budgets associated to a Parent B2BUnit
	 */
	@Accessor(qualifier = "Budgets", type = Accessor.Type.GETTER)
	public List<B2BBudgetModel> getBudgets()
	{
		return getPersistenceContext().getPropertyValue(BUDGETS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.CostCenters</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the CostCenters - CostCenters associated to a Parent B2BUnit
	 */
	@Accessor(qualifier = "CostCenters", type = Accessor.Type.GETTER)
	public List<B2BCostCenterModel> getCostCenters()
	{
		return getPersistenceContext().getPropertyValue(COSTCENTERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.CreditLimit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the CreditLimit - Merchant Check associated to a Parent B2BUnit
	 */
	@Accessor(qualifier = "CreditLimit", type = Accessor.Type.GETTER)
	public B2BCreditLimitModel getCreditLimit()
	{
		return getPersistenceContext().getPropertyValue(CREDITLIMIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.Orders</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Orders
	 */
	@Accessor(qualifier = "Orders", type = Accessor.Type.GETTER)
	public Set<AbstractOrderModel> getOrders()
	{
		return getPersistenceContext().getPropertyValue(ORDERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.Permissions</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Permissions - Permissions associated to a unit B2BUnit
	 */
	@Accessor(qualifier = "Permissions", type = Accessor.Type.GETTER)
	public Set<B2BPermissionModel> getPermissions()
	{
		return getPersistenceContext().getPropertyValue(PERMISSIONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.QuoteLimit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the QuoteLimit - Minimum Amount on Cart for qualifying for Quote Request
	 */
	@Accessor(qualifier = "QuoteLimit", type = Accessor.Type.GETTER)
	public B2BQuoteLimitModel getQuoteLimit()
	{
		return getPersistenceContext().getPropertyValue(QUOTELIMIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.reportingOrganization</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the reportingOrganization
	 */
	@Accessor(qualifier = "reportingOrganization", type = Accessor.Type.GETTER)
	public B2BUnitModel getReportingOrganization()
	{
		return getPersistenceContext().getPropertyValue(REPORTINGORGANIZATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BUnit.UserGroups</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the UserGroups
	 */
	@Accessor(qualifier = "UserGroups", type = Accessor.Type.GETTER)
	public Set<B2BUserGroupModel> getUserGroups()
	{
		return getPersistenceContext().getPropertyValue(USERGROUPS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.accountManager</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the accountManager - Employee-Account Manager associated to a Parent B2BUnit
	 */
	@Accessor(qualifier = "accountManager", type = Accessor.Type.SETTER)
	public void setAccountManager(final EmployeeModel value)
	{
		getPersistenceContext().setPropertyValue(ACCOUNTMANAGER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.AccountManagerGroups</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the AccountManagerGroups - User groups associated to a B2BUnit that hold other employees who can approve quotes
	 */
	@Accessor(qualifier = "AccountManagerGroups", type = Accessor.Type.SETTER)
	public void setAccountManagerGroups(final Set<UserGroupModel> value)
	{
		getPersistenceContext().setPropertyValue(ACCOUNTMANAGERGROUPS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.approvalProcessCode</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the approvalProcessCode - A name of the process to be consumed by process engine for
	 * 						b2b order approval as defined in the process definition file.
	 */
	@Accessor(qualifier = "approvalProcessCode", type = Accessor.Type.SETTER)
	public void setApprovalProcessCode(final String value)
	{
		getPersistenceContext().setPropertyValue(APPROVALPROCESSCODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.ApproverGroups</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the ApproverGroups - User groups associated to a B2BUnit that hold other employees who can approve orders
	 */
	@Accessor(qualifier = "ApproverGroups", type = Accessor.Type.SETTER)
	public void setApproverGroups(final Set<B2BUserGroupModel> value)
	{
		getPersistenceContext().setPropertyValue(APPROVERGROUPS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.Approvers</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the Approvers - Approvers associated to a customer
	 */
	@Accessor(qualifier = "Approvers", type = Accessor.Type.SETTER)
	public void setApprovers(final Set<B2BCustomerModel> value)
	{
		getPersistenceContext().setPropertyValue(APPROVERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.Budgets</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the Budgets - Budgets associated to a Parent B2BUnit
	 */
	@Accessor(qualifier = "Budgets", type = Accessor.Type.SETTER)
	public void setBudgets(final List<B2BBudgetModel> value)
	{
		getPersistenceContext().setPropertyValue(BUDGETS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.CostCenters</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the CostCenters - CostCenters associated to a Parent B2BUnit
	 */
	@Accessor(qualifier = "CostCenters", type = Accessor.Type.SETTER)
	public void setCostCenters(final List<B2BCostCenterModel> value)
	{
		getPersistenceContext().setPropertyValue(COSTCENTERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.CreditLimit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the CreditLimit - Merchant Check associated to a Parent B2BUnit
	 */
	@Accessor(qualifier = "CreditLimit", type = Accessor.Type.SETTER)
	public void setCreditLimit(final B2BCreditLimitModel value)
	{
		getPersistenceContext().setPropertyValue(CREDITLIMIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.Orders</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the Orders
	 */
	@Accessor(qualifier = "Orders", type = Accessor.Type.SETTER)
	public void setOrders(final Set<AbstractOrderModel> value)
	{
		getPersistenceContext().setPropertyValue(ORDERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.Permissions</code> attribute defined at extension <code>b2bapprovalprocess</code>. 
	 *  
	 * @param value the Permissions - Permissions associated to a unit B2BUnit
	 */
	@Accessor(qualifier = "Permissions", type = Accessor.Type.SETTER)
	public void setPermissions(final Set<B2BPermissionModel> value)
	{
		getPersistenceContext().setPropertyValue(PERMISSIONS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.QuoteLimit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the QuoteLimit - Minimum Amount on Cart for qualifying for Quote Request
	 */
	@Accessor(qualifier = "QuoteLimit", type = Accessor.Type.SETTER)
	public void setQuoteLimit(final B2BQuoteLimitModel value)
	{
		getPersistenceContext().setPropertyValue(QUOTELIMIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.reportingOrganization</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the reportingOrganization
	 */
	@Accessor(qualifier = "reportingOrganization", type = Accessor.Type.SETTER)
	public void setReportingOrganization(final B2BUnitModel value)
	{
		getPersistenceContext().setPropertyValue(REPORTINGORGANIZATION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BUnit.UserGroups</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the UserGroups
	 */
	@Accessor(qualifier = "UserGroups", type = Accessor.Type.SETTER)
	public void setUserGroups(final Set<B2BUserGroupModel> value)
	{
		getPersistenceContext().setPropertyValue(USERGROUPS, value);
	}
	
}
