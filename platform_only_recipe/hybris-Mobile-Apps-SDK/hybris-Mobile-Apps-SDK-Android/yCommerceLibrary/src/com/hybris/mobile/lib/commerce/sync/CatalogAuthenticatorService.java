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

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Authenticator service for the Catalog authenticator
 */
public class CatalogAuthenticatorService extends Service {

    private CatalogAuthenticator mAuthenticator;

    @Override
    public void onCreate() {
        mAuthenticator = new CatalogAuthenticator(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }

}
