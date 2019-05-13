/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
package de.hybris.platform.adaptivesearch.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearch.data.AsCatalogVersion;

public  class AbstractAsSearchProfile  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractAsSearchProfile.catalogVersion</code> property defined at extension <code>adaptivesearch</code>. */
		
	private AsCatalogVersion catalogVersion;

	/** <i>Generated property</i> for <code>AbstractAsSearchProfile.code</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>AbstractAsSearchProfile.indexType</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String indexType;
	
	public AbstractAsSearchProfile()
	{
		// default constructor
	}
	
		
	
	public void setCatalogVersion(final AsCatalogVersion catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

		
	
	public AsCatalogVersion getCatalogVersion() 
	{
		return catalogVersion;
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
	}
	
		
	
	public void setIndexType(final String indexType)
	{
		this.indexType = indexType;
	}

		
	
	public String getIndexType() 
	{
		return indexType;
	}
	


}
