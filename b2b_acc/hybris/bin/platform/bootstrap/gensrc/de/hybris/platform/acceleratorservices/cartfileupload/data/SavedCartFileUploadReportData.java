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
package de.hybris.platform.acceleratorservices.cartfileupload.data;

import java.io.Serializable;
import  de.hybris.platform.commerceservices.order.CommerceCartModification;
import java.util.List;

public  class SavedCartFileUploadReportData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SavedCartFileUploadReportData.errorModificationList</code> property defined at extension <code>acceleratorservices</code>. */
		
	private List<CommerceCartModification> errorModificationList;

	/** <i>Generated property</i> for <code>SavedCartFileUploadReportData.successCount</code> property defined at extension <code>acceleratorservices</code>. */
		
	private Integer successCount;

	/** <i>Generated property</i> for <code>SavedCartFileUploadReportData.partialImportCount</code> property defined at extension <code>acceleratorservices</code>. */
		
	private Integer partialImportCount;

	/** <i>Generated property</i> for <code>SavedCartFileUploadReportData.failureCount</code> property defined at extension <code>acceleratorservices</code>. */
		
	private Integer failureCount;
	
	public SavedCartFileUploadReportData()
	{
		// default constructor
	}
	
		
	
	public void setErrorModificationList(final List<CommerceCartModification> errorModificationList)
	{
		this.errorModificationList = errorModificationList;
	}

		
	
	public List<CommerceCartModification> getErrorModificationList() 
	{
		return errorModificationList;
	}
	
		
	
	public void setSuccessCount(final Integer successCount)
	{
		this.successCount = successCount;
	}

		
	
	public Integer getSuccessCount() 
	{
		return successCount;
	}
	
		
	
	public void setPartialImportCount(final Integer partialImportCount)
	{
		this.partialImportCount = partialImportCount;
	}

		
	
	public Integer getPartialImportCount() 
	{
		return partialImportCount;
	}
	
		
	
	public void setFailureCount(final Integer failureCount)
	{
		this.failureCount = failureCount;
	}

		
	
	public Integer getFailureCount() 
	{
		return failureCount;
	}
	


}
