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
package de.hybris.platform.commercewebservicescommons.dto.consent;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.consent.ConsentWsDTO;

public  class ConsentTemplateWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsentTemplateWsDTO.id</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>ConsentTemplateWsDTO.name</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>ConsentTemplateWsDTO.description</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private String description;

	/** <i>Generated property</i> for <code>ConsentTemplateWsDTO.version</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private Integer version;

	/** <i>Generated property</i> for <code>ConsentTemplateWsDTO.currentConsent</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private ConsentWsDTO currentConsent;
	
	public ConsentTemplateWsDTO()
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
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	
		
	
	public void setVersion(final Integer version)
	{
		this.version = version;
	}

		
	
	public Integer getVersion() 
	{
		return version;
	}
	
		
	
	public void setCurrentConsent(final ConsentWsDTO currentConsent)
	{
		this.currentConsent = currentConsent;
	}

		
	
	public ConsentWsDTO getCurrentConsent() 
	{
		return currentConsent;
	}
	


}
