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
import android.view.View;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.listener.CartMergeListener;
import com.hybris.mobile.app.commerce.utils.UIUtils;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Cart;
import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.query.QueryCartCreate;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.ui.view.Alert;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Helper for carts
 */
public class CartHelperBase extends CartHelper {

    /**
     * Update an item to the cart
     *
     * @param activity          The activity that calls the method
     * @param requestId         Identifier for the call
     * @param onAddToCart       Listener for success/error after update
     * @param entryNumber       The entry number to update on the cart
     * @param quantity          The new quantity for the entry number
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Request listener for before/after call actions
     */
    public static void updateCart(Activity activity, String requestId, OnAddToCart onAddToCart, int entryNumber, int quantity,
                                  List<View> viewsToDisable, OnRequestListener onRequestListener) {
        addOrUpdateToCart(activity, requestId, onAddToCart, true, null, entryNumber, quantity, viewsToDisable, onRequestListener);
    }

    /**
     * Add an item to the cart
     *
     * @param activity          The activity that calls the method
     * @param requestId         Identifier for the call
     * @param onAddToCart       Listener for success/error after update
     * @param productCode       The code of the product to add
     * @param quantity          The quantity to add
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Request listener for before/after call actions
     */
    public static void addToCart(Activity activity, String requestId, OnAddToCart onAddToCart, String productCode, int quantity,
                                 List<View> viewsToDisable, OnRequestListener onRequestListener) {
        addOrUpdateToCart(activity, requestId, onAddToCart, false, productCode, 0, quantity, viewsToDisable, onRequestListener);
    }

    /**
     * Add/Update an item to the cart.
     *
     * @param activity          The activity that calls the method
     * @param requestId         Identifier for the call
     * @param onAddToCart       Listener for success/error after update
     * @param isUpdate          Flag for update
     * @param productCode       The code of the product to add
     * @param entryNumber       The entry number to update on the cart
     * @param quantity          The quantity to add
     * @param viewsToDisable    Views to disable/enable before/after the request
     * @param onRequestListener Request listener for before/after call actions
     */
    private static void addOrUpdateToCart(final Activity activity, final String requestId, final OnAddToCart onAddToCart,
                                          final boolean isUpdate, final String productCode, final int entryNumber, final int quantity,
                                          final List<View> viewsToDisable, final OnRequestListener onRequestListener) {

        if (quantity > 0) {
            UIUtils.showLoadingActionBar(activity, true);

            // Update
            if (isUpdate) {

                updateProductForCart(requestId, entryNumber, quantity, viewsToDisable, onRequestListener, new ResponseReceiver<CartModification>() {
                    @Override
                    public void onResponse(Response<CartModification> response) {
                        onReceiveAddToCartResponse(activity, requestId, onAddToCart, response);
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        UIUtils.showLoadingActionBar(activity, false);

                        UIUtils.showError(response, activity);

                        // Update the cart
                        SessionHelper.updateCart(activity, requestId, false);
                    }
                });

            }
            // Add
            else {

                addProductForCart(requestId, productCode, quantity, viewsToDisable, onRequestListener, new ResponseReceiver<CartModification>() {
                    @Override
                    public void onResponse(Response<CartModification> response) {
                        onReceiveAddToCartResponse(activity, requestId, onAddToCart, response);
                    }

                    @Override
                    public void onError(Response<ErrorList> response) {
                        UIUtils.showLoadingActionBar(activity, false);

                        UIUtils.showError(response, activity);

                        // Update the cart
                        SessionHelper.updateCart(activity, requestId, false);
                    }
                });

            }

        }
    }

    /**
     * Called after adding/updating an item to the cart
     *
     * @param activity    The activity that calls the method
     * @param requestId   Identifier for the call
     * @param onAddToCart Listener for success/error after update
     * @param response    Response data
     */
    private static void onReceiveAddToCartResponse(Activity activity, final String requestId, OnAddToCart onAddToCart,
                                                   Response<CartModification> response) {
        UIUtils.showLoadingActionBar(activity, false);

        // Out of stock, we print an error
        if (response.getData().isOutOfStock()) {
            if (StringUtils.isNotBlank(response.getData().getStatusMessage())) {
                Alert.showError(activity, response.getData().getStatusMessage());
            }

            if (onAddToCart != null) {
                onAddToCart.onAddToCartError(true);
            }
        }
        // Quantity not fulfilled, we print a warning
        else if (response.getData().isQuantityAddedNotFulfilled()) {
            if (StringUtils.isNotBlank(response.getData().getStatusMessage())) {
                Alert.showWarning(activity, response.getData().getStatusMessage());
            }

            if (onAddToCart != null) {
                onAddToCart.onAddToCartError(false);
            }
        }
        // Otherwise success message
        else {
            Alert.showSuccess(activity, activity.getString(R.string.cart_update_item_confirm_message));
        }

        if (onAddToCart != null) {
            onAddToCart.onAddToCart(response.getData());
        }

        // Update the cart
        SessionHelper.updateCart(activity, requestId, false);

    }

    public interface OnAddToCart {
        void onAddToCart(CartModification productAdded);

        void onAddToCartError(boolean isOutOfStock);
    }

    /**
     * Merge a cart with the current user cart
     *
     * @param cartToMerge
     * @param requestId
     * @param cartMergeCallback
     * @param viewsToDisable
     * @param onRequestListener
     */
    public static void mergeCartWithUserCart(final Cart cartToMerge, final String requestId, final CartMergeListener cartMergeCallback, final List<View> viewsToDisable, final OnRequestListener onRequestListener) {
        // We had a guest cart before authenticate
        if (cartToMerge != null) {

            // We get the current user cart
            CommerceApplication.getContentServiceHelper().getCart(new ResponseReceiver<Cart>() {
                @Override
                public void onResponse(Response<Cart> response) {

                    // We merge the guest cart with the user default cart
                    mergeCarts(cartToMerge.getGuid(), response.getData().getGuid(), requestId, cartMergeCallback, viewsToDisable, onRequestListener);
                }

                @Override
                public void onError(Response<ErrorList> response) {
                    cartMergeCallback.onError(response);
                }
            }, requestId, null, false, viewsToDisable, null);

        }

    }

    /**
     * Merge two carts
     *
     * @param oldCartGuid
     * @param newCartGuid
     * @param viewsToDisable
     * @param onRequestListener
     */
    private static void mergeCarts(String oldCartGuid, String newCartGuid, String requestId, final CartMergeListener cartMergeCallback, List<View> viewsToDisable, OnRequestListener onRequestListener) {
        QueryCartCreate queryCartCreate = new QueryCartCreate();
        queryCartCreate.setOldCartId(oldCartGuid);
        queryCartCreate.setToMergeCartGuid(newCartGuid);

        CommerceApplication.getContentServiceHelper().createCart(new ResponseReceiver<Cart>() {
            @Override
            public void onResponse(Response<Cart> response) {
                cartMergeCallback.onSuccess(response.getData());
            }

            @Override
            public void onError(Response<ErrorList> response) {
                cartMergeCallback.onError(response);
            }
        }, requestId, queryCartCreate, null, false, viewsToDisable, onRequestListener);
    }

}
