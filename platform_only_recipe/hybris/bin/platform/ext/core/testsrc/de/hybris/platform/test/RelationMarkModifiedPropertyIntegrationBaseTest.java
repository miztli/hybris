/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 *
 */

package de.hybris.platform.test;


import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;
import de.hybris.platform.testframework.seed.TestDataCreator;
import de.hybris.platform.util.Utilities;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public abstract class RelationMarkModifiedPropertyIntegrationBaseTest extends ServicelayerBaseTest
{

	private static final int MILLIS = 10;
	@Resource
	private ModelService modelService;

	private final PropertyConfigSwitcher persistenceLegacyMode = new PropertyConfigSwitcher("persistence.legacy.mode");
	private final PropertyConfigSwitcher relationMarkModified = new PropertyConfigSwitcher(
			"relation.PrincipalGroupRelation.markmodified");
	private UserModel testUser;
	private UserGroupModel testGroup;

	private final boolean persistenceLegacyModeValue;

	public RelationMarkModifiedPropertyIntegrationBaseTest(final boolean persistenceLegacyModeValue)
	{
		this.persistenceLegacyModeValue = persistenceLegacyModeValue;
	}

	@Before
	public void setUp() throws Exception
	{
		persistenceLegacyMode.switchToValue(Boolean.toString(persistenceLegacyModeValue));

		final TestDataCreator testDataCreator = new TestDataCreator(modelService);

		testUser = testDataCreator.createUser(UUID.randomUUID().toString(), "testUser");
		testGroup = testDataCreator.createUserGroup(UUID.randomUUID().toString(), "testGroup");


	}

	@After
	public void tearDown() throws Exception
	{
		persistenceLegacyMode.switchBackToDefault();
		relationMarkModified.switchBackToDefault();
	}

	@Test
	public void shouldUpdateTimestampWhenAddingLinkWhileRelationPropertyIsTrue() throws InterruptedException
	{
		final Date userDate1 = testUser.getModifiedtime();

		setRelationMarkModified(true);

		//when
		Thread.sleep(MILLIS);
		testGroup.setMembers(Collections.singleton(testUser));

		modelService.save(testGroup);
		modelService.refresh(testUser);
		final Date userDate2 = testUser.getModifiedtime();

		assertThat(userDate1).isBefore(userDate2);
	}

	private void setRelationMarkModified(final boolean value)
	{
		relationMarkModified.switchToValue(Boolean.toString(value));
		Utilities.clearMarkModifiedOverrideCache();
	}


	@Test
	public void shouldNotUpdateTimestampWhenAddingLinkWhileRelationPropertyIsFalse() throws InterruptedException
	{
		final Date userDate1 = testUser.getModifiedtime();

		setRelationMarkModified(false);

		//when
		Thread.sleep(MILLIS);
		testGroup.setMembers(Collections.singleton(testUser));

		modelService.save(testGroup);
		modelService.refresh(testUser);

		final Date userDate2 = testUser.getModifiedtime();

		assertThat(userDate1).isEqualTo(userDate2);
	}


	@Test
	public void shouldUpdateTimestampWhenRemovingLinkWhileRelationPropertyIsTrue() throws InterruptedException
	{
		setRelationMarkModified(true);

		testUser.setGroups(Collections.singleton(testGroup));

		modelService.save(testUser);
		modelService.refresh(testUser);

		final Date userDate1 = testUser.getModifiedtime();

		//when
		Thread.sleep(MILLIS);
		testGroup.setMembers(Collections.emptySet());
		modelService.save(testGroup);

		//then
		modelService.refresh(testUser);
		final Date userDate2 = testUser.getModifiedtime();
		assertThat(userDate1).isBefore(userDate2);
	}


	@Test
	public void shouldNotUpdateTimestampWhenRemovingLinkWhileRelationPropertyIsFalse() throws InterruptedException
	{

		setRelationMarkModified(false);

		testUser.setGroups(Collections.singleton(testGroup));

		modelService.save(testUser);
		modelService.refresh(testUser);

		final Date userDate1 = testUser.getModifiedtime();

		//when
		Thread.sleep(MILLIS);
		testGroup.setMembers(Collections.emptySet());
		modelService.save(testUser);

		//then
		modelService.refresh(testUser);
		final Date userDate2 = testUser.getModifiedtime();
		assertThat(userDate1).isEqualTo(userDate2);
	}


	@Test
	public void shouldUpdateTimestampWhenRemovingTargetWhileRelationPropertyIsTrue() throws InterruptedException
	{
		setRelationMarkModified(true);

		testUser.setGroups(Collections.singleton(testGroup));

		modelService.save(testUser);
		modelService.refresh(testUser);

		final Date userDate1 = testUser.getModifiedtime();

		//when
		Thread.sleep(MILLIS);
		modelService.remove(testGroup);

		//then
		modelService.refresh(testUser);
		final Date userDate2 = testUser.getModifiedtime();
		assertThat(userDate1).isBefore(userDate2);
	}


	@Test
	public void shouldNotUpdateTimestampWhenRemovingTargetWhileRelationPropertyIsFalse() throws InterruptedException
	{

		setRelationMarkModified(false);

		testUser.setGroups(Collections.singleton(testGroup));

		modelService.save(testUser);
		modelService.refresh(testUser);

		final Date userDate1 = testUser.getModifiedtime();

		//when
		Thread.sleep(MILLIS);
		modelService.remove(testGroup);

		//then
		modelService.refresh(testUser);
		final Date userDate2 = testUser.getModifiedtime();
		assertThat(userDate1).isEqualTo(userDate2);
	}
}
