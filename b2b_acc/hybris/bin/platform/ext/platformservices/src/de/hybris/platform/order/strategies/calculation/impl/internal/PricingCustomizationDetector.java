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

package de.hybris.platform.order.strategies.calculation.impl.internal;

import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.core.TenantListener;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.order.OrderManager;
import de.hybris.platform.jalo.order.price.AbstractPriceFactory;
import de.hybris.platform.jalo.order.price.PriceFactory;
import de.hybris.platform.order.strategies.calculation.impl.FindPricingWithCurrentPriceFactoryStrategy;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PricingCustomizationDetector
{
	private static final Logger LOG = LoggerFactory.getLogger(PricingCustomizationDetector.class);

	private static final String JALO_FIND_PRICING_STRATEGY_BEAN = "currentFactoryFindPricingStrategy";
	private static final Class<FindPricingWithCurrentPriceFactoryStrategy> JALO_FIND_PRICING_STRATEGY_DEFAULT_CLASS = FindPricingWithCurrentPriceFactoryStrategy.class;

	private static final Class<PriceFactorySwitcher> DEFAULT_PRICE_FACTORY_IMPLEMENTATION = PriceFactorySwitcher.class;


	private final AtomicBoolean customizedDefaultPriceFactory = new AtomicBoolean(false);
	private final AtomicBoolean slCompatibleCurrentFactoryFindPricingStrategy = new AtomicBoolean(false);

	@PostConstruct
	public void doInit()
	{
		Registry.registerTenantListener(new PricingCustomizationDetectorListener(Registry.getCurrentTenant(),
				customizedDefaultPriceFactory, slCompatibleCurrentFactoryFindPricingStrategy));

		final CalculationMode calculationMode = getCalculationMode();

		if (calculationMode == CalculationMode.SMART)
		{
			LOG.info("PDT smart calculation mode is enabled (pdt.calculation.mode=smart). " +
					"This setting is not recommended for production environment.");
		}
	}

	public boolean useJalo()
	{
		final CalculationMode calculationMode = getCalculationMode();
		if (shouldForceJaloMode(calculationMode))
		{
			return true;
		}

		if (shouldForceServiceLayerMode(calculationMode))
		{
			return false;
		}

		if (useJaloIfCustomFindPricingStrategy())
		{
			return true;
		}

		final PriceFactory priceFactory = JaloSession.getCurrentSession().getPriceFactory();
		if (priceFactory == null)
		{
			return customizedDefaultPriceFactory.get();
		}
		else
		{
			if (isSmartMode() && customizedPriceFactoryInSession(priceFactory))
			{
				LOG.info("Customized PriceFactory detected in JaloSession: " + priceFactory.getClass().getName() + " (not: "
						+ DEFAULT_PRICE_FACTORY_IMPLEMENTATION.getName() + ") - falling back to jalo strategy");
				return true;
			}
			return false;
		}
	}

	private boolean customizedPriceFactoryInSession(final PriceFactory priceFactory)
	{
		return isNotTargetClass(priceFactory, DEFAULT_PRICE_FACTORY_IMPLEMENTATION);
	}

	private boolean useJaloIfCustomFindPricingStrategy()
	{
		return !slCompatibleCurrentFactoryFindPricingStrategy.get();
	}

	private boolean shouldForceServiceLayerMode(final CalculationMode calculationMode)
	{
		return calculationMode == CalculationMode.SL;
	}

	private boolean shouldForceJaloMode(final CalculationMode calculationMode)
	{
		return calculationMode == CalculationMode.JALO;
	}


	private static boolean isSmartMode()
	{
		return getCalculationMode() == CalculationMode.SMART;
	}

	private static CalculationMode getCalculationMode()
	{
		final String property = Registry.getCurrentTenant().getConfig().getString("pdt.calculation.mode", "smart");
		return CalculationMode.fromString(property);
	}

	private enum CalculationMode
	{
		JALO("jalo"), SL("sl"), SMART("smart");
		private final String property;

		CalculationMode(final String property)
		{
			this.property = property;
		}

		public static CalculationMode fromString(final String value)
		{
			final String trimmed = value.trim();
			for (final CalculationMode mode : CalculationMode.values())
			{
				if (mode.property.equalsIgnoreCase(trimmed))
				{
					return mode;
				}
			}
			throw new IllegalArgumentException("No enum constant ." + value);
		}
	}


	private static class PricingCustomizationDetectorListener implements TenantListener
	{
		private final Tenant beanTenant;

		private final AtomicBoolean customizedDefaultPriceFactory;
		private final AtomicBoolean slCompatibleCurrentFactoryFindPricingStrategy;

		private PricingCustomizationDetectorListener(final Tenant beanTenant, final AtomicBoolean customizedDefaultPriceFactory,
				final AtomicBoolean slCompatibleCurrentFactoryFindPricingStrategy)
		{
			this.beanTenant = beanTenant;
			this.customizedDefaultPriceFactory = customizedDefaultPriceFactory;
			this.slCompatibleCurrentFactoryFindPricingStrategy = slCompatibleCurrentFactoryFindPricingStrategy;
		}

		@Override
		public void afterTenantStartUp(final Tenant tenant)
		{
			if (!beanTenant.equals(tenant))
			{
				return;
			}

			final AbstractPriceFactory defaultPriceFactory = OrderManager.getInstance().getDefaultPriceFactory();
			final Object currentFactoryFindPricingStrategy = Registry.getApplicationContext()
					.getBean(JALO_FIND_PRICING_STRATEGY_BEAN);

			if (isNotTargetClass(defaultPriceFactory, DEFAULT_PRICE_FACTORY_IMPLEMENTATION))
			{
				customizedDefaultPriceFactory.set(true);

				if (isSmartMode())
				{
					LOG.info("Customized PriceFactory detected: " + defaultPriceFactory.getClass().getName() + " (not: "
							+ DEFAULT_PRICE_FACTORY_IMPLEMENTATION.getName() + ") - falling back to jalo strategy");
				}
			}

			if (isOfTargetClass(currentFactoryFindPricingStrategy, JALO_FIND_PRICING_STRATEGY_DEFAULT_CLASS))
			{
				slCompatibleCurrentFactoryFindPricingStrategy.set(true);
			}
			else
			{
				if (isSmartMode())
				{
					LOG.info("Detected custom bean '" + JALO_FIND_PRICING_STRATEGY_BEAN + "' implementation: "
							+ currentFactoryFindPricingStrategy.getClass().getName() + " (not: "
							+ JALO_FIND_PRICING_STRATEGY_DEFAULT_CLASS.getName() + " ) - falling back to jalo strategy");
				}
			}
		}


		@Override
		public void beforeTenantShutDown(final Tenant tenant)
		{
			//
		}

		@Override
		public void beforeUnsetActivateSession(final Tenant tenant)
		{
			//
		}

		@Override
		public void afterSetActivateSession(final Tenant tenant)
		{
			//
		}
	}

	private static boolean isOfTargetClass(final Object obj, final Class targetClazz)
	{
		final Class<?> clazz = obj.getClass();
		return clazz.equals(targetClazz);
	}

	private static boolean isNotTargetClass(final Object obj, final Class targetClazz)
	{
		final Class<?> clazz = obj.getClass();
		return !clazz.equals(targetClazz);
	}

}
