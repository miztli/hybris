package com.hybris.mobile.lib.b2c.service;

import android.content.Context;

import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.service.CommerceServiceHelper;
import com.hybris.mobile.lib.http.converter.DataConverter;
import com.hybris.mobile.lib.http.manager.PersistenceManager;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/**
 * B2C extension to retrieve the application data
 */
public class B2CServiceHelper extends CommerceServiceHelper implements B2CContentServiceHelper {

    public B2CServiceHelper(Context context, Configuration configuration, PersistenceManager persistenceManager, DataConverter dataConverter, boolean uiRelated) {
        super(context, configuration, persistenceManager, dataConverter, uiRelated);
    }

    public B2CServiceHelper(Context context, Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier, boolean uiRelated) {
        super(context, configuration, sslSocketFactory, hostnameVerifier, uiRelated);
    }
}
