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

package de.hybris.platform.impex;

import static com.google.common.collect.ImmutableList.of;
import static de.hybris.platform.util.zip.SafeZipInputStreamTest.zipSlipArchiveAsBytes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.impex.jalo.ImpExManager;
import de.hybris.platform.impex.jalo.cronjob.DefaultCronJobMediaDataHandler;
import de.hybris.platform.impex.jalo.cronjob.ImpExImportCronJob;
import de.hybris.platform.impex.jalo.cronjob.ImpExImportJob;
import de.hybris.platform.impex.jalo.media.MediaDataHandler;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.media.Media;
import de.hybris.platform.jalo.media.MediaManager;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.util.zip.UnsupportedZipEntryException;
import org.junit.Test;
import java.io.File;
import java.util.UUID;


@IntegrationTest
public class ZipSlipTest extends ServicelayerBaseTest
{

	@Test
	public void shouldNotBeAffectedByZipSlip()
	{
		// given
		final ImpExImportJob job = ImpExManager.getInstance().getOrCreateImpExImportJob();
		final ImpExImportCronJob cronJob = ImpExManager.getInstance().createDefaultImpExImportCronJob(job);

		final Media media = MediaManager.getInstance().createMedia("testMediaCron");
		cronJob.setUnzipMediasMedia(true);

		final String validEntry = new File("files", UUID.randomUUID().toString()).getPath();
		final String invalidEntry = new File("../../../../../../../../../../zip-slip", UUID.randomUUID().toString()).getPath();

		cronJob.setMediasMedia(createZipSlipMediaArchive(zipSlipArchiveAsBytes(of(validEntry, invalidEntry), of("foo", "bar"))));

		final MediaDataHandler handler = new DefaultCronJobMediaDataHandler(cronJob);

		// when
		final Throwable throwable = catchThrowable(() -> handler.importData(media, "files/test.txt"));

		// then
		assertThat(throwable).isInstanceOf(UnsupportedZipEntryException.class);
	}

	private Media createZipSlipMediaArchive(final byte[] zipSlipBytes)
	{
		final Media zipSlipMediaArchive = MediaManager.getInstance().createMedia("mediasMedia");
		try
		{
			zipSlipMediaArchive.setData(zipSlipBytes);
		}
		catch (final JaloBusinessException e)
		{
			throw new RuntimeException();
		}
		return zipSlipMediaArchive;
	}
}
