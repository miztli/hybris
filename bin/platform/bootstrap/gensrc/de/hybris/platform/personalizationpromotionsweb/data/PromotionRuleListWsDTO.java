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
package de.hybris.platform.personalizationpromotionsweb.data;

import java.io.Serializable;
import de.hybris.platform.personalizationpromotionsweb.data.PromotionRuleWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * List of promotion rules
 */
@ApiModel(value="segmentList", description="List of promotion rules")
public  class PromotionRuleListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** List of promotion rules<br/><br/><i>Generated property</i> for <code>PromotionRuleListWsDTO.promotions</code> property defined at extension <code>personalizationpromotionsweb</code>. */
	@ApiModelProperty(name="promotions", value="List of promotion rules") 	
	private List<PromotionRuleWsDTO> promotions;
	
	public PromotionRuleListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setPromotions(final List<PromotionRuleWsDTO> promotions)
	{
		this.promotions = promotions;
	}

		
	
	public List<PromotionRuleWsDTO> getPromotions() 
	{
		return promotions;
	}
	


}
