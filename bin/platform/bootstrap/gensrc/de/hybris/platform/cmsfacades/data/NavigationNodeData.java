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
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.NavigationEntryData;
import de.hybris.platform.cmsfacades.data.NavigationNodeData;
import java.util.List;
import java.util.Map;

public  class NavigationNodeData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationNodeData.uid</code> property defined at extension <code>cmsfacades</code>. */
		
	private String uid;

	/** <i>Generated property</i> for <code>NavigationNodeData.uuid</code> property defined at extension <code>cmsfacades</code>. */
		
	private String uuid;

	/** <i>Generated property</i> for <code>NavigationNodeData.itemtype</code> property defined at extension <code>cmsfacades</code>. */
		
	private String itemtype;

	/** <i>Generated property</i> for <code>NavigationNodeData.parentUid</code> property defined at extension <code>cmsfacades</code>. */
		
	private String parentUid;

	/** <i>Generated property</i> for <code>NavigationNodeData.name</code> property defined at extension <code>cmsfacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>NavigationNodeData.title</code> property defined at extension <code>cmsfacades</code>. */
		
	private Map<String,String> title;

	/** <i>Generated property</i> for <code>NavigationNodeData.hasChildren</code> property defined at extension <code>cmsfacades</code>. */
		
	private Boolean hasChildren;

	/** <i>Generated property</i> for <code>NavigationNodeData.position</code> property defined at extension <code>cmsfacades</code>. */
		
	private Integer position;

	/** <i>Generated property</i> for <code>NavigationNodeData.entries</code> property defined at extension <code>cmsfacades</code>. */
		
	private List<NavigationEntryData> entries;

	/** <i>Generated property</i> for <code>NavigationNodeData.children</code> property defined at extension <code>cmsfacades</code>. */
		
	private List<NavigationNodeData> children;

	/** <i>Generated property</i> for <code>NavigationNodeData.localizedTitle</code> property defined at extension <code>cmsfacades</code>. */
		
	private String localizedTitle;
	
	public NavigationNodeData()
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
	
		
	
	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

		
	
	public String getUuid() 
	{
		return uuid;
	}
	
		
	
	public void setItemtype(final String itemtype)
	{
		this.itemtype = itemtype;
	}

		
	
	public String getItemtype() 
	{
		return itemtype;
	}
	
		
	
	public void setParentUid(final String parentUid)
	{
		this.parentUid = parentUid;
	}

		
	
	public String getParentUid() 
	{
		return parentUid;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setTitle(final Map<String,String> title)
	{
		this.title = title;
	}

		
	
	public Map<String,String> getTitle() 
	{
		return title;
	}
	
		
	
	public void setHasChildren(final Boolean hasChildren)
	{
		this.hasChildren = hasChildren;
	}

		
	
	public Boolean getHasChildren() 
	{
		return hasChildren;
	}
	
		
	
	public void setPosition(final Integer position)
	{
		this.position = position;
	}

		
	
	public Integer getPosition() 
	{
		return position;
	}
	
		
	
	public void setEntries(final List<NavigationEntryData> entries)
	{
		this.entries = entries;
	}

		
	
	public List<NavigationEntryData> getEntries() 
	{
		return entries;
	}
	
		
	
	public void setChildren(final List<NavigationNodeData> children)
	{
		this.children = children;
	}

		
	
	public List<NavigationNodeData> getChildren() 
	{
		return children;
	}
	
		
	
	public void setLocalizedTitle(final String localizedTitle)
	{
		this.localizedTitle = localizedTitle;
	}

		
	
	public String getLocalizedTitle() 
	{
		return localizedTitle;
	}
	


}
