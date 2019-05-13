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

package de.hybris.platform.order.strategies.calculation.pdt.processor;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.FindPDTValueInfoStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria.PDTCriteriaTarget;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.TaxValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.impl.DefaultTaxValueInfoCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.processor.impl.DefaultPDTProcessor;
import de.hybris.platform.util.TaxValue;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultPDTProcessorTest
{
	@Mock
	FindPDTValueInfoStrategy strategy;

	@Mock
	PDTContext context;

	@Test
	public void shouldProcessIfNoResultConstantSetInContextForValues() throws CalculationException
	{
		when(context.getCriteria()).thenReturn(DefaultTaxValueInfoCriteria.buildForValue().build());
		when(context.getPDTCriteriaTarget()).thenReturn(PDTCriteriaTarget.VALUE);
		when(context.getValues()).thenReturn(DefaultPDTProcessor.NO_RESULT);

		final DefaultPDTProcessor<TaxValue, TaxInformation, TaxValueInfoCriteria> processor = new DefaultPDTProcessor<>();
		processor.setFindPDTValueInfoStrategy(strategy);

		processor.doProcess(context, mock(PDTProcessorChain.class));

		verify(strategy, times(1)).getPDTValues(any());
		verify(context, times(1)).setValues(anyList());
		verify(context, never()).setInformations(anyList());
	}

	@Test
	public void shouldProcessIfNullConstantSetInContextForValues() throws CalculationException
	{
		when(context.getCriteria()).thenReturn(DefaultTaxValueInfoCriteria.buildForValue().build());
		when(context.getPDTCriteriaTarget()).thenReturn(PDTCriteriaTarget.VALUE);
		when(context.getValues()).thenReturn(null);

		final DefaultPDTProcessor<TaxValue, TaxInformation, TaxValueInfoCriteria> processor = new DefaultPDTProcessor<>();
		processor.setFindPDTValueInfoStrategy(strategy);

		processor.doProcess(context, mock(PDTProcessorChain.class));

		verify(strategy, times(1)).getPDTValues(any());
		verify(context, times(1)).setValues(anyList());
		verify(context, never()).setInformations(anyList());
	}

	@Test
	public void shouldNotProcessIfCollectionsEmptyListSetInContextForValues() throws CalculationException
	{
		when(context.getCriteria()).thenReturn(DefaultTaxValueInfoCriteria.buildForValue().build());
		when(context.getPDTCriteriaTarget()).thenReturn(PDTCriteriaTarget.VALUE);
		when(context.getValues()).thenReturn(Collections.emptyList());

		final DefaultPDTProcessor<TaxValue, TaxInformation, TaxValueInfoCriteria> processor = new DefaultPDTProcessor<>();
		processor.setFindPDTValueInfoStrategy(strategy);

		processor.doProcess(context, mock(PDTProcessorChain.class));

		verify(strategy, never()).getPDTValues(any());
		verify(context, never()).setValues(anyList());
		verify(context, never()).setInformations(anyList());
	}

	@Test
	public void shouldProcessIfNoResultConstantSetInContextForInformations() throws CalculationException
	{
		when(context.getCriteria()).thenReturn(DefaultTaxValueInfoCriteria.buildForInfo().build());
		when(context.getPDTCriteriaTarget()).thenReturn(PDTCriteriaTarget.INFORMATION);
		when(context.getInformations()).thenReturn(DefaultPDTProcessor.NO_RESULT);

		final DefaultPDTProcessor<TaxValue, TaxInformation, TaxValueInfoCriteria> processor = new DefaultPDTProcessor<>();
		processor.setFindPDTValueInfoStrategy(strategy);

		processor.doProcess(context, mock(PDTProcessorChain.class));

		verify(strategy, times(1)).getPDTInformation(any());
		verify(context, times(1)).setInformations(anyList());
		verify(context, never()).setValues(anyList());
	}

}
