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

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.task.TaskService;

import java.text.MessageFormat;

import javax.annotation.Resource;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;


public abstract class BaseGatewayTest extends ServicelayerBaseTest
{
	@Resource
	protected TaskService taskService;

	@Resource
	protected JdbcTemplate jdbcTemplate;

	private boolean taskEngineWasRunningBefore;

	protected void disableTaskEngine()
	{
		if (taskService.getEngine().isRunning())
		{
			taskEngineWasRunningBefore = true;
			taskService.getEngine().stop();
		}

		assertThat(taskService.getEngine().isRunning()).isFalse();
	}

	protected void enableTaskEngine()
	{
		if (taskEngineWasRunningBefore)
		{
			taskService.getEngine().start();
		}
	}

	protected void assertTableExists(final String tableName)
	{
		final Pair<Integer, Integer> testInt = jdbcTemplate.queryForObject(
				MessageFormat.format("SELECT 1, COUNT(*) FROM {0}", tableName),
				(resultSet, i) -> Pair.of(resultSet.getInt(1), resultSet.getInt(2)));

		assertThat(testInt).isNotNull();
		assertThat(testInt.getLeft()).isEqualTo(1);
	}

	protected void assertTableNotExists(final String tableName)
	{
		Assertions.assertThatThrownBy(() -> jdbcTemplate.execute(MessageFormat.format("SELECT * FROM {0}", tableName)))
				.isInstanceOf(BadSqlGrammarException.class);
	}
}
