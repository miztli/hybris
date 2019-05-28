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
package de.hybris.platform.customersupportbackoffice.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.ticket.enums.CsEventReason;
import de.hybris.platform.ticket.enums.CsInterventionType;
import de.hybris.platform.ticket.enums.CsTicketCategory;
import de.hybris.platform.ticket.enums.CsTicketPriority;
import de.hybris.platform.ticket.model.CsAgentGroupModel;

public  class CsCreateTicketForm  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.customer</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private CustomerModel customer;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.assignedTo</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private AbstractOrderModel assignedTo;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.assignedAgent</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private EmployeeModel assignedAgent;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.assignedGroup</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private CsAgentGroupModel assignedGroup;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.reason</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private CsEventReason reason;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.intervention</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private CsInterventionType intervention;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.category</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private CsTicketCategory category;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.priority</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private CsTicketPriority priority;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.subject</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private String subject;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.message</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private String message;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.basesite</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private BaseSiteModel basesite;

	/** <i>Generated property</i> for <code>CsCreateTicketForm.rootGroup</code> property defined at extension <code>customersupportbackoffice</code>. */
		
	private UserGroupModel rootGroup;
	
	public CsCreateTicketForm()
	{
		// default constructor
	}
	
		
	
	public void setCustomer(final CustomerModel customer)
	{
		this.customer = customer;
	}

		
	
	public CustomerModel getCustomer() 
	{
		return customer;
	}
	
		
	
	public void setAssignedTo(final AbstractOrderModel assignedTo)
	{
		this.assignedTo = assignedTo;
	}

		
	
	public AbstractOrderModel getAssignedTo() 
	{
		return assignedTo;
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
	
		
	
	public void setReason(final CsEventReason reason)
	{
		this.reason = reason;
	}

		
	
	public CsEventReason getReason() 
	{
		return reason;
	}
	
		
	
	public void setIntervention(final CsInterventionType intervention)
	{
		this.intervention = intervention;
	}

		
	
	public CsInterventionType getIntervention() 
	{
		return intervention;
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
	
		
	
	public void setBasesite(final BaseSiteModel basesite)
	{
		this.basesite = basesite;
	}

		
	
	public BaseSiteModel getBasesite() 
	{
		return basesite;
	}
	
		
	
	public void setRootGroup(final UserGroupModel rootGroup)
	{
		this.rootGroup = rootGroup;
	}

		
	
	public UserGroupModel getRootGroup() 
	{
		return rootGroup;
	}
	


}
