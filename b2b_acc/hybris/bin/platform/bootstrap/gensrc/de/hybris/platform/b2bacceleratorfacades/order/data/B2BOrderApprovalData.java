/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:21 PM
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
package de.hybris.platform.b2bacceleratorfacades.order.data;

import java.io.Serializable;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BOrderHistoryEntryData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import java.util.List;

public  class B2BOrderApprovalData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.workflowActionModelCode</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private String workflowActionModelCode;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.b2bOrderData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private OrderData b2bOrderData;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.permissionTypes</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<String> permissionTypes;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.allDecisions</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<String> allDecisions;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.selectedDecision</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private String selectedDecision;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.approvalComments</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private String approvalComments;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.approvalDecisionRequired</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private boolean approvalDecisionRequired;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.orderHistoryEntriesData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<B2BOrderHistoryEntryData> orderHistoryEntriesData;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.quotesApprovalHistoryEntriesData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<B2BOrderHistoryEntryData> quotesApprovalHistoryEntriesData;

	/** <i>Generated property</i> for <code>B2BOrderApprovalData.merchantApprovalHistoryEntriesData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<B2BOrderHistoryEntryData> merchantApprovalHistoryEntriesData;
	
	public B2BOrderApprovalData()
	{
		// default constructor
	}
	
		
	
	public void setWorkflowActionModelCode(final String workflowActionModelCode)
	{
		this.workflowActionModelCode = workflowActionModelCode;
	}

		
	
	public String getWorkflowActionModelCode() 
	{
		return workflowActionModelCode;
	}
	
		
	
	public void setB2bOrderData(final OrderData b2bOrderData)
	{
		this.b2bOrderData = b2bOrderData;
	}

		
	
	public OrderData getB2bOrderData() 
	{
		return b2bOrderData;
	}
	
		
	
	public void setPermissionTypes(final List<String> permissionTypes)
	{
		this.permissionTypes = permissionTypes;
	}

		
	
	public List<String> getPermissionTypes() 
	{
		return permissionTypes;
	}
	
		
	
	public void setAllDecisions(final List<String> allDecisions)
	{
		this.allDecisions = allDecisions;
	}

		
	
	public List<String> getAllDecisions() 
	{
		return allDecisions;
	}
	
		
	
	public void setSelectedDecision(final String selectedDecision)
	{
		this.selectedDecision = selectedDecision;
	}

		
	
	public String getSelectedDecision() 
	{
		return selectedDecision;
	}
	
		
	
	public void setApprovalComments(final String approvalComments)
	{
		this.approvalComments = approvalComments;
	}

		
	
	public String getApprovalComments() 
	{
		return approvalComments;
	}
	
		
	
	public void setApprovalDecisionRequired(final boolean approvalDecisionRequired)
	{
		this.approvalDecisionRequired = approvalDecisionRequired;
	}

		
	
	public boolean isApprovalDecisionRequired() 
	{
		return approvalDecisionRequired;
	}
	
		
	
	public void setOrderHistoryEntriesData(final List<B2BOrderHistoryEntryData> orderHistoryEntriesData)
	{
		this.orderHistoryEntriesData = orderHistoryEntriesData;
	}

		
	
	public List<B2BOrderHistoryEntryData> getOrderHistoryEntriesData() 
	{
		return orderHistoryEntriesData;
	}
	
	@Deprecated
    /**
     * @deprecated Since 6.3. Please see quote functionality from commerce.
     */
		
	
	public void setQuotesApprovalHistoryEntriesData(final List<B2BOrderHistoryEntryData> quotesApprovalHistoryEntriesData)
	{
		this.quotesApprovalHistoryEntriesData = quotesApprovalHistoryEntriesData;
	}

	@Deprecated
	/**
	 * @deprecated Since 6.3. Please see quote functionality from commerce.
	 */
		
	
	public List<B2BOrderHistoryEntryData> getQuotesApprovalHistoryEntriesData() 
	{
		return quotesApprovalHistoryEntriesData;
	}
	
		
	
	public void setMerchantApprovalHistoryEntriesData(final List<B2BOrderHistoryEntryData> merchantApprovalHistoryEntriesData)
	{
		this.merchantApprovalHistoryEntriesData = merchantApprovalHistoryEntriesData;
	}

		
	
	public List<B2BOrderHistoryEntryData> getMerchantApprovalHistoryEntriesData() 
	{
		return merchantApprovalHistoryEntriesData;
	}
	


}
