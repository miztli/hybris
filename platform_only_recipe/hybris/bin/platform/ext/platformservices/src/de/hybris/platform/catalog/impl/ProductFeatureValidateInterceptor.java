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
package de.hybris.platform.catalog.impl;

import de.hybris.platform.catalog.model.ProductFeatureModel;
import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import de.hybris.platform.servicelayer.type.TypeService;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Required;


/**
 * ProductFeature Validator
 */
public class ProductFeatureValidateInterceptor implements ValidateInterceptor<ProductFeatureModel>
{
	private TypeService typeService;

	@Override
	public void onValidate(final ProductFeatureModel feature, final InterceptorContext ctx) throws InterceptorException
	{
		if (feature.getValue() == null)
		{
			throw new InterceptorException("missing attribute 'Value' ");
		}

		if (isUntypedFeature(feature))
		{
			return;
		}

		final ClassAttributeAssignmentModel assignment = feature.getClassificationAttributeAssignment();

		if (assignment == null)
		{
			return;
		}

		final ComposedTypeModel configuredReferenceType = assignment.getReferenceType();

		if (configuredReferenceType == null)
		{
			return;
		}

		final ComposedTypeModel actualValueType = getComposedTypeForValue(feature.getValue());

		if (assignment.getReferenceIncludesSubTypes())
		{
			if (!typeService.isAssignableFrom(configuredReferenceType, actualValueType))
			{
				throw new InterceptorException(MessageFormat.format(
						"Corresponding ClassificationAttributeAssignment is not configured to handle {0} type, configured one is {1}",
						actualValueType.getCode(), assignment.getReferenceType().getCode()));
			}
		}
		else
		{
			if (!configuredReferenceType.getPk().equals(actualValueType.getPk()))
			{
				throw new InterceptorException(MessageFormat.format(
						"Corresponding ClassificationAttributeAssignment is not configured to handle {0} type, configured one is {1}. Subtypes are disabled.",
						actualValueType.getCode(), assignment.getReferenceType().getCode()));
			}
		}
	}

	private boolean isUntypedFeature(final ProductFeatureModel feature)
	{
		return feature.getClassificationAttributeAssignment() == null;
	}

	private ComposedTypeModel getComposedTypeForValue(final Object value)
	{
		return typeService.getComposedTypeForCode(((ItemModel) value).getItemModelContext().getItemType());
	}

	@Required
	public void setTypeService(final TypeService typeService)
	{
		this.typeService = typeService;
	}
}
