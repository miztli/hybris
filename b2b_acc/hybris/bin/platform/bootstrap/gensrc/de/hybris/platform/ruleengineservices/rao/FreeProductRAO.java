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

import de.hybris.platform.ruleengineservices.rao.AbstractRuleActionRAO;
import de.hybris.platform.ruleengineservices.rao.OrderEntryRAO;

public  class FreeProductRAO extends AbstractRuleActionRAO 
{

 

	/** <i>Generated property</i> for <code>FreeProductRAO.addedOrderEntry</code> property defined at extension <code>ruleengineservices</code>. */
		
	private OrderEntryRAO addedOrderEntry;

	/** <i>Generated property</i> for <code>FreeProductRAO.quantityAdded</code> property defined at extension <code>ruleengineservices</code>. */
		
	private int quantityAdded;
	
	public FreeProductRAO()
	{
		// default constructor
	}
	
		
	
	public void setAddedOrderEntry(final OrderEntryRAO addedOrderEntry)
	{
		this.addedOrderEntry = addedOrderEntry;
	}

		
	
	public OrderEntryRAO getAddedOrderEntry() 
	{
		return addedOrderEntry;
	}
	
		
	
	public void setQuantityAdded(final int quantityAdded)
	{
		this.quantityAdded = quantityAdded;
	}

		
	
	public int getQuantityAdded() 
	{
		return quantityAdded;
	}
	


}
