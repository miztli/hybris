/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.b2bcommercefacades.company.data;

import de.hybris.platform.b2bcommercefacades.company.data.B2BBudgetData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BCostCenterData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUnitData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUserGroupData;
import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CompanyData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import de.hybris.platform.commercefacades.user.data.UserGroupData;
import java.util.Collection;
import java.util.List;

public  class B2BUnitData extends CompanyData 
{

 

	/** <i>Generated property</i> for <code>B2BUnitData.unit</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private B2BUnitData unit;

	/** <i>Generated property</i> for <code>B2BUnitData.active</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private boolean active;

	/** <i>Generated property</i> for <code>B2BUnitData.selected</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private boolean selected;

	/** <i>Generated property</i> for <code>B2BUnitData.selectable</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private boolean selectable;

	/** <i>Generated property</i> for <code>B2BUnitData.reportingOrganization</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private B2BUnitData reportingOrganization;

	/** <i>Generated property</i> for <code>B2BUnitData.budgets</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<B2BBudgetData> budgets;

	/** <i>Generated property</i> for <code>B2BUnitData.orders</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private Collection<AbstractOrderData> orders;

	/** <i>Generated property</i> for <code>B2BUnitData.costCenters</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<B2BCostCenterData> costCenters;

	/** <i>Generated property</i> for <code>B2BUnitData.userGroups</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private Collection<B2BUserGroupData> userGroups;

	/** <i>Generated property</i> for <code>B2BUnitData.accountManagerGroups</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private Collection<UserGroupData> accountManagerGroups;

	/** <i>Generated property</i> for <code>B2BUnitData.children</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<B2BUnitData> children;

	/** <i>Generated property</i> for <code>B2BUnitData.administrators</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private Collection<CustomerData> administrators;

	/** <i>Generated property</i> for <code>B2BUnitData.customers</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private Collection<CustomerData> customers;

	/** <i>Generated property</i> for <code>B2BUnitData.managers</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<CustomerData> managers;

	/** <i>Generated property</i> for <code>B2BUnitData.accountManagers</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<PrincipalData> accountManagers;

	/** <i>Generated property</i> for <code>B2BUnitData.addresses</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<AddressData> addresses;

	/** <i>Generated property</i> for <code>B2BUnitData.approvalProcessCode</code> property defined at extension <code>b2bapprovalprocessfacades</code>. */
		
	private String approvalProcessCode;

	/** <i>Generated property</i> for <code>B2BUnitData.approvalProcessName</code> property defined at extension <code>b2bapprovalprocessfacades</code>. */
		
	private String approvalProcessName;

	/** <i>Generated property</i> for <code>B2BUnitData.approvers</code> property defined at extension <code>b2bapprovalprocessfacades</code>. */
		
	private Collection<CustomerData> approvers;

	/** <i>Generated property</i> for <code>B2BUnitData.approverGroups</code> property defined at extension <code>b2bapprovalprocessfacades</code>. */
		
	private Collection<B2BUserGroupData> approverGroups;
	
	public B2BUnitData()
	{
		// default constructor
	}
	
		
	
	public void setUnit(final B2BUnitData unit)
	{
		this.unit = unit;
	}

		
	
	public B2BUnitData getUnit() 
	{
		return unit;
	}
	
		
	
	public void setActive(final boolean active)
	{
		this.active = active;
	}

		
	
	public boolean isActive() 
	{
		return active;
	}
	
		
	
	public void setSelected(final boolean selected)
	{
		this.selected = selected;
	}

		
	
	public boolean isSelected() 
	{
		return selected;
	}
	
		
	
	public void setSelectable(final boolean selectable)
	{
		this.selectable = selectable;
	}

		
	
	public boolean isSelectable() 
	{
		return selectable;
	}
	
		
	
	public void setReportingOrganization(final B2BUnitData reportingOrganization)
	{
		this.reportingOrganization = reportingOrganization;
	}

		
	
	public B2BUnitData getReportingOrganization() 
	{
		return reportingOrganization;
	}
	
		
	
	public void setBudgets(final List<B2BBudgetData> budgets)
	{
		this.budgets = budgets;
	}

		
	
	public List<B2BBudgetData> getBudgets() 
	{
		return budgets;
	}
	
		
	
	public void setOrders(final Collection<AbstractOrderData> orders)
	{
		this.orders = orders;
	}

		
	
	public Collection<AbstractOrderData> getOrders() 
	{
		return orders;
	}
	
		
	
	public void setCostCenters(final List<B2BCostCenterData> costCenters)
	{
		this.costCenters = costCenters;
	}

		
	
	public List<B2BCostCenterData> getCostCenters() 
	{
		return costCenters;
	}
	
		
	
	public void setUserGroups(final Collection<B2BUserGroupData> userGroups)
	{
		this.userGroups = userGroups;
	}

		
	
	public Collection<B2BUserGroupData> getUserGroups() 
	{
		return userGroups;
	}
	
		
	
	public void setAccountManagerGroups(final Collection<UserGroupData> accountManagerGroups)
	{
		this.accountManagerGroups = accountManagerGroups;
	}

		
	
	public Collection<UserGroupData> getAccountManagerGroups() 
	{
		return accountManagerGroups;
	}
	
		
	
	public void setChildren(final List<B2BUnitData> children)
	{
		this.children = children;
	}

		
	
	public List<B2BUnitData> getChildren() 
	{
		return children;
	}
	
		
	
	public void setAdministrators(final Collection<CustomerData> administrators)
	{
		this.administrators = administrators;
	}

		
	
	public Collection<CustomerData> getAdministrators() 
	{
		return administrators;
	}
	
		
	
	public void setCustomers(final Collection<CustomerData> customers)
	{
		this.customers = customers;
	}

		
	
	public Collection<CustomerData> getCustomers() 
	{
		return customers;
	}
	
		
	
	public void setManagers(final List<CustomerData> managers)
	{
		this.managers = managers;
	}

		
	
	public List<CustomerData> getManagers() 
	{
		return managers;
	}
	
		
	
	public void setAccountManagers(final List<PrincipalData> accountManagers)
	{
		this.accountManagers = accountManagers;
	}

		
	
	public List<PrincipalData> getAccountManagers() 
	{
		return accountManagers;
	}
	
		
	
	public void setAddresses(final List<AddressData> addresses)
	{
		this.addresses = addresses;
	}

		
	
	public List<AddressData> getAddresses() 
	{
		return addresses;
	}
	
		
	
	public void setApprovalProcessCode(final String approvalProcessCode)
	{
		this.approvalProcessCode = approvalProcessCode;
	}

		
	
	public String getApprovalProcessCode() 
	{
		return approvalProcessCode;
	}
	
		
	
	public void setApprovalProcessName(final String approvalProcessName)
	{
		this.approvalProcessName = approvalProcessName;
	}

		
	
	public String getApprovalProcessName() 
	{
		return approvalProcessName;
	}
	
		
	
	public void setApprovers(final Collection<CustomerData> approvers)
	{
		this.approvers = approvers;
	}

		
	
	public Collection<CustomerData> getApprovers() 
	{
		return approvers;
	}
	
		
	
	public void setApproverGroups(final Collection<B2BUserGroupData> approverGroups)
	{
		this.approverGroups = approverGroups;
	}

		
	
	public Collection<B2BUserGroupData> getApproverGroups() 
	{
		return approverGroups;
	}
	


}
