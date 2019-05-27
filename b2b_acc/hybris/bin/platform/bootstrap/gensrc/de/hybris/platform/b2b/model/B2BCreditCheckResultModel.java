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
import de.hybris.platform.b2b.model.B2BMerchantCheckResultModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.math.BigDecimal;

/**
 * Generated model class for type B2BCreditCheckResult first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BCreditCheckResultModel extends B2BMerchantCheckResultModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BCreditCheckResult";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditCheckResult.currency</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditCheckResult.creditLimit</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CREDITLIMIT = "creditLimit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditCheckResult.amountUtilised</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String AMOUNTUTILISED = "amountUtilised";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BCreditCheckResultModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BCreditCheckResultModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _currency initial attribute declared by type <code>B2BCreditCheckResult</code> at extension <code>b2bcommerce</code>
	 */
	@Deprecated
	public B2BCreditCheckResultModel(final CurrencyModel _currency)
	{
		super();
		setCurrency(_currency);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _currency initial attribute declared by type <code>B2BCreditCheckResult</code> at extension <code>b2bcommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BCreditCheckResultModel(final CurrencyModel _currency, final ItemModel _owner)
	{
		super();
		setCurrency(_currency);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditCheckResult.amountUtilised</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the amountUtilised
	 */
	@Accessor(qualifier = "amountUtilised", type = Accessor.Type.GETTER)
	public BigDecimal getAmountUtilised()
	{
		return getPersistenceContext().getPropertyValue(AMOUNTUTILISED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditCheckResult.creditLimit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the creditLimit
	 */
	@Accessor(qualifier = "creditLimit", type = Accessor.Type.GETTER)
	public BigDecimal getCreditLimit()
	{
		return getPersistenceContext().getPropertyValue(CREDITLIMIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditCheckResult.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditCheckResult.amountUtilised</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the amountUtilised
	 */
	@Accessor(qualifier = "amountUtilised", type = Accessor.Type.SETTER)
	public void setAmountUtilised(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(AMOUNTUTILISED, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditCheckResult.creditLimit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the creditLimit
	 */
	@Accessor(qualifier = "creditLimit", type = Accessor.Type.SETTER)
	public void setCreditLimit(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(CREDITLIMIT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditCheckResult.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
}
