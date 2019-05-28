/*
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.acceleratorservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum CheckoutFlowEnum declared at extension acceleratorservices.
 */
@SuppressWarnings("PMD")
public enum CheckoutFlowEnum implements HybrisEnumValue
{
	/**
	 * Generated enum value for CheckoutFlowEnum.MULTISTEP declared at extension acceleratorservices.
	 */
	MULTISTEP("MULTISTEP"),
	/**
	 * Generated enum value for CheckoutFlowEnum.SINGLE declared at extension b2bacceleratorservices.
	 */
	SINGLE("SINGLE");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "CheckoutFlowEnum";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "CheckoutFlowEnum";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private CheckoutFlowEnum(final String code)
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