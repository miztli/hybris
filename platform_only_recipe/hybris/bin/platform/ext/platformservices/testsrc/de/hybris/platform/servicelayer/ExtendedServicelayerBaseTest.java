/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.servicelayer;

import de.hybris.platform.impex.jalo.ImpExException;

import java.io.InputStream;

import org.apache.log4j.Logger;
import org.junit.Ignore;


/**
 * Service layer test with possibility to create sample data.
 */
public class ExtendedServicelayerBaseTest extends ServicelayerBaseTest
{
	private static final Logger LOG = Logger.getLogger(ExtendedServicelayerBaseTest.class);

	public static void createDefaultCatalog() throws Exception
	{
		ServicelayerTestLogic.createDefaultCatalog();
	}

	/**
	 * Imports given csv file from classpath using given encoding. Fails in case of import errors.
	 * 
	 * @param csvFile
	 *           name of file to import from classpath
	 * @param encoding
	 *           encoding to use
	 * @throws ImpExException
	 */
	protected static void importCsv(final String csvFile, final String encoding) throws ImpExException
	{
		ServicelayerTestLogic.importCsv(csvFile, encoding);
	}

	protected static void importStream(final InputStream is, final String encoding, final String resourceName)
			throws ImpExException
	{
		ServicelayerTestLogic.importStream(is, encoding, resourceName);
	}

	public static void createCoreData() throws Exception
	{
		ServicelayerTestLogic.createCoreData();
	}
}
