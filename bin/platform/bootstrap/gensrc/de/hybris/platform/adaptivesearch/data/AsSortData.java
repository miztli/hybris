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
package de.hybris.platform.adaptivesearch.data;

import java.io.Serializable;

public  class AsSortData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsSortData.code</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>AsSortData.name</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>AsSortData.applyPromotedItems</code> property defined at extension <code>adaptivesearch</code>. */
		
	private boolean applyPromotedItems;

	/** <i>Generated property</i> for <code>AsSortData.highlightPromotedItems</code> property defined at extension <code>adaptivesearch</code>. */
		
	private boolean highlightPromotedItems;
	
	public AsSortData()
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
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setApplyPromotedItems(final boolean applyPromotedItems)
	{
		this.applyPromotedItems = applyPromotedItems;
	}

		
	
	public boolean isApplyPromotedItems() 
	{
		return applyPromotedItems;
	}
	
		
	
	public void setHighlightPromotedItems(final boolean highlightPromotedItems)
	{
		this.highlightPromotedItems = highlightPromotedItems;
	}

		
	
	public boolean isHighlightPromotedItems() 
	{
		return highlightPromotedItems;
	}
	


}
