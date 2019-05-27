/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
package de.hybris.platform.acceleratorservices.data;

import java.io.Serializable;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.product.ProductModel;

/**
 * Holds context data for rendering the current request
 */
public  class RequestContextData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>RequestContextData.product</code> property defined at extension <code>acceleratorcms</code>. */
		
	private ProductModel product;

	/** <i>Generated property</i> for <code>RequestContextData.category</code> property defined at extension <code>acceleratorcms</code>. */
		
	private CategoryModel category;

	/** <i>Generated property</i> for <code>RequestContextData.search</code> property defined at extension <code>acceleratorcms</code>. */
		
	private SearchPageData search;
	
	public RequestContextData()
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
	
		
	
	public void setCategory(final CategoryModel category)
	{
		this.category = category;
	}

		
	
	public CategoryModel getCategory() 
	{
		return category;
	}
	
		
	
	public void setSearch(final SearchPageData search)
	{
		this.search = search;
	}

		
	
	public SearchPageData getSearch() 
	{
		return search;
	}
	


}
