/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.platform.persistence.property.loader;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.cache.InvalidationManager;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.persistence.property.DBPersistenceManager;
import de.hybris.platform.persistence.property.TypeInfoMap;
import de.hybris.platform.persistence.property.internal.LoadDeploymentInfoResult;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.junit.Test;


@IntegrationTest
public class BatchTypeInfoMapLoaderTest extends ServicelayerBaseTest
{
	@Test
	public void shouldReturnTheSameTypeInfoMapAsLegacyImplementation() throws NoSuchFieldException, IllegalAccessException
	{
		final DBPersistenceManager pm = new DBPersistenceManager(Registry.getCurrentTenant(), dummyInvalidationManager());
		pm.legacyLoadPersistenceInfosInternalInTX();

		final Tenant tenant = Registry.getCurrentTenant();

		final BatchTypeInfoMapLoader loader = new BatchTypeInfoMapLoader(tenant);
		final List<TypeInfoMap> typeInfoMaps = loader.loadAllTypes();
		final LoadDeploymentInfoResult deploymentInfoResult = loader.getLoadDeploymentInfoResult();

		for (final TypeInfoMap newPersistenceInfo : typeInfoMaps)
		{
			final String typeCode = newPersistenceInfo.getCode();

			assertThat(typeCode).isNotEmpty();
			final TypeInfoMap legacyPersistenceInfo = pm.getPersistenceInfo(typeCode);

			assertThat(newPersistenceInfo).isEqualToComparingFieldByFieldRecursively(legacyPersistenceInfo);
		}

		final Map deploymentInfos = (Map) getViaReflection(pm, "deploymentInfos");
		final Map typeCode2JndiMappings = (Map) getViaReflection(pm, "typeCode2JndiMappings");
		final Map javaDefMapping = (Map) getViaReflection(pm, "javaDefMapping");

		assertThat(typeCode2JndiMappings).containsAllEntriesOf(deploymentInfoResult.getTypeCode2JndiMappings());
		assertThat(javaDefMapping).containsAllEntriesOf(deploymentInfoResult.getJavaDefMapping());

		assertThat(deploymentInfos).hasSameSizeAs(deploymentInfoResult.getDeploymentInfos());
	}

	private Object getViaReflection(final DBPersistenceManager pm, final String field)
			throws NoSuchFieldException, IllegalAccessException
	{
		final Field javaDefMapping = DBPersistenceManager.class.getDeclaredField(field);
		javaDefMapping.setAccessible(true);
		return javaDefMapping.get(pm);
	}

	private InvalidationManager dummyInvalidationManager()
	{
		return new InvalidationManager((key, invalidationType) -> {
		});
	}

}


