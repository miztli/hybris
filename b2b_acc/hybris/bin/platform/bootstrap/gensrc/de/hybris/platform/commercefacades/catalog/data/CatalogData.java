/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
package de.hybris.platform.commercefacades.catalog.data;

import de.hybris.platform.commercefacades.catalog.data.AbstractCatalogItemData;
import de.hybris.platform.commercefacades.catalog.data.CatalogVersionData;
import java.util.Collection;

public  class CatalogData extends AbstractCatalogItemData 
{

 

	/** <i>Generated property</i> for <code>CatalogData.catalogVersions</code> property defined at extension <code>commercefacades</code>. */
		
	private Collection<CatalogVersionData> catalogVersions;
	
	public CatalogData()
	{
		// default constructor
	}
	
		
	
	public void setCatalogVersions(final Collection<CatalogVersionData> catalogVersions)
	{
		this.catalogVersions = catalogVersions;
	}

		
	
	public Collection<CatalogVersionData> getCatalogVersions() 
	{
		return catalogVersions;
	}
	


}
