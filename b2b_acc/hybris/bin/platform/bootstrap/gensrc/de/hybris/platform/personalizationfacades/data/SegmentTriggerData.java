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
package de.hybris.platform.personalizationfacades.data;

import de.hybris.platform.personalizationfacades.data.SegmentData;
import de.hybris.platform.personalizationfacades.data.TriggerData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Segment trigger
 */
@ApiModel(value="segmentTrigger", description="Segment trigger")
public  class SegmentTriggerData extends TriggerData 
{

 

	/** Details of the segments<br/><br/><i>Generated property</i> for <code>SegmentTriggerData.segments</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="segments", value="Details of the segments") 	
	private List<SegmentData> segments;

	/** Logical operator connecting the segments<br/><br/><i>Generated property</i> for <code>SegmentTriggerData.groupBy</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="groupBy", value="Logical operator connecting the segments", allowableValues="AND,OR") 	
	private String groupBy;
	
	public SegmentTriggerData()
	{
		// default constructor
	}
	
		
	
	public void setSegments(final List<SegmentData> segments)
	{
		this.segments = segments;
	}

		
	
	public List<SegmentData> getSegments() 
	{
		return segments;
	}
	
		
	
	public void setGroupBy(final String groupBy)
	{
		this.groupBy = groupBy;
	}

		
	
	public String getGroupBy() 
	{
		return groupBy;
	}
	


}
