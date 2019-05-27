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
package com.hybris.mobile.lib.commerce.data.catalog;

import com.hybris.mobile.lib.commerce.data.catalog.AbstractCatalogItem;
import com.hybris.mobile.lib.commerce.data.catalog.CatalogVersion;
import java.util.Collection;

public class Catalog extends AbstractCatalogItem 
{

	/** <i>Generated property</i> for <code>Catalog.catalogVersions</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Collection<CatalogVersion> catalogVersions;
		
	public Catalog()
	{
		// default constructor
	}
	
		
	public void setCatalogVersions(final Collection<CatalogVersion> catalogVersions)
	{
		this.catalogVersions = catalogVersions;
	}
	
		
	public Collection<CatalogVersion> getCatalogVersions() 
	{
		return catalogVersions;
	}
		
	
}