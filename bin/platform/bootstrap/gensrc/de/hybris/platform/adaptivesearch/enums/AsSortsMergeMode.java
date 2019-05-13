/*
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.adaptivesearch.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum AsSortsMergeMode declared at extension adaptivesearch.
 */
@SuppressWarnings("PMD")
public enum AsSortsMergeMode implements HybrisEnumValue
{
	/**
	 * Generated enum value for AsSortsMergeMode.ADD_AFTER declared at extension adaptivesearch.
	 */
	ADD_AFTER("ADD_AFTER"),
	/**
	 * Generated enum value for AsSortsMergeMode.ADD_BEFORE declared at extension adaptivesearch.
	 */
	ADD_BEFORE("ADD_BEFORE"),
	/**
	 * Generated enum value for AsSortsMergeMode.REPLACE declared at extension adaptivesearch.
	 */
	REPLACE("REPLACE");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "AsSortsMergeMode";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "AsSortsMergeMode";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private AsSortsMergeMode(final String code)
	{
		this.code = code.intern();
	}
	
	
	/**
	 * Gets the code of this enum value.
	 *  
	 * @return code of value
	 */
	@Override
	public String getCode()
	{
		return this.code;
	}
	
	/**
	 * Gets the type this enum value belongs to.
	 *  
	 * @return code of type
	 */
	@Override
	public String getType()
	{
		return SIMPLE_CLASSNAME;
	}
	
}
