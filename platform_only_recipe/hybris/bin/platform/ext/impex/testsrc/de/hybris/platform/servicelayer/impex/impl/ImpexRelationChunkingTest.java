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

package de.hybris.platform.servicelayer.impex.impl;

import static de.hybris.platform.impex.constants.ImpExConstants.Params.QUERY_CHUNK_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.classification.ClassificationAttributeModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemVersionModel;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.impex.ImpExResource;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.testframework.TestUtils;
import de.hybris.platform.util.Config;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class ImpexRelationChunkingTest extends ServicelayerTest
{
	private static final String CLASSIFICATION_SYSTEM = "ERP_CLASSIFICATION_300";
	private static final String CLASSIFICATION_SYSTEM_VERSION = "ERP_IMPORT";
	private static final String IMPORTED_ATTRIBUTE_CODE = "TEST_MODEL";

	private static final int EXPECTED_IMPORTED_ATTRIBUTES = 1738;

	@Resource
	private ModelService modelService;

	@Resource
	private FlexibleSearchService flexibleSearchService;

	private final PropertyConfigSwitcher queryChunkSizeSwitcher = new PropertyConfigSwitcher(QUERY_CHUNK_SIZE);

	private ClassificationSystemModel catalog;
	private ClassificationSystemVersionModel catalogVersion;

	@Before
	public void setupTest()
	{
		catalog = modelService.create(ClassificationSystemModel.class);
		catalog.setId(CLASSIFICATION_SYSTEM);

		catalogVersion = modelService.create(ClassificationSystemVersionModel.class);
		catalogVersion.setCatalog(catalog);
		catalogVersion.setVersion(CLASSIFICATION_SYSTEM_VERSION);

		modelService.saveAll();
	}

	@After
	public void cleanup()
	{
		queryChunkSizeSwitcher.switchBackToDefault();
	}

	@Test
	public void shouldExecuteBigQueryThatIsChunkedBecauseOfHeaderModifier()
	{
		// given
		importService.importData(getTestResource("test/ChunkingTest-FeatureValue.impex"));

		// when
		final ImportResult importResult = importService.importData(getTestResource("test/ChunkingTest-Assignment.impex"));

		// then
		final ClassificationAttributeModel importedAttribute = findClassificationAttribute(IMPORTED_ATTRIBUTE_CODE);

		assertThat(importResult.isSuccessful()).isTrue();
		assertThat(importedAttribute.getDefaultAttributeValues()).hasSize(EXPECTED_IMPORTED_ATTRIBUTES);
	}

	@Test
	public void shouldFailImportWithTooBigQueryOnProblematicDb()
	{
		// Oracle 11 doesn't handle big translation query without chunking while 12 does
		// we're not getting into details of determining version and simply skipping test
		Assume.assumeFalse(Config.isOracleUsed());
		Assume.assumeTrue(Config.isHanaUsed() || Config.isSQLServerUsed());

		// given
		queryChunkSizeSwitcher.switchToValue("0");
		importService.importData(getTestResource("test/ChunkingTest-FeatureValue.impex"));

		// when
		TestUtils.disableFileAnalyzer("Importing big collection should fail on hana when " + QUERY_CHUNK_SIZE + " is set to 0");

		final ImportResult importResult = importService
				.importData(getTestResource("test/ChunkingTest-NonChunkingAssignment.impex"));

		TestUtils.enableFileAnalyzer();

		// then
		assertThat(importResult.isSuccessful()).isFalse();
		assertThat(importResult.isError()).isTrue();
	}

	@Test
	public void shouldImportWithBigQueryOnNonProblematicDb()
	{
		// Oracle 11 doesn't handle big translation query without chunking while 12 does
		// we're not getting into details of determining version and simply skipping test
		Assume.assumeFalse(Config.isOracleUsed());
		Assume.assumeFalse(Config.isHanaUsed() || Config.isSQLServerUsed());

		// given
		queryChunkSizeSwitcher.switchToValue("0");
		importService.importData(getTestResource("test/ChunkingTest-FeatureValue.impex"));

		// when
		final ImportResult importResult = importService
				.importData(getTestResource("test/ChunkingTest-NonChunkingAssignment.impex"));

		// then
		final ClassificationAttributeModel importedAttribute = findClassificationAttribute(IMPORTED_ATTRIBUTE_CODE);

		assertThat(importResult.isSuccessful()).isTrue();
		assertThat(importedAttribute.getDefaultAttributeValues()).hasSize(EXPECTED_IMPORTED_ATTRIBUTES);
	}


	private ImpExResource getTestResource(final String name)
	{
		final URL resource = Registry.class.getClassLoader().getResource(name);
		return new FileBasedImpExResource(new File(resource.getFile()), StandardCharsets.UTF_8.name());
	}

	private ClassificationAttributeModel findClassificationAttribute(final String code)
	{
		final ClassificationAttributeModel example = modelService.create(ClassificationAttributeModel.class);
		example.setCode(code);
		return flexibleSearchService.getModelByExample(example);
	}
}
