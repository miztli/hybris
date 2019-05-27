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
package de.hybris.platform.servicelayer.web.session;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import de.hybris.platform.testframework.HybrisJUnit4TransactionalTest;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;


public class PersistedSessionTest extends HybrisJUnit4TransactionalTest
{
	@Test
	public void testCreatePersistedSession()
	{
		//https://jira.hybris.com/browse/ECP-2554
		final PersistedSession persistedSession = new PersistedSession("test", 99, "test", "testContext");
		persistedSession.setAttribute("dummy", null);
		persistedSession.setAttribute("dummy2", "testValue");
		final byte[] b = SerializationUtils.serialize(persistedSession);

		final PersistedSession s = SerializationUtils.deserialize(b);
		assertNull(s.getAttribute("dummy"));
		assertEquals(s.getAttribute("dummy2"), "testValue");
	}

}
