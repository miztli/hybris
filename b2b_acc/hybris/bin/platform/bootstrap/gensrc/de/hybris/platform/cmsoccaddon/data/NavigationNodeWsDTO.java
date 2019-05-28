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
package de.hybris.platform.cmsoccaddon.data;

import java.io.Serializable;
import de.hybris.platform.cmsoccaddon.data.NavigationEntryWsDTO;
import de.hybris.platform.cmsoccaddon.data.NavigationNodeWsDTO;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
			@XmlAccessorType(XmlAccessType.FIELD)
public  class NavigationNodeWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.uid</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String uid;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.name</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.position</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private Integer position;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.entries</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private List<NavigationEntryWsDTO> entries;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.children</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private List<NavigationNodeWsDTO> children;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.title</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String title;

	/** <i>Generated property</i> for <code>NavigationNodeWsDTO.localizedTitle</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String localizedTitle;
	
	public NavigationNodeWsDTO()
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
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setPosition(final Integer position)
	{
		this.position = position;
	}

		
	
	public Integer getPosition() 
	{
		return position;
	}
	
		
	
	public void setEntries(final List<NavigationEntryWsDTO> entries)
	{
		this.entries = entries;
	}

		
	
	public List<NavigationEntryWsDTO> getEntries() 
	{
		return entries;
	}
	
		
	
	public void setChildren(final List<NavigationNodeWsDTO> children)
	{
		this.children = children;
	}

		
	
	public List<NavigationNodeWsDTO> getChildren() 
	{
		return children;
	}
	
		
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

		
	
	public String getTitle() 
	{
		return title;
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
