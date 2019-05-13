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
package de.hybris.platform.catalog.jalo.synchronization;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

import de.hybris.platform.catalog.jalo.CatalogManager;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;


public final class SynchronizationTestHelper
{
	private final CatalogVersionModel srcCatalogVersion;
	private final CatalogVersionModel dstCatalogVersion;
	private final ConfigureSyncCronJob configure;
	private final SyncOperation[] operations;


	private SynchronizationTestHelper(final CatalogVersionModel srcCatalogVersion, final CatalogVersionModel dstCatalogVersion,
			final ConfigureSyncCronJob configure, final SyncOperation[] operations)
	{
		this.srcCatalogVersion = requireNonNull(srcCatalogVersion);
		this.dstCatalogVersion = requireNonNull(dstCatalogVersion);
		this.configure = requireNonNull(configure);
		this.operations = requireNonNull(operations);
	}

	public static Builder builder(final CatalogVersionModel srcCatalogVersion, final CatalogVersionModel dstCatalogVersion)
	{
		return new Builder(srcCatalogVersion, dstCatalogVersion);
	}

	public static void givenTestCatalogWithVersions(final ModelService modelService, final String catalogId,
			final String srcCatalogVersion, final String dstCatalogVersion, final String category, final String... product)
	{
		final CatalogModel catalog = modelService.create(CatalogModel.class);
		catalog.setId(catalogId);

		final CatalogVersionModel sourceVersion = modelService.create(CatalogVersionModel.class);
		sourceVersion.setCatalog(catalog);
		sourceVersion.setVersion(srcCatalogVersion);

		final CatalogVersionModel targetVersion = modelService.create(CatalogVersionModel.class);
		targetVersion.setCatalog(catalog);
		targetVersion.setVersion(dstCatalogVersion);

		final CategoryModel category1 = modelService.create(CategoryModel.class);
		category1.setCatalogVersion(sourceVersion);
		category1.setCode(category);

		final List<ProductModel> products = Arrays.stream(product).map(productCode -> {
			final ProductModel p1 = modelService.create(ProductModel.class);
			p1.setCatalogVersion(sourceVersion);
			p1.setCode(productCode);
			p1.setSupercategories(Collections.singletonList(category1));
			return p1;
		}).collect(Collectors.toList());

		category1.setProducts(products);

		modelService.saveAll();
	}

	public void performSynchronization()
	{
		final Map args = new HashMap();

		args.put(CatalogVersionSyncJob.CODE, "[" + System.currentTimeMillis() + "]" + srcCatalogVersion.getVersion() + "->"
				+ dstCatalogVersion.getVersion());
		args.put(CatalogVersionSyncJob.SOURCEVERSION, srcCatalogVersion.getItemModelContext().getSource());
		args.put(CatalogVersionSyncJob.TARGETVERSION, dstCatalogVersion.getItemModelContext().getSource());

		final CatalogVersionSyncJob syncJob = CatalogManager.getInstance().createCatalogVersionSyncJob(args);

		final CatalogVersionSyncCronJob syncCronJob = (CatalogVersionSyncCronJob) syncJob.newExecution();
		for (final SyncOperation operation : operations)
		{
			syncCronJob.addPendingItem(operation.getSrcPk(), operation.getDstPk());
		}

		configure.configure(syncCronJob);

		syncCronJob.getJob().perform(syncCronJob, true);
	}

	public static SyncOperation create(final ItemModel item)
	{
		return new SyncOperation(requireNonNull(item), null);
	}

	public static SyncOperation remove(final ItemModel item)
	{
		return new SyncOperation(null, requireNonNull(item));
	}

	public static SyncOperation update(final ItemModel srcItem, final ItemModel dstItem)
	{
		return new SyncOperation(requireNonNull(srcItem), requireNonNull(dstItem));
	}

	public static class SyncOperation
	{
		private final ItemModel src;
		private final ItemModel dst;

		public SyncOperation(final ItemModel src, final ItemModel dst)
		{
			checkArgument(src != null || dst != null);
			this.src = src;
			this.dst = dst;
		}

		public PK getSrcPk()
		{
			return src == null ? null : src.getPk();
		}

		public PK getDstPk()
		{
			return dst == null ? null : dst.getPk();
		}
	}

	public interface ConfigureSyncCronJob
	{
		void configure(CatalogVersionSyncCronJob job);
	}

	public static class Builder
	{
		private final CatalogVersionModel srcCatalogVersion;
		private final CatalogVersionModel dstCatalogVersion;
		private final ImmutableList.Builder<SyncOperation> operations = ImmutableList.builder();
		private ConfigureSyncCronJob configureSyncCronJob = null;

		public Builder(final CatalogVersionModel srcCatalogVersion, final CatalogVersionModel dstCatalogVersion)
		{
			this.srcCatalogVersion = requireNonNull(srcCatalogVersion);
			this.dstCatalogVersion = requireNonNull(dstCatalogVersion);
		}

		public Builder add(final SyncOperation... operations)
		{
			for (final SyncOperation operation : requireNonNull(operations))
			{
				this.operations.add(requireNonNull(operation));
			}
			return this;
		}

		public Builder configure(final ConfigureSyncCronJob configure)
		{
			configureSyncCronJob = configure;
			return this;
		}

		public SynchronizationTestHelper build()
		{
			final SyncOperation[] syncOperations = operations.build().toArray(new SyncOperation[] {});
			ConfigureSyncCronJob configure = configureSyncCronJob;
			if (configure == null)
			{
				configure = new ConfigureSyncCronJob()
				{
					@Override
					public void configure(final CatalogVersionSyncCronJob job)
					{
						//default implementation. nothing to configure
					}
				};
			}
			return new SynchronizationTestHelper(srcCatalogVersion, dstCatalogVersion, configure, syncOperations);
		}
	}
}
