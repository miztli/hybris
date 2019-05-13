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
package de.hybris.platform.b2b.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Generated model class for type B2BQuoteLimit first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BQuoteLimitModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BQuoteLimit";
	
	/**<i>Generated relation code constant for relation <code>B2BUnit2B2BQuoteLimit</code> defining source attribute <code>Unit</code> in extension <code>b2bcommerce</code>.</i>*/
	public static final String _B2BUNIT2B2BQUOTELIMIT = "B2BUnit2B2BQuoteLimit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BQuoteLimit.code</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BQuoteLimit.amount</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String AMOUNT = "amount";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BQuoteLimit.currency</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BQuoteLimit.Unit</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String UNIT = "Unit";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BQuoteLimitModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BQuoteLimitModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _amount initial attribute declared by type <code>B2BQuoteLimit</code> at extension <code>b2bcommerce</code>
	 * @param _code initial attribute declared by type <code>B2BQuoteLimit</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BQuoteLimit</code> at extension <code>b2bcommerce</code>
	 */
	@Deprecated
	public B2BQuoteLimitModel(final BigDecimal _amount, final String _code, final CurrencyModel _currency)
	{
		super();
		setAmount(_amount);
		setCode(_code);
		setCurrency(_currency);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _amount initial attribute declared by type <code>B2BQuoteLimit</code> at extension <code>b2bcommerce</code>
	 * @param _code initial attribute declared by type <code>B2BQuoteLimit</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BQuoteLimit</code> at extension <code>b2bcommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BQuoteLimitModel(final BigDecimal _amount, final String _code, final CurrencyModel _currency, final ItemModel _owner)
	{
		super();
		setAmount(_amount);
		setCode(_code);
		setCurrency(_currency);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BQuoteLimit.amount</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the amount
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.GETTER)
	public BigDecimal getAmount()
	{
		return getPersistenceContext().getPropertyValue(AMOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BQuoteLimit.code</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BQuoteLimit.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BQuoteLimit.Unit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Unit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.GETTER)
	public Collection<B2BUnitModel> getUnit()
	{
		return getPersistenceContext().getPropertyValue(UNIT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BQuoteLimit.amount</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the amount
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.SETTER)
	public void setAmount(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(AMOUNT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BQuoteLimit.code</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BQuoteLimit.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BQuoteLimit.Unit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the Unit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.SETTER)
	public void setUnit(final Collection<B2BUnitModel> value)
	{
		getPersistenceContext().setPropertyValue(UNIT, value);
	}
	
}
