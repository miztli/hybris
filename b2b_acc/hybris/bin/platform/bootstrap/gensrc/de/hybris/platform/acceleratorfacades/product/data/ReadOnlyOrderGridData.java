/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
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
package de.hybris.platform.acceleratorfacades.product.data;

import java.io.Serializable;
import de.hybris.platform.acceleratorfacades.product.data.LeafDimensionData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import java.util.Map;
import java.util.Set;

public  class ReadOnlyOrderGridData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReadOnlyOrderGridData.dimensionHeaderMap</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private Map<String,String> dimensionHeaderMap;

	/** <i>Generated property</i> for <code>ReadOnlyOrderGridData.leafDimensionDataSet</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private Set<LeafDimensionData> leafDimensionDataSet;

	/** <i>Generated property</i> for <code>ReadOnlyOrderGridData.product</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private ProductData product;
	
	public ReadOnlyOrderGridData()
	{
		// default constructor
	}
	
		
	
	public void setDimensionHeaderMap(final Map<String,String> dimensionHeaderMap)
	{
		this.dimensionHeaderMap = dimensionHeaderMap;
	}

		
	
	public Map<String,String> getDimensionHeaderMap() 
	{
		return dimensionHeaderMap;
	}
	
		
	
	public void setLeafDimensionDataSet(final Set<LeafDimensionData> leafDimensionDataSet)
	{
		this.leafDimensionDataSet = leafDimensionDataSet;
	}

		
	
	public Set<LeafDimensionData> getLeafDimensionDataSet() 
	{
		return leafDimensionDataSet;
	}
	
		
	
	public void setProduct(final ProductData product)
	{
		this.product = product;
	}

		
	
	public ProductData getProduct() 
	{
		return product;
	}
	


}
