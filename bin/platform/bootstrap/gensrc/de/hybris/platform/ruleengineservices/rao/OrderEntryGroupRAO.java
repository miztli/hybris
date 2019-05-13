/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
package de.hybris.platform.ruleengineservices.rao;

import de.hybris.platform.ruleengineservices.rao.AbstractActionedRAO;
import de.hybris.platform.ruleengineservices.rao.OrderEntryGroupRAO;

public  class OrderEntryGroupRAO extends AbstractActionedRAO 
{

 

	/** <i>Generated property</i> for <code>OrderEntryGroupRAO.rootEntryGroup</code> property defined at extension <code>ruleengineservices</code>. */
		
	private OrderEntryGroupRAO rootEntryGroup;

	/** <i>Generated property</i> for <code>OrderEntryGroupRAO.entryGroupId</code> property defined at extension <code>ruleengineservices</code>. */
		
	private Integer entryGroupId;

	/** <i>Generated property</i> for <code>OrderEntryGroupRAO.externalReferenceId</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String externalReferenceId;

	/** <i>Generated property</i> for <code>OrderEntryGroupRAO.groupType</code> property defined at extension <code>ruleengineservices</code>. */
		
	private String groupType;
	
	public OrderEntryGroupRAO()
	{
		// default constructor
	}
	
		
	
	public void setRootEntryGroup(final OrderEntryGroupRAO rootEntryGroup)
	{
		this.rootEntryGroup = rootEntryGroup;
	}

		
	
	public OrderEntryGroupRAO getRootEntryGroup() 
	{
		return rootEntryGroup;
	}
	
		
	
	public void setEntryGroupId(final Integer entryGroupId)
	{
		this.entryGroupId = entryGroupId;
	}

		
	
	public Integer getEntryGroupId() 
	{
		return entryGroupId;
	}
	
		
	
	public void setExternalReferenceId(final String externalReferenceId)
	{
		this.externalReferenceId = externalReferenceId;
	}

		
	
	public String getExternalReferenceId() 
	{
		return externalReferenceId;
	}
	
		
	
	public void setGroupType(final String groupType)
	{
		this.groupType = groupType;
	}

		
	
	public String getGroupType() 
	{
		return groupType;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final OrderEntryGroupRAO other = (OrderEntryGroupRAO) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getEntryGroupId(), other.getEntryGroupId()) 
			.append(getExternalReferenceId(), other.getExternalReferenceId()) 
			.append(getGroupType(), other.getGroupType()) 
			.isEquals();
		} 
		catch (ClassCastException c)
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return new org.apache.commons.lang.builder.HashCodeBuilder()
		.append(getEntryGroupId()) 
		.append(getExternalReferenceId()) 
		.append(getGroupType()) 
		.toHashCode();
	}

}
