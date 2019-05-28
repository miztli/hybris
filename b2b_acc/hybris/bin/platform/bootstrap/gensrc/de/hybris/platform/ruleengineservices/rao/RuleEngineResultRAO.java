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
package de.hybris.platform.ruleengineservices.rao;

import java.io.Serializable;
import de.hybris.platform.ruleengineservices.rao.AbstractRuleActionRAO;
import java.util.Date;
import java.util.LinkedHashSet;

public  class RuleEngineResultRAO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RuleEngineResultRAO.startTime</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Date startTime;

	/** <i>Generated property</i> for <code>RuleEngineResultRAO.endTime</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Date endTime;

	/** <i>Generated property</i> for <code>RuleEngineResultRAO.actions</code> property defined at extension <code>ruleengineservices</code>. */
		
	private LinkedHashSet<AbstractRuleActionRAO> actions;
	
	public RuleEngineResultRAO()
	{
		// default constructor
	}
	
		
	
	public void setStartTime(final Date startTime)
	{
		this.startTime = startTime;
	}

		
	
	public Date getStartTime() 
	{
		return startTime;
	}
	
		
	
	public void setEndTime(final Date endTime)
	{
		this.endTime = endTime;
	}

		
	
	public Date getEndTime() 
	{
		return endTime;
	}
	
		
	
	public void setActions(final LinkedHashSet<AbstractRuleActionRAO> actions)
	{
		this.actions = actions;
	}

		
	
	public LinkedHashSet<AbstractRuleActionRAO> getActions() 
	{
		return actions;
	}
	


}
