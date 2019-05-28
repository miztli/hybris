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
import de.hybris.platform.commercefacades.product.data.PriceData;

public  class LeafDimensionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>LeafDimensionData.leafDimensionHeader</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private String leafDimensionHeader;

	/** <i>Generated property</i> for <code>LeafDimensionData.leafDimensionValue</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private String leafDimensionValue;

	/** <i>Generated property</i> for <code>LeafDimensionData.leafDimensionData</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private String leafDimensionData;

	/** <i>Generated property</i> for <code>LeafDimensionData.sequence</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private int sequence;

	/** <i>Generated property</i> for <code>LeafDimensionData.price</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private PriceData price;
	
	public LeafDimensionData()
	{
		// default constructor
	}
	
		
	
	public void setLeafDimensionHeader(final String leafDimensionHeader)
	{
		this.leafDimensionHeader = leafDimensionHeader;
	}

		
	
	public String getLeafDimensionHeader() 
	{
		return leafDimensionHeader;
	}
	
		
	
	public void setLeafDimensionValue(final String leafDimensionValue)
	{
		this.leafDimensionValue = leafDimensionValue;
	}

		
	
	public String getLeafDimensionValue() 
	{
		return leafDimensionValue;
	}
	
		
	
	public void setLeafDimensionData(final String leafDimensionData)
	{
		this.leafDimensionData = leafDimensionData;
	}

		
	
	public String getLeafDimensionData() 
	{
		return leafDimensionData;
	}
	
		
	
	public void setSequence(final int sequence)
	{
		this.sequence = sequence;
	}

		
	
	public int getSequence() 
	{
		return sequence;
	}
	
		
	
	public void setPrice(final PriceData price)
	{
		this.price = price;
	}

		
	
	public PriceData getPrice() 
	{
		return price;
	}
	


}
