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

import java.util.Date;

public class AbstractCatalogItem  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>AbstractCatalogItem.name</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String name;
	/** <i>Generated property</i> for <code>AbstractCatalogItem.id</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String id;
	/** <i>Generated property</i> for <code>AbstractCatalogItem.lastModified</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date lastModified;
	/** <i>Generated property</i> for <code>AbstractCatalogItem.url</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String url;
		
	public AbstractCatalogItem()
	{
		// default constructor
	}
	
		
	public void setName(final String name)
	{
		this.name = name;
	}
	
		
	public String getName() 
	{
		return name;
	}
		
		
	public void setId(final String id)
	{
		this.id = id;
	}
	
		
	public String getId() 
	{
		return id;
	}
		
		
	public void setLastModified(final Date lastModified)
	{
		this.lastModified = lastModified;
	}
	
		
	public Date getLastModified() 
	{
		return lastModified;
	}
		
		
	public void setUrl(final String url)
	{
		this.url = url;
	}
	
		
	public String getUrl() 
	{
		return url;
	}
		
	
}