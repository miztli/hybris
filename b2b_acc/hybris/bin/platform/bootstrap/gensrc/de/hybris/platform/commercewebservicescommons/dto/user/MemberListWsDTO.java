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
package de.hybris.platform.commercewebservicescommons.dto.user;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.user.PrincipalWsDTO;
import java.util.List;

public  class MemberListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MemberListWsDTO.members</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<PrincipalWsDTO> members;
	
	public MemberListWsDTO()
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
	


}
