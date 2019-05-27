/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 2-Sep-2015 12:47:23 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.hybris.mobile.lib.commerce.data.store;

import com.hybris.mobile.lib.commerce.data.search.pagedata.Pagination;
import com.hybris.mobile.lib.commerce.data.search.pagedata.Sort;

import java.util.List;

public class StoreFinderSearchPage  implements java.io.Serializable 
{

	/** <i>Generated property</i> for <code>StoreFinderSearchPage.sourceLatitude</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double sourceLatitude;
	/** <i>Generated property</i> for <code>StoreFinderSearchPage.sourceLongitude</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double sourceLongitude;
	/** <i>Generated property</i> for <code>StoreFinderSearchPage.pagination</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Pagination pagination;
	/** <i>Generated property</i> for <code>StoreFinderSearchPage.locationText</code> property defined at extension <code>commercewebservicescommons</code>. */
	private String locationText;
	/** <i>Generated property</i> for <code>StoreFinderSearchPage.boundWestLongitude</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double boundWestLongitude;
	/** <i>Generated property</i> for <code>StoreFinderSearchPage.stores</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<PointOfService> stores;
	/** <i>Generated property</i> for <code>StoreFinderSearchPage.boundNorthLatitude</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double boundNorthLatitude;
	/** <i>Generated property</i> for <code>StoreFinderSearchPage.sorts</code> property defined at extension <code>commercewebservicescommons</code>. */
	private List<Sort> sorts;
	/** <i>Generated property</i> for <code>StoreFinderSearchPage.boundSouthLatitude</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double boundSouthLatitude;
	/** <i>Generated property</i> for <code>StoreFinderSearchPage.boundEastLongitude</code> property defined at extension <code>commercewebservicescommons</code>. */
	private Double boundEastLongitude;
		
	public StoreFinderSearchPage()
	{
		// default constructor
	}
	
		
	public void setSourceLatitude(final Double sourceLatitude)
	{
		this.sourceLatitude = sourceLatitude;
	}
	
		
	public Double getSourceLatitude() 
	{
		return sourceLatitude;
	}
		
		
	public void setSourceLongitude(final Double sourceLongitude)
	{
		this.sourceLongitude = sourceLongitude;
	}
	
		
	public Double getSourceLongitude() 
	{
		return sourceLongitude;
	}
		
		
	public void setPagination(final Pagination pagination)
	{
		this.pagination = pagination;
	}
	
		
	public Pagination getPagination() 
	{
		return pagination;
	}
		
		
	public void setLocationText(final String locationText)
	{
		this.locationText = locationText;
	}
	
		
	public String getLocationText() 
	{
		return locationText;
	}
		
		
	public void setBoundWestLongitude(final Double boundWestLongitude)
	{
		this.boundWestLongitude = boundWestLongitude;
	}
	
		
	public Double getBoundWestLongitude() 
	{
		return boundWestLongitude;
	}
		
		
	public void setStores(final List<PointOfService> stores)
	{
		this.stores = stores;
	}
	
		
	public List<PointOfService> getStores() 
	{
		return stores;
	}
		
		
	public void setBoundNorthLatitude(final Double boundNorthLatitude)
	{
		this.boundNorthLatitude = boundNorthLatitude;
	}
	
		
	public Double getBoundNorthLatitude() 
	{
		return boundNorthLatitude;
	}
		
		
	public void setSorts(final List<Sort> sorts)
	{
		this.sorts = sorts;
	}
	
		
	public List<Sort> getSorts() 
	{
		return sorts;
	}
		
		
	public void setBoundSouthLatitude(final Double boundSouthLatitude)
	{
		this.boundSouthLatitude = boundSouthLatitude;
	}
	
		
	public Double getBoundSouthLatitude() 
	{
		return boundSouthLatitude;
	}
		
		
	public void setBoundEastLongitude(final Double boundEastLongitude)
	{
		this.boundEastLongitude = boundEastLongitude;
	}
	
		
	public Double getBoundEastLongitude() 
	{
		return boundEastLongitude;
	}
		
	
}