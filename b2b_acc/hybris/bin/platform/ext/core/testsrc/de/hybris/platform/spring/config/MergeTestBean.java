/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.spring.config;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * Class for testing list merge directive and map merge directive
 */
public class MergeTestBean
{
	private List<String> stringList;
	private List<Object> objectList;
	private List<BigDecimal> decimalList;


	private Map<String, String> stringMap;
	private Map<String, Collection<String>> multiMap;

	public MergeTestBean()
	{

	}

	public List<String> getStringList()
	{
		return stringList;
	}

	public void setStringList(final List<String> stringList)
	{
		this.stringList = stringList;
	}

	public List<Object> getObjectList()
	{
		return objectList;
	}

	public void setObjectList(final List<Object> objectList)
	{
		this.objectList = objectList;
	}

	public void setDecimalList(final List<BigDecimal> decimalList)
	{
		this.decimalList = decimalList;
	}

	public List<BigDecimal> getDecimalList()
	{
		return decimalList;
	}

	public Map<String, String> getStringMap()
	{
		return stringMap;
	}

	public void setStringMap(final Map<String, String> stringMap)
	{
		this.stringMap = stringMap;
	}

	public Map<String, Collection<String>> getMultiMap()
	{
		return multiMap;
	}

	public void setMultiMap(final Map<String, Collection<String>> multiMap)
	{
		this.multiMap = multiMap;
	}

}
