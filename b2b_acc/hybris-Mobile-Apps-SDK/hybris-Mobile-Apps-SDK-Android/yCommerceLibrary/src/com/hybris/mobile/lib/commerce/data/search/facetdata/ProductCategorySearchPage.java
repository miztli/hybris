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
package com.hybris.mobile.lib.commerce.data.search.facetdata;

import com.hybris.mobile.lib.commerce.data.product.Category;
import com.hybris.mobile.lib.commerce.data.search.facetdata.ProductSearchPage;
import java.util.List;

/**
 * POJO containing the result page for product or category search.
 */
public class ProductCategorySearchPage extends ProductSearchPage 
{

	/** <i>Generated property</i> for <code>ProductCategorySearchPage.subCategories</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Category> subCategories;
		
	public ProductCategorySearchPage()
	{
		// default constructor
	}
	
		
	public void setSubCategories(final List<Category> subCategories)
	{
		this.subCategories = subCategories;
	}
	
		
	public List<Category> getSubCategories() 
	{
		return subCategories;
	}
		
	
}