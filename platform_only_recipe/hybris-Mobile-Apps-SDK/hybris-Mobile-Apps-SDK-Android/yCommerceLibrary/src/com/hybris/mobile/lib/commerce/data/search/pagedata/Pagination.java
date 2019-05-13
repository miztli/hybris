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
package com.hybris.mobile.lib.commerce.data.search.pagedata;

import com.hybris.mobile.lib.commerce.data.search.pagedata.Pageable;

/**
 * POJO representation of search results pagination.
 */
public class Pagination extends Pageable 
{

	/** The total number of matched results across all pages.<br/><br/><i>Generated property</i> for <code>Pagination.totalResults</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Long totalResults;
	/** The total number of pages. This is the number of pages, each of pageSize, required to display
				the totalResults.
			<br/><br/><i>Generated property</i> for <code>Pagination.totalPages</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer totalPages;
		
	public Pagination()
	{
		// default constructor
	}
	
		
	public void setTotalResults(final Long totalResults)
	{
		this.totalResults = totalResults;
	}
	
		
	public Long getTotalResults() 
	{
		return totalResults;
	}
		
		
	public void setTotalPages(final Integer totalPages)
	{
		this.totalPages = totalPages;
	}
	
		
	public Integer getTotalPages() 
	{
		return totalPages;
	}
		
	
}