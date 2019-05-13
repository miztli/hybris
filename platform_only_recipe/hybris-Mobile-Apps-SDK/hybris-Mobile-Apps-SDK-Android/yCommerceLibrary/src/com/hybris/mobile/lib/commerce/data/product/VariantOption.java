/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:21 PM
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

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Iterator;

public class VariantOption  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>VariantOption.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>VariantOption.priceData</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Price priceData;
	/** <i>Generated property</i> for <code>VariantOption.variantOptionQualifiers</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Collection<VariantOptionQualifier> variantOptionQualifiers;
	/** <i>Generated property</i> for <code>VariantOption.stock</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Stock stock;
	/** <i>Generated property</i> for <code>VariantOption.url</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String url;
		
	public VariantOption()
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
		
		
	public void setPriceData(final Price priceData)
	{
		this.priceData = priceData;
	}
	
		
	public Price getPriceData() 
	{
		return priceData;
	}
		
		
	public void setVariantOptionQualifiers(final Collection<VariantOptionQualifier> variantOptionQualifiers)
	{
		this.variantOptionQualifiers = variantOptionQualifiers;
	}
	
		
	public Collection<VariantOptionQualifier> getVariantOptionQualifiers() 
	{
		return variantOptionQualifiers;
	}
		
		
	public void setStock(final Stock stock)
	{
		this.stock = stock;
	}
	
		
	public Stock getStock() 
	{
		return stock;
	}
		
		
	public void setUrl(final String url)
	{
		this.url = url;
	}
	
		
	public String getUrl() 
	{
		return url;
	}

	public String getImageThumbnailUrl() {

		String thumbnail = "";

		if (variantOptionQualifiers != null && !variantOptionQualifiers.isEmpty()) {

			boolean imageFound = false;
			Iterator<VariantOptionQualifier> iterImages = variantOptionQualifiers.iterator();

			while (iterImages.hasNext() && !imageFound) {
				VariantOptionQualifier variantOptionQualifier = iterImages.next();

				if (variantOptionQualifier.getImage() != null && StringUtils.equals(variantOptionQualifier.getImage().getFormat(), "thumbnail")) {
					thumbnail = variantOptionQualifier.getImage().getUrl();
					imageFound = true;
				}
			}

		}

		return thumbnail;

	}

}