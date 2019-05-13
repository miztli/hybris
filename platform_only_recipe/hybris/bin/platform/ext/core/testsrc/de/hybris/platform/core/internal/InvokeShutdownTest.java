/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.platform.core.internal;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import de.hybris.platform.shutdown.InvokeShutdown;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@IntegrationTest
public class InvokeShutdownTest
{
	private Path token;

	@Before
	public void setup() throws IOException
	{
		token = File.createTempFile("shutdown", "token").toPath();
	}

	@After
	public void cleanup()
	{
		if (token != null)
		{
			token.toFile().delete();
		}
	}

	@Test
	public void shouldReadTokenFile() throws IOException
	{
		final String tokenContent = "https://localhost:9002/monitoring/suspendresume/halt;foo";

		Files.write(token, tokenContent.getBytes(StandardCharsets.UTF_8));

		final String[] tokenParts = InvokeShutdown.readTokenFile(token);

		assertThat(tokenParts).hasSize(2);
		assertThat(tokenParts[0]).isEqualTo("https://localhost:9002/monitoring/suspendresume/halt");
		assertThat(tokenParts[1]).isEqualTo("foo");
	}

	@Test
	public void shouldBuildPostData()
	{
		final byte[] postData = InvokeShutdown.buildPostData("foo");
		final String postDataContent = new String(postData, StandardCharsets.UTF_8);

		assertThat(postDataContent).isEqualTo("suspendToken=foo&forShutdown=true");
	}
}
