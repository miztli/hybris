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
package de.hybris.platform.adaptivesearchbackoffice.data;

import java.io.Serializable;
import de.hybris.platform.adaptivesearch.data.AsSearchQueryData;
import de.hybris.platform.adaptivesearchbackoffice.data.FacetStateData;
import java.util.Map;

public  class SearchStateData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SearchStateData.searchQuery</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private AsSearchQueryData searchQuery;

	/** <i>Generated property</i> for <code>SearchStateData.facetsState</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private Map<String,FacetStateData> facetsState;
	
	public SearchStateData()
	{
		// default constructor
	}
	
		
	
	public void setSearchQuery(final AsSearchQueryData searchQuery)
	{
		this.searchQuery = searchQuery;
	}

		
	
	public AsSearchQueryData getSearchQuery() 
	{
		return searchQuery;
	}
	
		
	
	public void setFacetsState(final Map<String,FacetStateData> facetsState)
	{
		this.facetsState = facetsState;
	}

		
	
	public Map<String,FacetStateData> getFacetsState() 
	{
		return facetsState;
	}
	


}
