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
package de.hybris.platform.store.pojo;

import java.io.Serializable;
import de.hybris.platform.store.pojo.StoreCountInfo;
import de.hybris.platform.store.pojo.StoreCountType;
import java.util.List;

public  class StoreCountInfo  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StoreCountInfo.type</code> property defined at extension <code>basecommerce</code>. */
		
	private StoreCountType type;

	/** <i>Generated property</i> for <code>StoreCountInfo.name</code> property defined at extension <code>basecommerce</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>StoreCountInfo.isoCode</code> property defined at extension <code>basecommerce</code>. */
		
	private String isoCode;

	/** <i>Generated property</i> for <code>StoreCountInfo.count</code> property defined at extension <code>basecommerce</code>. */
		
	private Integer count;

	/** <i>Generated property</i> for <code>StoreCountInfo.storeCountInfoList</code> property defined at extension <code>basecommerce</code>. */
		
	private List<StoreCountInfo> storeCountInfoList;
	
	public StoreCountInfo()
	{
		// default constructor
	}
	
		
	
	public void setType(final StoreCountType type)
	{
		this.type = type;
	}

		
	
	public StoreCountType getType() 
	{
		return type;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setIsoCode(final String isoCode)
	{
		this.isoCode = isoCode;
	}

		
	
	public String getIsoCode() 
	{
		return isoCode;
	}
	
		
	
	public void setCount(final Integer count)
	{
		this.count = count;
	}

		
	
	public Integer getCount() 
	{
		return count;
	}
	
		
	
	public void setStoreCountInfoList(final List<StoreCountInfo> storeCountInfoList)
	{
		this.storeCountInfoList = storeCountInfoList;
	}

		
	
	public List<StoreCountInfo> getStoreCountInfoList() 
	{
		return storeCountInfoList;
	}
	


}
