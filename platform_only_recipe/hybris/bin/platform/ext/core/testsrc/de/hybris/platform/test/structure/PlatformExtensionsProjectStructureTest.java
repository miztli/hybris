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
package de.hybris.platform.test.structure;


import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.bootstrap.config.ConfigUtil;

import org.apache.log4j.Logger;


@IntegrationTest
public class PlatformExtensionsProjectStructureTest extends AbstractProjectStructureTest
{

	static final Logger log = Logger.getLogger(PlatformExtensionsProjectStructureTest.class.getName());

	public PlatformExtensionsProjectStructureTest()
	{
		super(ConfigUtil.getPlatformConfig(PlatformExtensionsProjectStructureTest.class).getAllPlatformExtensionNames()
				.toArray(new String[0]));
	}
}

