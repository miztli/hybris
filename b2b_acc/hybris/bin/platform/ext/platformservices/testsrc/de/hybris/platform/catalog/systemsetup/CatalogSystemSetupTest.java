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
package de.hybris.platform.catalog.systemsetup;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.CatalogTypeService;
import de.hybris.platform.catalog.constants.CatalogConstants;
import de.hybris.platform.catalog.jalo.ItemSyncTimestamp;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.ItemSyncTimestampModel;
import de.hybris.platform.catalog.model.SyncItemJobModel;
import de.hybris.platform.catalog.model.synchronization.CatalogVersionSyncJobModel;
import de.hybris.platform.catalog.synchronization.CatalogSynchronizationService;
import de.hybris.platform.catalog.synchronization.SyncConfig;
import de.hybris.platform.constants.GeneratedCoreConstants.TC;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.cronjob.enums.JobLogLevel;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.util.Utilities;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.common.collect.Lists;


@IntegrationTest
public class CatalogSystemSetupTest extends ServicelayerTest
{

	@Resource
	private ModelService modelService;

	@Resource
	private TypeService typeService;

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private CatalogTypeService catalogTypeService;

	@Resource(name = "catalogSynchronizationService")
	private CatalogSynchronizationService catalogSynchronizationService;

	private CatalogSystemSetup catalogSystemSetup;

	@Before
	public void setUp() throws Exception
	{
		createCoreData();
		catalogSystemSetup = new CatalogSystemSetup();
		catalogSystemSetup.setModelService(modelService);
		catalogSystemSetup.setJdbcTemplate(jdbcTemplate);
		catalogSystemSetup.setTypeService(typeService);
		catalogSystemSetup.setCatalogTypeService(catalogTypeService);
	}

	@Test
	public void patchOldSyncTimestamps()
	{

		final CatalogModel catalog = modelService.create(CatalogModel.class);
		catalog.setId("catalog");

		final CatalogVersionModel source = createCatalogVersion(catalog, "staged");
		final CatalogVersionModel target = createCatalogVersion(catalog, "online");

		final ProductModel product = modelService.create(ProductModel.class);
		product.setCode("test_product");
		product.setCatalogVersion(source);

		final CatalogVersionSyncJobModel syncJobModel = createCatalogVersionSyncJobModel(source, target, "testSyncJob");


		modelService.saveAll();

		catalogSynchronizationService.performSynchronization(Lists.newArrayList(product), syncJobModel, prepareSyncConfig());

		final ItemSyncTimestampModel itemSyncTimestampModel = catalogSynchronizationService
				.getSynchronizationSourceTimestampFor(syncJobModel,
				product);


		final ComposedTypeModel timestampType = typeService.getComposedTypeForCode(CatalogConstants.TC.ITEMSYNCTIMESTAMP);

		final ComposedTypeModel productType = typeService.getComposedTypeForCode(TC.PRODUCT);

		final String syncJobAd = typeService.getAttributeDescriptor(timestampType, ItemSyncTimestamp.SYNCJOB).getDatabaseColumn();

		final String lastModTsAd = typeService.getAttributeDescriptor(timestampType, ItemSyncTimestamp.LASTSYNCSOURCEMODIFIEDTIME)
				.getDatabaseColumn();


		final String modTsAd = typeService.getAttributeDescriptor(productType, ItemSyncTimestamp.MODIFIED_TIME).getDatabaseColumn();

		final int timeStampUpdated = jdbcTemplate.update(
				"UPDATE " + timestampType.getTable() + " SET " + lastModTsAd + " = NULL, " + syncJobAd + " = NULL WHERE PK = ?",
				itemSyncTimestampModel.getPk().getLong());

		final int prodUpdated = jdbcTemplate.update("UPDATE " + productType.getTable() + " SET " + modTsAd + " = NULL WHERE PK = ?",
				product.getPk().getLong());



		assertThat(timeStampUpdated).isEqualTo(1);
		assertThat(prodUpdated).isEqualTo(1);

		Utilities.invalidateCache(itemSyncTimestampModel.getPk());
		Utilities.invalidateCache(product.getPk());

		modelService.refresh(itemSyncTimestampModel);
		modelService.refresh(product);


		assertThat(product.getModifiedtime()).isNull();
		assertThat(itemSyncTimestampModel.getLastSyncSourceModifiedTime()).isNull();


		//when
		catalogSystemSetup.patchOldSyncTimestamps();

		modelService.refresh(itemSyncTimestampModel);
		modelService.refresh(product);

		//then
		assertThat(product.getModifiedtime()).isNotNull().isEqualTo(product.getCreationtime());
		assertThat(itemSyncTimestampModel.getLastSyncSourceModifiedTime()).isNotNull().isEqualTo(new Timestamp(0));

	}

	@Test
	public void shouldPatchObsoleteAttributes()
	{
		//given
		final ComposedTypeModel synJobComposedTypeModel = typeService.getComposedTypeForCode(CatalogConstants.TC.SYNCITEMJOB);

		final AttributeDescriptorModel sourceVersionLanguages = createAttributeDescriptorModel(synJobComposedTypeModel,
				"sourceversionlanguages");

		final AttributeDescriptorModel targetVersionLanguages = createAttributeDescriptorModel(synJobComposedTypeModel,
				"targetversionlanguages");

		modelService.saveAll(sourceVersionLanguages, targetVersionLanguages);

		modelService.refresh(synJobComposedTypeModel);


		assertThat(typeService.getAttributeDescriptorsForType(synJobComposedTypeModel)).contains(sourceVersionLanguages,
				targetVersionLanguages);


		//when
		catalogSystemSetup.patchObsoleteAttributes();


		//then
		assertThat(typeService.getAttributeDescriptorsForType(synJobComposedTypeModel)).doesNotContain(sourceVersionLanguages,
				targetVersionLanguages);

	}

	private CatalogVersionSyncJobModel createCatalogVersionSyncJobModel(final CatalogVersionModel source,
			final CatalogVersionModel target, final String code)
	{
		final CatalogVersionSyncJobModel syncJobModel = modelService.create(CatalogVersionSyncJobModel.class);
		syncJobModel.setCode(code);
		syncJobModel.setSourceVersion(source);
		syncJobModel.setTargetVersion(target);
		syncJobModel.setRemoveMissingItems(true);
		syncJobModel.setCreateNewItems(true);
		syncJobModel.setMaxThreads(1);
		return syncJobModel;
	}

	protected SyncConfig prepareSyncConfig()
	{
		final SyncConfig syncConfig = new SyncConfig();
		syncConfig.setCreateSavedValues(Boolean.FALSE);
		syncConfig.setForceUpdate(Boolean.FALSE);
		syncConfig.setLogLevelDatabase(JobLogLevel.WARNING);
		syncConfig.setLogLevelFile(JobLogLevel.WARNING);
		syncConfig.setLogToFile(Boolean.TRUE);
		syncConfig.setLogToDatabase(Boolean.FALSE);
		syncConfig.setSynchronous(Boolean.TRUE);
		return syncConfig;
	}

	protected void performSynchronization(final SyncItemJobModel syncItemJobModel, final List<ItemModel> items,
			final SyncConfig syncConfig)
	{
		catalogSynchronizationService.performSynchronization(items, syncItemJobModel, syncConfig);
	}

	protected CatalogVersionModel createCatalogVersion(final CatalogModel catalog, final String version)
	{
		final CatalogVersionModel catalogVersionModel = modelService.create(CatalogVersionModel.class);
		catalogVersionModel.setCatalog(catalog);
		catalogVersionModel.setVersion(version);
		return catalogVersionModel;
	}

	private AttributeDescriptorModel createAttributeDescriptorModel(final ComposedTypeModel synJobComposedTypeModel,
			final String sourceversionlanguages)
	{
		final AttributeDescriptorModel sourceVersionLanguages = modelService.create(AttributeDescriptorModel.class);
		sourceVersionLanguages.setEnclosingType(synJobComposedTypeModel);
		sourceVersionLanguages.setGenerate(Boolean.TRUE);
		sourceVersionLanguages.setPartOf(Boolean.FALSE);
		sourceVersionLanguages.setRemovable(Boolean.FALSE);
		sourceVersionLanguages.setAttributeType(typeService.getAtomicTypeForJavaClass(String.class));

		sourceVersionLanguages.setQualifier(sourceversionlanguages);
		return sourceVersionLanguages;
	}
}