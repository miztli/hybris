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

package com.hybris.mobile.lib.b2b.sync;

import android.content.Context;
import android.util.Log;

import com.hybris.mobile.lib.b2b.data.product.Product;
import com.hybris.mobile.lib.b2b.data.search.facetdata.ProductSearchPage;
import com.hybris.mobile.lib.b2b.service.B2BContentServiceHelper;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.query.QueryProducts;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.commerce.sync.CatalogSyncAdapter;
import com.hybris.mobile.lib.commerce.sync.DataSync;
import com.hybris.mobile.lib.commerce.utils.ErrorUtils;
import com.hybris.mobile.lib.http.converter.exception.DataConverterException;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;

import java.util.ArrayList;
import java.util.List;


/**
 * Sync adapter for the catalog
 */
public class B2BCatalogSyncAdapter extends CatalogSyncAdapter {

    private static final String TAG = B2BCatalogSyncAdapter.class.getCanonicalName();

    public B2BCatalogSyncAdapter(Context context, boolean autoInitialize, B2BContentServiceHelper contentServiceHelper) {
        super(context, autoInitialize, contentServiceHelper);
    }

    @Override
    public void getProducts(QueryProducts queryProducts, boolean shouldUseCache, OnRequestListener onRequestListener, final Callback callback) {

        getContentServiceHelper().getProducts(new ResponseReceiver<ProductSearchPage>() {
            @Override
            public void onResponse(Response<ProductSearchPage> response) {
                List<DataSync> products = new ArrayList<>();

                if (response.getData() != null && response.getData().getProducts() != null) {
                    for (Product product : response.getData().getProducts()) {
                        try {
                            products.add(new DataSync(product.getCode(), getContentServiceHelper().getDataConverter().convertTo(product)));
                        } catch (DataConverterException e) {
                            Log.e(TAG, "Error converting the product to a data String. Error: " + e.getLocalizedMessage());
                        }
                    }
                }

                callback.onProductsLoadedSuccess(products, response.getData().getPagination().getTotalResults());
            }

            @Override
            public void onError(Response<ErrorList> response) {
                Log.e(TAG, ErrorUtils.getFirstErrorMessage(response.getData()));
                callback.onProductsLoadedError();
            }
        }, null, queryProducts, false, null, onRequestListener);

    }

    private B2BContentServiceHelper getContentServiceHelper() {
        return (B2BContentServiceHelper) mContentServiceHelper;
    }
}
