/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
package de.hybris.platform.ordermanagementfacades.returns.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.RefundReason;
import de.hybris.platform.basecommerce.enums.ReplacementReason;
import de.hybris.platform.basecommerce.enums.ReturnAction;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.data.PriceData;
import java.util.Date;

public  class ReturnEntryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnEntryData.expectedQuantity</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Long expectedQuantity;

	/** <i>Generated property</i> for <code>ReturnEntryData.receivedQuantity</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Long receivedQuantity;

	/** <i>Generated property</i> for <code>ReturnEntryData.reachedDate</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Date reachedDate;

	/** <i>Generated property</i> for <code>ReturnEntryData.orderEntry</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private OrderEntryData orderEntry;

	/** <i>Generated property</i> for <code>ReturnEntryData.notes</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String notes;

	/** <i>Generated property</i> for <code>ReturnEntryData.action</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private ReturnAction action;

	/** <i>Generated property</i> for <code>ReturnEntryData.refundReason</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private RefundReason refundReason;

	/** <i>Generated property</i> for <code>ReturnEntryData.replacementReason</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private ReplacementReason replacementReason;

	/** <i>Generated property</i> for <code>ReturnEntryData.refundAmount</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private PriceData refundAmount;

	/** <i>Generated property</i> for <code>ReturnEntryData.refundedDate</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Date refundedDate;
	
	public ReturnEntryData()
	{
		// default constructor
	}
	
		
	
	public void setExpectedQuantity(final Long expectedQuantity)
	{
		this.expectedQuantity = expectedQuantity;
	}

		
	
	public Long getExpectedQuantity() 
	{
		return expectedQuantity;
	}
	
		
	
	public void setReceivedQuantity(final Long receivedQuantity)
	{
		this.receivedQuantity = receivedQuantity;
	}

		
	
	public Long getReceivedQuantity() 
	{
		return receivedQuantity;
	}
	
		
	
	public void setReachedDate(final Date reachedDate)
	{
		this.reachedDate = reachedDate;
	}

		
	
	public Date getReachedDate() 
	{
		return reachedDate;
	}
	
		
	
	public void setOrderEntry(final OrderEntryData orderEntry)
	{
		this.orderEntry = orderEntry;
	}

		
	
	public OrderEntryData getOrderEntry() 
	{
		return orderEntry;
	}
	
		
	
	public void setNotes(final String notes)
	{
		this.notes = notes;
	}

		
	
	public String getNotes() 
	{
		return notes;
	}
	
		
	
	public void setAction(final ReturnAction action)
	{
		this.action = action;
	}

		
	
	public ReturnAction getAction() 
	{
		return action;
	}
	
		
	
	public void setRefundReason(final RefundReason refundReason)
	{
		this.refundReason = refundReason;
	}

		
	
	public RefundReason getRefundReason() 
	{
		return refundReason;
	}
	
		
	
	public void setReplacementReason(final ReplacementReason replacementReason)
	{
		this.replacementReason = replacementReason;
	}

		
	
	public ReplacementReason getReplacementReason() 
	{
		return replacementReason;
	}
	
		
	
	public void setRefundAmount(final PriceData refundAmount)
	{
		this.refundAmount = refundAmount;
	}

		
	
	public PriceData getRefundAmount() 
	{
		return refundAmount;
	}
	
		
	
	public void setRefundedDate(final Date refundedDate)
	{
		this.refundedDate = refundedDate;
	}

		
	
	public Date getRefundedDate() 
	{
		return refundedDate;
	}
	


}
