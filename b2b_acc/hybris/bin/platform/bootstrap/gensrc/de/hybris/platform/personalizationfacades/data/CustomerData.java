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
package de.hybris.platform.personalizationfacades.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.CustomerSegmentationData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Customer details
 */
@ApiModel(value="customer", description="Customer details")
public  class CustomerData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** ID of the customer<br/><br/><i>Generated property</i> for <code>CustomerData.uid</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="uid", value="ID of the customer") 	
	private String uid;

	/** List of customer's segmentation details<br/><br/><i>Generated property</i> for <code>CustomerData.segmentLinks</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="segmentLinks", value="List of customer's segmentation details") 	
	private List<CustomerSegmentationData> segmentLinks;
	
	public CustomerData()
	{
		// default constructor
	}
	
		
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

		
	
	public String getUid() 
	{
		return uid;
	}
	
		
	
	public void setSegmentLinks(final List<CustomerSegmentationData> segmentLinks)
	{
		this.segmentLinks = segmentLinks;
	}

		
	
	public List<CustomerSegmentationData> getSegmentLinks() 
	{
		return segmentLinks;
	}
	


}
