/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pageable DTO
 */
@ApiModel(value="PageableWsDTO", description="Pageable DTO")
public  class PageableWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageableWsDTO.pageSize</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="pageSize") 	
	private int pageSize;

	/** <i>Generated property</i> for <code>PageableWsDTO.currentPage</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="currentPage") 	
	private int currentPage;

	/** <i>Generated property</i> for <code>PageableWsDTO.sort</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="sort") 	
	private String sort;
	
	public PageableWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setPageSize(final int pageSize)
	{
		this.pageSize = pageSize;
	}

		
	
	public int getPageSize() 
	{
		return pageSize;
	}
	
		
	
	public void setCurrentPage(final int currentPage)
	{
		this.currentPage = currentPage;
	}

		
	
	public int getCurrentPage() 
	{
		return currentPage;
	}
	
		
	
	public void setSort(final String sort)
	{
		this.sort = sort;
	}

		
	
	public String getSort() 
	{
		return sort;
	}
	


}
