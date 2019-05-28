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
package de.hybris.platform.ordermanagementfacades.returns.data;

import java.io.Serializable;
import de.hybris.platform.basecommerce.enums.ReturnStatus;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.ordermanagementfacades.returns.data.ReturnEntryData;
import java.util.Date;
import java.util.List;

public  class ReturnRequestData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnRequestData.code</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>ReturnRequestData.rma</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String rma;

	/** <i>Generated property</i> for <code>ReturnRequestData.creationTime</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Date creationTime;

	/** <i>Generated property</i> for <code>ReturnRequestData.order</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private OrderData order;

	/** <i>Generated property</i> for <code>ReturnRequestData.deliveryCost</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private PriceData deliveryCost;

	/** <i>Generated property</i> for <code>ReturnRequestData.returnEntries</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private List<ReturnEntryData> returnEntries;

	/** <i>Generated property</i> for <code>ReturnRequestData.status</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private ReturnStatus status;

	/** <i>Generated property</i> for <code>ReturnRequestData.refundDeliveryCost</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Boolean refundDeliveryCost;

	/** <i>Generated property</i> for <code>ReturnRequestData.subtotal</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private PriceData subtotal;

	/** <i>Generated property</i> for <code>ReturnRequestData.total</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private PriceData total;

	/** <i>Generated property</i> for <code>ReturnRequestData.returnLabelDownloadUrl</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private String returnLabelDownloadUrl;

	/** <i>Generated property</i> for <code>ReturnRequestData.cancellable</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private boolean cancellable;
	
	public ReturnRequestData()
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
	
		
	
	public void setRma(final String rma)
	{
		this.rma = rma;
	}

		
	
	public String getRma() 
	{
		return rma;
	}
	
		
	
	public void setCreationTime(final Date creationTime)
	{
		this.creationTime = creationTime;
	}

		
	
	public Date getCreationTime() 
	{
		return creationTime;
	}
	
		
	
	public void setOrder(final OrderData order)
	{
		this.order = order;
	}

		
	
	public OrderData getOrder() 
	{
		return order;
	}
	
		
	
	public void setDeliveryCost(final PriceData deliveryCost)
	{
		this.deliveryCost = deliveryCost;
	}

		
	
	public PriceData getDeliveryCost() 
	{
		return deliveryCost;
	}
	
		
	
	public void setReturnEntries(final List<ReturnEntryData> returnEntries)
	{
		this.returnEntries = returnEntries;
	}

		
	
	public List<ReturnEntryData> getReturnEntries() 
	{
		return returnEntries;
	}
	
		
	
	public void setStatus(final ReturnStatus status)
	{
		this.status = status;
	}

		
	
	public ReturnStatus getStatus() 
	{
		return status;
	}
	
		
	
	public void setRefundDeliveryCost(final Boolean refundDeliveryCost)
	{
		this.refundDeliveryCost = refundDeliveryCost;
	}

		
	
	public Boolean getRefundDeliveryCost() 
	{
		return refundDeliveryCost;
	}
	
		
	
	public void setSubtotal(final PriceData subtotal)
	{
		this.subtotal = subtotal;
	}

		
	
	public PriceData getSubtotal() 
	{
		return subtotal;
	}
	
		
	
	public void setTotal(final PriceData total)
	{
		this.total = total;
	}

		
	
	public PriceData getTotal() 
	{
		return total;
	}
	
		
	
	public void setReturnLabelDownloadUrl(final String returnLabelDownloadUrl)
	{
		this.returnLabelDownloadUrl = returnLabelDownloadUrl;
	}

		
	
	public String getReturnLabelDownloadUrl() 
	{
		return returnLabelDownloadUrl;
	}
	
		
	
	public void setCancellable(final boolean cancellable)
	{
		this.cancellable = cancellable;
	}

		
	
	public boolean isCancellable() 
	{
		return cancellable;
	}
	


}
