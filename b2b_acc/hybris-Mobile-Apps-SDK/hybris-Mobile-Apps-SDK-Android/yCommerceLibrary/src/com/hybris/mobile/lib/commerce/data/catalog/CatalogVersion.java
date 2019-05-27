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
package com.hybris.mobile.lib.commerce.data.catalog;

import com.hybris.mobile.lib.commerce.data.catalog.AbstractCatalogItem;
import com.hybris.mobile.lib.commerce.data.catalog.CategoryHierarchy;
import java.util.Collection;

public class CatalogVersion extends AbstractCatalogItem 
{

	/** <i>Generated property</i> for <code>CatalogVersion.categories</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Collection<CategoryHierarchy> categories;
		
	public CatalogVersion()
	{
		// default constructor
	}
	
		
	public void setCategories(final Collection<CategoryHierarchy> categories)
	{
		this.categories = categories;
	}
	
		
	public Collection<CategoryHierarchy> getCategories() 
	{
		return categories;
	}
		
	
}