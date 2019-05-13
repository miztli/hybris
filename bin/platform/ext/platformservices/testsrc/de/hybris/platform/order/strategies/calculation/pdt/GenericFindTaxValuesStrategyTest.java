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
import org.junit.After;
import org.junit.Before;

import javax.annotation.Resource;


public class GenericFindTaxValuesStrategyTest extends AbstractFindTaxValuesStrategyTest
{
	@Resource
	FindPDTValueInfoStrategy<TaxValue, TaxInformation, TaxValueInfoCriteria> findTaxValueInfoStrategy;


	@Override
	public FindPDTValueInfoStrategy<TaxValue, TaxInformation, TaxValueInfoCriteria> findPDTValueInfoStrategy()
	{
		return findTaxValueInfoStrategy;
	}

	@Before
	public void disableEurope1CacheTaxes()
	{
		europe1CacheTaxesProperty.switchToValue("false");
	}


}
