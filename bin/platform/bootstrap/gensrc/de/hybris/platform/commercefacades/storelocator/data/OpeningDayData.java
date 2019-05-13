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
import de.hybris.platform.commercefacades.storelocator.data.TimeData;

public  class OpeningDayData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OpeningDayData.openingTime</code> property defined at extension <code>commercefacades</code>. */
		
	private TimeData openingTime;

	/** <i>Generated property</i> for <code>OpeningDayData.closingTime</code> property defined at extension <code>commercefacades</code>. */
		
	private TimeData closingTime;
	
	public OpeningDayData()
	{
		// default constructor
	}
	
		
	
	public void setOpeningTime(final TimeData openingTime)
	{
		this.openingTime = openingTime;
	}

		
	
	public TimeData getOpeningTime() 
	{
		return openingTime;
	}
	
		
	
	public void setClosingTime(final TimeData closingTime)
	{
		this.closingTime = closingTime;
	}

		
	
	public TimeData getClosingTime() 
	{
		return closingTime;
	}
	


}
