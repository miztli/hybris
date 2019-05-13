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

import com.hybris.mobile.lib.commerce.data.product.Feature;
import java.util.Collection;

public class Classification  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Classification.features</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Collection<Feature> features;
	/** <i>Generated property</i> for <code>Classification.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>Classification.name</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String name;
		
	public Classification()
	{
		// default constructor
	}
	
		
	public void setFeatures(final Collection<Feature> features)
	{
		this.features = features;
	}
	
		
	public Collection<Feature> getFeatures() 
	{
		return features;
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
		
	
}