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
package de.hybris.platform.adaptivesearch.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsBoostRuleConfiguration;
import de.hybris.platform.adaptivesearch.enums.AsBoostOperator;
import de.hybris.platform.adaptivesearch.enums.AsBoostType;

public  class AsBoostRule extends AbstractAsBoostRuleConfiguration 
{

 

	/** <i>Generated property</i> for <code>AsBoostRule.indexProperty</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String indexProperty;

	/** <i>Generated property</i> for <code>AsBoostRule.operator</code> property defined at extension <code>adaptivesearch</code>. */
		
	private AsBoostOperator operator;

	/** <i>Generated property</i> for <code>AsBoostRule.value</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String value;

	/** <i>Generated property</i> for <code>AsBoostRule.boostType</code> property defined at extension <code>adaptivesearch</code>. */
		
	private AsBoostType boostType;

	/** <i>Generated property</i> for <code>AsBoostRule.boost</code> property defined at extension <code>adaptivesearch</code>. */
		
	private Float boost;
	
	public AsBoostRule()
	{
		// default constructor
	}
	
		
	
	public void setIndexProperty(final String indexProperty)
	{
		this.indexProperty = indexProperty;
	}

		
	
	public String getIndexProperty() 
	{
		return indexProperty;
	}
	
		
	
	public void setOperator(final AsBoostOperator operator)
	{
		this.operator = operator;
	}

		
	
	public AsBoostOperator getOperator() 
	{
		return operator;
	}
	
		
	
	public void setValue(final String value)
	{
		this.value = value;
	}

		
	
	public String getValue() 
	{
		return value;
	}
	
		
	
	public void setBoostType(final AsBoostType boostType)
	{
		this.boostType = boostType;
	}

		
	
	public AsBoostType getBoostType() 
	{
		return boostType;
	}
	
		
	
	public void setBoost(final Float boost)
	{
		this.boost = boost;
	}

		
	
	public Float getBoost() 
	{
		return boost;
	}
	


}
