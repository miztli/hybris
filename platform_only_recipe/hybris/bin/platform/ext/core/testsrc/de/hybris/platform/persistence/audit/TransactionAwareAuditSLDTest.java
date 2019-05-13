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
package de.hybris.platform.persistence.audit;

import de.hybris.bootstrap.annotations.IntegrationTest;

import org.junit.Before;


@IntegrationTest
public class TransactionAwareAuditSLDTest extends TransactionAwareAuditTest
{

	@Before
	public void prepare()
	{
		persistanceLegacyModeSwitcher.switchToValue("false");
		allTypesEnabledSwitcher.switchToValue("true");
		assumeAuditEnabled();
		warmUp();
	}

}
