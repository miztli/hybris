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
package de.hybris.platform.servicelayer.i18n.util;

import org.junit.Assert;
import org.junit.Test;


public class I18NUtilsTest
{
	@Test
	public void testIsFormerISOCode()
	{
		// "iw"->"he", "ji"->"yi", "in"->"id"
		Assert.assertTrue("code should belong to FORMER_ISO_CODES", I18NUtils.isFormerISOCode("iw"));
		Assert.assertTrue("code should belong to FORMER_ISO_CODES", I18NUtils.isFormerISOCode("ji"));
		Assert.assertTrue("code should belong to FORMER_ISO_CODES", I18NUtils.isFormerISOCode("in"));
	}

	@Test
	public void testMapFormerISOCodeToActual()
	{
		// "iw"->"he", "ji"->"yi", "in"->"id"
		Assert.assertEquals("code should be equal to \"he\"", "he", I18NUtils.mapFormerISOCodeToActual("iw"));
		Assert.assertEquals("code should be equal to \"yi\"", "yi", I18NUtils.mapFormerISOCodeToActual("ji"));
		Assert.assertEquals("code should be equal to \"id\"", "id", I18NUtils.mapFormerISOCodeToActual("in"));
	}
}
