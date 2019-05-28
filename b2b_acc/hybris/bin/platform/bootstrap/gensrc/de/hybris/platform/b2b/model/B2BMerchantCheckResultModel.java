/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 28, 2019 3:18:54 PM                     ---
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
import de.hybris.platform.b2b.enums.MerchantCheckStatus;
import de.hybris.platform.b2b.enums.MerchantCheckStatusEmail;
import de.hybris.platform.b2b.model.B2BMerchantCheckModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Locale;

/**
 * Generated model class for type B2BMerchantCheckResult first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BMerchantCheckResultModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BMerchantCheckResult";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BMerchantCheckResult.merchantcheck</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String MERCHANTCHECK = "merchantcheck";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BMerchantCheckResult.merchantCheckTypeCode</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String MERCHANTCHECKTYPECODE = "merchantCheckTypeCode";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BMerchantCheckResult.status</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String STATUS = "status";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BMerchantCheckResult.statusEmail</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String STATUSEMAIL = "statusEmail";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BMerchantCheckResult.note</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String NOTE = "note";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BMerchantCheckResultModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BMerchantCheckResultModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BMerchantCheckResultModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BMerchantCheckResult.merchantcheck</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the merchantcheck
	 */
	@Accessor(qualifier = "merchantcheck", type = Accessor.Type.GETTER)
	public B2BMerchantCheckModel getMerchantcheck()
	{
		return getPersistenceContext().getPropertyValue(MERCHANTCHECK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BMerchantCheckResult.merchantCheckTypeCode</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the merchantCheckTypeCode - the item type code for the merchant check, the result is
	 * 						holding as defined in items.xml
	 */
	@Accessor(qualifier = "merchantCheckTypeCode", type = Accessor.Type.GETTER)
	public String getMerchantCheckTypeCode()
	{
		return getPersistenceContext().getPropertyValue(MERCHANTCHECKTYPECODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BMerchantCheckResult.note</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the note
	 */
	@Accessor(qualifier = "note", type = Accessor.Type.GETTER)
	public String getNote()
	{
		return getNote(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BMerchantCheckResult.note</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @param loc the value localization key 
	 * @return the note
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "note", type = Accessor.Type.GETTER)
	public String getNote(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NOTE, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BMerchantCheckResult.status</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.GETTER)
	public MerchantCheckStatus getStatus()
	{
		return getPersistenceContext().getPropertyValue(STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BMerchantCheckResult.statusEmail</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the statusEmail
	 */
	@Accessor(qualifier = "statusEmail", type = Accessor.Type.GETTER)
	public MerchantCheckStatusEmail getStatusEmail()
	{
		return getPersistenceContext().getPropertyValue(STATUSEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BMerchantCheckResult.merchantcheck</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the merchantcheck
	 */
	@Accessor(qualifier = "merchantcheck", type = Accessor.Type.SETTER)
	public void setMerchantcheck(final B2BMerchantCheckModel value)
	{
		getPersistenceContext().setPropertyValue(MERCHANTCHECK, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BMerchantCheckResult.merchantCheckTypeCode</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the merchantCheckTypeCode - the item type code for the merchant check, the result is
	 * 						holding as defined in items.xml
	 */
	@Accessor(qualifier = "merchantCheckTypeCode", type = Accessor.Type.SETTER)
	public void setMerchantCheckTypeCode(final String value)
	{
		getPersistenceContext().setPropertyValue(MERCHANTCHECKTYPECODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BMerchantCheckResult.note</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the note
	 */
	@Accessor(qualifier = "note", type = Accessor.Type.SETTER)
	public void setNote(final String value)
	{
		setNote(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>B2BMerchantCheckResult.note</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the note
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "note", type = Accessor.Type.SETTER)
	public void setNote(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NOTE, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BMerchantCheckResult.status</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the status
	 */
	@Accessor(qualifier = "status", type = Accessor.Type.SETTER)
	public void setStatus(final MerchantCheckStatus value)
	{
		getPersistenceContext().setPropertyValue(STATUS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BMerchantCheckResult.statusEmail</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the statusEmail
	 */
	@Accessor(qualifier = "statusEmail", type = Accessor.Type.SETTER)
	public void setStatusEmail(final MerchantCheckStatusEmail value)
	{
		getPersistenceContext().setPropertyValue(STATUSEMAIL, value);
	}
	
}
