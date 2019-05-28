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
package de.hybris.platform.adaptivesearch.data;

import java.io.Serializable;
import java.util.List;

public  class AsConfigurationHolder<T, R>  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsConfigurationHolder<T, R>.configuration</code> property defined at extension <code>adaptivesearch</code>. */
		
	private T configuration;

	/** <i>Generated property</i> for <code>AsConfigurationHolder<T, R>.replacedConfigurations</code> property defined at extension <code>adaptivesearch</code>. */
		
	private List<R> replacedConfigurations;

	/** <i>Generated property</i> for <code>AsConfigurationHolder<T, R>.rank</code> property defined at extension <code>adaptivesearch</code>. */
		
	private int rank;

	/** <i>Generated property</i> for <code>AsConfigurationHolder<T, R>.data</code> property defined at extension <code>adaptivesearch</code>. */
		
	private Object data;
	
	public AsConfigurationHolder()
	{
		// default constructor
	}
	
		
	
	public void setConfiguration(final T configuration)
	{
		this.configuration = configuration;
	}

		
	
	public T getConfiguration() 
	{
		return configuration;
	}
	
		
	
	public void setReplacedConfigurations(final List<R> replacedConfigurations)
	{
		this.replacedConfigurations = replacedConfigurations;
	}

		
	
	public List<R> getReplacedConfigurations() 
	{
		return replacedConfigurations;
	}
	
		
	
	public void setRank(final int rank)
	{
		this.rank = rank;
	}

		
	
	public int getRank() 
	{
		return rank;
	}
	
		
	
	public void setData(final Object data)
	{
		this.data = data;
	}

		
	
	public Object getData() 
	{
		return data;
	}
	


}
