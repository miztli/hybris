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
package de.hybris.platform.cms2.data;

import java.io.Serializable;
import de.hybris.platform.core.PK;

public  class CMSItemData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSItemData.uid</code> property defined at extension <code>cms2</code>. */
		
	private String uid;

	/** <i>Generated property</i> for <code>CMSItemData.catalogId</code> property defined at extension <code>cms2</code>. */
		
	private String catalogId;

	/** <i>Generated property</i> for <code>CMSItemData.catalogVersion</code> property defined at extension <code>cms2</code>. */
		
	private String catalogVersion;

	/** <i>Generated property</i> for <code>CMSItemData.pk</code> property defined at extension <code>cms2</code>. */
		
	private PK pk;

	/** <i>Generated property</i> for <code>CMSItemData.typeCode</code> property defined at extension <code>cms2</code>. */
		
	private String typeCode;
	
	public CMSItemData()
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
	
		
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

		
	
	public String getCatalogId() 
	{
		return catalogId;
	}
	
		
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

		
	
	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
		
	
	public void setPk(final PK pk)
	{
		this.pk = pk;
	}

		
	
	public PK getPk() 
	{
		return pk;
	}
	
		
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

		
	
	public String getTypeCode() 
	{
		return typeCode;
	}
	


}
