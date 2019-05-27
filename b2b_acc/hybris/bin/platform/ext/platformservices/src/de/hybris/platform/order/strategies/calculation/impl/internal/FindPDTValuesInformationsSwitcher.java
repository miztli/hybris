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
package de.hybris.platform.order.strategies.calculation.impl.internal;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.order.price.DiscountInformation;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindDeliveryCostStrategy;
import de.hybris.platform.order.strategies.calculation.FindDiscountValuesStrategy;
import de.hybris.platform.order.strategies.calculation.FindPaymentCostStrategy;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.order.strategies.calculation.FindTaxValuesStrategy;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.servicelayer.user.UserNetCheckingStrategy;
import de.hybris.platform.util.DiscountValue;
import de.hybris.platform.util.PriceValue;
import de.hybris.platform.util.TaxValue;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * Internal use only
 */
final class FindPDTValuesInformationsSwitcher implements FindTaxValuesStrategy, FindDiscountValuesStrategy, FindPriceStrategy,
		UserNetCheckingStrategy, FindPaymentCostStrategy, FindDeliveryCostStrategy
{
	private FindDiscountValuesStrategy slFindDiscountValuesStrategy;
	private FindTaxValuesStrategy slFindTaxValuesStrategy;
	private FindPriceStrategy slFindPriceStrategy;
	private UserNetCheckingStrategy slUserNetCheckingStrategy;
	private FindPaymentCostStrategy slFindPaymentCostStrategy;
	private FindDeliveryCostStrategy slFindDeliveryCostStrategy;

	private FindDiscountValuesStrategy findDiscountValuesStrategy;
	private FindTaxValuesStrategy findTaxValuesStrategy;
	private FindPriceStrategy findPriceStrategy;
	private UserNetCheckingStrategy userNetCheckingStrategy;
	private FindPaymentCostStrategy findPaymentCostStrategy;
	private FindDeliveryCostStrategy findDeliveryCostStrategy;

	private PricingCustomizationDetector pricingCustomizationDetector;


	@Override
	public boolean isSLOnly()
	{
		return (isSLOnlyForPricingStrategies() && getPaymentStrategy().isSLOnly() && getDeliveryStrategy().isSLOnly());
	}

	private boolean isSLOnlyForPricingStrategies()
	{
		return getFindDiscountValuesStrategy().isSLOnly() && getFindPriceStrategy().isSLOnly()
				&& getFindTaxValuesStrategy().isSLOnly();
	}

	@Override
	public List<PriceInformation> getPriceInformation(final BaseCriteria priceCriteria) throws CalculationException
	{
		return getFindPriceStrategy().getPriceInformation(priceCriteria);
	}

	@Override
	public List<TaxInformation> getTaxInformation(final BaseCriteria priceCriteria) throws CalculationException
	{
		return getFindTaxValuesStrategy().getTaxInformation(priceCriteria);
	}

	@Override
	public List<DiscountInformation> getDiscountInformation(final BaseCriteria priceCriteria) throws CalculationException
	{
		return getFindDiscountValuesStrategy().getDiscountInformation(priceCriteria);
	}

	@Override
	public boolean isNetUser(final UserModel user)
	{
		return getUserNetCheckingStrategy().isNetUser(user);
	}

	@Override
	public PriceValue findBasePrice(final AbstractOrderEntryModel entry) throws CalculationException
	{
		return getFindPriceStrategy().findBasePrice(entry);
	}

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderEntryModel entry) throws CalculationException
	{
		return getFindDiscountValuesStrategy().findDiscountValues(entry);
	}

	@Override
	public List<DiscountValue> findDiscountValues(final AbstractOrderModel order) throws CalculationException
	{
		return getFindDiscountValuesStrategy().findDiscountValues(order);
	}

	@Override
	public Collection<TaxValue> findTaxValues(final AbstractOrderEntryModel entry) throws CalculationException
	{
		return getFindTaxValuesStrategy().findTaxValues(entry);
	}

	@Override
	public PriceValue getPaymentCost(final AbstractOrderModel order)
	{
		return getPaymentStrategy().getPaymentCost(order);
	}

	@Override
	public PriceValue getDeliveryCost(final AbstractOrderModel order)
	{
		return getDeliveryStrategy().getDeliveryCost(order);
	}

	private FindDeliveryCostStrategy getDeliveryStrategy()
	{
		if (useJaloCalculation())
		{
			return findDeliveryCostStrategy;
		}
		else
		{
			return slFindDeliveryCostStrategy;
		}
	}

	private FindPaymentCostStrategy getPaymentStrategy()
	{
		if (useJaloCalculation())
		{
			return findPaymentCostStrategy;
		}
		else
		{
			return slFindPaymentCostStrategy;
		}
	}

	private FindPriceStrategy getFindPriceStrategy()
	{
		if (useJaloCalculation())
		{
			return findPriceStrategy;
		}
		else
		{
			return slFindPriceStrategy;
		}
	}

	private FindTaxValuesStrategy getFindTaxValuesStrategy()
	{
		if (useJaloCalculation())
		{
			return findTaxValuesStrategy;
		}
		else
		{
			return slFindTaxValuesStrategy;
		}
	}

	private FindDiscountValuesStrategy getFindDiscountValuesStrategy()
	{
		if (useJaloCalculation())
		{
			return findDiscountValuesStrategy;
		}
		else
		{
			return slFindDiscountValuesStrategy;
		}
	}

	private UserNetCheckingStrategy getUserNetCheckingStrategy()
	{
		if (useJaloCalculation())
		{
			return userNetCheckingStrategy;
		}
		else
		{
			return slUserNetCheckingStrategy;
		}
	}

	private boolean useJaloCalculation()
	{
		return pricingCustomizationDetector.useJalo();
	}

	@Required
	public void setSlUserNetCheckingStrategy(final UserNetCheckingStrategy userNetCheckingStrategy)
	{
		this.slUserNetCheckingStrategy = userNetCheckingStrategy;
	}

	@Required
	public void setSlFindTaxValuesStrategy(final FindTaxValuesStrategy findTaxValuesStrategy)
	{
		this.slFindTaxValuesStrategy = findTaxValuesStrategy;
	}

	@Required
	public void setSlFindDiscountValuesStrategy(final FindDiscountValuesStrategy findDiscountValuesStrategy)
	{
		this.slFindDiscountValuesStrategy = findDiscountValuesStrategy;
	}

	@Required
	public void setSlFindPriceStrategy(final FindPriceStrategy findPriceStrategy)
	{
		this.slFindPriceStrategy = findPriceStrategy;
	}

	@Required
	public void setFindDiscountValuesStrategy(final FindDiscountValuesStrategy findDiscountValuesStrategyJALO)
	{
		this.findDiscountValuesStrategy = findDiscountValuesStrategyJALO;
	}

	@Required
	public void setFindTaxValuesStrategy(final FindTaxValuesStrategy findTaxValuesStrategyJALO)
	{
		this.findTaxValuesStrategy = findTaxValuesStrategyJALO;
	}

	@Required
	public void setFindPriceStrategy(final FindPriceStrategy findPriceStrategyJALO)
	{
		this.findPriceStrategy = findPriceStrategyJALO;
	}

	@Required
	public void setUserNetCheckingStrategy(final UserNetCheckingStrategy userNetCheckingStrategyJALO)
	{
		this.userNetCheckingStrategy = userNetCheckingStrategyJALO;
	}

	@Required
	public void setSlFindPaymentCostStrategy(final FindPaymentCostStrategy findPaymentCostStrategySLOnly)
	{
		this.slFindPaymentCostStrategy = findPaymentCostStrategySLOnly;
	}

	@Required
	public void setSlFindDeliveryCostStrategy(final FindDeliveryCostStrategy findDeliveryCostStrategySLOnly)
	{
		this.slFindDeliveryCostStrategy = findDeliveryCostStrategySLOnly;
	}

	@Required
	public void setFindPaymentCostStrategy(final FindPaymentCostStrategy findPaymentCostStrategy)
	{
		this.findPaymentCostStrategy = findPaymentCostStrategy;
	}

	@Required
	public void setFindDeliveryCostStrategy(final FindDeliveryCostStrategy findDeliveryCostStrategy)
	{
		this.findDeliveryCostStrategy = findDeliveryCostStrategy;
	}

	@Required
	public void setPricingCustomizationDetector(final PricingCustomizationDetector pricingCustomizationDetector)
	{
		this.pricingCustomizationDetector = pricingCustomizationDetector;
	}
}
