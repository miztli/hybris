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
package de.hybris.platform.ruleengineservices.rule.data;

import de.hybris.platform.ruleengineservices.rule.data.AbstractRuleDefinitionData;
import de.hybris.platform.ruleengineservices.rule.data.RuleActionDefinitionCategoryData;
import java.util.List;

public  class RuleActionDefinitionData extends AbstractRuleDefinitionData 
{

 

	/** <i>Generated property</i> for <code>RuleActionDefinitionData.categories</code> property defined at extension <code>ruleengineservices</code>. */
		
	private List<RuleActionDefinitionCategoryData> categories;
	
	public RuleActionDefinitionData()
	{
		// default constructor
	}
	
		
	
	public void setCategories(final List<RuleActionDefinitionCategoryData> categories)
	{
		this.categories = categories;
	}

		
	
	public List<RuleActionDefinitionCategoryData> getCategories() 
	{
		return categories;
	}
	


}
