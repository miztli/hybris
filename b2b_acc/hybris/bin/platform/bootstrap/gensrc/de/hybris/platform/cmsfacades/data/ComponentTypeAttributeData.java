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
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.OptionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ApiModel(value="ComponentTypeAttributeData")
public  class ComponentTypeAttributeData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.qualifier</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="qualifier") 	
	private String qualifier;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.required</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="required") 	
	private boolean required;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.localized</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="localized") 	
	private Boolean localized;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.editable</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="editable") 	
	private boolean editable;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.cmsStructureType</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="cmsStructureType") 	
	private String cmsStructureType;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.cmsStructureEnumType</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="cmsStructureEnumType") 	
	private String cmsStructureEnumType;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.i18nKey</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="i18nKey") 	
	private String i18nKey;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.paged</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="paged") 	
	private boolean paged;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.collection</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="collection") 	
	private boolean collection;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.dependsOn</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="dependsOn") 	
	private String dependsOn;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.options</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="options") 	
	private List<OptionData> options;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.idAttribute</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="idAttribute") 	
	private String idAttribute;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.labelAttributes</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="labelAttributes") 	
	private List<String> labelAttributes;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.params</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="params") 	
	private Map<String,String> params;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.uri</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="uri") 	
	private String uri;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.subTypes</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="subTypes") 	
	private Map<String,String> subTypes;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.containedTypes</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="containedTypes") 	
	private Set<String> containedTypes;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.placeholder</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="placeholder") 	
	private String placeholder;

	/** <i>Generated property</i> for <code>ComponentTypeAttributeData.mode</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="mode") 	
	private String mode;
	
	public ComponentTypeAttributeData()
	{
		// default constructor
	}
	
		
	
	public void setQualifier(final String qualifier)
	{
		this.qualifier = qualifier;
	}

		
	
	public String getQualifier() 
	{
		return qualifier;
	}
	
		
	
	public void setRequired(final boolean required)
	{
		this.required = required;
	}

		
	
	public boolean isRequired() 
	{
		return required;
	}
	
		
	
	public void setLocalized(final Boolean localized)
	{
		this.localized = localized;
	}

		
	
	public Boolean getLocalized() 
	{
		return localized;
	}
	
		
	
	public void setEditable(final boolean editable)
	{
		this.editable = editable;
	}

		
	
	public boolean isEditable() 
	{
		return editable;
	}
	
		
	
	public void setCmsStructureType(final String cmsStructureType)
	{
		this.cmsStructureType = cmsStructureType;
	}

		
	
	public String getCmsStructureType() 
	{
		return cmsStructureType;
	}
	
		
	
	public void setCmsStructureEnumType(final String cmsStructureEnumType)
	{
		this.cmsStructureEnumType = cmsStructureEnumType;
	}

		
	
	public String getCmsStructureEnumType() 
	{
		return cmsStructureEnumType;
	}
	
		
	
	public void setI18nKey(final String i18nKey)
	{
		this.i18nKey = i18nKey;
	}

		
	
	public String getI18nKey() 
	{
		return i18nKey;
	}
	
		
	
	public void setPaged(final boolean paged)
	{
		this.paged = paged;
	}

		
	
	public boolean isPaged() 
	{
		return paged;
	}
	
		
	
	public void setCollection(final boolean collection)
	{
		this.collection = collection;
	}

		
	
	public boolean isCollection() 
	{
		return collection;
	}
	
		
	
	public void setDependsOn(final String dependsOn)
	{
		this.dependsOn = dependsOn;
	}

		
	
	public String getDependsOn() 
	{
		return dependsOn;
	}
	
		
	
	public void setOptions(final List<OptionData> options)
	{
		this.options = options;
	}

		
	
	public List<OptionData> getOptions() 
	{
		return options;
	}
	
		
	
	public void setIdAttribute(final String idAttribute)
	{
		this.idAttribute = idAttribute;
	}

		
	
	public String getIdAttribute() 
	{
		return idAttribute;
	}
	
		
	
	public void setLabelAttributes(final List<String> labelAttributes)
	{
		this.labelAttributes = labelAttributes;
	}

		
	
	public List<String> getLabelAttributes() 
	{
		return labelAttributes;
	}
	
		
	
	public void setParams(final Map<String,String> params)
	{
		this.params = params;
	}

		
	
	public Map<String,String> getParams() 
	{
		return params;
	}
	
		
	
	public void setUri(final String uri)
	{
		this.uri = uri;
	}

		
	
	public String getUri() 
	{
		return uri;
	}
	
		
	
	public void setSubTypes(final Map<String,String> subTypes)
	{
		this.subTypes = subTypes;
	}

		
	
	public Map<String,String> getSubTypes() 
	{
		return subTypes;
	}
	
		
	
	public void setContainedTypes(final Set<String> containedTypes)
	{
		this.containedTypes = containedTypes;
	}

		
	
	public Set<String> getContainedTypes() 
	{
		return containedTypes;
	}
	
		
	
	public void setPlaceholder(final String placeholder)
	{
		this.placeholder = placeholder;
	}

		
	
	public String getPlaceholder() 
	{
		return placeholder;
	}
	
	@Deprecated
    /**
     * @deprecated true
     */
		
	
	public void setMode(final String mode)
	{
		this.mode = mode;
	}

	@Deprecated
	/**
	 * @deprecated true
	 */
		
	
	public String getMode() 
	{
		return mode;
	}
	


}
