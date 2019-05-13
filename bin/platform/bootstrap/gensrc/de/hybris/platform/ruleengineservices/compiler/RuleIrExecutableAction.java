/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
package de.hybris.platform.ruleengineservices.compiler;

import de.hybris.platform.ruleengineservices.compiler.RuleIrAction;
import java.util.Map;

public  class RuleIrExecutableAction extends RuleIrAction 
{

 

	/** <i>Generated property</i> for <code>RuleIrExecutableAction.actionId</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String actionId;

	/** <i>Generated property</i> for <code>RuleIrExecutableAction.actionParameters</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Map<String,Object> actionParameters;
	
	public RuleIrExecutableAction()
	{
		// default constructor
	}
	
		
	
	public void setActionId(final String actionId)
	{
		this.actionId = actionId;
	}

		
	
	public String getActionId() 
	{
		return actionId;
	}
	
		
	
	public void setActionParameters(final Map<String,Object> actionParameters)
	{
		this.actionParameters = actionParameters;
	}

		
	
	public Map<String,Object> getActionParameters() 
	{
		return actionParameters;
	}
	


}
