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

package com.hybris.mobile.app.commerce.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.lib.http.utils.ConnectionUtils;


/**
 * Broadcast receiver for network change
 */
public class NetworkChangeBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = NetworkChangeBroadcastReceiver.class.getCanonicalName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Broadcast received for network status change");

        // If any change we send a broadcast for resume
        if (CommerceApplication.isOnlineStatusChanged(ConnectionUtils.isConnectedToInternet(context))) {
            // Save the online status
            CommerceApplication.saveCurrentOnlineStatus(ConnectionUtils.isConnectedToInternet(context));

            // Send broadcast
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(context.getString(R.string.intent_action_resume)));
        }

    }
}
