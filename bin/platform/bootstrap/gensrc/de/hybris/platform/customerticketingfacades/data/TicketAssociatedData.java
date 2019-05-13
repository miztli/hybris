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
package de.hybris.platform.customerticketingfacades.data;

import java.io.Serializable;
import java.util.Date;

/**
 * This Data Object is used to hold all the objects which can associate with the customer tickets
 */
public  class TicketAssociatedData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketAssociatedData.code</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>TicketAssociatedData.modifiedtime</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private Date modifiedtime;

	/** <i>Generated property</i> for <code>TicketAssociatedData.siteUid</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String siteUid;

	/** <i>Generated property</i> for <code>TicketAssociatedData.type</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String type;
	
	public TicketAssociatedData()
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
	
		
	
	public void setModifiedtime(final Date modifiedtime)
	{
		this.modifiedtime = modifiedtime;
	}

		
	
	public Date getModifiedtime() 
	{
		return modifiedtime;
	}
	
		
	
	public void setSiteUid(final String siteUid)
	{
		this.siteUid = siteUid;
	}

		
	
	public String getSiteUid() 
	{
		return siteUid;
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
