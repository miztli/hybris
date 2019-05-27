/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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

public  class B2BSelectionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>B2BSelectionData.id</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>B2BSelectionData.selected</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private boolean selected;

	/** <i>Generated property</i> for <code>B2BSelectionData.active</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private boolean active;

	/** <i>Generated property</i> for <code>B2BSelectionData.roles</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<String> roles;

	/** <i>Generated property</i> for <code>B2BSelectionData.displayRoles</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private List<String> displayRoles;

	/** <i>Generated property</i> for <code>B2BSelectionData.normalizedCode</code> property defined at extension <code>b2bcommercefacades</code>. */
		
	private String normalizedCode;
	
	public B2BSelectionData()
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
	
		
	
	public void setSelected(final boolean selected)
	{
		this.selected = selected;
	}

		
	
	public boolean isSelected() 
	{
		return selected;
	}
	
		
	
	public void setActive(final boolean active)
	{
		this.active = active;
	}

		
	
	public boolean isActive() 
	{
		return active;
	}
	
		
	
	public void setRoles(final List<String> roles)
	{
		this.roles = roles;
	}

		
	
	public List<String> getRoles() 
	{
		return roles;
	}
	
		
	
	public void setDisplayRoles(final List<String> displayRoles)
	{
		this.displayRoles = displayRoles;
	}

		
	
	public List<String> getDisplayRoles() 
	{
		return displayRoles;
	}
	
		
	
	public void setNormalizedCode(final String normalizedCode)
	{
		this.normalizedCode = normalizedCode;
	}

		
	
	public String getNormalizedCode() 
	{
		return normalizedCode;
	}
	


}
