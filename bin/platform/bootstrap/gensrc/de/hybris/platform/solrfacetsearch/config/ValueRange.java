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
package de.hybris.platform.solrfacetsearch.config;

import java.io.Serializable;

public  class ValueRange  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ValueRange.name</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>ValueRange.from</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Comparable from;

	/** <i>Generated property</i> for <code>ValueRange.to</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private Comparable to;
	
	public ValueRange()
	{
		// default constructor
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setFrom(final Comparable from)
	{
		this.from = from;
	}

		
	
	public Comparable getFrom() 
	{
		return from;
	}
	
		
	
	public void setTo(final Comparable to)
	{
		this.to = to;
	}

		
	
	public Comparable getTo() 
	{
		return to;
	}
	


}
