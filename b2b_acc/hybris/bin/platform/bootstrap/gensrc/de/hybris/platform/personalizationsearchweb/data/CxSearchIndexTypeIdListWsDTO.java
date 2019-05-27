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
package de.hybris.platform.personalizationsearchweb.data;

import java.io.Serializable;
import java.util.Set;

public  class CxSearchIndexTypeIdListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CxSearchIndexTypeIdListWsDTO.indexTypeIds</code> property defined at extension <code>personalizationsearchweb</code>. */
		
	private Set<String> indexTypeIds;
	
	public CxSearchIndexTypeIdListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setIndexTypeIds(final Set<String> indexTypeIds)
	{
		this.indexTypeIds = indexTypeIds;
	}

		
	
	public Set<String> getIndexTypeIds() 
	{
		return indexTypeIds;
	}
	


}
