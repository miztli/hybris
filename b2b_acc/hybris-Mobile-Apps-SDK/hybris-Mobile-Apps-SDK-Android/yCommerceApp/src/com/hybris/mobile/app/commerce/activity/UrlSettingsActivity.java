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

package com.hybris.mobile.app.commerce.activity;

import android.app.Activity;
import android.os.Bundle;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.UrlSettingsFragment;


public class UrlSettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_url_settings);
        getActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void onBackPressed() {
        UrlSettingsFragment urlSettingsFragment = (UrlSettingsFragment) getFragmentManager().findFragmentById(R.id.options_fragment);

        // We remove the fragment, will call onDetach on the fragment to logout or not
        if (urlSettingsFragment != null && urlSettingsFragment.hasPreferencesChanged()) {
            getFragmentManager().beginTransaction().remove(urlSettingsFragment).commit();
        } else {
            super.onBackPressed();
        }
    }
}
