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
package de.hybris.platform.servicelayer

import de.hybris.platform.testframework.HybrisSpockRunner
import de.hybris.platform.testframework.RunListeners
import de.hybris.platform.testframework.runlistener.LightPlatformRunListener
import org.junit.runner.RunWith
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@RunWith(HybrisSpockRunner.class)
@RunListeners(LightPlatformRunListener.class)
abstract class HybrisSpockLightSpecification extends Specification
{
    protected static final ServicelayerBaseTestLogic servicelayerBaseTestLogic = new ServicelayerBaseTestLogic();

    def setup()
    {
        servicelayerBaseTestLogic.prepareApplicationContextAndSession(this)
    }

    protected ApplicationContext getApplicationContext()
    {
        return servicelayerBaseTestLogic.getApplicationContext();
    }
}
