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
import de.hybris.platform.core.PK;

public  class AsReference  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsReference.pk</code> property defined at extension <code>adaptivesearch</code>. */
		
	private PK pk;

	/** <i>Generated property</i> for <code>AsReference.version</code> property defined at extension <code>adaptivesearch</code>. */
		
	private long version;
	
	public AsReference()
	{
		// default constructor
	}
	
		
	
	public void setPk(final PK pk)
	{
		this.pk = pk;
	}

		
	
	public PK getPk() 
	{
		return pk;
	}
	
		
	
	public void setVersion(final long version)
	{
		this.version = version;
	}

		
	
	public long getVersion() 
	{
		return version;
	}
	


}
