/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 27, 2019 5:14:19 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.b2b.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Date;

/**
 * Generated model class for type B2BComment first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BCommentModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BComment";
	
	/**<i>Generated relation code constant for relation <code>AbstractOrder2B2BComment</code> defining source attribute <code>order</code> in extension <code>b2bcommerce</code>.</i>*/
	public static final String _ABSTRACTORDER2B2BCOMMENT = "AbstractOrder2B2BComment";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BComment.code</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BComment.comment</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COMMENT = "comment";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BComment.modifiedDate</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String MODIFIEDDATE = "modifiedDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BComment.order</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ORDER = "order";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BCommentModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BCommentModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>B2BComment</code> at extension <code>b2bcommerce</code>
	 */
	@Deprecated
	public B2BCommentModel(final UserModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BComment.code</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BComment.comment</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the comment
	 */
	@Accessor(qualifier = "comment", type = Accessor.Type.GETTER)
	public String getComment()
	{
		return getPersistenceContext().getPropertyValue(COMMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BComment.modifiedDate</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the modifiedDate
	 */
	@Accessor(qualifier = "modifiedDate", type = Accessor.Type.GETTER)
	public Date getModifiedDate()
	{
		return getPersistenceContext().getPropertyValue(MODIFIEDDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BComment.order</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the order
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.GETTER)
	public AbstractOrderModel getOrder()
	{
		return getPersistenceContext().getPropertyValue(ORDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Item.owner</code> attribute defined at extension <code>core</code> and redeclared at extension <code>b2bcommerce</code>. 
	 * @return the owner - responsible user for this template
	 */
	@Override
	@Accessor(qualifier = "owner", type = Accessor.Type.GETTER)
	public UserModel getOwner()
	{
		return (UserModel) super.getOwner();
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BComment.code</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BComment.comment</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the comment
	 */
	@Accessor(qualifier = "comment", type = Accessor.Type.SETTER)
	public void setComment(final String value)
	{
		getPersistenceContext().setPropertyValue(COMMENT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BComment.modifiedDate</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the modifiedDate
	 */
	@Accessor(qualifier = "modifiedDate", type = Accessor.Type.SETTER)
	public void setModifiedDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(MODIFIEDDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BComment.order</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the order
	 */
	@Accessor(qualifier = "order", type = Accessor.Type.SETTER)
	public void setOrder(final AbstractOrderModel value)
	{
		getPersistenceContext().setPropertyValue(ORDER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Item.owner</code> attribute defined at extension <code>core</code> and redeclared at extension <code>b2bcommerce</code>. Will only accept values of type {@link de.hybris.platform.core.model.user.UserModel}. 
	 *  
	 * @param value the owner - responsible user for this template
	 */
	@Override
	@Accessor(qualifier = "owner", type = Accessor.Type.SETTER)
	public void setOwner(final ItemModel value)
	{
		if( value == null || value instanceof UserModel)
		{
			super.setOwner(value);
		}
		else
		{
			throw new IllegalArgumentException("Given value is not instance of de.hybris.platform.core.model.user.UserModel");
		}
	}
	
}
