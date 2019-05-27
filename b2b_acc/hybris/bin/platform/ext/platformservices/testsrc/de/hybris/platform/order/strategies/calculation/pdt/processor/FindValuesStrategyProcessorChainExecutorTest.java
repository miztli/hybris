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
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.processor.impl.DefaultPDTProcessorChainExecutor;
import de.hybris.platform.util.PDTValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


@UnitTest
public class FindValuesStrategyProcessorChainExecutorTest
{

	@Test
	public void shouldPassThroughWithoutResult() throws CalculationException
	{
		//given
		final DefaultPDTProcessorChainExecutor<PDTValue, PDTInformation, PDTCriteria> chainExecutor = new DefaultPDTProcessorChainExecutor<>();
		chainExecutor.setPdtProcessors(Collections.singletonList(getPassThroughProcessorWithResponseSingleOrNull(null)));

		//when
		final List<PDTValue> response = chainExecutor.getPDTValues(null);

		//then
		assertThat(response).isNull();

	}

	@Test
	public void shouldNotProcessSecondProcessorWhenFirstProcessorIsNotCallingChain() throws CalculationException
	{
		//given
		final DefaultPDTProcessorChainExecutor<PDTValue, PDTInformation, PDTCriteria> chainExecutor = new DefaultPDTProcessorChainExecutor<>();

		final PDTProcessor processorToBlockProcessing = (final PDTContext c, final PDTProcessorChain chain) -> {
			c.setValues(Collections.singletonList(createPDTValue(1)));
			//in this case we don't call chain.doProcess
		};
		final PDTProcessor secondProcessor = getPassThroughProcessorWithResponseSingleOrNull(2d);
		chainExecutor.setPdtProcessors(Arrays.asList(processorToBlockProcessing, secondProcessor));

		//when
		final List<PDTValue> response = chainExecutor.getPDTValues(null);

		//then
		assertThat(response).isNotEmpty();
		assertThat(response).extracting(PDTValue::getValue).containsExactly(1d);

	}


	@Test
	public void shouldProcessSecondProcessorWhenFirstProcessorIsCallingChain() throws CalculationException
	{
		//given
		final DefaultPDTProcessorChainExecutor<PDTValue, PDTInformation, PDTCriteria> chainExecutor = new DefaultPDTProcessorChainExecutor<>();

		final PDTProcessor processorToGoThroughProcessing = getPassThroughProcessorWithResponseSingleOrNull(1d);
		final PDTProcessor secondProcessor = getPassThroughProcessorWithResponseSingleOrNull(2d);
		chainExecutor.setPdtProcessors(Arrays.asList(processorToGoThroughProcessing, secondProcessor));

		//when
		final List<PDTValue> response = chainExecutor.getPDTValues(null);

		//then
		assertThat(response).isNotEmpty();
		assertThat(response).extracting(PDTValue::getValue).containsExactly(2d);
	}


	@Test
	public void shouldHaveResultsFromTwoProcessors() throws CalculationException
	{

		//given
		final DefaultPDTProcessorChainExecutor<PDTValue, PDTInformation, PDTCriteria> chainExecutor = new DefaultPDTProcessorChainExecutor<>();
		final PDTProcessor firstProcessor = getPassThroughProcessorWithResultAddedToResponse(1d);
		final PDTProcessor secondProcessor = getPassThroughProcessorWithResultAddedToResponse(2d);
		chainExecutor.setPdtProcessors(Arrays.asList(firstProcessor, secondProcessor));

		//when
		final List<PDTValue> response = chainExecutor.getPDTValues(null);

		//then
		assertThat(response).isNotEmpty();
		assertThat(response).extracting(PDTValue::getValue).containsExactly(1d, 2d);

	}

	private PDTProcessor getPassThroughProcessorWithResponseSingleOrNull(final Double responseValue)
	{
		return (final PDTContext c, final PDTProcessorChain chain) -> {
			if (responseValue != null)
			{
				c.setValues(Collections.singletonList(createPDTValue(responseValue)));
			}
			else
			{
				c.setValues(null);
			}
			chain.doProcess(c);
		};
	}

	private PDTProcessor getPassThroughProcessorWithResultAddedToResponse(final Double responseValue)
	{
		return (final PDTContext c, final PDTProcessorChain chain) -> {
			List<PDTValue> response = c.getValues();
			if (response == null)
			{
				response = new ArrayList<PDTValue>();
			}
			response.add(createPDTValue(responseValue));
			c.setValues(response);
			chain.doProcess(c);
		};
	}

	private PDTValue createPDTValue(final double value)
	{
		return () -> value;
	}
}
