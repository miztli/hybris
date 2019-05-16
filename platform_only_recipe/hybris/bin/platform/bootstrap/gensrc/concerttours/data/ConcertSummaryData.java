/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 16, 2019 10:32:52 AM
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
package concerttours.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Data object for a concert summary
 */
public  class ConcertSummaryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConcertSummaryData.id</code> property defined at extension <code>concerttours</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>ConcertSummaryData.date</code> property defined at extension <code>concerttours</code>. */
		
	private Date date;

	/** <i>Generated property</i> for <code>ConcertSummaryData.venue</code> property defined at extension <code>concerttours</code>. */
		
	private String venue;

	/** <i>Generated property</i> for <code>ConcertSummaryData.type</code> property defined at extension <code>concerttours</code>. */
		
	private String type;
	
	public ConcertSummaryData()
	{
		// default constructor
	}
	
		
	
	public void setId(final String id)
	{
		this.id = id;
	}

		
	
	public String getId() 
	{
		return id;
	}
	
		
	
	public void setDate(final Date date)
	{
		this.date = date;
	}

		
	
	public Date getDate() 
	{
		return date;
	}
	
		
	
	public void setVenue(final String venue)
	{
		this.venue = venue;
	}

		
	
	public String getVenue() 
	{
		return venue;
	}
	
		
	
	public void setType(final String type)
	{
		this.type = type;
	}

		
	
	public String getType() 
	{
		return type;
	}
	


}
