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

import com.hybris.mobile.lib.commerce.data.user.User;
import java.util.Date;

public class Review  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>Review.date</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Date date;
	/** <i>Generated property</i> for <code>Review.principal</code> property defined at extension <code>commercewebservicescommons</code>. */
	private User principal;
	/** <i>Generated property</i> for <code>Review.rating</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double rating;
	/** <i>Generated property</i> for <code>Review.alias</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String alias;
	/** <i>Generated property</i> for <code>Review.comment</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String comment;
	/** <i>Generated property</i> for <code>Review.id</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String id;
	/** <i>Generated property</i> for <code>Review.headline</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String headline;
		
	public Review()
	{
		// default constructor
	}
	
		
	public void setDate(final Date date)
	{
		this.date = date;
	}
	
		
	public Date getDate() 
	{
		return date;
	}
		
		
	public void setPrincipal(final User principal)
	{
		this.principal = principal;
	}
	
		
	public User getPrincipal() 
	{
		return principal;
	}
		
		
	public void setRating(final Double rating)
	{
		this.rating = rating;
	}
	
		
	public Double getRating() 
	{
		return rating;
	}
		
		
	public void setAlias(final String alias)
	{
		this.alias = alias;
	}
	
		
	public String getAlias() 
	{
		return alias;
	}
		
		
	public void setComment(final String comment)
	{
		this.comment = comment;
	}
	
		
	public String getComment() 
	{
		return comment;
	}
		
		
	public void setId(final String id)
	{
		this.id = id;
	}
	
		
	public String getId() 
	{
		return id;
	}
		
		
	public void setHeadline(final String headline)
	{
		this.headline = headline;
	}
	
		
	public String getHeadline() 
	{
		return headline;
	}
		
	
}