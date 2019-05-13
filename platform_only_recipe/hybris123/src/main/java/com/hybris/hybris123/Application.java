package com.hybris.hybris123;
/*
 * © 2017 SAP SE or an SAP affiliate company.
 * All rights reserved.
 * Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and
 * notices.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.hybris.hybris123.runtime.helper.FileHelper;
import com.hybris.hybris123.runtime.tests.Hybris123Tests;

@SpringBootApplication	
public class Application {
	
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {  	  
		String pathHere = FileHelper.getPath("");
        if (environmentIsOk()) {
        		new SpringApplicationBuilder(Application.class).properties("y123dir="+pathHere).run(args);
        }   
	}
	
    private static boolean environmentIsOk() { 
	    	boolean dirOk = true;
	    	boolean mvnOk = true;
	    	boolean gitOk = true;
	    	 	
	    	// Confirm we are running in a directory called hybris123
	    	String workingDirectory = System.getProperty("user.dir");
	    	
	    	if (workingDirectory ==null || !workingDirectory.endsWith("/hybris123") && !workingDirectory.endsWith("\\hybris123"))
	    		dirOk = false;
	
	    	// Check for mvn
	    	try {
	    		String cmdOutput;
	    		String os = System.getProperty("os.name").toLowerCase();
	    		if (os.contains("windows"))
	    			cmdOutput = Hybris123Tests.runCmd("mvn.cmd --version");
	    		else
	    			cmdOutput = Hybris123Tests.runCmd("mvn --version");
	        	if (!cmdOutput.contains("Apache Maven"))
	        		mvnOk=false;        		
	    	} catch(Exception e) {
	    		mvnOk = false;
	    	}
	    	
	    	// Check for git
	    	try {
	        	String cmdOutput = Hybris123Tests.runCmd("git --version");
	        	if (!cmdOutput.contains("git version"))
	        		gitOk = false;        		
	    	} catch(Exception e) {
	    		gitOk = false;
	    	}
	
	    	if (!dirOk  || !mvnOk || !gitOk ) {
	    		LOG.error("One or more prerequisites are not met for running Hybris 123 Interactive. Please check then re-run:");
	    		LOG.error("Called within directory 'hybris123': {}", dirOk);
	    		LOG.error("Maven found (mvn --version is running): {}", mvnOk);
		       	LOG.error("Git found (git --version is running): {}", gitOk);
	    		return false;
	    	}
    		return true;
    }  
}


