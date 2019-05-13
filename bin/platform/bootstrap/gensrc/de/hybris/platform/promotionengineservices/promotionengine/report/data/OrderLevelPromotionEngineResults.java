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
package de.hybris.platform.promotionengineservices.promotionengine.report.data;

import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.promotionengineservices.promotionengine.report.data.AbstractPromotionEngineResults;

public  class OrderLevelPromotionEngineResults extends AbstractPromotionEngineResults 
{

 

	/** <i>Generated property</i> for <code>OrderLevelPromotionEngineResults.order</code> property defined at extension <code>promotionengineservices</code>. */
		
	private AbstractOrderModel order;
	
	public OrderLevelPromotionEngineResults()
	{
		// default constructor
	}
	
		
	
	public void setOrder(final AbstractOrderModel order)
	{
		this.order = order;
	}

		
	
	public AbstractOrderModel getOrder() 
	{
		return order;
	}
	


}
