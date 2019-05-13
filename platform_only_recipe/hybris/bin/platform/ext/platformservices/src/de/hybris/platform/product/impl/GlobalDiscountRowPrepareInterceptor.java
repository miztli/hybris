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

import de.hybris.platform.europe1.model.GlobalDiscountRowModel;
import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;


/**
 * {@link PrepareInterceptor} for the {@link GlobalDiscountRowModel}.
 */
public class GlobalDiscountRowPrepareInterceptor extends PDTRowPrepareInterceptor
{

	private static final long MATCH_ANY = de.hybris.platform.core.PK.NULL_PK.getLongValue();
	private static final long MATCH_BY_PRODUCT_ID = MATCH_ANY - 1;

	@Override
	public void onPrepare(final Object model, final InterceptorContext ctx) throws InterceptorException
	{
		if (model instanceof GlobalDiscountRowModel)
		{
			final GlobalDiscountRowModel gdModel = (GlobalDiscountRowModel) model;
			if (ctx.isNew(gdModel))
			{
				gdModel.setProduct(null);
				gdModel.setPg(null);
				updateProductMatchQualifier(gdModel, ctx);
			}
			super.handleUserAndUserGroup(gdModel, ctx);
			super.updateUserMatchQualifier(gdModel, ctx);
		}
	}

	@Override
	protected void updateProductMatchQualifier(final PDTRowModel prModel, final InterceptorContext ctx)
	{
		if (prModel.getProductId() != null)
		{
			prModel.setProductMatchQualifier(MATCH_BY_PRODUCT_ID);
		}
		else
		{
			prModel.setProductMatchQualifier(MATCH_ANY);
		}
	}

	@Override
	protected void updateCatalogVersion(final PDTRowModel pdtModel)
	{
		// do nothing here
	}

}
