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
package de.hybris.platform.product.impl;

import static de.hybris.platform.catalog.enums.ClassificationAttributeTypeEnum.REFERENCE;

import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;


public class ClassAttributeAssignmentStateValidator implements ValidateInterceptor<ClassAttributeAssignmentModel>
{
	@Override
	public void onValidate(final ClassAttributeAssignmentModel assignment, final InterceptorContext ctx)
			throws InterceptorException
	{
		if (assignment.getReferenceType() != null && assignment.getAttributeType() != REFERENCE)
		{
			throw new InterceptorException("Reference type is set but attribute type has wrong value (must be " + REFERENCE + ")");
		}
		else if (assignment.getReferenceType() == null && assignment.getAttributeType() == REFERENCE)
		{
            throw new InterceptorException("Attribute type is set to " + REFERENCE + " but reference type is not set");
        }
	}
}
