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
package de.hybris.platform.servicelayer.session;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.session.impl.DefaultSessionTokenService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@UnitTest
public class DefaultSessionTokenServiceTest
{
	private DefaultSessionTokenService sessionTokenService;

	@Before
	public void setup()
	{
		sessionTokenService = new DefaultSessionTokenService();
		sessionTokenService.setSessionService(new MockSessionService());
	}

	@Test
	public void testCreateToken()
	{
		//when
		final String token = sessionTokenService.getOrCreateSessionToken();

		//then
		Assert.assertNotNull("Got null as token", token);
		Assert.assertTrue("Got empty token", token.length() > 0);
	}

	@Test
	public void testSetToken()
	{
		//given
		final String expectedToken = "1234567890";

		sessionTokenService.setSessionToken(expectedToken);

		//when
		final String token = sessionTokenService.getOrCreateSessionToken();

		//then
		Assert.assertEquals("Returned token is different than set token", expectedToken, token);
	}

}
