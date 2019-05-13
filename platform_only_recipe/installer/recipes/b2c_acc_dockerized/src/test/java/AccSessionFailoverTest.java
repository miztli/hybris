import static de.hybris.platform.orchestration.Orchestration.inWorkDir;
import static de.hybris.platform.orchestration.status.StatusCheckers.http;
import static de.hybris.platform.orchestration.status.StatusCheckers.jdbc;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hybris.platform.orchestration.Orchestration;
import de.hybris.platform.orchestration.Orchestrator;
import de.hybris.platform.orchestration.configuration.InstanceConfiguration;
import okhttp3.Response;

public class AccSessionFailoverTest {
	private static final Logger logger = LoggerFactory.getLogger(AccSessionFailoverTest.class);

	public static final String SITE = "electronics";
	public static final String LANGUAGE = "en";
	public static final String USERNAME = "john.doe@hybris.com";
	public static final String PASSWORD = "12341234";
	
	public static final String DEPLOYMENT_NAME = "b2cacc_deployment";
	private static final String RANDOM_UUID = UUID.randomUUID().toString();
	
	private static final String DB_VOLUME = "db_" + RANDOM_UUID;
	private static final String SOLR_VOLUME = "solr_" + RANDOM_UUID;
	private static final String HSQL = "hsql_" + RANDOM_UUID;
	private static final String LOAD_BALANCER = "load_balancer_" + RANDOM_UUID;
	private static final String SOLR = "solr_" + RANDOM_UUID;
	private static final String PLATFORM = "platform_" + RANDOM_UUID;
	private static final String PLATFORM_INIT = "platform_init_" + RANDOM_UUID;	
	private static final String PLATFORM_IMPEX = "platform_impex_" + RANDOM_UUID;
	
	public static final int MAX_RETRIES_AFTER_FAILOVER = 10;

	private Map<String, Orchestrator> platforms = new HashMap<>();
	private Orchestrator loadBalancer;

	@Test
	public void shouldRedirectToDifferentNodeWithoutLoggingOut()
	{
		try (final Orchestration orchestration = Orchestration.build())
		{
			setupScenarioWithLoadBalancerAndTwoNodes(orchestration);

			String acceleratorUrl = "https://localhost:" + loadBalancer.getPort("https") + "/yacceleratorstorefront";
			
			logger.info("Trying to login to Accelerator");
			AccInteractionSession session = AccInteractionSession.forUrl(acceleratorUrl, SITE, LANGUAGE, USERNAME, PASSWORD);
			session.logIn();

			logger.info("Getting node name and session id");
			final String nodeName = session.getNodeNameFromCookie("/yacceleratorstorefront");
			final String sessionIdBeforeKill = session.getCookie("JSESSIONID", "/yacceleratorstorefront");

			logger.info("Waiting until session is persisted");
			waitUntilSessionIsPersisted();

			logger.info("Killing platform with cookie node id: " + nodeName);
			killPlatformByNodeName(nodeName);

			logger.info("Trying to connect few times to my-account page");
			// try few times
			Response resp2 = null;
			for (int i = 0; i < MAX_RETRIES_AFTER_FAILOVER; ++i)
			{
				try {
					resp2 = session.getSubPage("my-account");
					if (resp2.isSuccessful()) {
						break;
					}
				}
				catch (Exception e) {
					// ignore
				}
			}
			// user should be still logged
			Assert.assertTrue(!resp2.isRedirect());

			// session ID should be the same
			final String sessionIdAfterKill = session.getCookie("JSESSIONID", "/yacceleratorstorefront");
			Assert.assertTrue(sessionIdBeforeKill.equals(sessionIdAfterKill));
		}
		catch (final Exception ex)
		{
			throw ex;
		}
	}

	public void setupScenarioWithLoadBalancerAndTwoNodes(final Orchestration orchestration)
	{
		final Orchestrator databaseOrchestrator = configureDatabase(orchestration);
		logger.info("Starting database container");
		databaseOrchestrator.start();
		databaseOrchestrator.assureStarted();
		logger.info("Database container fully started");
		
		loadBalancer = configureLoadBalancer(orchestration);
		logger.info("Starting load balancer container");
		loadBalancer.start();
		logger.info("Load balancer container fully started");

		final Orchestrator solrOrchestrator = configureSolr(orchestration);
		logger.info("Starting solr container");
		solrOrchestrator.start();
		solrOrchestrator.assureStarted();
		logger.info("Solr container fully started");

		final Orchestrator platformInitializer = configurePlatformInit(orchestration);
		logger.info("Starting initialization container");
		platformInitializer.start();
		logger.info("Waiting for initialization to finish");
		platformInitializer.waitForFinish(10000, 360);
		logger.info("Initialization container finished");

		final Orchestrator importImpexOrchestrator = importImpex(orchestration);
		logger.info("Starting impex importer");
		importImpexOrchestrator.start();
		logger.info("Waiting for impex importer to finish");		
		importImpexOrchestrator.waitForFinish();

		logger.info("Running storefront container 1");
		Orchestrator platform1 = configureStorefrontNode("node1", orchestration);		
		platform1.start();
		platforms.put("node1", platform1);

		logger.info("Running storefront container 2");
		Orchestrator platform2 = configureStorefrontNode("node2", orchestration);		
		platform2.start();
		platforms.put("node2", platform2);
		
		logger.info("Warming up storefront nodes");
		assureNodesRunningAndWarmedUp(loadBalancer);
		logger.info("Test preparation finished");
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

	private void killPlatformByNodeName(final String nodeName)
	{
		Orchestrator platform = platforms.get(nodeName);
		platform.kill();
	}

	private void assureNodesRunningAndWarmedUp(final Orchestrator loadBalancer)
	{
		for (int i = 0; i < 10; ++i)
		{
			loadBalancer.assureStarted();
		}
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
				.withName(LOAD_BALANCER) //
				.withNamedPort("http", 80) //
				.withNamedPort("https", 443) //
				.withNamedPort("modCluster", 6666) //
				.checkStatusVia(http("https://localhost:${https}/yacceleratorstorefront?site=electronics")) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}

	private Orchestrator configureStorefrontNode(final String nodeName, final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage(DEPLOYMENT_NAME + "_platform") //
				.withVolume("/opt/hybris/data/media") //
				.withEnv("y_db_url=jdbc:hsqldb:hsql://" + HSQL + ":9090/hybris;hsqldb.tx=MVCC") //
				.withEnv("y_jvm_route="+nodeName) //
				.withEnv("JVM_ROUTE="+nodeName) //
				.withEnv("MOD_CLUSTER_ADDRESS_GROUP=224.0.1.105") //
				.withEnv("MOD_CLUSTER_ADDRESS_PORT=23364")
				.withEnv("y_solr_config_Default_urls=http://" + SOLR + ":8983/solr")
				.withEnv("y_solr_config_Default_mode=standalone")
				.withEnv("y_solr_server_mode=standalone")
				.withEnv("y_solrserver_instances_default_autostart=false")
				.linkContainers(HSQL, LOAD_BALANCER, SOLR) //
				.executeCommands("accstorefront") //
				.instance() //
				.withName(PLATFORM + nodeName) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}
	
	public static Orchestrator configurePlatformInit(final Orchestration orchestration)
	{
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage(DEPLOYMENT_NAME + "_platform") //
				.withVolume("/opt/hybris/data/media") //
				.withEnv("y_db_url=jdbc:hsqldb:hsql://" + HSQL + ":9090/hybris;hsqldb.tx=MVCC") //
				.withEnv("y_solr_config_Default_urls=http://" + SOLR + ":8983/solr")
				.withEnv("y_solr_config_Default_mode=standalone")
				.withEnv("y_solr_server_mode=standalone")
				.withEnv("y_solrserver_instances_default_autostart=false")
				.linkContainers(HSQL, SOLR) //
				.executeCommands("admin", "initialize") //
				.instance() //
				.withName(PLATFORM_INIT) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}

	
	public static Orchestrator importImpex(final Orchestration orchestration) {
		
		ClassLoader classLoader = Orchestrator.class.getClassLoader();
		File impexDir = new File(classLoader.getResource("import/testData.impex").getFile()).getParentFile();
		String impexPath = impexDir.getAbsolutePath();
		
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage(DEPLOYMENT_NAME + "_platform") //
				.linkContainers(HSQL) //
				.executeCommands("admin", "importImpex", "-Dresource=/tmp/import/testData.impex") //
				.withVolume("/opt/hybris/data/media") //
				.withEnv("y_db_url=jdbc:hsqldb:hsql://" + HSQL + ":9090/hybris;hsqldb.tx=MVCC") //
				.instance() //
				.copyDirectory(impexPath, "/tmp/import") //
				.withName(PLATFORM_IMPEX) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}

	public static Orchestrator configureDatabase(final Orchestration orchestration) {
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage(DEPLOYMENT_NAME + "_hsql") //
				.withNamedVolume(DB_VOLUME, "/opt/hsqldb/data") //
				.instance() //
				.withName(HSQL) //
				.withNamedPort("hsqldb", 9090) //
				.checkStatusVia(jdbc("jdbc:hsqldb:hsql://localhost:${hsqldb}/hybris", "hybris", "hybris")) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}
	
	public static Orchestrator configureSolr(final Orchestration orchestration) {
		final InstanceConfiguration configuration = orchestration.container() //
				.fromImage("ybase_solr") //
				.withNamedVolume(SOLR_VOLUME, "/opt/solr/server/solr/cores") //
				.executeCommands("default") //
				.instance() //
				.withName(SOLR) //
				.withNamedPort("solr", 8983) //
				.checkStatusVia(http("http://localhost:${solr}/solr")) //
				.configure();

		return orchestration.onLocalDocker(configuration);
	}
}
