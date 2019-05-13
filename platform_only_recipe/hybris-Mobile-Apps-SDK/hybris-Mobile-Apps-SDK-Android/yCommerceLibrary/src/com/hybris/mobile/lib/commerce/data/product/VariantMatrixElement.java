/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 1, 2015 2:19:46 PM
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

import java.util.List;

public class VariantMatrixElement extends VariantMatrixElementBase
{

	private List<VariantMatrixElement> elements;
	/** <i>Generated property</i> for <code>VariantMatrixElement.variantValueCategory</code> property defined at extension <code>commercewebservicescommons</code>. */
	private VariantValueCategory variantValueCategory;

	public List<VariantMatrixElement> getElements() {
		return elements;
	}

	public void setElements(List<VariantMatrixElement> elements) {
		this.elements = elements;
	}

	/** <i>Generated property</i> for <code>VariantMatrixElement.isLeaf</code> property defined at extension <code>commercewebservicescommons</code>. */



	public void setVariantValueCategory(final VariantValueCategory variantValueCategory)
	{
		this.variantValueCategory = variantValueCategory;
	}
	
		
	public VariantValueCategory getVariantValueCategory() 
	{
		return variantValueCategory;
	}

	
}