/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 16, 2019 10:32:52 AM                    ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.core.model.c2l;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.C2LItemModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;

/**
 * Generated model class for type Currency first defined at extension core.
 */
@SuppressWarnings("all")
public class CurrencyModel extends C2LItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>Currency.base</code> attribute defined at extension <code>core</code>. */
	public static final String BASE = "base";
	
	/** <i>Generated constant</i> - Attribute key of <code>Currency.conversion</code> attribute defined at extension <code>core</code>. */
	public static final String CONVERSION = "conversion";
	
	/** <i>Generated constant</i> - Attribute key of <code>Currency.digits</code> attribute defined at extension <code>core</code>. */
	public static final String DIGITS = "digits";
	
	/** <i>Generated constant</i> - Attribute key of <code>Currency.symbol</code> attribute defined at extension <code>core</code>. */
	public static final String SYMBOL = "symbol";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public CurrencyModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public CurrencyModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _isocode initial attribute declared by type <code>Currency</code> at extension <code>core</code>
	 * @param _symbol initial attribute declared by type <code>Currency</code> at extension <code>core</code>
	 */
	@Deprecated
	public CurrencyModel(final String _isocode, final String _symbol)
	{
		super();
		setIsocode(_isocode);
		setSymbol(_symbol);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _isocode initial attribute declared by type <code>Currency</code> at extension <code>core</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 * @param _symbol initial attribute declared by type <code>Currency</code> at extension <code>core</code>
	 */
	@Deprecated
	public CurrencyModel(final String _isocode, final ItemModel _owner, final String _symbol)
	{
		super();
		setIsocode(_isocode);
		setOwner(_owner);
		setSymbol(_symbol);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Currency.base</code> attribute defined at extension <code>core</code>. 
	 * @return the base
	 */
	@Accessor(qualifier = "base", type = Accessor.Type.GETTER)
	public Boolean getBase()
	{
		final Boolean value = getPersistenceContext().getPropertyValue(BASE);
		return value != null ? value : Boolean.valueOf(false);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Currency.conversion</code> attribute defined at extension <code>core</code>. 
	 * @return the conversion
	 */
	@Accessor(qualifier = "conversion", type = Accessor.Type.GETTER)
	public Double getConversion()
	{
		final Double value = getPersistenceContext().getPropertyValue(CONVERSION);
		return value != null ? value : Double.valueOf(0d);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Currency.digits</code> attribute defined at extension <code>core</code>. 
	 * @return the digits
	 */
	@Accessor(qualifier = "digits", type = Accessor.Type.GETTER)
	public Integer getDigits()
	{
		final Integer value = getPersistenceContext().getPropertyValue(DIGITS);
		return value != null ? value : Integer.valueOf(0);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Currency.symbol</code> attribute defined at extension <code>core</code>. 
	 * @return the symbol
	 */
	@Accessor(qualifier = "symbol", type = Accessor.Type.GETTER)
	public String getSymbol()
	{
		return getPersistenceContext().getPropertyValue(SYMBOL);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Currency.base</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the base
	 */
	@Accessor(qualifier = "base", type = Accessor.Type.SETTER)
	public void setBase(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(BASE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Currency.conversion</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the conversion
	 */
	@Accessor(qualifier = "conversion", type = Accessor.Type.SETTER)
	public void setConversion(final Double value)
	{
		getPersistenceContext().setPropertyValue(CONVERSION, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Currency.digits</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the digits
	 */
	@Accessor(qualifier = "digits", type = Accessor.Type.SETTER)
	public void setDigits(final Integer value)
	{
		getPersistenceContext().setPropertyValue(DIGITS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Currency.symbol</code> attribute defined at extension <code>core</code>. 
	 *  
	 * @param value the symbol
	 */
	@Accessor(qualifier = "symbol", type = Accessor.Type.SETTER)
	public void setSymbol(final String value)
	{
		getPersistenceContext().setPropertyValue(SYMBOL, value);
	}
	
}
