/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:22 PM
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
package com.hybris.mobile.lib.commerce.data.order;

import com.hybris.mobile.lib.commerce.data.product.PromotionResult;
import com.hybris.mobile.lib.commerce.data.user.Principal;

import java.util.Date;
import java.util.List;

public class Cart extends AbstractOrder
{

	/** <i>Generated property</i> for <code>Cart.potentialOrderPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<PromotionResult> potentialOrderPromotions;
	/** <i>Generated property</i> for <code>Cart.potentialProductPromotions</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<PromotionResult> potentialProductPromotions;
	/** <i>Generated property</i> for <code>Cart.expirationTime</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date expirationTime;
	/** <i>Generated property</i> for <code>Cart.totalUnitCount</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Integer totalUnitCount;
	/** <i>Generated property</i> for <code>Cart.name</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String name;
	/** <i>Generated property</i> for <code>Cart.description</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String description;
	/** <i>Generated property</i> for <code>Cart.saveTime</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date saveTime;
	/** <i>Generated property</i> for <code>Cart.savedBy</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Principal savedBy;

	public Cart()
	{
		// default constructor
	}


	public void setPotentialOrderPromotions(final List<PromotionResult> potentialOrderPromotions)
	{
		this.potentialOrderPromotions = potentialOrderPromotions;
	}


	public List<PromotionResult> getPotentialOrderPromotions()
	{
		return potentialOrderPromotions;
	}


	public void setPotentialProductPromotions(final List<PromotionResult> potentialProductPromotions)
	{
		this.potentialProductPromotions = potentialProductPromotions;
	}


	public List<PromotionResult> getPotentialProductPromotions()
	{
		return potentialProductPromotions;
	}


	public void setExpirationTime(final Date expirationTime)
	{
		this.expirationTime = expirationTime;
	}


	public Date getExpirationTime()
	{
		return expirationTime;
	}


	public void setTotalUnitCount(final Integer totalUnitCount)
	{
		this.totalUnitCount = totalUnitCount;
	}


	public Integer getTotalUnitCount()
	{
		return totalUnitCount;
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


	public void setSaveTime(final Date saveTime)
	{
		this.saveTime = saveTime;
	}


	public Date getSaveTime()
	{
		return saveTime;
	}


	public void setSavedBy(final Principal savedBy)
	{
		this.savedBy = savedBy;
	}


	public Principal getSavedBy()
	{
		return savedBy;
	}


}