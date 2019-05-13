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
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.b2bapprovalprocessfacades.company.data.B2BPermissionResultData;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.user.data.PrincipalData;
import de.hybris.platform.core.enums.OrderStatus;
import java.util.Date;
import java.util.List;

public  class OrderHistoryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>OrderHistoryData.code</code> property defined at extension <code>commercefacades</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>OrderHistoryData.status</code> property defined at extension <code>commercefacades</code>. */
		
	private OrderStatus status;

	/** <i>Generated property</i> for <code>OrderHistoryData.statusDisplay</code> property defined at extension <code>commercefacades</code>. */
		
	private String statusDisplay;

	/** <i>Generated property</i> for <code>OrderHistoryData.placed</code> property defined at extension <code>commercefacades</code>. */
		
	private Date placed;

	/** <i>Generated property</i> for <code>OrderHistoryData.guid</code> property defined at extension <code>commercefacades</code>. */
		
	private String guid;

	/** <i>Generated property</i> for <code>OrderHistoryData.total</code> property defined at extension <code>commercefacades</code>. */
		
	private PriceData total;

	/** <i>Generated property</i> for <code>OrderHistoryData.purchaseOrderNumber</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private String purchaseOrderNumber;

	/** <i>Generated property</i> for <code>OrderHistoryData.b2bPermissionResults</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<B2BPermissionResultData> b2bPermissionResults;

	/** <i>Generated property</i> for <code>OrderHistoryData.managers</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<PrincipalData> managers;
	
	public OrderHistoryData()
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
	
		
	
	public void setPlaced(final Date placed)
	{
		this.placed = placed;
	}

		
	
	public Date getPlaced() 
	{
		return placed;
	}
	
		
	
	public void setGuid(final String guid)
	{
		this.guid = guid;
	}

		
	
	public String getGuid() 
	{
		return guid;
	}
	
		
	
	public void setTotal(final PriceData total)
	{
		this.total = total;
	}

		
	
	public PriceData getTotal() 
	{
		return total;
	}
	
		
	
	public void setPurchaseOrderNumber(final String purchaseOrderNumber)
	{
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

		
	
	public String getPurchaseOrderNumber() 
	{
		return purchaseOrderNumber;
	}
	
		
	
	public void setB2bPermissionResults(final List<B2BPermissionResultData> b2bPermissionResults)
	{
		this.b2bPermissionResults = b2bPermissionResults;
	}

		
	
	public List<B2BPermissionResultData> getB2bPermissionResults() 
	{
		return b2bPermissionResults;
	}
	
		
	
	public void setManagers(final List<PrincipalData> managers)
	{
		this.managers = managers;
	}

		
	
	public List<PrincipalData> getManagers() 
	{
		return managers;
	}
	


}
