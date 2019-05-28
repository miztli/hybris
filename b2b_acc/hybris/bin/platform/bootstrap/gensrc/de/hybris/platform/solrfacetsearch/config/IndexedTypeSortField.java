/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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

public  class IndexedTypeSortField  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>IndexedTypeSortField.fieldName</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private String fieldName;

	/** <i>Generated property</i> for <code>IndexedTypeSortField.ascending</code> property defined at extension <code>solrfacetsearch</code>. */
		
	private boolean ascending;
	
	public IndexedTypeSortField()
	{
		// default constructor
	}
	
		
	
	public void setFieldName(final String fieldName)
	{
		this.fieldName = fieldName;
	}

		
	
	public String getFieldName() 
	{
		return fieldName;
	}
	
		
	
	public void setAscending(final boolean ascending)
	{
		this.ascending = ascending;
	}

		
	
	public boolean isAscending() 
	{
		return ascending;
	}
	


}
