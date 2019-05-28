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
package de.hybris.platform.customerticketingfacades.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public  class TicketData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketData.id</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>TicketData.customerId</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String customerId;

	/** <i>Generated property</i> for <code>TicketData.cartId</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String cartId;

	/** <i>Generated property</i> for <code>TicketData.subject</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String subject;

	/** <i>Generated property</i> for <code>TicketData.message</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String message;

	/** <i>Generated property</i> for <code>TicketData.messageHistory</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String messageHistory;

	/** <i>Generated property</i> for <code>TicketData.ticketEvents</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private List<TicketEventData> ticketEvents;

	/** <i>Generated property</i> for <code>TicketData.creationDate</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private Date creationDate;

	/** <i>Generated property</i> for <code>TicketData.lastModificationDate</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private Date lastModificationDate;

	/** <i>Generated property</i> for <code>TicketData.status</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private StatusData status;

	/** <i>Generated property</i> for <code>TicketData.ticketCategory</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private TicketCategory ticketCategory;

	/** <i>Generated property</i> for <code>TicketData.availableStatusTransitions</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private List<StatusData> availableStatusTransitions;

	/** <i>Generated property</i> for <code>TicketData.associatedTo</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private String associatedTo;

	/** <i>Generated property</i> for <code>TicketData.attachments</code> property defined at extension <code>customerticketingfacades</code>. */
		
	private List<MultipartFile> attachments;
	
	public TicketData()
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
	
		
	
	public void setCustomerId(final String customerId)
	{
		this.customerId = customerId;
	}

		
	
	public String getCustomerId() 
	{
		return customerId;
	}
	
		
	
	public void setCartId(final String cartId)
	{
		this.cartId = cartId;
	}

		
	
	public String getCartId() 
	{
		return cartId;
	}
	
		
	
	public void setSubject(final String subject)
	{
		this.subject = subject;
	}

		
	
	public String getSubject() 
	{
		return subject;
	}
	
		
	
	public void setMessage(final String message)
	{
		this.message = message;
	}

		
	
	public String getMessage() 
	{
		return message;
	}
	
		
	
	public void setMessageHistory(final String messageHistory)
	{
		this.messageHistory = messageHistory;
	}

		
	
	public String getMessageHistory() 
	{
		return messageHistory;
	}
	
		
	
	public void setTicketEvents(final List<TicketEventData> ticketEvents)
	{
		this.ticketEvents = ticketEvents;
	}

		
	
	public List<TicketEventData> getTicketEvents() 
	{
		return ticketEvents;
	}
	
		
	
	public void setCreationDate(final Date creationDate)
	{
		this.creationDate = creationDate;
	}

		
	
	public Date getCreationDate() 
	{
		return creationDate;
	}
	
		
	
	public void setLastModificationDate(final Date lastModificationDate)
	{
		this.lastModificationDate = lastModificationDate;
	}

		
	
	public Date getLastModificationDate() 
	{
		return lastModificationDate;
	}
	
		
	
	public void setStatus(final StatusData status)
	{
		this.status = status;
	}

		
	
	public StatusData getStatus() 
	{
		return status;
	}
	
		
	
	public void setTicketCategory(final TicketCategory ticketCategory)
	{
		this.ticketCategory = ticketCategory;
	}

		
	
	public TicketCategory getTicketCategory() 
	{
		return ticketCategory;
	}
	
		
	
	public void setAvailableStatusTransitions(final List<StatusData> availableStatusTransitions)
	{
		this.availableStatusTransitions = availableStatusTransitions;
	}

		
	
	public List<StatusData> getAvailableStatusTransitions() 
	{
		return availableStatusTransitions;
	}
	
		
	
	public void setAssociatedTo(final String associatedTo)
	{
		this.associatedTo = associatedTo;
	}

		
	
	public String getAssociatedTo() 
	{
		return associatedTo;
	}
	
		
	
	public void setAttachments(final List<MultipartFile> attachments)
	{
		this.attachments = attachments;
	}

		
	
	public List<MultipartFile> getAttachments() 
	{
		return attachments;
	}
	


}
