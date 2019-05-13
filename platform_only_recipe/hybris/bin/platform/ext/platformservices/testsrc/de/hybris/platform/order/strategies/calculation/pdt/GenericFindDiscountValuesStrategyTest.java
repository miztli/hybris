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

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.DiscountValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultDiscountValueInfoCriteria;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.DiscountValue;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;


@IntegrationTest
public class GenericFindDiscountValuesStrategyTest extends ServicelayerBaseTest
{
	@Resource
	private FindPDTValueInfoStrategy<DiscountValue, DiscountInformation, DiscountValueInfoCriteria> findDiscountValueInfoStrategy;

	@Resource
	private ModelService modelService;

	@Resource
	private UserService userService;

	@Test
	public void shouldReturnEmptyListsWhenNoDiscountInSystem() throws CalculationException
	{
		final CurrencyModel currency = modelService.create(CurrencyModel.class);
		currency.setIsocode("PLN");
		modelService.save(currency);

		final UserModel currentUser = userService.getCurrentUser();

		final DiscountValueInfoCriteria criteria = DefaultDiscountValueInfoCriteria.buildForValue() //
				.withUser(currentUser) //
				.withCurrency(currency) //
				.withDate(new Date()) //
				.build();

		final List<DiscountValue> discountValues = findDiscountValueInfoStrategy.getPDTValues(criteria);
		final List<DiscountInformation> discountInfo = findDiscountValueInfoStrategy.getPDTInformation(criteria);

		assertThat(discountValues).isEmpty();
		assertThat(discountInfo).isEmpty();
	}
}
