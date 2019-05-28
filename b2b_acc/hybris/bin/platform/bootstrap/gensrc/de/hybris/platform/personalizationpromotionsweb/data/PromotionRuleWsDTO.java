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

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Promotion rule details
 */
@ApiModel(value="promotionRule", description="Promotion rule details")
public  class PromotionRuleWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** Code of the promotion rule<br/><br/><i>Generated property</i> for <code>PromotionRuleWsDTO.code</code> property defined at extension <code>personalizationpromotionsweb</code>. */
	@ApiModelProperty(name="code", value="Code of the promotion rule", required=true) 	
	private String code;

	/** Name of the promotion rule<br/><br/><i>Generated property</i> for <code>PromotionRuleWsDTO.name</code> property defined at extension <code>personalizationpromotionsweb</code>. */
	@ApiModelProperty(name="name", value="Name of the promotion rule") 	
	private String name;

	/** Description of the promotion rule<br/><br/><i>Generated property</i> for <code>PromotionRuleWsDTO.description</code> property defined at extension <code>personalizationpromotionsweb</code>. */
	@ApiModelProperty(name="description", value="Description of the promotion rule") 	
	private String description;

	/** Status of the promotion rule<br/><br/><i>Generated property</i> for <code>PromotionRuleWsDTO.status</code> property defined at extension <code>personalizationpromotionsweb</code>. */
	@ApiModelProperty(name="status", value="Status of the promotion rule") 	
	private String status;

	/** Promotion group of the promotion rule<br/><br/><i>Generated property</i> for <code>PromotionRuleWsDTO.promotionGroup</code> property defined at extension <code>personalizationpromotionsweb</code>. */
	@ApiModelProperty(name="promotionGroup", value="Promotion group of the promotion rule") 	
	private String promotionGroup;
	
	public PromotionRuleWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	
		
	
	public void setStatus(final String status)
	{
		this.status = status;
	}

		
	
	public String getStatus() 
	{
		return status;
	}
	
		
	
	public void setPromotionGroup(final String promotionGroup)
	{
		this.promotionGroup = promotionGroup;
	}

		
	
	public String getPromotionGroup() 
	{
		return promotionGroup;
	}
	


}
