/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
package de.hybris.platform.ycommercewebservices.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.ProductData;
import java.util.List;

public  class ProductDataList  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ProductDataList.products</code> property defined at extension <code>ycommercewebservices</code>. */
		
	private List<ProductData> products;

	/** <i>Generated property</i> for <code>ProductDataList.catalog</code> property defined at extension <code>ycommercewebservices</code>. */
		
	private String catalog;

	/** <i>Generated property</i> for <code>ProductDataList.version</code> property defined at extension <code>ycommercewebservices</code>. */
		
	private String version;

	/** <i>Generated property</i> for <code>ProductDataList.totalProductCount</code> property defined at extension <code>ycommercewebservices</code>. */
		
	private int totalProductCount;

	/** <i>Generated property</i> for <code>ProductDataList.totalPageCount</code> property defined at extension <code>ycommercewebservices</code>. */
		
	private int totalPageCount;

	/** <i>Generated property</i> for <code>ProductDataList.currentPage</code> property defined at extension <code>ycommercewebservices</code>. */
		
	private int currentPage;
	
	public ProductDataList()
	{
		// default constructor
	}
	
		
	
	public void setProducts(final List<ProductData> products)
	{
		this.products = products;
	}

		
	
	public List<ProductData> getProducts() 
	{
		return products;
	}
	
		
	
	public void setCatalog(final String catalog)
	{
		this.catalog = catalog;
	}

		
	
	public String getCatalog() 
	{
		return catalog;
	}
	
		
	
	public void setVersion(final String version)
	{
		this.version = version;
	}

		
	
	public String getVersion() 
	{
		return version;
	}
	
		
	
	public void setTotalProductCount(final int totalProductCount)
	{
		this.totalProductCount = totalProductCount;
	}

		
	
	public int getTotalProductCount() 
	{
		return totalProductCount;
	}
	
		
	
	public void setTotalPageCount(final int totalPageCount)
	{
		this.totalPageCount = totalPageCount;
	}

		
	
	public int getTotalPageCount() 
	{
		return totalPageCount;
	}
	
		
	
	public void setCurrentPage(final int currentPage)
	{
		this.currentPage = currentPage;
	}

		
	
	public int getCurrentPage() 
	{
		return currentPage;
	}
	


}
