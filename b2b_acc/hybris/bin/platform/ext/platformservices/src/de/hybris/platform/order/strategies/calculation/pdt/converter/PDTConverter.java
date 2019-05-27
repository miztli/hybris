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

package de.hybris.platform.order.strategies.calculation.pdt.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;


public interface PDTConverter<SOURCE, TARGET, CONTEXT>
{
	TARGET convert(SOURCE source, CONTEXT context);

	default List<TARGET> convertAll(final Collection<? extends SOURCE> sources, final CONTEXT context)
	{
		if (CollectionUtils.isEmpty(sources))
		{
			return Collections.emptyList();
		}

		final List<TARGET> result = new ArrayList<>(sources.size());

		for (final SOURCE source : sources)
		{
			result.add(convert(source, context));
		}
		return result;
	}
}
