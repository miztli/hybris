/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 *
 */

package de.hybris.platform.catalog.jalo.synchronization;

import static de.hybris.platform.catalog.jalo.synchronization.SynchronizationTestHelper.givenTestCatalogWithVersions;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.jalo.CatalogManager;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.cronjob.CronJobService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.util.Utilities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;


@IntegrationTest
public class SyncCronJobDumpFileIntegrationTest extends ServicelayerBaseTest
{

	private static final String CATALOG = "testCatalog";
	private static final String SRC_CATALOG_VERSION = "srcCatalog";
	private static final String DST_CATALOG_VERSION = "dstCatalog";
	private static final String CATEGORY = "category";
	private static final String PRODUCT1 = "product1";
	private static final String PRODUCT2 = "product2";

	@Resource
	private ModelService modelService;
	@Resource
	private FlexibleSearchService flexibleSearchService;
	@Resource
	CronJobService cronJobService;

	private final PropertyConfigSwitcher synchronizationDumpFileTempDir = new PropertyConfigSwitcher(
			"synchronization.dumpfile.tempdir");

	@After
	public void tearDown() throws Exception
	{
		synchronizationDumpFileTempDir.switchBackToDefault();
	}

	@Test
	public void shouldReturnDefaultSyncDumpFileDir()
	{
		givenTestCatalogWithVersions(modelService, CATALOG, SRC_CATALOG_VERSION, DST_CATALOG_VERSION, CATEGORY, PRODUCT1, PRODUCT2);

		final CatalogVersionSyncCronJob syncCronJob = whenSyncCronJobCreated();

		//then
		final String dumpFilesDir = syncCronJob.getDumpFilesDir();
		assertThat(Paths.get(dumpFilesDir)).isEqualTo(Utilities.getPlatformTempDir().toPath().resolve("sync"));
	}


	@Test
	public void shouldReturnWorkspaceWhenPropertySetEmpty()
	{
		synchronizationDumpFileTempDir.switchToValue("");

		givenTestCatalogWithVersions(modelService, CATALOG, SRC_CATALOG_VERSION, DST_CATALOG_VERSION, CATEGORY, PRODUCT1, PRODUCT2);

		final CatalogVersionSyncCronJob syncCronJob = whenSyncCronJobCreated();



		//then
		final String dumpFilesDir = syncCronJob.getDumpFilesDir();
		assertThat(Paths.get(dumpFilesDir).toAbsolutePath()).isEqualTo(new File(".").toPath().toAbsolutePath());
	}

	@Test
	public void shouldCreateDirWhileSyncAndDirNotExists()
	{
		final Path tempDir = Utilities.getPlatformTempDir().toPath().resolve(RandomStringUtils.randomAlphabetic(5))
				.resolve(RandomStringUtils.randomAlphabetic(5));
		assertThat(tempDir).doesNotExist();

		synchronizationDumpFileTempDir.switchToValue(tempDir.toString());

		givenTestCatalogWithVersions(modelService, CATALOG, SRC_CATALOG_VERSION, DST_CATALOG_VERSION, CATEGORY, PRODUCT1, PRODUCT2);

		final CatalogVersionSyncCronJob syncCronJob = whenSyncCronJobCreated();
		syncCronJob.getJob().perform(syncCronJob, true);

		//then
		final String dumpFilesDir = syncCronJob.getDumpFilesDir();
		assertThat(Paths.get(dumpFilesDir)).isEqualTo(tempDir);

		assertThat(tempDir).exists().isDirectory();
	}
	
	@Test
	public void shouldFailWhenDirSetToFile()
	{
		final Path tempDir = Paths.get("build.xml");
		assertThat(tempDir).exists().isRegularFile();

		synchronizationDumpFileTempDir.switchToValue(tempDir.toString());

		givenTestCatalogWithVersions(modelService, CATALOG, SRC_CATALOG_VERSION, DST_CATALOG_VERSION, CATEGORY, PRODUCT1, PRODUCT2);

		final CatalogVersionSyncCronJob syncCronJob = whenSyncCronJobCreated();
		syncCronJob.setLogToDatabase(true);

		final String dumpFilesDir = syncCronJob.getDumpFilesDir();
		assertThat(Paths.get(dumpFilesDir)).isEqualTo(tempDir);

		syncCronJob.getJob().perform(syncCronJob, true);

		final CronJobModel cronJob = cronJobService.getCronJob(syncCronJob.getCode());

		assertThat(cronJobService.isFinished(cronJob)).isTrue();
		assertThat(cronJob.getResult()).isEqualTo(CronJobResult.FAILURE);
	}

	@Test
	public void shouldFailWhenDirSetToInvalidPath()
	{
		final Path tempDir = Paths.get("build.xml/temp");

		synchronizationDumpFileTempDir.switchToValue(tempDir.toString());

		givenTestCatalogWithVersions(modelService, CATALOG, SRC_CATALOG_VERSION, DST_CATALOG_VERSION, CATEGORY, PRODUCT1, PRODUCT2);

		final CatalogVersionSyncCronJob syncCronJob = whenSyncCronJobCreated();

		final String dumpFilesDir = syncCronJob.getDumpFilesDir();
		assertThat(Paths.get(dumpFilesDir)).isEqualTo(tempDir);

		syncCronJob.getJob().perform(syncCronJob, true);

		final CronJobModel cronJob = cronJobService.getCronJob(syncCronJob.getCode());

		assertThat(cronJobService.isFinished(cronJob)).isTrue();
		assertThat(cronJob.getResult()).isEqualTo(CronJobResult.FAILURE);
	}

	private CatalogVersionSyncCronJob whenSyncCronJobCreated()
	{
		final Map<String, Object> args = new HashMap<>();
		final CatalogVersionModel srcCatalogVersion = srcCatalogVersion();
		final CatalogVersionModel dstCatalogVersion = dstCatalogVersion();

		args.put(CatalogVersionSyncJob.CODE,
				"[" + System.currentTimeMillis() + "]" + srcCatalogVersion.getVersion() + "->" + dstCatalogVersion.getVersion());
		args.put(CatalogVersionSyncJob.SOURCEVERSION, srcCatalogVersion.getItemModelContext().getSource());
		args.put(CatalogVersionSyncJob.TARGETVERSION, dstCatalogVersion.getItemModelContext().getSource());

		final CatalogVersionSyncJob syncJob = CatalogManager.getInstance().createCatalogVersionSyncJob(args);

		return (CatalogVersionSyncCronJob) syncJob.newExecution();
	}

	private CatalogVersionModel srcCatalogVersion()
	{
		final CatalogVersionModel example = new CatalogVersionModel();
		example.setCatalog(testCatalog());
		example.setVersion(SRC_CATALOG_VERSION);
		return flexibleSearchService.getModelByExample(example);
	}

	private CatalogVersionModel dstCatalogVersion()
	{
		final CatalogVersionModel example = new CatalogVersionModel();
		example.setCatalog(testCatalog());
		example.setVersion(DST_CATALOG_VERSION);
		return flexibleSearchService.getModelByExample(example);
	}

	private CatalogModel testCatalog()
	{
		final de.hybris.platform.catalog.model.CatalogModel example = new CatalogModel();
		example.setId(CATALOG);
		return flexibleSearchService.getModelByExample(example);
	}
}
