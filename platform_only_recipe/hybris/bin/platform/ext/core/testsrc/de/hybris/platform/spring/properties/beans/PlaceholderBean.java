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
package de.hybris.platform.spring.properties.beans;

/**
 *
 */
public class PlaceholderBean
{
	private String value;

	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}
