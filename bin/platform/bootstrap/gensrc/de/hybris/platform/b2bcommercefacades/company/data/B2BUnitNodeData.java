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
package de.hybris.platform.b2bcommercefacades.company.data;

import java.io.Serializable;
import java.util.List;

public  class B2BUnitNodeData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.id</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.name</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.parent</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private String parent;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.active</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private boolean active;

	/** <i>Generated property</i> for <code>B2BUnitNodeData.children</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<B2BUnitNodeData> children;
	
	public B2BUnitNodeData()
	{
		// default constructor
	}
	
		
	
	public void setId(final String id)
	{
		this.id = id;
	}

		
	
	public String getId() 
	{
		return id;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setParent(final String parent)
	{
		this.parent = parent;
	}

		
	
	public String getParent() 
	{
		return parent;
	}
	
		
	
	public void setActive(final boolean active)
	{
		this.active = active;
	}

		
	
	public boolean isActive() 
	{
		return active;
	}
	
		
	
	public void setChildren(final List<B2BUnitNodeData> children)
	{
		this.children = children;
	}

		
	
	public List<B2BUnitNodeData> getChildren() 
	{
		return children;
	}
	


}
