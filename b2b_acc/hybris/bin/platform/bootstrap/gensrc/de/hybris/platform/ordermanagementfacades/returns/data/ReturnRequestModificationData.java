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
import de.hybris.platform.ordermanagementfacades.returns.data.ReturnEntryModificationData;
import java.util.List;

public  class ReturnRequestModificationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ReturnRequestModificationData.returnEntries</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private List<ReturnEntryModificationData> returnEntries;

	/** <i>Generated property</i> for <code>ReturnRequestModificationData.refundDeliveryCost</code> property defined at extension <code>ordermanagementfacades</code>. */
		
	private Boolean refundDeliveryCost;
	
	public ReturnRequestModificationData()
	{
		// default constructor
	}
	
		
	
	public void setReturnEntries(final List<ReturnEntryModificationData> returnEntries)
	{
		this.returnEntries = returnEntries;
	}

		
	
	public List<ReturnEntryModificationData> getReturnEntries() 
	{
		return returnEntries;
	}
	
		
	
	public void setRefundDeliveryCost(final Boolean refundDeliveryCost)
	{
		this.refundDeliveryCost = refundDeliveryCost;
	}

		
	
	public Boolean getRefundDeliveryCost() 
	{
		return refundDeliveryCost;
	}
	


}
