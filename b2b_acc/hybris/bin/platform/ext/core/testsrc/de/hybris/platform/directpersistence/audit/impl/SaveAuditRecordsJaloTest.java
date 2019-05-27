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
package de.hybris.platform.directpersistence.audit.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.util.persistence.PersistenceUtils;

import org.junit.Before;


@IntegrationTest
public class SaveAuditRecordsJaloTest extends SaveAuditRecordsTest
{


	@Before
	@Override
	public void setUp() throws Exception
	{
		super.setUp();
		switchPersistenceLegacyMode(true);
		assertThat(PersistenceUtils.isPersistenceLegacyModeEnabled()).isTrue();
	}


}
