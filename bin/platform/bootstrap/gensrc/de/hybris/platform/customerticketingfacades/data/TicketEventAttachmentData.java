/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
package de.hybris.platform.customerticketingfacades.data;

import java.io.Serializable;

public  class TicketEventAttachmentData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketEventAttachmentData.filename</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String filename;

	/** <i>Generated property</i> for <code>TicketEventAttachmentData.URL</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String URL;
	
	public TicketEventAttachmentData()
	{
		// default constructor
	}
	
		
	
	public void setFilename(final String filename)
	{
		this.filename = filename;
	}

		
	
	public String getFilename() 
	{
		return filename;
	}
	
		
	
	public void setURL(final String URL)
	{
		this.URL = URL;
	}

		
	
	public String getURL() 
	{
		return URL;
	}
	


}
