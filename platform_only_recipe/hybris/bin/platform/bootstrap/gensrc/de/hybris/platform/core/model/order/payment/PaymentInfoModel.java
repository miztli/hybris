/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 13, 2019 3:38:13 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.core.model.order.payment;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type PaymentInfo first defined at extension core.
 */
@SuppressWarnings("all")
public class PaymentInfoModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "PaymentInfo";
	
	/**<i>Generated relation code constant for relation <code>User2PaymentInfos</code> defining source attribute <code>user</code> in extension <code>core</code>.</i>*/
	public static final String _USER2PAYMENTINFOS = "User2PaymentInfos";
	
	/** <i>Generated constant</i> - Attribute key of <code>PaymentInfo.original</code> attribute defined at extension <code>core</code>. */
	public static final String ORIGINAL = "original";
	
	/** <i>Generated constant</i> - Attribute key of <code>PaymentInfo.code</code> attribute defined at extension <code>core</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>PaymentInfo.duplicate</code> attribute defined at extension <code>core</code>. */
	public static final String DUPLICATE = "duplicate";
	
	/** <i>Generated constant</i> - Attribute key of <code>PaymentInfo.user</code> attribute defined at extension <code>core</code>. */
	public static final String USER = "user";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public PaymentInfoModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public PaymentInfoModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>PaymentInfo</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>PaymentInfo</code> at extension <code>core</code>
	 */
	@Deprecated
	public PaymentInfoModel(final String _code, final UserModel _user)
	{
		super();
		setCode(_code);
		setUser(_user);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>PaymentInfo</code> at extension <code>core</code>
	 * @param _original initial attribute declared by type <code>PaymentInfo</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _user initial attribute declared by type <code>PaymentInfo</code> at extension <code>core</code>
	 */
	@Deprecated
	public PaymentInfoModel(final String _code, final ItemModel _original, final ItemModel _owner, final UserModel _user)
	{
		super();
		setCode(_code);
		setOriginal(_original);
		setOwner(_owner);
		setUser(_user);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaymentInfo.code</code> attribute defined at extension <code>core</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaymentInfo.duplicate</code> attribute defined at extension <code>core</code>. 
	 * @return the duplicate
	 */
	@Accessor(qualifier = "duplicate", type = Accessor.Type.GETTER)
	public Boolean getDuplicate()
	{
		final Boolean value = getPersistenceContext().getPropertyValue(DUPLICATE);
		return value != null ? value : Boolean.valueOf(false);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaymentInfo.original</code> attribute defined at extension <code>core</code>. 
	 * @return the original
	 */
	@Accessor(qualifier = "original", type = Accessor.Type.GETTER)
	public ItemModel getOriginal()
	{
		return getPersistenceContext().getPropertyValue(ORIGINAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaymentInfo.user</code> attribute defined at extension <code>core</code>. 
	 * @return the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.GETTER)
	public UserModel getUser()
	{
		return getPersistenceContext().getPropertyValue(USER);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PaymentInfo.code</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>PaymentInfo.duplicate</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the duplicate
	 */
	@Accessor(qualifier = "duplicate", type = Accessor.Type.SETTER)
	public void setDuplicate(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(DUPLICATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>PaymentInfo.original</code> attribute defined at extension <code>core</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the original
	 */
	@Accessor(qualifier = "original", type = Accessor.Type.SETTER)
	public void setOriginal(final ItemModel value)
	{
		getPersistenceContext().setPropertyValue(ORIGINAL, value);
	}
	
	/**
	 * <i>Generated method</i> - Initial setter of <code>PaymentInfo.user</code> attribute defined at extension <code>core</code>. Can only be used at creation of model - before first save.  
	 *  
	 * @param value the user
	 */
	@Accessor(qualifier = "user", type = Accessor.Type.SETTER)
	public void setUser(final UserModel value)
	{
		getPersistenceContext().setPropertyValue(USER, value);
	}
	
}
