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
package de.hybris.platform.personalizationfacades.data;

import java.io.Serializable;
import de.hybris.platform.personalizationfacades.data.VariationData;
import de.hybris.platform.personalizationfacades.enums.ItemStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;

/**
 * Customization
 */
@ApiModel(value="customization", description="Customization")
public  class CustomizationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** Customization code<br/><br/><i>Generated property</i> for <code>CustomizationData.code</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="code", value="Customization code") 	
	private String code;

	/** Customization name<br/><br/><i>Generated property</i> for <code>CustomizationData.name</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="name", value="Customization name") 	
	private String name;

	/** Customization description<br/><br/><i>Generated property</i> for <code>CustomizationData.description</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="description", value="Customization description") 	
	private String description;

	/** Priority of the customization<br/><br/><i>Generated property</i> for <code>CustomizationData.rank</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="rank", value="Priority of the customization") 	
	private Integer rank;

	/** Dynamic attribute describing whether the customization affects the experience<br/><br/><i>Generated property</i> for <code>CustomizationData.active</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="active", value="Dynamic attribute describing whether the customization affects the experience") 	
	private Boolean active;

	/** Status of the customization<br/><br/><i>Generated property</i> for <code>CustomizationData.status</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="status", value="Status of the customization", allowableValues="ENABLED,DISABLED,DELETED") 	
	private ItemStatus status;

	/** Point in time when the customization will activate, if it's enabled<br/><br/><i>Generated property</i> for <code>CustomizationData.enabledStartDate</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="enabledStartDate", value="Point in time when the customization will activate, if it's enabled", example="yyyy-MM-ddTHH:mm:ssZ") 	
	private Date enabledStartDate;

	/** Point in time when the customization will deactivate<br/><br/><i>Generated property</i> for <code>CustomizationData.enabledEndDate</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="enabledEndDate", value="Point in time when the customization will deactivate", example="yyyy-MM-ddTHH:mm:ssZ") 	
	private Date enabledEndDate;

	/** Catalog name<br/><br/><i>Generated property</i> for <code>CustomizationData.catalog</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="catalog", value="Catalog name") 	
	private String catalog;

	/** Catalog version<br/><br/><i>Generated property</i> for <code>CustomizationData.catalogVersion</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="catalogVersion", value="Catalog version") 	
	private String catalogVersion;

	/** Details of the variations in this customization<br/><br/><i>Generated property</i> for <code>CustomizationData.variations</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="variations", value="Details of the variations in this customization") 	
	private List<VariationData> variations;
	
	public CustomizationData()
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
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

		
	
	public String getDescription() 
	{
		return description;
	}
	
		
	
	public void setRank(final Integer rank)
	{
		this.rank = rank;
	}

		
	
	public Integer getRank() 
	{
		return rank;
	}
	
		
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

		
	
	public Boolean getActive() 
	{
		return active;
	}
	
		
	
	public void setStatus(final ItemStatus status)
	{
		this.status = status;
	}

		
	
	public ItemStatus getStatus() 
	{
		return status;
	}
	
		
	
	public void setEnabledStartDate(final Date enabledStartDate)
	{
		this.enabledStartDate = enabledStartDate;
	}

		
	
	public Date getEnabledStartDate() 
	{
		return enabledStartDate;
	}
	
		
	
	public void setEnabledEndDate(final Date enabledEndDate)
	{
		this.enabledEndDate = enabledEndDate;
	}

		
	
	public Date getEnabledEndDate() 
	{
		return enabledEndDate;
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
	
		
	
	public void setVariations(final List<VariationData> variations)
	{
		this.variations = variations;
	}

		
	
	public List<VariationData> getVariations() 
	{
		return variations;
	}
	


}
