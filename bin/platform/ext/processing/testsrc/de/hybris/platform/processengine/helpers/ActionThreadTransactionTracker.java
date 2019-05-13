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
package de.hybris.platform.processengine.helpers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;




public class ActionThreadTransactionTracker
{
	private final Set<TrackerGroup> groups = new HashSet<>();

	public void addSynchroGroup(final String groupName, final String... args)
	{
		groups.add(new SynchroGroup(groupName, args));
	}

	public void addAsynchroGroup(final String groupName, final String... args)
	{
		groups.add(new AsynchroGroup(groupName, args));
	}

	public synchronized void trackThreadAndTransactionForAction(final String actionName, final long threadId,
			final long transactionId)
	{
		groups.forEach(gr -> gr.trackThreadAndTransactionForAction(threadId, transactionId, actionName));
	}

	public boolean isTransactionError(final String groupName)
	{
		return groups.stream().filter(gr -> groupName.equals(gr.getGroupName())).findFirst().get().isTransactionError();
	}

	public boolean isThreadError(final String groupName)
	{
		return groups.stream().filter(gr -> groupName.equals(gr.getGroupName())).findFirst().get().isThreadError();
	}


	private abstract class AbstractGroup
	{
		boolean errorThread = false;
		boolean errorSameTransaction = false;
		String groupId;
		Set<String> actions = new HashSet<>();
		Set<Long> transactionIds = new HashSet<>();

		public AbstractGroup(final String groupId, final String... args)
		{
			this.groupId = groupId;
			final HashSet group = new HashSet<>();
			group.addAll(Arrays.asList(args));
			actions = group;
		}

		protected void checkTransactionError(final Long transactionId)
		{
			//transactions should be different
			if (transactionIds.contains(transactionId))
			{
				errorSameTransaction = true;
			}
			else
			{
				transactionIds.add(transactionId);
			}
		}

		public boolean isTransactionError()
		{
			return errorSameTransaction;
		}

		public boolean isThreadError()
		{
			return errorThread;
		}

		public String getGroupName()
		{
			return groupId;
		}
	}

	private class AsynchroGroup extends AbstractGroup implements TrackerGroup
	{
		Set<Long> threadIds = new HashSet<>();

		public AsynchroGroup(final String groupId, final String... args)
		{
			super(groupId, args);
		}

		public void trackThreadAndTransactionForAction(final long threadId, final Long transactionId, final String actionName)
		{
			if (actions.contains(actionName))
			{
				//threads should be different
				if (threadIds.contains(threadId))
				{
					errorThread = true;
				}
				threadIds.add(threadId);
				checkTransactionError(transactionId);
			}
		}

	}


	private class SynchroGroup extends AbstractGroup implements TrackerGroup
	{
		Long currentThreadId;

		public SynchroGroup(final String groupId, final String... args)
		{
			super(groupId, args);
		}

		public void trackThreadAndTransactionForAction(final long threadId, final Long transactionId, final String actionName)
		{
			if (actions.contains(actionName))
			{
				if (!checkIfInitializeThreadId(threadId) && currentThreadId.longValue() != threadId)
				{
					errorThread = true;
				}
				checkTransactionError(transactionId);
			}
		}

		private boolean checkIfInitializeThreadId(final long threadId)
		{
			if (currentThreadId == null)
			{
				currentThreadId = threadId;
				return true;
			}
			return false;
		}

	}

	public static interface TrackerGroup
	{
		public void trackThreadAndTransactionForAction(final long threadId, final Long transactionId, final String actionName);

		public boolean isTransactionError();

		public boolean isThreadError();

		public String getGroupName();

	}
}