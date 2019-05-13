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

import de.hybris.platform.task.impl.AuxiliaryTablesBasedTaskProvider;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.task.impl.AuxiliaryTablesGatewayFactory;

import java.time.Instant;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class SchedulerStateGatewayTest extends BaseGatewayTest
{

	@Resource
	private AuxiliaryTablesGatewayFactory auxiliaryTablesGatewayFactory;

	private SchedulerStateGateway gateway;

	@Before
	public void setUp() throws Exception
	{
		disableTaskEngine();

		gateway = auxiliaryTablesGatewayFactory.getSchedulerStateGateway();

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
	public void insertSchedulerRow()
	{
		final boolean b = gateway.insertSchedulerRow(Instant.now(), AuxiliaryTablesBasedTaskProvider.VERSION);

		assertThat(b).isTrue();
	}

	@Test
	public void updateSchedulerRow()
	{
		final Instant oldTimeStamp = Instant.now().minusSeconds(20);
		final boolean b = gateway.insertSchedulerRow(oldTimeStamp, AuxiliaryTablesBasedTaskProvider.VERSION);
		assertThat(b).isTrue();

		final boolean b1 = gateway.updateSchedulerRow(Instant.now(), oldTimeStamp);
		assertThat(b1).isTrue();
	}

	@Test
	public void getSchedulerTimestamp()
	{
		final Instant oldTimeStamp = Instant.now().minusSeconds(20);
		final boolean b = gateway.insertSchedulerRow(oldTimeStamp, AuxiliaryTablesBasedTaskProvider.VERSION);
		assertThat(b).isTrue();

		final Optional<SchedulerState> schedulerTimestamp = gateway.getSchedulerTimestamp();

		assertThat(schedulerTimestamp).isPresent();
		assertThat(schedulerTimestamp.get().getTimestamp().toInstant()).isEqualTo(oldTimeStamp);
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