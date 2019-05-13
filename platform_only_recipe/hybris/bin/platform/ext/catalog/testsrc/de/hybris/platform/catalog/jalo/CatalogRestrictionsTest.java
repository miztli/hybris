/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.catalog.jalo;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Collections;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class CatalogRestrictionsTest extends ServicelayerBaseTest
{

	@Resource
	UserService userService;

	@Resource
	ModelService modelService;

	@Resource
	FlexibleSearchService flexibleSearchService;

	private UserModel previousUser;

	@Before
	public void setUp()
	{
		final UserGroupModel testGroup = modelService.create(UserGroupModel.class);
		testGroup.setUid(unique("TEST_GROUP"));

		final UserModel employee = modelService.create(UserModel.class);
		employee.setUid(unique("TEST_USER"));
		employee.setGroups(Collections.singleton(testGroup));

		modelService.saveAll();

		CatalogManager.getInstance().createCatalogSearchRestriction(unique("TEST_RESTRICTION"), modelService.getSource(testGroup));
		previousUser = userService.getCurrentUser();
		userService.setCurrentUser(employee);
	}

	@After
	public void tearDown()
	{
		userService.setCurrentUser(previousUser);
	}

	@Test
	public void shouldFindCatalogWithoutCatalogVersions()
	{
		final CatalogModel catalog = givenCatalog();

		final SearchResult<CatalogModel> catalogs = flexibleSearchService.search("select {PK} from {Catalog} where {PK}=?catalogPK",
				Collections.singletonMap("catalogPK", catalog.getPk()));

		assertThat(catalogs.getResult()).isNotEmpty().hasSize(1).containsExactly(catalog);
	}

	private CatalogModel givenCatalog()
	{
		final CatalogModel catalog = modelService.create(CatalogModel.class);
		catalog.setId(unique("TEST_CATALOG"));
		modelService.saveAll();
		return catalog;
	}

	private static String unique(final String prefix)
	{
		return prefix + "_" + UUID.randomUUID();
	}
}
