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
package com.hybris.mobile.app.commerce;

import com.hybris.mobile.lib.b2c.service.B2CContentServiceHelper;
import com.hybris.mobile.lib.b2c.service.B2CServiceHelper;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/**
 * B2C Application class to manage and provide functionality over the apps
 */
public class CommerceApplication extends CommerceApplicationBase {

    /**
     * Return the content service helper
     *
     * @return
     */
    public static B2CContentServiceHelper getContentServiceHelper() {
        return (B2CContentServiceHelper) mInstance.mContentServiceHelper;
    }

    @Override
    protected ContentServiceHelper buildContentServiceHelper(com.hybris.mobile.lib.commerce.Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier) {
        return new B2CServiceHelper(getApplicationContext(), configuration, sslSocketFactory, hostnameVerifier, true);
    }

}