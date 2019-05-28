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
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at May 28, 2019 3:18:55 PM
 * ----------------------------------------------------------------
 */
package de.hybris.platform.cms2.namedquery;

import de.hybris.platform.cms2.enums.SortDirection;

public class Sort {

	/** <i>Generated property</i> for <code>Sort.parameter</code> property defined at extension <code>cms2</code>. */
	private String parameter;
	/** <i>Generated property</i> for <code>Sort.direction</code> property defined at extension <code>cms2</code>. */
	private SortDirection direction;


		public void setParameter(final String parameter)
	{
		this.parameter = parameter;
	}

	public Sort withParameter(final String parameter)
	{
		this.parameter = parameter;
		return this;
	}

			
	public String getParameter() 
	{
		return parameter;
	}

	
		public void setDirection(final SortDirection direction)
	{
		this.direction = direction;
	}

	public Sort withDirection(final SortDirection direction)
	{
		this.direction = direction;
		return this;
	}

			
	public SortDirection getDirection() 
	{
		return direction;
	}

	}
