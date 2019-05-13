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
package de.hybris.platform.retention;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.core.model.user.UserGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cronjob.model.JobModel;
import de.hybris.platform.processing.model.AfterRetentionCleanupRuleModel;
import de.hybris.platform.retention.impl.AfterRetentionCleanupItemsProvider;
import de.hybris.platform.retention.impl.BasicRemoveCleanupAction;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.cronjob.CronJobService;
import de.hybris.platform.servicelayer.internal.model.RetentionJobModel;
import de.hybris.platform.servicelayer.locking.ItemLockingService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.servicelayer.user.UserService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class AfterRetentionCleanupItemsProviderTest extends ServicelayerBaseTest

{
	@Resource
	protected ModelService modelService;

	@Resource
	protected FlexibleSearchService flexibleSearchService;

	@Resource
	private CronJobService cronJobService;

	@Resource
	private ItemLockingService itemLockingService;

	@Resource
	private UserService userService;

	private final TypeService typeService = Registry.getApplicationContext().getBean("typeService", TypeService.class);

	private AfterRetentionCleanupRuleModel wrongRule;
	private AfterRetentionCleanupRuleModel secondsRule;
	private static ComposedTypeModel composedType;
	private static AttributeDescriptorModel dateAttributeDescriptor;

	private static boolean initialized = false;



	private UserModel user;
	private PrincipalGroupModel itemLockingGroup;

	private Set<PrincipalGroupModel> oldGroups;
	private Set<PrincipalGroupModel> groupsWithItemLockingGroup;

	@Before
	public void setUp() throws Exception
	{
		if (!initialized)
		{

			composedType = typeService.getComposedTypeForCode("Order");
			dateAttributeDescriptor = typeService.getAttributeDescriptor(composedType, "date");
			initialized = true;
		}
		wrongRule = new AfterRetentionCleanupRuleModel();
		wrongRule.setCode("wrongRule");
		wrongRule.setRetirementItemType(composedType);
		wrongRule.setActionReference(BasicRemoveCleanupAction.SPRING_ID);
		modelService.save(wrongRule);

		secondsRule = new AfterRetentionCleanupRuleModel();
		secondsRule.setCode("secondsRule");
		secondsRule.setItemFilterExpression("{name} = 'secondsRule'");
		secondsRule.setRetirementItemType(composedType);
		secondsRule.setRetirementDateAttribute(dateAttributeDescriptor);
		secondsRule.setRetentionTimeSeconds(Long.valueOf(64800l)); // 18h
		secondsRule.setActionReference(BasicRemoveCleanupAction.SPRING_ID);
		modelService.save(secondsRule);

		setUpLockingMechanism();
	}


	public void setUpLockingMechanism()
	{
		user = modelService.create(UserModel.class);
		user.setUid(UUID.randomUUID().toString());
		modelService.save(user);

		itemLockingGroup = modelService.create(UserGroupModel.class);
		itemLockingGroup.setUid("itemLockingGroup");
		modelService.save(itemLockingGroup);

		oldGroups = userService.getCurrentUser().getGroups();
		groupsWithItemLockingGroup = new HashSet<>(oldGroups);
		groupsWithItemLockingGroup.add(itemLockingGroup);

		userService.getCurrentUser().setGroups(groupsWithItemLockingGroup);
	}

	@After
	public void cleanUpLockingMechanism()
	{

		if (user.getPk() != null && !modelService.isRemoved(user))
		{
			userService.getCurrentUser().setGroups(groupsWithItemLockingGroup);
			itemLockingService.unlock(user);
			modelService.remove(user);
		}
		modelService.remove(itemLockingGroup);

	}

	@Test
	public void testRetentionTimeMultiple()
	{
		final Instant localDateTimeBefore = Instant.now().minusSeconds(3600);
		final Instant localDateTimeAfter = Instant.now().plusSeconds(3600);
		createOrders("secondsRule", localDateTimeBefore, 6, localDateTimeAfter, 3);

		final AfterRetentionCleanupItemsProvider afterRetentionCleanupItemsProvider = createCleanupProvider(3);

		List<ItemToCleanup> collectionList = afterRetentionCleanupItemsProvider.nextItemsForCleanup();
		assertThat(collectionList).hasSize(3);

		collectionList = afterRetentionCleanupItemsProvider.nextItemsForCleanup();
		assertThat(collectionList).hasSize(2);

		collectionList = afterRetentionCleanupItemsProvider.nextItemsForCleanup();
		assertThat(collectionList).hasSize(0);
	}

	@Test
	public void testRetentionTimeMultiple2()
	{
		final Instant localDateTimeBefore = Instant.now().minusSeconds(3600);
		final Instant localDateTimeAfter = Instant.now().plusSeconds(3600);
		createOrders("secondsRule", localDateTimeBefore, 7, localDateTimeAfter, 3);

		final AfterRetentionCleanupItemsProvider afterRetentionCleanupItemsProvider = createCleanupProvider(3);

		List<ItemToCleanup> collectionList = afterRetentionCleanupItemsProvider.nextItemsForCleanup();
		assertThat(collectionList).hasSize(3);

		collectionList = afterRetentionCleanupItemsProvider.nextItemsForCleanup();
		assertThat(collectionList).hasSize(3);

		collectionList = afterRetentionCleanupItemsProvider.nextItemsForCleanup();
		assertThat(collectionList).hasSize(0);
	}



	@Test
	public void testRetentionTimeSingleWithCleanup() throws Exception
	{
		final CronJobModel cronjob = prepareCronJobWithRule();

		final String query = "SELECT {pk} FROM {Order}  WHERE {name} = 'secondsRule' ";

		final Instant localDateTimeBefore = Instant.now().minusSeconds(3600);
		final Instant localDateTimeAfter = Instant.now().plusSeconds(3600);
		final List<OrderModel> orderList = createOrders("secondsRule", localDateTimeBefore, 6, localDateTimeAfter, 3);
		assertThatResultQueryHasSpecyficSize(query, 9);

		final AfterRetentionCleanupItemsProvider afterRetentionCleanupItemsProvider = createCleanupProvider(10);

		final List<ItemToCleanup> itemToRetentions = afterRetentionCleanupItemsProvider.nextItemsForCleanup();

		assertTrue(itemToRetentions != null);
		assertThat(itemToRetentions).hasSize(5);

		//when
		cronJobService.performCronJob(cronjob, true);

		asserThatCronjobIsFinishedAndSucessful(cronjob);
		assertThatResultQueryHasSpecyficSize(query, 4);
	}



	@Test
	public void shouldSkipAllLockedItemsAndNotThrowException()
	{
		final CronJobModel cronjob = prepareCronJobWithRule();

		final Instant localDateTimeBefore = Instant.now().minusSeconds(3600);
		final Instant localDateTimeAfter = Instant.now().plusSeconds(3600);
		final List<OrderModel> createdOrderModels = createOrders("secondsRule", localDateTimeBefore, 6, localDateTimeAfter, 3);
		itemLockingService.lockAll((Collection) createdOrderModels);

		final String orderForSecondRuleQuery = "SELECT {pk} FROM {Order} WHERE {name} = 'secondsRule' ";

		assertThatResultQueryHasSpecyficSize(orderForSecondRuleQuery, 9);

		final AfterRetentionCleanupItemsProvider afterRetentionCleanupItemsProvider = createCleanupProvider(10);

		//when
		final List<ItemToCleanup> itemToRetentions = afterRetentionCleanupItemsProvider.nextItemsForCleanup();

		//then
		assertTrue(itemToRetentions != null);
		assertThat(itemToRetentions).hasSize(0);

		//when
		cronJobService.performCronJob(cronjob, true);

		//then
		asserThatCronjobIsFinishedAndSucessful(cronjob);
		assertThatResultQueryHasSpecyficSize(orderForSecondRuleQuery, 9);

		userService.getCurrentUser().setGroups(groupsWithItemLockingGroup);
		itemLockingService.unlockAll((Collection) createdOrderModels);
	}

	@Test
	public void shouldSkipOnlyLockedAndRemoveUnlockedItems()
	{
		final CronJobModel cronjob = prepareCronJobWithRule();
		final Instant localDateTimeBefore = Instant.now().minusSeconds(64801); //18h + 1sec
		final List<OrderModel> createdOrders = createOrders("secondsRule", localDateTimeBefore, 20, null, 0);
		final List<OrderModel> lockedOrders = new ArrayList<>();
		boolean isLock = true;
		for (final OrderModel ord : createdOrders)
		{
			if (isLock)
			{
				itemLockingService.lock(ord);
				lockedOrders.add(ord);
			}
			else
			{
				itemLockingService.unlock(ord);
			}
			isLock = !isLock;
		}
		final String orderForSecondRuleQuery = "SELECT {pk} FROM {Order} WHERE {name} = 'secondsRule' ";
		assertThatResultQueryHasSpecyficSize(orderForSecondRuleQuery, 20);

		final AfterRetentionCleanupItemsProvider afterRetentionCleanupItemsProvider = createCleanupProvider(10);

		final List<ItemToCleanup> itemToRetentions = afterRetentionCleanupItemsProvider.nextItemsForCleanup();
		assertThat(itemToRetentions).hasSize(10);

		//when
		cronJobService.performCronJob(cronjob, true);

		//then
		asserThatCronjobIsFinishedAndSucessful(cronjob);
		assertThatResultQueryHasSpecyficSize(orderForSecondRuleQuery, 10);

		userService.getCurrentUser().setGroups(groupsWithItemLockingGroup);
		itemLockingService.unlockAll((Collection) lockedOrders);
	}

	private CronJobModel prepareCronJobWithRule()
	{
		final RetentionJobModel job = modelService.create(RetentionJobModel.class);
		job.setCode("code");
		job.setBatchSize(10);
		job.setRetentionRule(secondsRule);
		modelService.save(job);
		return prepareCronJob("myCronjob", job);
	}

	private void assertThatResultQueryHasSpecyficSize(final String query, final int queryResultSize)
	{
		final SearchResult<List<Object>> result = flexibleSearchService.search(query);
		assertThat(result.getResult()).hasSize(queryResultSize);
	}

	private AfterRetentionCleanupItemsProvider createCleanupProvider(final int batchSize)
	{
		final AfterRetentionCleanupItemsProvider afterRetentionCleanupItemsProvider = new AfterRetentionCleanupItemsProvider(
				secondsRule);
		afterRetentionCleanupItemsProvider.setBatchSize(batchSize);
		afterRetentionCleanupItemsProvider.setFlexibleSearchService(flexibleSearchService);
		return afterRetentionCleanupItemsProvider;
	}

	private void asserThatCronjobIsFinishedAndSucessful(final CronJobModel cronjob)
	{
		assertThat(cronJobService.isSuccessful(cronjob)).isTrue();
		assertThat(cronJobService.isFinished(cronjob)).isTrue();
	}


	private CronJobModel prepareCronJob(final String code, final JobModel job)
	{
		final CronJobModel cronjob = modelService.create(CronJobModel.class);
		cronjob.setCode(code);
		cronjob.setSingleExecutable(Boolean.TRUE);
		cronjob.setJob(job);
		modelService.save(cronjob);
		return cronjob;
	}

	@Test
	public void testWrongRule()
	{
		IllegalStateException illegalStateException = null;
		final AfterRetentionCleanupItemsProvider afterRetentionCleanupItemsProvider = new AfterRetentionCleanupItemsProvider(
				wrongRule);
		afterRetentionCleanupItemsProvider.setFlexibleSearchService(flexibleSearchService);

		try
		{
			afterRetentionCleanupItemsProvider.nextItemsForCleanup();
		}
		catch (final IllegalStateException e)
		{
			illegalStateException = e;
		}
		assertTrue("Expected IllegalStateException ", illegalStateException != null);
	}

	private List<OrderModel> createOrders(final String orderName, final Instant orderDateBefore, final int countBefore,
			final Instant orderDateAfter, final int countAfter)
	{

		final List<OrderModel> createdOrders = new ArrayList<>();
		final UserModel userModel = modelService.create(UserModel.class);
		userModel.setUid("userWithOrders");
		modelService.save(userModel);

		final CurrencyModel polishCurrency = modelService.create(CurrencyModel.class);
		polishCurrency.setIsocode("ZL");
		polishCurrency.setSymbol("ZL");

		if (orderDateBefore != null)
		{
			LocalDateTime localDateTimeBefore = orderDateBefore.atZone(ZoneId.systemDefault()).toLocalDateTime();
			for (int i = 0; i < countBefore; i++)
			{
				final OrderModel order = modelService.create(OrderModel.class);
				order.setCode(UUID.randomUUID().toString());
				order.setName(orderName);
				order.setUser(userModel);
				order.setDate(Date.from(localDateTimeBefore.atZone(ZoneId.systemDefault()).toInstant()));
				order.setCurrency(polishCurrency);
				modelService.save(order);
				createdOrders.add(order);
				localDateTimeBefore = localDateTimeBefore.minusDays(1);
			}
		}
		if (orderDateAfter != null)
		{
			LocalDateTime localDateTimeAfter = orderDateAfter.atZone(ZoneId.systemDefault()).toLocalDateTime();
			for (int i = 0; i < countAfter; i++)
			{
				final OrderModel order = modelService.create(OrderModel.class);
				order.setCode(UUID.randomUUID().toString());
				order.setName(orderName);
				order.setUser(userModel);
				order.setDate(Date.from(localDateTimeAfter.atZone(ZoneId.systemDefault()).toInstant()));
				order.setCurrency(polishCurrency);
				modelService.save(order);
				createdOrders.add(order);
				localDateTimeAfter = localDateTimeAfter.plusDays(1);
			}
		}

		return createdOrders;
	}
}
