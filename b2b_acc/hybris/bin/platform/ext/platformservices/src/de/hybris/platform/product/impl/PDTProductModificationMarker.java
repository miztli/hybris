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

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.constants.Europe1Constants;
import de.hybris.platform.europe1.model.PDTRowModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.PersistenceOperation;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import de.hybris.platform.servicelayer.session.Session;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.util.Config;

import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Required;


/**
 * Marks PDTRow product as modified if pdtrow.mark.product.modified is enabled in session/configuration. Used by
 * {@link PDTRowPrepareInterceptor} and {@link PDTRowRemoveInterceptor}
 */
public class PDTProductModificationMarker
{
	private SessionService sessionService;

	public void markProductAsModifiedIfFlagSet(final PDTRowModel pdtRowModel, final InterceptorContext ctx)
	{
		markProductAsModifiedIfFlagSet(pdtRowModel, ctx, false);
	}

	public void markProductAsModifiedIfFlagSet(final PDTRowModel pdtRowModel, final InterceptorContext ctx, final boolean isRemove)
	{
		final Session currentSession = sessionService.getCurrentSession();
		final boolean markProductModifiedSession = Boolean.TRUE
				.equals(currentSession.getAttribute(Europe1Constants.PDTROW_MARK_PRODUCT_MODIFIED));

		final boolean markProductModified = Config.getBoolean(Europe1Constants.PDTROW_MARK_PRODUCT_MODIFIED, false);
		if (markProductModifiedSession || markProductModified)
		{
			markProductModifiedIfNeeded(pdtRowModel, ctx, isRemove);
		}
	}

	private static void markProductModifiedIfNeeded(final PDTRowModel pdtRowModel, final InterceptorContext ctx,
			final boolean isRemove)
	{
		final ProductModel product = pdtRowModel.getProduct();
		if (product == null)
		{
			return;
		}

		final boolean pdtRowModelChanged = ctx.isNew(pdtRowModel) || ctx.isRemoved(pdtRowModel) || isRemove
				|| isPdtRowModelChanged(pdtRowModel);

		if (pdtRowModelChanged)
		{
			product.setModifiedtime(new Date());
			if (!ctx.contains(product, PersistenceOperation.SAVE))
			{
				ctx.registerElementFor(product, PersistenceOperation.SAVE);
			}
		}
	}

	private static boolean isPdtRowModelChanged(final PDTRowModel pdtRowModel)
	{
		return isAnyDirtyAttributeChanged(pdtRowModel) || isAnyDirtyLocalizedAttributeChanged(pdtRowModel);
	}

	private static boolean isAnyDirtyLocalizedAttributeChanged(final PDTRowModel pdtRowModel)
	{
		final ItemModelContext itemModelContext = pdtRowModel.getItemModelContext();
		final Map<Locale, Set<String>> dirtyLocalizedAttributes = itemModelContext.getDirtyLocalizedAttributes();
		if (dirtyLocalizedAttributes != null)
		{
			for (final Map.Entry<Locale, Set<String>> localeSetEntry : dirtyLocalizedAttributes.entrySet())
			{
				final Locale locale = localeSetEntry.getKey();
				final Set<String> attributes = localeSetEntry.getValue();
				final boolean anyLocalizedAttributeChanged = attributes.stream().anyMatch(s -> {
					final Object originalValue = itemModelContext.getOriginalValue(s, locale);
					return !Objects.equals(originalValue, pdtRowModel.getProperty(s, locale));
				});

				if (anyLocalizedAttributeChanged)
				{
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isAnyDirtyAttributeChanged(final PDTRowModel pdtRowModel)
	{
		final ItemModelContext itemModelContext = pdtRowModel.getItemModelContext();
		final Set<String> dirtyAttributes = itemModelContext.getDirtyAttributes();

		return dirtyAttributes != null && dirtyAttributes.stream().anyMatch(s -> {
			final Object originalValue = itemModelContext.getOriginalValue(s);
			return !Objects.equals(originalValue, pdtRowModel.getProperty(s));
		});
	}

	@Required
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}
}
