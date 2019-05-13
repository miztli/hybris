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
package de.hybris.platform.order.strategies.calculation.pdt.processor;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.jalo.order.price.PDTInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.FindPDTValueInfoStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultPriceValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.processor.impl.DefaultPDTProcessor;
import de.hybris.platform.util.PDTValue;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;


@UnitTest
public class DefaultFindValuesStrategyProcessorDecoratorTest
{



	@Test
	public void shouldCompleteResponseWhenResponseIsEmpty() throws CalculationException

	{
		//given
		final PDTProcessorChain pChain = Mockito.mock(PDTProcessorChain.class);
		final FindPDTValueInfoStrategy pdtValueStrategy = Mockito.mock(FindPDTValueInfoStrategy.class);

		final DefaultPDTProcessor<PDTValue, PDTInformation, PDTCriteria> decorator = new DefaultPDTProcessor<>();
		decorator.setFindPDTValueInfoStrategy(pdtValueStrategy);

		Mockito.when(pdtValueStrategy.getPDTValues(Mockito.any())).thenReturn(Collections.singletonList(createPDTValue(1d)));
		final PDTContext context = createPDTContext();
		context.setValues(null);

		//when
		decorator.doProcess(context, pChain);

		//then
		Mockito.verify(pChain, Mockito.times(1)).doProcess(Mockito.any());
		final List<PDTValue> responseValueList = context.getValues();
		assertThat(responseValueList).isNotEmpty();
		assertThat(responseValueList).extracting(PDTValue::getValue).containsExactly(1d);

	}

	@Test
	public void shouldNotOverrideResponseWhenResponseIsNotEmpty() throws CalculationException
	{

		//given
		final PDTProcessorChain pChain = Mockito.mock(PDTProcessorChain.class);
		final FindPDTValueInfoStrategy pdtValueStrategy = Mockito.mock(FindPDTValueInfoStrategy.class);

		final DefaultPDTProcessor<PDTValue, PDTInformation, PDTCriteria> decorator = new DefaultPDTProcessor<>();
		decorator.setFindPDTValueInfoStrategy(pdtValueStrategy);

		Mockito.when(pdtValueStrategy.getPDTValues(Mockito.any())).thenReturn(Collections.singletonList(createPDTValue(1d)));
		final PDTContext context = createPDTContext();
		context.setValues(Collections.singletonList(createPDTValue(2d)));

		//when
		decorator.doProcess(context, pChain);

		//then
		Mockito.verify(pChain, Mockito.times(1)).doProcess(Mockito.any());
		final List<PDTValue> responseValueList = context.getValues();
		assertThat(responseValueList).isNotEmpty();
		assertThat(responseValueList).extracting(PDTValue::getValue).containsExactly(2d);

	}

	private PDTContext createPDTContext()
	{
		final PDTCriteria criteria = DefaultPriceValueInfoCriteria.buildForValue().build();
		return new PDTContext<>(criteria);
	}


	private PDTValue createPDTValue(final double value)
	{
		return () -> value;
	}
}
