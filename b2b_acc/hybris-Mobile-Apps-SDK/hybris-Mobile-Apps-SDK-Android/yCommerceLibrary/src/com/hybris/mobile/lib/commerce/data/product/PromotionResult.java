/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:23 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.hybris.mobile.lib.commerce.data.product;

import com.hybris.mobile.lib.commerce.data.order.PromotionOrderEntryConsumed;
import com.hybris.mobile.lib.commerce.data.product.Promotion;
import java.util.List;

public class PromotionResult  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>PromotionResult.consumedEntries</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<PromotionOrderEntryConsumed> consumedEntries;
	/** <i>Generated property</i> for <code>PromotionResult.description</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String description;
	/** <i>Generated property</i> for <code>PromotionResult.promotion</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Promotion promotion;
		
	public PromotionResult()
	{
		// default constructor
	}
	
		
	public void setConsumedEntries(final List<PromotionOrderEntryConsumed> consumedEntries)
	{
		this.consumedEntries = consumedEntries;
	}
	
		
	public List<PromotionOrderEntryConsumed> getConsumedEntries() 
	{
		return consumedEntries;
	}
		
		
	public void setDescription(final String description)
	{
		this.description = description;
	}
	
		
	public String getDescription() 
	{
		return description;
	}
		
		
	public void setPromotion(final Promotion promotion)
	{
		this.promotion = promotion;
	}
	
		
	public Promotion getPromotion() 
	{
		return promotion;
	}
		
	
}