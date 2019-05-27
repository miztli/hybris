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
package de.hybris.platform.testframework;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;


public class SampleTestCornerCaseBeforeAssume
{
	private static final Logger LOG = Logger.getLogger(SampleTestCornerCaseBeforeAssume.class);

	@Before
	public void prepare()
	{
		Assume.assumeTrue(false);
	}

	@Test
	public void test()
	{
		Assert.assertTrue(true);
	}

}
