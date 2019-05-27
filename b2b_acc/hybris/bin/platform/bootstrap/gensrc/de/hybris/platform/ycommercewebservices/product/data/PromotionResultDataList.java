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
package de.hybris.platform.ycommercewebservices.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.PromotionResultData;
import java.util.List;

public  class PromotionResultDataList  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PromotionResultDataList.promotions</code> property defined at extension <code>ycommercewebservices</code>. */
		
	private List<PromotionResultData> promotions;
	
	public PromotionResultDataList()
	{
		// default constructor
	}
	
		
	
	public void setPromotions(final List<PromotionResultData> promotions)
	{
		this.promotions = promotions;
	}

		
	
	public List<PromotionResultData> getPromotions() 
	{
		return promotions;
	}
	


}
