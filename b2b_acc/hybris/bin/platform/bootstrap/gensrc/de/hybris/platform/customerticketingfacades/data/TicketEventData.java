/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:21 PM
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
import java.util.List;
import java.util.Map;

public  class TicketEventData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketEventData.author</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String author;

	/** <i>Generated property</i> for <code>TicketEventData.startDateTime</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private Date startDateTime;

	/** <i>Generated property</i> for <code>TicketEventData.text</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String text;

	/** <i>Generated property</i> for <code>TicketEventData.displayText</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String displayText;

	/** <i>Generated property</i> for <code>TicketEventData.attachments</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private List<TicketEventAttachmentData> attachments;

	/** <i>Generated property</i> for <code>TicketEventData.modifiedFields</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private Map<String,List<StatusData>> modifiedFields;

	/** <i>Generated property</i> for <code>TicketEventData.addedByAgent</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private Boolean addedByAgent;
	
	public TicketEventData()
	{
		// default constructor
	}
	
		
	
	public void setAuthor(final String author)
	{
		this.author = author;
	}

		
	
	public String getAuthor() 
	{
		return author;
	}
	
		
	
	public void setStartDateTime(final Date startDateTime)
	{
		this.startDateTime = startDateTime;
	}

		
	
	public Date getStartDateTime() 
	{
		return startDateTime;
	}
	
		
	
	public void setText(final String text)
	{
		this.text = text;
	}

		
	
	public String getText() 
	{
		return text;
	}
	
		
	
	public void setDisplayText(final String displayText)
	{
		this.displayText = displayText;
	}

		
	
	public String getDisplayText() 
	{
		return displayText;
	}
	
		
	
	public void setAttachments(final List<TicketEventAttachmentData> attachments)
	{
		this.attachments = attachments;
	}

		
	
	public List<TicketEventAttachmentData> getAttachments() 
	{
		return attachments;
	}
	
		
	
	public void setModifiedFields(final Map<String,List<StatusData>> modifiedFields)
	{
		this.modifiedFields = modifiedFields;
	}

		
	
	public Map<String,List<StatusData>> getModifiedFields() 
	{
		return modifiedFields;
	}
	
		
	
	public void setAddedByAgent(final Boolean addedByAgent)
	{
		this.addedByAgent = addedByAgent;
	}

		
	
	public Boolean getAddedByAgent() 
	{
		return addedByAgent;
	}
	


}
