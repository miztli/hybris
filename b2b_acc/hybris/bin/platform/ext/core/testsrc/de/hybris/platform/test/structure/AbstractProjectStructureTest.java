/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.test.structure;
import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.config.ConfigUtil;
import de.hybris.bootstrap.config.ExtensionInfo;
import de.hybris.bootstrap.config.PlatformConfig;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.fest.assertions.BasicDescription;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public abstract class AbstractProjectStructureTest extends ServicelayerBaseTest
{
	private final String[] extensionName;
	private final boolean includeWebJars;

	List<Pair<String, String>> duplicateJarPairsToIgnore = new ArrayList<>();



	public AbstractProjectStructureTest(final String... extensionName)
	{
		this(false, extensionName);
	}

	public AbstractProjectStructureTest(final boolean includeWebJars, final String... extensionName)
	{
		this.includeWebJars = includeWebJars;
		this.extensionName = extensionName;
	}

	@Before
	public void setUp()
	{
		final Map<String, String> ingoreJars = Registry.getCurrentTenantNoFallback().getConfig()
				.getParametersMatching("duplicatejarchecker\\.ignore\\.(.*)", true);
		final Set<String> jarPairs = ingoreJars.keySet();

		duplicateJarPairsToIgnore = ingoreJars.keySet().stream()//
				.map(s -> s.split("_____")) //
				.filter(a -> a.length == 2) //
				.map(a -> new ImmutablePair<>((String) a[0], (String) a[1])) //
				.collect(Collectors.toList());
	}

	private List<Path> getJarsInExtensions(final List<ExtensionInfo> extensionsInfo, final boolean excludeWeb)
	{
		return extensionsInfo.stream().map(ei -> getJarsInExtension(ei, excludeWeb)).flatMap(List::stream)
				.collect(Collectors.toList());
	}

	private List<Path> getJarsInExtension(final ExtensionInfo extensionInfo, final boolean excludeWeb)
	{
		if (extensionInfo.getExtensionDirectory() != null) {

			final Path extensionPath = extensionInfo.getExtensionDirectory().toPath();
			try (Stream<Path> paths = Files.walk(extensionPath)) {
				return buildJarStream(paths, excludeWeb).collect(Collectors.toList());
			} catch (final IOException e) {
				return Collections.emptyList();
			}
		}
		return Collections.emptyList();
	}

	private Stream<Path> buildJarStream(final Stream<Path> stream, final boolean excludeWeb)
	{
		Stream<Path> result = stream;

		result = result.filter(Files::isRegularFile) //
				.filter(p -> p.toAbsolutePath().toString().contains("lib"));
		if (excludeWeb)
		{
			result = result.filter(this::isInWebInf);
		}
		result = result.filter(this::isNotPlatformSpecificLib) //
				.filter(this::isNotSolarserverExtLib) //
				.filter(p -> p.getFileName().toString().endsWith(".jar"));

		return result;
	}



	private boolean isInWebInf(final Path p)
	{
		final String webInfPath = Paths.get("webroot", "WEB-INF", "lib").toString();
		final String absolutePath = p.toAbsolutePath().toString();
		return !absolutePath.contains(webInfPath);
	}

	private boolean isNotPlatformSpecificLib(final Path p)
	{
		final String resources = Paths.get("platform", "resources").toString();
		final String ant = Paths.get("platform", "apache-ant").toString();

		final String absolutePath = p.toAbsolutePath().toString();

		return !(absolutePath.contains(resources) || absolutePath.contains(ant));
	}

	private boolean isNotSolarserverExtLib(final Path p)
	{
		final String solrfolder = Paths.get("solrserver", "resources", "solr").toString();

		final String absolutePath = p.toAbsolutePath().toString();

		return !(absolutePath.contains(solrfolder));
	}


	private String getParsedFilename(final Pattern p, final String fileName)
	{
		final Matcher m = p.matcher(fileName);
		if (m.find())
		{
			return fileName.substring(0, m.start());
		}
		else
		{
			return fileName;
		}
	}

	private List<Pair<String, String>> getListOfConfilcts(final List<Path> baseJars, final List<Path> allJars)
	{
		final List<Pair<String, String>> listOfConflicts = new ArrayList<>();
		final Pattern p = Pattern.compile("-(\\d*[^a-zA-Z])+");

		for (final Path baseJar : baseJars)
		{
			for (final Path jar : allJars)
			{
				final String baseJarFilename = baseJar.getFileName().toString();
				final String jarFilename = jar.getFileName().toString();

				final String parsedBaseName = getParsedFilename(p, baseJarFilename);
				final String parsedName = getParsedFilename(p, jarFilename);

				if (parsedBaseName.equals(parsedName))
				{
					final Pair<String, String> conflict = new ImmutablePair<>(baseJar.toString(), jar.toString());
					listOfConflicts.add(conflict);
				}

			}
		}

		return listOfConflicts;
	}

	@Test
	public void testDuplicateJarFiles() throws IOException, NoSuchAlgorithmException
	{
		final PlatformConfig platformConfig = ConfigUtil.getPlatformConfig(this.getClass());

		final List<ExtensionInfo> allExtensionsInfo = new ArrayList<>(platformConfig.getExtensionInfosInBuildOrder());

		final List<ExtensionInfo> thisExtensions = Arrays.stream(extensionName) //
				.map(platformConfig::getExtensionInfo) //
				.collect(Collectors.toList());
		allExtensionsInfo.removeAll(thisExtensions);

		final List<Path> thisJars = getJarsInExtensions(thisExtensions, true);
		final List<Path> allJars = getJarsInExtensions(allExtensionsInfo, true);

		final List<Pair<String, String>> listOfConflicts = findCopies(thisJars, allJars);

		assertThat(listOfConflicts).hasSize(0).as(new BasicDescription("Can be overridden in project.properties"));
	}

	@Test
	public void testDuplicateJarFilesInWeb() throws IOException, NoSuchAlgorithmException
	{
		org.junit.Assume.assumeTrue(includeWebJars);

		final PlatformConfig platformConfig = ConfigUtil.getPlatformConfig(this.getClass());

		final List<ExtensionInfo> allExtensionsInfo = new ArrayList<>(platformConfig.getExtensionInfosInBuildOrder());

		final List<ExtensionInfo> thisExtensions = Arrays.stream(extensionName) //
				.map(platformConfig::getExtensionInfo) //
				.collect(Collectors.toList());
		allExtensionsInfo.removeAll(thisExtensions);

		final List<Path> thisJars = getJarsInExtensions(thisExtensions, true);
		final List<Path> allJars = getJarsInExtensions(allExtensionsInfo, false);

		final List<Pair<String, String>> listOfConflicts = findCopies(thisJars, allJars);

		assertThat(listOfConflicts).hasSize(0).as(new BasicDescription("Can be overridden in project.properties"));

	}

	private List<Pair<String, String>> findCopies(final List<Path> thisJars, final List<Path> allJars)
	{
		final List<Pair<String, String>> listOfConflicts = getListOfConfilcts(thisJars, allJars);
		final List<Pair<String, String>> copyOfListConflicts = new ArrayList<>(listOfConflicts);

		for (final Pair<String, String> duplicatePairFound : listOfConflicts)
		{
			final String found1 = duplicatePairFound.getLeft();
			final String found2 = duplicatePairFound.getRight();

			for (final Pair<String, String> duplicateToIgnore : duplicateJarPairsToIgnore)
			{
				final String pathToIgnore1 = FilenameUtils.separatorsToSystem(duplicateToIgnore.getLeft());
				final String pathToIgnore2 = FilenameUtils.separatorsToSystem(duplicateToIgnore.getRight());

				if ((found1.contains(pathToIgnore1) && found2.contains(pathToIgnore2))
						|| found1.contains(pathToIgnore2) && found2.contains(pathToIgnore1))

				{
					copyOfListConflicts.remove(duplicatePairFound);
				}

			}
		}
		return copyOfListConflicts;
	}
}
