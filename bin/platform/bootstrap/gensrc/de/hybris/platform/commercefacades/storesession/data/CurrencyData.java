/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 10, 2019 3:20:54 PM
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
package de.hybris.platform.commercefacades.storesession.data;

import java.io.Serializable;

public  class CurrencyData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CurrencyData.isocode</code> property defined at extension <code>commercefacades</code>. */
		
	private String isocode;

	/** <i>Generated property</i> for <code>CurrencyData.name</code> property defined at extension <code>commercefacades</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>CurrencyData.active</code> property defined at extension <code>commercefacades</code>. */
		
	private boolean active;

	/** <i>Generated property</i> for <code>CurrencyData.symbol</code> property defined at extension <code>commercefacades</code>. */
		
	private String symbol;
	
	public CurrencyData()
	{
		// default constructor
	}
	
		
	
	public void setIsocode(final String isocode)
	{
		this.isocode = isocode;
	}

		
	
	public String getIsocode() 
	{
		return isocode;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setActive(final boolean active)
	{
		this.active = active;
	}

		
	
	public boolean isActive() 
	{
		return active;
	}
	
		
	
	public void setSymbol(final String symbol)
	{
		this.symbol = symbol;
	}

		
	
	public String getSymbol() 
	{
		return symbol;
	}
	


}
