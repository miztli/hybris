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

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;

import com.hybris.mobile.app.commerce.barcode.CommerceBarcodeCheckerFactory;
import com.hybris.mobile.app.commerce.broadcast.LogoutBroadcastReceiver;
import com.hybris.mobile.app.commerce.broadcast.UpdateCacheBroadcastReceiver;
import com.hybris.mobile.app.commerce.utils.ArrayUtils;
import com.hybris.mobile.lib.commerce.helper.SecurityHelper;
import com.hybris.mobile.lib.commerce.service.ContentServiceHelper;
import com.hybris.mobile.lib.commerce.sync.CatalogSyncConstants;
import com.hybris.mobile.lib.http.utils.ConnectionUtils;
import com.hybris.mobile.lib.scanner.ScannerHelper;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/**
 * Main Application class to manage and provide functionality over the apps
 */
public abstract class CommerceApplicationBase extends Application {

    protected static final String TAG = CommerceApplicationBase.class.getCanonicalName();
    protected static CommerceApplicationBase mInstance;
    protected Configuration mConfiguration;
    protected ContentServiceHelper mContentServiceHelper;
    protected ScannerHelper mScannerHelper;
    protected boolean mSaveOnlineStatus = true;

    /**
     * Update the ContentServiceHelper and SyncAdapter url
     *
     * @param url
     * @param catalog
     * @param catalogId
     * @param catalogMainCategoryId
     */
    public static void updateUrl(String url, String catalog, String catalogId, String catalogMainCategoryId) {
        // Cancelling all the requests first
        mInstance.mContentServiceHelper.cancelAll();

        // For the catalog sync adapter
        Bundle bundle = new Bundle();
        bundle.putBoolean(CatalogSyncConstants.SYNC_PARAM_CANCEL_ALL_REQUESTS, true);
        requestCatalogSyncAdapter(bundle);

        // Updating the configuration of the catalog sync adapter
        bundle = new Bundle();
        bundle.putString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_URL, url);
        bundle.putString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_CATALOG, catalog);
        bundle.putString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_CATALOG_ID, catalogId);
        bundle.putString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_CATALOG_VERSION_ID, mInstance.getString(R.string.url_path_catalog_version_id));
        bundle.putString(CatalogSyncConstants.SYNC_PARAM_CONTENT_SERVICE_HELPER_MAIN_CATEGORY_ID, catalogMainCategoryId);
        requestCatalogSyncAdapter(bundle);

        // Content service helper
        mInstance.mContentServiceHelper.updateConfiguration(url, catalog, catalogId, mInstance.getString(R.string.url_path_catalog_version_id), catalogMainCategoryId);
    }

    /**
     * Get the String value associated with the key on the shared settings (Encrypted)
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getStringFromSharedPreferencesSecure(String key, String defaultValue) {
        return SecurityHelper.getStringFromSecureSharedPreferences(getSharedPreferences(), key, defaultValue);
    }

    /**
     * Get the String value associated with the key on the shared settings
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getStringFromSharedPreferences(String key, String defaultValue) {
        return getSharedPreferences().getString(key, defaultValue);
    }

    /**
     * Get the int value associated with the key on the shared settings
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getIntFromSharedPreferences(String key, int defaultValue) {
        return getSharedPreferences().getInt(key, defaultValue);
    }

    /**
     * Get the long value associated with the key on the shared settings
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static long getLongFromSharedPreferences(String key, long defaultValue) {
        return getSharedPreferences().getLong(key, defaultValue);
    }

    /**
     * Get the boolean value associated with the key on the shared settings
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBooleanFromSharedPreferences(String key, boolean defaultValue) {
        return getSharedPreferences().getBoolean(key, defaultValue);
    }

    /**
     * Get the String set value associated with the key on the shared settings
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static Set<String> getStringSetFromSharedPreferences(String key, Set<String> defaultValue) {
        return getSharedPreferences().getStringSet(key, defaultValue);
    }

    /**
     * Set a String pair key/value on the shared settings (Encrypted)
     *
     * @param key
     * @param value
     */
    public static void setStringToSharedPreferencesSecure(String key, String value) {
        SecurityHelper.setStringToSecureSharedPreferences(getSharedPreferences(), key, value);
    }

    /**
     * Set a String pair key/value on the shared settings
     *
     * @param key
     * @param value
     */
    public static void setStringToSharedPreferences(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Set a Long pair key/value on the shared settings
     *
     * @param key
     * @param value
     */
    public static void setLongToSharedPreferences(String key, long value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * Set a int pair key/value on the shared settings
     *
     * @param key
     * @param value
     */
    public static void setIntToSharedPreferences(String key, int value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * Set a boolean pair key/value on the shared settings
     *
     * @param key
     * @param value
     */
    public static void setBooleanToSharedPreferences(String key, boolean value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Set a String set pair key/value on the shared settings
     *
     * @param key
     * @param value
     */
    public static void setStringSetToSharedPreferences(String key, Set<String> value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putStringSet(key, value);
        editor.commit();
    }

    /**
     * Get the shared settings
     *
     * @return
     */
    private static SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mInstance);
    }

    /**
     * Return the configuration instance
     *
     * @return
     */
    public static Configuration getConfiguration() {
        return mInstance.mConfiguration;
    }

    /**
     * Return the application context
     *
     * @return
     */
    public static Context getContext() {
        return mInstance.getApplicationContext();
    }

    /**
     * Save the current online status
     *
     * @param onlineStatus
     */
    public static void saveCurrentOnlineStatus(boolean onlineStatus) {
        mInstance.mSaveOnlineStatus = onlineStatus;
    }

    /**
     * Return true if the status
     *
     * @param onlineStatus
     * @return
     */
    public static boolean isOnlineStatusChanged(boolean onlineStatus) {
        return mInstance.mSaveOnlineStatus != onlineStatus;
    }

    /**
     * Return true if the app is in online mode
     *
     * @return
     */
    public static boolean isOnline() {
        return ConnectionUtils.isConnectedToInternet(getContext());
    }

    /**
     * Return the catalog last sync date
     *
     * @return
     */
    public static String getCatalogLastSyncDate() {
        long lastSyncDateInMillis = mInstance.mContentServiceHelper.getCatalogLastSyncDate();
        String lastSyncDateString;

        if (lastSyncDateInMillis > 0) {
            Date lastSyncDate = new Date(lastSyncDateInMillis);
            lastSyncDateString = Constants.DATE_FORMAT_CATALOG_LAST_SYNC_DATE.format(lastSyncDate);
        } else {
            lastSyncDateString = mInstance.getString(R.string.unknown);
        }

        return lastSyncDateString;
    }

    /**
     * Request a sync of the catalog sync adapter
     *
     * @param bundle
     */
    public static void requestCatalogSyncAdapter(Bundle bundle) {
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        ContentResolver.requestSync(new Account(mInstance.getString(R.string.account_name), mInstance.getString(R.string.account_type)), mInstance.getString(R.string.provider_authority), bundle);
    }

    public void onCreate() {
        super.onCreate();
        mInstance = this;

        String urlBackend = getStringFromSharedPreferences(getString(R.string.preference_key_value_base_url), "");
        String catalogStore = getStringFromSharedPreferences(getString(R.string.preference_key_value_catalog_store), "");
        String catalogId = getStringFromSharedPreferences(getString(R.string.preference_key_value_catalog_id), "");
        String catalogMainCategory = getStringFromSharedPreferences(getString(R.string.preference_key_value_catalog_main_category_id), "");

        // Setting the default backend url
        if (StringUtils.isBlank(urlBackend)) {
            urlBackend = getString(R.string.url_backend);

            int index = ArrayUtils.indexOf(getResources().getStringArray(R.array.backend_url_values), urlBackend);

            // Update the settings
            setStringToSharedPreferences(getString(R.string.preference_key_value_base_url), urlBackend);
            setStringToSharedPreferences(getString(R.string.preference_key_key_base_url), getResources().getStringArray(R.array.backend_url_keys)[index]);
        }

        // Setting the default catalog
        if (StringUtils.isBlank(catalogStore)) {
            catalogStore = getString(R.string.url_path_catalog);
            setStringToSharedPreferences(getString(R.string.preference_key_value_catalog_store), catalogStore);
        }

        if (StringUtils.isBlank(catalogId)) {
            catalogId = getString(R.string.url_path_catalog_id);
            setStringToSharedPreferences(getString(R.string.preference_key_value_catalog_id), catalogId);
        }

        if (StringUtils.isBlank(catalogMainCategory)) {
            catalogMainCategory = getString(R.string.id_category_main);
            setStringToSharedPreferences(getString(R.string.preference_key_value_catalog_main_category_id), catalogMainCategory);
        }

        // Updating the pre-defined catalog key
        String catalogKey = catalogStore + "|" + catalogId + "|" + catalogMainCategory;
        int index = ArrayUtils.indexOf(getResources().getStringArray(R.array.backend_catalog_values), catalogKey);
        setStringToSharedPreferences(getString(R.string.preference_key_key_catalog), getResources().getStringArray(R.array.backend_catalog_keys)[index]);

        // Configuration for the backend url
        com.hybris.mobile.lib.commerce.Configuration configuration = new com.hybris.mobile.lib.commerce.Configuration();
        configuration.setBackendUrl(urlBackend);
        configuration.setCatalogId(catalogId);
        configuration.setCatalog(catalogStore);
        configuration.setCatalogVersionId(mInstance.getString(R.string.url_path_catalog_version_id));
        configuration.setCatalogAuthority(getString(R.string.provider_authority));
        configuration.setCatalogIdMainCategory(catalogMainCategory);

        // Creating the content service helper
        mInstance.mContentServiceHelper = buildContentServiceHelper(configuration, null, null);

        // Build the configuration for the app
        mConfiguration = Configuration.buildConfiguration(this);

        // Barcode scanner instance
        mScannerHelper = new ScannerHelper(new CommerceBarcodeCheckerFactory());

        // Register local broadcast to Logout
        LocalBroadcastManager.getInstance(this).registerReceiver(new LogoutBroadcastReceiver(),
                new IntentFilter(getString(R.string.intent_action_logout)));

        // Register local broadcast to update cache on the content service helper
        LocalBroadcastManager.getInstance(this).registerReceiver(new UpdateCacheBroadcastReceiver(),
                new IntentFilter(getString(R.string.intent_action_update_cache)));

        // Default account for the sync adapter
        addCatalogSyncAdapterDefaultAccount();

        // We sync in advance the main category of the catalog to create the sync adapter and accelerate the process
        Bundle bundle = new Bundle();
        bundle.putString(CatalogSyncConstants.SYNC_PARAM_GROUP_ID, catalogMainCategory);
        bundle.putInt(CatalogSyncConstants.SYNC_PARAM_CURRENT_PAGE, 0);
        bundle.putInt(CatalogSyncConstants.SYNC_PARAM_PAGE_SIZE, mConfiguration.getDefaultPageSize());
        requestCatalogSyncAdapter(bundle);
    }

    /**
     * Build the content service helper
     *
     * @param configuration
     * @param sslSocketFactory
     * @param hostnameVerifier @return
     */
    protected abstract ContentServiceHelper buildContentServiceHelper(com.hybris.mobile.lib.commerce.Configuration configuration, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier);

    public static ScannerHelper getScannerHelper() {
        return mInstance.mScannerHelper;
    }

    /**
     * Add a default account to the sync adapter
     */
    private void addCatalogSyncAdapterDefaultAccount() {
        AccountManager accountManager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
        accountManager.addAccountExplicitly(new Account(getString(R.string.account_name), getString(R.string.account_type)), null, null);
    }

}
