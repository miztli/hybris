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
import de.hybris.platform.b2b.enums.B2BPeriodRange;
import de.hybris.platform.b2b.enums.B2BRateType;
import de.hybris.platform.b2b.model.B2BMerchantCheckModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.util.StandardDateRange;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * Generated model class for type B2BCreditLimit first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BCreditLimitModel extends B2BMerchantCheckModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BCreditLimit";
	
	/**<i>Generated relation code constant for relation <code>B2BUnit2B2BCreditLimit</code> defining source attribute <code>Unit</code> in extension <code>b2bcommerce</code>.</i>*/
	public static final String _B2BUNIT2B2BCREDITLIMIT = "B2BUnit2B2BCreditLimit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditLimit.currency</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditLimit.amount</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String AMOUNT = "amount";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditLimit.datePeriod</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String DATEPERIOD = "datePeriod";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditLimit.dateRange</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String DATERANGE = "dateRange";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditLimit.alertThreshold</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ALERTTHRESHOLD = "alertThreshold";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditLimit.alertRateType</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ALERTRATETYPE = "alertRateType";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditLimit.alertSentDate</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ALERTSENTDATE = "alertSentDate";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BCreditLimit.Unit</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String UNIT = "Unit";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BCreditLimitModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BCreditLimitModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>B2BMerchantCheck</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BCreditLimit</code> at extension <code>b2bcommerce</code>
	 */
	@Deprecated
	public B2BCreditLimitModel(final String _code, final CurrencyModel _currency)
	{
		super();
		setCode(_code);
		setCurrency(_currency);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _code initial attribute declared by type <code>B2BMerchantCheck</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BCreditLimit</code> at extension <code>b2bcommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BCreditLimitModel(final String _code, final CurrencyModel _currency, final ItemModel _owner)
	{
		super();
		setCode(_code);
		setCurrency(_currency);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditLimit.alertRateType</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the alertRateType
	 */
	@Accessor(qualifier = "alertRateType", type = Accessor.Type.GETTER)
	public B2BRateType getAlertRateType()
	{
		return getPersistenceContext().getPropertyValue(ALERTRATETYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditLimit.alertSentDate</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the alertSentDate
	 */
	@Accessor(qualifier = "alertSentDate", type = Accessor.Type.GETTER)
	public Date getAlertSentDate()
	{
		return getPersistenceContext().getPropertyValue(ALERTSENTDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditLimit.alertThreshold</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the alertThreshold
	 */
	@Accessor(qualifier = "alertThreshold", type = Accessor.Type.GETTER)
	public BigDecimal getAlertThreshold()
	{
		return getPersistenceContext().getPropertyValue(ALERTTHRESHOLD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditLimit.amount</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the amount
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.GETTER)
	public BigDecimal getAmount()
	{
		return getPersistenceContext().getPropertyValue(AMOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditLimit.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditLimit.datePeriod</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the datePeriod - date range the credit limit is active
	 */
	@Accessor(qualifier = "datePeriod", type = Accessor.Type.GETTER)
	public StandardDateRange getDatePeriod()
	{
		return getPersistenceContext().getPropertyValue(DATEPERIOD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditLimit.dateRange</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the dateRange
	 */
	@Accessor(qualifier = "dateRange", type = Accessor.Type.GETTER)
	public B2BPeriodRange getDateRange()
	{
		return getPersistenceContext().getPropertyValue(DATERANGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BCreditLimit.Unit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the Unit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.GETTER)
	public Collection<B2BUnitModel> getUnit()
	{
		return getPersistenceContext().getPropertyValue(UNIT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditLimit.alertRateType</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the alertRateType
	 */
	@Accessor(qualifier = "alertRateType", type = Accessor.Type.SETTER)
	public void setAlertRateType(final B2BRateType value)
	{
		getPersistenceContext().setPropertyValue(ALERTRATETYPE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditLimit.alertSentDate</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the alertSentDate
	 */
	@Accessor(qualifier = "alertSentDate", type = Accessor.Type.SETTER)
	public void setAlertSentDate(final Date value)
	{
		getPersistenceContext().setPropertyValue(ALERTSENTDATE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditLimit.alertThreshold</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the alertThreshold
	 */
	@Accessor(qualifier = "alertThreshold", type = Accessor.Type.SETTER)
	public void setAlertThreshold(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(ALERTTHRESHOLD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditLimit.amount</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the amount
	 */
	@Accessor(qualifier = "amount", type = Accessor.Type.SETTER)
	public void setAmount(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(AMOUNT, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditLimit.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditLimit.datePeriod</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the datePeriod - date range the credit limit is active
	 */
	@Accessor(qualifier = "datePeriod", type = Accessor.Type.SETTER)
	public void setDatePeriod(final StandardDateRange value)
	{
		getPersistenceContext().setPropertyValue(DATEPERIOD, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditLimit.dateRange</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the dateRange
	 */
	@Accessor(qualifier = "dateRange", type = Accessor.Type.SETTER)
	public void setDateRange(final B2BPeriodRange value)
	{
		getPersistenceContext().setPropertyValue(DATERANGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BCreditLimit.Unit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the Unit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.SETTER)
	public void setUnit(final Collection<B2BUnitModel> value)
	{
		getPersistenceContext().setPropertyValue(UNIT, value);
	}
	
}
