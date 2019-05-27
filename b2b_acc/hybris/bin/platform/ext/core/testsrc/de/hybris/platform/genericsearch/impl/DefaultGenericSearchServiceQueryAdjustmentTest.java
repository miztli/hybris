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

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.GenericCondition;
import de.hybris.platform.core.GenericConditionList;
import de.hybris.platform.core.GenericQuery;
import de.hybris.platform.core.GenericSearchField;
import de.hybris.platform.core.Operator;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.genericsearch.GenericSearchQuery;
import de.hybris.platform.genericsearch.GenericSearchService;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class DefaultGenericSearchServiceQueryAdjustmentTest extends ServicelayerTransactionalBaseTest
{
	@Resource
	private GenericSearchService genericSearchService;

	@Resource
	private ModelService modelService;

	private CatalogModel catalog;
	private CatalogVersionModel catalogVersion;
	private ProductModel product;
	private UnitModel unitModel;

	@Before
	public void prepareData()
	{
		getOrCreateLanguage("de");

		unitModel = modelService.create(UnitModel.class);
		unitModel.setCode(UUID.randomUUID().toString());
		unitModel.setName("Unit");
		unitModel.setUnitType("Type");

		catalog = modelService.create(CatalogModel.class);
		catalog.setId(UUID.randomUUID().toString());

		catalogVersion = modelService.create(CatalogVersionModel.class);
		catalogVersion.setVersion(UUID.randomUUID().toString());
		catalogVersion.setCatalog(catalog);

		product = modelService.create(ProductModel.class);
		product.setCode(UUID.randomUUID().toString());
		product.setDescription(UUID.randomUUID().toString());
		product.setCatalogVersion(catalogVersion);
		product.setUnit(unitModel);

		modelService.saveAll();
	}

	@Test
	public void shouldQueryForNclobField()
	{
		// given
		final GenericCondition descriptionCondition = GenericCondition.equals("description", product.getDescription());
		final GenericConditionList conditionList = GenericCondition.createConditionList(descriptionCondition);

		final GenericQuery genericQuery = new GenericQuery(ProductModel._TYPECODE, conditionList);
		final GenericSearchQuery genericSearchQuery = new GenericSearchQuery(genericQuery);

		// when
		final List<Object> serviceResults = genericSearchService.search(genericSearchQuery).getResult();
		final List jaloResults = JaloSession.getCurrentSession().search(genericQuery).getResult();

		// then
		assertThat(serviceResults).hasSize(1);
		assertThat(jaloResults).hasSize(1);
	}

	@Test
	public void shouldAdjustNclobFieldsInFieldComparison()
	{
		// given
		final GenericSearchField prodDescription = new GenericSearchField(ProductModel._TYPECODE, ProductModel.DESCRIPTION);
		final GenericCondition conditionForFieldComparison = GenericCondition.createConditionForFieldComparison(prodDescription, Operator.EQUAL, prodDescription);

		final GenericConditionList conditionList = GenericCondition.createConditionList(conditionForFieldComparison);

		final GenericQuery genericQuery = new GenericQuery(ProductModel._TYPECODE, conditionList);
		final GenericSearchQuery genericSearchQuery = new GenericSearchQuery(genericQuery);

		// when
		final List<Object> serviceResults = genericSearchService.search(genericSearchQuery).getResult();
		final List jaloResults = JaloSession.getCurrentSession().search(genericQuery).getResult();

		// then
		assertThat(serviceResults).hasSize(1);
		assertThat(jaloResults).hasSize(1);
	}

	@Test
	public void shouldQueryForNCLOBFieldInJoinQuery()
	{
		// given
		final GenericSearchField productDescriptionField = new GenericSearchField(ProductModel._TYPECODE, ProductModel.DESCRIPTION);

		final GenericCondition descriptionCondition = GenericCondition.equals(productDescriptionField, product.getDescription());
		final GenericConditionList conditionList = GenericCondition.createConditionList(descriptionCondition);

		final GenericQuery genericQuery = new GenericQuery(UnitModel._TYPECODE, conditionList);
		genericQuery.addInnerJoin(ProductModel._TYPECODE, productUnitJoin());

		// when
		final List<Object> serviceResults = genericSearchService.search(genericQuery).getResult();
		final List jaloResults = JaloSession.getCurrentSession().search(genericQuery).getResult();

		// then
		assertThat(serviceResults).hasSize(1);
		assertThat(jaloResults).hasSize(1);
	}

	@Test
	public void shouldHandleNCLOBFieldInSubquery()
	{
		final GenericCondition descriptionCondition = GenericCondition.equals("description", product.getDescription());
		final GenericConditionList conditionList = GenericCondition.createConditionList(descriptionCondition);

		final GenericQuery genericQuery = new GenericQuery(ProductModel._TYPECODE);
		final GenericQuery subQuery = genericQuery.addSubQuery(ProductModel.PK, Operator.IN, ProductModel._TYPECODE);
		subQuery.addCondition(conditionList);

		final GenericSearchQuery genericSearchQuery = new GenericSearchQuery(genericQuery);

		final List<Object> serviceResults = genericSearchService.search(genericSearchQuery).getResult();
		final List jaloResults = JaloSession.getCurrentSession().search(genericQuery).getResult();

		// then
		assertThat(serviceResults).hasSize(1);
		assertThat(jaloResults).hasSize(1);
	}


	private GenericCondition productUnitJoin()
	{
		final GenericSearchField productUnitField = new GenericSearchField(ProductModel._TYPECODE, ProductModel.UNIT);
		final GenericSearchField unitPkField = new GenericSearchField(UnitModel._TYPECODE, ItemModel.PK);

		return GenericCondition.createJoinCondition(productUnitField, unitPkField);
	}

}
