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
package de.hybris.platform.adaptivesearch.data;

import de.hybris.platform.adaptivesearch.data.AbstractAsItemConfiguration;
import de.hybris.platform.adaptivesearch.enums.AsSortOrder;

public  class AsSortExpression extends AbstractAsItemConfiguration 
{

 

	/** <i>Generated property</i> for <code>AsSortExpression.expression</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String expression;

	/** <i>Generated property</i> for <code>AsSortExpression.order</code> property defined at extension <code>adaptivesearch</code>. */
		
	private AsSortOrder order;
	
	public AsSortExpression()
	{
		// default constructor
	}
	
		
	
	public void setExpression(final String expression)
	{
		this.expression = expression;
	}

		
	
	public String getExpression() 
	{
		return expression;
	}
	
		
	
	public void setOrder(final AsSortOrder order)
	{
		this.order = order;
	}

		
	
	public AsSortOrder getOrder() 
	{
		return order;
	}
	


}
