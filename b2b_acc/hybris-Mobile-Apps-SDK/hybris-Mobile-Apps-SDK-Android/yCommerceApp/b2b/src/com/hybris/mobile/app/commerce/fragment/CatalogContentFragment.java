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
package com.hybris.mobile.app.commerce.fragment;

import android.util.Log;

import com.hybris.mobile.app.commerce.CommerceApplication;
import com.hybris.mobile.lib.b2b.data.product.Product;
import com.hybris.mobile.lib.commerce.data.error.ErrorList;
import com.hybris.mobile.lib.commerce.query.QueryProducts;
import com.hybris.mobile.lib.commerce.response.ResponseReceiver;
import com.hybris.mobile.lib.http.converter.exception.DataConverterException;
import com.hybris.mobile.lib.http.listener.OnRequestListener;
import com.hybris.mobile.lib.http.response.Response;

import java.util.ArrayList;
import java.util.List;


/**
 * Fragment to display the list of product
 */
public class CatalogContentFragment extends CatalogContentFragmentBase implements ResponseReceiver<com.hybris.mobile.lib.b2b.data.search.facetdata.ProductSearchPage> {

    @Override
    public void onResponse(Response<com.hybris.mobile.lib.b2b.data.search.facetdata.ProductSearchPage> response) {

        List<ProductSimple> productSimpleList = new ArrayList<>();

        if (response.getData() != null &&
                response.getData().getProducts() != null) {
            for (Product product : response.getData().getProducts()) {
                try {
                    productSimpleList.add(new ProductSimple(product.getCode(), CommerceApplication.getContentServiceHelper().getDataConverter()
                            .convertTo(product)));
                } catch (DataConverterException e) {
                    Log.e(TAG, "Error converting the product " + product.getCode() + ". Details: " + e.getLocalizedMessage());
                }
            }
        }

        onResponseSearch(response.getRequestId(), productSimpleList, response.getData().getSpellingSuggestion(), response.getData().getPagination());
    }

    protected void updateProductListFromSearchAbstract(String requestId, QueryProducts queryProducts, boolean shouldUseCache, OnRequestListener onRequestListener) {
        CommerceApplication.getContentServiceHelper().getProducts(this, requestId, queryProducts, shouldUseCache, null, onRequestListener);
    }

    @Override
    public void onError(Response<ErrorList> response) {
        onErrorSearch(response);
    }
}
