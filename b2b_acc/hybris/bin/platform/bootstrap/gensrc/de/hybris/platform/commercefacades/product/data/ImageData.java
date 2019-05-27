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
import de.hybris.platform.commercefacades.product.data.ImageDataType;

public  class ImageData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ImageData.imageType</code> property defined at extension <code>commercefacades</code>. */
		
	private ImageDataType imageType;

	/** <i>Generated property</i> for <code>ImageData.format</code> property defined at extension <code>commercefacades</code>. */
		
	private String format;

	/** <i>Generated property</i> for <code>ImageData.url</code> property defined at extension <code>commercefacades</code>. */
		
	private String url;

	/** <i>Generated property</i> for <code>ImageData.altText</code> property defined at extension <code>commercefacades</code>. */
		
	private String altText;

	/** <i>Generated property</i> for <code>ImageData.galleryIndex</code> property defined at extension <code>commercefacades</code>. */
		
	private Integer galleryIndex;

	/** <i>Generated property</i> for <code>ImageData.width</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private Integer width;
	
	public ImageData()
	{
		// default constructor
	}
	
		
	
	public void setImageType(final ImageDataType imageType)
	{
		this.imageType = imageType;
	}

		
	
	public ImageDataType getImageType() 
	{
		return imageType;
	}
	
		
	
	public void setFormat(final String format)
	{
		this.format = format;
	}

		
	
	public String getFormat() 
	{
		return format;
	}
	
		
	
	public void setUrl(final String url)
	{
		this.url = url;
	}

		
	
	public String getUrl() 
	{
		return url;
	}
	
		
	
	public void setAltText(final String altText)
	{
		this.altText = altText;
	}

		
	
	public String getAltText() 
	{
		return altText;
	}
	
		
	
	public void setGalleryIndex(final Integer galleryIndex)
	{
		this.galleryIndex = galleryIndex;
	}

		
	
	public Integer getGalleryIndex() 
	{
		return galleryIndex;
	}
	
		
	
	public void setWidth(final Integer width)
	{
		this.width = width;
	}

		
	
	public Integer getWidth() 
	{
		return width;
	}
	


}
