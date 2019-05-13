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
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;

import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.lib.commerce.data.error.Error;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.http.Constants;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.ui.view.Alert;

import org.apache.commons.lang3.StringUtils;


/**
 * Utils for UI
 */
public class UIUtils {

    public static final String TAG = UIUtils.class.getCanonicalName();
    public static final float CART_ITEM_ACTION_BAR_ICON_SCALE_FACTOR = 0.2f;
    public static final int CART_ITEM_ACTION_BAR_ICON_SCALE_DURATION = 100;

    /**
     * Show/Hide loading icon on the action bar
     *
     * @param activity
     * @param show
     */
    public static void showLoadingActionBar(Activity activity, boolean show) {
        if (activity != null)
            activity.setProgressBarIndeterminateVisibility(show);
    }

    /**
     * Show/Hide the keyboard
     *
     * @param activity
     */
    public static void hideKeyboard(Activity activity) {
        if (activity != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.findViewById(android.R.id.content).getWindowToken(), 0);
        }
    }

    /**
     * Show alert message
     *
     * @param context
     * @param title
     * @param message
     */
    public static void showAlertMessage(Context context, String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.AlertDialogCustom));
        builder.setTitle(title).setIcon(android.R.drawable.ic_dialog_alert).setMessage(message).setCancelable(true)
                .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showError(Response<ErrorList> error, Activity activity) {

        Error firstError = error != null && error.getData().getErrors() != null && !error.getData().getErrors().isEmpty() ? error.getData().getErrors().get(0) : null;

        // We don't show the no connection error because it's already shown as a static block in the MainActivity
        if (firstError != null && !StringUtils.equals(firstError.getType(), Constants.ERROR_TYPE_NO_CONNECTION)) {
            Alert.showError(activity, firstError.getMessage());
        }
    }


    /**
     * Animate the layout to expand
     */
    public static void expandLayout(Context context, View view) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.expand);
        view.setAnimation(animation);
        view.animate();
        animation.start();
    }

    /**
     * Animate the layout to collapse
     */
    public static void collapseLayout(Context context, View view) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.collapse);
        view.setAnimation(animation);
        view.animate();
        animation.start();
    }

}
