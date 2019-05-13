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

package de.hybris.platform.genericsearch.impl;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.bootstrap.typesystem.YAttributeDescriptor;
import de.hybris.bootstrap.typesystem.YTypeSystem;
import de.hybris.platform.core.GenericCondition;
import de.hybris.platform.core.GenericConditionList;
import de.hybris.platform.core.GenericQuery;
import de.hybris.platform.core.GenericSearchField;
import de.hybris.platform.core.Operator;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.ImmutableMap;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class GenericSearchQueryAdjusterTest
{
	private static final String PRODUCT = "Product";
	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String NCLOB = "NCLOB";
	private static final String SAP_DB_CODE = "sap";
	private static final String ORACLE_DB_CODE = "oracle";

	@Test
	public void shouldAdjustNCLOBAttributeOperatorToLike()
	{
		// given
		final YAttributeDescriptor productName = mockAttributeDescriptor(PRODUCT, "name", ImmutableMap.of("sap", "varchar(32)"));

		final YAttributeDescriptor productDescription = mockAttributeDescriptor(PRODUCT, DESCRIPTION,
				ImmutableMap.of(SAP_DB_CODE, NCLOB));

		final YAttributeDescriptor productProducer = mockAttributeDescriptor(PRODUCT, "producer",
				ImmutableMap.of(SAP_DB_CODE, NCLOB));

		final YTypeSystem typeSystem = mockTypeSystem(productName, productDescription, productProducer);
		final GenericSearchQueryAdjuster queryAdjuster = GenericSearchQueryAdjuster.create(typeSystem, SAP_DB_CODE);

		final GenericCondition nameCondition = GenericCondition.equals("name", "foo");
		final GenericCondition descriptionCondition = GenericCondition.equals(DESCRIPTION, "foo");
		final GenericCondition producerCondition = GenericCondition.contains(new GenericSearchField("producer"), "foo");

		final GenericConditionList conditionList = GenericCondition.createConditionList(nameCondition, descriptionCondition,
				producerCondition);
		final GenericQuery genericQuery = new GenericQuery(ProductModel._TYPECODE, conditionList);

		// when
		queryAdjuster.adjust(genericQuery);

		// then
		assertThat(nameCondition.getOperator()).isEqualTo(Operator.EQUAL);
		assertThat(descriptionCondition.getOperator()).isEqualTo(Operator.LIKE);
		assertThat(producerCondition.getOperator()).isEqualTo(Operator.LIKE);
	}

	@Test
	public void shouldNotAdjustAttributeForOracleDB()
	{
		// given
		final YAttributeDescriptor productName = mockAttributeDescriptor(PRODUCT, NAME,
				ImmutableMap.of(ORACLE_DB_CODE, "VARCHAR2(10 CHAR)"));
		final YTypeSystem typeSystem = mockTypeSystem(productName);

		final GenericSearchQueryAdjuster queryAdjuster = GenericSearchQueryAdjuster.create(typeSystem, ORACLE_DB_CODE);

		final GenericQuery query = new GenericQuery(ProductModel._TYPECODE);
		query.addCondition(GenericCondition.in(new GenericSearchField(ProductModel.NAME), Arrays.asList("1234", "2345")));

		// when
        queryAdjuster.adjust(query);

		// then
        assertThat(query.getCondition().getOperator()).isEqualTo(Operator.IN);
	}

	@Test
	public void shouldAdjustAttributeForSapDB()
	{
		// given
		final YAttributeDescriptor productName = mockAttributeDescriptor(PRODUCT, NAME,
				ImmutableMap.of(SAP_DB_CODE, NCLOB));
		final YTypeSystem typeSystem = mockTypeSystem(productName);

		final GenericSearchQueryAdjuster queryAdjuster = GenericSearchQueryAdjuster.create(typeSystem, SAP_DB_CODE);

		final GenericQuery query = new GenericQuery(ProductModel._TYPECODE);
		query.addCondition(GenericCondition.in(new GenericSearchField(ProductModel.NAME), Arrays.asList("1234", "2345")));

		// when
        queryAdjuster.adjust(query);

		// then
        assertThat(query.getCondition().getOperator()).isEqualTo(Operator.LIKE);
	}

	@Test
	public void shouldAdjustNCLOBAttributeOperatorToLikeInFieldComparison()
	{
		// given
		final YAttributeDescriptor productName = mockAttributeDescriptor(PRODUCT, NAME,
				ImmutableMap.of(SAP_DB_CODE, "varchar(32)"));

		final YAttributeDescriptor productDescription = mockAttributeDescriptor(PRODUCT, DESCRIPTION,
				ImmutableMap.of(SAP_DB_CODE, NCLOB));

		final YTypeSystem typeSystem = mockTypeSystem(productName, productDescription);
		final GenericSearchQueryAdjuster queryAdjuster = GenericSearchQueryAdjuster.create(typeSystem, SAP_DB_CODE);

		final GenericSearchField productNameField = new GenericSearchField(ProductModel._TYPECODE, ProductModel.NAME);
		final GenericSearchField productDescriptionField = new GenericSearchField(ProductModel._TYPECODE, ProductModel.DESCRIPTION);

		final GenericCondition nameComparisonCondition = GenericCondition.createConditionForFieldComparison(productNameField,
				Operator.EQUAL, productNameField);
		final GenericCondition descriptionComparisonCondition = GenericCondition
				.createConditionForFieldComparison(productDescriptionField, Operator.EQUAL, productDescriptionField);

		final GenericConditionList conditionList = GenericCondition.createConditionList(nameComparisonCondition,
				descriptionComparisonCondition);
		final GenericQuery genericQuery = new GenericQuery(ProductModel._TYPECODE, conditionList);

		// when
		queryAdjuster.adjust(genericQuery);

		// then
		assertThat(nameComparisonCondition.getOperator()).isEqualTo(Operator.EQUAL);
		assertThat(descriptionComparisonCondition.getOperator()).isEqualTo(Operator.LIKE);
	}

	@Test
	public void shouldTranslateConditionOperatorForAllBlobTypes()
	{
		// given
		final List<YAttributeDescriptor> blobDescriptors = randomProductAttributesOfAllBlobTypes();

		final YTypeSystem typeSystem = mockTypeSystem(blobDescriptors);
		final GenericSearchQueryAdjuster queryAdjuster = GenericSearchQueryAdjuster.create(typeSystem, SAP_DB_CODE);

		final GenericConditionList conditions = equalsConditionsForDescriptors(blobDescriptors);
		final GenericQuery genericQuery = new GenericQuery(ProductModel._TYPECODE, conditions);

		// when
		queryAdjuster.adjust(genericQuery);

		// then
		for (final GenericCondition condition : conditions.getConditionList())
		{
			assertThat(condition.getOperator()).isEqualTo(Operator.LIKE);
		}
	}

	@Test
	public void shouldTranslateInSubquery()
	{
		final YAttributeDescriptor productDescription = mockAttributeDescriptor(PRODUCT, DESCRIPTION,
				ImmutableMap.of(SAP_DB_CODE, NCLOB));

		final YTypeSystem typeSystem = mockTypeSystem(productDescription);

		final GenericCondition descriptionCondition = GenericCondition.equals(DESCRIPTION, "foo");
		final GenericConditionList conditionList = GenericCondition.createConditionList(descriptionCondition);

		final GenericQuery genericQuery = new GenericQuery(ProductModel._TYPECODE);
		final GenericQuery subQuery = genericQuery.addSubQuery(ProductModel.PK, Operator.IN, ProductModel._TYPECODE);
		subQuery.addCondition(conditionList);


		final GenericSearchQueryAdjuster queryAdjuster = GenericSearchQueryAdjuster.create(typeSystem, SAP_DB_CODE);

		// when
		queryAdjuster.adjust(genericQuery);

		// then
		assertThat(descriptionCondition.getOperator()).isEqualTo(Operator.LIKE);
	}

	private List<YAttributeDescriptor> randomProductAttributesOfAllBlobTypes()
	{
		final List<YAttributeDescriptor> blobDescriptors = new ArrayList<>();

		for (final String blobType : GenericSearchQueryAdjuster.LARGE_OBJECT_DATA_TYPES)
		{
			blobDescriptors
					.add(mockAttributeDescriptor(PRODUCT, UUID.randomUUID().toString(), ImmutableMap.of(SAP_DB_CODE, blobType)));
		}
		return blobDescriptors;
	}

	private GenericConditionList equalsConditionsForDescriptors(final List<YAttributeDescriptor> blobDescriptors)
	{
		final List<GenericCondition> conditions = new ArrayList<>();
		for (final YAttributeDescriptor descriptor : blobDescriptors)
		{
			conditions.add(GenericCondition.equals(descriptor.getQualifier(), UUID.randomUUID().toString()));
		}
		return GenericConditionList.and(conditions);
	}

	private YTypeSystem mockTypeSystem(final YAttributeDescriptor... descriptors)
	{
		return mockTypeSystem(Arrays.asList(descriptors));
	}

	private YTypeSystem mockTypeSystem(final List<YAttributeDescriptor> descriptors)
	{
		final YTypeSystem typeSystem = mock(YTypeSystem.class);
		when(typeSystem.getAttributes()).thenReturn(new HashSet<>(descriptors));

		return typeSystem;
	}

	private YAttributeDescriptor mockAttributeDescriptor(final String enclosingTypeCode, final String qualifier,
			final Map<String, String> dbColumnDefinitions)
	{
		final YAttributeDescriptor attributeDescriptor = mock(YAttributeDescriptor.class);
		when(attributeDescriptor.getEnclosingTypeCode()).thenReturn(enclosingTypeCode);
		when(attributeDescriptor.getQualifier()).thenReturn(qualifier);
		when(attributeDescriptor.getDbColumnDefinitions()).thenReturn(dbColumnDefinitions);

		return attributeDescriptor;
	}
}
