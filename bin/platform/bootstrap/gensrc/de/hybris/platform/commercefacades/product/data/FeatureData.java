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
package de.hybris.platform.commercefacades.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.FeatureUnitData;
import de.hybris.platform.commercefacades.product.data.FeatureValueData;
import java.util.Collection;

public  class FeatureData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>FeatureData.code</code> property defined at extension <code>commercefacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>FeatureData.name</code> property defined at extension <code>commercefacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>FeatureData.description</code> property defined at extension <code>commercefacades</code>. */
		
	private String description;

	/** <i>Generated property</i> for <code>FeatureData.type</code> property defined at extension <code>commercefacades</code>. */
		
	private String type;

	/** <i>Generated property</i> for <code>FeatureData.range</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean range;

	/** <i>Generated property</i> for <code>FeatureData.comparable</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean comparable;

	/** <i>Generated property</i> for <code>FeatureData.featureUnit</code> property defined at extension <code>commercefacades</code>. */
		
	private FeatureUnitData featureUnit;

	/** <i>Generated property</i> for <code>FeatureData.featureValues</code> property defined at extension <code>commercefacades</code>. */
		
	private Collection<FeatureValueData> featureValues;
	
	public FeatureData()
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
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	
		
	
	public void setType(final String type)
	{
		this.type = type;
	}

		
	
	public String getType() 
	{
		return type;
	}
	
		
	
	public void setRange(final boolean range)
	{
		this.range = range;
	}

		
	
	public boolean isRange() 
	{
		return range;
	}
	
		
	
	public void setComparable(final boolean comparable)
	{
		this.comparable = comparable;
	}

		
	
	public boolean isComparable() 
	{
		return comparable;
	}
	
		
	
	public void setFeatureUnit(final FeatureUnitData featureUnit)
	{
		this.featureUnit = featureUnit;
	}

		
	
	public FeatureUnitData getFeatureUnit() 
	{
		return featureUnit;
	}
	
		
	
	public void setFeatureValues(final Collection<FeatureValueData> featureValues)
	{
		this.featureValues = featureValues;
	}

		
	
	public Collection<FeatureValueData> getFeatureValues() 
	{
		return featureValues;
	}
	


}
