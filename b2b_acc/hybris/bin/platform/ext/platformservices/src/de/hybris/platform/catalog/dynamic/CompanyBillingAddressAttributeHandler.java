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
package de.hybris.platform.catalog.dynamic;

import de.hybris.platform.core.model.user.AddressModel;

import java.util.Collection;
import java.util.Iterator;


public class CompanyBillingAddressAttributeHandler extends AbstractCompanyAddressAttributeHandler
{
	@Override
	public void filterOutAddresses(final Collection<AddressModel> addresses)
	{
		for (final Iterator<AddressModel> it = addresses.iterator(); it.hasNext();)
		{
			final AddressModel address = it.next();
			if (address.getBillingAddress() == null || !address.getBillingAddress())
			{
				it.remove();
			}
		}
	}
}
