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

import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.delivery.DeliveryModeModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.deliveryzone.constants.ZoneDeliveryModeConstants;
import de.hybris.platform.deliveryzone.jalo.ZoneDeliveryModeValue;
import de.hybris.platform.deliveryzone.model.ZoneDeliveryModeModel;
import de.hybris.platform.deliveryzone.model.ZoneDeliveryModeValueModel;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindDeliveryCostStrategy;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import de.hybris.platform.util.PriceValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;


/**
 * Service-Layer implementation of {@link FindDeliveryCostStrategy}.
 */
public class DefaultSLFindDeliveryCostStrategy implements FindDeliveryCostStrategy
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultSLFindDeliveryCostStrategy.class);

	private FlexibleSearchService flexibleSearchService;
	private CommonI18NService commonI18NService;

	private static final String ZONE_DELIVERY_MODE_QUERY = "SELECT {v.PK} " + "FROM {"
			+ ZoneDeliveryModeConstants.TC.ZONEDELIVERYMODEVALUE + " AS v " + "JOIN "
			+ ZoneDeliveryModeConstants.Relations.ZONECOUNTRYRELATION + " AS z2cRel " + "ON {v." + ZoneDeliveryModeValue.ZONE
			+ "}={z2cRel." + Link.SOURCE + "} } " + "WHERE " + "{v." + ZoneDeliveryModeValue.DELIVERYMODE + "} = ?me AND " + "{v."
			+ ZoneDeliveryModeValue.CURRENCY + "} = ?curr AND " + "{v." + ZoneDeliveryModeValue.MINIMUM + "} <= ?amount AND "
			+ "{z2cRel." + Link.TARGET + "} = ?country " + "ORDER BY {v." + ZoneDeliveryModeValue.MINIMUM + "} DESC ";// get closest minimum at top



	@Override
	public PriceValue getDeliveryCost(final AbstractOrderModel order)
	{
		ServicesUtil.validateParameterNotNullStandardMessage("order", order);
		try
		{
			return getDeliveryCostValue(order);
		}
		catch (final CalculationException e)
		{
			LOG.warn("Could not find deliveryCost for order [{}] due to : {}... skipping!", order.getCode(), e, e);

			if (order.getCurrency() == null)
			{
				throw new IllegalArgumentException("order currency cannot be NULL");
			}

			if (order.getNet() == null)
			{
				throw new IllegalArgumentException("order net cannot be NULL");
			}

			return new PriceValue(order.getCurrency().getIsocode(), 0.0, order.getNet().booleanValue());
		}
	}

	@Override
	public boolean isSLOnly()
	{
		return true;
	}

	protected PriceValue getDeliveryCostValue(final AbstractOrderModel order) throws CalculationException
	{
		final DeliveryModeModel deliveryModeModel = order.getDeliveryMode();

		if (deliveryModeModel instanceof ZoneDeliveryModeModel)
		{
			validateOrder(order);

			final AddressModel addr = order.getDeliveryAddress();
			final CountryModel country = addr.getCountry();
			final CurrencyModel curr = order.getCurrency();

			final ZoneDeliveryModeModel zoneDeliveryMode = (ZoneDeliveryModeModel) order.getDeliveryMode();

			final String propName = zoneDeliveryMode.getPropertyName();
			if (propName == null)
			{
				throw new CalculationException("missing propertyname in deliverymode " + this);
			}

			final double amount = getCalculationBaseValue(order, propName);

			final Map<String, Object> params = new HashMap<>();
			params.put("me", zoneDeliveryMode);
			params.put("curr", curr);
			params.put("country", country);
			params.put("amount", Double.valueOf(amount));

			FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(ZONE_DELIVERY_MODE_QUERY, params);

			SearchResult<ZoneDeliveryModeValueModel> results = flexibleSearchService.search(searchQuery);
			List<ZoneDeliveryModeValueModel> values = results.getResult();

			// fallback to base currency if nothing has been found
			if (values.isEmpty() && !curr.getBase().booleanValue() && commonI18NService.getBaseCurrency() != null)
			{
				params.put("curr", commonI18NService.getBaseCurrency());
				searchQuery = new FlexibleSearchQuery(ZONE_DELIVERY_MODE_QUERY, params);
				results = flexibleSearchService.search(searchQuery);
				values = results.getResult();
			}
			if (values.isEmpty())
			{
				throw new CalculationException("no delivery price defined for mode " + this + ", country " + country + ", currency "
						+ curr + " and amount " + amount);
			}

			final ZoneDeliveryModeValueModel bestMatch = values.get(0);

			final CurrencyModel myCurr = bestMatch.getCurrency();
			if (!curr.equals(myCurr) && myCurr != null)
			{
				return new PriceValue(curr.getIsocode(),
						commonI18NService.convertAndRoundCurrency(myCurr.getConversion().doubleValue(),
								curr.getConversion().doubleValue(), curr.getDigits().intValue(), bestMatch.getValue().doubleValue()),
						zoneDeliveryMode.getNet().booleanValue());
			}
			else
			{
				return new PriceValue(curr.getIsocode(), bestMatch.getValue().doubleValue(),
						zoneDeliveryMode.getNet().booleanValue());
			}
		}
		else
		{
			if (order.getCurrency() == null)
			{
				throw new CalculationException("getCost(): currency was NULL in order " + order);
			}
			return new PriceValue(order.getCurrency().getIsocode(), 0.0, order.getNet().booleanValue());
		}
	}

	protected void validateOrder(final AbstractOrderModel order) throws CalculationException
	{
		if (order.getDeliveryAddress() == null)
		{
			throw new CalculationException("getCost(): delivery address was NULL in order " + order);
		}

		if (order.getDeliveryAddress().getCountry() == null)
		{
			throw new CalculationException(
					"getCost(): country of delivery address " + order.getDeliveryAddress() + " was NULL in order " + order);
		}

		if (order.getCurrency() == null)
		{
			throw new CalculationException("getCost(): currency was NULL in order " + order);
		}
	}

	protected double getCalculationBaseValue(final AbstractOrderModel order, final String propName)
	{

		if (ZoneDeliveryModeConstants.PRICE_PROPERTY_NAME.equalsIgnoreCase(propName))
		{
			return order.getSubtotal().doubleValue();
		}
		//--- calculate property sum
		double sum = 0;
		for (final AbstractOrderEntryModel entry : order.getEntries())
		{
			Double value = parseItemProperty(entry.getProduct().getProperty(propName));
			if (value == null)
			{
				value = parseItemProperty(entry.getProperty(propName));
				if (value != null)
				{
					sum += value.doubleValue();
				}
			}
			else
			{
				sum += (value.doubleValue() * entry.getQuantity().longValue());
			}
		}
		return sum;
	}

	private static Double parseItemProperty(final Object value)
	{
		if (value instanceof Number)
		{
			return Double.valueOf(((Number) value).doubleValue());
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
