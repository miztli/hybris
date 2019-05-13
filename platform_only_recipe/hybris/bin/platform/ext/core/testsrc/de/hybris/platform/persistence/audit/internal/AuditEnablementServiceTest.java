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
package de.hybris.platform.persistence.audit.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class AuditEnablementServiceTest extends ServicelayerBaseTest
{
	@Resource(name = "auditingEnablementService")
	private AuditEnablementService auditEnablementService;
	@Resource
	private TypeService typeService;
	private final PropertyConfigSwitcher auditingEnabledFlag = getConfigSwitcherForAuditingEnabledFlag();
	private final PropertyConfigSwitcher flagForAllTyes = getConfigSwitcherForAllTypesFlag();
	private final PropertyConfigSwitcher flagForUserType = getConfigSwitcherForType("user");
	private final PropertyConfigSwitcher flagForBlacklistedType = getConfigSwitcherForType("itemsynctimestamp");
	private final PropertyConfigSwitcher flagForItem = getConfigSwitcherForType("item");
	private final PropertyConfigSwitcher flagForProcessTask = getConfigSwitcherForType("processtask");
	private final PropertyConfigSwitcher blacklistConfiguration = getConfigSwitcherForAuditingBlacklist();

	private final PropertyConfigSwitcher flagForCapitalUser = getConfigSwitcherForType("User");
	private final PropertyConfigSwitcher flagForPokemonCatalog = getConfigSwitcherForType("CaTaLoG");

	private PK typePkForUser;
	private PK typePkForEmployee;

	@Before
	public void setUp() throws Exception
	{
		typePkForUser = typeService.getComposedTypeForCode("User").getPk();
		typePkForEmployee = typeService.getComposedTypeForCode("Employee").getPk();
	}

	@After
	public void tearDown() throws Exception
	{
		auditingEnabledFlag.switchBackToDefault();
		flagForUserType.switchBackToDefault();
		flagForBlacklistedType.switchBackToDefault();
		flagForItem.switchBackToDefault();
		flagForProcessTask.switchBackToDefault();
		flagForAllTyes.switchBackToDefault();

		flagForCapitalUser.switchBackToDefault();
		flagForCapitalUser.switchBackToDefault();
		flagForPokemonCatalog.switchBackToDefault();

		auditEnablementService.refreshConfiguredAuditTypes();
		blacklistConfiguration.switchBackToDefault();
	}

	@Test
	public void shouldHaveAuditEnabledForTypeWhichIsNotConfiguredDirectlyButFlagForAllTypesIsEnabled() throws Exception
	{
		// given
		auditingEnabledFlag.switchToValue("true");
		flagForAllTyes.switchToValue("true");
		final PK mediaTypePk = typeService.getComposedTypeForCode("Media").getPk();

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(mediaTypePk);

		// then
		assertThat(auditEnabled).isTrue();
	}

	@Test
	public void shouldHaveAuditDisabledWhenGlobalFlagIsSetToFalse() throws Exception
	{
		// given
		auditingEnabledFlag.switchToValue("false");

		// when
		final boolean enabledGlobally = auditEnablementService.isAuditEnabledGlobally();

		// then
		assertThat(enabledGlobally).isFalse();
	}

	@Test
	public void shouldHaveAuditEnabledWhenGlobalFlagIsSetToTrue() throws Exception
	{
		// given
		auditingEnabledFlag.switchToValue("true");

		// when
		final boolean enabledGlobally = auditEnablementService.isAuditEnabledGlobally();

		// then
		assertThat(enabledGlobally).isTrue();
	}

	@Test
	public void shouldHaveAuditDisabledForAnyTypeIfAuditIsDisabledGlobally() throws Exception
	{
		// given
		auditingEnabledFlag.switchToValue("false");

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(typePkForUser);

		// then
		assertThat(auditEnabled).isFalse();
	}

	@Test
	public void shouldHaveAuditDisabledForTypeWhichIsNotConfigured() throws Exception
	{
		// given
		auditingEnabledFlag.switchToValue("true");
		flagForAllTyes.switchToValue("false");
		final PK mediaTypePk = typeService.getComposedTypeForCode("Media").getPk();

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(mediaTypePk);

		// then
		assertThat(auditEnabled).isFalse();
	}

	@Test
	public void shouldHaveAuditDisabledForBlacklistedTypeEvenItIsConfiguredByUser() throws Exception
	{
		// given
		flagForAllTyes.switchToValue("false");
		auditingEnabledFlag.switchToValue("true");
		flagForBlacklistedType.switchToValue("true");
		blacklistConfiguration.switchToValue("itemsynctimestamp");
		auditEnablementService.refreshConfiguredAuditTypes();
		final PK typePk = typeService.getComposedTypeForCode("ItemSyncTimestamp").getPk();

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(typePk);

		// then
		assertThat(auditEnabled).isFalse();
	}

	@Test
	public void shouldHaveAuditDisabledForBlacklistedTypeEvenIfAuditIsEnabledForAllTypes() throws Exception
	{
		// given
		flagForAllTyes.switchToValue("true");
		auditingEnabledFlag.switchToValue("true");
		blacklistConfiguration.switchToValue("itemsynctimestamp");
		auditEnablementService.refreshConfiguredAuditTypes();
		final PK typePk = typeService.getComposedTypeForCode("ItemSyncTimestamp").getPk();

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(typePk);

		// then
		assertThat(auditEnabled).isFalse();
	}

	@Test
	public void shouldHaveAuditDisabledForBlacklistedTypeEvenIfAuditIsEnabledForSuperTypeOfBlacklistedOne() throws Exception
	{
		// given
		flagForAllTyes.switchToValue("true");
		auditingEnabledFlag.switchToValue("true");
		flagForItem.switchToValue("true");
		blacklistConfiguration.switchToValue("itemsyncTimestamp");
		auditEnablementService.refreshConfiguredAuditTypes();
		final PK typePk = typeService.getComposedTypeForCode("ItemSyncTimestamp").getPk();

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(typePk);

		// then
		assertThat(auditEnabled).isFalse();
	}

	@Test
	public void shouldHaveAuditDisabledForTypeIfAuditrSuperTypeIsBlacklisted() throws Exception
	{
		// given
		flagForAllTyes.switchToValue("true");
		auditingEnabledFlag.switchToValue("true");
		flagForProcessTask.switchToValue("true");
		blacklistConfiguration.switchToValue("processtask");
		auditEnablementService.refreshConfiguredAuditTypes();
		final PK typePk = typeService.getComposedTypeForCode("ProcessTask").getPk();

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(typePk);

		// then
		assertThat(auditEnabled).isFalse();
	}

	@Test
	public void shouldHaveAuditDisabledForSubTypeIfNotSetInConfigAndSuperTypeIsDisabledInConfig() throws Exception
	{
		// given
		flagForAllTyes.switchToValue("false");
		auditingEnabledFlag.switchToValue("true");
		flagForUserType.switchToValue("false");
		// no config for customer
		auditEnablementService.refreshConfiguredAuditTypes();
		final PK typePk = typeService.getComposedTypeForCode("Customer").getPk();

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(typePk);

		// then
		assertThat(auditEnabled).isFalse();
	}

	@Test
	public void shouldHaveAuditEnabledForUserTypeWhenItIsSetInConfigurationAndGlobalFlagIsEnabled() throws Exception
	{
		// given
		flagForAllTyes.switchToValue("false");
		auditingEnabledFlag.switchToValue("true");
		flagForUserType.switchToValue("true");
		auditEnablementService.refreshConfiguredAuditTypes();

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(typePkForUser);

		// then
		assertThat(auditEnabled).isTrue();
	}

	@Test
	public void shouldHaveAuditEnabledForSubTypeWhenSupertpeIsSetInConfigurationAndGlobalFlagIsEnabled() throws Exception
	{
		// given
		flagForAllTyes.switchToValue("false");
		auditingEnabledFlag.switchToValue("true");
		flagForUserType.switchToValue("true");
		auditEnablementService.refreshConfiguredAuditTypes();

		// when
		final boolean auditEnabled = auditEnablementService.isAuditEnabledForType(typePkForEmployee);

		// then
		assertThat(auditEnabled).isTrue();
	}

	@Test
	public void shouldHaveAuditEnabledForProcessTaskTypeAfterRemoveProcessTaskFromBlacklist() throws Exception
	{
		// given
		blacklistConfiguration.switchToValue("processtask,itemsyncTimestamp");

		flagForAllTyes.switchToValue("true");
		auditingEnabledFlag.switchToValue("true");

		auditEnablementService.refreshConfiguredAuditTypes();

		// when
		final PK processTaskPk = typeService.getComposedTypeForCode("ProcessTask").getPk();

		boolean auditEnabledForProcessTask = auditEnablementService.isAuditEnabledForType(processTaskPk);
		final PK typeItemSyncTimestampPk = typeService.getComposedTypeForCode("ItemSyncTimestamp").getPk();
		boolean auditEnabledForItemSyncTimestamp = auditEnablementService.isAuditEnabledForType(typeItemSyncTimestampPk);

		// then
		assertThat(auditEnabledForProcessTask).isFalse();
		assertThat(auditEnabledForItemSyncTimestamp).isFalse();
		//given
		blacklistConfiguration.switchToValue("itemsyncTimestamp");
		auditEnablementService.refreshConfiguredAuditTypes();
		// when
		auditEnabledForProcessTask = auditEnablementService.isAuditEnabledForType(processTaskPk);
		auditEnabledForItemSyncTimestamp = auditEnablementService.isAuditEnabledForType(typeItemSyncTimestampPk);
		//then
		assertThat(auditEnabledForProcessTask).isTrue();
		assertThat(auditEnabledForItemSyncTimestamp).isFalse();

	}

	@Test
	public void shouldThrowExceptionIfAuditPropertyDefinedTwice()
	{
		flagForUserType.switchToValue("false");
		flagForCapitalUser.switchToValue("true");

		try
		{
			auditEnablementService.refreshConfiguredAuditTypes();
			fail("Expected auditEnablementService to throw an exception");
		}
		catch (final Exception ex)
		{
			assertThat(ex).isInstanceOf(AuditConfigurationException.class);
			final AuditConfigurationException auditConfigException = (AuditConfigurationException) ex;
			assertThat(auditConfigException.getViolatingProperties()).containsOnly("audit.User.enabled");
		}
	}

	@Test
	public void shouldThrowExceptionForNonLowercaseProperty()
	{
		flagForPokemonCatalog.switchToValue("true");

		try
		{
			auditEnablementService.refreshConfiguredAuditTypes();
			fail("Expected auditEnablementService to throw an exception");
		}
		catch (final Exception ex)
		{
			assertThat(ex).isInstanceOf(AuditConfigurationException.class);
			final AuditConfigurationException auditConfigException = (AuditConfigurationException) ex;
			assertThat(auditConfigException.getViolatingProperties()).containsOnly("audit.CaTaLoG.enabled");
		}
	}


	private PropertyConfigSwitcher getConfigSwitcherForAllTypesFlag()
	{
		return new PropertyConfigSwitcher(AuditEnablementService.AUDITING_FOR_ALL_TYPES);
	}

	private PropertyConfigSwitcher getConfigSwitcherForAuditingEnabledFlag()
	{
		return new PropertyConfigSwitcher(AuditEnablementService.AUDITING_ENABLED);
	}

	private PropertyConfigSwitcher getConfigSwitcherForType(final String type)
	{
		return new PropertyConfigSwitcher("audit." + type + ".enabled");
	}

	private PropertyConfigSwitcher getConfigSwitcherForAuditingBlacklist()
	{
		return new PropertyConfigSwitcher(AuditEnablementService.AUDITING_BLACKLIST);
	}

}
