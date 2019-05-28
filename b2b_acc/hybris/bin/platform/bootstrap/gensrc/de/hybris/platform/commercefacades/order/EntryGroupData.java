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
package de.hybris.platform.commercefacades.order;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.hybris.platform.commercefacades.order.EntryGroupData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.core.enums.GroupType;
import java.util.List;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="groupNumber")
public  class EntryGroupData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>EntryGroupData.groupNumber</code> property defined at extension <code>commercefacades</code>. */
		
	private Integer groupNumber;

	/** <i>Generated property</i> for <code>EntryGroupData.priority</code> property defined at extension <code>commercefacades</code>. */
		
	private Integer priority;

	/** <i>Generated property</i> for <code>EntryGroupData.label</code> property defined at extension <code>commercefacades</code>. */
		
	private String label;

	/** <i>Generated property</i> for <code>EntryGroupData.groupType</code> property defined at extension <code>commercefacades</code>. */
		
	private GroupType groupType;

	/** <i>Generated property</i> for <code>EntryGroupData.children</code> property defined at extension <code>commercefacades</code>. */
		
	private List<EntryGroupData> children;

	/** <i>Generated property</i> for <code>EntryGroupData.externalReferenceId</code> property defined at extension <code>commercefacades</code>. */
		
	private String externalReferenceId;

	/** <i>Generated property</i> for <code>EntryGroupData.erroneous</code> property defined at extension <code>commercefacades</code>. */
		
	private Boolean erroneous;

	/** <i>Generated property</i> for <code>EntryGroupData.orderEntries</code> property defined at extension <code>commercefacades</code>. */
		
	private List<OrderEntryData> orderEntries;

	/** <i>Generated property</i> for <code>EntryGroupData.rootGroup</code> property defined at extension <code>commercefacades</code>. */
		
	private EntryGroupData rootGroup;

	/** <i>Generated property</i> for <code>EntryGroupData.parent</code> property defined at extension <code>commercefacades</code>. */
		
	private EntryGroupData parent;
	
	public EntryGroupData()
	{
		// default constructor
	}
	
		
	
	public void setGroupNumber(final Integer groupNumber)
	{
		this.groupNumber = groupNumber;
	}

		
	
	public Integer getGroupNumber() 
	{
		return groupNumber;
	}
	
		
	
	public void setPriority(final Integer priority)
	{
		this.priority = priority;
	}

		
	
	public Integer getPriority() 
	{
		return priority;
	}
	
		
	
	public void setLabel(final String label)
	{
		this.label = label;
	}

		
	
	public String getLabel() 
	{
		return label;
	}
	
		
	
	public void setGroupType(final GroupType groupType)
	{
		this.groupType = groupType;
	}

		
	
	public GroupType getGroupType() 
	{
		return groupType;
	}
	
		
	
	public void setChildren(final List<EntryGroupData> children)
	{
		this.children = children;
	}

		
	
	public List<EntryGroupData> getChildren() 
	{
		return children;
	}
	
		
	
	public void setExternalReferenceId(final String externalReferenceId)
	{
		this.externalReferenceId = externalReferenceId;
	}

		
	
	public String getExternalReferenceId() 
	{
		return externalReferenceId;
	}
	
		
	
	public void setErroneous(final Boolean erroneous)
	{
		this.erroneous = erroneous;
	}

		
	
	public Boolean getErroneous() 
	{
		return erroneous;
	}
	
		
	
	public void setOrderEntries(final List<OrderEntryData> orderEntries)
	{
		this.orderEntries = orderEntries;
	}

		
	
	public List<OrderEntryData> getOrderEntries() 
	{
		return orderEntries;
	}
	
		
	
	public void setRootGroup(final EntryGroupData rootGroup)
	{
		this.rootGroup = rootGroup;
	}

		
	
	public EntryGroupData getRootGroup() 
	{
		return rootGroup;
	}
	
		
	
	public void setParent(final EntryGroupData parent)
	{
		this.parent = parent;
	}

		
	
	public EntryGroupData getParent() 
	{
		return parent;
	}
	


}
