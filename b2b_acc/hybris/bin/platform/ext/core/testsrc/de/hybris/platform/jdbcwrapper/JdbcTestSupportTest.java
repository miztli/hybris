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
package de.hybris.platform.jdbcwrapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.jdbcwrapper.JdbcTestSupport.JdbcStatistics;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class JdbcTestSupportTest extends ServicelayerBaseTest
{
	@Resource
	ModelService modelService;

	@Resource
	FlexibleSearchService flexibleSearchService;

	private JdbcStatistics stats;

	@Before
	public void setUp()
	{
		stats = JdbcTestSupport.createNewJdbcStatistics();
	}

	@After
	public void tearDown()
	{
		stats.detach();
	}

	@Test
	public void shouldNotCollectStatementsWhenStatiscticsAreNotAttachedToTheThread()
	{
		final ItemModel testModel = givenTestModel();

		modelService.save(testModel);

		assertThat(stats).containsNoStatements();
	}

	@Test
	public void shouldCollectStatementsWhenStatiscticsAreAttachedToTheThread()
	{
		stats.attachToCurrentThread();
		final ItemModel testModel = givenTestModel();

		modelService.save(testModel);

		assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> {
			assertThat(stats).containsNoDMLStatements();
		}).withMessageContaining("Expecting empty").withMessageContaining("INSERT INTO");
	}

	@Test
	public void shouldCollectSelectStatements()
	{
		stats.attachToCurrentThread();

		flexibleSearchService.search("select {PK} from {Title}");

		assertThat(stats).containsNoDMLStatements();

		assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> {
			assertThat(stats).containsNoStatements();
		}).withMessageContaining("Expecting empty").withMessageContaining("SELECT");
	}

	@Test
	public void shouldCollectStatementsOnlyFromAttachedThreads() throws InterruptedException
	{
		final Tenant tenant = Registry.getCurrentTenant();
		final Thread t = new Thread(() -> {
			Registry.setCurrentTenant(tenant);

			stats.attachToCurrentThread();

			flexibleSearchService.search("select {PK} from {Title}");
		});

		t.start();

		final ItemModel testModel = givenTestModel();
		modelService.save(testModel);

		t.join(1000);

		assertThat(stats).containsNoDMLStatements();
		assertThat(stats).containsOnlySelectStatements();
	}

	private ItemModel givenTestModel()
	{
		final TitleModel title = modelService.create(TitleModel.class);
		title.setCode(UUID.randomUUID().toString());
		return title;
	}

}
