/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
package de.hybris.platform.ruleengine;

import java.io.Serializable;
import de.hybris.platform.ruleengine.InitializeMode;
import java.util.Collection;
import java.util.Map;

/**
 * ExecutionContext is a ruleengine specific context object used during rule initialization
 */
public  class ExecutionContext  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** this map contains entries of rule code and referenced engine rule version<br/><br/><i>Generated property</i> for <code>ExecutionContext.ruleVersions</code> property defined at extension <code>ruleengine</code>. */
		
	private Map<String, Long> ruleVersions;

	/** mode of Rule Engine initialization<br/><br/><i>Generated property</i> for <code>ExecutionContext.initializeMode</code> property defined at extension <code>ruleengine</code>. */
		
	private InitializeMode initializeMode;

	/** <i>Generated property</i> for <code>ExecutionContext.modifiedRuleCodes</code> property defined at extension <code>ruleengine</code>. */
		
	private Collection<String> modifiedRuleCodes;
	
	public ExecutionContext()
	{
		// default constructor
	}
	
		
	
	public void setRuleVersions(final Map<String, Long> ruleVersions)
	{
		this.ruleVersions = ruleVersions;
	}

		
	
	public Map<String, Long> getRuleVersions() 
	{
		return ruleVersions;
	}
	
		
	
	public void setInitializeMode(final InitializeMode initializeMode)
	{
		this.initializeMode = initializeMode;
	}

		
	
	public InitializeMode getInitializeMode() 
	{
		return initializeMode;
	}
	
		
	
	public void setModifiedRuleCodes(final Collection<String> modifiedRuleCodes)
	{
		this.modifiedRuleCodes = modifiedRuleCodes;
	}

		
	
	public Collection<String> getModifiedRuleCodes() 
	{
		return modifiedRuleCodes;
	}
	


}
