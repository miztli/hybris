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
package com.hybris.mobile.app.commerce.helper;

import android.view.View;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.lib.b2b.query.QueryCartAddEntry;
import com.hybris.mobile.lib.b2b.query.QueryCartUpdateEntry;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;

import java.util.List;


/**
 * Helper for carts
 */
public class CartHelper {

    protected static void updateProductForCart(final String requestId, final int entryNumber, final int quantity,
                                               final List<View> viewsToDisable, final OnRequestListener onRequestListener, final ResponseReceiver<CartModification> responseReceiver) {

        QueryCartUpdateEntry queryCartUpdateEntry = new QueryCartUpdateEntry();
        queryCartUpdateEntry.setQuantity(quantity);
        queryCartUpdateEntry.setEntryNumber(entryNumber + "");

        CommerceApplication.getContentServiceHelper().replaceCartEntry(new ResponseReceiver<CartModification>() {
            @Override
            public void onResponse(Response<CartModification> response) {
                responseReceiver.onResponse(response);
            }

            @Override
            public void onError(Response<ErrorList> response) {
                responseReceiver.onError(response);
            }
        }, requestId, queryCartUpdateEntry, null, false, viewsToDisable, onRequestListener);

    }

    protected static void addProductForCart(final String requestId, final String productCode, final int quantity,
                                            final List<View> viewsToDisable, final OnRequestListener onRequestListener, final ResponseReceiver<CartModification> responseReceiver) {

        QueryCartAddEntry queryCartAddEntry = new QueryCartAddEntry();
        queryCartAddEntry.setProduct(productCode);
        queryCartAddEntry.setQuantity(quantity);

        CommerceApplication.getContentServiceHelper().addCartEntry(new ResponseReceiver<CartModification>() {

            @Override
            public void onResponse(Response<CartModification> response) {
                responseReceiver.onResponse(response);
            }

            @Override
            public void onError(Response<ErrorList> response) {
                responseReceiver.onError(response);
            }
        }, requestId, queryCartAddEntry, null, false, viewsToDisable, onRequestListener);
    }
}
