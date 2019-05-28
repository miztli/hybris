/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
package de.hybris.platform.commercefacades.promotion.data;

import java.io.Serializable;

public  class PromotionRestrictionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PromotionRestrictionData.restrictionType</code> property defined at extension <code>commercefacades</code>. */
		
	private String restrictionType;

	/** <i>Generated property</i> for <code>PromotionRestrictionData.description</code> property defined at extension <code>commercefacades</code>. */
		
	private String description;
	
	public PromotionRestrictionData()
	{
		// default constructor
	}
	
		
	
	public void setRestrictionType(final String restrictionType)
	{
		this.restrictionType = restrictionType;
	}

		
	
	public String getRestrictionType() 
	{
		return restrictionType;
	}
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	


}
