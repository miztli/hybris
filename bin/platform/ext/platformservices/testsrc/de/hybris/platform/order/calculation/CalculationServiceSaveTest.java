/*
 * [y] hybris Platform
 *
 * Copyright (c) {year} SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.platform.order.calculation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.order.CalculationService;
import de.hybris.platform.order.OrderService;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.impl.DefaultCalculationService;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class CalculationServiceSaveTest extends ServicelayerTransactionalTest
{
	@Resource
	private CalculationService calculationService;

	@Resource
	private ModelService modelService;

	@Resource
	private OrderService orderService;

	@Resource
	private ProductService productService;

	@Resource
	private CommonI18NService commonI18NService;

	private ModelService spiedModelService;
	private DefaultCalculationService spiedCalculationService;

	protected PropertyConfigSwitcher pdtCalculationModeProperty = new PropertyConfigSwitcher("pdt.calculation.mode");

	@Before
	public void setUp() throws Exception
	{
		createCoreData();
		importCsv("/platformservices/test/testOrderCalculation.csv", "utf-8");

		spiedModelService = spy(modelService);
		final DefaultCalculationService defaultCalculationService = (DefaultCalculationService) calculationService;
		spiedCalculationService = spy(defaultCalculationService);
		spiedCalculationService.setModelService(spiedModelService);
	}

	@After
	public void cleanup()
	{
		pdtCalculationModeProperty.switchBackToDefault();
	}

	@Test
	public void shouldNotSaveDuringCalculateInSl() throws CalculationException
	{
		pdtCalculationModeProperty.switchToValue("sl");
		assertOrderEntriesSaves(0, (calculationService, order) -> spiedCalculationService.calculate(order));
	}

	@Test
	public void shouldSaveDuringCalculateInJalo() throws CalculationException
	{
		pdtCalculationModeProperty.switchToValue("jalo");
		assertOrderEntriesSaves(1, (calculationService, order) -> spiedCalculationService.calculate(order));
	}

	@Test
	public void shouldNotSaveDuringRecalculateInSl() throws CalculationException
	{
		pdtCalculationModeProperty.switchToValue("sl");
		assertOrderEntriesSaves(0, (calculationService, order) -> spiedCalculationService.recalculate(order));
	}

	@Test
	public void shouldSaveDuringRecalculateInJalo() throws CalculationException
	{
		pdtCalculationModeProperty.switchToValue("jalo");
		assertOrderEntriesSaves(1, (calculationService, order) -> spiedCalculationService.recalculate(order));
	}

	@Test
	public void shouldNotSaveDuringCalculateWithDateInSl() throws CalculationException
	{
		pdtCalculationModeProperty.switchToValue("sl");
		assertOrderEntriesSaves(0, (calculationService, order) -> spiedCalculationService.calculate(order, new Date()));
	}

	@Test
	public void shouldSaveDuringCalculateWithDateInJalo() throws CalculationException
	{
		pdtCalculationModeProperty.switchToValue("jalo");
		assertOrderEntriesSaves(1, (calculationService, order) -> spiedCalculationService.calculate(order, new Date()));
	}

	@Test
	public void shouldNotSaveDuringRecalculateWithDateInSl() throws CalculationException
	{
		pdtCalculationModeProperty.switchToValue("sl");
		assertOrderEntriesSaves(0, (calculationService, order) -> spiedCalculationService.recalculate(order, new Date()));
	}

	@Test
	public void shouldSaveDuringRecalculateWithDateInJalo() throws CalculationException
	{
		pdtCalculationModeProperty.switchToValue("jalo");
		assertOrderEntriesSaves(1, (calculationService, order) -> spiedCalculationService.recalculate(order, new Date()));
	}

	private interface CalculationServiceCallable
	{
		void call(CalculationService calculationService, AbstractOrderModel order) throws CalculationException;
	}

	private void assertOrderEntriesSaves(final int times, final CalculationServiceCallable calculationServiceCallable) throws CalculationException
	{
		// given
		final Pair<OrderModel, AbstractOrderEntryModel> orderAndEntry = createOrderWithEntry();
		final OrderModel order = orderAndEntry.getLeft();
		final AbstractOrderEntryModel orderEntry = orderAndEntry.getRight();

		// when
		calculationServiceCallable.call(spiedCalculationService, order);

		// then
		assertThat(order.getTotalPrice()).isEqualTo(1.234);
		assertThat(order.getTotalDiscounts()).isEqualTo(0.0);
		assertThat(order.getTotalTax()).isEqualTo(0.0);
		assertThat(order.getCurrency().getSymbol()).isEqualTo("PLN");

		verify(spiedModelService, times(times)).save(orderEntry);
	}

	private Pair<OrderModel, AbstractOrderEntryModel> createOrderWithEntry()
	{
		final ProductModel product = productService.getProductForCode("pB");

		final CustomerModel customer = modelService.create(CustomerModel.class);
		customer.setUid(UUID.randomUUID().toString());

		final OrderModel order = modelService.create(OrderModel.class);
		order.setCode(UUID.randomUUID().toString());
		order.setUser(customer);
		order.setCurrency(commonI18NService.getCurrency("PLN"));
		order.setDate(new Date());
		order.setNet(Boolean.FALSE);
		order.setEntries(new ArrayList<>());

		final AbstractOrderEntryModel orderEntry = orderService.addNewEntry(order, product, 1, product.getUnit());
		orderEntry.setBasePrice(Double.valueOf(10));

		modelService.saveAll();

		return Pair.of(order, orderEntry);
	}
}
