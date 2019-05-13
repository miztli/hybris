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
package de.hybris.platform.converters.data;


public class TestProductData implements java.io.Serializable
{

	private String code;
	private String description;
	private String name;

	public TestProductData()
	{
		// default constructor
	}


	public void setCode(final String code)
	{
		this.code = code;
	}


	public String getCode()
	{
		return code;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}


	public String getDescription()
	{
		return description;
	}

	public void setName(final String name)
	{
		this.name = name;
	}


	public String getName()
	{
		return name;
	}

}
