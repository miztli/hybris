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
package de.hybris.platform.personalizationfacades.data;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Action
 */
@ApiModel(value="action", description="Action")
public  class ActionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** Action code<br/><br/><i>Generated property</i> for <code>ActionData.code</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="code", value="Action code") 	
	private String code;

	/** Catalog name<br/><br/><i>Generated property</i> for <code>ActionData.catalog</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="catalog", value="Catalog name") 	
	private String catalog;

	/** Catalog version<br/><br/><i>Generated property</i> for <code>ActionData.catalogVersion</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="catalogVersion", value="Catalog version") 	
	private String catalogVersion;

	/** Priority of the action<br/><br/><i>Generated property</i> for <code>ActionData.rank</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="rank", value="Priority of the action") 	
	private Integer rank;
	
	public ActionData()
	{
		// default constructor
	}
	
		
	
	public void setCode(final String code)
	{
		this.code = code;
	}

		
	
	public String getCode() 
	{
		return code;
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
	
		
	
	public void setRank(final Integer rank)
	{
		this.rank = rank;
	}

		
	
	public Integer getRank() 
	{
		return rank;
	}
	


}
