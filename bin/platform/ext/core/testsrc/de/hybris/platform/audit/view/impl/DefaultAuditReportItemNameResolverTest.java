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
package de.hybris.platform.audit.view.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.audit.internal.config.AuditReportItemNameResolvable;
import de.hybris.platform.audit.view.AuditReportItemNameResolver;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.util.Config;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class DefaultAuditReportItemNameResolverTest extends ServicelayerBaseTest
{
	private static final String USER_KEY = "type.user.name";
	private static final String NOT_EXISTING_KEY = "this.is.not.existing.key.name";
	private static final String DISPLAY_NAME = "DisplayName";
	private static final String DEFAULT_NAME = "defaultName";
	private static final String USER_EN = "User";
	private static final String USER_FROM_PARAM = "type.useraudit.name";
	private static final String SEPARATOR = " / ";
	private static final String LANG_EN = "en";
	private static final String LANG_YO = "yo";

	@Resource(type = AuditReportItemNameResolver.class)
	private AuditReportItemNameResolver auditReportItemNameResolver;

	private Set<String> emptySet = Collections.emptySet();
	private Set<String> isoCodes = new HashSet<>();
	private Set<String> oneNonExistingLang = new HashSet<>();

	@Before
	public void setUp()
	{
		//test environment only supports english locales
		isoCodes.add(LANG_EN);

		oneNonExistingLang.add(LANG_YO);
	}

	@Test
	public void shouldReturnNameForDisplayNameFirstIfDisplayNameIsDefined()
	{
		assertThat(auditReportItemNameResolver.getName(isoCodes, newItem(USER_KEY, DISPLAY_NAME, DEFAULT_NAME)))
				.isEqualTo(DISPLAY_NAME);
	}

	@Test
	public void shouldReturnPropertyNameForDisplayKeyFirstIfPropertyIsDefinedInConfig()
	{
		Config.setParameter(USER_FROM_PARAM, USER_FROM_PARAM);
		assertThat(auditReportItemNameResolver.getName(isoCodes, newItem(USER_FROM_PARAM, DEFAULT_NAME))).isEqualTo(USER_FROM_PARAM);
	}

	@Test
	public void shouldReturnLocalizedNameForDisplayKey()
	{
		assertThat(auditReportItemNameResolver.getName(isoCodes, newItem(USER_KEY, DEFAULT_NAME))).isEqualTo(USER_EN);
	}

	@Test
	public void shouldReturnDefaultNameIfDisplayKeyIsUndefined()
	{
		assertThat(auditReportItemNameResolver.getName(isoCodes, newItem(NOT_EXISTING_KEY, DEFAULT_NAME))).isEqualTo(DEFAULT_NAME);
	}

	@Test
	public void shouldReturnDefaultNameIfNoLangIsDefined()
	{
		assertThat(auditReportItemNameResolver.getName(emptySet, newItem(USER_KEY, DEFAULT_NAME))).isEqualTo(DEFAULT_NAME);
	}

	@Test
	public void shouldReturnDefaultNameIfNotExistsResourceForLocale()
	{
		assertThat(auditReportItemNameResolver.getName(oneNonExistingLang, newItem(USER_KEY, DEFAULT_NAME)))
				.isEqualTo(DEFAULT_NAME);
	}

	@Test
	public void shouldReturnConcatenatedLocalizedName()
	{
		assertThat(auditReportItemNameResolver.getName(isoCodes, newItem(USER_KEY, DEFAULT_NAME)))
				.isEqualTo(getConcatenatedString(isoCodes));
	}

	private DefaultResolvableItem newItem(String displayKey, String displayName, String defaultName)
	{
		return new DefaultResolvableItem(displayKey, displayName, defaultName);
	}

	private DefaultResolvableItem newItem(String displayKey, String defaultName)
	{
		return new DefaultResolvableItem(displayKey, StringUtils.EMPTY, defaultName);
	}


	private String getConcatenatedString(Set<String> langs)
	{
		Map<String, String> mapping = new HashMap<>();
		mapping.put(LANG_EN, USER_EN);
		StringBuilder sb = new StringBuilder();
		langs.forEach(lang -> sb.append(mapping.get(lang)).append(SEPARATOR));
		return sb.length() == 0 ? "" : sb.substring(0, sb.lastIndexOf(SEPARATOR)).trim();
	}

	static class DefaultResolvableItem implements AuditReportItemNameResolvable
	{
		private String displayName;
		private String displayKey;
		private String defaultName;

		DefaultResolvableItem(String displayKey, String displayName, String defaultName)
		{
			this.defaultName = defaultName;
			this.displayKey = displayKey;
			this.displayName = displayName;
		}

		@Override
		public String getDisplayKey()
		{
			return this.displayKey;
		}

		@Override
		public String getDisplayName()
		{
			return this.displayName;
		}

		@Override
		public String getDefaultName()
		{
			return this.defaultName;
		}
	}
}
