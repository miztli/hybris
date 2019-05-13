/*
 * [y] hybris Platform
 * 
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of SAP 
 * Hybris ("Confidential Information"). You shall not disclose such 
 * Confidential Information and shall use it only in accordance with the 
 * terms of the license agreement you entered into with SAP Hybris.
 */
class JavaVersionChecker {
    
    public static void main(String[] args) {
        String version = System.getProperty("java.version");
        System.out.println("Java version: " + version);
        if (Integer.parseInt(version.split("\\.")[1]) < 8) {
            System.out.println("Wrong java version is set: " + version + ". Installer requires at least java 1.8");
            System.exit(-1);
        }
    }
}
