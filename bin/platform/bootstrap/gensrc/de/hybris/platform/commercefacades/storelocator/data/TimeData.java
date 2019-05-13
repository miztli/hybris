/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
package de.hybris.platform.commercefacades.storelocator.data;

import java.io.Serializable;

public  class TimeData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TimeData.hour</code> property defined at extension <code>commercefacades</code>. */
		
	private byte hour;

	/** <i>Generated property</i> for <code>TimeData.minute</code> property defined at extension <code>commercefacades</code>. */
		
	private byte minute;

	/** <i>Generated property</i> for <code>TimeData.formattedHour</code> property defined at extension <code>commercefacades</code>. */
		
	private String formattedHour;
	
	public TimeData()
	{
		// default constructor
	}
	
		
	
	public void setHour(final byte hour)
	{
		this.hour = hour;
	}

		
	
	public byte getHour() 
	{
		return hour;
	}
	
		
	
	public void setMinute(final byte minute)
	{
		this.minute = minute;
	}

		
	
	public byte getMinute() 
	{
		return minute;
	}
	
		
	
	public void setFormattedHour(final String formattedHour)
	{
		this.formattedHour = formattedHour;
	}

		
	
	public String getFormattedHour() 
	{
		return formattedHour;
	}
	


}
