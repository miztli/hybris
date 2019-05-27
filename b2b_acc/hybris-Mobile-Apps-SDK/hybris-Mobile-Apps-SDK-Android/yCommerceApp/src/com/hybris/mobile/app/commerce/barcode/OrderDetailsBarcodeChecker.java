/**
 * ****************************************************************************
 * [y] hybris Platform
 * <p/>
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * ****************************************************************************
 */
package com.hybris.mobile.app.commerce.barcode;

import android.app.Activity;
import android.content.Intent;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.R;
import com.hybris.mobile.app.commerce.activity.OrderDetailActivity;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.Order;
import com.hybris.mobile.lib.commerce.query.QueryOrder;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.scanner.callback.AfterScanCallback;
import com.hybris.mobile.lib.scanner.checker.BarcodeChecker;

public class OrderDetailsBarcodeChecker implements BarcodeChecker {

    private String mOrderCode;

    public OrderDetailsBarcodeChecker(String orderCode) {
        this.mOrderCode = orderCode;
    }

    @Override
    public void doAfterScan(final AfterScanCallback afterScanCallback) {
        QueryOrder queryOrder = new QueryOrder();
        queryOrder.setCode(mOrderCode);

        CommerceApplication.getContentServiceHelper().getOrder(new ResponseReceiver<Order>() {
            @Override
            public void onResponse(Response<Order> response) {
                afterScanCallback.onSuccess();
            }

            @Override
            public void onError(Response<ErrorList> response) {
                afterScanCallback.onError(R.string.error_barcode_no_order_found, mOrderCode);
            }
        }, null, queryOrder, null, false, null, null);
    }

    @Override
    public Intent getIntent(Activity activity) {
        Intent intent = new Intent(activity, OrderDetailActivity.class);
        intent.putExtra(IntentConstants.ORDER_CODE, mOrderCode);
        return intent;
    }

}
