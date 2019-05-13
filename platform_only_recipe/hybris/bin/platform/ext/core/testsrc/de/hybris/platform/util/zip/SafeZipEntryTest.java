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

package de.hybris.platform.util.zip;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assume.assumeTrue;

import de.hybris.bootstrap.annotations.UnitTest;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;

@UnitTest
public class SafeZipEntryTest
{
	@Test
	public void shouldReturnNameForEntriesNotEscapingDirectory()
	{
		assertThat(new SafeZipEntry("foo").getName()).isEqualTo("foo");

		assertThat(new SafeZipEntry("FOO").getName()).isEqualTo("FOO");

		assertThat(new SafeZipEntry("foo/bar").getName()).isEqualTo("foo/bar");

		assertThat(new SafeZipEntry("foo/../foo").getName()).isEqualTo("foo/../foo");

		assertThat(new SafeZipEntry("%userprofile%/a.txt").getName()).isEqualTo("%userprofile%/a.txt");

		assertThat(new SafeZipEntry("~/a.txt").getName()).isEqualTo("~/a.txt");

		assertThat(new SafeZipEntry("$HOME/a.txt").getName()).isEqualTo("$HOME/a.txt");

		assertThat(new SafeZipEntry("./a.txt").getName()).isEqualTo("./a.txt");

		assertThat(new SafeZipEntry("a.txt; mkdir test").getName()).isEqualTo("a.txt; mkdir test");

		assertThat(new SafeZipEntry("a.txt &").getName()).isEqualTo("a.txt &");

		assertThat(new SafeZipEntry("& mkdir test").getName()).isEqualTo("& mkdir test");

		assertThat(new SafeZipEntry("a.txt & touch test").getName()).isEqualTo("a.txt & touch test");
	}

	@Test
	public void shouldThrowExceptionForEntriesEscapingDirectory()
	{
		final Throwable throwable1 = catchThrowable(() -> new SafeZipEntry("../foo").getName());
		assertThat(throwable1).isInstanceOf(UnsupportedZipEntryException.class);

		final Throwable throwable2 = catchThrowable(() -> new SafeZipEntry("foo/../../foo").getName());
		assertThat(throwable2).isInstanceOf(UnsupportedZipEntryException.class);

		final Throwable throwable3 = catchThrowable(() -> new SafeZipEntry("/foo/../../foo").getName());
		assertThat(throwable3).isInstanceOf(UnsupportedZipEntryException.class);

		final Throwable throwable4 = catchThrowable(() -> new SafeZipEntry("/etc/passwd").getName());
		assertThat(throwable4).isInstanceOf(UnsupportedZipEntryException.class);
	}

	@Test
	public void shouldThrowExceptionForEntriesEscapingDirectoryOnWindows()
	{
		assumeTrue(SystemUtils.IS_OS_WINDOWS);

		final Throwable throwable5 = catchThrowable(() -> new SafeZipEntry("c:\\windows\\a.txt").getName());
		assertThat(throwable5).isInstanceOf(UnsupportedZipEntryException.class);

		final Throwable throwable6 = catchThrowable(() -> new SafeZipEntry("d:\\a.txt").getName());
		assertThat(throwable6).isInstanceOf(UnsupportedZipEntryException.class);
	}
}
