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
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.config.impl.SecureConfigurationViewService;
import de.hybris.platform.util.config.ConfigIntf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.util.Collections.emptyMap;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class SecureConfigurationViewServiceFunctionalTest
{
	private static final String HIDDEN_VALUE = "*****";
	final private Map<String, String> properties;
	final private Map<String, String> envVariables;
	final private Map<String, String> mergedProperties;

	private Map<String, String> blacklist;
	private Map<String, String> regexRules;

	private final Map.Entry<String,String>[] MAP_ENTRY_ARRAY_TYPE = new Map.Entry[]{};

	public SecureConfigurationViewServiceFunctionalTest()
	{
		properties = prepareTestDataAsProperties();
		envVariables = prepareTestDataAsEnvVariables();
		mergedProperties = ImmutableMap.<String,String> builder()
				.putAll(properties)
				.putAll(envVariables)
				.build();
	}

	@Before
	public void prepareTest()
	{
		// given
		blacklist = emptyMap();
		regexRules = emptyMap();
	}

	@Test
	public void shouldAllowAllIfNothingBlacklisted()
	{
		// given
		// defaults

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties);
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldApplySingleBlacklist()
	{
		// given
		blacklist = ImmutableMap.of("db", "db.password");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties, "db.password", "y_db_password");
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldApplyMultiBlacklist()
	{
		// given
		blacklist = ImmutableMap.of("db", "db.password,db.username");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties, "db.username", "db.password", "y_db_username", "y_db_password");
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldApplyMergedBlacklist()
	{
		// given
		blacklist = ImmutableMap.of(
				"db", "db.password,db.username",
				"ldap", "ldap.password");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"db.username",
				"db.password",
				"ldap.password",
				"y_db_username",
				"y_db_password",
				"y_ldap_password");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));

	}

	@Test
	public void shouldApplySingleRegex()
	{
		// given
		regexRules = ImmutableMap.of("configuration.view.regex.rule.test.password", "^[^0-9]+password$"); // ignoring uppercase test data, they are not a subject of this test

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"db.password",
				"mysql.db.password",
				"hsql.db.password",
				"ldap.password",
				"y_db_password",
				"y_mysql_db_password",
				"y_hsql_db_password",
				"y_ldap_password");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldApplyMergedRegex()
	{
		// given
		regexRules = ImmutableMap.of(
				"configuration.view.regex.rule.test.allpasswords", "password$",
				"configuration.view.regex.rule.test.passwordclass", "password\\.");


		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
			"db.password",
			"mysql.db.password",
			"hsql.db.password",
			"ldap.password",
			"password.encoder",
			"password.encoder.keylength",
			"password.expired",
			"password.min.length",
			"y_db_password",
			"y_mysql_db_password",
			"y_hsql_db_password",
			"y_ldap_password",
			"y_password_encoder",
			"y_password_encoder.keylength",
			"y_password_expired",
			"y_password_min_length",
			"UpperCase1.password",
			"uppercase2.PassWord",
			"UPPERCASE3.PASSWORD",
			"y_UpperCase4_password",
			"y_uppercase5_PassWord",
			"Y_UPPERCASE6_PASSWORD");
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldIgnoreLetterCaseInBlacklist()
	{
		// given
		blacklist = ImmutableMap.of(
				"types", "types.EMPTY,Types.int",
				"Types", "types.array,Types.Boolean,types.Empty,Types.blank");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"types.boolean",
				"types.array",
				"types.empty",
				"types.blank",
				"types.int",
				"y_types_boolean",
				"y_types_array",
				"y_types_empty",
				"y_types_blank",
				"y_types_int");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));

	}

	@Test
	public void shouldIgnoreLetterCaseInRegex()
	{
		// given
		regexRules = ImmutableMap.of(
				"configuration.view.regex.rule.test.types.case.default", "Empty$",
				"configuration.view.regex.rule.test.types.case.insensitive", "(?i)Username$",
				"configuration.view.regex.rule.test.types.case.sensitive", "(?-i)Encoder$");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"db.username",
				"ldap.username",
				"types.empty",
				"y_db_username",
				"y_ldap_username",
				"y_types_empty");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldBlacklistIgnoreLetterCase()
	{
		// given
		blacklist = ImmutableMap.<String, String> builder()
				.put("case1", "uppercase1.password")
				.put("case2", "uppercase2.password")
				.put("case3", "uppercase3.password")
				.put("case4", "uppercase4.password")
				.put("case5", "uppercase5.password")
				.put("case6", "uppercase6.password")
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"UpperCase1.password",
				"uppercase2.PassWord",
				"UPPERCASE3.PASSWORD",
				"y_UpperCase4_password",
				"y_uppercase5_PassWord",
				"Y_UPPERCASE6_PASSWORD");

		System.out.println(mergedProperties);
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldRegexIgnoreLetterCase()
	{
		// given
		regexRules = ImmutableMap.of("configuration.view.regex.rule.test.types.case.default", "uppercase");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"UpperCase1.password",
				"uppercase2.PassWord",
				"UPPERCASE3.PASSWORD",
				"y_UpperCase4_password",
				"y_uppercase5_PassWord",
				"Y_UPPERCASE6_PASSWORD");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}
	@Test
	public void shouldApplyNonexistentBlacklist()
	{
		// given
		blacklist = ImmutableMap.of("types", "types.nonexistent");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties);
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldApplyBlankEntryBlacklist()
	{
		// given
		blacklist = ImmutableMap.of(" ", " ");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				" ",
				"y_ "
		);

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldApplyEmptyEntryBlacklist()
	{
		// given
		blacklist = ImmutableMap.of("", "");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"",
				"y_"
		);

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldNotApplyIncompleteEntryBlacklist()
	{
		// given
		blacklist = ImmutableMap.<String, String> builder()
				.put("db", "db.p,db.u")
				.put("ldap", "ldap.usernam")
				.put("types", "types.")
				.put("hsql", "hsql")
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties);
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldAcceptAnyKeyNameInBlacklist()
	{
		// given
		blacklist = ImmutableMap.<String, String> builder()
				.put("nonexistent", "db.password")
				.put(" ", "db.username")
				.put("", "ldap.username")
				.put("!@#$%^&*()_+{}\\|}{:\"'?><<>?~`", "hsql.db.password")
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"db.password",
				"db.username",
				"ldap.username",
				"hsql.db.password",
				"y_db_password",
				"y_db_username",
				"y_ldap_username",
				"y_hsql_db_password");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldApplyEdgeRegex()
	{
		// given
		regexRules = ImmutableMap.<String, String> builder() //
				.put("configuration.view.regex.rule.test.types.empty", "empty")
				.put("configuration.view.regex.rule.test.types.nonexistent", "nonexistent")
				.put("configuration.view.regex.rule.test.types.space", "\\s+")
				.build();

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"types.empty",
				" ",
				"   ",
				"y_types_empty",
				"y_ ",
				"y_   ");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldIgnoreBlankRegex()
	{
		// given
		regexRules = ImmutableMap.of(
				"configuration.view.regex.rule.empty", "",
				"configuration.view.regex.rule.blank", " ");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties);
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldBePossibleToRemoveAllByRegex()
	{
		// given
		regexRules = ImmutableMap.of("configuration.view.regex.rule.test", ".*");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		assertThat(safeProperties).isEmpty();
	}

	@Test
	public void shouldHideByBlacklist()
	{
		// given
		blacklist = ImmutableMap.of(
				"a", "db.password",
				"b", "db.username");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockHideConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithReplacement(mergedProperties,
				"db.password",
				"db.username",
				"y_db_password",
				"y_db_username");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldHideByRegex()
	{
		// given
		regexRules = ImmutableMap.of(
				"configuration.view.regex.rule.test.types.db.pass", "expired",
				"configuration.view.regex.rule.test.types.encoder", "encoder$");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockHideConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithReplacement(mergedProperties,
				"password.expired",
				"password.encoder",
				"y_password_encoder",
				"y_password_expired");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldHideByBlacklistAndRegex()
	{
		// given
		blacklist = ImmutableMap.of("db", "db.password");
		regexRules = ImmutableMap.of("configuration.view.regex.rule.test.types.db.pass", "expired");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockHideConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithReplacement(mergedProperties,
				"db.password",
				"password.expired",
				"y_db_password",
				"y_password_expired");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldRemoveByBlacklistAndRegex()
	{
		// given
		blacklist = ImmutableMap.of("db", "db.password");
		regexRules = ImmutableMap.of("configuration.view.regex.rule.test.types.db.pass", "expired");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(properties),
				() -> mockRemoveConfiguration(blacklist, regexRules, mergedProperties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithoutEntries(mergedProperties,
				"db.password",
				"password.expired",
				"y_db_password",
				"y_password_expired");

		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldHidePropertiesOnlyByBlacklist()
	{
		// given
		blacklist = ImmutableMap.of("db", "db.password");
		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(), () -> asProperties(properties),
				() -> mockHideConfiguration(blacklist, regexRules, properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithReplacement(properties, "db.password");
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldHideEnvOnlyByBlacklist()
	{
		// given
		blacklist = ImmutableMap.of("db", "db.password");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(emptyMap()),
				() -> mockHideConfiguration(blacklist, regexRules, envVariables));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithReplacement(envVariables, "y_db_password");
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	@Test
	public void shouldHidePropertiesOnlyByRegex()
	{
		// given
		regexRules = ImmutableMap.of("configuration.view.regex.rule.test.types.db.pass", "expired");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> emptyMap(), () -> asProperties(properties),
				() -> mockHideConfiguration(blacklist, regexRules, properties));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithReplacement(properties, "password.expired");
		assertThat(safeProperties).containsOnly(asEntryArray(expected));

	}

	@Test
	public void shouldHideEnvOnlyByRegex()
	{
		// given
		regexRules = ImmutableMap.of("configuration.view.regex.rule.test.types.db.pass", "expired");

		final ConfigurationViewService viewService = new SecureConfigurationViewService(() -> envVariables, () -> asProperties(emptyMap()),
				() -> mockHideConfiguration(blacklist, regexRules, envVariables));

		// when
		final Map<String, String> safeProperties = viewService.readConfigParameters();

		// then
		final Map<String,String> expected = copyMapWithReplacement(envVariables, "y_password_expired");
		assertThat(safeProperties).containsOnly(asEntryArray(expected));
	}

	private Map<String, String> prepareTestDataAsProperties()
	{
		return ImmutableMap.<String, String> builder() //
				.put("db.username", "admin") //
				.put("db.password", "nimda") //
				.put("mysql.db.password", "root")
				.put("hsql.db.password", "toor")
				.put("ldap.username", "ldap_foo")
				.put("ldap.password", "ldap_bar") //
				.put("password.encoder", "foo") //
				.put("password.encoder.keylength", "32") //
				.put("password.expired", "true")
				.put("password.min.length", "6")
				.put("UpperCase1.password", "foo")
				.put("uppercase2.PassWord", "foo")
				.put("UPPERCASE3.PASSWORD", "foo")
				.put("types.boolean", "true")
				.put("types.array", "admin,customer,editor")
				.put("types.empty", "")
				.put("types.blank", " ")
				.put("types.int", "0")
				.put("types.null.string", "null")
				.put("", "empty_name")
				.put(" ", "blank_name")
				.put("   ", "blank_name_multispace")
				.put("unaffected", "ok")
				.build();
	}

	private Map<String, String> prepareTestDataAsEnvVariables()
	{
		return ImmutableMap.<String, String> builder()
				.put("y_db_username", "admin")
				.put("y_db_password", "nimda")
				.put("y_mysql_db_password", "root")
				.put("y_hsql_db_password", "toor")
				.put("y_ldap_username", "ldap_foo")
				.put("y_ldap_password", "ldap_bar") //
				.put("y_password_encoder", "foo") //
				.put("y_password_encoder.keylength", "32") //
				.put("y_password_expired", "true")
				.put("y_password_min_length", "6")
				.put("y_UpperCase4_password", "foo")
				.put("y_uppercase5_PassWord", "foo")
				.put("Y_UPPERCASE6_PASSWORD", "foo")
				.put("y_types_boolean", "true")
				.put("y_types_array", "admin,customer,editor")
				.put("y_types_empty", "")
				.put("y_types_blank", " ")
				.put("y_types_int", "0")
				.put("y_types_null_string", "null")
				.put("y_", "empty_name")
				.put("y_ ", "blank_name")
				.put("y_   ", "blank_name_multispace")
				.put("y_unaffected", "ok")
				.build();
	}

	/**
	 * Private helper to convert Map&lt;&gt; into array of Map.Entry&lt;&gt;, which can be used in MapAssertion
	 * instead of varargs.
	 * Easier to maintain expected results, while keeping same test data everywhere.
	 * @param map - any Map implementation
	 * @return Map.Entry&lt;String,String&gt;[]
	 */
	private Map.Entry<String,String>[] asEntryArray(final Map<String,String> map)
	{
		return map.entrySet().toArray(MAP_ENTRY_ARRAY_TYPE);
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
		return SecureConfigurationViewServiceTest.mockConfiguration(blacklist, regexRules, properties, "hide");
	}

	private ConfigIntf mockRemoveConfiguration(final Map<String, String> blacklist, final Map<String, String> regexRules,
			final Map<String, String> properties)
	{
		return SecureConfigurationViewServiceTest.mockConfiguration(blacklist, regexRules, properties, "remove");
	}

	private Map<String,String> copyMapWithoutEntries(final Map<String,String> source, final String... toBeRemoved)
	{
		final Map<String,String> target = new HashMap<>(source);
		for(final String item : toBeRemoved)
			target.remove(item);

		return target;
	}

	private Map<String,String> copyMapWithReplacement(final Map<String,String> source, final String... toBeReplaced)
	{
		final Map<String,String> target = new HashMap<>(source);
		for(final String item : toBeReplaced)
			target.replace(item, HIDDEN_VALUE);

		return target;
	}
}
