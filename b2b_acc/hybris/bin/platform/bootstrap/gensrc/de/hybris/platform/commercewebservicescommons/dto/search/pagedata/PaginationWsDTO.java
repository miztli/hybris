/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:21 PM
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
package de.hybris.platform.commercewebservicescommons.dto.search.pagedata;

import de.hybris.platform.commercewebservicescommons.dto.search.pagedata.PageableWsDTO;

/**
 * POJO representation of search results pagination.
 *
 * @deprecated Since version 6.5 use de.hybris.platform.webservicescommons.dto.PaginationWsDTO instead
 */
@Deprecated
public  class PaginationWsDTO extends PageableWsDTO 
{

 

	/** The total number of pages. This is the number of pages, each of pageSize, required to display
				the totalResults.
			<br/><br/><i>Generated property</i> for <code>PaginationWsDTO.totalPages</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Integer totalPages;

	/** The total number of matched results across all pages.<br/><br/><i>Generated property</i> for <code>PaginationWsDTO.totalResults</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Long totalResults;
	
	public PaginationWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setTotalPages(final Integer totalPages)
	{
		this.totalPages = totalPages;
	}

		
	
	public Integer getTotalPages() 
	{
		return totalPages;
	}
	
		
	
	public void setTotalResults(final Long totalResults)
	{
		this.totalResults = totalResults;
	}

		
	
	public Long getTotalResults() 
	{
		return totalResults;
	}
	


}
