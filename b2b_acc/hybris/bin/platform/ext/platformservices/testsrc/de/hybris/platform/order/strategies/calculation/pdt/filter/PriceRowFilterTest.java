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
package de.hybris.platform.order.strategies.calculation.pdt.filter;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.europe1.enums.PriceRowChannel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultPriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.filter.impl.DefaultPriceRowValueFilter;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.util.StandardDateRange;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


@IntegrationTest
public class PriceRowFilterTest extends ServicelayerBaseTest
{
	@Resource
	DefaultPriceRowValueFilter defaultPriceRowValueFilter;
	@Resource
	private CommonI18NService commonI18NService;
	@Resource
	private ModelService modelService;
	@Resource
	private SessionService sessionService;

	private UnitModel unitModel;
	private static final String CHANNEL = "channel";
	private static final String DETECTED_UI_EXPERIENCE_LEVEL = "UiExperienceService-Detected-Level";

	@Before
	public void setUp() throws Exception
	{
		unitModel = modelService.create(UnitModel.class);
		unitModel.setCode("pieces");
		unitModel.setUnitType("pieces");
		modelService.save(unitModel);
	}

	@Test
	public void shouldReturn0PriceRowsIfMinimumQuantityIsNotReeached()
	{
		final long _quantity = 1;
		final PriceRowModel pRowModel = getTemporaryPriceRowModel();
		pRowModel.setMinqtd(2L);
		final PriceValueInfoCriteria params = createPriceRowParams(_quantity, pRowModel.getUnit(), pRowModel.getCurrency(), null,
				false);
		final Collection<PriceRowModel> prmList = defaultPriceRowValueFilter.filter(Collections.singletonList(pRowModel), params);
		assertThat(prmList).isEmpty();
	}

	@Test
	public void shouldReturnOriginalPriceRow()
	{
		final PriceRowModel pRowModel = getTemporaryPriceRowModel();
		final PriceValueInfoCriteria params = createPriceRowParams(1, pRowModel.getUnit(), pRowModel.getCurrency(), null, false);
		final Collection<PriceRowModel> prmList = defaultPriceRowValueFilter.filter(Collections.singletonList(pRowModel), params);
		assertThat(prmList).isNotEmpty();
	}

	@Test
	public void shouldReturn0PricesIfChannelIsNotReached()
	{
		final PriceRowModel pRowModel = getTemporaryPriceRowModel();

		setChannel(PriceRowChannel.MOBILE);
		pRowModel.setChannel(PriceRowChannel.DESKTOP);

		final PriceValueInfoCriteria params = createPriceRowParams(1, pRowModel.getUnit(), pRowModel.getCurrency(), null, false);
		final Collection<PriceRowModel> prmList = defaultPriceRowValueFilter.filter(Collections.singletonList(pRowModel), params);
		assertThat(prmList).isEmpty();
	}

	@Test
	public void shouldRemovePriceRowsWithNullChannelIfChannelIsReachedForOnPriceRow()
	{
		final UnitModel unit = new UnitModel();
		final PriceRowModel pRowModel1 = getTemporaryPriceRowModel();

		pRowModel1.setChannel(PriceRowChannel.DESKTOP);
		setChannel(PriceRowChannel.DESKTOP);

		final PriceRowModel pRowModel2 = getTemporaryPriceRowModel();
		pRowModel2.setChannel(null);

		final PriceRowModel pRowModel3 = getTemporaryPriceRowModel();
		pRowModel3.setChannel(null);

		final Collection<PriceRowModel> rows = Arrays.asList(pRowModel1, pRowModel2, pRowModel3);
		final PriceValueInfoCriteria params = createPriceRowParams(1, unitModel, pRowModel1.getCurrency(), null, false);

		final Collection<PriceRowModel> prmList = defaultPriceRowValueFilter.filter(rows, params);
		assertThat(prmList).containsOnly(pRowModel1);
	}

	@Test
	public void shouldGiveAway()
	{
		final PriceRowModel pRowModel = getTemporaryPriceRowModel();

		pRowModel.setChannel(PriceRowChannel.DESKTOP);
		setChannel(PriceRowChannel.MOBILE);
		final boolean isGiveaway = true;
		pRowModel.setGiveAwayPrice(!isGiveaway);

		final PriceValueInfoCriteria params = createPriceRowParams(1, pRowModel.getUnit(), pRowModel.getCurrency(), null, isGiveaway);
		final Collection<PriceRowModel> prmList = defaultPriceRowValueFilter.filter(Collections.singletonList(pRowModel), params);
		assertThat(prmList).isEmpty();
	}

	@Test
	public void shouldFilterOutRowWithWrongDateRange()
	{
		final PriceRowModel pRowModel = getTemporaryPriceRowModel();
		setChannel(PriceRowChannel.DESKTOP);

		final long currentTime = System.currentTimeMillis();
		final Date startDate = new Date(currentTime - 1);
		final Date endDate = new Date(currentTime + 1);
		final Date beforeDate = new Date(currentTime - 10);

		pRowModel.setDateRange(new StandardDateRange(startDate, endDate));
		pRowModel.setProductId("ProductWithDateRange");
		modelService.save(pRowModel);

		final PriceValueInfoCriteria params = createPriceRowParams(1, pRowModel.getUnit(), pRowModel.getCurrency(), beforeDate, false);
		final Collection<PriceRowModel> prmList = defaultPriceRowValueFilter.filter(Collections.singletonList(pRowModel), params);
		assertThat(prmList).isEmpty();
	}

	PriceValueInfoCriteria createPriceRowParams(final long _quantity, final UnitModel unit, final CurrencyModel curr, final Date date,
			final boolean giveAwayMode)
	{
		return DefaultPriceValueInfoCriteria.buildForValue()//
				.withQuantity(_quantity)//
				.withUnit(unit)//
				.withCurrency(curr)//
				.withDate(date)//
				.withNet(false)//
				.withGiveAwayMode(giveAwayMode).build();
	}

	private PriceRowModel getTemporaryPriceRowModel()
	{
		final PriceRowModel pRowModel = modelService.create(PriceRowModel.class);
		final CurrencyModel baseModel = commonI18NService.getBaseCurrency();
		pRowModel.setMinqtd(1L);
		pRowModel.setCurrency(baseModel);
		pRowModel.setUnit(unitModel);
		pRowModel.setGiveAwayPrice(false);
		pRowModel.setPrice(100d);
		return pRowModel;
	}

	private void setChannel(final PriceRowChannel channel)
	{
		sessionService.setAttribute(CHANNEL, channel);
		sessionService.setAttribute(DETECTED_UI_EXPERIENCE_LEVEL, channel);
	}
}
