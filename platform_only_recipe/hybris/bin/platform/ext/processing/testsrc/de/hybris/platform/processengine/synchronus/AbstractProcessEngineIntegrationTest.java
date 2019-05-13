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
package de.hybris.platform.processengine.synchronus;

import de.hybris.platform.processengine.enums.ProcessState;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.SystemException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;


public abstract class AbstractProcessEngineIntegrationTest extends ServicelayerBaseTest
{
	@Resource
	protected ModelService modelService;
	protected final PropertyConfigSwitcher canJoinPreviousNodeDefaultValue = new PropertyConfigSwitcher(
			"processengine.process.canjoinpreviousnode.default");

	protected void waitForBusinessProcess(final BusinessProcessModel bpm) throws TimeoutException
	{
		final long maxWaitTime = System.currentTimeMillis() + 2 * 60 * 1000;
		do
		{
			try
			{
				if (System.currentTimeMillis() > maxWaitTime)
				{
					throw new TimeoutException("Wait time exceeded for " + bpm.getCode());
				}

				final ProcessState state = bpm.getState();

				if (state == ProcessState.SUCCEEDED || state == ProcessState.ERROR || state == ProcessState.FAILED)
				{
					return;
				}
				Thread.sleep(1000);
				modelService.refresh(bpm);
			}
			catch (final InterruptedException e)
			{
				throw new SystemException(e);
			}
		}
		while (true);
	}

}
