/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:56 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.b2bcommercefacades.company.data;

import java.io.Serializable;
import de.hybris.platform.b2bcommercefacades.company.data.B2BCostCenterData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUnitData;
import de.hybris.platform.commercefacades.storesession.data.CurrencyData;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public  class B2BBudgetData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BBudgetData.budget</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private BigDecimal budget;

	/** <i>Generated property</i> for <code>B2BBudgetData.unit</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private B2BUnitData unit;

	/** <i>Generated property</i> for <code>B2BBudgetData.code</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>B2BBudgetData.name</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>B2BBudgetData.currency</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private CurrencyData currency;

	/** <i>Generated property</i> for <code>B2BBudgetData.active</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private boolean active;

	/** <i>Generated property</i> for <code>B2BBudgetData.costCenters</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<B2BCostCenterData> costCenters;

	/** <i>Generated property</i> for <code>B2BBudgetData.costCenterNames</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<String> costCenterNames;

	/** <i>Generated property</i> for <code>B2BBudgetData.startDate</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private Date startDate;

	/** <i>Generated property</i> for <code>B2BBudgetData.endDate</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private Date endDate;

	/** <i>Generated property</i> for <code>B2BBudgetData.selected</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private boolean selected;

	/** <i>Generated property</i> for <code>B2BBudgetData.originalCode</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private String originalCode;
	
	public B2BBudgetData()
	{
		// default constructor
	}
	
		
	
	public void setBudget(final BigDecimal budget)
	{
		this.budget = budget;
	}

		
	
	public BigDecimal getBudget() 
	{
		return budget;
	}
	
		
	
	public void setUnit(final B2BUnitData unit)
	{
		this.unit = unit;
	}

		
	
	public B2BUnitData getUnit() 
	{
		return unit;
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setCurrency(final CurrencyData currency)
	{
		this.currency = currency;
	}

		
	
	public CurrencyData getCurrency() 
	{
		return currency;
	}
	
		
	
	public void setActive(final boolean active)
	{
		this.active = active;
	}

		
	
	public boolean isActive() 
	{
		return active;
	}
	
		
	
	public void setCostCenters(final List<B2BCostCenterData> costCenters)
	{
		this.costCenters = costCenters;
	}

		
	
	public List<B2BCostCenterData> getCostCenters() 
	{
		return costCenters;
	}
	
		
	
	public void setCostCenterNames(final List<String> costCenterNames)
	{
		this.costCenterNames = costCenterNames;
	}

		
	
	public List<String> getCostCenterNames() 
	{
		return costCenterNames;
	}
	
		
	
	public void setStartDate(final Date startDate)
	{
		this.startDate = startDate;
	}

		
	
	public Date getStartDate() 
	{
		return startDate;
	}
	
		
	
	public void setEndDate(final Date endDate)
	{
		this.endDate = endDate;
	}

		
	
	public Date getEndDate() 
	{
		return endDate;
	}
	
		
	
	public void setSelected(final boolean selected)
	{
		this.selected = selected;
	}

		
	
	public boolean isSelected() 
	{
		return selected;
	}
	
		
	
	public void setOriginalCode(final String originalCode)
	{
		this.originalCode = originalCode;
	}

		
	
	public String getOriginalCode() 
	{
		return originalCode;
	}
	


}
