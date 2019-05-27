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
package de.hybris.platform.commercefacades.order.data;

import de.hybris.platform.b2bacceleratorfacades.order.data.B2BCommentData;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BPaymentTypeData;
import de.hybris.platform.b2bacceleratorfacades.order.data.TriggerData;
import de.hybris.platform.b2bapprovalprocessfacades.company.data.B2BPermissionResultData;
import de.hybris.platform.b2bcommercefacades.company.data.B2BCostCenterData;
import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.order.data.ConsignmentData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.enums.DeliveryStatus;
import de.hybris.platform.core.enums.OrderStatus;
import java.util.Date;
import java.util.List;

public  class OrderData extends AbstractOrderData 
{

 

	/** <i>Generated property</i> for <code>OrderData.created</code> property defined at extension <code>commercefacades</code>. */
		
	private Date created;

	/** <i>Generated property</i> for <code>OrderData.status</code> property defined at extension <code>commercefacades</code>. */
		
	private OrderStatus status;

	/** <i>Generated property</i> for <code>OrderData.statusDisplay</code> property defined at extension <code>commercefacades</code>. */
		
	private String statusDisplay;

	/** <i>Generated property</i> for <code>OrderData.guestCustomer</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean guestCustomer;

	/** <i>Generated property</i> for <code>OrderData.consignments</code> property defined at extension <code>commercefacades</code>. */
		
	private List<ConsignmentData> consignments;

	/** <i>Generated property</i> for <code>OrderData.deliveryStatus</code> property defined at extension <code>commercefacades</code>. */
		
	private DeliveryStatus deliveryStatus;

	/** <i>Generated property</i> for <code>OrderData.deliveryStatusDisplay</code> property defined at extension <code>commercefacades</code>. */
		
	private String deliveryStatusDisplay;

	/** <i>Generated property</i> for <code>OrderData.unconsignedEntries</code> property defined at extension <code>commercefacades</code>. */
		
	private List<OrderEntryData> unconsignedEntries;

	/** <i>Generated property</i> for <code>OrderData.placedBy</code> property defined at extension <code>commercefacades</code>. */
		
	private String placedBy;

	/** <i>Generated property</i> for <code>OrderData.quoteCode</code> property defined at extension <code>commercefacades</code>. */
		
	private String quoteCode;

	/** <i>Generated property</i> for <code>OrderData.cancellable</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private boolean cancellable;

	/** <i>Generated property</i> for <code>OrderData.returnable</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private boolean returnable;

	/** <i>Generated property</i> for <code>OrderData.costCenter</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private B2BCostCenterData costCenter;

	/** <i>Generated property</i> for <code>OrderData.paymentType</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private B2BPaymentTypeData paymentType;

	/** <i>Generated property</i> for <code>OrderData.b2BComment</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private B2BCommentData b2BComment;

	/** <i>Generated property</i> for <code>OrderData.b2bCustomerData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private CustomerData b2bCustomerData;

	/** <i>Generated property</i> for <code>OrderData.b2bCommentData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<B2BCommentData> b2bCommentData;

	/** <i>Generated property</i> for <code>OrderData.quoteExpirationDate</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private Date quoteExpirationDate;

	/** <i>Generated property</i> for <code>OrderData.purchaseOrderNumber</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private String purchaseOrderNumber;

	/** <i>Generated property</i> for <code>OrderData.triggerData</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private TriggerData triggerData;

	/** <i>Generated property</i> for <code>OrderData.b2bPermissionResult</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<B2BPermissionResultData> b2bPermissionResult;

	/** <i>Generated property</i> for <code>OrderData.jobCode</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private String jobCode;
	
	public OrderData()
	{
		// default constructor
	}
	
		
	
	public void setCreated(final Date created)
	{
		this.created = created;
	}

		
	
	public Date getCreated() 
	{
		return created;
	}
	
		
	
	public void setStatus(final OrderStatus status)
	{
		this.status = status;
	}

		
	
	public OrderStatus getStatus() 
	{
		return status;
	}
	
		
	
	public void setStatusDisplay(final String statusDisplay)
	{
		this.statusDisplay = statusDisplay;
	}

		
	
	public String getStatusDisplay() 
	{
		return statusDisplay;
	}
	
		
	
	public void setGuestCustomer(final boolean guestCustomer)
	{
		this.guestCustomer = guestCustomer;
	}

		
	
	public boolean isGuestCustomer() 
	{
		return guestCustomer;
	}
	
		
	
	public void setConsignments(final List<ConsignmentData> consignments)
	{
		this.consignments = consignments;
	}

		
	
	public List<ConsignmentData> getConsignments() 
	{
		return consignments;
	}
	
		
	
	public void setDeliveryStatus(final DeliveryStatus deliveryStatus)
	{
		this.deliveryStatus = deliveryStatus;
	}

		
	
	public DeliveryStatus getDeliveryStatus() 
	{
		return deliveryStatus;
	}
	
		
	
	public void setDeliveryStatusDisplay(final String deliveryStatusDisplay)
	{
		this.deliveryStatusDisplay = deliveryStatusDisplay;
	}

		
	
	public String getDeliveryStatusDisplay() 
	{
		return deliveryStatusDisplay;
	}
	
		
	
	public void setUnconsignedEntries(final List<OrderEntryData> unconsignedEntries)
	{
		this.unconsignedEntries = unconsignedEntries;
	}

		
	
	public List<OrderEntryData> getUnconsignedEntries() 
	{
		return unconsignedEntries;
	}
	
		
	
	public void setPlacedBy(final String placedBy)
	{
		this.placedBy = placedBy;
	}

		
	
	public String getPlacedBy() 
	{
		return placedBy;
	}
	
		
	
	public void setQuoteCode(final String quoteCode)
	{
		this.quoteCode = quoteCode;
	}

		
	
	public String getQuoteCode() 
	{
		return quoteCode;
	}
	
		
	
	public void setCancellable(final boolean cancellable)
	{
		this.cancellable = cancellable;
	}

		
	
	public boolean isCancellable() 
	{
		return cancellable;
	}
	
		
	
	public void setReturnable(final boolean returnable)
	{
		this.returnable = returnable;
	}

		
	
	public boolean isReturnable() 
	{
		return returnable;
	}
	
		
	
	public void setCostCenter(final B2BCostCenterData costCenter)
	{
		this.costCenter = costCenter;
	}

		
	
	public B2BCostCenterData getCostCenter() 
	{
		return costCenter;
	}
	
		
	
	public void setPaymentType(final B2BPaymentTypeData paymentType)
	{
		this.paymentType = paymentType;
	}

		
	
	public B2BPaymentTypeData getPaymentType() 
	{
		return paymentType;
	}
	
		
	
	public void setB2BComment(final B2BCommentData b2BComment)
	{
		this.b2BComment = b2BComment;
	}

		
	
	public B2BCommentData getB2BComment() 
	{
		return b2BComment;
	}
	
		
	
	public void setB2bCustomerData(final CustomerData b2bCustomerData)
	{
		this.b2bCustomerData = b2bCustomerData;
	}

		
	
	public CustomerData getB2bCustomerData() 
	{
		return b2bCustomerData;
	}
	
		
	
	public void setB2bCommentData(final List<B2BCommentData> b2bCommentData)
	{
		this.b2bCommentData = b2bCommentData;
	}

		
	
	public List<B2BCommentData> getB2bCommentData() 
	{
		return b2bCommentData;
	}
	
	@Deprecated
    /**
     * @deprecated Since 6.3. Use {@link de.hybris.platform.commercefacades.order.data.AbstractOrderData#expirationTime} instead.
     */
		
	
	public void setQuoteExpirationDate(final Date quoteExpirationDate)
	{
		this.quoteExpirationDate = quoteExpirationDate;
	}

	@Deprecated
	/**
	 * @deprecated Since 6.3. Use {@link de.hybris.platform.commercefacades.order.data.AbstractOrderData#expirationTime} instead.
	 */
		
	
	public Date getQuoteExpirationDate() 
	{
		return quoteExpirationDate;
	}
	
		
	
	public void setPurchaseOrderNumber(final String purchaseOrderNumber)
	{
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

		
	
	public String getPurchaseOrderNumber() 
	{
		return purchaseOrderNumber;
	}
	
		
	
	public void setTriggerData(final TriggerData triggerData)
	{
		this.triggerData = triggerData;
	}

		
	
	public TriggerData getTriggerData() 
	{
		return triggerData;
	}
	
		
	
	public void setB2bPermissionResult(final List<B2BPermissionResultData> b2bPermissionResult)
	{
		this.b2bPermissionResult = b2bPermissionResult;
	}

		
	
	public List<B2BPermissionResultData> getB2bPermissionResult() 
	{
		return b2bPermissionResult;
	}
	
		
	
	public void setJobCode(final String jobCode)
	{
		this.jobCode = jobCode;
	}

		
	
	public String getJobCode() 
	{
		return jobCode;
	}
	


}
