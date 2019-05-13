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
package de.hybris.platform.adaptivesearch.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsItemConfiguration;
import de.hybris.platform.adaptivesearch.data.AsSortExpression;
import java.util.List;
import java.util.Map;

public abstract  class AbstractAsSortConfiguration extends AbstractAsItemConfiguration 
{

 

	/** <i>Generated property</i> for <code>AbstractAsSortConfiguration.code</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>AbstractAsSortConfiguration.name</code> property defined at extension <code>adaptivesearch</code>. */
		
	private Map<String,String> name;

	/** <i>Generated property</i> for <code>AbstractAsSortConfiguration.priority</code> property defined at extension <code>adaptivesearch</code>. */
		
	private Integer priority;

	/** <i>Generated property</i> for <code>AbstractAsSortConfiguration.applyPromotedItems</code> property defined at extension <code>adaptivesearch</code>. */
		
	private boolean applyPromotedItems;

	/** <i>Generated property</i> for <code>AbstractAsSortConfiguration.highlightPromotedItems</code> property defined at extension <code>adaptivesearch</code>. */
		
	private boolean highlightPromotedItems;

	/** <i>Generated property</i> for <code>AbstractAsSortConfiguration.expressions</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<AsSortExpression> expressions;
	
	public AbstractAsSortConfiguration()
	{
		// default constructor
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setName(final Map<String,String> name)
	{
		this.name = name;
	}

		
	
	public Map<String,String> getName() 
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
	
		
	
	public void setApplyPromotedItems(final boolean applyPromotedItems)
	{
		this.applyPromotedItems = applyPromotedItems;
	}

		
	
	public boolean isApplyPromotedItems() 
	{
		return applyPromotedItems;
	}
	
		
	
	public void setHighlightPromotedItems(final boolean highlightPromotedItems)
	{
		this.highlightPromotedItems = highlightPromotedItems;
	}

		
	
	public boolean isHighlightPromotedItems() 
	{
		return highlightPromotedItems;
	}
	
		
	
	public void setExpressions(final List<AsSortExpression> expressions)
	{
		this.expressions = expressions;
	}

		
	
	public List<AsSortExpression> getExpressions() 
	{
		return expressions;
	}
	


}
