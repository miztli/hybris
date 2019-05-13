/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.order.strategies.calculation.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Constants;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.order.strategies.calculation.impl.servicelayer.DefaultSLFindPaymentCostStrategy;
import de.hybris.platform.paymentstandard.model.StandardPaymentModeModel;
import de.hybris.platform.paymentstandard.model.StandardPaymentModeValueModel;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.util.PriceValue;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class FindPaymentCostStrategySLOnlyTest extends ServicelayerBaseTest
{


	@Resource
	private DefaultSLFindPaymentCostStrategy slFindPaymentCostStrategy;

	@Resource
	private ModelService modelService;

	@Resource
	private TypeService typeService;

	private CurrencyModel currencyModel;
	@Resource
	private CommonI18NService commonI18NService;

	@Before
	public void setUp()
	{
		currencyModel = modelService.create(CurrencyModel.class);
		currencyModel.setActive(Boolean.TRUE);
		currencyModel.setSymbol("foo");
		currencyModel.setIsocode("foo");
		modelService.save(currencyModel);
	}

	@Test
	public void shouldReturn0ForPaymentCostIfPaymentModeIsNotSet()
	{
		//given
		final AbstractOrderModel model = new AbstractOrderModel();
		model.setNet(false);
		model.setCurrency(currencyModel);
		//when
		final PriceValue pValue = slFindPaymentCostStrategy.getPaymentCost(model);
		//then
		assertThat(pValue).isNotNull();
		assertThat(pValue.getValue()).isEqualTo(0.0);
	}

	@Test
	public void shouldReturnValueForStandardPaymentModel()
	{
		//given
		final AbstractOrderModel orderModel = new AbstractOrderModel();
		final StandardPaymentModeModel paymentModoModel = modelService.create(StandardPaymentModeModel.class);
		final StandardPaymentModeValueModel value = modelService.create(StandardPaymentModeValueModel.class);
		value.setCurrency(currencyModel);
		value.setValue(100.0);
		value.setPaymentMode(paymentModoModel);
		paymentModoModel.setPaymentModeValues(Arrays.asList(value));
		paymentModoModel.setActive(true);
		paymentModoModel.setCode("PaymentMode");
		paymentModoModel.setPaymentInfoType(typeService.getComposedTypeForCode(Constants.TYPES.CreditCardTypeType));
		modelService.save(paymentModoModel);
		modelService.save(value);
		orderModel.setPaymentMode(paymentModoModel);
		orderModel.setNet(false);
		orderModel.setCurrency(currencyModel);

		//when
		final PriceValue pValue = slFindPaymentCostStrategy.getPaymentCost(orderModel);

		//then
		assertThat(pValue.getValue()).isEqualTo(100.0);
	}


	@Test
	public void shouldReturnCalcualtedPriceValueForBaseCurrencyIfPaymenetValue()
	{
		//given
		CurrencyModel currencyModelUSD;
		try
		{
			currencyModelUSD = modelService.create(CurrencyModel.class);
			currencyModelUSD.setIsocode("USD");
			currencyModelUSD.setConversion(2.0);
			modelService.save(currencyModelUSD);
		}
		catch (final Exception e)
		{
			currencyModelUSD = commonI18NService.getCurrency("USD");
		}

		final AbstractOrderModel orderModel = new AbstractOrderModel();
		final StandardPaymentModeModel paymentModeModel = modelService.create(StandardPaymentModeModel.class);
		final StandardPaymentModeValueModel value = modelService.create(StandardPaymentModeValueModel.class);
		value.setCurrency(commonI18NService.getBaseCurrency());
		value.setValue(100.0);
		value.setPaymentMode(paymentModeModel);
		paymentModeModel.setPaymentModeValues(Arrays.asList(value));
		paymentModeModel.setActive(true);
		paymentModeModel.setCode("PaymentMode");
		paymentModeModel.setPaymentInfoType(typeService.getComposedTypeForCode(Constants.TYPES.CreditCardTypeType));
		modelService.save(value);
		modelService.save(paymentModeModel);
		orderModel.setPaymentMode(paymentModeModel);
		orderModel.setNet(false);
		orderModel.setCurrency(currencyModelUSD);

		//when
		final PriceValue pValue = slFindPaymentCostStrategy.getPaymentCost(orderModel);

		//then
		assertThat(pValue.getValue()).isEqualTo(200.0);
	}


}
