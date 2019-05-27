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
package com.hybris.mobile.lib.commerce.data.search.pagedata;

/**
 * POJO representation of search query pagination.
 */
public class Pageable  implements java.io.Serializable 
{

	/** The number of results per page. A page may have less results if there are less than a full page
				of results, only on the last page in the results.
			<br/><br/><i>Generated property</i> for <code>Pageable.pageSize</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer pageSize;
	/** The selected sort code.<br/><br/><i>Generated property</i> for <code>Pageable.sort</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String sort;
	/** The current page number. The first page is number zero (0), the second page is number one (1),
				and so on.
			<br/><br/><i>Generated property</i> for <code>Pageable.currentPage</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer currentPage;
		
	public Pageable()
	{
		// default constructor
	}
	
		
	public void setPageSize(final Integer pageSize)
	{
		this.pageSize = pageSize;
	}
	
		
	public Integer getPageSize() 
	{
		return pageSize;
	}
		
		
	public void setSort(final String sort)
	{
		this.sort = sort;
	}
	
		
	public String getSort() 
	{
		return sort;
	}
		
		
	public void setCurrentPage(final Integer currentPage)
	{
		this.currentPage = currentPage;
	}
	
		
	public Integer getCurrentPage() 
	{
		return currentPage;
	}
		
	
}