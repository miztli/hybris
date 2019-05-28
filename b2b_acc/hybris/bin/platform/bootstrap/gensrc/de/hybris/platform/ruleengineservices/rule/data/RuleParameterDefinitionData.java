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
package de.hybris.platform.ruleengineservices.rule.data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public  class RuleParameterDefinitionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RuleParameterDefinitionData.name</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>RuleParameterDefinitionData.description</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String description;

	/** <i>Generated property</i> for <code>RuleParameterDefinitionData.priority</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Integer priority;

	/** <i>Generated property</i> for <code>RuleParameterDefinitionData.type</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String type;

	/** <i>Generated property</i> for <code>RuleParameterDefinitionData.defaultValue</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Object defaultValue;

	/** <i>Generated property</i> for <code>RuleParameterDefinitionData.required</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Boolean required;

	/** <i>Generated property</i> for <code>RuleParameterDefinitionData.validators</code> property defined at extension <code>ruleengineservices</code>. */
		
	private List<String> validators;

	/** <i>Generated property</i> for <code>RuleParameterDefinitionData.filters</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Map<String, String> filters;

	/** <i>Generated property</i> for <code>RuleParameterDefinitionData.defaultEditor</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String defaultEditor;
	
	public RuleParameterDefinitionData()
	{
		// default constructor
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	
		
	
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}

		
	
	public Integer getPriority() 
	{
		return priority;
	}
	
		
	
	public void setType(final String type)
	{
		this.type = type;
	}

		
	
	public String getType() 
	{
		return type;
	}
	
		
	
	public void setDefaultValue(final Object defaultValue)
	{
		this.defaultValue = defaultValue;
	}

		
	
	public Object getDefaultValue() 
	{
		return defaultValue;
	}
	
		
	
	public void setRequired(final Boolean required)
	{
		this.required = required;
	}

		
	
	public Boolean getRequired() 
	{
		return required;
	}
	
		
	
	public void setValidators(final List<String> validators)
	{
		this.validators = validators;
	}

		
	
	public List<String> getValidators() 
	{
		return validators;
	}
	
		
	
	public void setFilters(final Map<String, String> filters)
	{
		this.filters = filters;
	}

		
	
	public Map<String, String> getFilters() 
	{
		return filters;
	}
	
		
	
	public void setDefaultEditor(final String defaultEditor)
	{
		this.defaultEditor = defaultEditor;
	}

		
	
	public String getDefaultEditor() 
	{
		return defaultEditor;
	}
	


}
