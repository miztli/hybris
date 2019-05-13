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

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.KeywordModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.util.Config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Streams;


@IntegrationTest
public class SynchronizeCatalogAwareItemsTest extends ServicelayerBaseTest
{
	private static final String CATALOG = "syncTestCatalog";
	private static final String SRC_CATALOG_VERSION = "srcCatalog";
	private static final String DST_CATALOG_VERSION = "dstCatalog";
	private static final String PRODUCT1 = "product1";
	private static final String PRODUCT2 = "product2";
	private static final String KEYWORD_1 = "keyword1";
	private static final String KEYWORD_2 = "keyword2";
	private static final String KEYWORD_3 = "keyword3";
	private static final String ISO_CODE = "en";

	private Locale lang;
	private String configLegacyFlag;

	@Resource
	private ModelService modelService;
	@Resource
	private FlexibleSearchService flexibleSearchService;
	@Resource
	private CommonI18NService commonI18NService;

	@Before
	public void setUp()
	{
		configLegacyFlag = Config.getParameter(GenericCatalogCopyContext.LEGACY_MODE_FLAG);
		Config.setParameter(GenericCatalogCopyContext.LEGACY_MODE_FLAG, "false");
		this.lang = commonI18NService.getLocaleForIsoCode(ISO_CODE);
	}

	@After
	public void tearDown()
	{
		Config.setParameter(GenericCatalogCopyContext.LEGACY_MODE_FLAG, configLegacyFlag);

		performSynchronization(null, Stream.concat(
				allProductsFor(dstCatalogVersion()).stream().map(SynchronizationTestHelper::remove),
				allKeywordsFor(dstCatalogVersion()).stream().map(SynchronizationTestHelper::remove))
				.toArray(SynchronizationTestHelper.SyncOperation[]::new));
	}

	//HORST-4881 - Keyword hasn't been translated properly during synchronization update
	@Test
	public void shouldTranslateCatalogForKeywordsDuringUpdate()
	{
		givenTestCatalogWithVersions();
		final CatalogVersionModel srcCV = srcCatalogVersion();
		final CatalogVersionModel dstCV = dstCatalogVersion();

		assertThat(allProductsFor(dstCV)).isNotNull().hasSize(0);
		performSynchronization(null);
		assertThat(allProductsFor(dstCV)).isNotNull().hasSize(2);

		addKeywordsToProducts(srcCV);

		assertThat(allKeywordsFor(srcCV)).isNotNull().hasSize(3);
		assertThat(allKeywordsFor(dstCV)).isNotNull().hasSize(0);

		performSynchronization(null,
				Streams.zip(
						allProductsFor(srcCV).stream().sorted(Comparator.comparing(ProductModel::getCode)),
						allProductsFor(dstCV).stream().sorted(Comparator.comparing(ProductModel::getCode)),
						(src, dst) -> {
							assertThat(src.getCode()).isEqualTo(dst.getCode());
							assertThat(src.getCatalogVersion()).isEqualTo(srcCV);
							assertThat(dst.getCatalogVersion()).isEqualTo(dstCV);
							return SynchronizationTestHelper.update(src, dst);
						})
						.toArray(SynchronizationTestHelper.SyncOperation[]::new));

		assertThat(allKeywordsFor(srcCV)).isNotNull().hasSize(3);
		assertThat(allKeywordsFor(dstCV)).isNotNull().hasSize(3);

		allProductsFor(dstCV).forEach(p -> p.getKeywords().forEach(k ->
			assertThat(k.getCatalogVersion()).isEqualTo(dstCV)
		));
	}

	private void addKeywordsToProducts(final CatalogVersionModel cv)
	{
		KeywordModel keyword1 = createKeyword(KEYWORD_1, cv);
		KeywordModel keyword2 = createKeyword(KEYWORD_2, cv);
		KeywordModel keyword3 = createKeyword(KEYWORD_3, cv);

		updateProductWithKeywords(cv, PRODUCT1, keyword1, keyword2);
		updateProductWithKeywords(cv, PRODUCT2, keyword1, keyword2, keyword3);

		modelService.saveAll();
	}

	private ProductModel createProduct(final CatalogVersionModel cv, String prod)
	{
		ProductModel product = modelService.create(ProductModel.class);
		product.setCode(prod);
		product.setCatalogVersion(cv);
		return product;
	}

	private ProductModel updateProductWithKeywords(final CatalogVersionModel cv, final String prod, final KeywordModel... keywords)
	{
		ProductModel example = new ProductModel();
		example.setCode(prod);
		example.setCatalogVersion(cv);
		final ProductModel product = flexibleSearchService.getModelByExample(example);
		product.setKeywords(Arrays.asList(keywords), this.lang);
		return product;
	}

	private KeywordModel createKeyword(final String value, final CatalogVersionModel cv)
	{
		KeywordModel keyword = modelService.create(KeywordModel.class);
		keyword.setKeyword(value);
		keyword.setCatalogVersion(cv);
		keyword.setLanguage(commonI18NService.getLanguage(ISO_CODE));
		return keyword;
	}

	private void givenTestCatalogWithVersions()
	{
		final CatalogModel catalog = modelService.create(CatalogModel.class);
		catalog.setId(CATALOG);

		final CatalogVersionModel sourceVersion = createCatalogVersionModel(catalog, SRC_CATALOG_VERSION);

		createCatalogVersionModel(catalog, DST_CATALOG_VERSION);

		createProduct(sourceVersion, PRODUCT1);
		createProduct(sourceVersion, PRODUCT2);

		modelService.saveAll();
	}

	private CatalogVersionModel createCatalogVersionModel(final CatalogModel catalog, final String version)
	{
		final CatalogVersionModel cv = modelService.create(CatalogVersionModel.class);
		cv.setCatalog(catalog);
		cv.setVersion(version);
		cv.setLanguages(Arrays.asList(commonI18NService.getLanguage(ISO_CODE)));
		return cv;
	}

	private void performSynchronization(final SynchronizationTestHelper.ConfigureSyncCronJob configure,
			final SynchronizationTestHelper.SyncOperation... operations)
	{
		final SynchronizationTestHelper.Builder builder = SynchronizationTestHelper
				.builder(srcCatalogVersion(), dstCatalogVersion());

		final SynchronizationTestHelper helper = builder.configure(configure).add(operations).build();

		helper.performSynchronization();
	}

	private CatalogModel testCatalog()
	{
		final CatalogModel example = new CatalogModel();
		example.setId(CATALOG);
		return flexibleSearchService.getModelByExample(example);
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

	private Collection<ProductModel> allProductsFor(final CatalogVersionModel catalogVersion)
	{
		final ProductModel example = new ProductModel();
		example.setCatalogVersion(catalogVersion);
		return flexibleSearchService.getModelsByExample(example);
	}

	private Collection<KeywordModel> allKeywordsFor(final CatalogVersionModel catalogVersion)
	{
		final KeywordModel example = new KeywordModel();
		example.setCatalogVersion(catalogVersion);
		return flexibleSearchService.getModelsByExample(example);
	}
}
