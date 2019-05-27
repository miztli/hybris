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
package de.hybris.platform.catalog.jalo;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.platform.catalog.jalo.classification.ClassAttributeAssignment;
import de.hybris.platform.catalog.jalo.classification.ClassificationAttribute;
import de.hybris.platform.catalog.jalo.classification.ClassificationClass;
import de.hybris.platform.catalog.jalo.classification.ClassificationSystem;
import de.hybris.platform.catalog.jalo.classification.ClassificationSystemVersion;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.enumeration.EnumerationManager;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.product.ProductManager;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.jalo.user.Employee;
import de.hybris.platform.jalo.user.Title;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.testframework.HybrisJUnit4Test;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;


public class ProductFeatureJaloTest extends HybrisJUnit4Test
{
	private ClassAttributeAssignment assignment;
	private Product product;

	@Before
	public void setUp() throws Exception
	{
		final Language currentLang = JaloSession.getCurrentSession().getSessionContext().getLanguage();

		final CatalogManager manager = CatalogManager.getInstance();

		final Catalog catalog = manager.createCatalog("catalog");
		final CatalogVersion catalogVersion = manager.createCatalogVersion(catalog, "testVersion", currentLang);

		product = ProductManager.getInstance().createProduct("testProduct");

		final ClassificationSystem classificationSystem = manager.createClassificationSystem("testSystem");
		final ClassificationSystemVersion classificationSystemVersion = manager
				.createClassificationSystemVersion(classificationSystem, "testClassificationSystemVersion", currentLang);
		final ClassificationClass classificationClass = manager.createClassificationClass(
				ImmutableMap.of("code", "testClassificationClass", "catalogVersion", classificationSystemVersion));
		final ClassificationAttribute classificationAttribute = manager
				.createClassificationAttribute(ImmutableMap.of("code", "fooBar", "systemVersion", classificationSystemVersion));
		assignment = manager.createClassAttributeAssignment(
				ImmutableMap.of("classificationClass", classificationClass, "classificationAttribute", classificationAttribute));
	}

	@Test
	public void shouldCreateProductFeatureWithReferenceValue() throws Exception
	{
		// given
		final EnumerationValue referenceType = EnumerationManager.getInstance()
				.getEnumerationValue("ClassificationAttributeTypeEnum", "reference");

		final Title title = UserManager.getInstance().createTitle("testTitle");
		assignment.setAttributeType(referenceType);
		assignment.setReferenceType(TypeManager.getInstance().getComposedType("Title"));
		assignment.setReferenceIncludesSubTypes(false);

		// when
		final ProductFeature feature = createProductFeature(assignment, title);

		// then
		assertThat(feature).isNotNull();
		assertThat(feature.getValue()).isEqualTo(title);
	}

	@Test
	public void shouldCreateProductFeatureWithReferenceValueWhichIsSubtypeOfConfiguredOne() throws Exception
	{
		final EnumerationValue referenceType = EnumerationManager.getInstance()
				.getEnumerationValue("ClassificationAttributeTypeEnum", "reference");

		final Employee user = UserManager.getInstance().getAdminEmployee();
		assignment.setAttributeType(referenceType);
		assignment.setReferenceType(TypeManager.getInstance().getComposedType("User"));
		assignment.setReferenceIncludesSubTypes(false);

		// when
		final ProductFeature feature = createProductFeature(assignment, user);

		// then
		assertThat(feature).isNotNull();
		assertThat(feature.getValue()).isEqualTo(user);
	}

	private ProductFeature createProductFeature(final ClassAttributeAssignment assignment, final Object value)
	{
		return CatalogManager.getInstance().createProductFeature( //
				ImmutableMap.of("classificationAttributeAssignment", assignment, "value", value, "product", product) //
		);
	}


}