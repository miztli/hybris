/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
import de.hybris.platform.basecommerce.enums.StockLevelStatus;

public  class StockData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StockData.stockLevelStatus</code> property defined at extension <code>commercefacades</code>. */
		
	private StockLevelStatus stockLevelStatus;

	/** <i>Generated property</i> for <code>StockData.stockLevel</code> property defined at extension <code>commercefacades</code>. */
		
	private Long stockLevel;

	/** <i>Generated property</i> for <code>StockData.stockThreshold</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private Integer stockThreshold;
	
	public StockData()
	{
		// default constructor
	}
	
		
	
	public void setStockLevelStatus(final StockLevelStatus stockLevelStatus)
	{
		this.stockLevelStatus = stockLevelStatus;
	}

		
	
	public StockLevelStatus getStockLevelStatus() 
	{
		return stockLevelStatus;
	}
	
		
	
	public void setStockLevel(final Long stockLevel)
	{
		this.stockLevel = stockLevel;
	}

		
	
	public Long getStockLevel() 
	{
		return stockLevel;
	}
	
		
	
	public void setStockThreshold(final Integer stockThreshold)
	{
		this.stockThreshold = stockThreshold;
	}

		
	
	public Integer getStockThreshold() 
	{
		return stockThreshold;
	}
	


}
