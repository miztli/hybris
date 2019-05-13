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
package de.hybris.platform.test;

import de.hybris.bootstrap.annotations.IntegrationTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * This test together with {@link ReplaceSuccessfulTest} shows how to replace one test with another.
 */
@IntegrationTest
public class ReplaceFailingTest
{
    @Test
    public void failingTest()
    {
        assertTrue("this should fail", false);
    }
}
