package com.hybris.hybris123.runtime.helper;
/*
 * © 2017 SAP SE or an SAP affiliate company.
 * All rights reserved.
 * Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and
 * notices.
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hybris.hybris123.runtime.tests.Hybris123Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumHelper {
	private static final Logger LOG = LoggerFactory.getLogger(SeleniumHelper.class);
	private static WebDriver dvr = null;		
	
	private static final String yUSERNAME="admin";
	private static final String yPASSWORD="nimda";

	private static Wait<WebDriver> wait;
	private static Wait<WebDriver> longWait;	
	private static int PAUSE_MS = 2000;
	private static int PAUSE_FOR_SERVER_START_MS  = 120000;
	private static int PAUSE_BETWEEN_KEYS_MS = 50;
	 
	private static int NORMAL_WAIT_S = 10;
	private static int LONG_WAIT_S = 240;
	private static int POLLING_RATE_S = 2;
	private static boolean WINDOWS = (System.getProperty("os.name")!=null)? System.getProperty("os.name").toLowerCase().contains("windows") : false;
	private static boolean OSX = (System.getProperty("os.name")!=null)? System.getProperty("os.name").toLowerCase().contains("mac") : false;
	

	public static boolean canLoginToHybrisCommerce()  {		
		try {
			waitForConnectionToOpen("https://localhost:9002/login.jsp", PAUSE_FOR_SERVER_START_MS);
			getDriver().get("https://localhost:9002/login.jsp");
			pauseMS();
			WebElement usernameElem = findElement(By.name("j_username"));
			WebElement passwordElem = findElement(By.name("j_password"));

			clearField(usernameElem);
			usernameElem.sendKeys(yUSERNAME);		
			clearField(passwordElem);	
			passwordElem.sendKeys(yPASSWORD);
			pauseMS();
			passwordElem.submit();
			Assert.assertTrue(waitFor("div", "Memory overview"));
			return true;
		} catch (Exception e) {
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			String callingMethod = stackTraceElements[2].getMethodName();						
			Hybris123Tests.fail(callingMethod, "Connect Exception: " + e.getMessage());
		}		
		return false;
	}
	
	public static boolean loginToBackOffice(String ... language) {
		try {
			pauseMS(PAUSE_MS);
			// Allow time for server to start
			waitForConnectionToOpen("https://localhost:9002/backoffice", PAUSE_FOR_SERVER_START_MS);
			getDriver().get("https://localhost:9002/backoffice");			
			if (language.length == 0){
				Select s = new Select(findElement(By.xpath("//select")));
				s.selectByVisibleText("English");					
			}
			if (language.length == 1){
				Select s = new Select(findElement(By.xpath("//select")));
				s.selectByVisibleText(language[0]);	
			}
			pauseMS(PAUSE_MS);
			
			WebElement un = findElement(By.name("j_username"));
			clearField(un, yUSERNAME + Keys.TAB);	
			
			WebElement pwd = findElement(By.name("j_password"));
			clearField(pwd, yPASSWORD + Keys.TAB);	
			pauseMS(PAUSE_MS);		
			pwd.submit();
			return true;
		} catch (Exception e) {
			String callingMethod =Thread.currentThread().getStackTrace()[2].getMethodName();						
			Hybris123Tests.fail(callingMethod, "Connect Exception");
		}	
		return false;
	}
	
	private static void waitForThenDoBackofficeSearch(String search, String xp) {
		waitUntilElement(By.xpath(xp));
		pauseMS(PAUSE_MS);
		sendKeysSlowly(findElement(By.xpath(xp)), search+Keys.RETURN);			
		waitUntilElement(By.xpath("//button[contains(@class, 'yw-textsearch-searchbutton')]"));
		pauseMS(PAUSE_MS);		
		scrollToThenClick( findElement(By.xpath(xp)));			
	}	
	
	public static void waitForThenDoBackofficeSearch(String search){
		pauseMS(PAUSE_MS);
		if (VersionHelper.is60()) {
			if (search.length()==0) {// 6.0 Default search does not work; need to expand it like this			
				waitForthenScrollToThenClick("//button[contains(@class, 'yw-toggle-advanced-search')]");
				pauseMS(PAUSE_MS);
				waitForthenScrollToThenClick("//button[contains(@class, 'yw-textsearch-searchbutton')]");
			}		
			else
				waitForThenDoBackofficeSearch(search, "//input[contains(@class, 'yw-textsearch-searchbox')]");
		}	
		else
			waitForThenDoBackofficeSearch(search, "//input[contains(@class, 'z-bandbox-input')]");
		pauseMS(PAUSE_MS);
	}

	private static void waitForthenScrollToThenClick(String xpath) {
		WebElement we = waitUntilElement(By.xpath(xpath));
		scrollToThenClick(we);		
	}
	
	private static void scrollToThenClick(WebElement e) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", e);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {} 
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", e);
	}
	
	public static WebElement waitUntilElement(By by) {
		return wait.until((WebDriver webDriver) -> findElement(by));
	}
	
	public static List<WebElement> waitUntilElements(By by) {
		return wait.until((WebDriver webDriver) -> findElements(by));
	}
	
	public static void waitForThenClickOkInAlertWindow() {
		longWait.until(ExpectedConditions.alertIsPresent());
		getDriver().switchTo().alert().accept();
	}
	
	public static WebElement waitForConstraintsMenu(){
		try {
			wait.until((WebDriver webDriver) -> findElements(By.xpath("//span[@class='z-tree-icon']")).size() == 3);	
		} catch(Exception e){
			// 6.1 and before requires clicking an extra top level menu entry "Constraint"
			waitForthenScrollToThenClick("//span[@class='z-tree-icon']");			
			wait.until((WebDriver webDriver) -> findElements(By.xpath("//span[@class='z-tree-icon']")).size() == 3);	
		}		
		List<WebElement> we = findElements(By.xpath("//span[@class='z-tree-icon']"));
		scrollToThenClick(we.get(1));
		return we.get(1);		
	}
	
	public static void waitForTagXWithAttributeYWithValueZThenClick( String tag, String att, String value){
		try {
			pauseMS(PAUSE_MS);		
			waitForthenScrollToThenClick("//"+tag+"[@"+att+"='"+value+"']");
		} catch(Exception e) {
			LOG.error(e.getMessage());
		}		
	}
	
	public static WebElement findElement(By by) {
		return getDriver().findElement(by);
	}
	
	public static List<WebElement> findElements(By by) {
		return getDriver().findElements(by);
	}
	
	public static void waitForGroovyWindowThenSubmitScript(String gs) {
		// Rollback to Commit
		pauseMS(2000);
		waitForthenScrollToThenClick("//label[@for='commitCheckbox']");
		WebElement queryInput = waitUntilElement(By.xpath("//div[contains(@class, 'CodeMirror')]"));
		pauseMS(2000);
		JavascriptExecutor js = (JavascriptExecutor) dvr;
		
		gs = gs.replaceAll("\\n", "\\\\"+"n");	

		js.executeScript("arguments[0].CodeMirror.setValue('"+gs+"');", queryInput);
		// Note some users have noted that they need the following line instead of the previous one
		//js.executeScript("arguments[0].CodeMirror.setValue(\""+gs+"\");", queryInput);
		
		waitForthenScrollToThenClick("//button[@id='executeButton']");
		pauseMS(4000);

	}
	
	public static void waitForFlexQueryFieldThenSubmit(String fq) {		
		WebElement localSel = waitUntilElement(By.id("locale1"));
		new Select(localSel).selectByVisibleText("en");

		WebElement queryInput = waitUntilElement(By.xpath("//div[contains(@class, 'CodeMirror')]"));
		JavascriptExecutor js = (JavascriptExecutor) dvr;
		js.executeScript("arguments[0].CodeMirror.setValue('"+fq+"');", queryInput);
		scrollToThenClick(findElement(By.xpath("//button[@id='buttonSubmit1']")));		
		pauseMS(PAUSE_MS);
		scrollToThenClick(findElement(By.xpath("//a[@id='nav-tab-3']")));	
	}	
	
	public static boolean waitForText(String text) {
		wait.until(webDriver -> webDriver.findElement(By.tagName("body")).getText().contains(text));
		return true;
	}
	
	public  static boolean waitFor(String tag, String text) {
		try {
			waitUntilElement(By.xpath("//"+tag+"[text()='"+text+"']"));
			return true;
		}
		catch(Exception e) {
			if (text.equals("Import finished successfully")) {
				waitUntilElement(By.xpath("//"+tag+"[text()='Import wurde erfolgreich abgeschlossen']"));
				return true;
			}
			throw new NoSuchElementException("Text not found in  waitFor: "+text);
		}	
	}
	
	public static boolean waitForTagContaining(String tag, String text) {
		waitUntilElement(By.xpath("//"+tag+"[contains(text(),'"+text+"')]"));
		return true;
	}

	public static boolean waitForImageWithTitleThenClick(String title) {
		waitForthenScrollToThenClick("//img[@title='"+title+"']");
		return true;
	}
	
	public static boolean waitForValidImage() {
		wait.until(webDriver -> !findElements(By.tagName("img")).isEmpty());
		String src = findElements(By.tagName("img")).get(0).getAttribute("src");
		return src.contains("media");
	}
	
	public static boolean waitForThenUpdateInputField(String from, String to) {
		WebElement e = waitUntilElement(By.xpath("//input[@value='"+from+"']"));
		clearField(e);
		
		sendKeysSlowly(e, to);
		e.sendKeys(Keys.RETURN);
		return true;
	}

	
	public static boolean waitForThenClick(String tag, String text) {		
		pauseMS(PAUSE_MS);
		try {
			waitForthenScrollToThenClick("//"+tag+"[text()='"+text+"']");
		}
		catch(Exception e) {
			LOG.debug("Not found " +"//"+tag+"[text()='"+text+"']. If 6.2 or eariler and span, will try for div");
		}

		if (tag.equals("span") && VersionHelper.is60() || VersionHelper.is61() || VersionHelper.is62()){
			try {
				waitForthenScrollToThenClick("//div[text()='"+text+"']");	
			}
			catch(Exception e) {
				LOG.debug("Not found " +"//div[text()='"+text+"']");
			}	
		}
		return true;
	}
	
	public static boolean waitForValue(String tag, String text) {
		waitUntilElement(By.xpath("//"+tag+"[@value='"+text+"']"));		
		return true;
	}
	
	public static Boolean waitForExtensionListing(String extensionName){	
		return waitUntilElement(By.xpath("//td[@data-extensionname='"+extensionName+"']")) != null;
	}

	public static void waitForThenClickMenuItem(String menuItem) {
		pauseMS(PAUSE_MS);
		waitUntilElement(By.xpath("//tr[@title='" + menuItem + "']"));
		pauseMS(PAUSE_MS);		
		waitForthenScrollToThenClick("//span[text()='" + menuItem + "']");
		pauseMS(PAUSE_MS);
	}
	
	public static void waitForThenClickDotsBySpan(String text) {
		pauseMS(PAUSE_MS);
		try {
			waitFor("span",text);		
		}
		catch(Exception e) { // 6.2, 6.1 expect a div rather than a span
			waitFor("div",text);				
		}			
		WebElement dots = findElements(By.xpath("//td[contains(@class, 'ye-actiondots')]")).get(2);
		scrollToThenClick(dots);		
	}
	
	public static void waitForThenAndClickSpan(final String spanText) { // For 6.2 Divs versus Spans
		pauseMS(PAUSE_MS);
		try {
			waitForthenScrollToThenClick("//span[text()='" + spanText + "']");
		}
		catch(Exception e) {
			if (spanText.equals("Concert")) {// 6.2 expects div with Konzert rather than span with Concert
				waitForthenScrollToThenClick("//div[text()='Konzert']");
			}
			else {
				waitForthenScrollToThenClick("//div[text()='" + spanText + "']");
			}
		}
	}
	
	public static void waitForThenAndClickSpan(String spanText, String ... spanOptionalText) {
		pauseMS(PAUSE_MS);
		try {
			waitForthenScrollToThenClick("//span[text()='" + spanText + "']");
		}
		catch(Exception e){
			if (spanOptionalText!=null){
				waitForthenScrollToThenClick("//span[text()='" + spanText + "'] | //span[text()='" + spanOptionalText[0] + "'] ");
			}
		}
	}
	
	public static void waitForThenAndClickDiv(String divText, String ... divOptionalText) {
		pauseMS(PAUSE_MS);
		try {
			waitForthenScrollToThenClick("//div[text()='" + divText + "']");
		}
		catch(Exception e){
			if (divOptionalText!=null){
				waitForthenScrollToThenClick("//div[text()='" + divText + "'] | //div[text()='" + divOptionalText[0] + "'] ");
			}
		}
	}
	
	public static void waitForThenClickButtonWithText(String buttonText) {
		pauseMS(PAUSE_MS);
		waitForthenScrollToThenClick("//button[text()='" + buttonText + "']");
	}
	
	public static void waitForInitToComplete() {
		// on some machines the focus is on the search box and fails the test
		hideElement(By.id("searchsuggest"));
		pauseMS(PAUSE_MS * 2);
		scrollToBottom();
		longWait.until(webDriver -> findElement(By.xpath("//a[text()='Continue...']")));
		scrollToBottom();
		scrollToThenClick(findElement(By.xpath("//a[text()='Continue...']")));
	}

	private static void scrollToBottom() {
		int count = 4;
		for (int i = 0; i < count; i++) {
			 new Actions(getDriver()).sendKeys(Keys.PAGE_DOWN).perform();
			 pauseMS(100);
		 }
	}
	public static void waitForNoificationToClose() {
		pauseMS();
	}
	
	public static void waitForAllInputFields(int n) {
		wait.until(webDriver -> findElements(By.xpath("//input[@type='text']")).size()>=n );
		pauseMS(PAUSE_MS);
	}


	public static  void navigateTo(String url) {
		getDriver().navigate().to(url);
		pauseMS(PAUSE_MS);
	}

	public static String getTitle() {
		return getDriver().getTitle();
	}
	
	public static String getXMLFromPage(String page) {
		navigateTo(page);	
		String content = getDriver().getPageSource();
		content = content.replaceAll("\n", "");
		return content;
	}
	
	public static void submitImpexScript(String impex) {
		WebElement queryInput = findElement(By.xpath("//div[contains(@class, 'CodeMirror')]"));
		JavascriptExecutor js = (JavascriptExecutor) dvr;
		impex = impex.replaceAll("\\n", "\\\\n");
		js.executeScript("arguments[0].CodeMirror.setValue('"+impex+"');", queryInput);
	
		try {
			waitForthenScrollToThenClick("//input[@value='Import content']");
			return;
		}
		catch (Exception e) {
			waitForthenScrollToThenClick("//input[@value='Inhalt importieren']");
		}
	}	
	


	public static void setDriver(WebDriver wd) {
		dvr = wd;
	}


	public static WebDriver peakDriver() {
		return dvr;
	}
	
	private static int parseString(String s) {
		try {
			return Integer.parseInt(s);
		}
		catch (Exception e) {
			return -1;
		}
	}
	
	public static WebDriver getDriver() {
		if (dvr != null)
			return dvr;

		
		LOG.debug("In getdriver");
		WebDriverManager.chromedriver().targetPath("resources/selenium").setup();
		
		// add --no-sandbox to prevent unknown WebDriver error
		List<String> optionArguments = new ArrayList<>();
		optionArguments.add("window-size=1044,784");
		optionArguments.add("--disable-gpu");
		optionArguments.add("--disable-browser-side-navigation");
        optionArguments.add("--headless");
        optionArguments.add("--disable-dev-shm-usage");
        optionArguments.add("--no-sandbox");
        optionArguments.add("--allow-insecure-localhost");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(optionArguments);
		chromeOptions = chromeOptions.setAcceptInsecureCerts(true);
		
		if (WINDOWS) {
			dvr = new ChromeDriver(chromeOptions);
		} else {
			int seleniumPort = parseString( System.getProperty("selenium.port") );
			if (seleniumPort!=-1){
				LOG.debug("Opening chromedriver on port" + seleniumPort);			
				ChromeDriverService cds = 
						new ChromeDriverService.Builder().usingDriverExecutable(
						new File( "./chromedriver"))
		                .usingPort(seleniumPort)
		                .build();
				
				dvr = new ChromeDriver(cds, chromeOptions);
			}
			else {
				dvr = new ChromeDriver(chromeOptions);
			}
		}
		
		wait = new FluentWait<WebDriver>(dvr)
				.withTimeout(Duration.ofSeconds(NORMAL_WAIT_S))
				.pollingEvery(Duration.ofSeconds(POLLING_RATE_S))
				.ignoring(NoSuchElementException.class);
		
		longWait = new FluentWait<WebDriver>(dvr)
				.withTimeout(Duration.ofSeconds(LONG_WAIT_S))
				.pollingEvery(Duration.ofSeconds(POLLING_RATE_S))
				.ignoring(NoSuchElementException.class);

		return dvr;
	}

	public static boolean checkTestSuiteXMLMatches(String s){
		try {
			String fileContents = FileHelper.getContents("../hybris/log/junit/TESTS-TestSuites.xml").replace("\n", "").replace("\r", "");
			boolean match = fileContents.matches(s);
			if (!match)
				System.out.println("checkTestSuiteXMLMatches failed: " + fileContents);
			return match;
		} catch (IOException e) {
			Hybris123Tests.fail("Regex not found:" + s);
		}	
		return false;
	}
	
	public static String callCurl(String... curl) {
		byte[] bytes = new byte[100];
	    StringBuffer response = new StringBuffer();
	    try {
			ProcessBuilder pb = new ProcessBuilder(curl);
		    Process p = pb.start();			
		    InputStream is = p.getInputStream();
		    BufferedInputStream bis = new BufferedInputStream(is);
		    while (bis.read(bytes, 0, 100) != -1) {
		    	for (byte b : bytes) {
			        response.append((char)b);
			    }
		        Arrays.fill(bytes, (byte) 0);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response.toString();
	}
	
	public static String getMethodName() {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		int i = 2;
		while (!ste[i].getMethodName().startsWith("test") && 
				!ste[i].getMethodName().startsWith("gitRepoOk") && 
				!ste[i].getMethodName().startsWith("loginAndCheckForConcertToursExtension"))
			i++;
		return  ste[i].getMethodName();  
	}
	
	public static void modifyABandToHaveNegativeAlbumSales() {
		waitForThenClickMenuItem("System");
		waitForThenClickMenuItem("Types");		
		waitForThenDoBackofficeSearch("Band");
		waitForThenClick("span","Band");  // 6.2 expects div
		waitForImageWithTitleThenClick("Search by type");
		waitForThenDoBackofficeSearch(""); // 6.2
		waitForThenClick("span","The Quiet");// 6.2 expects div
		waitForThenUpdateInputField("1200", "-1200");
		waitForThenClick("button","Save");
	}

	public static void tryToViolateTheNewConstraint() {
		waitForThenClickMenuItem("Types");		
		waitForThenDoBackofficeSearch("Band");
		waitForThenClick("span","Band");// 6.2 expects div
		waitForImageWithTitleThenClick("Search by type");
		waitForThenDoBackofficeSearch(""); // 6.2
		waitForThenClick("span","The Quiet"); // 6.2 expects div
		waitForThenUpdateInputField("1200", "-1200");
		waitForThenClick("button","Save");
		waitFor("div","You have 1 Validation Errors");
	}
	
	public static void tryToViolateTheNewCustomConstraint() {
		waitForThenClickMenuItem("Types");		
		waitForThenDoBackofficeSearch("Band"+Keys.RETURN);
		waitForThenClick("span","Band");// 6.2 expects div
		waitForImageWithTitleThenClick("Search by type");
		waitForThenDoBackofficeSearch("");//6.2
		waitForThenClick("span","The Quiet");// 6.2 expects div
		waitForThenUpdateInputField("English choral society specialising in beautifully arranged, soothing melodies and songs", "Lorem Ipsum"+Keys.RETURN);
		waitForThenClick("button","Save");
		waitFor("div","You have 1 Validation Errors");
	}
	
	public static void reloadConstraints() {
		waitForThenClickMenuItem("Constraints");		
		waitForTagXWithAttributeYWithValueZThenClick("img","title","Reload validation engine");
		waitForThenClick("button","Yes");
		pauseMS();
	}

	public static void pauseMS(long ... pause) {
		try {
			if (pause.length==0)
				Thread.sleep(6000);
			else
				Thread.sleep(pause[0]);				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	private static void clearField(WebElement elem) {
		clearField(elem, "");
	}
	 
	
	private static void sendKeysSlowly(WebElement elem, String input) {
		for (int i = 0; i < input.length(); i++) {
		    elem.sendKeys(input.charAt(i) + "");	
			pauseMS(PAUSE_BETWEEN_KEYS_MS);
		}
	}
	private static void clearField(WebElement elem, String newInput) {
		elem.clear();
		pauseMS(PAUSE_BETWEEN_KEYS_MS);
		elem.sendKeys(newInput);
	}
	
	public static void addNewMinConstraint(String id) {
		if (VersionHelper.is61() || VersionHelper.is60()) {
			addNewMinConstraint61(id);
			return;
		}
		
		waitForTagXWithAttributeYWithValueZThenClick("a","class","ya-create-type-selector-button z-toolbarbutton");
		waitForConstraintsMenu();			
		waitForTagXWithAttributeYWithValueZThenClick("tr","title","Min constraint");
		waitForAllInputFields(20);
		
		WebElement idInputField = findElements(By.xpath("//span[text()='ID:']/following::input[1]")).get(0);	
		clearField(idInputField, id);
		
		WebElement minimalValueField = findElements(By.xpath("//span[text()='Minimal value:']/following::input[1]")).get(0);	
		clearField(minimalValueField, "0");
				
		WebElement dots = waitUntilElements(By.xpath("//span[text()='Enclosing Type:' or text()='Composed type to validate:']/following::i[1]")).get(0);	
		scrollToThenClick(dots);
		pauseMS(PAUSE_MS);		
		WebElement identifierField = waitUntilElements(By.xpath("//span[text()='Identifier']/following::input[2]")).get(0);	
		identifierField.sendKeys("Band"+Keys.RETURN);
		waitForThenClick("span","Band");// 6.2 expects div
		waitForThenClick("button","Select (1)");	
		pauseMS(PAUSE_MS);
		
		WebElement attributeDescField = findElements(By.xpath("//span[text()='Attribute descriptor to validate:']/following::input[1]")).get(0);			
		sendKeysSlowly(attributeDescField, "album sales");
		attributeDescField.sendKeys(Keys.DOWN);		
		
		waitForThenClick("span","Band [Band] -> album sales [albumSales]");
		scrollToBottom();
		waitForThenClick("button","Done");
		waitForNoificationToClose();
		
		// Add a message to the the new min constraint
		waitForThenDoBackofficeSearch(id);
		waitForThenClick("span", id);// 6.2 expects div
		waitForTagXWithAttributeYWithValueZThenClick("button","class","yw-expandCollapse z-button");
		pauseMS(PAUSE_MS);
		
		WebElement errorMessageField = findElements(By.xpath("//div[text()='Is used in the following constraint groups']/preceding::input[1]")).get(0);			
		sendKeysSlowly(errorMessageField, "Album sales must be > 0. Do pay attention."+Keys.RETURN);
		waitForThenClick("button","Save");
		waitForNoificationToClose();
	}
	
	public static void addNewMinConstraint61(String id) {
		waitForTagXWithAttributeYWithValueZThenClick("a","class","ya-create-type-selector-button z-toolbarbutton");
				
		waitForConstraintsMenu();			
		
		waitForTagXWithAttributeYWithValueZThenClick("tr","title","Min constraint");
		pauseMS(1000);
		
		WebElement idInputField = findElements(By.xpath("//span[text()='ID:']/following::input[1]")).get(0);	
		clearField(idInputField, id);
		
		WebElement minimalValueField = findElements(By.xpath("//span[text()='Minimal value:']/following::input[1]")).get(0);	
		clearField(minimalValueField, "0");
		
		WebElement enclosingTypeField = findElements(By.xpath("//span[text()='Enclosing Type:']/following::input[1]")).get(0);	
		enclosingTypeField.sendKeys("Band"+Keys.RETURN);
		
		pauseMS(1000);
		WebElement dots = findElements(By.xpath("//span[text()='Enclosing Type:']/following::i[1]")).get(0);	
		scrollToThenClick(dots);

		waitForThenClick("span","Band [Band]");// 6.2 expects div
		pauseMS(PAUSE_MS);

		WebElement attributeDescField = findElements(By.xpath("//span[text()='Attribute descriptor to validate:']/following::input[1]")).get(0);			
		sendKeysSlowly(attributeDescField, "album sales");
		attributeDescField.sendKeys(Keys.DOWN);		
		
		waitForThenClick("span","Band [Band] -> album sales [albumSales]");
		scrollToBottom();
		waitForThenClick("button","Done");
		waitForNoificationToClose();
		
		// Add a message to the the new min constraint
		waitForThenDoBackofficeSearch(id);
		waitForThenClick("span", id);// 6.2 expects div
		waitForTagXWithAttributeYWithValueZThenClick("button", "class", "yw-expandCollapse z-button");
		pauseMS(PAUSE_MS);
		
		WebElement errorMessageField = findElements(By.xpath("//div[text()='Is used in the following constraint groups']/preceding::input[1]")).get(0);			
		sendKeysSlowly(errorMessageField, "Album sales must be > 0. Do pay attention."+Keys.RETURN);
		waitForThenClick("button","Save");
		waitForNoificationToClose();
	}
	
	public static void addNewCustomConstraint(String id) {
		if (VersionHelper.is61() || VersionHelper.is60()) {
			addNewCustomConstraint61(id);
			return;
		}

		waitForTagXWithAttributeYWithValueZThenClick("a","class","ya-create-type-selector-button z-toolbarbutton");
		
		waitForConstraintsMenu();							
		
		scrollToBottom();
		waitForTagXWithAttributeYWithValueZThenClick("tr","title","NotLoremIpsumConstraint");
		waitForAllInputFields(19);
		scrollToBottom();
		List<WebElement> l = findElements(By.xpath("//input[@type='text']"));	
		scrollToBottom();
						
		WebElement idInputField = waitUntilElements(By.xpath("//span[text()='ID:']/following::input[1]")).get(0);	
		clearField(idInputField, id+Keys.RETURN);
		

		// Set Band [Bands]
		WebElement dots = waitUntilElements(By.xpath("//span[text()='Enclosing Type:' or text()='Composed type to validate:']/following::i[1]")).get(0);
		scrollToThenClick(dots);
		pauseMS(PAUSE_MS);		
		WebElement identifierField = waitUntilElements(By.xpath("//span[text()='Identifier']/following::input[2]")).get(0);	
		identifierField.sendKeys("Band"+Keys.RETURN);
		waitForThenClick("span","Band");// 6.2 expects div
		waitForThenClick("button","Select (1)");	
		pauseMS(PAUSE_MS);

		waitForAllInputFields(19);
	
			
		dots = waitUntilElements(By.xpath("//span[text()='Attribute descriptor to validate:']/following::i[1]")).get(0);	
		scrollToThenClick(dots);
		pauseMS(PAUSE_MS);		
		waitForThenClick("span","history");// 6.2 expects div
		waitForThenClick("button","Select (1)");	
		pauseMS(PAUSE_MS);
		
		waitForThenClick("button","Done");
		waitForNoificationToClose();
	
		// Add a message to the the custom constraint
		waitForThenDoBackofficeSearch(id);
		waitForThenClick("span", id);// 6.2 expects div
		waitForTagXWithAttributeYWithValueZThenClick("button","class","yw-expandCollapse z-button");
		WebElement errorMessageField = findElements(By.xpath("//div[text()='Is used in the following constraint groups']/preceding::input[1]")).get(0);			
		sendKeysSlowly(errorMessageField, "No Lorem Ipsum");
		waitForThenClick("button","Save");
		waitForNoificationToClose();
	}
	
	public static void addNewCustomConstraint61(String id) {
		waitForTagXWithAttributeYWithValueZThenClick("a","class","ya-create-type-selector-button z-toolbarbutton");
				
		waitForConstraintsMenu();			
		
		waitForTagXWithAttributeYWithValueZThenClick("tr","title","NotLoremIpsumConstraint");
		pauseMS(1000);
		
		WebElement idInputField = findElements(By.xpath("//span[text()='ID:']/following::input[1]")).get(0);	
		clearField(idInputField, id);
		
		WebElement enclosingTypeField = findElements(By.xpath("//span[text()='Enclosing Type:']/following::input[1]")).get(0);	
		enclosingTypeField.sendKeys("Band"+Keys.RETURN);
		WebElement dots = findElements(By.xpath("//span[text()='Enclosing Type:']/following::i[1]")).get(0);	
		scrollToThenClick(dots);
		pauseMS(PAUSE_MS);		
		
		waitForThenClick("span","Band [Band]");// 6.2 expects div
		pauseMS(PAUSE_MS);

		WebElement attributeDescField = findElements(By.xpath("//span[text()='Attribute descriptor to validate:']/following::input[1]")).get(0);			
		sendKeysSlowly(attributeDescField, "history");
		attributeDescField.sendKeys(Keys.DOWN);		
		
		waitForThenClick("span","Band [Band] -> history [history]");
		scrollToBottom();
		waitForThenClick("button","Done");
		waitForNoificationToClose();
		
		// Add a message to the the new min constraint
		waitForThenDoBackofficeSearch(id);
		waitForThenClick("span", id);// 6.2 expects div
		waitForTagXWithAttributeYWithValueZThenClick("button","class","yw-expandCollapse z-button");
		pauseMS(PAUSE_MS);
		
		WebElement errorMessageField = findElements(By.xpath("//div[text()='Is used in the following constraint groups']/preceding::input[1]")).get(0);			
		sendKeysSlowly(errorMessageField, "No Lorem Ipsum"+Keys.RETURN);
		waitForThenClick("button","Save");
		waitForNoificationToClose();
	}
	
	
	public static void selectConstraintsPage() {
		waitForThenClickMenuItem("System");
		waitForThenClickMenuItem("Validation");		
		waitForThenClickMenuItem("Constraints");
	}

	public static void deleteExistingMinConstraint(String id) {
		try{
			waitForThenClick("span", id);// 6.2 expects div
			pauseMS(PAUSE_MS);

			List<WebElement> bins = findElements(By.xpath("//img[contains(@src,'/backoffice/widgetClasspathResource/widgets/actions/deleteAction/icons/icon_action_delete_default.png')]"));			
			if (bins.size()==2)
				scrollToThenClick(bins.get(1));
			else
				scrollToThenClick(bins.get(0));			

			waitForThenClickButtonWithText("Yes");
			waitForNoificationToClose();
		}
		catch(Exception e){
			LOG.info(e.getMessage());
		}
	}
	
	public static boolean waitForConnectionToOpen(String url, int waitMS) throws Exception {
		try {
			URL obj = new URL(url);
			HttpURLConnection conn;
			if (url.contains("https"))
				conn = (HttpsURLConnection) obj.openConnection();
			else
				conn = (HttpURLConnection) obj.openConnection();
			conn.setConnectTimeout(waitMS); // start-up can take some time
			conn.setReadTimeout(waitMS);
			conn.setRequestMethod("GET");
			// Read response
			conn.getResponseCode();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public static boolean isElementClickable(By by) {
		try {
			getDriver().findElement(by).click();
			return true;
		}
		catch (WebDriverException exc) {
			return false;
		}
	}
	
	/**
	 * Makes a page element invisible. Useful when an user action cannot be simulated.
	 */
	public static void hideElement(By by) {
		try {
			WebElement element = findElement(by);
			((JavascriptExecutor) dvr).executeScript("arguments[0].style.display = 'none';", element);
		}
		catch(Exception e) {}
	}
	
	public static void closeBrowser() {
		if (peakDriver() != null) {
			for (StackTraceElement s : Thread.currentThread().getStackTrace())
				System.out.println(s.getMethodName());
			getDriver().close(); 
			getDriver().quit();
			setDriver(null);
		}
	}
	
}
