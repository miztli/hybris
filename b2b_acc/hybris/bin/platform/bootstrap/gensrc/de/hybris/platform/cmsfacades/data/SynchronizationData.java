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
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import java.util.List;

public  class SynchronizationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SynchronizationData.items</code> property defined at extension <code>cmsfacades</code>. */
		
	private List<ItemSynchronizationData> items;
	
	public SynchronizationData()
	{
		// default constructor
	}
	
		
	
	public void setItems(final List<ItemSynchronizationData> items)
	{
		this.items = items;
	}

		
	
	public List<ItemSynchronizationData> getItems() 
	{
		return items;
	}
	


}
