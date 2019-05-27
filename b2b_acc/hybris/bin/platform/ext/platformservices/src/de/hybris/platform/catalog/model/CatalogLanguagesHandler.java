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
package de.hybris.platform.catalog.model;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

import java.util.Collection;


public class CatalogLanguagesHandler implements DynamicAttributeHandler<Collection<LanguageModel>, CatalogModel>
{

	@Override
	public Collection<LanguageModel> get(final CatalogModel model)
	{
		final CatalogVersionModel activeCatalogVersion = model.getActiveCatalogVersion();
		if (activeCatalogVersion != null)
		{
			return activeCatalogVersion.getLanguages();
		}
		return null;
	}

	@Override
	public void set(final CatalogModel model, final Collection<LanguageModel> lanuages)
	{
	}
}
