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
package de.hybris.platform.order.strategies.calculation.impl.servicelayer;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.payment.PaymentModeModel;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindPaymentCostStrategy;
import de.hybris.platform.paymentstandard.constants.StandardPaymentModeConstants;
import de.hybris.platform.paymentstandard.jalo.StandardPaymentModeValue;
import de.hybris.platform.paymentstandard.model.StandardPaymentModeModel;
import de.hybris.platform.paymentstandard.model.StandardPaymentModeValueModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.util.PriceValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;


/**
 * Service-Layer implementation of {@link FindPaymentCostStrategy}.
 */
public class DefaultSLFindPaymentCostStrategy implements FindPaymentCostStrategy
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultSLFindPaymentCostStrategy.class);
	private FlexibleSearchService flexibleSearchService;
	private CommonI18NService commonI18NService;

	private static final String STANDARD_PAYMENT_MODE_QUERY = "SELECT {PK} FROM {"
			+ StandardPaymentModeConstants.TC.STANDARDPAYMENTMODEVALUE + "} " + "WHERE {" + StandardPaymentModeValue.PAYMENTMODE
			+ "}=?me AND " + "{" + StandardPaymentModeValue.CURRENCY + "}=?curr ";



	@Override
	public PriceValue getPaymentCost(final AbstractOrderModel order)
	{
		try
		{
			return getPaymentCostValue(order);
		}
		catch (final Exception e)
		{
			LOG.warn("Could not find paymentCost for order [{}] due to : {}... skipping!", order.getCode(), e, e);
			return new PriceValue(order.getCurrency().getIsocode(), 0.0, order.getNet().booleanValue());
		}
	}

	@Override
	public boolean isSLOnly()
	{
		return true;
	}

	protected PriceValue getPaymentCostValue(final AbstractOrderModel order) throws CalculationException
	{
		final PaymentModeModel paymentMode = order.getPaymentMode();
		if (paymentMode instanceof StandardPaymentModeModel)
		{

			final CurrencyModel curr = order.getCurrency();
			final StandardPaymentModeModel standardPaymenetMode = (StandardPaymentModeModel) paymentMode;
			CurrencyModel base = null;
			if (curr == null)
			{
				throw new CalculationException("getCost(): currency was NULL in order.");
			}
			StandardPaymentModeValueModel value = getPaymentModeValue(standardPaymenetMode, curr);
			if (value == null && !curr.getBase().booleanValue())
			{
				base = commonI18NService.getBaseCurrency();
				value = base != null ? getPaymentModeValue(standardPaymenetMode, base) : null;
			}
			if (value == null)
			{
				throw new CalculationException(
						"getCost(): No price defined for paymentMode='" + this + "' and currency '" + curr + "'.");
			}
			if (base != null)
			{
				return new PriceValue(curr.getIsocode(),
						commonI18NService.convertAndRoundCurrency(base.getConversion().doubleValue(),
								curr.getConversion().doubleValue(), curr.getDigits().intValue(), value.getValue().doubleValue()),
						standardPaymenetMode.getNet().booleanValue());
			}
			else
			{
				return new PriceValue(curr.getIsocode(), value.getValue().doubleValue(),
						standardPaymenetMode.getNet().booleanValue());
			}
		}
		else
		{
			return new PriceValue(order.getCurrency().getIsocode(), 0.0, order.getNet().booleanValue());
		}
	}

	private StandardPaymentModeValueModel getPaymentModeValue(final PaymentModeModel paymentModeModel, final CurrencyModel curr)
	{
		final Map<String, Object> params = new HashMap<>();
		params.put("me", paymentModeModel);
		params.put("curr", curr);

		final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(STANDARD_PAYMENT_MODE_QUERY, params);
		final SearchResult<StandardPaymentModeValueModel> results = flexibleSearchService.search(searchQuery);
		final List<StandardPaymentModeValueModel> values = results.getResult();

		if (!values.isEmpty())
		{
			return values.get(0);
		}
		else
		{
			return null;
		}
	}


	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

	@Required
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}

}
