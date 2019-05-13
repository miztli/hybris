/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.b2bacceleratoraddon.checkout.steps.validation.impl;

import de.hybris.platform.acceleratorstorefrontcommons.checkout.steps.validation.ValidationResults;
import de.hybris.platform.b2bacceleratoraddon.checkout.steps.validation.AbstractB2BCheckoutStepValidator;

import de.hybris.platform.b2bacceleratorfacades.order.data.B2BPaymentTypeData;
import de.hybris.platform.b2bacceleratorservices.enums.CheckoutPaymentType;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public class DefaultB2BPaymentTypeCheckoutStepValidator extends AbstractB2BCheckoutStepValidator
{
	@Override
	protected ValidationResults doValidateOnEnter(final RedirectAttributes redirectAttributes)
	{
		return ValidationResults.SUCCESS;
	}

	@Override
	public ValidationResults validateOnExit()
	{
		final B2BPaymentTypeData checkoutPaymentType = getCheckoutFacade().getCheckoutCart().getPaymentType();

		if (checkoutPaymentType != null
				&& CheckoutPaymentType.ACCOUNT.getCode().equals(checkoutPaymentType.getCode())
				&& !getCheckoutFlowFacade().hasNoDeliveryAddress())
		{
			return ValidationResults.REDIRECT_TO_DELIVERY_METHOD;
		}

		return ValidationResults.SUCCESS;
	}
}