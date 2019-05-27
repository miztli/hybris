/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:23 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.hybris.mobile.lib.commerce.data.store;

import java.util.List;

public class OpeningSchedule  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>OpeningSchedule.code</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String code;
	/** <i>Generated property</i> for <code>OpeningSchedule.specialDayOpeningList</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<SpecialOpeningDay> specialDayOpeningList;
	/** <i>Generated property</i> for <code>OpeningSchedule.name</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String name;
	/** <i>Generated property</i> for <code>OpeningSchedule.weekDayOpeningList</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<WeekdayOpeningDay> weekDayOpeningList;
		
	public OpeningSchedule()
	{
		// default constructor
	}
	
		
	public void setCode(final String code)
	{
		this.code = code;
	}
	
		
	public String getCode() 
	{
		return code;
	}
		
		
	public void setSpecialDayOpeningList(final List<SpecialOpeningDay> specialDayOpeningList)
	{
		this.specialDayOpeningList = specialDayOpeningList;
	}
	
		
	public List<SpecialOpeningDay> getSpecialDayOpeningList() 
	{
		return specialDayOpeningList;
	}
		
		
	public void setName(final String name)
	{
		this.name = name;
	}
	
		
	public String getName() 
	{
		return name;
	}
		
		
	public void setWeekDayOpeningList(final List<WeekdayOpeningDay> weekDayOpeningList)
	{
		this.weekDayOpeningList = weekDayOpeningList;
	}
	
		
	public List<WeekdayOpeningDay> getWeekDayOpeningList() 
	{
		return weekDayOpeningList;
	}
		
	
}