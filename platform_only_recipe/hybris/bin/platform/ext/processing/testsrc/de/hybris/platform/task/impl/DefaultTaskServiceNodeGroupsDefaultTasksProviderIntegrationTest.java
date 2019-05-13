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
 *
 */
package de.hybris.platform.task.impl;


import de.hybris.bootstrap.annotations.IntegrationTest;


@IntegrationTest
public class DefaultTaskServiceNodeGroupsDefaultTasksProviderIntegrationTest extends DefaultTaskServiceNodeGroupsIntegrationTest
{

	@Override
	protected TasksProvider getTasksProvider()
	{
		final DefaultTasksProvider tasksProvider = new DefaultTasksProvider();
		tasksProvider.setMetricRegistry(metricRegistry);
		tasksProvider.setTypeService(typeService);
		tasksProvider.setFlexibleSearchService(flexibleSearchService);

		tasksProvider.afterPropertiesSet();

		return tasksProvider;
	}

}
