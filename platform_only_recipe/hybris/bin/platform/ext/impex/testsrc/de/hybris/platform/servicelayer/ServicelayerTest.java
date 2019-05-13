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

import de.hybris.platform.core.Registry;
import de.hybris.platform.impex.jalo.ImpExException;
import de.hybris.platform.servicelayer.impex.ImpExResource;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;

import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.springframework.context.ApplicationContext;


public abstract class ServicelayerTest extends ServicelayerBaseTest
{
	@Resource
	protected ImportService importService;

	private final ServicelayerTestLogic servicelayerTestLogic;

	protected ServicelayerTest()
	{
		servicelayerTestLogic = new ServicelayerTestLogic();
	}

	public static void createCoreData() throws Exception
	{
		ServicelayerTestLogic.createCoreData();
	}

	public static void createDefaultCatalog() throws Exception
	{
		ServicelayerTestLogic.createDefaultCatalog();
	}

	public static void createHardwareCatalog() throws Exception
	{
		ServicelayerTestLogic.createHardwareCatalog();
	}

	public static void createDefaultUsers() throws Exception
	{
		ServicelayerTestLogic.createDefaultUsers();
	}

	/**
	 * Delegates to de.hybris.platform.servicelayer.ServicelayerTestLogic#importData(java.lang.String, java.lang.String, de.hybris.platform.servicelayer.impex.ImportService)
	 * 
	 * @param resource
	 *           location of classpath resource that will be imported
	 * @param encoding
	 *           encoding of classpath resource
	 */
	public void importData(final String resource, final String encoding) throws ImpExException
	{
		servicelayerTestLogic.importData(resource, encoding, importService);
	}

	/**
	 * Delegates to de.hybris.platform.servicelayer.ServicelayerTestLogic#importData(de.hybris.platform.servicelayer.impex.ImpExResource, de.hybris.platform.servicelayer.impex.ImportService)
	 *
	 * @param resource
	 *           impex resource to load
	 */
	public void importData(final ImpExResource resource) throws ImpExException
	{
		servicelayerTestLogic.importData(resource, importService);
	}

	/**
	 * Delegates to de.hybris.platform.servicelayer.ServicelayerTestLogic#importData(de.hybris.platform.servicelayer.impex.ImportConfig, de.hybris.platform.servicelayer.impex.ImportService)
	 * 
	 * @param config
	 *           with import details.
	 * @return import result
	 */
	public ImportResult importData(final ImportConfig config) throws ImpExException
	{
		return servicelayerTestLogic.importData(config, importService);
	}

	@Override
	protected ApplicationContext getApplicationContext()
	{
		return Registry.getApplicationContext();
	}

	/**
	 * Delegates to de.hybris.platform.servicelayer.ServicelayerTestLogic#importCsv(java.lang.String, java.lang.String)
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

	protected static void importStream(final InputStream is, final String encoding, final String resourceName,
			final boolean hijackExceptions) throws ImpExException
	{
		ServicelayerTestLogic.importStream(is, encoding, resourceName, hijackExceptions);
	}

	/**
	 * Delegates to de.hybris.platform.servicelayer.ServicelayerTestLogic#isPrefetchModeNone()
	 */
	protected boolean isPrefetchModeNone()
	{
		return servicelayerTestLogic.isPrefetchModeNone();
	}


}
