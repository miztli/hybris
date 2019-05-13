package com.hybris.hybris123.runtime.endpoint;
/*
 * © 2017 SAP SE or an SAP affiliate company.
 * All rights reserved.
 * Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and
 * notices.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.ManagedBean;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hybris.hybris123.annotations.Snippet;
import com.hybris.hybris123.runtime.tests.Hybris123Tests;

@ManagedBean
@RestController
public class Hybris123RestEndpoints {
	private static final Logger LOG = LoggerFactory.getLogger(Hybris123RestEndpoints.class);

	@Autowired
	Hybris123Tests y123Tests;

	@Value("${y123dir:'Undefined'}")
	private String y123dir;

	@Value("${home:'Undefined'}")
	private String trailHome;
	
	@Value("${os:'Undefined'}")
	private String os;

	@Value("${zip:'Undefined'}")
	private String zip;

	private static Map<String, String> testLog = createTestListing();
		
	public static void updateTestStatus(String testname, String status){
		testLog.put(testname, status);
	}
	
	public static String validateTestLogBeforeSendingOverWireForSecurity(){
		for (String key: testLog.keySet()){
			if (!key.matches("com.hybris.hybris123.Hybris123Tests_\\w.*")){
				LOG.error("key not matching in validateTestLogBeforeSendingOverWireForSecurity"  );
				return "";
			}
			String value = testLog.get(key);
			if (!value.matches("failed|passed|NotYetRun|running")){
				LOG.error("value not matching in validateTestLogBeforeSendingOverWireForSecurity"  );
				return "";
			}
		}
		return testLog.toString();
	}
	
	@CrossOrigin()
	@Snippet("com.hybris.hybris123.runtime.endpoint.Hybris123RestEndpoints_runATest")
	@RequestMapping(path="/hybris123/tdd", produces="text/plain" )
	public ResponseEntity<String> runATest(
			@RequestParam(value = "test", defaultValue = "") String methodName, 
			@RequestParam(value = "testName", defaultValue = "") String testNameIfSetting,
			@RequestParam(value = "testStatus", defaultValue = "") String testStatusIfSetting,
			@RequestParam(value = "email", defaultValue = "") String email
			) {	
		String hybris123TestsPrefix = "com.hybris.hybris123.Hybris123Tests_";
		try {
			if (methodName.equals("reset")){
				testLog = createTestListing();
				return new ResponseEntity<String>(validateTestLogBeforeSendingOverWireForSecurity(), HttpStatus.OK);
			}
			else if (methodName.equals("getlog"))
				return new ResponseEntity<String>(validateTestLogBeforeSendingOverWireForSecurity(), HttpStatus.OK);
			
			else if (methodName.startsWith("updatelog")){
				updateTestStatus(testNameIfSetting,testStatusIfSetting );
				return new ResponseEntity<>(validateTestLogBeforeSendingOverWireForSecurity(), HttpStatus.OK);
			}
			else if (email!=null && email.length()>0){
				return new ResponseEntity<>("Email sent", HttpStatus.OK);
			}
			else if (methodName.startsWith("gety123dir")){
				return new ResponseEntity<>(y123dir, HttpStatus.OK);
			}			
			else if (!methodName.contains(hybris123TestsPrefix))
				throw new Exception("Unrecognized value: "+methodName);
			
			Method method = y123Tests.getClass().getMethod( methodName.replace(hybris123TestsPrefix, ""));					
			updateTestStatus(methodName,"running");
			y123Tests.allowHttps();		
			method.invoke(y123Tests);
			
			if (!methodName.contains("testIsOnline")){
				y123Tests.closeSelenium();
			}
			
		} catch (InvocationTargetException e) {
			testLog.put(methodName, "failed");
			y123Tests.closeSelenium();
			return new ResponseEntity<>("Fail", HttpStatus.OK);
		}
		catch(Exception e){
			testLog.put(methodName, "failed");
			y123Tests.closeSelenium();
			return new ResponseEntity<>("Fail Run from command line to find more details.", HttpStatus.OK);
		} catch (Error e) {
			testLog.put(methodName, "failed");
			y123Tests.closeSelenium();
			return new ResponseEntity<>("Fail Run from command line to find more details.", HttpStatus.OK);
		}
		testLog.put(methodName, "passed");
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	

	public static Map<String, String> createTestListing (){
		Class<? extends Hybris123Tests> c = new Hybris123Tests().getClass();
		Map<String, String> testLog = new ConcurrentHashMap<>();
		for (Method method : c.getDeclaredMethods()) {
		  if (method.getAnnotation(Test.class) != null) {
			  testLog.put("com.hybris.hybris123.Hybris123Tests_"+method.getName(),"NotYetRun");
		  }
		}
		return testLog;
	}
	
}
