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
package de.hybris.platform.ticketsystem.data;

import java.io.Serializable;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.ticket.enums.CsEventReason;
import de.hybris.platform.ticket.enums.CsInterventionType;
import de.hybris.platform.ticket.enums.CsTicketCategory;
import de.hybris.platform.ticket.enums.CsTicketPriority;
import de.hybris.platform.ticket.model.CsAgentGroupModel;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public  class CsTicketParameter  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CsTicketParameter.customer</code> property defined at extension <code>ticketsystem</code>. */
		
	private UserModel customer;

	/** <i>Generated property</i> for <code>CsTicketParameter.associatedTo</code> property defined at extension <code>ticketsystem</code>. */
		
	private AbstractOrderModel associatedTo;

	/** <i>Generated property</i> for <code>CsTicketParameter.category</code> property defined at extension <code>ticketsystem</code>. */
		
	private CsTicketCategory category;

	/** <i>Generated property</i> for <code>CsTicketParameter.priority</code> property defined at extension <code>ticketsystem</code>. */
		
	private CsTicketPriority priority;

	/** <i>Generated property</i> for <code>CsTicketParameter.assignedAgent</code> property defined at extension <code>ticketsystem</code>. */
		
	private EmployeeModel assignedAgent;

	/** <i>Generated property</i> for <code>CsTicketParameter.assignedGroup</code> property defined at extension <code>ticketsystem</code>. */
		
	private CsAgentGroupModel assignedGroup;

	/** <i>Generated property</i> for <code>CsTicketParameter.headline</code> property defined at extension <code>ticketsystem</code>. */
		
	private String headline;

	/** <i>Generated property</i> for <code>CsTicketParameter.interventionType</code> property defined at extension <code>ticketsystem</code>. */
		
	private CsInterventionType interventionType;

	/** <i>Generated property</i> for <code>CsTicketParameter.reason</code> property defined at extension <code>ticketsystem</code>. */
		
	private CsEventReason reason;

	/** <i>Generated property</i> for <code>CsTicketParameter.creationNotes</code> property defined at extension <code>ticketsystem</code>. */
		
	private String creationNotes;

	/** <i>Generated property</i> for <code>CsTicketParameter.attachments</code> property defined at extension <code>ticketsystem</code>. */
		
	private List<MultipartFile> attachments;
	
	public CsTicketParameter()
	{
		// default constructor
	}
	
		
	
	public void setCustomer(final UserModel customer)
	{
		this.customer = customer;
	}

		
	
	public UserModel getCustomer() 
	{
		return customer;
	}
	
		
	
	public void setAssociatedTo(final AbstractOrderModel associatedTo)
	{
		this.associatedTo = associatedTo;
	}

		
	
	public AbstractOrderModel getAssociatedTo() 
	{
		return associatedTo;
	}
	
		
	
	public void setCategory(final CsTicketCategory category)
	{
		this.category = category;
	}

		
	
	public CsTicketCategory getCategory() 
	{
		return category;
	}
	
		
	
	public void setPriority(final CsTicketPriority priority)
	{
		this.priority = priority;
	}

		
	
	public CsTicketPriority getPriority() 
	{
		return priority;
	}
	
		
	
	public void setAssignedAgent(final EmployeeModel assignedAgent)
	{
		this.assignedAgent = assignedAgent;
	}

		
	
	public EmployeeModel getAssignedAgent() 
	{
		return assignedAgent;
	}
	
		
	
	public void setAssignedGroup(final CsAgentGroupModel assignedGroup)
	{
		this.assignedGroup = assignedGroup;
	}

		
	
	public CsAgentGroupModel getAssignedGroup() 
	{
		return assignedGroup;
	}
	
		
	
	public void setHeadline(final String headline)
	{
		this.headline = headline;
	}

		
	
	public String getHeadline() 
	{
		return headline;
	}
	
		
	
	public void setInterventionType(final CsInterventionType interventionType)
	{
		this.interventionType = interventionType;
	}

		
	
	public CsInterventionType getInterventionType() 
	{
		return interventionType;
	}
	
		
	
	public void setReason(final CsEventReason reason)
	{
		this.reason = reason;
	}

		
	
	public CsEventReason getReason() 
	{
		return reason;
	}
	
		
	
	public void setCreationNotes(final String creationNotes)
	{
		this.creationNotes = creationNotes;
	}

		
	
	public String getCreationNotes() 
	{
		return creationNotes;
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
