/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 27, 2019 5:14:20 PM
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
import de.hybris.platform.personalizationfacades.data.ActionData;
import de.hybris.platform.personalizationfacades.data.CustomizationData;
import de.hybris.platform.personalizationfacades.data.TriggerData;
import de.hybris.platform.personalizationfacades.enums.ItemStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Variation
 */
@ApiModel(value="variation", description="Variation")
public  class VariationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** Variation code<br/><br/><i>Generated property</i> for <code>VariationData.code</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="code", value="Variation code") 	
	private String code;

	/** Variation name<br/><br/><i>Generated property</i> for <code>VariationData.name</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="name", value="Variation name") 	
	private String name;

	/** Dynamic attribute describing whether the variation affects the experience<br/><br/><i>Generated property</i> for <code>VariationData.active</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="active", value="Dynamic attribute describing whether the variation affects the experience") 	
	private Boolean active;

	/** This is deprecated field (use status field instead)<br/><br/><i>Generated property</i> for <code>VariationData.enabled</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="enabled", value="This is deprecated field (use status field instead)") 	
	private Boolean enabled;

	/** Priority of the variation<br/><br/><i>Generated property</i> for <code>VariationData.rank</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="rank", value="Priority of the variation") 	
	private Integer rank;

	/** Status of the variation<br/><br/><i>Generated property</i> for <code>VariationData.status</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="status", value="Status of the variation", allowableValues="ENABLED,DISABLED,DELETED") 	
	private ItemStatus status;

	/** Catalog name<br/><br/><i>Generated property</i> for <code>VariationData.catalog</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="catalog", value="Catalog name") 	
	private String catalog;

	/** Catalog version<br/><br/><i>Generated property</i> for <code>VariationData.catalogVersion</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="catalogVersion", value="Catalog version") 	
	private String catalogVersion;

	/** Details of the customization the variation belongs to<br/><br/><i>Generated property</i> for <code>VariationData.customization</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="customization", value="Details of the customization the variation belongs to") 	
	private CustomizationData customization;

	/** Details of the variation triggers<br/><br/><i>Generated property</i> for <code>VariationData.triggers</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="triggers", value="Details of the variation triggers") 	
	private List<TriggerData> triggers;

	/** Details of the variation actions<br/><br/><i>Generated property</i> for <code>VariationData.actions</code> property defined at extension <code>personalizationfacades</code>. */
	@ApiModelProperty(name="actions", value="Details of the variation actions") 	
	private List<ActionData> actions;
	
	public VariationData()
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
	
		
	
	public void setActive(final Boolean active)
	{
		this.active = active;
	}

		
	
	public Boolean getActive() 
	{
		return active;
	}
	
	@Deprecated
    /**
     * @deprecated Use status field instead
     */
		
	
	public void setEnabled(final Boolean enabled)
	{
		this.enabled = enabled;
	}

	@Deprecated
	/**
	 * @deprecated Use status field instead
	 */
		
	
	public Boolean getEnabled() 
	{
		return enabled;
	}
	
		
	
	public void setRank(final Integer rank)
	{
		this.rank = rank;
	}

		
	
	public Integer getRank() 
	{
		return rank;
	}
	
		
	
	public void setStatus(final ItemStatus status)
	{
		this.status = status;
	}

		
	
	public ItemStatus getStatus() 
	{
		return status;
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
	
		
	
	public void setCustomization(final CustomizationData customization)
	{
		this.customization = customization;
	}

		
	
	public CustomizationData getCustomization() 
	{
		return customization;
	}
	
		
	
	public void setTriggers(final List<TriggerData> triggers)
	{
		this.triggers = triggers;
	}

		
	
	public List<TriggerData> getTriggers() 
	{
		return triggers;
	}
	
		
	
	public void setActions(final List<ActionData> actions)
	{
		this.actions = actions;
	}

		
	
	public List<ActionData> getActions() 
	{
		return actions;
	}
	


}
