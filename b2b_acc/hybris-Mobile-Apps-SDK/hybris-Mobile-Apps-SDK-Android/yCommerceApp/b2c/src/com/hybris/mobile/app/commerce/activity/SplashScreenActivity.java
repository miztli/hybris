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


/**
 * SplashScreen
 */
public class SplashScreenActivity extends SplashScreenActivityBase {

    @Override
    protected void redirectToApp() {
        // Starting the dashboard activity
        startActivity(new Intent(SplashScreenActivity.this, DashboardActivity.class));
    }

}
