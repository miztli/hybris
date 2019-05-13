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
import de.hybris.platform.core.Registry;
import de.hybris.platform.task.constants.TaskConstants;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import org.junit.After;
import org.junit.Before;


@IntegrationTest
public class DefaultTaskServiceNodeGroupsAuxiliaryTablesTasksProviderIntegrationTest
		extends DefaultTaskServiceNodeGroupsIntegrationTest
{

	private final PropertyConfigSwitcher taskPollInterval = new PropertyConfigSwitcher(TaskConstants.Params.POLLING_INTERVAL);

	@Override
	@Before
	public void setUp()
	{
		super.setUp();
		taskPollInterval.switchToValue("1");
	}

	@Override
	@After
	public void tearDown()
	{
		super.tearDown();
		taskPollInterval.switchBackToDefault();
	}

	@Override
	protected TasksProvider getTasksProvider()
	{
		final AuxiliaryTablesGatewayFactory auxiliaryTablesGatewayFactory = Registry.getApplicationContext()
				.getBean("auxiliaryTablesGatewayFactory", AuxiliaryTablesGatewayFactory.class);

		final AuxiliaryTablesSchedulerRole schedulerRole = new AuxiliaryTablesSchedulerRole();
		schedulerRole.setGatewayFactory(auxiliaryTablesGatewayFactory);
		schedulerRole.setMetricRegistry(metricRegistry);
		schedulerRole.setTypeService(typeService);
		schedulerRole.afterPropertiesSet();

		final AuxiliaryTablesWorkerRole workerRole = new AuxiliaryTablesWorkerRole();
		workerRole.setGatewayFactory(auxiliaryTablesGatewayFactory);
		workerRole.setMetricRegistry(metricRegistry);
		workerRole.afterPropertiesSet();

		final AuxiliaryTablesBasedTaskProvider tasksProvider = new AuxiliaryTablesBasedTaskProvider();
		tasksProvider.setAuxiliaryTablesSchedulerRole(schedulerRole);
		tasksProvider.setAuxiliaryTablesWorkerRole(workerRole);

		return tasksProvider;
	}

}
