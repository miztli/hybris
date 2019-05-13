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

package com.hybris.mobile.app.commerce.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.utils.ArrayUtils;

import org.apache.commons.lang3.StringUtils;


/**
 * Fragment for the settings
 */
public class UrlSettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private boolean mHasPreferencesChanged = false;
    private SharedPreferences mSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the settings from an XML resource
        addPreferencesFromResource(R.xml.url_settings);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSharedPreferences = getPreferenceManager().getSharedPreferences();
        mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        updateSummary(getString(R.string.preference_key_key_base_url), mSharedPreferences.getString(getString(R.string.preference_key_key_base_url), ""));
        updateSummary(getString(R.string.preference_key_value_base_url), mSharedPreferences.getString(getString(R.string.preference_key_value_base_url), ""));
        updateSummary(getString(R.string.preference_key_key_catalog), mSharedPreferences.getString(getString(R.string.preference_key_key_catalog), ""));
        updateSummary(getString(R.string.preference_key_value_catalog_store), mSharedPreferences.getString(getString(R.string.preference_key_value_catalog_store), ""));
        updateSummary(getString(R.string.preference_key_value_catalog_id), mSharedPreferences.getString(getString(R.string.preference_key_value_catalog_id), ""));
        updateSummary(getString(R.string.preference_key_value_catalog_main_category_id), mSharedPreferences.getString(getString(R.string.preference_key_value_catalog_main_category_id), ""));
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        boolean resetBackendEndConnectors = true;
        String keyUrlValue = getString(R.string.preference_key_value_base_url);
        String keyStoreValue = getString(R.string.preference_key_value_catalog_store);
        String keyCatalogIdValue = getString(R.string.preference_key_value_catalog_id);
        String keyCatalogMainCategoryIdValue = getString(R.string.preference_key_value_catalog_main_category_id);

        Preference keyPreference = findPreference(key);
        String keyValue = sharedPreferences.getString(key, "");

        // Setting the description
        keyPreference.setSummary(keyValue);

        // Changing the backend url selection (internal, external, etc.)
        if (StringUtils.equals(key, getString(R.string.preference_key_key_base_url)) || StringUtils.equals(key, keyUrlValue)) {

            String[] keysTab = getResources().getStringArray(R.array.backend_url_keys);
            String[] valuesTab = getResources().getStringArray(R.array.backend_url_values);

            if (StringUtils.equals(key, getString(R.string.preference_key_key_base_url))) {
                int indexKey = ArrayUtils.indexOf(keysTab, keyValue);

                // For custom key don't empty the field
                if (indexKey < keysTab.length - 1) {

                    // If something changed
                    if (!StringUtils.equals(valuesTab[indexKey], mSharedPreferences.getString(keyUrlValue, ""))) {
                        updatePreference(keyUrlValue, valuesTab[indexKey]);
                    } else {
                        resetBackendEndConnectors = false;
                    }

                }
            }
            // Changing the backend url value
            else {
                // Updating the description (Or custom if no value found)
                updatePreference(getString(R.string.preference_key_key_base_url), keysTab[ArrayUtils.indexOf(valuesTab, keyValue)]);
            }

        }
        // Selecting a catalog
        else if (StringUtils.equals(key, getString(R.string.preference_key_key_catalog))) {
            String[] keysTab = getResources().getStringArray(R.array.backend_catalog_keys);
            String[] valuesTab = getResources().getStringArray(R.array.backend_catalog_values);

            String catalog = valuesTab[ArrayUtils.indexOf(keysTab, keyValue)];

            // Catalog is in format: store|catalogId|catalogMainCategoryId
            String[] catalogValues = catalog.split("\\|");

            //  Pre defined values
            if (catalogValues.length > 1) {
                updatePreference(keyStoreValue, catalogValues[0]);
                updatePreference(keyCatalogIdValue, catalogValues[1]);
                updatePreference(keyCatalogMainCategoryIdValue, catalogValues[2]);
            }
        }
        // Changing catalog values
        else if (StringUtils.equals(key, getString(R.string.preference_key_value_catalog_store)) || StringUtils.equals(key, getString(R.string.preference_key_value_catalog_id)) || StringUtils.equals(key, getString(R.string.preference_key_value_catalog_main_category_id))) {

            // We select the corresponding pre-defined catalog
            String catalogKey = mSharedPreferences.getString(keyStoreValue, "") + "|" + mSharedPreferences.getString(keyCatalogIdValue, "") + "|" + mSharedPreferences.getString(keyCatalogMainCategoryIdValue, "");
            int index = ArrayUtils.indexOf(getResources().getStringArray(R.array.backend_catalog_values), catalogKey);
            updatePreference(getString(R.string.preference_key_key_catalog), getResources().getStringArray(R.array.backend_catalog_keys)[index]);
        }

        // Update the url of the backend
        if (resetBackendEndConnectors) {
            CommerceApplication.updateUrl(mSharedPreferences.getString(keyUrlValue, ""), mSharedPreferences.getString(keyStoreValue, ""), mSharedPreferences.getString(keyCatalogIdValue, ""), mSharedPreferences.getString(keyCatalogMainCategoryIdValue, ""));
            mHasPreferencesChanged = true;
        }

    }

    private void updatePreference(String key, String value) {
        Preference preference = findPreference(key);

        if (preference instanceof EditTextPreference) {
            ((EditTextPreference) preference).setText(value);
        } else if (preference instanceof ListPreference) {
            ((ListPreference) preference).setValue(value);
        }

        updateSummary(key, value);
        putStringSharedPreferences(key, value);
    }

    private void updateSummary(String key, String value) {
        Preference preference = findPreference(key);
        preference.setSummary(value);
    }

    private void putStringSharedPreferences(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(this);

        // Logout when preferences have changed
        if (mHasPreferencesChanged) {
            SessionHelper.logout(getActivity(), true);
        }
    }

    public boolean hasPreferencesChanged() {
        return mHasPreferencesChanged;
    }
}
