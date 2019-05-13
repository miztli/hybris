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
package de.hybris.platform.adaptivesearch.converters;

import java.io.Serializable;
import de.hybris.platform.catalog.model.CatalogVersionModel;

public  class AsConfigurationReverseConverterContext  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsConfigurationReverseConverterContext.catalogVersion</code> property defined at extension <code>adaptivesearch</code>. */
		
	private CatalogVersionModel catalogVersion;
	
	public AsConfigurationReverseConverterContext()
	{
		// default constructor
	}
	
		
	
	public void setCatalogVersion(final CatalogVersionModel catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

		
	
	public CatalogVersionModel getCatalogVersion() 
	{
		return catalogVersion;
	}
	


}
