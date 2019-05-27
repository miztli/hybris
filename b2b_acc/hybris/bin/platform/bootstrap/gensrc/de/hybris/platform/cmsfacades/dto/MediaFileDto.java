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
package de.hybris.platform.cmsfacades.dto;

import java.io.Serializable;
import java.io.InputStream;

public  class MediaFileDto  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaFileDto.inputStream</code> property defined at extension <code>cmsfacades</code>. */
		
	private InputStream inputStream;

	/** <i>Generated property</i> for <code>MediaFileDto.mime</code> property defined at extension <code>cmsfacades</code>. */
		
	private String mime;

	/** <i>Generated property</i> for <code>MediaFileDto.name</code> property defined at extension <code>cmsfacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>MediaFileDto.size</code> property defined at extension <code>cmsfacades</code>. */
		
	private Long size;
	
	public MediaFileDto()
	{
		// default constructor
	}
	
		
	
	public void setInputStream(final InputStream inputStream)
	{
		this.inputStream = inputStream;
	}

		
	
	public InputStream getInputStream() 
	{
		return inputStream;
	}
	
		
	
	public void setMime(final String mime)
	{
		this.mime = mime;
	}

		
	
	public String getMime() 
	{
		return mime;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setSize(final Long size)
	{
		this.size = size;
	}

		
	
	public Long getSize() 
	{
		return size;
	}
	


}
