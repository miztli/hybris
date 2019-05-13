/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */


import static de.hybris.platform.orchestration.Orchestration.inWorkDir;
import static de.hybris.platform.orchestration.assertions.DatabaseAssert.assertThat;
import static de.hybris.platform.orchestration.assertions.HacAssert.assertThat;
import static de.hybris.platform.orchestration.status.StatusCheckers.http;
import static de.hybris.platform.orchestration.status.StatusCheckers.jdbc;

import de.hybris.platform.orchestration.Orchestration;
import de.hybris.platform.orchestration.Orchestrator;
import de.hybris.platform.orchestration.assertions.DatabaseAsserter;
import de.hybris.platform.orchestration.assertions.HacInteractionSession;
import de.hybris.platform.orchestration.configuration.InstanceConfiguration;

import org.junit.Test;

import com.spotify.docker.client.exceptions.DockerCertificateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;


public class DbFailureDemoTest
{
	private static final Logger logger = LoggerFactory.getLogger(DbFailureDemoTest.class);
	private static final String DB_VOLUME = "db_" + UUID.randomUUID().toString();
	private static final String HSQL = "hsql_" + UUID.randomUUID().toString();
	private static final String PLATFORM = "platform_" + UUID.randomUUID().toString();

	@Test
	public void shouldLogInAfterDatabaseRestart() throws DockerCertificateException
	{
		logger.info("Executing db failure test on hac!");
		try (final Orchestration orchestration = Orchestration.build())
		{
			final Orchestrator hsql = dbOrchestrator(orchestration);

			hsql.start();
			hsql.assureStarted();

			final Orchestrator adminInit = initOrchestrator(orchestration);

			adminInit.start();
			adminInit.waitForFinish();

			final Orchestrator platform = platformOrchestrator(orchestration);
			platform.start();
			platform.assureStarted();


			final DatabaseAsserter database = DatabaseAsserter.forDb("jdbc:hsqldb:hsql://localhost:" + hsql.getPort("hsqldb") + "/hybris", "hybris", "hybris");
			final HacInteractionSession hac = HacInteractionSession.forUrl("https://localhost:" + platform.getPort("platform") + "/");

			logger.info("Asserting that database is running");
			assertThat(database).isRunning();

			logger.info("Asserting that we can log into hac");
			assertThat(hac).canLogIn();

			logger.info("Killing database");
			hsql.kill();

			logger.info("Asserting that database is not running");
			assertThat(database).isNotRunning();

			logger.info("Asserting that we can not log into hac");
			assertThat(hac).cannotLogIn();

			logger.info("Starting db again");
			hsql.start();
			hsql.assureStarted();

			final DatabaseAsserter dbAfterRestart = DatabaseAsserter.forDb("jdbc:hsqldb:hsql://localhost:" + hsql.getPort("hsqldb") + "/hybris", "hybris", "hybris");

			logger.info("Asserting that database is running");
			assertThat(dbAfterRestart).isRunning();

			logger.info("Asserting that we can log into hac");
			assertThat(hac).canLogIn();
		}
		catch (final Exception ex)
		{
			throw ex;
		}
	}

	public static Orchestrator initOrchestrator(final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage("simple_deployment_platform") //
				.linkContainers(HSQL) //
				.executeCommands("admin", "initialize") //
				.withVolume("/opt/hybris/data/media") //
				.withEnv("y_db_url=jdbc:hsqldb:hsql://" + HSQL + ":9090/hybris;hsqldb.tx=MVCC")
				.instance() //
				.copyDirectory(inWorkDir("/resources/secrets"), "/etc/pki/tls/certs/hybris") //
				.withName(PLATFORM) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}

	public static Orchestrator platformOrchestrator(final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage("simple_deployment_platform") //
				.linkContainers(HSQL) //
				.withVolume("/opt/hybris/data/media") //
				.withEnv("y_db_url=jdbc:hsqldb:hsql://" + HSQL + ":9090/hybris;hsqldb.tx=MVCC")
				.instance() //
				.copyDirectory(inWorkDir("/resources/secrets"), "/etc/pki/tls/certs/hybris") //
				.withName(PLATFORM) //
				.withNamedPort("ajp", 8081) //
				.withNamedPort("platform", 8088)
				.checkStatusVia(http("https://localhost:${platform}/")) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}

	public static Orchestrator dbOrchestrator(final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage("simple_deployment_hsql") //
				.withNamedVolume(DB_VOLUME, "/opt/hsqldb/data") //
				.instance() //
				.withName(HSQL) //
				//.mapPort(9090, 9090) //
				.withNamedPort("hsqldb", 9090) //
				.checkStatusVia(jdbc("jdbc:hsqldb:hsql://localhost:${hsqldb}/hybris", "hybris", "hybris")) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}
}
