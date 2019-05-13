/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 13, 2019 5:26:14 PM
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
package de.hybris.platform.core.servicelayer.data;

import java.io.Serializable;

/**
 * POJO representing a sort option.
 */
public  class SortData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SortData.code</code> property defined at extension <code>core</code>. */
		
	private String code;

	/** Direction of sorting. true=ascending, false=descending<br/><br/><i>Generated property</i> for <code>SortData.asc</code> property defined at extension <code>core</code>. */
		
	private boolean asc;
	
	public SortData()
	{
		// default constructor
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setAsc(final boolean asc)
	{
		this.asc = asc;
	}

		
	
	public boolean isAsc() 
	{
		return asc;
	}
	


}
