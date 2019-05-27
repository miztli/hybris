/*******************************************************************************
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 ******************************************************************************/

package com.hybris.mobile.lib.commerce.sync;

import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.service.CommerceContentServiceHelperBuilder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;


/**
 * Service to init and bind the catalog sync adapter
 */
public class CommerceCatalogSyncService extends CatalogSyncService {
    @Override
    public CatalogSyncAdapter buildSyncAdapter(Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier) {
        return new CommerceCatalogSyncAdapter(getApplicationContext(), true,
                CommerceContentServiceHelperBuilder.build(getApplicationContext(), configuration, sslSocketFactory, hostnameVerifier, false));
    }
}
