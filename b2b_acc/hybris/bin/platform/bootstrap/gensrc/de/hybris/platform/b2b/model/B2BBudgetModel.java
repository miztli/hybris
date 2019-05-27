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
import de.hybris.platform.b2b.model.B2BCostCenterModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.util.StandardDateRange;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

/**
 * Generated model class for type B2BBudget first defined at extension b2bcommerce.
 */
@SuppressWarnings("all")
public class B2BBudgetModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "B2BBudget";
	
	/**<i>Generated relation code constant for relation <code>B2BUnit2B2BBudget</code> defining source attribute <code>Unit</code> in extension <code>b2bcommerce</code>.</i>*/
	public static final String _B2BUNIT2B2BBUDGET = "B2BUnit2B2BBudget";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBudget.code</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBudget.name</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBudget.budget</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String BUDGET = "budget";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBudget.currency</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String CURRENCY = "currency";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBudget.dateRange</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String DATERANGE = "dateRange";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBudget.active</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String ACTIVE = "active";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBudget.Unit</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String UNIT = "Unit";
	
	/** <i>Generated constant</i> - Attribute key of <code>B2BBudget.CostCenters</code> attribute defined at extension <code>b2bcommerce</code>. */
	public static final String COSTCENTERS = "CostCenters";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public B2BBudgetModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public B2BBudgetModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - Constructor with all mandatory attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BBudget</code> at extension <code>b2bcommerce</code>
	 * @param _code initial attribute declared by type <code>B2BBudget</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BBudget</code> at extension <code>b2bcommerce</code>
	 */
	@Deprecated
	public B2BBudgetModel(final B2BUnitModel _Unit, final String _code, final CurrencyModel _currency)
	{
		super();
		setUnit(_Unit);
		setCode(_code);
		setCurrency(_currency);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _Unit initial attribute declared by type <code>B2BBudget</code> at extension <code>b2bcommerce</code>
	 * @param _code initial attribute declared by type <code>B2BBudget</code> at extension <code>b2bcommerce</code>
	 * @param _currency initial attribute declared by type <code>B2BBudget</code> at extension <code>b2bcommerce</code>
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public B2BBudgetModel(final B2BUnitModel _Unit, final String _code, final CurrencyModel _currency, final ItemModel _owner)
	{
		super();
		setUnit(_Unit);
		setCode(_code);
		setCurrency(_currency);
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBudget.active</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.GETTER)
	public Boolean getActive()
	{
		return getPersistenceContext().getPropertyValue(ACTIVE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBudget.budget</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the budget
	 */
	@Accessor(qualifier = "budget", type = Accessor.Type.GETTER)
	public BigDecimal getBudget()
	{
		return getPersistenceContext().getPropertyValue(BUDGET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBudget.code</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBudget.CostCenters</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the CostCenters
	 */
	@Accessor(qualifier = "CostCenters", type = Accessor.Type.GETTER)
	public Set<B2BCostCenterModel> getCostCenters()
	{
		return getPersistenceContext().getPropertyValue(COSTCENTERS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBudget.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.GETTER)
	public CurrencyModel getCurrency()
	{
		return getPersistenceContext().getPropertyValue(CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBudget.dateRange</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the dateRange - date range the budget is active
	 */
	@Accessor(qualifier = "dateRange", type = Accessor.Type.GETTER)
	public StandardDateRange getDateRange()
	{
		return getPersistenceContext().getPropertyValue(DATERANGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBudget.name</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBudget.name</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @param loc the value localization key 
	 * @return the name
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>B2BBudget.Unit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 * @return the Unit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.GETTER)
	public B2BUnitModel getUnit()
	{
		return getPersistenceContext().getPropertyValue(UNIT);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBudget.active</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the active
	 */
	@Accessor(qualifier = "active", type = Accessor.Type.SETTER)
	public void setActive(final Boolean value)
	{
		getPersistenceContext().setPropertyValue(ACTIVE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBudget.budget</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the budget
	 */
	@Accessor(qualifier = "budget", type = Accessor.Type.SETTER)
	public void setBudget(final BigDecimal value)
	{
		getPersistenceContext().setPropertyValue(BUDGET, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBudget.code</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the code
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBudget.CostCenters</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the CostCenters
	 */
	@Accessor(qualifier = "CostCenters", type = Accessor.Type.SETTER)
	public void setCostCenters(final Set<B2BCostCenterModel> value)
	{
		getPersistenceContext().setPropertyValue(COSTCENTERS, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBudget.currency</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the currency
	 */
	@Accessor(qualifier = "currency", type = Accessor.Type.SETTER)
	public void setCurrency(final CurrencyModel value)
	{
		getPersistenceContext().setPropertyValue(CURRENCY, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBudget.dateRange</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the dateRange - date range the budget is active
	 */
	@Accessor(qualifier = "dateRange", type = Accessor.Type.SETTER)
	public void setDateRange(final StandardDateRange value)
	{
		getPersistenceContext().setPropertyValue(DATERANGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBudget.name</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the name
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBudget.name</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the name
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>B2BBudget.Unit</code> attribute defined at extension <code>b2bcommerce</code>. 
	 *  
	 * @param value the Unit
	 */
	@Accessor(qualifier = "Unit", type = Accessor.Type.SETTER)
	public void setUnit(final B2BUnitModel value)
	{
		getPersistenceContext().setPropertyValue(UNIT, value);
	}
	
}
