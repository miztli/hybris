/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:55 PM
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
import de.hybris.platform.adaptivesearch.data.AsRankChangeType;

public  class AsRankChange  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsRankChange.type</code> property defined at extension <code>adaptivesearch</code>. */
		
	private AsRankChangeType type;

	/** <i>Generated property</i> for <code>AsRankChange.uid</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String uid;

	/** <i>Generated property</i> for <code>AsRankChange.oldRank</code> property defined at extension <code>adaptivesearch</code>. */
		
	private Integer oldRank;

	/** <i>Generated property</i> for <code>AsRankChange.newRank</code> property defined at extension <code>adaptivesearch</code>. */
		
	private Integer newRank;
	
	public AsRankChange()
	{
		// default constructor
	}
	
		
	
	public void setType(final AsRankChangeType type)
	{
		this.type = type;
	}

		
	
	public AsRankChangeType getType() 
	{
		return type;
	}
	
		
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

		
	
	public String getUid() 
	{
		return uid;
	}
	
		
	
	public void setOldRank(final Integer oldRank)
	{
		this.oldRank = oldRank;
	}

		
	
	public Integer getOldRank() 
	{
		return oldRank;
	}
	
		
	
	public void setNewRank(final Integer newRank)
	{
		this.newRank = newRank;
	}

		
	
	public Integer getNewRank() 
	{
		return newRank;
	}
	


}
