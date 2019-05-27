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
package com.hybris.mobile.app.commerce.utils;

import android.app.Activity;
import android.content.Context;

import com.hybris.mobile.app.commerce.CommerceApplication;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.FeedbackManager;
import net.hockeyapp.android.UpdateManager;

import org.apache.commons.lang3.StringUtils;


/**
 * Utility class for HockeyApp integration
 */
public class HockeyAppUtils {

    /**
     * HockeyApp crash manager
     *
     * @param context
     */
    public static void checkForCrashes(Context context) {
        if (StringUtils.isNotBlank(CommerceApplication.getConfiguration().getHockeyAppIdentifier())) {
            CrashManager.register(context, CommerceApplication.getConfiguration().getHockeyAppIdentifier());
        }
    }

    /**
     * HockeyApp for new updates on the app
     *
     * @param context
     */
    public static void checkForUpdates(Activity context) {
        if (StringUtils.isNotBlank(CommerceApplication.getConfiguration().getHockeyAppIdentifier())) {
            UpdateManager.register(context, CommerceApplication.getConfiguration().getHockeyAppIdentifier());
        }
    }

    /**
     * HockeyApp feedbacks
     *
     * @param context
     */
    public static void showFeedbackActivity(Context context) {
        if (StringUtils.isNotBlank(CommerceApplication.getConfiguration().getHockeyAppIdentifier())) {
            FeedbackManager.register(context, CommerceApplication.getConfiguration().getHockeyAppIdentifier());
            FeedbackManager.showFeedbackActivity(context);
        }
    }

}
