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
package de.hybris.platform.personalizationpromotionsweb.data;

import de.hybris.platform.personalizationfacades.data.ActionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CxPromotionAction details
 */
@ApiModel(value="cxPromotionAction", description="CxPromotionAction details")
public  class CxPromotionActionData extends ActionData 
{

 

	/** ID of the promotion<br/><br/><i>Generated property</i> for <code>CxPromotionActionData.promotionId</code> property defined at extension <code>personalizationpromotionsweb</code>. */
	@ApiModelProperty(name="promotionId", value="ID of the promotion") 	
	private String promotionId;
	
	public CxPromotionActionData()
	{
		// default constructor
	}
	
		
	
	public void setPromotionId(final String promotionId)
	{
		this.promotionId = promotionId;
	}

		
	
	public String getPromotionId() 
	{
		return promotionId;
	}
	


}
