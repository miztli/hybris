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

import de.hybris.platform.catalog.CatalogTypeService;
import de.hybris.platform.catalog.constants.CatalogConstants;
import de.hybris.platform.catalog.jalo.ItemSyncTimestamp;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetup.Process;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.exceptions.ModelRemovalException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;


@SystemSetup(extension = CatalogConstants.EXTENSIONNAME)
public class CatalogSystemSetup
{
	private static final Logger LOG = LoggerFactory.getLogger(CatalogSystemSetup.class);

	private static final String PATCHED = "Patched ";

	private ModelService modelService;
	private TypeService typeService;
	private JdbcTemplate jdbcTemplate;
	private CatalogTypeService catalogTypeService;

	@SystemSetup(patch = true, process = Process.UPDATE)
	public void patchOldSyncTimestamps()
	{

		final ComposedTypeModel tsType = typeService.getComposedTypeForCode(CatalogConstants.TC.ITEMSYNCTIMESTAMP);

		final String modTsAd = typeService.getAttributeDescriptor(tsType, ItemSyncTimestamp.MODIFIED_TIME).getDatabaseColumn();
		final String createdTsAd = typeService.getAttributeDescriptor(tsType, ItemSyncTimestamp.CREATION_TIME).getDatabaseColumn();

		final int timestampsWithSyncJobNullUpdated = patchItemSyncTimestampsWithSyncJobNull(tsType);
		final int timestampsWithLastModifyTimeNullUpdated = patchItemSyncTimestampsWithLastModifyTimeNull(tsType);

		final Set<ComposedTypeModel> catalogItemTablesForCacheInvalidation = new HashSet<>();

		final Set<ComposedTypeModel> catalogItemTables = catalogTypeService.getAllCatalogVersionAwareTypes(false).stream()
				.filter(rootType -> rootType.getTable() != null).collect(Collectors.toSet());

		for (final ComposedTypeModel catalogItemType : catalogItemTables)
		{
			final Boolean existsWithModificationTimeNull = jdbcTemplate
					.query(MessageFormat.format("SELECT 1 FROM {0} WHERE {1} IS NULL", catalogItemType.getTable(), modTsAd),
							ResultSet::next);

			if (existsWithModificationTimeNull)
			{
				catalogItemTablesForCacheInvalidation.add(catalogItemType);

				final int res = jdbcTemplate
						.update(MessageFormat.format("UPDATE {0} SET {1}={2} WHERE {1} IS NULL", catalogItemType.getTable(), modTsAd,
								createdTsAd));

				if (LOG.isInfoEnabled() && res > 0)
				{
					LOG.info("{}{} NULL modified timestamps from {}", PATCHED, res, catalogItemType);
				}
			}
		}

		if ((timestampsWithSyncJobNullUpdated > 0 || timestampsWithLastModifyTimeNullUpdated > 0
				|| !catalogItemTablesForCacheInvalidation.isEmpty()))
		{
			Registry.getCurrentTenant().getCache().clear();

			// really needs invalidation for given type not for the whole cache clear!
		}
	}

	@SystemSetup(patch = true, process = Process.UPDATE)
	public void patchObsoleteAttributes()
	{
		final ComposedTypeModel synJobComposedTypeModel = typeService.getComposedTypeForCode(CatalogConstants.TC.SYNCITEMJOB);

		removeSyncItemJobAttribute(synJobComposedTypeModel, "sourceversionlanguages");
		removeSyncItemJobAttribute(synJobComposedTypeModel, "targetversionlanguages");

		modelService.refresh(synJobComposedTypeModel);
	}

	private int patchItemSyncTimestampsWithLastModifyTimeNull(final ComposedTypeModel tsType)
	{
		final String lastModTsAd = typeService.getAttributeDescriptor(tsType, ItemSyncTimestamp.LASTSYNCSOURCEMODIFIEDTIME)
				.getDatabaseColumn();

		final int updated = jdbcTemplate
				.update(MessageFormat.format("UPDATE {0} SET {1}=? WHERE {1} IS NULL", tsType.getTable(), lastModTsAd),
						new Timestamp(0));

		if (LOG.isInfoEnabled())
		{
			LOG.info("{}{} sync timestamp NULL modified timestamps", PATCHED, updated);
		}

		return updated;
	}

	private int patchItemSyncTimestampsWithSyncJobNull(final ComposedTypeModel tsType)
	{
		final String syncJobAd = typeService.getAttributeDescriptor(tsType, ItemSyncTimestamp.SYNCJOB).getDatabaseColumn();

		final int updated = jdbcTemplate
				.update(MessageFormat.format("UPDATE {0} SET {1}=0 WHERE {1} IS NULL", tsType.getTable(), syncJobAd));


		if (LOG.isInfoEnabled())
		{
			LOG.info("{}{} old sync timestamp job references", PATCHED, updated);
		}

		return updated;
	}

	private void removeSyncItemJobAttribute(final ComposedTypeModel composedTypeModel, final String qualifier)
	{
		try
		{
			final AttributeDescriptorModel attributeDescriptorModel = typeService.getAttributeDescriptor(composedTypeModel,
					qualifier);

			attributeDescriptorModel.setRemovable(true);
			modelService.save(attributeDescriptorModel);

			modelService.remove(attributeDescriptorModel);
		}
		catch (final UnknownIdentifierException e)
		{
			LOG.debug("Attribute " + qualifier + " for " + CatalogConstants.TC.SYNCITEMJOB
					+ " not found. Probably was removed before. " + e.getMessage());
		}
		catch (final ModelRemovalException mre)
		{
			LOG.error("Cannot remove obsolete attribute " + qualifier + " due to " + mre.getMessage(), mre);
		}
	}

	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	public void setTypeService(final TypeService typeService)
	{
		this.typeService = typeService;
	}

	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setCatalogTypeService(final CatalogTypeService catalogTypeService)
	{
		this.catalogTypeService = catalogTypeService;
	}
}