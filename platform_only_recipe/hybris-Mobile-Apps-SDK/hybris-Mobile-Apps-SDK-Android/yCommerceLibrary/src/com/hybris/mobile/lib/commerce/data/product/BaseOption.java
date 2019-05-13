/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:22 PM
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

import com.hybris.mobile.lib.commerce.data.product.VariantOption;
import java.util.List;

public class BaseOption  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>BaseOption.variantType</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String variantType;
	/** <i>Generated property</i> for <code>BaseOption.options</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<VariantOption> options;
	/** <i>Generated property</i> for <code>BaseOption.selected</code> property defined at extension <code>commercewebservicescommons</code>. */
	private VariantOption selected;
		
	public BaseOption()
	{
		// default constructor
	}
	
		
	public void setVariantType(final String variantType)
	{
		this.variantType = variantType;
	}
	
		
	public String getVariantType() 
	{
		return variantType;
	}
		
		
	public void setOptions(final List<VariantOption> options)
	{
		this.options = options;
	}
	
		
	public List<VariantOption> getOptions() 
	{
		return options;
	}
		
		
	public void setSelected(final VariantOption selected)
	{
		this.selected = selected;
	}
	
		
	public VariantOption getSelected() 
	{
		return selected;
	}
		
	
}