package de.hybris.platform.util.config;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.BDDMockito.given;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.exceptions.SystemException;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
@UnitTest
public class RuntimeConfigUpdateListenerTest
{
	@Mock
	private ConfigIntf config;

	@Test
	public void shouldNotInstantiateConfigLoaderClassWhenItsConfiguredAsEmptyString()
	{
		// given
		given(config.getParameter(RuntimeConfigUpdateListener.RUNTIME_CONFIG_LOADER_CLASS)).willReturn(StringUtils.EMPTY);

		// when
		final RuntimeConfigLoader configLoader = RuntimeConfigUpdateListener.getConfigLoader(config);

		// then
		assertThat(configLoader).isNull();
	}

	@Test
	public void shouldNotInstantiateConfigLoaderClassWhenItsConfiguredAsBlankString()
	{
		// given
		given(config.getParameter(RuntimeConfigUpdateListener.RUNTIME_CONFIG_LOADER_CLASS)).willReturn("  ");

		// when
		final RuntimeConfigLoader configLoader = RuntimeConfigUpdateListener.getConfigLoader(config);

		// then
		assertThat(configLoader).isNull();
	}

	@Test
	public void shouldNotInstantiateConfigLoaderClassWhenConfigObjectReturnsNull()
	{
		// given
		given(config.getParameter(RuntimeConfigUpdateListener.RUNTIME_CONFIG_LOADER_CLASS)).willReturn(null);

		// when
		final RuntimeConfigLoader configLoader = RuntimeConfigUpdateListener.getConfigLoader(config);

		// then
		assertThat(configLoader).isNull();
	}

	@Test
	public void shouldThrowTheSystemExceptionWhenConfiguredConfigLoaderClassDoesntExist()
	{
		// given
		given(config.getParameter(RuntimeConfigUpdateListener.RUNTIME_CONFIG_LOADER_CLASS))
				.willReturn("org.non.existent.LoaderClass");

		try
		{
			// when
			RuntimeConfigUpdateListener.getConfigLoader(config);
			fail("Should throw SystemException");
		}
		catch (final SystemException e)
		{
			// then fine
		}
	}
	
	@Test
	public void shouldInstantiateProperConfigLoaderClass()
	{
		// given
        given(config.getParameter(RuntimeConfigUpdateListener.RUNTIME_CONFIG_LOADER_CLASS))
                .willReturn("de.hybris.platform.util.config.FileBasedConfigLoader");

		// when
        final RuntimeConfigLoader configLoader = RuntimeConfigUpdateListener.getConfigLoader(config);

        // then
        assertThat(configLoader).isNotNull();
        assertThat(configLoader).isInstanceOf(FileBasedConfigLoader.class);
	}

}