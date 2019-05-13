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
package de.hybris.platform.commercefacades.storelocator.data;

import java.io.Serializable;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.storelocator.model.PointOfServiceModel;

public  class StoreStockHolder  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StoreStockHolder.product</code> property defined at extension <code>commercefacades</code>. */
		
	private ProductModel product;

	/** <i>Generated property</i> for <code>StoreStockHolder.pointOfService</code> property defined at extension <code>commercefacades</code>. */
		
	private PointOfServiceModel pointOfService;
	
	public StoreStockHolder()
	{
		// default constructor
	}
	
		
	
	public void setProduct(final ProductModel product)
	{
		this.product = product;
	}

		
	
	public ProductModel getProduct() 
	{
		return product;
	}
	
		
	
	public void setPointOfService(final PointOfServiceModel pointOfService)
	{
		this.pointOfService = pointOfService;
	}

		
	
	public PointOfServiceModel getPointOfService() 
	{
		return pointOfService;
	}
	


}
