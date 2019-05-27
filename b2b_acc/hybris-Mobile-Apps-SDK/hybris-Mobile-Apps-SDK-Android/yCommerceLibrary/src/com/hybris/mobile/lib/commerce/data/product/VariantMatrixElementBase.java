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

public class VariantMatrixElementBase implements java.io.Serializable {

	/**
	 * <i>Generated property</i> for <code>VariantMatrixElement.parentVariantCategory</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private VariantCategory parentVariantCategory;
	/**
	 * <i>Generated property</i> for <code>VariantMatrixElement.variantOption</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private VariantOption variantOption;
	/**
	 * <i>Generated property</i> for <code>VariantMatrixElement.isLeaf</code> property defined at extension <code>commercewebservicescommons</code>.
	 */
	private Boolean isLeaf;

	public VariantMatrixElementBase() {
		// default constructor
	}


	public void setParentVariantCategory(final VariantCategory parentVariantCategory) {
		this.parentVariantCategory = parentVariantCategory;
	}


	public VariantCategory getParentVariantCategory() {
		return parentVariantCategory;
	}


	public void setVariantOption(final VariantOption variantOption) {
		this.variantOption = variantOption;
	}


	public VariantOption getVariantOption() {
		return variantOption;
	}

	public void setIsLeaf(final Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	public Boolean getIsLeaf()
	{
		return isLeaf;
	}


}