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
package de.hybris.platform.commercewebservicescommons.dto.catalog;

import java.io.Serializable;
import de.hybris.platform.commercewebservicescommons.dto.catalog.CatalogWsDTO;
import java.util.List;

public  class CatalogListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogListWsDTO.catalogs</code> property defined at extension <code>commercewebservicescommons</code>. */
		
	private List<CatalogWsDTO> catalogs;
	
	public CatalogListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setCatalogs(final List<CatalogWsDTO> catalogs)
	{
		this.catalogs = catalogs;
	}

		
	
	public List<CatalogWsDTO> getCatalogs() 
	{
		return catalogs;
	}
	


}
