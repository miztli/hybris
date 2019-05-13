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

package de.hybris.platform.servicelayer.media.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.security.UserRightModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import de.hybris.platform.tx.Transaction;
import org.junit.Test;


public class MediaPermittedPrincipalsIntegrationTests extends ServicelayerBaseTest
{
	@Resource
	private UserService userService;
	@Resource
	private ModelService modelService;

	@Test
	public void shouldCorrectlySetPermittedPrincipalWhenSettingTwice() throws InterruptedException
	{
		//given
		final AtomicInteger size = new AtomicInteger(0);
		Transaction.current().begin();
		createUserRight();
		final MediaModel media = createMedia();
		Transaction.current().commit();

		final Long pk = media.getPk().getLongValue();

		media.setPermittedPrincipals(Arrays.asList(userService.getUserForUID("admin")));
		modelService.save(media);
		assertThat(media.getPermittedPrincipals()).hasSize(1);

		final Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{	//when
				Registry.setCurrentTenant(Registry.getSlaveJunitTenant());
				Transaction.current().begin();
				final MediaModel media2 = modelService.get(PK.fromLong(pk));
				media2.setPermittedPrincipals(Arrays.asList(userService.getUserForUID("admin")));
				modelService.save(media2);
				size.set(media2.getPermittedPrincipals().size());
				Transaction.current().commit();
			}
		});
		thread.start();
		thread.join();
		//then
		assertThat(size.get()).isEqualTo(1);
	}

	@Test
	public void shouldCorrectlySetDeniedPrincipalWhenSettingTwice() throws InterruptedException
	{
		//given
		final AtomicInteger size = new AtomicInteger(0);
		Transaction.current().begin();
		createUserRight();
		final MediaModel media = createMedia();
		Transaction.current().commit();

		final Long pk = media.getPk().getLongValue();

		media.setDeniedPrincipals(Arrays.asList(userService.getUserForUID("admin")));
		modelService.save(media);
		assertThat(media.getDeniedPrincipals()).hasSize(1);

		final Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				//when
				Registry.setCurrentTenant(Registry.getSlaveJunitTenant());
				Transaction.current().begin();
				final MediaModel media2 = modelService.get(PK.fromLong(pk));
				media2.setDeniedPrincipals(Arrays.asList(userService.getUserForUID("admin")));
				modelService.save(media2);
				size.set(media2.getDeniedPrincipals().size());
				Transaction.current().commit();
			}
		});
		thread.start();
		thread.join();
		//then
		assertThat(size.get()).isEqualTo(1);
	}

	private MediaModel createMedia() {
		final MediaModel media = modelService.create(CatalogUnawareMediaModel.class);
		media.setCode(UUID.randomUUID().toString());
		modelService.save(media);
		return media;
	}

	private void createUserRight() {
		final UserRightModel userRight = modelService.create(UserRightModel.class);
		userRight.setCode("read");
		modelService.save(userRight);
	}
}
