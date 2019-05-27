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

import com.hybris.mobile.lib.commerce.data.product.FeatureUnit;
import com.hybris.mobile.lib.commerce.data.product.FeatureValue;
import java.util.Collection;

public class Feature  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Feature.featureUnit</code> property defined at extension <code>commercewebservicescommons</code>. */
	private FeatureUnit featureUnit;
	/** <i>Generated property</i> for <code>Feature.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>Feature.name</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String name;
	/** <i>Generated property</i> for <code>Feature.description</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String description;
	/** <i>Generated property</i> for <code>Feature.range</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean range;
	/** <i>Generated property</i> for <code>Feature.type</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String type;
	/** <i>Generated property</i> for <code>Feature.comparable</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean comparable;
	/** <i>Generated property</i> for <code>Feature.featureValues</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Collection<FeatureValue> featureValues;
		
	public Feature()
	{
		// default constructor
	}
	
		
	public void setFeatureUnit(final FeatureUnit featureUnit)
	{
		this.featureUnit = featureUnit;
	}
	
		
	public FeatureUnit getFeatureUnit() 
	{
		return featureUnit;
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
		
		
	public void setDescription(final String description)
	{
		this.description = description;
	}
	
		
	public String getDescription() 
	{
		return description;
	}
		
		
	public void setRange(final Boolean range)
	{
		this.range = range;
	}
	
		
	public Boolean getRange() 
	{
		return range;
	}
		
		
	public void setType(final String type)
	{
		this.type = type;
	}
	
		
	public String getType() 
	{
		return type;
	}
		
		
	public void setComparable(final Boolean comparable)
	{
		this.comparable = comparable;
	}
	
		
	public Boolean getComparable() 
	{
		return comparable;
	}
		
		
	public void setFeatureValues(final Collection<FeatureValue> featureValues)
	{
		this.featureValues = featureValues;
	}
	
		
	public Collection<FeatureValue> getFeatureValues() 
	{
		return featureValues;
	}
		
	
}