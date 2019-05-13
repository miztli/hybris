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

package de.hybris.platform.order.strategies.calculation.pdt;

import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.util.TaxValue;

import javax.annotation.Resource;

import org.junit.Before;


public class DefaultFindTaxValuesServiceIntegrationTest extends AbstractFindTaxValuesStrategyTest
{
	@Resource
	FindPDTValueInfoStrategy<TaxValue, TaxInformation, TaxValueInfoCriteria> cachingFindTaxValueInfoStrategy;

	@Override
	public FindPDTValueInfoStrategy<TaxValue, TaxInformation, TaxValueInfoCriteria> findPDTValueInfoStrategy()
	{
		return cachingFindTaxValueInfoStrategy;
	}

	@Before
	public void enableEurope1CacheTaxes()
	{
		europe1CacheTaxesProperty.switchToValue("true");
	}


}
