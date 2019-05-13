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
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import de.hybris.platform.cmssmarteditwebservices.dto.StructureWsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * The list of structures for a type code.
 *
 * @deprecated since 1811, no longer needed.
 */
@ApiModel(value="StructureListWsDTO", description="The list of structures for a type code.")
@Deprecated
public  class StructureListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>StructureListWsDTO.structures</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="structures") 	
	private List<StructureWsDTO> structures;
	
	public StructureListWsDTO()
	{
		// default constructor
	}
	
		
	
	public void setStructures(final List<StructureWsDTO> structures)
	{
		this.structures = structures;
	}

		
	
	public List<StructureWsDTO> getStructures() 
	{
		return structures;
	}
	


}
