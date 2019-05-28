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
package de.hybris.platform.acceleratorfacades.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.ProductData;

public  class ProductWrapperData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ProductWrapperData.productData</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private ProductData productData;

	/** <i>Generated property</i> for <code>ProductWrapperData.errorMsg</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private String errorMsg;
	
	public ProductWrapperData()
	{
		// default constructor
	}
	
		
	
	public void setProductData(final ProductData productData)
	{
		this.productData = productData;
	}

		
	
	public ProductData getProductData() 
	{
		return productData;
	}
	
		
	
	public void setErrorMsg(final String errorMsg)
	{
		this.errorMsg = errorMsg;
	}

		
	
	public String getErrorMsg() 
	{
		return errorMsg;
	}
	


}
