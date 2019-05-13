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
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ApiModel(value="AbstractPageWsDTO")
public  class AbstractPageWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.pk</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="pk") 	
	private String pk;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.creationtime</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="creationtime") 	
	private Date creationtime;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.modifiedtime</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="modifiedtime") 	
	private Date modifiedtime;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.uid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="uid") 	
	private String uid;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.name</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="name") 	
	private String name;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.title</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="title") 	
	private Map<String,String> title;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.typeCode</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="typeCode") 	
	private String typeCode;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.template</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="template") 	
	private String template;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.defaultPage</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="defaultPage") 	
	private boolean defaultPage;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.onlyOneRestrictionMustApply</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="onlyOneRestrictionMustApply") 	
	private boolean onlyOneRestrictionMustApply;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.cloneComponents</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="cloneComponents") 	
	private boolean cloneComponents;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.restrictions</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="restrictions") 	
	private List<String> restrictions;

	/** <i>Generated property</i> for <code>AbstractPageWsDTO.catalogVersionUuid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="catalogVersionUuid") 	
	private String catalogVersionUuid;
	
	public AbstractPageWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setPk(final String pk)
	{
		this.pk = pk;
	}

		
	
	public String getPk() 
	{
		return pk;
	}
	
		
	
	public void setCreationtime(final Date creationtime)
	{
		this.creationtime = creationtime;
	}

		
	
	public Date getCreationtime() 
	{
		return creationtime;
	}
	
		
	
	public void setModifiedtime(final Date modifiedtime)
	{
		this.modifiedtime = modifiedtime;
	}

		
	
	public Date getModifiedtime() 
	{
		return modifiedtime;
	}
	
		
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

		
	
	public String getUid() 
	{
		return uid;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setTitle(final Map<String,String> title)
	{
		this.title = title;
	}

		
	
	public Map<String,String> getTitle() 
	{
		return title;
	}
	
		
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

		
	
	public String getTypeCode() 
	{
		return typeCode;
	}
	
		
	
	public void setTemplate(final String template)
	{
		this.template = template;
	}

		
	
	public String getTemplate() 
	{
		return template;
	}
	
		
	
	public void setDefaultPage(final boolean defaultPage)
	{
		this.defaultPage = defaultPage;
	}

		
	
	public boolean isDefaultPage() 
	{
		return defaultPage;
	}
	
		
	
	public void setOnlyOneRestrictionMustApply(final boolean onlyOneRestrictionMustApply)
	{
		this.onlyOneRestrictionMustApply = onlyOneRestrictionMustApply;
	}

		
	
	public boolean isOnlyOneRestrictionMustApply() 
	{
		return onlyOneRestrictionMustApply;
	}
	
		
	
	public void setCloneComponents(final boolean cloneComponents)
	{
		this.cloneComponents = cloneComponents;
	}

		
	
	public boolean isCloneComponents() 
	{
		return cloneComponents;
	}
	
		
	
	public void setRestrictions(final List<String> restrictions)
	{
		this.restrictions = restrictions;
	}

		
	
	public List<String> getRestrictions() 
	{
		return restrictions;
	}
	
		
	
	public void setCatalogVersionUuid(final String catalogVersionUuid)
	{
		this.catalogVersionUuid = catalogVersionUuid;
	}

		
	
	public String getCatalogVersionUuid() 
	{
		return catalogVersionUuid;
	}
	


}
