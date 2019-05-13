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
package de.hybris.platform.personalizationservices.data;

import java.io.Serializable;
import java.math.BigDecimal;

public  class UserToSegmentData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserToSegmentData.code</code> property defined at extension <code>personalizationservices</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>UserToSegmentData.affinity</code> property defined at extension <code>personalizationservices</code>. */
		
	private BigDecimal affinity;

	/** <i>Generated property</i> for <code>UserToSegmentData.provider</code> property defined at extension <code>personalizationservices</code>. */
		
	private String provider;

	/** <i>Generated property</i> for <code>UserToSegmentData.description</code> property defined at extension <code>personalizationservices</code>. */
		
	private String description;
	
	public UserToSegmentData()
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
	
		
	
	public void setAffinity(final BigDecimal affinity)
	{
		this.affinity = affinity;
	}

		
	
	public BigDecimal getAffinity() 
	{
		return affinity;
	}
	
		
	
	public void setProvider(final String provider)
	{
		this.provider = provider;
	}

		
	
	public String getProvider() 
	{
		return provider;
	}
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	


}
