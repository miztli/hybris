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
import de.hybris.platform.commercefacades.product.data.ImageData;

public  class CategoryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CategoryData.code</code> property defined at extension <code>commercefacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>CategoryData.name</code> property defined at extension <code>commercefacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>CategoryData.url</code> property defined at extension <code>commercefacades</code>. */
		
	private String url;

	/** <i>Generated property</i> for <code>CategoryData.description</code> property defined at extension <code>commercefacades</code>. */
		
	private String description;

	/** <i>Generated property</i> for <code>CategoryData.image</code> property defined at extension <code>commercefacades</code>. */
		
	private ImageData image;

	/** <i>Generated property</i> for <code>CategoryData.parentCategoryName</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private String parentCategoryName;

	/** <i>Generated property</i> for <code>CategoryData.sequence</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private int sequence;
	
	public CategoryData()
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
	
		
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

		
	
	public String getUrl() 
	{
		return url;
	}
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	
		
	
	public void setImage(final ImageData image)
	{
		this.image = image;
	}

		
	
	public ImageData getImage() 
	{
		return image;
	}
	
		
	
	public void setParentCategoryName(final String parentCategoryName)
	{
		this.parentCategoryName = parentCategoryName;
	}

		
	
	public String getParentCategoryName() 
	{
		return parentCategoryName;
	}
	
		
	
	public void setSequence(final int sequence)
	{
		this.sequence = sequence;
	}

		
	
	public int getSequence() 
	{
		return sequence;
	}
	


}
