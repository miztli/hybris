/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
import java.util.Date;
import java.util.Map;

public  class ComponentWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ComponentWsDTO.uid</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String uid;

	/** <i>Generated property</i> for <code>ComponentWsDTO.typeCode</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String typeCode;

	/** <i>Generated property</i> for <code>ComponentWsDTO.modifiedtime</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private Date modifiedtime;

	/** <i>Generated property</i> for <code>ComponentWsDTO.name</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>ComponentWsDTO.otherProperties</code> property defined at extension <code>cmsoccaddon</code>. */
		
	private Map<String,Object> otherProperties;
	
	public ComponentWsDTO()
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
	
		
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

		
	
	public String getTypeCode() 
	{
		return typeCode;
	}
	
		
	
	public void setModifiedtime(final Date modifiedtime)
	{
		this.modifiedtime = modifiedtime;
	}

		
	
	public Date getModifiedtime() 
	{
		return modifiedtime;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setOtherProperties(final Map<String,Object> otherProperties)
	{
		this.otherProperties = otherProperties;
	}

		
	
	public Map<String,Object> getOtherProperties() 
	{
		return otherProperties;
	}
	


}
