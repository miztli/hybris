/*
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.basecommerce.enums;

import de.hybris.platform.core.HybrisEnumValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Generated enum StockLevelUpdateType declared at extension basecommerce.
 */
@SuppressWarnings("PMD")
public class StockLevelUpdateType implements HybrisEnumValue
{
	/**<i>Generated model type code constant.</i>*/
	public final static String _TYPECODE = "StockLevelUpdateType";
	
	/**<i>Generated simple class name constant.</i>*/
	public final static String SIMPLE_CLASSNAME = "StockLevelUpdateType";
	private static final ConcurrentMap<String, StockLevelUpdateType> cache = new ConcurrentHashMap<String, StockLevelUpdateType>();
	/**
	* Generated enum value for StockLevelUpdateType.warehouse declared at extension basecommerce.
	*/
	public static final StockLevelUpdateType WAREHOUSE = valueOf("warehouse");
	
	/**
	* Generated enum value for StockLevelUpdateType.customer_reserve declared at extension basecommerce.
	*/
	public static final StockLevelUpdateType CUSTOMER_RESERVE = valueOf("customer_reserve");
	
	/**
	* Generated enum value for StockLevelUpdateType.customer_release declared at extension basecommerce.
	*/
	public static final StockLevelUpdateType CUSTOMER_RELEASE = valueOf("customer_release");
	
	
	/** The code of this enum.*/
	private final String code;
	private final String codeLowerCase;
	private static final long serialVersionUID = 0L;
	
	/**
	 * Creates a new enum value for this enum type.
	 *  
	 * @param code the enum value code
	 */
	private StockLevelUpdateType(final String code)
	{
		this.code = code.intern();
		this.codeLowerCase = this.code.toLowerCase().intern();
	}
	
	
	/**
	 * Compares this object to the specified object. The result is <code>true</code>
	 * if and only if the argument is not <code>null</code> and is an <code>StockLevelUpdateType
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
	 * Returns a hash code for this <code>StockLevelUpdateType</code>.
	 *  
	 * @return a hash code value for this object, equal to the enum value <code>code</code>
	 *         represented by this <code>StockLevelUpdateType</code> object.
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
	 * Returns a <tt>StockLevelUpdateType</tt> instance representing the specified enum value.
	 *  
	 * @param code an enum value
	 * @return a <tt>StockLevelUpdateType</tt> instance representing <tt>value</tt>. 
	 */
	public static StockLevelUpdateType valueOf(final String code)
	{
		final String key = code.toLowerCase();
		StockLevelUpdateType result = cache.get(key);
		if (result == null)
		{
			StockLevelUpdateType newValue = new StockLevelUpdateType(code);
			StockLevelUpdateType previous = cache.putIfAbsent(key, newValue);
			result = previous != null ? previous : newValue;
		}
		return result;
	}
	
	private Object writeReplace()
	{
		return new de.hybris.bootstrap.typesystem.HybrisDynamicEnumValueSerializedForm(this.getClass(), getCode());
	}
	
}
