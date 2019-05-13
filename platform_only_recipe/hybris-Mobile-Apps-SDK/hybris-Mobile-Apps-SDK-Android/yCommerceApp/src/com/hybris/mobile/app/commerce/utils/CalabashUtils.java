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
package com.hybris.mobile.app.commerce.utils;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.activity.ProductDetailActivity;
import com.hybris.mobile.app.commerce.helper.SessionHelper;
import com.hybris.mobile.lib.commerce.data.EmptyResponse;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.query.QueryLogin;
import com.hybris.mobile.lib.commerce.response.ResponseReceiverEmpty;
import com.hybris.mobile.lib.http.response.Response;


public class CalabashUtils {
    private static final String PACKAGE = "com.hybris.mobile.app.commerce.activity.";
    private static final String INVALID_INVALID = "Activity invalid";
    private static final String TAG = CalabashUtils.class.getCanonicalName();


    public static String navigate(Activity initialActivity, String activityName) {
        String strActivity = INVALID_INVALID;
        try {
            Class destinationActivity = Class.forName(PACKAGE + activityName);
            initialActivity.startActivity(new Intent(initialActivity, destinationActivity));
            strActivity = destinationActivity.getSimpleName();
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Error Calabash Backdoor. Details: " + e.getLocalizedMessage());
        }
        return strActivity;
    }

    public static String navigateProductDetail(Activity initialActivity, String productCode) {
        String strActivity = INVALID_INVALID;

        try {
            Class destinationActivity = Class.forName(PACKAGE + ProductDetailActivity.class.getSimpleName());
            Intent intentProductDetail = new Intent(initialActivity, destinationActivity);
            intentProductDetail.putExtra(IntentConstants.PRODUCT_CODE, productCode);
            initialActivity.startActivity(intentProductDetail);
            strActivity = destinationActivity.getSimpleName();
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Error Calabash Backdoor. Details: " + e.getLocalizedMessage());
        }
        return strActivity;
    }

    public static String login(final Activity initialActivity, final String activityName, final String email, String password) {
        QueryLogin queryLogin = new QueryLogin();
        queryLogin.setUsername(email);
        queryLogin.setPassword(password);

        CommerceApplication.getContentServiceHelper().authenticate(new ResponseReceiverEmpty() {
            @Override
            public void onResponse(Response<EmptyResponse> response) {
                // Save the email for next authenticate
                SessionHelper.saveLastLoggedEmail(email);

                // Save refresh token for the user
                SessionHelper.setUserLoggedIn();

                // Updating the cart on session
                SessionHelper.updateCart(initialActivity, "BackdoorLogin", false);

                CalabashUtils.navigate(initialActivity, activityName);
            }

            @Override
            public void onError(Response<ErrorList> response) {

            }

        }, "BackdoorLogin", queryLogin, false, null, null);

        return "Logged In to " + activityName;
    }

}
