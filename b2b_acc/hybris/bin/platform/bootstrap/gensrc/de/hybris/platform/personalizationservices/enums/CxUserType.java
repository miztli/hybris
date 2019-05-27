/*
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.personalizationservices.enums;

import de.hybris.platform.core.HybrisEnumValue;

/**
 * Generated enum CxUserType declared at extension personalizationservices.
 */
@SuppressWarnings("PMD")
public enum CxUserType implements HybrisEnumValue
{
	/**
	 * Generated enum value for CxUserType.REGISTERED declared at extension personalizationservices.
	 * <p/>
	 * Registered customer.
	 */
	REGISTERED("REGISTERED"),
	/**
	 * Generated enum value for CxUserType.ANONYMOUS declared at extension personalizationservices.
	 * <p/>
	 * Anonymous customer.
	 */
	ANONYMOUS("ANONYMOUS"),
	/**
	 * Generated enum value for CxUserType.ALL declared at extension personalizationservices.
	 * <p/>
	 * All customers.
	 */
	ALL("ALL");
	 
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "CxUserType";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "CxUserType";
	
	/** The code of this enum.*/
	private final String code;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private CxUserType(final String code)
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
