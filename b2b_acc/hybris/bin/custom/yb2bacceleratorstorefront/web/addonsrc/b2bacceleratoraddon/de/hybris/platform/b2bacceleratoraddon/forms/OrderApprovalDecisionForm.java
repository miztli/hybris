/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.b2bacceleratoraddon.forms;

/**
 * Pojo for 'order approval decision' form.
 */
public class OrderApprovalDecisionForm
{
	private String workFlowActionCode;
	private String approverSelectedDecision;
	private String comments;

	public String getWorkFlowActionCode()
	{
		return workFlowActionCode;
	}

	public void setWorkFlowActionCode(final String workFlowActionCode)
	{
		this.workFlowActionCode = workFlowActionCode;
	}

	public String getApproverSelectedDecision()
	{
		return approverSelectedDecision;
	}

	public void setApproverSelectedDecision(final String approverSelectedDecision)
	{
		this.approverSelectedDecision = approverSelectedDecision;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(final String comments)
	{
		this.comments = comments;
	}
}
