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

package com.hybris.mobile.app.commerce.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;

import com.hybris.mobile.app.commerce.R;


/**
 * Fragment for the settings
 */
public class SettingsFragment extends PreferenceFragment {

    private Preference mCategoryList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the settings from an XML resource
        addPreferencesFromResource(R.xml.settings);

        // We save the category list for offline in case we show/hide this section
        mCategoryList = findPreference("settings_sync_categories");

        Preference switchSync = findPreference("settings_sync_status");

        // Show/hide the category list for sync
        showSyncCategoryList(switchSync.getSharedPreferences().getBoolean("settings_sync_status", false));

        // Register for changes on the switch to show/hide the sync category list
        switchSync.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                showSyncCategoryList((Boolean) newValue);
                return true;
            }
        });

    }

    private void showSyncCategoryList(boolean show) {
        PreferenceCategory category = (PreferenceCategory) findPreference("settings_sync");

        // Show/hide the category list
        if (show) {
            category.addPreference(mCategoryList);
        } else {
            category.removePreference(mCategoryList);
        }
    }

}
