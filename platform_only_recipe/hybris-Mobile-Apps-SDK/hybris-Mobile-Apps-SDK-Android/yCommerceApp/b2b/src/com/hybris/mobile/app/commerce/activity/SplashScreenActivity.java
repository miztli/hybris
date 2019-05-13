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

import android.content.Intent;

import com.hybris.mobile.app.commerce.helper.SessionHelper;


/**
 * SplashScreen
 */
public class SplashScreenActivity extends SplashScreenActivityBase {

    @Override
    protected void redirectToApp() {
        // If someone is already logged in
        if (SessionHelper.isUserLoggedIn()) {
            startActivity(new Intent(SplashScreenActivity.this, DashboardActivity.class));
            finish();
        }
        // Otherwise authenticate page
        else {
            startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
            finish();
        }
    }

}
