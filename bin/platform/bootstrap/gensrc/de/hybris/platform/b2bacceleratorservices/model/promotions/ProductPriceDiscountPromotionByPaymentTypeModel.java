/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 10, 2019 3:20:53 PM                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.b2bacceleratorservices.model.promotions;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2bacceleratorservices.enums.CheckoutPaymentType;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.promotions.model.ProductPromotionModel;
import de.hybris.platform.promotions.model.PromotionPriceRowModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type ProductPriceDiscountPromotionByPaymentType first defined at extension b2bacceleratorservices.
 * <p>
 * Deprecated since 6.3, please use promotion engine instead.
 */
@SuppressWarnings("all")
public class ProductPriceDiscountPromotionByPaymentTypeModel extends ProductPromotionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ProductPriceDiscountPromotionByPaymentType";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductPriceDiscountPromotionByPaymentType.productDiscountPrice</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String PRODUCTDISCOUNTPRICE = "productDiscountPrice";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductPriceDiscountPromotionByPaymentType.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String MESSAGEFIRED = "messageFired";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductPriceDiscountPromotionByPaymentType.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String MESSAGECOULDHAVEFIRED = "messageCouldHaveFired";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductPriceDiscountPromotionByPaymentType.paymentType</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String PAYMENTTYPE = "paymentType";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ProductPriceDiscountPromotionByPaymentTypeModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ProductPriceDiscountPromotionByPaymentTypeModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractPromotion</code> at extension <code>promotions</code>
	 */
	@Deprecated
	public ProductPriceDiscountPromotionByPaymentTypeModel(final String _code)
	{
		super();
		setCode(_code);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractPromotion</code> at extension <code>promotions</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public ProductPriceDiscountPromotionByPaymentTypeModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductPriceDiscountPromotionByPaymentType.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @return the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.GETTER)
	public String getMessageCouldHaveFired()
	{
		return getMessageCouldHaveFired(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductPriceDiscountPromotionByPaymentType.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @param loc the value localization key 
	 * @return the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.GETTER)
	public String getMessageCouldHaveFired(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(MESSAGECOULDHAVEFIRED, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductPriceDiscountPromotionByPaymentType.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @return the messageFired - The message to show when the promotion has fired.
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.GETTER)
	public String getMessageFired()
	{
		return getMessageFired(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductPriceDiscountPromotionByPaymentType.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @param loc the value localization key 
	 * @return the messageFired - The message to show when the promotion has fired.
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.GETTER)
	public String getMessageFired(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(MESSAGEFIRED, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductPriceDiscountPromotionByPaymentType.paymentType</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @return the paymentType - Payment type for Checkout summary
	 */
	@Accessor(qualifier = "paymentType", type = Accessor.Type.GETTER)
	public CheckoutPaymentType getPaymentType()
	{
		return getPersistenceContext().getPropertyValue(PAYMENTTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductPriceDiscountPromotionByPaymentType.productDiscountPrice</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the productDiscountPrice - Fixed price for discount in specific currencies.
	 */
	@Accessor(qualifier = "productDiscountPrice", type = Accessor.Type.GETTER)
	public Collection<PromotionPriceRowModel> getProductDiscountPrice()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTDISCOUNTPRICE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductPriceDiscountPromotionByPaymentType.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.SETTER)
	public void setMessageCouldHaveFired(final String value)
	{
		setMessageCouldHaveFired(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>ProductPriceDiscountPromotionByPaymentType.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.SETTER)
	public void setMessageCouldHaveFired(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(MESSAGECOULDHAVEFIRED, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductPriceDiscountPromotionByPaymentType.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageFired - The message to show when the promotion has fired.
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.SETTER)
	public void setMessageFired(final String value)
	{
		setMessageFired(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>ProductPriceDiscountPromotionByPaymentType.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageFired - The message to show when the promotion has fired.
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.SETTER)
	public void setMessageFired(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(MESSAGEFIRED, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductPriceDiscountPromotionByPaymentType.paymentType</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the paymentType - Payment type for Checkout summary
	 */
	@Accessor(qualifier = "paymentType", type = Accessor.Type.SETTER)
	public void setPaymentType(final CheckoutPaymentType value)
	{
		getPersistenceContext().setPropertyValue(PAYMENTTYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductPriceDiscountPromotionByPaymentType.productDiscountPrice</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the productDiscountPrice - Fixed price for discount in specific currencies.
	 */
	@Accessor(qualifier = "productDiscountPrice", type = Accessor.Type.SETTER)
	public void setProductDiscountPrice(final Collection<PromotionPriceRowModel> value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTDISCOUNTPRICE, value);
	}
	
}
