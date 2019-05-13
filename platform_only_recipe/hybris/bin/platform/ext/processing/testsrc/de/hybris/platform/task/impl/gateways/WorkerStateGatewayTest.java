/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 *
 */

package de.hybris.platform.task.impl.gateways;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.task.impl.AuxiliaryTablesGatewayFactory;
import de.hybris.platform.task.impl.gateways.WorkerStateGateway.WorkerState;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.assertj.core.groups.Tuple;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class WorkerStateGatewayTest extends BaseGatewayTest
{

	@Resource
	private AuxiliaryTablesGatewayFactory auxiliaryTablesGatewayFactory;


	private WorkerStateGateway gateway;

	@Before
	public void setUp() throws Exception
	{
		disableTaskEngine();

		gateway = auxiliaryTablesGatewayFactory.getWorkerStateGateway();

		try
		{
			gateway.dropTable();
		}
		catch (final Exception ignore)
		{
		}

		gateway.createTable();

		assertTableExists(gateway.getTableName());
	}

	@After
	public void tearDown() throws Exception
	{
		try
		{
			gateway.dropTable();

		}
		catch (final Exception ignore)
		{
		}
		assertTableNotExists(gateway.getTableName());

		enableTaskEngine();
	}


	@Test
	public void registerAsWorker()
	{
		gateway.registerAsWorker(new WorkerState(0, null, false, null));
	}

	@Test
	public void getInactiveWorkersHealthChecks()
	{
		gateway.getWorkersHealthChecks();
	}

	@Test
	public void getWorkerRangeById()
	{
		gateway.getWorkerRangeById(0);
	}

	@Test
	public void getWorkers()
	{
		final Set<String> nodeGroups = Collections.singleton("testing");
		gateway.registerAsWorker(new WorkerState(0, null, false, nodeGroups));
		final List<WorkerState> workers = gateway.getWorkers();

		assertThat(workers).hasSize(1).extracting(WorkerState::getNodeId, WorkerState::getNodeGroups)
				.containsExactly(Tuple.tuple(0, nodeGroups));
	}

	@Test
	public void updateWorkersRanges()
	{
		gateway.updateWorkersRanges(Maps.newHashMap(0, new WorkerStateGateway.WorkerRange(0, 100)));
	}

	@Test
	public void deleteWorkers()
	{
		gateway.deleteWorkers(Lists.newArrayList(0, 1));
	}

	@Test
	public void shouldReturnTrueIfTableExists()
	{
		assertTableExists(gateway.getTableName());

		final boolean r = gateway.doesTableExist();

		assertThat(r).isTrue();
	}

	@Test
	public void shouldReturnFalseIfTableDoesNotExist()
	{
		gateway.dropTable();
		assertTableNotExists(gateway.getTableName());

		final boolean r = gateway.doesTableExist();

		assertThat(r).isFalse();
	}
}