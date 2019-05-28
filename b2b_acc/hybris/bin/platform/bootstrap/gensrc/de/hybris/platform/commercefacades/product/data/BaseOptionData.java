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
package de.hybris.platform.commercefacades.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.VariantOptionData;
import java.util.List;

public  class BaseOptionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>BaseOptionData.variantType</code> property defined at extension <code>commercefacades</code>. */
		
	private String variantType;

	/** <i>Generated property</i> for <code>BaseOptionData.options</code> property defined at extension <code>commercefacades</code>. */
		
	private List<VariantOptionData> options;

	/** <i>Generated property</i> for <code>BaseOptionData.selected</code> property defined at extension <code>commercefacades</code>. */
		
	private VariantOptionData selected;
	
	public BaseOptionData()
	{
		// default constructor
	}
	
		
	
	public void setVariantType(final String variantType)
	{
		this.variantType = variantType;
	}

		
	
	public String getVariantType() 
	{
		return variantType;
	}
	
		
	
	public void setOptions(final List<VariantOptionData> options)
	{
		this.options = options;
	}

		
	
	public List<VariantOptionData> getOptions() 
	{
		return options;
	}
	
		
	
	public void setSelected(final VariantOptionData selected)
	{
		this.selected = selected;
	}

		
	
	public VariantOptionData getSelected() 
	{
		return selected;
	}
	


}
