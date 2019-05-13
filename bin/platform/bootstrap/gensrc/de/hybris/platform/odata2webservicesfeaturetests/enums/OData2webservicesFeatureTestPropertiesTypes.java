/*
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.odata2webservicesfeaturetests.enums;

import de.hybris.platform.core.HybrisEnumValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Generated enum OData2webservicesFeatureTestPropertiesTypes declared at extension odata2webservicesfeaturetests.
 */
@SuppressWarnings("PMD")
public class OData2webservicesFeatureTestPropertiesTypes implements HybrisEnumValue
{
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "OData2webservicesFeatureTestPropertiesTypes";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "OData2webservicesFeatureTestPropertiesTypes";
	private static final ConcurrentMap<String, OData2webservicesFeatureTestPropertiesTypes> cache = new ConcurrentHashMap<String, OData2webservicesFeatureTestPropertiesTypes>();
	/**
	* Generated enum value for OData2webservicesFeatureTestPropertiesTypes.string declared at extension odata2webservicesfeaturetests.
	*/
	public static final OData2webservicesFeatureTestPropertiesTypes STRING = valueOf("string");
	
	
	/** The code of this enum.*/
	private final String code;
	private final String codeLowerCase;
	private static final long serialVersionUID = 0L;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private OData2webservicesFeatureTestPropertiesTypes(final String code)
	{
		this.code = code.intern();
		this.codeLowerCase = this.code.toLowerCase().intern();
	}
	
	
	/**
	 * Compares this object to the specified object. The result is <code>true</code>
	 * if and only if the argument is not <code>null</code> and is an <code>OData2webservicesFeatureTestPropertiesTypes
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
	 * Returns a hash code for this <code>OData2webservicesFeatureTestPropertiesTypes</code>.
	 *  
	 * @return a hash code value for this object, equal to the enum value <code>code</code>
	 *         represented by this <code>OData2webservicesFeatureTestPropertiesTypes</code> object.
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
	 * Returns a <tt>OData2webservicesFeatureTestPropertiesTypes</tt> instance representing the specified enum value.
	 *  
	 * @param code an enum value
	 * @return a <tt>OData2webservicesFeatureTestPropertiesTypes</tt> instance representing <tt>value</tt>. 
	 */
	public static OData2webservicesFeatureTestPropertiesTypes valueOf(final String code)
	{
		final String key = code.toLowerCase();
		OData2webservicesFeatureTestPropertiesTypes result = cache.get(key);
		if (result == null)
		{
			OData2webservicesFeatureTestPropertiesTypes newValue = new OData2webservicesFeatureTestPropertiesTypes(code);
			OData2webservicesFeatureTestPropertiesTypes previous = cache.putIfAbsent(key, newValue);
			result = previous != null ? previous : newValue;
		}
		return result;
	}
	
	private Object writeReplace()
	{
		return new de.hybris.bootstrap.typesystem.HybrisDynamicEnumValueSerializedForm(this.getClass(), getCode());
	}
	
}
