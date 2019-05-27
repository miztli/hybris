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
package com.hybris.mobile.app.commerce.helper;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.fragment.CartFragment;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.sync.CatalogSyncConstants;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;


/**
 * Helper for session related
 */
public final class
        SessionHelper {

    public static final String LAST_LOGGED_IN_EMAIL = "LAST_LOGGED_IN_EMAIL";
    public static final String IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN";
    public static final String CART_TOTAL_UNIT_COUNT = "CART_TOTAL_UNIT_COUNT";
    public static final String CART_TOTAL_UNIT_COUNT_PREVIOUS = "CART_TOTAL_UNIT_COUNT_PREVIOUS";
    public static final String CATALOG_PRODUCT_ITEM_VIEW_TYPE = "CATALOG_PRODUCT_ITEM_VIEW_TYPE";

    /**
     * Save the last logged email
     *
     * @param email
     */
    public static void saveLastLoggedEmail(String email) {
        CommerceApplication.setStringToSharedPreferencesSecure(LAST_LOGGED_IN_EMAIL, email);
    }

    /**
     * Get the last logged email
     */
    public static String getLastLoggedEmail() {
        return CommerceApplication.getStringFromSharedPreferencesSecure(LAST_LOGGED_IN_EMAIL, "");
    }

    /**
     * Return true if a user is logged in
     *
     * @return
     */
    public static boolean isUserLoggedIn() {
        return CommerceApplication.getBooleanFromSharedPreferences(IS_USER_LOGGED_IN, false);
    }

    /**
     * Set the user logged in hint to true
     */
    public static void setUserLoggedIn() {
        CommerceApplication.setBooleanToSharedPreferences(IS_USER_LOGGED_IN, true);
    }

    /**
     * Logout a user
     *
     * @param context
     * @param explicit
     */
    public static void logout(Context context, boolean explicit) {
        // Logout the user only if he is online OR if this is an explicit demand (logout from the user)
        if (CommerceApplication.isOnline() || explicit) {
            // Logout the user from the B2B layer
            CommerceApplication.getContentServiceHelper().logout();

            // Clear logged in hint
            CommerceApplication.setBooleanToSharedPreferences(IS_USER_LOGGED_IN, false);

            // Reset cart
            resetCart();

            // Catalog sync adapter requests cancel
            Bundle bundle = new Bundle();
            bundle.putBoolean(CatalogSyncConstants.SYNC_PARAM_CANCEL_ALL_REQUESTS, true);
            CommerceApplication.requestCatalogSyncAdapter(bundle);

            // Restart application
            Intent intent = context.getPackageManager()
                    .getLaunchIntentForPackage(context.getPackageName());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
    }

    /**
     * Get the total unit count from the current cart from the shared settings
     *
     * @return
     */
    public static int getCartTotalUnitCount() {
        return CommerceApplication.getIntFromSharedPreferences(CART_TOTAL_UNIT_COUNT, 0);
    }

    /**
     * Get the previous total unit count from the current cart from the shared settings
     *
     * @return
     */
    public static int getCartTotalUnitCountPrevious() {
        return CommerceApplication.getIntFromSharedPreferences(CART_TOTAL_UNIT_COUNT_PREVIOUS, 0);
    }

    /**
     * Sync the unit count in the shared settings between the previous value and current value
     */
    public static void syncCartTotalUnitCountPrevious() {
        CommerceApplication.setIntToSharedPreferences(CART_TOTAL_UNIT_COUNT_PREVIOUS, getCartTotalUnitCount());
    }

    /**
     * Reset the previous total unit count
     */
    public static void resetCartTotalUnitCountPrevious() {
        CommerceApplication.setIntToSharedPreferences(CART_TOTAL_UNIT_COUNT_PREVIOUS, 0);
    }

    /**
     * Reset the cart
     */
    public static void resetCart() {
        resetCartTotalUnitCountPrevious();
        CommerceApplication.setIntToSharedPreferences(CART_TOTAL_UNIT_COUNT, 0);
    }

    /**
     * After authenticate task
     *
     * @param activity
     * @param login
     */
    public static void afterLogin(Activity activity, String requestId, String login) {
        // Save the email for next authenticate
        SessionHelper.saveLastLoggedEmail(login);

        // Save user logged in flag
        SessionHelper.setUserLoggedIn();

        // Updating the cart on session
        SessionHelper.updateCart(activity, requestId, false);
    }

    /**
     * Update the cart from the content service helper and update the cart fragment
     *
     * @param activity      The activity that calls the method
     * @param requestId     Identifier for the call
     * @param updateSummary Flag if we want to populate the cart summary if the cart fragment is present
     */
    public static void updateCart(final Activity activity, String requestId, final boolean updateSummary) {

        if (CommerceApplication.isOnline()) {
            CommerceApplication.getContentServiceHelper().getCart(new ResponseReceiver<Cart>() {
                @Override
                public void onResponse(Response<Cart> response) {

                    // Update the cart items
                    updateCartItemCount(response.getData().getTotalUnitCount(), activity);
                    activity.invalidateOptionsMenu();

                    // Updating the cart fragment
                    Fragment cartFragment = activity.getFragmentManager().findFragmentById(R.id.cart_fragment);

                    if (cartFragment != null && cartFragment instanceof CartFragment) {
                        if (updateSummary) {
                            ((CartFragment) cartFragment).populateCartSummary(response.getData());
                        }

                        ((CartFragment) cartFragment).populateCartContent(response.getData());
                    }
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    UIUtils.showError(response, activity);

                    // Reset the cart items to 0
                    updateCartItemCount(0, activity);
                }
            }, requestId, null, false, null, new OnRequestListener() {

                @Override
                public void beforeRequest() {
                    UIUtils.showLoadingActionBar(activity, true);
                }

                @Override
                public void afterRequestBeforeResponse() {

                }

                @Override
                public void afterRequest(boolean isDataSynced) {
                    UIUtils.showLoadingActionBar(activity, false);

                    // Resume the menu
                    activity.invalidateOptionsMenu();
                }
            });
        }

    }

    /**
     * Update the number of items in the shared settings, and update the cart icon accordingly
     *
     * @param nbItems
     * @param activity
     */
    public static void updateCartItemCount(int nbItems, Activity activity) {
        if (getCartTotalUnitCount() != nbItems) {
            CommerceApplication.setIntToSharedPreferences(CART_TOTAL_UNIT_COUNT_PREVIOUS, getCartTotalUnitCount());
            CommerceApplication.setIntToSharedPreferences(CART_TOTAL_UNIT_COUNT, nbItems);

            if (activity != null) {
                activity.invalidateOptionsMenu();
            }
        }
    }

    /**
     * Get the view type saved for the catalog content page
     *
     * @return
     */
    public static int getCatalogContentViewType() {
        return CommerceApplication.getIntFromSharedPreferences(CATALOG_PRODUCT_ITEM_VIEW_TYPE, 0);
    }

    /**
     * Save the view type for the catalog content page
     *
     * @return
     */
    public static void setCatalogContentViewType(int index) {
        CommerceApplication.setIntToSharedPreferences(CATALOG_PRODUCT_ITEM_VIEW_TYPE, index);
    }
}
