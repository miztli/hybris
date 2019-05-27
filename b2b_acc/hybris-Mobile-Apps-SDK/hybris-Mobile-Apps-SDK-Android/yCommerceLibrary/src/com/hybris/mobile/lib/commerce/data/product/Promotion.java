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

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Promotion  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Promotion.promotionType</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String promotionType;
	/** <i>Generated property</i> for <code>Promotion.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>Promotion.endDate</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date endDate;
	/** <i>Generated property</i> for <code>Promotion.description</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String description;
	/** <i>Generated property</i> for <code>Promotion.restrictions</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Collection<PromotionRestriction> restrictions;
	/** <i>Generated property</i> for <code>Promotion.title</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String title;
	/** <i>Generated property</i> for <code>Promotion.priority</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer priority;
	/** <i>Generated property</i> for <code>Promotion.enabled</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Boolean enabled;
	/** <i>Generated property</i> for <code>Promotion.firedMessages</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<String> firedMessages;
	/** <i>Generated property</i> for <code>Promotion.couldFireMessages</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<String> couldFireMessages;
	/** <i>Generated property</i> for <code>Promotion.promotionGroup</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String promotionGroup;
	/** <i>Generated property</i> for <code>Promotion.productBanner</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Image productBanner;
	/** <i>Generated property</i> for <code>Promotion.startDate</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date startDate;
		
	public Promotion()
	{
		// default constructor
	}
	
		
	public void setPromotionType(final String promotionType)
	{
		this.promotionType = promotionType;
	}
	
		
	public String getPromotionType() 
	{
		return promotionType;
	}
		
		
	public void setCode(final String code)
	{
		this.code = code;
	}
	
		
	public String getCode() 
	{
		return code;
	}
		
		
	public void setEndDate(final Date endDate)
	{
		this.endDate = endDate;
	}
	
		
	public Date getEndDate() 
	{
		return endDate;
	}
		
		
	public void setDescription(final String description)
	{
		this.description = description;
	}
	
		
	public String getDescription() 
	{
		return description;
	}
		
		
	public void setRestrictions(final Collection<PromotionRestriction> restrictions)
	{
		this.restrictions = restrictions;
	}
	
		
	public Collection<PromotionRestriction> getRestrictions() 
	{
		return restrictions;
	}
		
		
	public void setTitle(final String title)
	{
		this.title = title;
	}
	
		
	public String getTitle() 
	{
		return title;
	}
		
		
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}
	
		
	public Integer getPriority() 
	{
		return priority;
	}
		
		
	public void setEnabled(final Boolean enabled)
	{
		this.enabled = enabled;
	}
	
		
	public Boolean getEnabled() 
	{
		return enabled;
	}
		
		
	public void setFiredMessages(final List<String> firedMessages)
	{
		this.firedMessages = firedMessages;
	}
	
		
	public List<String> getFiredMessages() 
	{
		return firedMessages;
	}
		
		
	public void setCouldFireMessages(final List<String> couldFireMessages)
	{
		this.couldFireMessages = couldFireMessages;
	}
	
		
	public List<String> getCouldFireMessages() 
	{
		return couldFireMessages;
	}
		
		
	public void setPromotionGroup(final String promotionGroup)
	{
		this.promotionGroup = promotionGroup;
	}
	
		
	public String getPromotionGroup() 
	{
		return promotionGroup;
	}
		
		
	public void setProductBanner(final Image productBanner)
	{
		this.productBanner = productBanner;
	}
	
		
	public Image getProductBanner() 
	{
		return productBanner;
	}
		
		
	public void setStartDate(final Date startDate)
	{
		this.startDate = startDate;
	}
	
		
	public Date getStartDate() 
	{
		return startDate;
	}
		
	
}