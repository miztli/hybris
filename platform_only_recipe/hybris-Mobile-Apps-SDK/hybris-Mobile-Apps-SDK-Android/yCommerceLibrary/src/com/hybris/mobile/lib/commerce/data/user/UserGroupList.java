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
package com.hybris.mobile.lib.commerce.data.user;

import com.hybris.mobile.lib.commerce.data.user.UserGroup;
import java.util.List;

public class UserGroupList  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>UserGroupList.userGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<UserGroup> userGroups;
	/** <i>Generated property</i> for <code>UserGroupList.totalNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer totalNumber;
	/** <i>Generated property</i> for <code>UserGroupList.numberOfPages</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer numberOfPages;
	/** <i>Generated property</i> for <code>UserGroupList.pageSize</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer pageSize;
	/** <i>Generated property</i> for <code>UserGroupList.currentPage</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer currentPage;
		
	public UserGroupList()
	{
		// default constructor
	}
	
		
	public void setUserGroups(final List<UserGroup> userGroups)
	{
		this.userGroups = userGroups;
	}
	
		
	public List<UserGroup> getUserGroups() 
	{
		return userGroups;
	}
		
		
	public void setTotalNumber(final Integer totalNumber)
	{
		this.totalNumber = totalNumber;
	}
	
		
	public Integer getTotalNumber() 
	{
		return totalNumber;
	}
		
		
	public void setNumberOfPages(final Integer numberOfPages)
	{
		this.numberOfPages = numberOfPages;
	}
	
		
	public Integer getNumberOfPages() 
	{
		return numberOfPages;
	}
		
		
	public void setPageSize(final Integer pageSize)
	{
		this.pageSize = pageSize;
	}
	
		
	public Integer getPageSize() 
	{
		return pageSize;
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