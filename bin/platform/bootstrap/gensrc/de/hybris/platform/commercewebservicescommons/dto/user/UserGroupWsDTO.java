/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
package de.hybris.platform.commercewebservicescommons.dto.user;

import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import java.util.List;

public  class UserGroupWsDTO extends PrincipalWsDTO 
{

 

	/** <i>Generated property</i> for <code>UserGroupWsDTO.members</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<PrincipalWsDTO> members;

	/** <i>Generated property</i> for <code>UserGroupWsDTO.subGroups</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<UserGroupWsDTO> subGroups;

	/** <i>Generated property</i> for <code>UserGroupWsDTO.membersCount</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Integer membersCount;
	
	public UserGroupWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setMembers(final List<PrincipalWsDTO> members)
	{
		this.members = members;
	}

		
	
	public List<PrincipalWsDTO> getMembers() 
	{
		return members;
	}
	
		
	
	public void setSubGroups(final List<UserGroupWsDTO> subGroups)
	{
		this.subGroups = subGroups;
	}

		
	
	public List<UserGroupWsDTO> getSubGroups() 
	{
		return subGroups;
	}
	
		
	
	public void setMembersCount(final Integer membersCount)
	{
		this.membersCount = membersCount;
	}

		
	
	public Integer getMembersCount() 
	{
		return membersCount;
	}
	


}
