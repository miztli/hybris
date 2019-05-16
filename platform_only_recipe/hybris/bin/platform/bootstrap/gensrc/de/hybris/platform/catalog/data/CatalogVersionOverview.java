/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 16, 2019 10:32:52 AM
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
package de.hybris.platform.catalog.data;

import java.io.Serializable;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import java.util.Map;

public  class CatalogVersionOverview  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogVersionOverview.catalogVersion</code> property defined at extension <code>catalog</code>. */
		
	private CatalogVersionModel catalogVersion;

	/** <i>Generated property</i> for <code>CatalogVersionOverview.typeAmounts</code> property defined at extension <code>catalog</code>. */
		
	private Map<ComposedTypeModel, Long> typeAmounts;
	
	public CatalogVersionOverview()
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
	
		
	
	public void setTypeAmounts(final Map<ComposedTypeModel, Long> typeAmounts)
	{
		this.typeAmounts = typeAmounts;
	}

		
	
	public Map<ComposedTypeModel, Long> getTypeAmounts() 
	{
		return typeAmounts;
	}
	


}
