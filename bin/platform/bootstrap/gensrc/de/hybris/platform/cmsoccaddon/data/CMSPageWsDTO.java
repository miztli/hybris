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
package de.hybris.platform.cmsoccaddon.data;

import java.io.Serializable;
import de.hybris.platform.cmsoccaddon.data.ContentSlotListWsDTO;

public  class CMSPageWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.uid</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String uid;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.title</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String title;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.template</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String template;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.typeCode</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String typeCode;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.name</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.defaultPage</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private Boolean defaultPage;

	/** <i>Generated property</i> for <code>CMSPageWsDTO.contentSlots</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private ContentSlotListWsDTO contentSlots;
	
	public CMSPageWsDTO()
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
	
		
	
	public void setTitle(final String title)
	{
		this.title = title;
	}

		
	
	public String getTitle() 
	{
		return title;
	}
	
		
	
	public void setTemplate(final String template)
	{
		this.template = template;
	}

		
	
	public String getTemplate() 
	{
		return template;
	}
	
		
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

		
	
	public String getTypeCode() 
	{
		return typeCode;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setDefaultPage(final Boolean defaultPage)
	{
		this.defaultPage = defaultPage;
	}

		
	
	public Boolean getDefaultPage() 
	{
		return defaultPage;
	}
	
		
	
	public void setContentSlots(final ContentSlotListWsDTO contentSlots)
	{
		this.contentSlots = contentSlots;
	}

		
	
	public ContentSlotListWsDTO getContentSlots() 
	{
		return contentSlots;
	}
	


}
