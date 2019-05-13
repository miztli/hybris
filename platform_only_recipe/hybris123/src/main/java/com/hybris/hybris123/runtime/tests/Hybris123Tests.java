package com.hybris.hybris123.runtime.tests;
/*
 * © 2017, © 2018 SAP SE or an SAP affiliate company.
 * All rights reserved.
 * Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and
 * notices.
 */

import static com.hybris.hybris123.runtime.helper.SeleniumHelper.addNewCustomConstraint;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.addNewMinConstraint;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.callCurl;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.canLoginToHybrisCommerce;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.checkTestSuiteXMLMatches;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.closeBrowser;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.deleteExistingMinConstraint;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.getMethodName;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.getTitle;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.loginToBackOffice;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.modifyABandToHaveNegativeAlbumSales;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.navigateTo;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.reloadConstraints;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.selectConstraintsPage;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.submitImpexScript;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.tryToViolateTheNewConstraint;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.tryToViolateTheNewCustomConstraint;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitFor;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForConnectionToOpen;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForExtensionListing;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForFlexQueryFieldThenSubmit;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForGroovyWindowThenSubmitScript;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForImageWithTitleThenClick;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForInitToComplete;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForText;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForThenAndClickSpan;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForThenClick;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForThenClickButtonWithText;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForThenClickDotsBySpan;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForThenClickMenuItem;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForThenClickOkInAlertWindow;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForThenDoBackofficeSearch;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForThenUpdateInputField;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForValidImage;
import static com.hybris.hybris123.runtime.helper.SeleniumHelper.waitForValue;

import java.io.IOException;

import javax.annotation.ManagedBean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hybris.hybris123.annotations.Snippet;
import com.hybris.hybris123.runtime.helper.CommandLineHelper;
import com.hybris.hybris123.runtime.helper.FileHelper;
import com.hybris.hybris123.runtime.helper.HsqlDBHelper;
import com.hybris.hybris123.runtime.helper.HttpsHelper;
import com.hybris.hybris123.runtime.helper.LogHelper;
import com.hybris.hybris123.runtime.helper.VersionHelper;
/**
 * These tests check on your progress thru hybris123
 */
@ManagedBean
public class Hybris123Tests {
	private static final Logger LOG = LoggerFactory.getLogger(Hybris123Tests.class);
	private static boolean WAITONFAIL = false;
	
	//xxxPlaceHolderForSeleniumInnerClassForStaticVersionxxx   // Gets replaced by CreateHybris123Pages
	
	@Before
	public void allowHttps(){	
		HttpsHelper.allowHttps();
		VersionHelper.getVersion();
	}
	
	@After
	public void closeSelenium(){		
		try {
			closeBrowser();
		} catch (Exception e) {
			LOG.info("Exception thrown in closeSelenium::closeBrowser"+e);
		}
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testUnzippedOk")
	public void testUnzippedOk() throws Exception {
		assertTrue("The folder structure should be as shown in this method",
			FileHelper.fileExists("../../HYBRISCOMM6*.zip")  && 
			FileHelper.fileExists("../../HYBRISCOMM6*/README") && 
			FileHelper.fileExists("../../HYBRISCOMM6*/hybris123/src/main/java/com/hybris/hybris123/runtime/tests/Hybris123Tests.java")
		);
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testAcceleratorQuickDiveIsOk")
	public void testAcceleratorQuickDiveIsOk() throws Exception {
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/yb2bacceleratorstorefront/?site=powertools&clear=true");
		assertTrue( getTitle().contains("Powertools") );	
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testExtensionCreatedOk")
	public void testExtensionCreatedOk() {
		assertTrue("New constants are not there",
				FileHelper.fileExists("../hybris/bin/custom/concerttours/src/concerttours/constants/ConcerttoursConstants.java"));
		assertTrue("New services are not there",
				FileHelper.fileExists("../hybris/bin/custom/concerttours/src/concerttours/service/ConcerttoursService.java"));
		assertTrue("New default services are not there",
				FileHelper.fileExists("../hybris/bin/custom/concerttours/src/concerttours/service/impl/DefaultConcerttoursService.java"));
		assertTrue("New setup is not there",
				FileHelper.fileExists("../hybris/bin/custom/concerttours/src/concerttours/setup/ConcerttoursSystemSetup.java"));
		assertTrue("New standalone is not there",
				FileHelper.fileExists("../hybris/bin/custom/concerttours/src/concerttours/ConcerttoursStandalone.java"));
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testCodeGeneratedOk")
	public void testCodeGeneratedOk() throws IOException {
		// If you have correctly added an extension there should be some new
		// folders and files
		assertTrue("You should have included concerttours in localextensions.xml",
				FileHelper.fileExistsAndContains("../hybris/config/localextensions.xml", "concerttours"));
		assertTrue("Running ant should have generated some sources for concerttours",
				FileHelper.directoryExists("../hybris/bin/custom/concerttours/gensrc"));
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testExtensionModelOk")
	public void testExtensionModelOk() throws ClassNotFoundException, IOException { 
		assertTrue( "ProductModel has been extended to support Hashtag and Band", 
		FileHelper.fileContains( "../hybris/bin/platform/bootstrap/gensrc/de/hybris/platform/core/model/product/ProductModel.java",
		"getHashtag", "getBand",
		"setHashtag", "setBand") );

		assertTrue( "A new BandModel supports Code, Name, History, AlbumSales", 
		FileHelper.fileContains( "../hybris/bin/platform/bootstrap/gensrc/concerttours/model/BandModel.java",
		"getName","getHistory","getCode", "getAlbumSales",
		"setName","setHistory","setCode", "setAlbumSales") );

		assertTrue( "A new ConcertModel extends VariantProductModel and supports Venue and Date", 
		FileHelper.fileContains( "../hybris/bin/platform/bootstrap/gensrc/concerttours/model/ConcertModel.java",
		"ConcertModel extends VariantProductModel",
		"getVenue","getDate",
		"setVenue","setDate") );

		assertTrue( "The new Band extends GenericItem and supports Code, Name, History, AlbumSales", 
		FileHelper.fileContains( "../hybris/bin/custom/concerttours/gensrc/concerttours/jalo/Band.java",
		"Band extends GenericItem",
		"getName","getHistory","getCode", "getAlbumSales",
		"setName","setHistory","setCode", "setAlbumSales") );

		assertTrue( "The new Concert extends VariantProduct and supports Venue, Date", 
		FileHelper.fileContains( "../hybris/bin/custom/concerttours/gensrc/concerttours/jalo/Concert.java",
		"Concert extends VariantProduct",
		"getVenue","getDate",
		"setVenue","setDate") );
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testDatabaseSetup")
	public void testDatabaseSetup() throws Exception {
		HsqlDBHelper hsqldb = new HsqlDBHelper();
		// Note test will fail if the suite is running on this DB at the same time.
		try {			
			String res = hsqldb.select("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.SYSTEM_COLUMNS WHERE TABLE_NAME NOT LIKE 'SYSTEM_%'");
			assertTrue("Could not find the table BANDS",  res.contains("BANDS")  );
		} catch (Exception e) {
			fail("testDatabaseSetup", "HsqlDBTest failed: " + e.getMessage());
		} finally {
			hsqldb.shutdown();
		}
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_gitRepoOk")
	public void gitRepoOk() {
		CommandLineHelper shellCommands = new CommandLineHelper();
		String output = shellCommands.runCmd("git --git-dir ../hybris/.git log");			
		assertTrue("Git Repo has not been set up correctly", output.contains("Set Up a Git Repository"));
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testServiceLayerClassesExist")
	public void testServiceLayerClassesExist() throws IOException {
		  // If you have correctly added an extension there should be some new folders and files
		  assertTrue("You should have added concerttours.daos.BandDAO.java", FileHelper.fileExistsAndContains(
		      "../hybris/bin/custom/concerttours/src/concerttours/daos/BandDAO.java", "public interface BandDAO"));
		  assertTrue("You should have added concerttours.daos.impl.DefaultBandDAO.java", FileHelper.fileExistsAndContains(
		      "../hybris/bin/custom/concerttours/src/concerttours/daos/impl/DefaultBandDAO.java", "public class DefaultBandDAO implements BandDAO"));
		  assertTrue("You should have modified concerttours-spring.xml", FileHelper.fileExistsAndContains(
		      "../hybris/bin/custom/concerttours/resources/concerttours-spring.xml", "<context:component-scan base-package=\"concerttours\"/>"));
		  assertTrue("You should have added concerttours.service.impl.DefaultBandService.java", FileHelper.fileExistsAndContains(
		      "../hybris/bin/custom/concerttours/src/concerttours/service/impl/DefaultBandService.java", "public class DefaultBandService implements BandService"));
		  assertTrue("You should have added concerttours.service.BandService.java", FileHelper.fileExistsAndContains(
		      "../hybris/bin/custom/concerttours/src/concerttours/service/BandService.java", "public interface BandService"));
		  }

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testBackOffice")
	public void testBackOffice() throws Exception {
		assertTrue( loginToBackOffice() );
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testBackofficeProductListingContainsTheBands")
	public void testBackofficeProductListingContainsTheBands() {
		loginToBackOffice();
		waitForThenClickMenuItem("Catalog");
		waitForThenClickMenuItem("Products");
		assertTrue(waitForText("Grand Tour - Boston"));
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testValidationConstraintViaItemsXml")
	public void testValidationConstraintViaItemsXml() {
		loginToBackOffice();
		waitForThenClickMenuItem("System");
		waitForThenClickMenuItem("Types");		
		waitForThenDoBackofficeSearch("Band");
		waitForThenClick("span","Band"); 
		waitForImageWithTitleThenClick("Search by type");		
		waitForThenDoBackofficeSearch("");
		waitForThenClick("span","The Quiet");
		
		waitForThenUpdateInputField("The Quiet", "The Choir");
		assertTrue( waitForThenClick("button","Save") );
	}
	
	@Test
	public void testCreateValidationConstraintViaBackoffice() {	
		loginToBackOffice();
		selectConstraintsPage();	
		deleteExistingMinConstraint("NewConstraint");				
		addNewMinConstraint("NewConstraint");				
		reloadConstraints();			
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testValidationConstraintViaBackoffice")
	public void testValidationConstraintViaBackoffice() {	
		loginToBackOffice();
		selectConstraintsPage();	
		tryToViolateTheNewConstraint();					
		assertTrue( waitFor("span","Album sales must be > 0. Do pay attention."));
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testValidationCustomConstraint")
	public void testValidationCustomConstraint() {
		loginToBackOffice();
		selectConstraintsPage();	
		deleteExistingMinConstraint("NotIpsum");				
		addNewCustomConstraint("NotIpsum");				
		reloadConstraints();		
		tryToViolateTheNewCustomConstraint();		
		assertTrue( waitFor("span","No Lorem Ipsum"));
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testPropertiesFiles")
	public void testPropertiesFiles() {	
		assertTrue( 
			checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"DefaultBandFacadeIntegrationWithPropertiesTest\" package=\"concerttours.facades.impl\" tests=\"1\"(.*)") );								
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testValidationConstraintAfterImpex")
	public void testValidationConstraintAfterImpex() {
		loginToBackOffice();
		modifyABandToHaveNegativeAlbumSales();
		waitFor("div","You have 1 Validation Errors");
		assertTrue( waitFor("span","Album sales must not be negative"));
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testSuiteIsOnline")
	public void testSuiteIsOnline() {
		assertTrue( canLoginToHybrisCommerce());
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testDynamicAttributeView")
	public void testDynamicAttributeView() throws Exception {		
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/concerttours/bands/A001");
		waitFor("a","The Grand Little x Tour");
		navigateTo("https://localhost:9002/concerttours/tours/201701");
		waitFor("th","Days Until");		
		assertTrue( waitFor("td","0"));				
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testBandImages")
	public void testBandImages() throws Exception {
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/concerttours/bands");
		waitForValidImage();
		navigateTo("https://localhost:9002/concerttours/bands/A006");
		assertTrue( waitForValidImage());		
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_loginAndCheckForConcertToursExtension")
	public void loginAndCheckForConcertToursExtension()  {
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/platform/extensions") ;			
		assertTrue( waitForExtensionListing("concerttours"));
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testNewsEvents")
	public void testNewsEvents()  {		
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/platform/init");			
		waitForThenClickButtonWithText("Initialize");
		waitForThenClickOkInAlertWindow();
		waitForInitToComplete();		
		closeBrowser();
		
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/console/flexsearch");							
		waitForFlexQueryFieldThenSubmit("SELECT {headline} FROM {News}");			
		assertTrue( waitFor("td","New band, Banned"));
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_simulateInitialization")
	public void simulateInitialization() throws Exception {
		canLoginToHybrisCommerce();		
		navigateTo("https://localhost:9002/platform/init");			
		waitForThenClickButtonWithText("Initialize");
		waitForThenClickOkInAlertWindow();
		waitForInitToComplete();		
		closeBrowser();
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_simulateLoadingJobImpex")
	public void simulateLoadingJobImpex() throws Exception {			
		canLoginToHybrisCommerce();		
		String impex = FileHelper.getContents("src/main/webapp/resources/concerttours/resources/script/essentialdataJobs.impex");
		navigateTo("https://localhost:9002/console/impex/import");			
		submitImpexScript(impex);
		waitFor("div","Import finished successfully");	
	}
		
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testSendingNewsMails")
	public void testSendingNewsMails() throws Exception {
		long timeSinceLastMailWasSentMS = LogHelper.getMSSinceLastNewsMailsLogged();
		assertTrue("A log of the last mail sent should have been timestamped recently "+timeSinceLastMailWasSentMS,
				timeSinceLastMailWasSentMS < 5*60*1000);		
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testHookImpex")
	public void testHookImpex() throws Exception {
		canLoginToHybrisCommerce();		
		navigateTo("https://localhost:9002/platform/init");			
		waitForThenClickButtonWithText("Initialize");
		waitForThenClickOkInAlertWindow();
		waitForInitToComplete();		
		long timeSinceHookLogsFound = LogHelper.getMSSinceThisWasLogged("Custom project data loading for the Concerttours extension completed");
		assertTrue("Did not find the expected logs "+ timeSinceHookLogsFound,
				timeSinceHookLogsFound < 10000);		
	}
		
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testHookAndCoC")
	public void testHookAndCoC() throws Exception {
		canLoginToHybrisCommerce();		
		navigateTo("https://localhost:9002/platform/init");			
		waitForThenClickButtonWithText("Initialize");
		waitForThenClickOkInAlertWindow();
		waitForInitToComplete();		
		long timeSinceHookLogsFound = LogHelper.getMSSinceThisWasLogged("importing resource : /impex/projectdata-musictypes.impex");
		assertTrue("Did not find the expected logs",
				timeSinceHookLogsFound < 10000);		
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_simulateManualImpex")
	public void simulateManualImpex() throws Exception {
		String impex = FileHelper.getContents("src/main/webapp/resources/impex/essentialdata-bands.impex");
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/console/impex/import");			
		submitImpexScript(impex);
		waitFor("div","Import finished successfully");			
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testManualImpex")
	public void testManualImpex() throws Exception {
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/console/flexsearch");							
		waitForFlexQueryFieldThenSubmit("SELECT {pk}, {code}, {history} FROM {Band}");			
		assertTrue( waitFor("td","A cappella singing group based in Munich"));		
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testCoCImpex")
	public void testCoCImpex() throws Exception {	
		canLoginToHybrisCommerce();		
		navigateTo("https://localhost:9002/platform/init");			
		waitForThenClickButtonWithText("Initialize");
		waitForThenClickOkInAlertWindow();
		waitForInitToComplete();		
		closeBrowser();
		
		canLoginToHybrisCommerce();		
		navigateTo("https://localhost:9002/console/flexsearch");							
		waitForFlexQueryFieldThenSubmit("SELECT {pk}, {code}, {history} FROM {Band}");			
		assertTrue( waitFor("td","A cappella singing group based in Munich"));		
	}
	
	// See  https://wiki.hybris.com/display/release5/hybris+Testweb+Frontend+-+End+User+Guide
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testServiceLayerIntegrationTest")
	public void testServiceLayerIntegrationTest() throws Exception {
		assertTrue( checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"DefaultBandDAOIntegrationTest\" package=\"concerttours.daos.impl\" tests=\"3\"(.*)" ) &&
					checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"DefaultBandServiceIntegrationTest\" package=\"concerttours.service.impl\" tests=\"3\"(.*)" ));
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testCustomConstraintIntegrationTest")
	public void testCustomConstraintIntegrationTest() {
		assertTrue( checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"NotLoremIpsumConstraintTest\" package=\"concerttours.constraints\" tests=\"1\"(.*)" ));
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testLocalizedServiceLayerTest")
	public void testLocalizedServiceLayerTest() {
		assertTrue( checkTestSuiteXMLMatches("(.*)testsuite errors=\"2\" (.*) name=\"DefaultBandFacadeUnitTest\" package=\"concerttours.facades.impl\" tests=\"2\" (.*)") &&
					checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"DefaultBandServiceUnitTest\" package=\"concerttours.service.impl\" tests=\"2\"(.*)"));				
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testFacadeLayerOk")
	public void testFacadeLayerOk()  {
		assertTrue( checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"DefaultBandFacadeIntegrationTest\" package=\"concerttours.facades.impl\" tests=\"3\"(.*)" ) );
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testIsOnline")
	public void testIsOnline() throws Exception {
		//	Careful = this opens a second selenium..	canLoginToHybrisCommerce();	
		int waitMS= 2000;
		assertTrue( waitForConnectionToOpen("https://localhost:9002/login.jsp", waitMS) );
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testWebAppComponent")
	public void testWebAppComponent() throws Exception {	
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/concerttours/bands");
		waitFor("a","The Quiet");	
		navigateTo("https://localhost:9002/concerttours/bands/A007");
		assertTrue( waitFor("p","English choral society specialising in beautifully arranged, soothing melodies and songs"));		
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testServiceLayerUnitTest")
	public void testServiceLayerUnitTest()  {
		assertTrue( checkTestSuiteXMLMatches("(.*)<testsuite errors=\"0\" failures=\"0\" (.*) name=\"DefaultBandServiceUnitTest\" package=\"concerttours.service.impl\"(.*)" ));
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testDynamicAttributeIntegrationTest")
	public void testDynamicAttributeIntegrationTest()  {
		assertTrue( checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"ConcertDaysUntilAttributeHandlerIntegrationTest\" package=\"concerttours.attributehandlers\" tests=\"3\" (.*)" ));	
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testRESTCalls")
	public void testRESTCalls() throws Exception {
		String response = callCurl("curl", "-k", "-X", "GET", "https://localhost:9002/ws410/rest/bands/yRock", "-H", "authorization: Basic YWRtaW46bmltZGE='");
		assertTrue( "Response should include the bands as XML", response.contains("<band name=\"yRock\""));
		
		response = callCurl("curl", "-k", "-X", "GET", "https://localhost:9002/ws410/rest/bands/yRock", "-H", "accept: application/json", "-H", "authorization: Basic YWRtaW46bmltZGE='");
		assertTrue( "Response should include band details as JSON", response.contains("@name\":\"yRock\",\"@pk\":\"8796093085244\""));
		response = callCurl("curl", "-k", "-X", "PUT", "https://localhost:9002/ws410/rest/bands/yRock", "-H", "authorization: Basic YWRtaW46bmltZGE='", "-H", "content-type: text/xml", "-d", "<band code='A001'><history>The VERY biggest, baddest rock band in software vendor history</history></band>");
		assertTrue("Response should be empty", response.length()==0);
		
		response = callCurl("curl", "-k", "-X", "GET", "https://localhost:9002/ws410/rest/bands/yRock", "-H", "accept: application/json", "-H", "authorization: Basic YWRtaW46bmltZGE='");
		assertTrue( "Response should include band details as JSON", response.contains("\"history\":\"The VERY biggest, baddest rock band in software vendor history\""));

		response = callCurl("curl", "-k", "-X", "PUT", "https://localhost:9002/ws410/rest/cronjobs/sendNewsCronJob?cmd=StartCronJobCommand", "-H", "authorization: Basic YWRtaW46bmltZGE='", "-H", "content-type: text/xml", "-d", "<cronjob code='sendNewsCronJob'/>"  );
		assertTrue("Response should be empty", response.length()==0);
	}

	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testDynamicAttributeUnitTest")
	public void testDynamicAttributeUnitTest()  {
		assertTrue( checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"ConcertDaysUntilAttributeHandlerUnitTest\" package=\"concerttours.attributehandlers\" tests=\"3\" (.*)" ));
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testEventInterceptorIntegrationTest")
	public void testEventInterceptorIntegrationTest() {
		assertTrue( checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"BandAlbumSalesEventListenerIntegrationTest\" package=\"concerttours.events\" tests=\"2\" (.*)" ));
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testAsyncEventInterceptorIntegrationTest")
	public void testAsyncEventInterceptorIntegrationTest()  {
		assertTrue( 
				checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"BandAlbumSalesEventListenerIntegrationTest\" package=\"concerttours.events\" tests=\"2\" (.*)" ) &&
				checkTestSuiteXMLMatches("(.*)testcase classname=\"concerttours.events.BandAlbumSalesEventListenerIntegrationTest\" name=\"testEventSendingAsync\"(.*)"));				
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testSendNewsJobIntegrationTest")
	public void testSendNewsJobIntegrationTest() {
		assertTrue( checkTestSuiteXMLMatches("(.*)testsuite errors=\"0\" failures=\"0\" (.*) name=\"SendNewsJobIntegrationTest\" package=\"concerttours.jobs\" tests=\"2\" (.*)" ));
	}

	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_simulateGroovyScript")
	public void simulateGroovyScript() throws Exception {			
		String groovyScript = FileHelper.getContents("src/main/webapp/resources/concerttours/resources/script/groovyjob.script");
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/console/scripting");							
		waitForGroovyWindowThenSubmitScript(groovyScript);	
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testGroovyScript")
	public void testGroovyScript() throws Exception {			
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/console/flexsearch");							
		waitForFlexQueryFieldThenSubmit("SELECT {p.pk}, {p.code}, {p.name}, {q.code} FROM {Concert AS p}, {ArticleApprovalStatus AS q} WHERE {p.approvalstatus} = {q.pk}");			
		assertTrue( waitForText("check") );
	}
    
	@Test
	public void working() throws Exception{
		try {
			for (int i=0;i<10;i++){
				testBackofficeLocalization();
				closeBrowser();
			}
		} catch (Exception e) {
			Thread.sleep(100000);
		}
	}
	
	@Test
	@Snippet("com.hybris.hybris123.Hybris123Tests_testBackofficeLocalization")
	public void testBackofficeLocalization() {	
		canLoginToHybrisCommerce();
		navigateTo("https://localhost:9002/platform/init");			
		waitForThenClickButtonWithText("Initialize");
		waitForThenClickOkInAlertWindow();
		waitForInitToComplete();	
		closeBrowser();

		loginToBackOffice("Deutsch");
		waitForThenClickMenuItem("System");  
		waitForThenClickMenuItem("Typen");
		waitForThenDoBackofficeSearch("Concert");
		waitForThenAndClickSpan("Concert");
		waitForThenAndClickSpan("Eigenschaften");
		waitForThenClickDotsBySpan("daysUntil");
		waitForThenAndClickSpan("Details bearbeiten", "Edit Details");	 
		assertTrue( waitForValue("input", "Tage bis es stattfindet") );
	}

	private static void assertTrue(boolean condition) {	
		assertTrue(null, condition);
    }
	
	private static void assertTrue(String message, boolean condition) {
		String methodName = getMethodName();
		try{
			org.junit.Assert.assertTrue(message, condition);		
			updateTestStatus( "com.hybris.hybris123.Hybris123Tests_"+methodName, "passed");
		}
		catch(Error e){
			updateTestStatus( "com.hybris.hybris123.Hybris123Tests_"+methodName, "failed");		
			org.junit.Assert.fail(message);
		}
		catch(Exception e){
			updateTestStatus( "com.hybris.hybris123.Hybris123Tests_"+methodName, "failed");		
			org.junit.Assert.fail(message);
		}
	}
	
   public static void fail(String callingMethod, String message) {
	   LOG.debug("In fail "+callingMethod+" "+message);
	   updateTestStatus( "com.hybris.hybris123.Hybris123Tests_"+callingMethod, "failed");
       org.junit.Assert.fail(message);
		try {
			if (WAITONFAIL)
				Thread.sleep(500000);
		} catch (InterruptedException e) {
			LOG.error( e.getMessage() );
		}  
    }

   public static void fail(String callingMethod) {
        fail(callingMethod, null);     
    }

	private static void updateTestStatus(String name, String status){		
		try {
			waitForConnectionToOpen("http://localhost:8080/hybris123/tdd?test=updatelog&testName="+name+"&testStatus="+status, 1000);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}	
	
	public static boolean fileExists(String s){
		return FileHelper.fileExists(s);
	}
	
	public static String runCmd(String s){
		return CommandLineHelper.runCmd(s);
	}
}
