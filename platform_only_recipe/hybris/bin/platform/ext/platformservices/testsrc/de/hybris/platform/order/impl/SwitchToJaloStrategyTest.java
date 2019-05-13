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
package de.hybris.platform.order.impl;

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.jalo.order.price.PriceFactory;
import de.hybris.platform.order.TestPriceFactory;
import de.hybris.platform.order.strategies.calculation.FindDeliveryCostStrategy;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.order.strategies.calculation.FindPaymentCostStrategy;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.order.strategies.calculation.FindTaxValuesStrategy;
import de.hybris.platform.order.strategies.calculation.ServiceLayerOnlyCalculationVerifier;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


@UnitTest
public class SwitchToJaloStrategyTest extends ServicelayerTransactionalTest
{

	private final FindTaxValuesStrategy mockFindTaxValueStrategy = Mockito.mock(FindTaxValuesStrategy.class,
			Mockito.withSettings().extraInterfaces(ServiceLayerOnlyCalculationVerifier.class));

	private final FindPriceStrategy mockFindPriceStrategy = Mockito.mock(FindPriceStrategy.class,
			Mockito.withSettings().extraInterfaces(ServiceLayerOnlyCalculationVerifier.class));

	private final FindDiscountValuesStrategy mockFindDiscountsValuesStrategy = Mockito.mock(FindDiscountValuesStrategy.class,
			Mockito.withSettings().extraInterfaces(ServiceLayerOnlyCalculationVerifier.class));

	private final FindDeliveryCostStrategy mockFindDeliverCostsStrategy = Mockito.mock(FindDeliveryCostStrategy.class,
			Mockito.withSettings().extraInterfaces(ServiceLayerOnlyCalculationVerifier.class));

	private final FindPaymentCostStrategy mockFindPaymentCostsStrategyJalo = Mockito.mock(FindPaymentCostStrategy.class);

	private PriceFactory previousPf;

	@Before
	public void setUp() throws Exception
	{
		previousPf = jaloSession.getSessionContext().getPriceFactory();
	}

	@After
	public void tearDown()
	{
		jaloSession.getSessionContext().setPriceFactory(previousPf);
	}


	@Test
	public void shouldDetectJaloStrategy()
	{
		final DefaultCalculationService defCalcService = new DefaultCalculationService();
		final List<FindTaxValuesStrategy> strategyList = new ArrayList<>();
		strategyList.add(mockFindTaxValueStrategy);
		defCalcService.setFindTaxesStrategies(strategyList);
		defCalcService.setFindPriceStrategy(mockFindPriceStrategy);
		final List<FindDiscountValuesStrategy> dicountList = new ArrayList<>();
		dicountList.add(mockFindDiscountsValuesStrategy);
		defCalcService.setFindDiscountsStrategies(dicountList);
		defCalcService.setFindDeliveryCostStrategy(mockFindDeliverCostsStrategy);
		defCalcService.setFindPaymentCostStrategy(mockFindPaymentCostsStrategyJalo);

		assertThat(defCalcService.hasJaloStrategies()).isTrue();
	}

}
