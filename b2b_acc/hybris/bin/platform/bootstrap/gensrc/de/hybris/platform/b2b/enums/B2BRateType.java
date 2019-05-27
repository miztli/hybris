/*
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.b2b.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum B2BRateType declared at extension b2bcommerce.
 */
@SuppressWarnings("PMD")
public enum B2BRateType implements HybrisEnumValue
{
	/**
	 * Generated enum value for B2BRateType.CURRENCY declared at extension b2bcommerce.
	 */
	CURRENCY("CURRENCY"),
	/**
	 * Generated enum value for B2BRateType.PERCENTAGE declared at extension b2bcommerce.
	 */
	PERCENTAGE("PERCENTAGE");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "B2BRateType";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "B2BRateType";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private B2BRateType(final String code)
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
