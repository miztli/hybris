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
import static de.hybris.platform.orchestration.status.StatusCheckers.http;
import static de.hybris.platform.orchestration.status.StatusCheckers.jdbc;
import static org.assertj.core.api.Java6Assertions.assertThat;

import de.hybris.platform.orchestration.Orchestration;
import de.hybris.platform.orchestration.Orchestrator;
import de.hybris.platform.orchestration.assertions.HacInteractionSession;
import de.hybris.platform.orchestration.configuration.InstanceConfiguration;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SessionFailoverHacTest
{
	private static final Logger logger = LoggerFactory.getLogger(SessionFailoverHacTest.class);
	public static final String HAC_URL = "https://localhost";
	public static final int MAX_RETRIES_AFTER_FAILOVER = 10;

	private Orchestrator platform1;
	private Orchestrator platform2;


	@Test
	public void shouldRedirectToDifferentNodeWithoutLoggingOut()
	{
		try (final Orchestration orchestration = Orchestration.build())
		{
			setupScenarioWithLoadBalancerAndTwoNodes(orchestration);

			final HacInteractionSession hac = HacInteractionSession.forUrl(HAC_URL);
			hac.logIn();

			final int cookieNodeId = hac.getNodeIdFromCookie();
			final int hacNodeId = hac.getClusterInfo();

			logger.info("Waiting until session is persisted");
			waitUntilSessionIsPersisted();

			logger.info("Killing platform with cookie node id: " + cookieNodeId);
			killPlatformById(cookieNodeId);

			boolean loggedInAfterFailover = false;
			for (int i = 0; i < MAX_RETRIES_AFTER_FAILOVER; ++i)
			{
				try
				{
					final int nodeId2 = hac.getClusterInfo();
					logger.info("Before was on node {}, and now is on {}", hacNodeId, nodeId2);

					assertThat(hacNodeId).isNotEqualTo(nodeId2);
					loggedInAfterFailover = true;
				}
				catch (final Exception ex)
				{
					// swallow
				}
			}

			logger.info("Succesfully logged in after failover");
			assertThat(loggedInAfterFailover).isTrue();
		}
		catch (final Exception ex)
		{
			throw ex;
		}
	}

	public void setupScenarioWithLoadBalancerAndTwoNodes(final Orchestration orchestration)
	{
		final Orchestrator modClusterDb = configureDatabase(orchestration);
		final Orchestrator modClusterLoadBalancer = configureLoadBalancer(orchestration);

		modClusterDb.start();
		modClusterDb.assureStarted();

		final Orchestrator platformInitializer = configurePlatformInit(orchestration);
		platformInitializer.start();
		platformInitializer.waitForFinish();

		modClusterLoadBalancer.start();
		platform1 = configurePlatformNode1(orchestration);
		platform1.start();

		platform2 = configurePlatformNode2(orchestration);
		platform2.start();

		assureNodesRunningAndWarmedUp(modClusterLoadBalancer);
	}

	private void waitUntilSessionIsPersisted()
	{
		try
		{
			Thread.sleep(20_000);
		}
		catch (final InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private void killPlatformById(final int cookieNodeId)
	{
		if (cookieNodeId == 1)
		{
			platform1.kill();
		}
		else
		{
			platform2.kill();
		}
	}

	private void assureNodesRunningAndWarmedUp(final Orchestrator modClusterLoadBalancer)
	{
		for (int i = 0; i < 10; ++i)
		{
			modClusterLoadBalancer.assureStarted();
		}
	}

	private Orchestrator configurePlatformNode2(final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage("simple_deployment_platform") //
				.withVolume("/opt/hybris/data/media") //
				.withEnv("Y_JVM_ROUTE=2") //
				.withEnv("JVM_ROUTE=2") //
				.withEnv("MOD_CLUSTER_ADDRESS_GROUP=224.0.1.105") //
				.withEnv("MOD_CLUSTER_ADDRESS_PORT=23364")
				.linkContainers("hsql", "load_balancer").executeCommands("hac") //
				.instance() //
				.withName("platform_2") //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}

	private Orchestrator configurePlatformNode1(final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage("simple_deployment_platform") //
				.withVolume("/opt/hybris/data/media") //
				.withEnv("Y_JVM_ROUTE=1") //
				.withEnv("JVM_ROUTE=1") //
				.withEnv("MOD_CLUSTER_ADDRESS_GROUP=224.0.1.105") //
				.withEnv("MOD_CLUSTER_ADDRESS_PORT=23364")
				.linkContainers("hsql", "load_balancer").executeCommands("hac") //
				.instance() //
				.withName("platform_1") //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}

	public static Orchestrator configureDatabase(final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage("simple_deployment_hsql") //
				.withVolume("/opt/hsqldb/data") //
				.instance() //
				.withName("hsql") //
				.mapPort(9090, 9090) //
				.checkStatusVia(jdbc("jdbc:hsqldb:hsql://localhost:9090/hybris", "hybris", "hybris")) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}


	public static Orchestrator configureLoadBalancer(final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage("ybase_load_balancer") //
				.withEnv("HTTPD_LOG_LEVEL=debug")//
				.withEnv("MOD_CLUSTER_ADDRESS_GROUP=224.0.1.105")//
	            .withEnv("MOD_CLUSTER_ADDRESS_PORT=23364")
				.instance() //
				.copyDirectory(inWorkDir("/resources/secrets"), "/etc/httpd/conf/ssl") //
				.withName("load_balancer") //
				.mapPort(80, 80) //
				.mapPort(443, 443) //
				.mapPort(6666, 7777) //
				.checkStatusVia(http("https://localhost:443/", "Remember Login")) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}

	public static Orchestrator configurePlatformInit(final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage("simple_deployment_platform") //
				.withVolume("/opt/hybris/data/media") //
				.linkContainers("hsql") //
				.executeCommands("admin", "initialize") //
				.instance() //
				.withName("platform_admin_init") //
				.mapPort(8088, 8088) //
				.mapPort(8081, 8081) //
				.checkStatusVia(http("https://localhost:8088/")) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}

}
