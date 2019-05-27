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
package de.hybris.platform.ruleengineservices.rrd;

import java.io.Serializable;

/**
 * Represents a Rule's configuration at rule evaluation time (gets inserted as one fact per rule, the rule being identified by the ruleCode)
 */
public  class RuleConfigurationRRD  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RuleConfigurationRRD.ruleCode</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String ruleCode;

	/** <i>Generated property</i> for <code>RuleConfigurationRRD.maxAllowedRuns</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Integer maxAllowedRuns;

	/** <i>Generated property</i> for <code>RuleConfigurationRRD.currentRuns</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Integer currentRuns;

	/** <i>Generated property</i> for <code>RuleConfigurationRRD.ruleGroupCode</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String ruleGroupCode;

	/** indicates if at least one of a Rule Action executed successfully<br/><br/><i>Generated property</i> for <code>RuleConfigurationRRD.actionExecutionStarted</code> property defined at extension <code>ruleengineservices</code>. */
		
	private boolean actionExecutionStarted;
	
	public RuleConfigurationRRD()
	{
		// default constructor
	}
	
		
	
	public void setRuleCode(final String ruleCode)
	{
		this.ruleCode = ruleCode;
	}

		
	
	public String getRuleCode() 
	{
		return ruleCode;
	}
	
		
	
	public void setMaxAllowedRuns(final Integer maxAllowedRuns)
	{
		this.maxAllowedRuns = maxAllowedRuns;
	}

		
	
	public Integer getMaxAllowedRuns() 
	{
		return maxAllowedRuns;
	}
	
		
	
	public void setCurrentRuns(final Integer currentRuns)
	{
		this.currentRuns = currentRuns;
	}

		
	
	public Integer getCurrentRuns() 
	{
		return currentRuns;
	}
	
		
	
	public void setRuleGroupCode(final String ruleGroupCode)
	{
		this.ruleGroupCode = ruleGroupCode;
	}

		
	
	public String getRuleGroupCode() 
	{
		return ruleGroupCode;
	}
	
		
	
	public void setActionExecutionStarted(final boolean actionExecutionStarted)
	{
		this.actionExecutionStarted = actionExecutionStarted;
	}

		
	
	public boolean isActionExecutionStarted() 
	{
		return actionExecutionStarted;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final RuleConfigurationRRD other = (RuleConfigurationRRD) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getRuleCode(), other.getRuleCode()) 
			.isEquals();
		} 
		catch (ClassCastException c)
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return new org.apache.commons.lang.builder.HashCodeBuilder()
		.append(getRuleCode()) 
		.toHashCode();
	}

}
