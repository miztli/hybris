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
package de.hybris.platform.personalizationwebservices.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Catalog version
 */
@ApiModel(value="catalogVersion", description="Catalog version")
public  class CatalogVersionWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** Catalog name<br/><br/><i>Generated property</i> for <code>CatalogVersionWsDTO.catalog</code> property defined at extension <code>personalizationwebservices</code>. */
	@ApiModelProperty(name="catalog", value="Catalog name") 	
	private String catalog;

	/** Catalog version<br/><br/><i>Generated property</i> for <code>CatalogVersionWsDTO.version</code> property defined at extension <code>personalizationwebservices</code>. */
	@ApiModelProperty(name="version", value="Catalog version") 	
	private String version;
	
	public CatalogVersionWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setCatalog(final String catalog)
	{
		this.catalog = catalog;
	}

		
	
	public String getCatalog() 
	{
		return catalog;
	}
	
		
	
	public void setVersion(final String version)
	{
		this.version = version;
	}

		
	
	public String getVersion() 
	{
		return version;
	}
	


}
