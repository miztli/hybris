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

import de.hybris.platform.adaptivesearch.data.AsFacetVisibility;
import de.hybris.platform.adaptivesearchbackoffice.data.AbstractSearchRequestData;

public  class FacetRequestData extends AbstractSearchRequestData 
{

 

	/** <i>Generated property</i> for <code>FacetRequestData.indexProperty</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private String indexProperty;

	/** <i>Generated property</i> for <code>FacetRequestData.open</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private boolean open;

	/** <i>Generated property</i> for <code>FacetRequestData.facetVisibility</code> property defined at extension <code>adaptivesearchbackoffice</code>. */
		
	private AsFacetVisibility facetVisibility;
	
	public FacetRequestData()
	{
		// default constructor
	}
	
		
	
	public void setIndexProperty(final String indexProperty)
	{
		this.indexProperty = indexProperty;
	}

		
	
	public String getIndexProperty() 
	{
		return indexProperty;
	}
	
		
	
	public void setOpen(final boolean open)
	{
		this.open = open;
	}

		
	
	public boolean isOpen() 
	{
		return open;
	}
	
		
	
	public void setFacetVisibility(final AsFacetVisibility facetVisibility)
	{
		this.facetVisibility = facetVisibility;
	}

		
	
	public AsFacetVisibility getFacetVisibility() 
	{
		return facetVisibility;
	}
	


}
