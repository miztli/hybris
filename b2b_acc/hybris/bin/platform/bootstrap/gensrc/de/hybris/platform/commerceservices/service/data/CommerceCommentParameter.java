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
package de.hybris.platform.commerceservices.service.data;

import java.io.Serializable;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.UserModel;

public  class CommerceCommentParameter  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** The ItemModel that will hold the comment<br/><br/><i>Generated property</i> for <code>CommerceCommentParameter.item</code> property defined at extension <code>commerceservices</code>. */
		
	private ItemModel item;

	/** The comment author<br/><br/><i>Generated property</i> for <code>CommerceCommentParameter.author</code> property defined at extension <code>commerceservices</code>. */
		
	private UserModel author;

	/** The comment text<br/><br/><i>Generated property</i> for <code>CommerceCommentParameter.text</code> property defined at extension <code>commerceservices</code>. */
		
	private String text;

	/** The code of the Domain<br/><br/><i>Generated property</i> for <code>CommerceCommentParameter.domainCode</code> property defined at extension <code>commerceservices</code>. */
		
	private String domainCode;

	/** The code of the Component<br/><br/><i>Generated property</i> for <code>CommerceCommentParameter.componentCode</code> property defined at extension <code>commerceservices</code>. */
		
	private String componentCode;

	/** The code of the CommentType<br/><br/><i>Generated property</i> for <code>CommerceCommentParameter.commentTypeCode</code> property defined at extension <code>commerceservices</code>. */
		
	private String commentTypeCode;
	
	public CommerceCommentParameter()
	{
		// default constructor
	}
	
		
	
	public void setItem(final ItemModel item)
	{
		this.item = item;
	}

		
	
	public ItemModel getItem() 
	{
		return item;
	}
	
		
	
	public void setAuthor(final UserModel author)
	{
		this.author = author;
	}

		
	
	public UserModel getAuthor() 
	{
		return author;
	}
	
		
	
	public void setText(final String text)
	{
		this.text = text;
	}

		
	
	public String getText() 
	{
		return text;
	}
	
		
	
	public void setDomainCode(final String domainCode)
	{
		this.domainCode = domainCode;
	}

		
	
	public String getDomainCode() 
	{
		return domainCode;
	}
	
		
	
	public void setComponentCode(final String componentCode)
	{
		this.componentCode = componentCode;
	}

		
	
	public String getComponentCode() 
	{
		return componentCode;
	}
	
		
	
	public void setCommentTypeCode(final String commentTypeCode)
	{
		this.commentTypeCode = commentTypeCode;
	}

		
	
	public String getCommentTypeCode() 
	{
		return commentTypeCode;
	}
	


}
