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

package de.hybris.platform.order.strategies.calculation.pdt.impl;

import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.jalo.order.price.PDTInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.pdt.FindPDTValueInfoStrategy;
import de.hybris.platform.order.strategies.calculation.pdt.converter.PDTConverter;
import de.hybris.platform.order.strategies.calculation.pdt.criteria.PDTCriteria;
import de.hybris.platform.order.strategies.calculation.pdt.matcher.PDTModelMatcher;
import de.hybris.platform.order.strategies.calculation.pdt.postmatcher.PDTPostMatcher;
import de.hybris.platform.util.PDTValue;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;


public class GenericPDTFindValueInfoStrategy<VALUE extends PDTValue, INFO extends PDTInformation, CRITERIA extends PDTCriteria, MODEL extends PDTRowModel>
		implements FindPDTValueInfoStrategy<VALUE, INFO, CRITERIA>
{

	private PDTModelMatcher<CRITERIA, MODEL> valueModelMatcher;
	private PDTModelMatcher<CRITERIA, MODEL> informationModelMatcher;

	private PDTPostMatcher<CRITERIA, MODEL> valuePostMatcher;
	private PDTPostMatcher<CRITERIA, MODEL> informationPostMatcher;

	private PDTConverter<MODEL, VALUE, CRITERIA> valueConverter;
	private PDTConverter<MODEL, INFO, CRITERIA> informationConverter;

	@Override
	public List<VALUE> getPDTValues(final CRITERIA criteria) throws CalculationException
	{
		Collection<MODEL> rowModels = valueModelMatcher.matchRows(criteria);
		rowModels = valuePostMatcher.process(rowModels, criteria);
		return valueConverter.convertAll(rowModels, criteria);
	}

	@Override
	public List<INFO> getPDTInformation(final CRITERIA criteria) throws CalculationException
	{
		Collection<MODEL> rowModels = informationModelMatcher.matchRows(criteria);
		rowModels = informationPostMatcher.process(rowModels, criteria);
		return informationConverter.convertAll(rowModels, criteria);
	}

	@Required
	public void setInformationConverter(final PDTConverter<MODEL, INFO, CRITERIA> informationConverter)
	{
		this.informationConverter = informationConverter;
	}

	@Required
	public void setValueConverter(final PDTConverter<MODEL, VALUE, CRITERIA> valueConverter)
	{
		this.valueConverter = valueConverter;
	}

	@Required
	public void setValueModelMatcher(final PDTModelMatcher<CRITERIA, MODEL> valueModelMatcher)
	{
		this.valueModelMatcher = valueModelMatcher;
	}

	@Required
	public void setInformationModelMatcher(final PDTModelMatcher<CRITERIA, MODEL> informationModelMatcher)
	{
		this.informationModelMatcher = informationModelMatcher;
	}

	@Required
	public void setValuePostMatcher(final PDTPostMatcher<CRITERIA, MODEL> postMatcher)
	{
		this.valuePostMatcher = postMatcher;
	}

	@Required
	public void setInformationPostMatcher(final PDTPostMatcher<CRITERIA, MODEL> postInformationMatcher)
	{
		this.informationPostMatcher = postInformationMatcher;
	}
}
