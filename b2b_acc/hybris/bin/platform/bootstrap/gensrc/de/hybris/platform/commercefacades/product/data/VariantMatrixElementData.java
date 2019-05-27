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
import de.hybris.platform.commercefacades.product.data.VariantCategoryData;
import de.hybris.platform.commercefacades.product.data.VariantMatrixElementData;
import de.hybris.platform.commercefacades.product.data.VariantOptionData;
import de.hybris.platform.commercefacades.product.data.VariantValueCategoryData;
import java.util.List;

public  class VariantMatrixElementData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.variantValueCategory</code> property defined at extension <code>commercefacades</code>. */
		
	private VariantValueCategoryData variantValueCategory;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.parentVariantCategory</code> property defined at extension <code>commercefacades</code>. */
		
	private VariantCategoryData parentVariantCategory;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.variantOption</code> property defined at extension <code>commercefacades</code>. */
		
	private VariantOptionData variantOption;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.elements</code> property defined at extension <code>commercefacades</code>. */
		
	private List<VariantMatrixElementData> elements;

	/** <i>Generated property</i> for <code>VariantMatrixElementData.isLeaf</code> property defined at extension <code>commercefacades</code>. */
		
	private Boolean isLeaf;
	
	public VariantMatrixElementData()
	{
		// default constructor
	}
	
		
	
	public void setVariantValueCategory(final VariantValueCategoryData variantValueCategory)
	{
		this.variantValueCategory = variantValueCategory;
	}

		
	
	public VariantValueCategoryData getVariantValueCategory() 
	{
		return variantValueCategory;
	}
	
		
	
	public void setParentVariantCategory(final VariantCategoryData parentVariantCategory)
	{
		this.parentVariantCategory = parentVariantCategory;
	}

		
	
	public VariantCategoryData getParentVariantCategory() 
	{
		return parentVariantCategory;
	}
	
		
	
	public void setVariantOption(final VariantOptionData variantOption)
	{
		this.variantOption = variantOption;
	}

		
	
	public VariantOptionData getVariantOption() 
	{
		return variantOption;
	}
	
		
	
	public void setElements(final List<VariantMatrixElementData> elements)
	{
		this.elements = elements;
	}

		
	
	public List<VariantMatrixElementData> getElements() 
	{
		return elements;
	}
	
		
	
	public void setIsLeaf(final Boolean isLeaf)
	{
		this.isLeaf = isLeaf;
	}

		
	
	public Boolean getIsLeaf() 
	{
		return isLeaf;
	}
	


}
