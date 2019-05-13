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
package de.hybris.platform.util.config;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class FileBasedConfigLoaderTest
{
	private FileBasedConfigLoader loader;
	private Path testFile;

	@Before
	public void setUp() throws Exception
	{
		testFile = Files.createTempFile("loaderTest", null);
		loader = new TestFileBasedConfigLoader(testFile);
	}

	@After
	public void tearDown() throws Exception
	{
		Files.deleteIfExists(testFile);
	}

	@Test
	public void shouldReturnEmptyPropertiesIfFileWasNeverLoadedBeforeAndHasEmptyContent()
	{
		// when
		final Optional<Properties> result = loader.load();

		// then
		assertThat(result).isPresent();
		assertThat(result.get()).isEmpty();
	}

	@Test
	public void shouldNotReturnPropertiesIfFileWasLoadedBeforeAndNothingHasChangedSinceThen()
	{
		// given
		loader.load();

		// when
		final Optional<Properties> result = loader.load();

		// then
		assertThat(result).isNotPresent();
	}

	@Test
	public void shouldNotReturnPropertiesIfFileWithContentWasLoadedBeforeAndNothingHasChangedSinceThen() throws Exception
	{
		// given
		writeProperties("foo=bar");
		loader.load();

		// when
		final Optional<Properties> result = loader.load();

		// then
		assertThat(result).isNotPresent();
	}

	@Test
	public void shouldReturnPropertiesIfItHasContentAndWasNeverLoadedBefore() throws Exception
	{
		// given
		writeProperties("foo=bar");

		// when
		final Optional<Properties> result = loader.load();

		// then
		assertThat(result).isPresent();
		assertThat(result.get()).hasSize(1);
		assertThat(result.get().getProperty("foo")).isEqualTo("bar");
	}

	@Test
	public void shouldReturnPropertiesAfterModificationOfFileContent() throws Exception
	{
		// given
		writeProperties("foo=bar\n");

		// when
		final Optional<Properties> result = loader.load();

		// then
		assertThat(result).isPresent();
		assertThat(result.get()).hasSize(1);
		assertThat(result.get().getProperty("foo")).isEqualTo("bar");

		// given (again)
		Thread.sleep(3000);
		writeProperties("baz=boom\n");

		// when (again)
		final Optional<Properties> result2 = loader.load();

		// then (again)
		assertThat(result2).isPresent();
		assertThat(result2.get()).hasSize(2);
		assertThat(result2.get().getProperty("foo")).isEqualTo("bar");
		assertThat(result2.get().getProperty("baz")).isEqualTo("boom");
	}

	@Test
	public void shouldDetectDeletePropertyValue() throws Exception
	{
        // given
        writeProperties("foo=bar\n");

        // when
        final Optional<Properties> result = loader.load();

        // then
        assertThat(result).isPresent();
        assertThat(result.get()).hasSize(1);
        assertThat(result.get().getProperty("foo")).isEqualTo("bar");

        // given (again)
        Thread.sleep(3000);
        replaceProperties("foo=\n");

        // when (again)
        final Optional<Properties> result2 = loader.load();

        // then (again)
        assertThat(result2).isPresent();
        assertThat(result2.get()).hasSize(1);
        assertThat(result2.get().getProperty("foo")).isEmpty();
	}

	@Test
	public void shouldReturnEmptyPropertiesIfFileDoesntExist()
	{
		// given
		final TestFileBasedConfigLoader loader = new TestFileBasedConfigLoader(Paths.get("/non/existent/file"));

		// when
		final Optional<Properties> result = loader.load();

		// then
		assertThat(result).isNotPresent();
	}

	private void writeProperties(final String props) throws IOException
	{
		Files.write(testFile, props.getBytes(), APPEND);
	}

	private void replaceProperties(final String props) throws IOException
    {
        Files.write(testFile, props.getBytes(), TRUNCATE_EXISTING);
    }

	private static class TestFileBasedConfigLoader extends FileBasedConfigLoader
	{
		private final Path configFilePath;

		private TestFileBasedConfigLoader(final Path configFilePath)
		{
			this.configFilePath = configFilePath;
		}

		@Override
		Path getConfigFilePath()
		{
			return configFilePath;
		}
	}

}