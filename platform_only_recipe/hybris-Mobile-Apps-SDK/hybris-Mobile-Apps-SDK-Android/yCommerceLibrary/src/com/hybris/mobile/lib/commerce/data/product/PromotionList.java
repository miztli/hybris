/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:22 PM
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

import com.hybris.mobile.lib.commerce.data.product.Promotion;
import java.util.List;

public class PromotionList  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>PromotionList.promotions</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Promotion> promotions;
		
	public PromotionList()
	{
		// default constructor
	}
	
		
	public void setPromotions(final List<Promotion> promotions)
	{
		this.promotions = promotions;
	}
	
		
	public List<Promotion> getPromotions() 
	{
		return promotions;
	}
		
	
}