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
package de.hybris.platform.servicelayer;

import de.hybris.platform.testframework.Transactional;

import org.junit.Ignore;


/**
 * Service layer test with possibility to create sample data. All tests will be executed within transactions.
 */
@Transactional
public class ExtendedServicelayerTransactionalBaseTest extends ExtendedServicelayerBaseTest
{
	// nothing here
}
