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

package de.hybris.platform.servicelayer.web.session;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.cache.AbstractCacheUnit;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.web.StoredHttpSessionModel;
import de.hybris.platform.regioncache.CacheController;
import de.hybris.platform.regioncache.key.CacheKey;
import de.hybris.platform.regioncache.key.legacy.LegacyCacheKey;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;

import de.hybris.platform.servicelayer.web.session.persister.SyncSessionPersister;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.session.Session;


@IntegrationTest
public class CachedPersistedSessionRepositoryTest extends ServicelayerBaseTest
{
	@Resource
	private SyncSessionPersister synchronousSessionPersister;

	@Resource
	private StoredHttpSessionDao storedHttpSessionDao;

	@Resource
	private CacheController cacheController;

	private CachedPersistedSessionRepository repository;

	@Before
	public void setup()
	{
		repository = buildTestSessionRepository();
	}

	@Test
	public void shouldStoreSavedSessionInDbAndCache()
	{
		// given
		final Session session = repository.createSession();

		// when
		repository.save(session);

		// then
		final CacheKey key = createCacheUnitKey(session);

		final AbstractCacheUnit existingUnitAfterCreate = cacheController.get(key);
		final StoredHttpSessionModel storedSessionModel = storedHttpSessionDao.findById(session.getId());

		assertThat(existingUnitAfterCreate).isNotNull();
		assertThat(storedSessionModel).isNotNull();
	}

	@Test
	public void shouldRemoveSessionFromCacheAndDbAfterDeletion()
	{
		// given
		final Session session = repository.createSession();
		final CacheKey key = createCacheUnitKey(session);

		// when
		repository.save(session);
		repository.removeCachedPersistedSession(session.getId());

		// then
		final AbstractCacheUnit nonExistingUnitAfterRemove = cacheController.get(key);
		final StoredHttpSessionModel noStoredSessionAfterRemove = storedHttpSessionDao.findById(session.getId());

		assertThat(nonExistingUnitAfterRemove).isNull();
		assertThat(noStoredSessionAfterRemove).isNull();
	}

	@Test
	public void shouldHaveEmptyCacheAfterGettingRemovedSession()
	{
		// given
		final Session session = repository.createSession();
		final CacheKey key = createCacheUnitKey(session);

		// when
		repository.save(session);
		repository.removeCachedPersistedSession(session.getId());
		repository.getSession(session.getId());

		// then
		final AbstractCacheUnit nonExistingUnitAfterGetForRemoved = cacheController.get(key);
		final StoredHttpSessionModel stillNoSessionAfterRemove = storedHttpSessionDao.findById(session.getId());

		assertThat(nonExistingUnitAfterGetForRemoved).isNull();
		assertThat(stillNoSessionAfterRemove).isNull();
	}

	private CachedPersistedSessionRepository buildTestSessionRepository()
	{
		final HybrisDeserializer deserializer = new HybrisDeserializer(this.getClass().getClassLoader());
		return new CachedPersistedSessionRepository(deserializer, synchronousSessionPersister, "foo", "");
	}

	private CacheKey createCacheUnitKey(final Session session)
	{
		final Object[] array =
		{ session.getId(), Registry.getCurrentTenant().getTenantID(), CachedPersistedSessionRepository.SESSION };
		return new LegacyCacheKey(array, Registry.getCurrentTenant().getTenantID());
	}
}
