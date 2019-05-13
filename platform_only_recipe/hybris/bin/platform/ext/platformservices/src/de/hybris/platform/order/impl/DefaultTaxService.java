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
package de.hybris.platform.order.impl;

import de.hybris.platform.core.model.order.price.TaxModel;
import de.hybris.platform.jalo.order.price.TaxInformation;
import de.hybris.platform.order.TaxService;
import de.hybris.platform.order.daos.TaxDao;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindTaxValuesStrategy;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.servicelayer.internal.service.AbstractBusinessService;
import de.hybris.platform.servicelayer.util.ServicesUtil;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * Default implementation of the {@link TaxService}.
 */
public class DefaultTaxService extends AbstractBusinessService implements TaxService, ApplicationContextAware
{

	private transient ApplicationContext ctx;
	private transient TaxDao taxDao;
	private transient FindTaxValuesStrategy findTaxValuesStrategy;

	@Override
	public TaxModel getTaxForCode(final String code)
	{
		ServicesUtil.validateParameterNotNullStandardMessage("code", code);

		final List<TaxModel> taxes = taxDao.findTaxesByCode(code);

		ServicesUtil.validateIfSingleResult(taxes, TaxModel.class, "code", code);
		return taxes.get(0);
	}

	@Override
	public Collection<TaxModel> getTaxesForCode(final String matchedCode)
	{
		ServicesUtil.validateParameterNotNullStandardMessage("matchedCode", matchedCode);

		final Collection<TaxModel> taxes = taxDao.findTaxesByCodePattern(matchedCode);
		return taxes;
	}

	@Override
	public List<TaxInformation> getTaxInformation(final BaseCriteria baseCriteria) throws CalculationException
	{
		return findTaxValuesStrategy.getTaxInformation(baseCriteria);
	}

	@Required
	public void setTaxDao(final TaxDao taxDao)
	{
		this.taxDao = taxDao;
	}

	@Override
	public void setApplicationContext(final ApplicationContext ctx)
	{
		this.ctx = ctx;
	}

	// actually this would be @Required but we don't know how many partners did
	// override it. so we're looking it up in afterPropertiesSet() in case it's missing
	public void setFindTaxValuesStrategy(final FindTaxValuesStrategy findTaxValuesStrategy)
	{
		this.findTaxValuesStrategy = findTaxValuesStrategy;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		super.afterPropertiesSet();

		if (findTaxValuesStrategy == null)
		{
			this.findTaxValuesStrategy = ctx.getBean("findTaxValuesStrategy", FindTaxValuesStrategy.class);
		}
	}

}
