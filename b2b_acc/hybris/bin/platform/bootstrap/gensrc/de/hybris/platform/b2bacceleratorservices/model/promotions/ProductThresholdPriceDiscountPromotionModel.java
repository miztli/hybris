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
package de.hybris.platform.b2bacceleratorservices.model.promotions;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.promotions.model.ProductPromotionModel;
import de.hybris.platform.promotions.model.PromotionPriceRowModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type ProductThresholdPriceDiscountPromotion first defined at extension b2bacceleratorservices.
 */
@SuppressWarnings("all")
public class ProductThresholdPriceDiscountPromotionModel extends ProductPromotionModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "ProductThresholdPriceDiscountPromotion";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductThresholdPriceDiscountPromotion.productThresholdPrice</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String PRODUCTTHRESHOLDPRICE = "productThresholdPrice";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductThresholdPriceDiscountPromotion.productPriceDiscount</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String PRODUCTPRICEDISCOUNT = "productPriceDiscount";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductThresholdPriceDiscountPromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String MESSAGEFIRED = "messageFired";
	
	/** <i>Generated constant</i> - Attribute key of <code>ProductThresholdPriceDiscountPromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. */
	public static final String MESSAGECOULDHAVEFIRED = "messageCouldHaveFired";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public ProductThresholdPriceDiscountPromotionModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public ProductThresholdPriceDiscountPromotionModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>AbstractPromotion</code> at extension <code>promotions</code>
	 */
	@Deprecated
	public ProductThresholdPriceDiscountPromotionModel(final String _code)
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
	public ProductThresholdPriceDiscountPromotionModel(final String _code, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductThresholdPriceDiscountPromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @return the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.GETTER)
	public String getMessageCouldHaveFired()
	{
		return getMessageCouldHaveFired(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductThresholdPriceDiscountPromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>ProductThresholdPriceDiscountPromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * @return the messageFired - The message to show when the promotion has fired.
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.GETTER)
	public String getMessageFired()
	{
		return getMessageFired(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductThresholdPriceDiscountPromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
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
	 * <i>Generated method</i> - Getter of the <code>ProductThresholdPriceDiscountPromotion.productPriceDiscount</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the productPriceDiscount - Fixed price for discount in specific currencies.
	 */
	@Accessor(qualifier = "productPriceDiscount", type = Accessor.Type.GETTER)
	public Collection<PromotionPriceRowModel> getProductPriceDiscount()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTPRICEDISCOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductThresholdPriceDiscountPromotion.productThresholdPrice</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the productThresholdPrice - The cart total value threshold in specific currencies.
	 */
	@Accessor(qualifier = "productThresholdPrice", type = Accessor.Type.GETTER)
	public Collection<PromotionPriceRowModel> getProductThresholdPrice()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTTHRESHOLDPRICE);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductThresholdPriceDiscountPromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageCouldHaveFired - The message to show when the promotion could have potentially fire.
	 */
	@Accessor(qualifier = "messageCouldHaveFired", type = Accessor.Type.SETTER)
	public void setMessageCouldHaveFired(final String value)
	{
		setMessageCouldHaveFired(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>ProductThresholdPriceDiscountPromotion.messageCouldHaveFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
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
	 * <i>Generated method</i> - Setter of <code>ProductThresholdPriceDiscountPromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the messageFired - The message to show when the promotion has fired.
	 */
	@Accessor(qualifier = "messageFired", type = Accessor.Type.SETTER)
	public void setMessageFired(final String value)
	{
		setMessageFired(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>ProductThresholdPriceDiscountPromotion.messageFired</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
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
	 * <i>Generated method</i> - Setter of <code>ProductThresholdPriceDiscountPromotion.productPriceDiscount</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the productPriceDiscount - Fixed price for discount in specific currencies.
	 */
	@Accessor(qualifier = "productPriceDiscount", type = Accessor.Type.SETTER)
	public void setProductPriceDiscount(final Collection<PromotionPriceRowModel> value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTPRICEDISCOUNT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>ProductThresholdPriceDiscountPromotion.productThresholdPrice</code> attribute defined at extension <code>b2bacceleratorservices</code>. 
	 *  
	 * @param value the productThresholdPrice - The cart total value threshold in specific currencies.
	 */
	@Accessor(qualifier = "productThresholdPrice", type = Accessor.Type.SETTER)
	public void setProductThresholdPrice(final Collection<PromotionPriceRowModel> value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTTHRESHOLDPRICE, value);
	}
	
}
