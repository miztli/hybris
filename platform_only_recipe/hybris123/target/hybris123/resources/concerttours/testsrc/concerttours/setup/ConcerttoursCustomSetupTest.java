/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2017 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package concerttours.setup;
 
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
 
import javax.annotation.Resource;
 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
 
@IntegrationTest
public class ConcerttoursCustomSetupTest extends ServicelayerTransactionalTest
{
 
    @Resource
    private ConcerttoursCustomSetup concerttoursCustomSetup;
 
    @Before
    public void setup() throws Exception
    {
        createCoreData();
    }
 
    @Test
    public void testDataLoad()
    {
        Assert.assertTrue(concerttoursCustomSetup.putInMyEssentialData());
        Assert.assertTrue(concerttoursCustomSetup.addMyProjectData());
    }
}