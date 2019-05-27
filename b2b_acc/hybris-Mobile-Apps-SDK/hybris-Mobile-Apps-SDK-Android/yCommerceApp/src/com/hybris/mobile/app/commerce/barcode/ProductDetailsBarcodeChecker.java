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
import com.hybris.mobile.app.commerce.activity.ProductDetailActivity;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.data.product.Product;
import com.hybris.mobile.lib.commerce.query.QueryProduct;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.response.Response;
import com.hybris.mobile.lib.scanner.callback.AfterScanCallback;
import com.hybris.mobile.lib.scanner.checker.BarcodeChecker;


public class ProductDetailsBarcodeChecker implements BarcodeChecker {

    private String mProductCode;

    public ProductDetailsBarcodeChecker(String productCode) {
        this.mProductCode = productCode;
    }

    @Override
    public Intent getIntent(Activity activity) {
        Intent intent = new Intent(activity, ProductDetailActivity.class);
        intent.putExtra(IntentConstants.PRODUCT_CODE, mProductCode);
        return intent;
    }

    @Override
    public void doAfterScan(final AfterScanCallback afterScanCallback) {

        QueryProduct queryProduct = new QueryProduct();
        queryProduct.setCode(mProductCode);

        CommerceApplication.getContentServiceHelper().getProduct(new ResponseReceiver<Product>() {
            @Override
            public void onResponse(Response<Product> response) {
                afterScanCallback.onSuccess();
            }

            @Override
            public void onError(Response<ErrorList> response) {
                afterScanCallback.onError(R.string.error_barcode_no_product_found, mProductCode);
            }
        }, null, queryProduct, false, null, null);
    }

}
