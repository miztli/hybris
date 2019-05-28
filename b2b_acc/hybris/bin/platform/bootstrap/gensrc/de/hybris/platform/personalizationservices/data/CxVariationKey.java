/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
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
package de.hybris.platform.personalizationservices.data;

import java.io.Serializable;

public  class CxVariationKey  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CxVariationKey.variationCode</code> property defined at extension <code>personalizationservices</code>. */
		
	private String variationCode;

	/** <i>Generated property</i> for <code>CxVariationKey.customizationCode</code> property defined at extension <code>personalizationservices</code>. */
		
	private String customizationCode;

	/** <i>Generated property</i> for <code>CxVariationKey.catalog</code> property defined at extension <code>personalizationservices</code>. */
		
	private String catalog;

	/** <i>Generated property</i> for <code>CxVariationKey.catalogVersion</code> property defined at extension <code>personalizationservices</code>. */
		
	private String catalogVersion;
	
	public CxVariationKey()
	{
		// default constructor
	}
	
		
	
	public void setVariationCode(final String variationCode)
	{
		this.variationCode = variationCode;
	}

		
	
	public String getVariationCode() 
	{
		return variationCode;
	}
	
		
	
	public void setCustomizationCode(final String customizationCode)
	{
		this.customizationCode = customizationCode;
	}

		
	
	public String getCustomizationCode() 
	{
		return customizationCode;
	}
	
		
	
	public void setCatalog(final String catalog)
	{
		this.catalog = catalog;
	}

		
	
	public String getCatalog() 
	{
		return catalog;
	}
	
		
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

		
	
	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	

	@Override
	public boolean equals(final Object o)
	{
	
		if (o == null) return false;
		if (o == this) return true;

		try
		{
			final CxVariationKey other = (CxVariationKey) o;
			return new org.apache.commons.lang.builder.EqualsBuilder()
			.append(getVariationCode(), other.getVariationCode()) 
			.append(getCustomizationCode(), other.getCustomizationCode()) 
			.append(getCatalog(), other.getCatalog()) 
			.append(getCatalogVersion(), other.getCatalogVersion()) 
			.isEquals();
		} 
		catch (ClassCastException c)
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return new org.apache.commons.lang.builder.HashCodeBuilder()
		.append(getVariationCode()) 
		.append(getCustomizationCode()) 
		.append(getCatalog()) 
		.append(getCatalogVersion()) 
		.toHashCode();
	}

}
