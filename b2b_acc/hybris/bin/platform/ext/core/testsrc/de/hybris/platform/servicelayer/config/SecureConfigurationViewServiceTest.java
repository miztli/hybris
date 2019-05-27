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

package de.hybris.platform.servicelayer.config;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.bootstrap.config.ConfigUtil;
import de.hybris.platform.servicelayer.config.impl.SecureConfigurationViewService;
import de.hybris.platform.util.config.ConfigIntf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.entry;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class SecureConfigurationViewServiceTest
{
	private static final String HIDDEN_VALUE = "*****";

	@Test
	public void shouldNotDisplayBlacklistedPropertiesInRemoveMode()
	{
		// given
		final Map<String, String> properties = ImmutableMap.<String, String> builder() //
				.put("db.username", "admin") //
				.put("db.password", "nimda") //
				.put("password.encoder", "foo") //
				.put("password.encoder.keylength", "32") //
				.put("unaffected", "ok").build();

		final Map<String, String> blacklist = ImmutableMap.<String, String> builder() //
				.put("db", "db.username,db.password") //
				.put("encoder", "password.encoder,password.encoder.keylength") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(), () -> new Properties(),
				() -> mockRemoveConfiguration(blacklist, emptyMap(), properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).containsOnly(entry("unaffected", "ok"));
	}

	@Test
	public void shouldShowAsterisksForBlacklistedPropertiesInHideMode()
	{
		// given
		final Map<String, String> properties = ImmutableMap.<String, String> builder() //
				.put("db.username", "admin") //
				.put("db.password", "nimda") //
				.put("unaffected", "ok").build();

		final Map<String, String> blacklist = ImmutableMap.<String, String> builder() //
				.put("db", "db.username,db.password") //
				.put("encoder", "password.encoder.pbkdf2.iterations,password.encoder.pbkdf2.keylength") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(), () -> new Properties(),
				() -> mockHideConfiguration(blacklist, emptyMap(), properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).containsOnly( //
				entry("db.username", HIDDEN_VALUE), //
				entry("db.password", HIDDEN_VALUE), //
				entry("unaffected", "ok"));
	}

	@Test
	public void shouldNotDisplayBlacklistedByRegexInRemoveMode()
	{
		// given
		final Map<String, String> properties = ImmutableMap.<String, String> builder() //
				.put("ldap.username", "foo") //
				.put("ldap.password", "bar") //
				.put("db.user", "admin") //
				.put("db.password", "nimda") //
				.put("unaffected", "ok").build();

		final Map<String, String> regexRules = ImmutableMap.<String, String> builder() //
				.put("configuration.view.regex.rule.test.username", "user") //
				.put("configuration.view.regex.rule.test.password", "password") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(),
						() -> new Properties(), () -> mockRemoveConfiguration(emptyMap(), regexRules, properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).containsOnly(entry("unaffected", "ok"));
	}


	@Test
	public void shouldBlankRegexBeIgnored()
	{
		// given
		final Map<String, String> properties = ImmutableMap.<String, String> builder() //
				.put("ldap.username", "foo") //
				.put("ldap.password", "bar") //
				.put("unaffected", "ok").build();

		final Map<String, String> regexRules = ImmutableMap.<String, String> builder() //
				.put("configuration.view.regex.rule.blank", "       ") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(),
				() -> new Properties(), () -> mockRemoveConfiguration(emptyMap(), regexRules, properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).containsOnly(entry("ldap.username", "foo"), entry("ldap.password", "bar"),
				entry("unaffected", "ok"));
	}

	@Test
	public void shouldShowAsterisksForBlacklistedPropertiesByRegexInHideMode()
	{
		// given
		final Map<String, String> properties = ImmutableMap.<String, String> builder() //
				.put("ldap.username", "foo") //
				.put("ldap.password", "bar") //
				.put("db.user", "admin") //
				.put("db.password", "nimda") //
				.put("unaffected", "ok").build();

		final Map<String, String> regexRules = ImmutableMap.<String, String> builder() //
				.put("test.username", "user") //
				.put("test.password", "password") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(),
						() -> asProperties(properties), () -> mockHideConfiguration(emptyMap(), regexRules, properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).containsOnly( //
				entry("ldap.username", HIDDEN_VALUE), //
				entry("ldap.password", HIDDEN_VALUE), //
				entry("db.user", HIDDEN_VALUE), //
				entry("db.password", HIDDEN_VALUE), //
				entry("unaffected", "ok"));
	}


	@Test
	public void shouldNotDisplayBlacklistedEnvVarsAndSystemPropertiesInRemoveMode()
	{
		// given
		final Map<String, String> settings = ImmutableMap.<String, String> builder() //
				.put("y_ldap_username", "foo") //
				.put("y_ldap_password", "bar") //
				.put("y_db_user", "admin") //
				.put("y_db_password", "nimda") //
				.put("y_unaffected", "ok").build();

		final Map<String, String> blacklist = ImmutableMap.<String, String> builder() //
				.put("ldap", "y_ldap_username,y_ldap_password") //
				.put("db", "y_db_user,y_db_password") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> settings, () -> asProperties(settings),
				() -> mockRemoveConfiguration(blacklist, emptyMap(), Collections.emptyMap()));

		// when
		final Map<String, String> envVariables = viewService.readEnvVariables();
		final Properties properties = viewService.readSystemProperties();

		// then
		assertThat(envVariables).containsOnly(entry("y_unaffected", "ok"));
		assertThat(Maps.fromProperties(properties)).containsOnly(entry("y_unaffected", "ok"));
	}

	@Test
	public void shouldNotDisplayBlacklistedEnvVarsByRegexAndSystemPropertiesInRemoveMode()
	{
		// given
		final Map<String, String> settings = ImmutableMap.<String, String> builder() //
				.put("db.username", "admin") //
				.put("db.password", "nimda") //
				.put("y_db_user", "admin") //
				.put("y_db_password", "nimda") //
				.put("y_unaffected", "ok").build();

		final Map<String, String> regexRules = ImmutableMap.<String, String> builder() //
				.put("configuration.view.regex.rule.db", "db\\.")
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> settings, () -> asProperties(settings),
				() -> mockRemoveConfiguration(emptyMap(), regexRules, Collections.emptyMap()));

		// when
		final Map<String, String> envVariables = viewService.readEnvVariables();
		final Properties properties = viewService.readSystemProperties();

		// then
		assertThat(envVariables).containsOnly(entry("y_unaffected", "ok"));
		assertThat(Maps.fromProperties(properties)).containsOnly(entry("y_unaffected", "ok"));
	}

	@Test
	public void shouldShowAsterisksForBlacklistedEnvVarsByRegexAndSystemPropertiesInHideMode()
	{
		// given
		final Map<String, String> settings = ImmutableMap.<String, String> builder() //
				.put("db.username", "admin") //
				.put("db.password", "nimda") //
				.put("y_db_user", "admin") //
				.put("y_db_password", "nimda") //
				.put("y_unaffected", "ok").build();

		final Map<String, String> regexRules = ImmutableMap.<String, String> builder() //
				.put("configuration.view.regex.rule.db", "db\\.") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> settings, () -> asProperties(settings),
				() -> mockHideConfiguration(emptyMap(), regexRules, Collections.emptyMap()));

		// when
		final Map<String, String> envVariables = viewService.readEnvVariables();
		final Properties properties = viewService.readSystemProperties();

		// then
		assertThat(envVariables).containsOnly( //
				entry("db.username", HIDDEN_VALUE), //
				entry("db.password", HIDDEN_VALUE), //
				entry("y_db_user", HIDDEN_VALUE), //
				entry("y_db_password", HIDDEN_VALUE), //
				entry("y_unaffected", "ok"));
		assertThat(Maps.fromProperties(properties)).containsOnly( //
				entry("db.username", HIDDEN_VALUE), //
				entry("db.password", HIDDEN_VALUE), //
				entry("y_db_user", HIDDEN_VALUE), //
				entry("y_db_password", HIDDEN_VALUE), //
				entry("y_unaffected", "ok"));
	}

	@Test
	public void shouldShowAsterisksForBlacklistedEnvVarsAndSystemPropertiesInHideMode()
	{
		// given
		final Map<String, String> settings = ImmutableMap.<String, String> builder() //
				.put("y_ldap_username", "foo") //
				.put("y_ldap_password", "bar") //
				.put("y_db_user", "admin") //
				.put("y_db_password", "nimda") //
				.put("y_unaffected", "ok").build();

		final Map<String, String> blacklist = ImmutableMap.<String, String> builder() //
				.put("ldap", "y_ldap_username,y_ldap_password") //
				.put("db", "y_db_user,y_db_password") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> settings, () -> asProperties(settings),
				() -> mockHideConfiguration(blacklist, emptyMap(), Collections.emptyMap()));

		// when
		final Map<String, String> safeEnvVariables = viewService.readEnvVariables();
		final Properties safeSystemProperties = viewService.readSystemProperties();

		// then
		assertThat(safeEnvVariables).containsOnly( //
				entry("y_ldap_username", HIDDEN_VALUE), //
				entry("y_ldap_password", HIDDEN_VALUE), //
				entry("y_db_user", HIDDEN_VALUE), //
				entry("y_db_password", HIDDEN_VALUE), //
				entry("y_unaffected", "ok"));

		assertThat(Maps.fromProperties(safeSystemProperties)).containsOnly( //
				entry("y_ldap_username", HIDDEN_VALUE), //
				entry("y_ldap_password", HIDDEN_VALUE), //
				entry("y_db_user", HIDDEN_VALUE), //
				entry("y_db_password", HIDDEN_VALUE), //
				entry("y_unaffected", "ok"));
	}

	@Test
	public void shouldAdjustPropertiesBlacklistToMatchEnvironmentPropertyFormat()
	{
		// given
		final Map<String, String> settings = ImmutableMap.<String, String> builder() //
				.put("y_ldap_username", "foo") //
				.put("y_ldap_password", "bar") //
				.put("y_db_user", "admin") //
				.put("y_db_password", "nimda") //
				.put("y_unaffected", "ok").build();

		final Map<String, String> blacklist = ImmutableMap.<String, String> builder() //
				.put("db", "db.user,db.password") //
				.put("ldap", "ldap.username,ldap.password") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> settings, () -> asProperties(settings),
				() -> mockHideConfiguration(blacklist, emptyMap(), Collections.emptyMap()));

		// when
		final Map<String, String> safeEnvVariables = viewService.readEnvVariables();
		final Properties safeSystemProperties = viewService.readSystemProperties();

		// then
		assertThat(safeEnvVariables).containsOnly( //
				entry("y_ldap_username", HIDDEN_VALUE), //
				entry("y_ldap_password", HIDDEN_VALUE), //
				entry("y_db_user", HIDDEN_VALUE), //
				entry("y_db_password", HIDDEN_VALUE), //
				entry("y_unaffected", "ok"));

		assertThat(Maps.fromProperties(safeSystemProperties)).containsOnly( //
				entry("y_ldap_username", HIDDEN_VALUE), //
				entry("y_ldap_password", HIDDEN_VALUE), //
				entry("y_db_user", HIDDEN_VALUE), //
				entry("y_db_password", HIDDEN_VALUE), //
				entry("y_unaffected", "ok"));
	}

	@Test
	public void shouldIgnoreCaseForBlacklistEntries()
	{
		// given
		final Map<String, String> properties = ImmutableMap.<String, String> builder() //
				.put("db.username", "admin") //
				.put("db.password", "nimda") //
				.put("unaffected", "ok").build();

		final Map<String, String> blacklist = ImmutableMap.<String, String> builder() //
				.put("db", "dB.UserName,db.Password") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(), () -> new Properties(),
				() -> mockRemoveConfiguration(blacklist, emptyMap(), properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).containsOnly(entry("unaffected", "ok"));
	}

	@Test
	public void shouldNotDisplayPropertiesWithUppercaseWhenBlacklisted()
	{
		// given
		final Map<String, String> properties = ImmutableMap.<String, String> builder() //
				.put("dB.UserNaMe", "admin") //
				.put("db.PASSWORD", "nimda") //
				.put("unaffected", "ok").build();

		final Map<String, String> blacklist = ImmutableMap.<String, String> builder() //
				.put("db", "db.Username,db.Password") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(), () -> new Properties(),
				() -> mockRemoveConfiguration(blacklist, emptyMap(), properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).containsOnly(entry("unaffected", "ok"));
	}

	@Test
	public void shouldShowAsterisksForPropertiesWithUppercaseWhenBlacklisted()
	{
		// given
		final Map<String, String> properties = ImmutableMap.<String, String> builder() //
				.put("dB.UserNaMe", "admin") //
				.put("db.PASSWORD", "nimda") //
				.put("unaffected", "ok").build();

		final Map<String, String> blacklist = ImmutableMap.<String, String> builder() //
				.put("db", "db.Username,db.Password") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(), () -> new Properties(),
				() -> mockHideConfiguration(blacklist, emptyMap(), properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).containsOnly( //
				entry("dB.UserNaMe", HIDDEN_VALUE), //
				entry("db.PASSWORD", HIDDEN_VALUE), //
				entry("unaffected", "ok"));
	}

	@Test
	public void shouldAllowCaseInsensitiveBlacklistRules()
	{
		// given
		final Map<String, String> properties = ImmutableMap.<String, String> builder() //
				.put("ldap.Password", "bar") //
				.put("db.passWord", "nimda") //
				.put("unaffected", "ok").build();

		final Map<String, String> regexRules = ImmutableMap.<String, String> builder() //
				.put("configuration.view.regex.rule.test.password", "pass") //
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(),
				() -> new Properties(), () -> mockRemoveConfiguration(emptyMap(), regexRules, properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).containsOnly(entry("unaffected", "ok"));
	}

	private static Properties asProperties(final Map<String, String> properties)
	{
		final Properties props = new Properties();
		props.putAll(properties);
		return props;
	}

	private ConfigIntf mockHideConfiguration(final Map<String, String> blacklist, final Map<String, String> regexRules,
			final Map<String, String> properties)
	{
		return mockConfiguration(blacklist, regexRules, properties, "hide");
	}

	private ConfigIntf mockRemoveConfiguration(final Map<String, String> blacklist, final Map<String, String> regexRules,
			final Map<String, String> properties)
	{
		return mockConfiguration(blacklist, regexRules, properties, "remove");
	}

	public static ConfigIntf mockConfiguration(final Map<String, String> blacklist, final Map<String, String> regexRules,
			final Map<String, String> properties, final String strategy)
	{
		final ConfigIntf config = mock(ConfigIntf.class);
		when(config.getParametersMatching(SecureConfigurationViewService.BLACKLIST_EXACT_MATCH, true)).thenReturn(blacklist);
		when(config.getParametersMatching(SecureConfigurationViewService.BLACKLIST_REGEX_RULE, true)).thenReturn(regexRules);
		when(config.getAllParameters()).thenReturn(properties);

		when(config.getString(SecureConfigurationViewService.CONFIGURATION_VIEW_STRATEGY,
				SecureConfigurationViewService.REMOVE_STRATEGY)).thenReturn(strategy);

		when(config.getString(ConfigUtil.ENV_PROPERTIES_PREFIX, "y_")).thenReturn("y_");

		return config;
	}
}
