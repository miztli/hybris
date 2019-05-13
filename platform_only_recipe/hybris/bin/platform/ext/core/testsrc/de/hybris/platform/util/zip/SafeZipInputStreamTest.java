/*
 * [y] hybris Platform
 *
 * Copyright (c) {year} SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.platform.util.zip;

import static com.google.common.collect.ImmutableList.of;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.fest.assertions.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import de.hybris.bootstrap.annotations.UnitTest;
import org.junit.Test;

import com.google.common.base.Preconditions;

@UnitTest
public class SafeZipInputStreamTest
{
	@Test
	public void shouldThrowUnsupportedZipEntryExceptionWhenReadingMaliciousZipInputStream()
	{
		final String validEntry = new File("files", UUID.randomUUID().toString()).getPath();
		final String invalidEntry = new File("../../../../../../../../../../zip-slip", UUID.randomUUID().toString()).getPath();

		final Throwable throwable = catchThrowable(() -> readSafeZipInputStream(of(validEntry, invalidEntry), of("foo", "bar")));
		assertThat(throwable).isInstanceOf(UnsupportedZipEntryException.class);
	}

	@Test
	public void shouldReadCorrectEntriesFromZipInputStream() throws IOException
	{
		final String validEntry1 = new File("files", UUID.randomUUID().toString()).getPath();
		final String validEntry2 = new File("foo/bar", UUID.randomUUID().toString()).getPath();

		final List<String> entryNames = readSafeZipInputStream(of(validEntry1, validEntry2), of("foo", "bar"));

		assertThat(entryNames).containsExactly(validEntry1, validEntry2);
	}

	private List<String> readSafeZipInputStream(final List<String> entryNames, final List<String> contents) throws IOException
	{
		final List<String> readEntryNames = new ArrayList<>();

		try (final ByteArrayInputStream is = new ByteArrayInputStream(zipSlipArchiveAsBytes(entryNames, contents));
				final SafeZipInputStream zip = new SafeZipInputStream(is))
		{
			SafeZipEntry entry;
			while ((entry = zip.getNextEntry()) != null)
			{
				readEntryNames.add(entry.getName());
			}
		}
		catch (final Exception e)
		{
			throw e;
		}

		return readEntryNames;
	}

	public static byte[] zipSlipArchiveAsBytes(final List<String> entryNames, final List<String> contents)
	{
		Preconditions.checkArgument(entryNames.size() == contents.size());

		try (final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				final ZipOutputStream zos = new ZipOutputStream(byteArrayOutputStream);
				final PrintWriter printer = new PrintWriter(zos))
		{
			int counter = 0;
			for (final String entry : entryNames)
			{
				zos.putNextEntry(new ZipEntry(entry));
				printer.print(contents.get(counter++));
				printer.flush();
			}
			zos.flush();
			zos.close();

			return byteArrayOutputStream.toByteArray();
		}
		catch (final IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
