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
package com.hybris.mobile.lib.commerce.data.user;

import com.hybris.mobile.lib.commerce.data.user.Principal;
import java.util.List;

public class UserGroup extends Principal 
{

	/** <i>Generated property</i> for <code>UserGroup.membersCount</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer membersCount;
	/** <i>Generated property</i> for <code>UserGroup.members</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Principal> members;
	/** <i>Generated property</i> for <code>UserGroup.subGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<UserGroup> subGroups;
		
	public UserGroup()
	{
		// default constructor
	}
	
		
	public void setMembersCount(final Integer membersCount)
	{
		this.membersCount = membersCount;
	}
	
		
	public Integer getMembersCount() 
	{
		return membersCount;
	}
		
		
	public void setMembers(final List<Principal> members)
	{
		this.members = members;
	}
	
		
	public List<Principal> getMembers() 
	{
		return members;
	}
		
		
	public void setSubGroups(final List<UserGroup> subGroups)
	{
		this.subGroups = subGroups;
	}
	
		
	public List<UserGroup> getSubGroups() 
	{
		return subGroups;
	}
		
	
}