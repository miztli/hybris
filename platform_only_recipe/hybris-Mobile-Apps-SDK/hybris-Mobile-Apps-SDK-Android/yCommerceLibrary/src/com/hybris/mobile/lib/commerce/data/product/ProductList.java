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

import com.hybris.mobile.lib.commerce.data.product.Product;
import java.util.List;

public class ProductList  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>ProductList.catalog</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String catalog;
	/** <i>Generated property</i> for <code>ProductList.totalPageCount</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer totalPageCount;
	/** <i>Generated property</i> for <code>ProductList.currentPage</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer currentPage;
	/** <i>Generated property</i> for <code>ProductList.version</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String version;
	/** <i>Generated property</i> for <code>ProductList.products</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Product> products;
	/** <i>Generated property</i> for <code>ProductList.totalProductCount</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer totalProductCount;
		
	public ProductList()
	{
		// default constructor
	}
	
		
	public void setCatalog(final String catalog)
	{
		this.catalog = catalog;
	}
	
		
	public String getCatalog() 
	{
		return catalog;
	}
		
		
	public void setTotalPageCount(final Integer totalPageCount)
	{
		this.totalPageCount = totalPageCount;
	}
	
		
	public Integer getTotalPageCount() 
	{
		return totalPageCount;
	}
		
		
	public void setCurrentPage(final Integer currentPage)
	{
		this.currentPage = currentPage;
	}
	
		
	public Integer getCurrentPage() 
	{
		return currentPage;
	}
		
		
	public void setVersion(final String version)
	{
		this.version = version;
	}
	
		
	public String getVersion() 
	{
		return version;
	}
		
		
	public void setProducts(final List<Product> products)
	{
		this.products = products;
	}
	
		
	public List<Product> getProducts() 
	{
		return products;
	}
		
		
	public void setTotalProductCount(final Integer totalProductCount)
	{
		this.totalProductCount = totalProductCount;
	}
	
		
	public Integer getTotalProductCount() 
	{
		return totalProductCount;
	}
		
	
}