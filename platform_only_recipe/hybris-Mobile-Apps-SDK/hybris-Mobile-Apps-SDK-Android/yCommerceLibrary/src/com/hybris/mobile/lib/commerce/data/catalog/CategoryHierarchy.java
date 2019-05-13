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
package com.hybris.mobile.lib.commerce.data.catalog;

import android.os.Parcel;
import android.os.Parcelable;

import com.hybris.mobile.lib.commerce.data.product.Product;

import java.util.List;

public class CategoryHierarchy extends AbstractCatalogItem implements Parcelable {

	/** <i>Generated property</i> for <code>CategoryHierarchy.totalNumber</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer totalNumber;

	/** <i>Generated property</i> for <code>CategoryHierarchy.numberOfPages</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer numberOfPages;

	/** <i>Generated property</i> for <code>CategoryHierarchy.pageSize</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer pageSize;

	/** <i>Generated property</i> for <code>CategoryHierarchy.currentPage</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer currentPage;

	/** <i>Generated property</i> for <code>CategoryHierarchy.subcategories</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<CategoryHierarchy> subcategories;

	/** <i>Generated property</i> for <code>CategoryHierarchy.products</code> property defined at extension <code>b2boccaddon</code>. */
	private List<Product> products;

	private CategoryHierarchy parent;
		
	public CategoryHierarchy()
	{
		// default constructor
	}
	
		
	public void setTotalNumber(final Integer totalNumber)
	{
		this.totalNumber = totalNumber;
	}
	
		
	public Integer getTotalNumber() 
	{
		return totalNumber;
	}
		
		
	public void setNumberOfPages(final Integer numberOfPages)
	{
		this.numberOfPages = numberOfPages;
	}
	
		
	public Integer getNumberOfPages() 
	{
		return numberOfPages;
	}
		
		
	public void setPageSize(final Integer pageSize)
	{
		this.pageSize = pageSize;
	}
	
		
	public Integer getPageSize() 
	{
		return pageSize;
	}
		
		
	public void setCurrentPage(final Integer currentPage)
	{
		this.currentPage = currentPage;
	}
	
		
	public Integer getCurrentPage() 
	{
		return currentPage;
	}
		
		
	public void setSubcategories(final List<CategoryHierarchy> subcategories)
	{
		this.subcategories = subcategories;
	}
	
		
	public List<CategoryHierarchy> getSubcategories() 
	{
		return subcategories;
	}
		
		
	public void setProducts(final List<Product> products)
	{
		this.products = products;
	}
	
		
	public List<Product> getProducts() 
	{
		return products;
	}

	/**
	 * Set the parent for the current node and each subcategories
	 *
	 * @param parent Parent Category to modify
	 */
	public void setParent(CategoryHierarchy parent) {
		this.parent = parent;

		if (subcategories != null) {
			for (CategoryHierarchy catalog : subcategories) {
				catalog.setParent(this);
			}
		}
	}

	public CategoryHierarchy getParent() {
		return parent;
	}

	public static final Parcelable.Creator<CategoryHierarchy> CREATOR = new Parcelable.Creator<CategoryHierarchy>() {
		@Override
		public CategoryHierarchy createFromParcel(Parcel source) {
			return new CategoryHierarchy(source);
		}

		@Override
		public CategoryHierarchy[] newArray(int size) {
			return new CategoryHierarchy[size];
		}
	};

	public CategoryHierarchy(Parcel in) {
		setId(in.readString());
		setName(in.readString());
		parent = in.readParcelable(this.getClass().getClassLoader());
	}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getId());
		dest.writeString(getName());
		dest.writeParcelable(parent, flags);
	}

}