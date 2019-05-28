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
package de.hybris.platform.commerceservices.product.data;

import java.io.Serializable;

public  class SolrFirstVariantCategoryEntryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SolrFirstVariantCategoryEntryData.categoryName</code> property defined at extension <code>commerceservices</code>. */
		
	private String categoryName;

	/** <i>Generated property</i> for <code>SolrFirstVariantCategoryEntryData.variantCode</code> property defined at extension <code>commerceservices</code>. */
		
	private String variantCode;
	
	public SolrFirstVariantCategoryEntryData()
	{
		// default constructor
	}
	
		
	
	public void setCategoryName(final String categoryName)
	{
		this.categoryName = categoryName;
	}

		
	
	public String getCategoryName() 
	{
		return categoryName;
	}
	
		
	
	public void setVariantCode(final String variantCode)
	{
		this.variantCode = variantCode;
	}

		
	
	public String getVariantCode() 
	{
		return variantCode;
	}
	


}
