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

package com.hybris.mobile.lib.commerce.service;

import android.content.Context;

import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.utils.JsonUtils;
import com.hybris.mobile.lib.http.converter.JsonDataConverter;
import com.hybris.mobile.lib.http.manager.PersistenceManager;
import com.hybris.mobile.lib.http.manager.volley.VolleyPersistenceManager;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;


/**
 * Static class to instantiate a content service helper
 */
public final class CommerceContentServiceHelperBuilder {
    private CommerceContentServiceHelperBuilder() {
    }

    /**
     * Build a content service helper
     *
     * @param context          the android context
     * @param sslSocketFactory SSL factory to use for the secure calls
     * @param hostnameVerifier Hostname verifier to use for the secure calls
     * @return Service used to get the application data
     */
    public static CommerceContentServiceHelper build(Context context, Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier, boolean uiRelated) {
        PersistenceManager persistenceManager = new VolleyPersistenceManager(context, sslSocketFactory, hostnameVerifier);
        return new CommerceServiceHelper(context, configuration, persistenceManager, new JsonDataConverter() {

            @Override
            public String createErrorMessage(String errorMessage, String errorType) {
                return JsonUtils.createErrorMessageFromOCC(errorMessage, errorType);
            }

        }, false);

    }

}
