/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:21 PM
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

public  class VariantCategoryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>VariantCategoryData.name</code> property defined at extension <code>commercefacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>VariantCategoryData.hasImage</code> property defined at extension <code>commercefacades</code>. */
		
	private Boolean hasImage;

	/** <i>Generated property</i> for <code>VariantCategoryData.priority</code> property defined at extension <code>commercefacades</code>. */
		
	private int priority;
	
	public VariantCategoryData()
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
	
		
	
	public void setHasImage(final Boolean hasImage)
	{
		this.hasImage = hasImage;
	}

		
	
	public Boolean getHasImage() 
	{
		return hasImage;
	}
	
		
	
	public void setPriority(final int priority)
	{
		this.priority = priority;
	}

		
	
	public int getPriority() 
	{
		return priority;
	}
	


}
