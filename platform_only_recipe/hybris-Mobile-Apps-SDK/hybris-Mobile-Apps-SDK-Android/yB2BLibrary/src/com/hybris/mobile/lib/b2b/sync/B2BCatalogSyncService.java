/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */

package com.hybris.mobile.lib.b2b.sync;

import com.hybris.mobile.lib.b2b.service.B2BServiceHelper;
import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.sync.CatalogSyncAdapter;
import com.hybris.mobile.lib.commerce.sync.CatalogSyncService;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;


/**
 * Service to init and bind the catalog sync adapter
 */
public class B2BCatalogSyncService extends CatalogSyncService {
    @Override
    public CatalogSyncAdapter buildSyncAdapter(Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier) {
        return new B2BCatalogSyncAdapter(getApplicationContext(), true,
                new B2BServiceHelper(getApplicationContext(), configuration, sslSocketFactory, hostnameVerifier, false));
    }
}
