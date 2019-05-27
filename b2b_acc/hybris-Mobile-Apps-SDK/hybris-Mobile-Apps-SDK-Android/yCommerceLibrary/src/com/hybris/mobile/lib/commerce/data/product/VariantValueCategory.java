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
package com.hybris.mobile.lib.commerce.data.product;

import com.hybris.mobile.lib.commerce.data.product.VariantCategory;
import java.util.Collection;

public class VariantValueCategory  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>VariantValueCategory.superCategories</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Collection<VariantCategory> superCategories;
	/** <i>Generated property</i> for <code>VariantValueCategory.sequence</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer sequence;
	/** <i>Generated property</i> for <code>VariantValueCategory.name</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String name;
		
	public VariantValueCategory()
	{
		// default constructor
	}
	
		
	public void setSuperCategories(final Collection<VariantCategory> superCategories)
	{
		this.superCategories = superCategories;
	}
	
		
	public Collection<VariantCategory> getSuperCategories() 
	{
		return superCategories;
	}
		
		
	public void setSequence(final Integer sequence)
	{
		this.sequence = sequence;
	}
	
		
	public Integer getSequence() 
	{
		return sequence;
	}
		
		
	public void setName(final String name)
	{
		this.name = name;
	}
	
		
	public String getName() 
	{
		return name;
	}
		
	
}