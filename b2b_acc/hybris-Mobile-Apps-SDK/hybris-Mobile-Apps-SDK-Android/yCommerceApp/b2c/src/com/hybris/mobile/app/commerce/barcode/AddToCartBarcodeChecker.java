package com.hybris.mobile.app.commerce.barcode;

import android.app.Activity;
import android.content.Intent;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.app.commerce.IntentConstants;
import com.hybris.mobile.app.commerce.activity.ProductDetailActivity;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.order.CartModification;
import com.hybris.mobile.lib.commerce.query.QueryCartAddEntry;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.scanner.callback.AfterScanCallback;
import com.hybris.mobile.lib.scanner.checker.BarcodeChecker;

public class AddToCartBarcodeChecker implements BarcodeChecker {

    private String mProductCode;
    private int mQuantity;

    public AddToCartBarcodeChecker(String productCode, int quantity) {
        this.mProductCode = productCode;
        this.mQuantity = quantity;
    }

    @Override
    public void doAfterScan(final AfterScanCallback afterScanCallback) {

        QueryCartAddEntry queryCartAddEntry = new QueryCartAddEntry();
        queryCartAddEntry.setCode(mProductCode);
        queryCartAddEntry.setQty(mQuantity);

        CommerceApplication.getContentServiceHelper().addCartEntry(new ResponseReceiver<CartModification>() {
            @Override
            public void onResponse(Response<CartModification> response) {
                afterScanCallback.onSuccess();
            }

            @Override
            public void onError(Response<ErrorList> response) {
                afterScanCallback.onError(ErrorUtils.getFirstErrorMessage(response.getData()));
            }
        }, null, queryCartAddEntry, null, false, null, null);

    }

    @Override
    public Intent getIntent(Activity activity) {
        Intent intent = new Intent(activity, ProductDetailActivity.class);
        intent.putExtra(IntentConstants.PRODUCT_CODE, mProductCode);
        return intent;
    }
}
