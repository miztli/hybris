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
package com.hybris.mobile.app.commerce.activity;

import android.os.Bundle;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.utils.HockeyAppUtils;


/**
 * Landing page after Successful authenticate
 */
public class DashboardActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_dashboard);

        // Check for updates on HockeyApp
        HockeyAppUtils.checkForUpdates(this);

        // Open the main menu by default
        setOpenMainMenuByDefault(true);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Disable the main menu opening in case of resuming
        setOpenMainMenuByDefault(false);
    }
}
