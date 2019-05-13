/*
 *  [y] hybris Platform
 *
 *  Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 *  This software is the confidential and proprietary information of SAP
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with SAP.
 */

package de.hybris.platform.servicelayer.web;

import static de.hybris.platform.servicelayer.web.ResourcesGuardServiceTest.TestResourcesGuardServiceBuilder.havingConfigForExtension;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


@UnitTest
public class ResourcesGuardServiceTest
{

	@Test
	public void shouldHavePathEnabledByDefaultIfItIsNotConfiguredAtAll()
	{
		// given
		final String extName = "hac";
		final String resourcePath = "/not/configured";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.getService();

		// when
		final boolean resourceEnabled = service.isResourceEnabled(extName, resourcePath);

		// then
		assertThat(resourceEnabled).isTrue();
	}

	@Test
	public void shouldHavePathEnabledIfItIsConfiguredToBeEnabled()
	{
		// given
		final String extName = "hac";
		final String resourcePath = "/platform/init";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withResourceEnabled(resourcePath) //
				.getService();

		// when
		final boolean resourceEnabled = service.isResourceEnabled(extName, resourcePath);

		// then
		assertThat(resourceEnabled).isTrue();
	}

	@Test
	public void shouldHavePathEnabledIfItIsConfiguredToBeEnabled_CheckWithParams()
	{
		// given
		final String extName = "hac";
		final String resourcePath = "/platform/init";
		final String params = "?someParam=foo";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withResourceDisabled(resourcePath) //
				.getService();

		// when
		final boolean resourceEnabled = service.isResourceDisabled(extName, resourcePath + params);

		// then
		assertThat(resourceEnabled).isTrue();
	}

	@Test
	public void shouldHavePathEnabledIfItIsConfiguredToBeEnabled_CheckWithAnchor()
	{
		// given
		final String extName = "hac";
		final String resourcePath = "/platform/init";
		final String params = "#someAnchor";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withResourceDisabled(resourcePath) //
				.getService();

		// when
		final boolean resourceEnabled = service.isResourceDisabled(extName, resourcePath + params);

		// then
		assertThat(resourceEnabled).isTrue();
	}

	@Test
	public void shouldHaveAllPathsDisabledWithParentIsConfiguredToBeDisabled()
	{
		// given
		final String extName = "hac";
		final String resourcePath1 = "/platform/init";
		final String resourcePath2 = "/platform/init/foo";
		final String resourcePath3 = "/platform/init/foo/bar";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withResourceEnabled(resourcePath2) //
				.withResourceDisabled(resourcePath3) //
				.withResourceDisabled(resourcePath1) //
				.getService();

		// when
		final boolean resource1Enabled = service.isResourceEnabled(extName, resourcePath1);
		final boolean resource2Enabled = service.isResourceEnabled(extName, resourcePath2);
		final boolean resource3Enabled = service.isResourceEnabled(extName, resourcePath3);

		// then
		assertThat(resource1Enabled).isFalse();
		assertThat(resource2Enabled).isFalse();
		assertThat(resource3Enabled).isFalse();
	}

	@Test
	public void shouldHavePathDisabledIfItIsConfiguredToBeDisabled()
	{
		// given
		final String extName = "hac";
		final String resourcePath = "/platform/init";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withResourceDisabled(resourcePath) //
				.getService();

		// when
		final boolean resourceDisabled = service.isResourceDisabled(extName, resourcePath);

		// then
		assertThat(resourceDisabled).isTrue();
	}

	@Test
	public void shouldHaveSubPathDisabledIfTheParentPathIsConfiguredToBeDisabled()
	{
		// given
		final String extName = "hac";
		final String resourcePath = "/platform/init";
		final String resourceSubPath = "/platform/init/engine";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withResourceDisabled(resourcePath) //
				.withResourceEnabled(resourceSubPath) //
				.getService();

		// when
		final boolean resourceDisabled = service.isResourceDisabled(extName, resourcePath);
		final boolean subResourceDisabled = service.isResourceDisabled(extName, resourceSubPath);

		// then
		assertThat(resourceDisabled).isTrue();
		assertThat(subResourceDisabled).isTrue();
	}

	@Test
	public void shouldHaveAnyResourcesDisabledWhenWholeExtensionIsConfiguredToBeDisabled()
	{
		// given
		final String extName = "hac";
		final String resourcePath1 = "/platform/init";
		final String resourcePath2 = "/foobar/baz";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withWholeExtensionDisabled() //
				.getService();

		// when
		final boolean resource1Disabled = service.isResourceDisabled(extName, resourcePath1);
		final boolean resource2Disabled = service.isResourceDisabled(extName, resourcePath2);

		// then
		assertThat(resource1Disabled).isTrue();
		assertThat(resource2Disabled).isTrue();
	}

	@Test
	public void shouldHaveAnyResourcesDisabledWhenWholeExtensionIsConfiguredToBeDisabledEvenSomeResourcesAreConfiguredToBeEnabled()
	{
		// given
		final String extName = "hac";
		final String resourcePath1 = "/platform/init";
		final String resourcePath2 = "/foobar/baz";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withWholeExtensionDisabled() //
				.withResourceEnabled(resourcePath1) //
				.withResourceEnabled(resourcePath2) //
				.getService();

		// when
		final boolean resource1Disabled = service.isResourceDisabled(extName, resourcePath1);
		final boolean resource2Disabled = service.isResourceDisabled(extName, resourcePath2);

		// then
		assertThat(resource1Disabled).isTrue();
		assertThat(resource2Disabled).isTrue();
	}

	@Test
	public void shouldHaveAnyResourcesEnabledWhenWholeExtensionIsConfiguredToBeEnabledEvenSomeResourcesAreConfiguredToBeDisabled()
	{
		// given
		final String extName = "hac";
		final String resourcePath1 = "/platform/init";
		final String resourcePath2 = "/foobar/baz";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withWholeExtensionEnabled() //
				.withResourceDisabled(resourcePath1) //
				.withResourceDisabled(resourcePath2) //
				.getService();

		// when
		final boolean resource1Disabled = service.isResourceDisabled(extName, resourcePath1);
		final boolean resource2Disabled = service.isResourceDisabled(extName, resourcePath2);

		// then
		assertThat(resource1Disabled).isFalse();
		assertThat(resource2Disabled).isFalse();
	}
	
	@Test
	public void shouldHaveResourceEnabledEvenParentIsDisabledWhenConfiguredToNotRespectParentSettings()
	{
		// given
		final String extName = "hac";
		final String resourcePath1 = "/platform";
		final String resourcePath2 = "/platform/foo";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withResourceDisabled(resourcePath1) //
				.withResourceEnabled(resourcePath2) //
				.withNotRespectParentSettings()
				.getService();

		// when
		final boolean resource1Disabled = service.isResourceDisabled(extName, resourcePath1);
		final boolean resource2Disabled = service.isResourceDisabled(extName, resourcePath2);

		// then
		assertThat(resource1Disabled).isTrue();
		assertThat(resource2Disabled).isFalse();
	}

	@Test
	public void shouldHaveResourceDisabledIfItIsNotConfiguredAndItsParentIsDisabledRegardlessOfParentsRespectingConfiguration()
	{
		// given
		final String extName = "hac";
		final String resourcePath1 = "/platform";
		final String resourcePath2 = "/platform/foo";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withResourceDisabled(resourcePath1) //
				.withNotRespectParentSettings()
				.getService();

		// when
		final boolean resource1Disabled = service.isResourceDisabled(extName, resourcePath1);
		final boolean resource2Disabled = service.isResourceDisabled(extName, resourcePath2);

		// then
		assertThat(resource1Disabled).isTrue();
		assertThat(resource2Disabled).isTrue();
	}

	@Test
	public void shouldHavePathDisabledIfUrlEndsWithSlashes()
	{
		// given
		final String extName = "hac";
		final String resourcePath = "/platform/init";
		final String url = "/platform/init///";
		final ResourcesGuardService service = havingConfigForExtension(extName) //
				.withResourceDisabled(resourcePath) //
				.getService();

		// when
		final boolean resourceDisabled = service.isResourceDisabled(extName, url);

		// then
		assertThat(resourceDisabled).isTrue();
	}

	static class TestResourcesGuardServiceBuilder
	{
		private boolean respectParentSettings = true;
		private final String extName;
		private final Map<String, String> config = new HashMap<>();

		public TestResourcesGuardServiceBuilder(final String extName)
		{
			this.extName = extName;
		}

		public static TestResourcesGuardServiceBuilder havingConfigForExtension(final String extName)
		{
			return new TestResourcesGuardServiceBuilder(extName);
		}

		public TestResourcesGuardServiceBuilder withNotRespectParentSettings()
		{
			respectParentSettings = false;
			return this;
		}

		public TestResourcesGuardServiceBuilder withWholeExtensionDisabled()
		{
			config.put(extName, "true");
			return this;
		}

		public TestResourcesGuardServiceBuilder withWholeExtensionEnabled()
		{
			config.put(extName, "false");
			return this;
		}

		public TestResourcesGuardServiceBuilder withResourceEnabled(final String resource)
		{
			config.put(convertPathToProperty(resource), "false");
			return this;
		}

		public TestResourcesGuardServiceBuilder withResourceDisabled(final String resource)
		{
			config.put(convertPathToProperty(resource), "true");
			return this;
		}

		private String convertPathToProperty(final String resource)
		{
			return extName + resource.replace('/', '.');
		}

		public ResourcesGuardService getService()
		{
			return new ResourcesGuardService(config, respectParentSettings);
		}
	}

}
