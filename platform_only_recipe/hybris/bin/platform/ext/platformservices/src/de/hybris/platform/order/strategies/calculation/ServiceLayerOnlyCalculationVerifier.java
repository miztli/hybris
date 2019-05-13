/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.order.strategies.calculation;

/**
 * An interface for marking service layer only calculation strategies.
 */
public interface ServiceLayerOnlyCalculationVerifier
{

	/**
	 * Implement this and return true if you are using only service-layer models
	 *
	 * @return true, if only service-layer models are used
	 */
	default boolean isSLOnly()
	{
		return false;
	}
}
