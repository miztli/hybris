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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Generated enum B2BGroupEnum declared at extension b2bcommerce.
 * <p/>
 * Four Special B2B Groups because they grant rights to members.
 */
@SuppressWarnings("PMD")
public class B2BGroupEnum implements HybrisEnumValue
{
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "B2BGroupEnum";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "B2BGroupEnum";
	private static final ConcurrentMap<String, B2BGroupEnum> cache = new ConcurrentHashMap<String, B2BGroupEnum>();
	/**
	* Generated enum value for B2BGroupEnum.b2badmingroup declared at extension b2bcommerce.
	*/
	public static final B2BGroupEnum B2BADMINGROUP = valueOf("b2badmingroup");
	
	/**
	* Generated enum value for B2BGroupEnum.b2bcustomergroup declared at extension b2bcommerce.
	*/
	public static final B2BGroupEnum B2BCUSTOMERGROUP = valueOf("b2bcustomergroup");
	
	/**
	* Generated enum value for B2BGroupEnum.b2bapprovergroup declared at extension b2bcommerce.
	*/
	public static final B2BGroupEnum B2BAPPROVERGROUP = valueOf("b2bapprovergroup");
	
	/**
	* Generated enum value for B2BGroupEnum.b2bmanagergroup declared at extension b2bcommerce.
	*/
	public static final B2BGroupEnum B2BMANAGERGROUP = valueOf("b2bmanagergroup");
	
	
	/** The code of this enum.*/
	private final String code;
	private final String codeLowerCase;
	private static final long serialVersionUID = 0L;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private B2BGroupEnum(final String code)
	{
		this.code = code.intern();
		this.codeLowerCase = this.code.toLowerCase().intern();
	}
	
	
	/**
	 * Compares this object to the specified object. The result is <code>true</code>
	 * if and only if the argument is not <code>null</code> and is an <code>B2BGroupEnum
	 * </code> object that contains the enum value <code>code</code> as this object.
	 *  
	 * @param obj the object to compare with.
	 * @return <code>true</code> if the objects are the same;
	 *         <code>false</code> otherwise.
	 */
	@Override
	public boolean equals(final Object obj)
	{
		try
		{
			final HybrisEnumValue enum2 = (HybrisEnumValue) obj;
			return this == enum2
			|| (enum2 != null && !this.getClass().isEnum() && !enum2.getClass().isEnum()
			&& this.getType().equalsIgnoreCase(enum2.getType()) && this.getCode().equalsIgnoreCase(enum2.getCode()));
		}
		catch (final ClassCastException e)
		{
			return false;
		}
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
	
	/**
	 * Returns a hash code for this <code>B2BGroupEnum</code>.
	 *  
	 * @return a hash code value for this object, equal to the enum value <code>code</code>
	 *         represented by this <code>B2BGroupEnum</code> object.
	 */
	@Override
	public int hashCode()
	{
		return this.codeLowerCase.hashCode();
	}
	
	/**
	 * Returns the code representing this enum value.
	 *  
	 * @return a string representation of the value of this object.
	 */
	@Override
	public String toString()
	{
		return this.code.toString();
	}
	
	/**
	 * Returns a <tt>B2BGroupEnum</tt> instance representing the specified enum value.
	 *  
	 * @param code an enum value
	 * @return a <tt>B2BGroupEnum</tt> instance representing <tt>value</tt>. 
	 */
	public static B2BGroupEnum valueOf(final String code)
	{
		final String key = code.toLowerCase();
		B2BGroupEnum result = cache.get(key);
		if (result == null)
		{
			B2BGroupEnum newValue = new B2BGroupEnum(code);
			B2BGroupEnum previous = cache.putIfAbsent(key, newValue);
			result = previous != null ? previous : newValue;
		}
		return result;
	}
	
	private Object writeReplace()
	{
		return new de.hybris.bootstrap.typesystem.HybrisDynamicEnumValueSerializedForm(this.getClass(), getCode());
	}
	
}
