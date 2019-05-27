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
package com.hybris.mobile.lib.http.utils;

import android.content.Context;
import android.net.ConnectivityManager;


/**
 * Utilities for connections
 */
public class ConnectionUtils {

    private ConnectionUtils() {
    }

    /**
     * Return true if Internet is reachable
     *
     * @param context Application-specific resources
     * @return True if Internet is reachable
     */
    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivity != null && connectivity.getActiveNetworkInfo() != null
                && connectivity.getActiveNetworkInfo().isConnected();
    }

}
