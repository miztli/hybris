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

package com.hybris.mobile.lib.commerce.sync;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.hybris.mobile.lib.commerce.Configuration;
import com.hybris.mobile.lib.commerce.R;
import com.hybris.mobile.lib.commerce.helper.SSLHelper;
import com.hybris.mobile.lib.commerce.provider.CatalogProvider;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;


/**
 * Service to init and bind the catalog sync adapter
 */
public abstract class CatalogSyncService extends Service {
    private static final String TAG = CatalogSyncService.class.getCanonicalName();
    protected static CatalogSyncAdapter mSyncAdapter = null;
    private static final Object mSingletonLock = new Object();

    @Override
    public void onCreate() {
        Log.i(TAG, "Service for the CatalogSyncAdapter starting");

        // The sync adapter is created as a singleton
        synchronized (mSingletonLock) {
            if (mSyncAdapter == null) {

                try {
                    ComponentName componentName = new ComponentName(this, this.getClass());
                    Bundle bundle = getPackageManager().getServiceInfo(componentName, PackageManager.GET_META_DATA).metaData;

                    String urlBackend = bundle.getString(getApplicationContext().getString(R.string.sync_url_backend_metadata_name));
                    String urlPathCatalogMetadataName = bundle.getString(getApplicationContext().getString(R.string.sync_url_path_catalog_metadata_name));
                    String urlPathCatalogIdMetadataName = bundle.getString(getApplicationContext().getString(R.string.sync_url_path_catalog_id_metadata_name));
                    String urlPathCatalogVersionIdMetadataName = bundle.getString(getApplicationContext().getString(R.string.sync_url_path_catalog_version_id_metadata_name));
                    String idMainCategory = bundle.getString(getApplicationContext().getString(R.string.sync_id_category_main));

                    if (StringUtils.isBlank(urlBackend) || StringUtils.isBlank(urlBackend) || StringUtils.isBlank(urlBackend) || StringUtils.isBlank(idMainCategory)) {
                        throw new IllegalArgumentException("You must provide the metadata " + getApplicationContext().getString(R.string.sync_url_backend_metadata_name) + ", " + getApplicationContext().getString(R.string.sync_url_path_catalog_metadata_name) + ", " + getApplicationContext().getString(R.string.sync_url_path_catalog_id_metadata_name) + ", " + getApplicationContext().getString(R.string.sync_url_path_catalog_version_id_metadata_name) + ", " + getApplicationContext().getString(R.string.sync_id_category_main) + " for " + this.getClass());
                    }

                    Configuration configuration = new Configuration();
                    configuration.setBackendUrl(urlBackend);
                    configuration.setCatalog(urlPathCatalogMetadataName);
                    configuration.setCatalogId(urlPathCatalogIdMetadataName);
                    configuration.setCatalogVersionId(urlPathCatalogVersionIdMetadataName);
                    configuration.setCatalogIdMainCategory(idMainCategory);

                    // Provider authority
                    String provider_authority = getString(R.string.sync_default_authority);

                    try {
                        componentName = new ComponentName(this, CatalogProvider.class);

                        // Authority name from the manifest file
                        String tmpAuthority = getPackageManager().getProviderInfo(componentName, PackageManager.GET_META_DATA).authority;

                        if (StringUtils.isNotBlank(tmpAuthority)) {
                            provider_authority = tmpAuthority;
                        }

                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e(TAG, "Package name not found. Details:" + e.getLocalizedMessage());
                    }

                    configuration.setCatalogAuthority(provider_authority);

                    // SSL Helper for the ssl factory and hostname verifier
                    String sslHelperClassName = bundle.getString(getApplicationContext().getString(R.string.sync_ssl_helper));
                    SSLSocketFactory sslSocketFactory = null;
                    HostnameVerifier hostnameVerifier = null;

                    if (StringUtils.isNotBlank(sslHelperClassName)) {
                        SSLHelper sslHelper = null;
                        String errorMessage = null;
                        try {
                            Class sslFactory = Class.forName(sslHelperClassName);
                            Constructor<SSLHelper> constructor = sslFactory.getConstructor();
                            sslHelper = constructor.newInstance();

                            sslSocketFactory = sslHelper.getSSLSocketFactory();
                            hostnameVerifier = sslHelper.getHostnameVerifier();
                        } catch (ClassNotFoundException e) {
                            errorMessage = e.getLocalizedMessage();
                            Log.e(TAG, "ClassNotFoundException with SSLHelper. Details: " + errorMessage);
                        } catch (InvocationTargetException e) {
                            errorMessage = e.getLocalizedMessage();
                            Log.e(TAG, "InvocationTargetException with SSLHelper. Details: " + errorMessage);
                        } catch (NoSuchMethodException e) {
                            errorMessage = e.getLocalizedMessage();
                            Log.e(TAG, "NoSuchMethodException with SSLHelper. Details: " + errorMessage);
                        } catch (InstantiationException e) {
                            errorMessage = e.getLocalizedMessage();
                            Log.e(TAG, "InstantiationException with SSLHelper. Details: " + errorMessage);
                        } catch (IllegalAccessException e) {
                            errorMessage = e.getLocalizedMessage();
                            Log.e(TAG, "IllegalAccessException with SSLHelper. Details: " + errorMessage);
                        }

                    }

                    // Create the sync adapter
                    mSyncAdapter = buildSyncAdapter(configuration, sslSocketFactory, hostnameVerifier);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e(TAG, "Package name not found. Details:" + e.getLocalizedMessage());
                    throw new IllegalArgumentException("Error getting the information from the metadata of " + this.getClass());
                }

            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        //Get the object that allows external processes to call onPerformSync()
        return mSyncAdapter.getSyncAdapterBinder();
    }

    /**
     * Build the sync adapter to use with this service
     *
     * @param configuration    the configuration
     * @param sslSocketFactory SSL factory to use for the secure calls
     * @param hostnameVerifier Hostname verifier to use for the secure calls
     * @return the CatalogSyncAdapter associated to this sync service
     */
    public abstract CatalogSyncAdapter buildSyncAdapter(Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier);
}
