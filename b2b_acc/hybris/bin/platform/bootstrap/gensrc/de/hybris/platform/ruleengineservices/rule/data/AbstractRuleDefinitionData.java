/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
package de.hybris.platform.ruleengineservices.rule.data;

import java.io.Serializable;
import de.hybris.platform.ruleengineservices.rule.data.RuleParameterDefinitionData;
import java.util.Map;

public abstract  class AbstractRuleDefinitionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractRuleDefinitionData.id</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>AbstractRuleDefinitionData.name</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>AbstractRuleDefinitionData.priority</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Integer priority;

	/** <i>Generated property</i> for <code>AbstractRuleDefinitionData.breadcrumb</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String breadcrumb;

	/** <i>Generated property</i> for <code>AbstractRuleDefinitionData.translatorId</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String translatorId;

	/** <i>Generated property</i> for <code>AbstractRuleDefinitionData.translatorParameters</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Map<String,String> translatorParameters;

	/** <i>Generated property</i> for <code>AbstractRuleDefinitionData.parameters</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Map<String,RuleParameterDefinitionData> parameters;
	
	public AbstractRuleDefinitionData()
	{
		// default constructor
	}
	
		
	
	public void setId(final String id)
	{
		this.id = id;
	}

		
	
	public String getId() 
	{
		return id;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}

		
	
	public Integer getPriority() 
	{
		return priority;
	}
	
		
	
	public void setBreadcrumb(final String breadcrumb)
	{
		this.breadcrumb = breadcrumb;
	}

		
	
	public String getBreadcrumb() 
	{
		return breadcrumb;
	}
	
		
	
	public void setTranslatorId(final String translatorId)
	{
		this.translatorId = translatorId;
	}

		
	
	public String getTranslatorId() 
	{
		return translatorId;
	}
	
		
	
	public void setTranslatorParameters(final Map<String,String> translatorParameters)
	{
		this.translatorParameters = translatorParameters;
	}

		
	
	public Map<String,String> getTranslatorParameters() 
	{
		return translatorParameters;
	}
	
		
	
	public void setParameters(final Map<String,RuleParameterDefinitionData> parameters)
	{
		this.parameters = parameters;
	}

		
	
	public Map<String,RuleParameterDefinitionData> getParameters() 
	{
		return parameters;
	}
	


}
