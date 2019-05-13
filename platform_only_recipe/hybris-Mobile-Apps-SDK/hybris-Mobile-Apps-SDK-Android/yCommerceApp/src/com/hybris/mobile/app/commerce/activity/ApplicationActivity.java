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

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.broadcast.ResumeContextBroadcastReceiver;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.app.commerce.utils.CalabashUtils;
import com.hybris.mobile.lib.http.utils.RequestUtils;

import org.apache.commons.lang3.StringUtils;


/**
 * Base activity
 */
public abstract class ApplicationActivity extends Activity {

    // Broadcast for resuming the activity
    protected BroadcastReceiver mResumeContextBroadcastReceiver = new ResumeContextBroadcastReceiver() {

        @Override
        public void onReceive() {
            // Update the cart in the session
            SessionHelper.updateCart(ApplicationActivity.this, RequestUtils.generateUniqueRequestId(), false);

            // Resume the activity
            onResume();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        // Register a broadcast for resuming the activity
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mResumeContextBroadcastReceiver,
                new IntentFilter(getString(R.string.intent_action_resume)));
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mResumeContextBroadcastReceiver);
    }

    // TODO - Calabash backdoor utils
    public String backdoorNavigateTo(String activityName) {
        return CalabashUtils.navigate(this, activityName);
    }

    public String backdoorGoProductdetail(String productCode) {
        return CalabashUtils.navigateProductDetail(this, productCode);
    }

    public String backdoorLogin(String argument) {
        String parameters[] = StringUtils.split(argument, ';');

        return CalabashUtils.login(this, parameters[0], parameters[1], parameters[2]);
    }
}
