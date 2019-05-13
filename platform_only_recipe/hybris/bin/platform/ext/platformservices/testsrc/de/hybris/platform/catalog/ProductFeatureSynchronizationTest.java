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
package de.hybris.platform.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.platform.catalog.jalo.synchronization.SynchronizationTestHelper;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.catalog.model.classification.ClassificationAttributeModel;
import de.hybris.platform.catalog.model.classification.ClassificationClassModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemVersionModel;
import de.hybris.platform.classification.ClassificationService;
import de.hybris.platform.classification.features.FeatureList;
import de.hybris.platform.classification.features.FeatureValue;
import de.hybris.platform.classification.features.UnlocalizedFeature;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.testframework.seed.ClassificationSystemTestDataCreator;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


public class ProductFeatureSynchronizationTest extends ServicelayerBaseTest
{
	@Resource
	private ModelService modelService;
	@Resource
	private UserService userService;
	@Resource
	private FlexibleSearchService flexibleSearchService;
	@Resource
	private ClassificationService classificationService;
	@Resource
	private TypeService typeService;
	private ClassificationClassModel classificationClass;
	private ClassificationAttributeModel classificationAttribute;
	private ClassificationSystemTestDataCreator creator;
	private CatalogModel catalog;
	private CatalogVersionModel catalogVersionStaged;
	private CatalogVersionModel catalogVersionOnline;
	private ClassAttributeAssignmentModel attributeAssignment;

	@Before
	public void setUp() throws Exception
	{
		creator = new ClassificationSystemTestDataCreator(modelService);

		catalog = creator.createCatalog();

		catalogVersionStaged = creator.createCatalogVersion("test-staged", catalog);
		catalogVersionOnline = creator.createCatalogVersion("test-online", catalog);

		final ClassificationSystemModel system = creator.createClassificationSystem("testClassificationSystem");
		final ClassificationSystemVersionModel systemVersion = creator.createClassificationSystemVersion("testVersion", system);
		classificationClass = creator.createClassificationClass("testClass", systemVersion);
		classificationAttribute = creator.createClassificationAttribute("testAttribute", systemVersion);

		attributeAssignment = creator.createRefClassAttributeAssignment(classificationAttribute, classificationClass,
				typeService.getComposedTypeForCode("User"));
	}

	@Test
	public void shouldSynchronizeAssignedRefererenceFratureToExistingOnlineVersionOfTheProduct()
	{
        // given
        final ProductModel product = creator.createProduct(catalogVersionStaged);

        final SynchronizationTestHelper synchronizationTestHelper = SynchronizationTestHelper
                .builder(catalogVersionStaged, catalogVersionOnline).build();
        assertThat(findProduct(product.getCode(), catalogVersionStaged)).isNotNull();
        assertThat(findProduct(product.getCode(), catalogVersionOnline)).isNull();
        assertThat(classificationService.getFeatures(product)).isEmpty();

        synchronizationTestHelper.performSynchronization();
        assertThat(findProduct(product.getCode(), catalogVersionStaged)).isNotNull();
        assertThat(findProduct(product.getCode(), catalogVersionOnline)).isNotNull();

        final EmployeeModel adminAsFeatureValue = userService.getAdminUser();
        classificationService.setFeature(product,
                new UnlocalizedFeature(attributeAssignment, new FeatureValue(adminAsFeatureValue)));
        // We need to add Product to ClassificationClass to make it work
        classificationClass.setProducts(Arrays.asList(product));
        modelService.save(classificationClass);

        // when
        synchronizationTestHelper.performSynchronization();
        final ProductModel syncedProduct = findProduct(product.getCode(), catalogVersionOnline);
        final FeatureList features = classificationService.getFeatures(syncedProduct);

        // then
        assertThat(syncedProduct).isNotNull();
        assertThat(features).isNotEmpty();
        assertThat(features.getFeatureByAssignment(attributeAssignment)).isNotNull();
        assertThat(features.getFeatureByAssignment(attributeAssignment).getValue().getValue()).isEqualTo(adminAsFeatureValue);
	}

	@Test
	public void shouldSynchronizeProductWithAssignedReferenceProductFeature()
	{
		// given
		final EmployeeModel adminAsFeatureValue = userService.getAdminUser();
		final ProductModel product = creator.createProduct(catalogVersionStaged);
		classificationService.setFeature(product,
				new UnlocalizedFeature(attributeAssignment, new FeatureValue(adminAsFeatureValue)));
		// We need to add Product to ClassificationClass to make it work
		classificationClass.setProducts(Arrays.asList(product));
		modelService.save(classificationClass);

		final SynchronizationTestHelper synchronizationTestHelper = SynchronizationTestHelper
				.builder(catalogVersionStaged, catalogVersionOnline).build();
        assertThat(findProduct(product.getCode(), catalogVersionStaged)).isNotNull();
        assertThat(findProduct(product.getCode(), catalogVersionOnline)).isNull();

		// when
		synchronizationTestHelper.performSynchronization();
		final ProductModel syncedProduct = findProduct(product.getCode(), catalogVersionOnline);
		final FeatureList features = classificationService.getFeatures(syncedProduct);


		// then
		assertThat(syncedProduct).isNotNull();
		assertThat(features).isNotEmpty();
		assertThat(features.getFeatureByAssignment(attributeAssignment)).isNotNull();
		assertThat(features.getFeatureByAssignment(attributeAssignment).getValue().getValue()).isEqualTo(adminAsFeatureValue);
	}

	private ProductModel findProduct(final String code, final CatalogVersionModel catalogVersion)
	{
		final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(
				"SELECT {PK} FROM {Product} WHERE {catalogVersion}=?ctgVer AND {code}=?code");
		fQuery.addQueryParameter("ctgVer", catalogVersion);
		fQuery.addQueryParameter("code", code);

		try
		{
			return flexibleSearchService.searchUnique(fQuery);
		}
		catch (final Exception e)
		{
			return null;
		}
	}
}
