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
package de.hybris.platform.commercefacades.storefinder.data;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.storefinder.data.StoreFinderSearchPageData;

public  class StoreFinderStockSearchPageData<RESULT> extends StoreFinderSearchPageData<RESULT> 
{

 

	/** <i>Generated property</i> for <code>StoreFinderStockSearchPageData<RESULT>.product</code> property defined at extension <code>commercefacades</code>. */
		
	private ProductData product;
	
	public StoreFinderStockSearchPageData()
	{
		// default constructor
	}
	
		
	
	public void setProduct(final ProductData product)
	{
		this.product = product;
	}

		
	
	public ProductData getProduct() 
	{
		return product;
	}
	


}
