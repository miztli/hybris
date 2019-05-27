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
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.AbstractPageData;

/**
 * 
            HomePageData is part of CatalogVersionData, providing some associations:
        
 */
public  class HomePageData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** 
				The homepage of the given catalog version. This may be from the given catalog version or
				in multi country this may come from a parent catalog.
			<br/><br/><i>Generated property</i> for <code>HomePageData.current</code> property defined at extension <code>cmsfacades</code>. */
		
	private AbstractPageData current;

	/** 
				If the given catalog version is staged, this will be the homepage from online, if online,
				will be the same as current.
			<br/><br/><i>Generated property</i> for <code>HomePageData.old</code> property defined at extension <code>cmsfacades</code>. */
		
	private AbstractPageData old;

	/** 
				For multi country only. Fallback will be the first homepage found searching in the parent
				catalog up until it finds a homepage.
			<br/><br/><i>Generated property</i> for <code>HomePageData.fallback</code> property defined at extension <code>cmsfacades</code>. */
		
	private AbstractPageData fallback;
	
	public HomePageData()
	{
		// default constructor
	}
	
		
	
	public void setCurrent(final AbstractPageData current)
	{
		this.current = current;
	}

		
	
	public AbstractPageData getCurrent() 
	{
		return current;
	}
	
		
	
	public void setOld(final AbstractPageData old)
	{
		this.old = old;
	}

		
	
	public AbstractPageData getOld() 
	{
		return old;
	}
	
		
	
	public void setFallback(final AbstractPageData fallback)
	{
		this.fallback = fallback;
	}

		
	
	public AbstractPageData getFallback() 
	{
		return fallback;
	}
	


}
